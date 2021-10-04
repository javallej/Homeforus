package main.java.homeforus.ui;

import java.io.IOException;

import main.java.homeforus.core.ImageAdd;
import main.java.homeforus.core.ImageEdit;

public class UIimage {
    
    public void image() throws IOException {
        
        ImageAdd addimage = new ImageAdd();
        ImageEdit editimage = new ImageEdit();
        
        int id = 1;
        String path = "project";
        String name =  "test.jpg";
        
        addimage.addimage(id, path, name);
        
        editimage.getImage("test.jpg", 1);
        
        
        
    }

}
