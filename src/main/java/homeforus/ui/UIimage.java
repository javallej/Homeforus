package main.java.homeforus.ui;

import java.io.IOException;

import main.java.homeforus.core.ImageAdd;

public class UIimage {
    
    public void image() throws IOException {
        
        ImageAdd addimage = new ImageAdd();
        
        int id = 1;
        String path = "project";
        String name =  "test.jpg";
        
        addimage.addimage(id, path, name);
        
    }

}
