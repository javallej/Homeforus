package main.java.homeforus.core;

import java.io.IOException;
import java.sql.SQLException;

public class PrepareDatabase {

    public void prepare(String filepath){
        
        HouseList listcount = new HouseList();
        
        String path = filepath;
        String imagename = ".jpg";
        int count = 1;
        ImageAdd addimage = new ImageAdd();{
            try {
                do { 
                for(int i=1; i< 11; i++) {
                    try {
                        addimage.addimage(count, filepath, i + imagename);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    count++;
                } 
                }while (count < listcount.getHouseCount());
            } catch (SQLException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            }}}
