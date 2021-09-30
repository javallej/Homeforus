package main.java.homeforus.connect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.HouseList;
import main.java.homeforus.core.HouseListObject;
import main.java.homeforus.gui.SearchBar;
import main.java.homeforus.gui.SearchInput;

public class SearchBarConnect {

    public void search() throws SQLException, IOException {

    int max;
    
    SearchInput search = new SearchInput();
    
    max = search.getPriceMax();
    
    HouseList house = new HouseList();
    
    List<HouseListObject> housecostmax = new ArrayList<>();

    housecostmax = house.ListPriceMax(max);
    
    System.out.println("Houses are: ");
    for(int i=0; i< housecostmax.size(); i++) {
       
       System.out.print("HouseID: ");
       System.out.println(housecostmax.get(i).getHouseID());
    
    }
    }

}