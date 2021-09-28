package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends JFrame {

    TopHeader caller;
    JTextField username;
    JTextField password;

    public SignInWindow(TopHeader topHeader) {
        caller = topHeader;
        setPreferredSize(new Dimension(500,500));
        add(buildSignIn());
        setTitle("Sign In");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public JPanel buildSignIn() {
        JPanel windowContainer = new JPanel();
        windowContainer.setPreferredSize(new Dimension(500,500));
        windowContainer.setLayout(new BoxLayout(windowContainer, BoxLayout.PAGE_AXIS));
        windowContainer.add(buildInputGrid());
        JButton signInSubmit = new JButton("Sign In");
        signInSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(username.getText() + " and " + password.getText());
                changeHeaderState(username.getText());
                username.setText("");
                password.setText("");
                caller.hideSignIn();
            }
        });
        JPanel btnHolder = new JPanel();
        btnHolder.add(signInSubmit);
        windowContainer.add(btnHolder);

        return windowContainer;
    }

    public void changeHeaderState(String user) {
        if (user.compareTo("consumer") == 0) {
            caller.LoggedInConsumer(true);
        } else if (user.compareTo("realtor") == 0) {
            caller.LoggedInRealtor(true);
        }
    }

    public JPanel buildInputGrid() {
        JPanel textBoxHolder = new JPanel();
        textBoxHolder.setMaximumSize(new Dimension(400,150));
        textBoxHolder.setLayout(new GridLayout(2,1));
        InputField userNameInput = new InputField("username");
        textBoxHolder.add(userNameInput);
        username = userNameInput.getTextField();
        InputField passwordInput = new InputField("password");
        textBoxHolder.add(passwordInput);
        password = passwordInput.getTextField();

        return textBoxHolder;
    }
}
