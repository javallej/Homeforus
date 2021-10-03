package main.java.homeforus.gui;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

// blank button panel
// it still holds all the panels and buttons for every child class tho
public class ButtonArea extends JPanel {

    private BaseWindow window;
    private int width;
    private int height;
    private JPanel inner;
    private JButton btn1;
    private JButton btn2;

    public ButtonArea(BaseWindow window) {
        this.window = window;
        width = 150;
        height = 130;
        setPreferredSize(new Dimension(width, height));
        inner = new JPanel();
        inner.setPreferredSize(new Dimension(width - 10, height - 10));
        inner.setLayout(new BoxLayout(inner, BoxLayout.LINE_AXIS));
        add(inner);
        btn1 = new JButton("Button 1");
        btn2 = new JButton("Button 2");
        JPanel btnHolder = new JPanel();
        btnHolder.setPreferredSize(new Dimension(width - 50, height - 20));
        btnHolder.setLayout(new BoxLayout(btnHolder,BoxLayout.PAGE_AXIS));
        inner.add(Box.createHorizontalGlue());
        inner.add(btnHolder);
        inner.add(Box.createHorizontalGlue());

        btnHolder.add(Box.createVerticalGlue());
        btnHolder.add(btn1);
        btnHolder.add(Box.createVerticalGlue());
        btnHolder.add(btn2);
        btnHolder.add(Box.createVerticalGlue());

        btn1.setVisible(false);
        btn2.setVisible(false);
    }

    public JButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JPanel getInner() {
        return inner;
    }

    public void setInner(JPanel inner) {
        this.inner = inner;
    }
}
