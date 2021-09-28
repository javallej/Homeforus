/*
  File: ImageListObject.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Getter/Setter for list of images.
*/

package main.java.homeforus.core;

/**
Class:  ImageListObject  

Description: Getter/Setter for list of images.
*/

public class ImageListObject {

    private int house_id;
    private String file_path;
    private String image_name;
    
    /**
    Method: setHouseID
    Inputs: int House_id
    Returns: void

    Description: Sets the House_ID.
  */
    
    public void setHouseID(int House_id) {
        this.house_id = House_id;
    }

    /**
    Method: getHouseID
    Inputs: void
    Returns: int

    Description: Gets the House_ID.
  */
    public int getHouseID() {
        return this.house_id;
    }
    
    /**
    Method: setFilePath
    Inputs: String File_path
    Returns: void

    Description: Sets the File_Path.
  */
    public void setFilePath(String File_path) {
        this.file_path = File_path;
    }

    /**
    Method: getFilePath
    Inputs: void
    Returns: String

    Description: Gets the File_Path.
  */
    public String getFilePath() {
        return this.file_path;
    }
    
    /**
    Method: setImageName
    Inputs: String Image_name
    Returns: void

    Description: Sets the Image_Name.
  */
    public void setImageName(String Image_name) {
        this.image_name = Image_name;
    }

    /**
    Method: getImageName
    Inputs: void
    Returns: Strings

    Description: Gets the Image_Name.
  */
    public String getImageName() {
        return this.image_name;
    }
}
