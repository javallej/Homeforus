package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SignInWindow extends JFrame {

    BaseWindow window;
    TopHeader caller;
    InputField username;
    InputField password;

    public SignInWindow(TopHeader topHeader, BaseWindow window) {
        caller = topHeader;
        this.window = window;
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
                System.out.println(username.getTextField().getText() + " and " + password.getTextField().getText());
//                changeHeaderState(username.getTextField().getText());

                window.getQueryConnector().logInUser(username.getTextField().getText(), password.getTextField().getText());

                username.getTextField().setText("");
                password.getTextField().setText("");
                caller.hideSignIn();
            }
        });
        JPanel btnHolder = new JPanel();
        btnHolder.add(signInSubmit);
        windowContainer.add(btnHolder);

        JButton createAccount = new JButton("Create New Account");
        CreateAccountWindow createAccountWindow = new CreateAccountWindow(caller, window);
        windowContainer.add(createAccount);
        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caller.setCreateAccountWindow(createAccountWindow);
                createAccountWindow.setVisible(true);
                caller.hideSignIn();
            }
        });

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
        username = userNameInput;
        InputField passwordInput = new InputField("password");
        textBoxHolder.add(passwordInput);
        password = passwordInput;

        return textBoxHolder;
    }
}
