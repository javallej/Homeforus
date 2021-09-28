package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;

public class InputField extends JPanel {

    private JLabel label;
    private JTextField textField;

    // This creates an InputField that is styled to our UI design.
    public InputField(String labelText) {
        JPanel labelBox = new JPanel();
        labelBox.setLayout(new GridLayout());
        labelBox.setPreferredSize(new Dimension(150,20));
        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout());
        textBox.setPreferredSize(new Dimension(150,30));

        setPreferredSize(new Dimension(260, 60));
        setLayout(new GridLayout(2,1));
        textField = new JTextField();
        label = new JLabel(labelText);
        textBox.add(textField);
        labelBox.add(label);
        add(labelBox);
        add(textBox);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLabel() {
        return label;
    }
}
