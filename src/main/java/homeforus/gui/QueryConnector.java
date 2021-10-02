package main.java.homeforus.gui;

import main.java.homeforus.core.*;

import java.io.IOException;
import java.sql.SQLException;

public class QueryConnector {

    HouseList houseListDB;
    UserAdd userAddDB;
    ConsumerAdd consumerAddDB;
    RealtorAdd realtorAddDB;

    public QueryConnector() {
        houseListDB = new HouseList();
        userAddDB = new UserAdd();
        consumerAddDB = new ConsumerAdd();
        realtorAddDB = new RealtorAdd();
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


    public HouseList getHouseListDB() {
        return houseListDB;
    }

    public void setHouseListDB(HouseList houseListDB) {
        this.houseListDB = houseListDB;
    }

    public UserAdd getUserAddDB() {
        return userAddDB;
    }

    public void setUserAddDB(UserAdd userAddDB) {
        this.userAddDB = userAddDB;
    }

}
