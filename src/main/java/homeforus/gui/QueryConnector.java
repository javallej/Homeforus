package main.java.homeforus.gui;

import main.java.homeforus.core.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryConnector {

    private BaseWindow window;
    private CurrentlyLoggedInUser currentlyLoggedInUser;
    private UserAdd userAddDB;
    private ConsumerAdd consumerAddDB;
    private RealtorAdd realtorAddDB;
    private HouseAdd houseAddDB;
    private ApplicationAdd applicationAddDB;
    private ApplicationList applicationListDB;
    private HouseList houseListDB;

    public QueryConnector(BaseWindow window) {
        this.window = window;
        userAddDB = new UserAdd();
        consumerAddDB = new ConsumerAdd();
        realtorAddDB = new RealtorAdd();
        houseAddDB = new HouseAdd();
        applicationAddDB = new ApplicationAdd();
        applicationListDB = new ApplicationList();
        houseListDB = new HouseList();
    }

    public void addApplicationToDB(int houseID) {
        // Get CurrentlyLoggedInUser object from this class
        // Pull their userID
        // Pull the Realtor's userID and Realtor's username via the houseID that was passed in
        // Pass these parameters to ApplicationAdd:
//        applicationAddDB.add( parameters here );
        // Print a confirmation to console that it posted successfully.
        // Maybe query the database to confirm and print it out? You don't have to though, if you want to just check
        // it in Workbench~
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

    public ArrayList<HouseContentPanel> getRealtorHouses(int userID) {
        ArrayList<HouseContentPanel> houseList = null;

        // This is going to be almost the same as getSearchList() method, but instead, a userID will be passed in,
        // and a query (that hasn't been written yet in HouseList.java) will be called to return all
        // houses that a Realtor with the given user ID has listed
        // eg.
//        ArrayList<HouseListObject> searchResultObjects = (ArrayList<HouseListObject>) houseListDB.SearchByRealtor( userID );

        // Call the re-usable method that was written for getSearchList
        // Then return the list

        return houseList;
    }

    public ArrayList<HouseContentPanel> getSearchList(SearchInput searchInput) throws SQLException, IOException {
        ArrayList<HouseContentPanel> houseList = null;

        // Get a list of houses from the database matching the searchInput queries that the user gave
        // I know the method in HouseList isn't written that does this yet but hopefully it can be written similarly to
        // HouseSearch.java?
        // eg.
//        ArrayList<HouseListObject> searchResultObjects = (ArrayList<HouseListObject>) houseListDB.SearchList( params from houseList object );

        // ******
        // Write this part in a separate method so we can use it to display Realtor's houses (getRealtorHouses) as well

        // in a loop, go through and convert all the HouseListObjects to HouseContentPanel objects
        // you have to create the HouseDetailPanel first, set the properties in there from each HouseListObject, then
        // pass it into the HouseContentPanel's constructor
//        for (HouseListObject h : searchResultObjects) {
//            HouseDetailPanel details = new HouseDetailPanel(h);
//            HouseContentPanel houseInfo = new HouseContentPanel(window, h.getImage()? [it's not written yet...] , details);
        // add to houseList
//            houseList.add(houseInfo);
//        }

        //*****
        List<HouseListObject> h = new ArrayList<>();
        
        HouseList house = new HouseList();
        h = house.ListAllSearchInput(searchInput);
        
        for(int i=0; i< h.size(); i++) {
            System.out.print("HouseID: ");
            System.out.println(h.get(i).getHouseID());

            System.out.print("RealtorID: ");
            System.out.println(h.get(i).getRealtorID());
            
            System.out.print("Realtor Username: ");
            System.out.println(h.get(i).getRealtorUsername());
            
            System.out.print("State: ");
            System.out.println(h.get(i).getState());
            
            System.out.print("City: ");
            System.out.println(h.get(i).getCity());
            
            System.out.print("Zip: ");
            System.out.println(h.get(i).getZip());
            
            System.out.print("Street: ");
            System.out.println(h.get(i).getStreet());
            
            System.out.print("House Number: ");
            System.out.println(h.get(i).getHouseNumber());
            
            System.out.print("Cost: ");
            System.out.println(h.get(i).getCost());
            
            System.out.print("Year: ");
            System.out.println(h.get(i).getYear());
            
            System.out.print("Number of Floors: ");
            System.out.println(h.get(i).getNumFloors());
            
            System.out.print("Number of Beds: ");
            System.out.println(h.get(i).getNumBed());
            
            System.out.print("Number of Baths: ");
            System.out.println(h.get(i).getNumBath());
            
            System.out.print("Square Feet: ");
            System.out.println(h.get(i).getSqrFeet());
            
            System.out.print("Days Listed: ");
            System.out.println(h.get(i).getDaysListed());
        }

        return houseList;
    }

    public void logInUser(String username, String password) {

        //See if username and password is valid in the DB

        //Create CurrentlyLoggedInUser class


    }

    public void createNewListing(HouseInput houseInput) {
        // Add a new house
//        houseAddDB.add( fields from houseInput here );

        // Print a confirmation to console that it posted successfully.
        // Maybe query the database to confirm and print it out? You don't have to though, if you want to just check
        // it in Workbench~
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
