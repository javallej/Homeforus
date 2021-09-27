package main.java.homeforus.core;

public class ImageListObject {

    private int house_id;
    private String file_path;
    private String image_name;
    
    public void setHouseID(int House_id) {
        this.house_id = House_id;
    }

    public int getHouseID() {
        return this.house_id;
    }
    
    public void setFilePath(String File_path) {
        this.file_path = File_path;
    }

    public String getFilePath() {
        return this.file_path;
    }
    
    public void setImageName(String Image_name) {
        this.image_name = Image_name;
    }

    public String getImageName() {
        return this.image_name;
    }
}
