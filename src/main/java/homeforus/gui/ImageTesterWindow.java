package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.java.homeforus.core.ImageEdit;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageTesterWindow extends JFrame {

    public ImageTesterWindow() throws HeadlessException {
        int width = 600;
        int height = 600;
        setPreferredSize(new Dimension(width,height));
        pack();

        JPanel inner = new JPanel();
        inner.setPreferredSize(new Dimension(width - 20, height - 20));
        add(inner);

        JPanel imgHolder = new JPanel();
        imgHolder.setPreferredSize(new Dimension(width - 100, height - 100));
        inner.add(imgHolder);

        Image testerImg = null;

        try {
            ImageEdit editimage = new ImageEdit();
            editimage.getImage("test.jpg");
            //testerImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/houses/dbget.jpg")));
            testerImg = ImageIO.read(new File("/home/lazyuser/SER322/Project/src/main/resources/homeforus/houses/dbget.jpg"));
            imgHolder.add(new JLabel(new ImageIcon(testerImg)));
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }

}
