package main.java.homeforus.gui;

import main.java.homeforus.core.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;

public class QueryConnector {

    private BaseWindow window;
    private CurrentlyLoggedInUser currentlyLoggedInUser;
    private UserAdd userAddDB;
    private UserList userListDB;
    private ConsumerAdd consumerAddDB;
    private RealtorAdd realtorAddDB;
    private HouseAdd houseAddDB;
    private ApplicationAdd applicationAddDB;
    private ApplicationList applicationListDB;
    private HouseList houseListDB;
    private ImageList imageListDB;
    private ImageEdit imageEditDB;
    private HouseEdit houseEditDB;
    private HouseDelete houseDeleteDB;
    private ApplicationEdit applicationEditDB;

    public QueryConnector(BaseWindow window) {
        this.window = window;
        userAddDB = new UserAdd();
        userListDB = new UserList();
        consumerAddDB = new ConsumerAdd();
        realtorAddDB = new RealtorAdd();
        houseAddDB = new HouseAdd();
        applicationAddDB = new ApplicationAdd();
        applicationListDB = new ApplicationList();
        houseListDB = new HouseList();
        imageListDB = new ImageList();
        imageEditDB = new ImageEdit();
        houseEditDB = new HouseEdit();
        houseDeleteDB = new HouseDelete();
        applicationEditDB = new ApplicationEdit();

    }

    public void deleteHouse(int houseID) {
        // delete the house in the DB based on its houseID. ez pz.
        List<HouseListObject> house_exists = new ArrayList<>();
        try {
            house_exists = houseListDB.List(houseID);
            if(house_exists.size() == 1) {
                showMessageDialog(null,"DELETING!");
                houseDeleteDB.delete(houseID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateHouse(int houseID, HouseInput houseInput) {
        //showMessageDialog(null,"MADE IT INTO QUERY CONNECTOR UPDATE HOUSE");
        List<HouseListObject> house_exists = new ArrayList<>();
        try {
            house_exists = houseListDB.List(houseID);
            if(house_exists.size() == 1) {
                showMessageDialog(null,"UPDATING!");
                houseEditDB.editAll(houseID, houseInput.getState(), houseInput.getZip(), houseInput.getStreet(),
                        houseInput.getHouse_number(), houseInput.getCost(), houseInput.getYear(), houseInput.getNum_floors(),
                        houseInput.getNum_bed(), houseInput.getNum_bath(), houseInput.getSqr_feet(),houseInput.getCity());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getImgByHouseID(int houseID) throws SQLException, IOException {
        String imgName = "";

        try {
            if (imageListDB.List(houseID).size() == 0) {
                //showMessageDialog(null,"true for " + houseID);
            }

            imgName = imageListDB.List(houseID).get(0).getImageName();
        } catch (IndexOutOfBoundsException ex) {
            imgName = "Choose....";
        }

        return imgName;
    }

    public void denyApplication(int House_ID, int Consumer_ID, int Realtor_ID) {
        List<ApplicationListObject> application_exists = new ArrayList<>();

        try {
            application_exists = applicationListDB.List(House_ID, Consumer_ID, Realtor_ID);
            if(application_exists.size() == 1) {
                applicationEditDB.editStatus("Denied", House_ID, Consumer_ID, Realtor_ID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createNewListing(HouseInput houseInput) {
        // Add a new house
        try {
            houseAddDB.add( currentlyLoggedInUser.getUserID(), currentlyLoggedInUser.getUsername(), houseInput.getState(), houseInput.getCity(), houseInput.getZip(), houseInput.getStreet(), houseInput.getHouse_number(), houseInput.getCost(), houseInput.getYear(), houseInput.getNum_floors(), houseInput.getNum_bed(), houseInput.getNum_bath(), houseInput.getSqr_feet(), 0);
            showMessageDialog(null,"Listing Added Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void approveApplication(int House_ID, int Consumer_ID, int Realtor_ID) {
        List<ApplicationListObject> application_exists = new ArrayList<>();
        try {
            application_exists = applicationListDB.List(House_ID, Consumer_ID, Realtor_ID);
            if(application_exists.size() == 1) {
                applicationEditDB.editStatus("Approved", House_ID, Consumer_ID, Realtor_ID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean isImageTablePopulated() throws SQLException, IOException {
        return imageListDB.ListAll().size() > 1;
    }

    public ApplicationInfo getAppInfoFromAppListObj(ApplicationListObject appListObj) throws SQLException, IOException {
        ApplicationInfo appInfo = null;

        UserListObject user = userListDB.Listusername(appListObj.getConsumerID()).get(0);
        HouseListObject house = houseListDB.List(appListObj.getHouseID()).get(0);
        String address = house.getHouseNumber() + " " + house.getStreet() + ", " + house.getCity() + ", " + house.getState() + ", " + house.getZip();
        String image = "";
        try {
            image = imageListDB.List(appListObj.getHouseID()).get(0).getImageName();
        } catch (IndexOutOfBoundsException ex ){
            image = "";
        }
        appInfo = new ApplicationInfo(user.getFirstName(),user.getLastName(),appListObj.getStatus(), address, image, appListObj.getHouseID());
        return appInfo;
    }


    public void createNewApplication(int houseID, int realtorID, String realtorUser) throws SQLException, IOException {
        applicationAddDB.add(houseID, currentlyLoggedInUser.getUserID(), currentlyLoggedInUser.getUsername(), realtorID,realtorUser,"Submitted");
        // Print a confirmation to console that it posted successfully.
        showMessageDialog(null,"Application Submitted");
    }

    public ArrayList<ApplicationContentPanel> getAppContentPanels(boolean isRealtor, int userID) throws SQLException, IOException {
        ArrayList<ApplicationContentPanel> contentPanels = new ArrayList<>();
        List<ApplicationListObject> applications = null;

        if (isRealtor){
            applications = applicationListDB.ListByRealtorID(userID);
        }
        else{
            applications = applicationListDB.ListByConsumerID(userID);
        }

        for (ApplicationListObject a:applications) {

            ApplicationInfo app_info = getAppInfoFromAppListObj(a);
            ApplicationDetailPanel app_DetailPanel = new ApplicationDetailPanel(app_info);
            ApplicationContentPanel app_ContentPanel = new ApplicationContentPanel(window,app_DetailPanel,a,app_info);
            contentPanels.add(app_ContentPanel);
        }
        return contentPanels;
    }



    public ArrayList<HouseContentPanel> getRealtorHouses(int realtorUserID) throws SQLException, IOException {
        ArrayList<HouseContentPanel> houseList = null;
        List<HouseListObject> h;
        HouseList house = new HouseList();
        h = house.ListRealtorID(realtorUserID);
        houseList = convertHouseListToContentPanels(h);

        return houseList;
    }

    public ArrayList<HouseContentPanel> convertHouseListToContentPanels(List<HouseListObject> houses) throws SQLException, IOException {
        ArrayList<HouseContentPanel> houseContentPanels = new ArrayList<>();

        for (HouseListObject h : houses) {
            HouseDetailPanel details = new HouseDetailPanel(h);
            String imgS = "";
            if (imageListDB.List(h.getHouseID()).size() == 1) {
                imgS = imageListDB.List(h.getHouseID()).get(0).getImageName();
            }
            HouseContentPanel houseInfo = new HouseContentPanel(window, imgS, details);
            houseContentPanels.add(houseInfo);
        }
        return houseContentPanels;
    }

    public ArrayList<HouseContentPanel> getSearchList(SearchInput searchInput) throws SQLException, IOException {
        ArrayList<HouseContentPanel> houseList = null;

        List<HouseListObject> h = new ArrayList<>();

        HouseList house = new HouseList();
        h = house.ListAllSearchInput(searchInput);

        houseList = convertHouseListToContentPanels(h);

        return houseList;
    }

    public ArrayList<HouseContentPanel> getRandomHouses(int numOfHouses) throws SQLException, IOException {
        ArrayList<HouseContentPanel> houseList = null;

        List<HouseListObject> h = new ArrayList<>();
        List<HouseListObject> randomHouse = new ArrayList<>();

        HouseList house = new HouseList();
        Random rand = new Random();

        for (int i = 0; i < numOfHouses; i++) {
            randomHouse = house.List(rand.nextInt(80));
            while (randomHouse.size() == 0) {
                randomHouse = house.List(rand.nextInt(80));
            }
            h.add(randomHouse.get(0));
        }

        houseList = convertHouseListToContentPanels(h);

        return houseList;
    }


    public boolean verifyUsername(String username) throws IOException {
        PreparedStatement stmt = null;
        Connection conn = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement("Select User_Username From user Where User_Username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()){
                rs.close();
                conn.close();
                return false;
            }
            else{
                rs.close();
                conn.close();
                return true;
            }
        }

        catch (java.sql.SQLException exc){
            exc.printStackTrace();
        }
        return false;
    }

    public boolean logInUser(String username, String password) throws SQLException, IOException {
        // Establish DB connection and obtain user information for who is attempting log in
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));
        try {
            String query = "SELECT * FROM USER WHERE USER.User_Username = ?";
            stmt = connect.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            // Verify a user exists in the database with that name, otherwise move to else block
            if (rs.next()) {
                // If user exists, create UserListObject and update it with DB information
                UserListObject uObject = new UserListObject();
                uObject.setUserID(rs.getInt(1));
                uObject.setUserUsername(rs.getString(2));
                uObject.setFirstName(rs.getString(3));
                uObject.setLastName(rs.getString(4));
                uObject.setPhone(rs.getString(5));
                uObject.setEmail(rs.getString(6));
                uObject.setPassword(rs.getString(7));
                // Verify if user entered password matches user password stored in database
                if (uObject.getPassword().equals(password)) {
                    // If password matches, find out if user is a realtor
                    boolean isRealtor = true;
                    try {
                        query = "SELECT * FROM REALTOR WHERE REALTOR.Realtor_Username = ?";
                        stmt = connect.prepareStatement(query);
                        stmt.setString(1, uObject.getUsername());
                        rs = stmt.executeQuery();

                        if (rs.next()){
                            isRealtor = true;
                        }
                        else {
                            isRealtor = false;
                        }
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                            if (stmt != null) {
                                stmt.close();
                            }
                            if (connect != null) {
                                connect.close();
                            }
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                    }
                    // Finally, if we made it this far, update CurrentlyLoggedInUser object
                    CurrentlyLoggedInUser user = new CurrentlyLoggedInUser(uObject.getUsername(), uObject.getUserID(),
                            isRealtor);
                    currentlyLoggedInUser = user;
                }
                else {
                    // This block can be used by GUI for failed password condition
                    showMessageDialog(null,"Invalid password");
                    return false;
                }
            }
            else {
                // This block can be used by GUI for failed username condition
                showMessageDialog(null,"Invalid username");
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return true;
    }



    public void addUserToDB(NewUserInput newUserInput) throws IOException, SQLException {
        // Add a user
        userAddDB.add(newUserInput.getUsername(), newUserInput.getFirstName(), newUserInput.getLastName(), newUserInput.getPhone(),
                      newUserInput.getEmail(), newUserInput.getPassword());

        UserList userList = new UserList();
        UserListObject userListObject = userList.Listusername(newUserInput.getUsername()).get(0);
        int userID = userListObject.getUserID();

        // Add a consumer or realtor
        if (!newUserInput.isRealtor()) {
            showMessageDialog(null,newUserInput.getSSN());
            consumerAddDB.add(userID, newUserInput.getUsername(), newUserInput.getDOB(), newUserInput.getSSN());
        } else {
            realtorAddDB.add(userID, newUserInput.getUsername(), newUserInput.getBusinessName());
        }
        showMessageDialog(null,"Successfully added new User.");
        showMessageDialog(null,"Querying database: ");
        //showMessageDialog(null,"user ID: " + userList.Listusername(newUserInput.getUsername()).get(0).getUserID());
        //showMessageDialog(null,"user username: " + userList.Listusername(newUserInput.getUsername()).get(0).getUsername());
        if (!newUserInput.isRealtor()) {
            ConsumerList consumerList = new ConsumerList();
            ConsumerListObject c = consumerList.List(userID).get(0);
            //showMessageDialog(null,"User is Consumer.");
            //showMessageDialog(null,"consumer DOB: " + c.getDOB());
            //showMessageDialog(null,"consumer SSN: " + c.getSSN());
        } else {
            RealtorList realtorList = new RealtorList();
            RealtorListObject r = realtorList.List(userID).get(0);
            //showMessageDialog(null,"User is Realtor.");
            //showMessageDialog(null,"realtor business name: " + r.getRealtorBusinessName());
        }
    }

    public UserAdd getUserAddDB() {
        return userAddDB;
    }

    public void setUserAddDB(UserAdd userAddDB) {
        this.userAddDB = userAddDB;
    }

    public CurrentlyLoggedInUser getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }

    public void setCurrentlyLoggedInUser(CurrentlyLoggedInUser currentlyLoggedInUser) {
        this.currentlyLoggedInUser = currentlyLoggedInUser;
    }
}
