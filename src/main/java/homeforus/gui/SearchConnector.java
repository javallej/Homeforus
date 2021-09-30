package main.java.homeforus.gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.HouseList;
import main.java.homeforus.core.HouseListObject;

public class SearchConnector {

    public String connector(SearchInput searchInput) throws SQLException, IOException {

        HouseList house = new HouseList();
        List<HouseListObject> houselist = new ArrayList<>();
        houselist = house.ListPriceMax(searchInput.getPriceMax());
        String results = "";

        for (int i = 0; i < houselist.size(); i++) {
            results += " " + houselist.get(i).getHouseID();
            results += " " + houselist.get(i).getRealtorID();
            results += " " + houselist.get(i).getRealtorUsername();
            results += " " + houselist.get(i).getState();
            results += " " + houselist.get(i).getCity();
            results += " " + houselist.get(i).getZip();
            results += " " + houselist.get(i).getStreet();
            results += " " + houselist.get(i).getHouseNumber();
            results += " " + houselist.get(i).getCost();
            results += " " + houselist.get(i).getYear();
            results += " " + houselist.get(i).getNumFloors();
            results += " " + houselist.get(i).getNumBed();
            results += " " + houselist.get(i).getNumBath();
            results += " " + houselist.get(i).getSqrFeet();
            results += " " + houselist.get(i).getDaysListed();
            results += "\n";

        }
        return results;
    }

}
