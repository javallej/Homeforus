package main.java.homeforus.core;

import java.io.IOException;
import java.sql.SQLException;

public class PrepareDatabase {

    public void prepare(String filepath) {
        
        HouseList listcount = new HouseList();
        try {
            System.out.println(listcount.getHouseCount());
        } catch (SQLException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(filepath);
        
        String path = filepath;
        String imagename = ".jpg";

        ImageAdd addimage = new ImageAdd();
        try {
            for(int i=1; i< 9; i++)
            {
                addimage.addimage(i, filepath, i + imagename);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
