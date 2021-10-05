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
                System.out.println("DELETING!");
                houseDeleteDB.delete(houseID);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateHouse(int houseID, HouseInput houseInput) {
        // update a house in the Database, given this passed-in houseInput object
        // see below to createNewListing to see what it should vaguely be structured like.
        // Could probably just update every single field of the House in the table, because the rest
        // of the properties of the houseInput object will be the same if they didn't change anything.

        System.out.println("MADE IT INTO QUERY CONNECTOR UPDATE HOUSE");
        List<HouseListObject> house_exists = new ArrayList<>();
        try {
            house_exists = houseListDB.List(houseID);
            if(house_exists.size() == 1) {
                System.out.println("UPDATING!");
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
            System.out.println("Listing Added Successfully");
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

    public ApplicationInfo getAppInfoFromAppListObj(ApplicationListObject appListObj) throws SQLException, IOException {
        ApplicationInfo appInfo = null;

        // This method needs to read the appListObj object and pull the rest of the information from the
        // database to complete the construction of a new ApplicationInfo object.
        // Currently, we need ApplicationInfo object to display the following information on the
        // GUI pertaining to the application:
        // firstName;
        // lastName;
        // status;
        // address;
        // However, the Application table in our schema only stores status, from these things.
        // But we can use the ApplicationListObject, which represents 1 row taken from the Application
        // table in the database, to fill in the remaining information to populate ApplicationInfo object.
        // Step 1: You'll need to pull the consumer ID from the ApplicationListObject and find
        // that Consumer's first and last names from the database, based on that user ID.
        UserListObject user = userListDB.Listusername(appListObj.getConsumerID()).get(0);

        // Step 2: You'll need to pull the house ID from the ApplicationListObject and find
        // that House's address from the database, based on that house ID. Make sure to
        // concatenate the entire address in the House row, because it's stored as
        // Housenumber, street, city, state, zip. Put all that information into the String field when
        // creating the ApplicationInfo object.
        HouseListObject house = houseListDB.List(appListObj.getHouseID()).get(0);
        String address = house.getHouseNumber() + house.getStreet() + ", " + house.getCity() + ", " + house.getState() + ", " + house.getZip();

        // Then just create the object:
        appInfo = new ApplicationInfo(user.getFirstName(),user.getLastName(),appListObj.getStatus(), address);
        // then return the object.
        return appInfo;
    }


    public void createNewApplication(int houseID, int realtorID, String realtorUser) throws SQLException, IOException {


        applicationAddDB.add(houseID, currentlyLoggedInUser.getUserID(), currentlyLoggedInUser.getUsername(), realtorID,realtorUser,"Submitted");

        // Print a confirmation to console that it posted successfully.
        System.out.println("Application Submitted");

    }

    public ArrayList<ApplicationInfo> getAppList() throws SQLException, IOException {
        ArrayList<ApplicationInfo> appList = null;

        // Get currently logged in user's applications using applicationListDB
        // method is yet to be written but it will be something like:
//        ArrayList<ApplicationListObject> appsForUser = (ArrayList<ApplicationListObject>) applicationListDB.List( currentlyLoggedInUser.getUserID() );

        // in a loop, go through and convert all the ApplicationListObjects to ApplicationInfo objects
//        for (ApplicationListObject app:appsForUser) {
//            ApplicationInfo appInfo = new ApplicationInfo( fill in the required parameters for ApplicationInfo class (see constructor) );
            // add to appList
//            appList.add(appInfo);
//        }

        return appList;
    }

    public List<ApplicationListObject> getAppListObjs() throws SQLException, IOException {
        return applicationListDB.ListByConsumerID(3);
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
                    System.out.println("Invalid password");
                    return false;
                }
            }
            else {
                // This block can be used by GUI for failed username condition
                System.out.println("Invalid username");
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
            System.out.println(newUserInput.getSSN());
            consumerAddDB.add(userID, newUserInput.getUsername(), newUserInput.getDOB(), newUserInput.getSSN());
        } else {
            realtorAddDB.add(userID, newUserInput.getUsername(), newUserInput.getBusinessName());
        }
        System.out.println("From QueryConnector: Successfully added new User.");
        System.out.println("Querying database: ");
        System.out.println("user ID: " + userList.Listusername(newUserInput.getUsername()).get(0).getUserID());
        System.out.println("user username: " + userList.Listusername(newUserInput.getUsername()).get(0).getUsername());
        if (!newUserInput.isRealtor()) {
            ConsumerList consumerList = new ConsumerList();
            ConsumerListObject c = consumerList.List(userID).get(0);
            System.out.println("User is Consumer.");
            System.out.println("consumer DOB: " + c.getDOB());
            System.out.println("consumer SSN: " + c.getSSN());
        } else {
            RealtorList realtorList = new RealtorList();
            RealtorListObject r = realtorList.List(userID).get(0);
            System.out.println("User is Realtor.");
            System.out.println("realtor business name: " + r.getRealtorBusinessName());
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
