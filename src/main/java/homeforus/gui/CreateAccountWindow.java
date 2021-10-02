package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountWindow extends JFrame {

    TopHeader caller;
    JTextField username;
    JTextField password;
    JTextField firstName;
    JTextField lastName;
    JTextField email;
    JTextField phone;
    JTextField conDOB;
    JTextField conSSN;
    JTextField realtBN;
    NewUserInput newUserInput;

    public CreateAccountWindow(TopHeader topHeader) {
        this.caller = topHeader;
        setPreferredSize(new Dimension(500,500));
        add(buildCreateAccount());
        setTitle("Create New User Account");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildCreateAccount() {
        JPanel windowContainer = new JPanel();
        windowContainer.setPreferredSize(new Dimension(500,500));
        windowContainer.setLayout(new BoxLayout(windowContainer, BoxLayout.PAGE_AXIS));
        windowContainer.add(buildInputGrid());
        JButton signInSubmit = new JButton("Create Account");
        signInSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Parse Input
                String usernameS;
                String firstNameS;
                String lastNameS;
                String passwordS;
                String emailS;
                String phoneS;
                boolean isRealtor;
                String businessNameS;
                String DOBS;
                String SSNS;
                int ssn;

                usernameS = oNotNull(username.getText()).toString();
                usernameS = usernameS.trim();
                firstNameS = oNotNull(firstName.getText()).toString();
                firstNameS = firstNameS.trim();
                lastNameS = oNotNull(lastName.getText()).toString();
                lastNameS = lastNameS.trim();
                passwordS = oNotNull(password.getText()).toString();
                passwordS = passwordS.trim();
                emailS = oNotNull(email.getText()).toString();
                emailS = emailS.trim();
                phoneS = oNotNull(phone.getText()).toString();
                phoneS = phoneS.trim();

                // decide whether user is realtor or not here

                SSNS = oNotNull(conSSN.getText()).toString();
                SSNS = SSNS.trim();
                ssn = toNum(SSNS);
                DOBS = oNotNull(conDOB.getText()).toString();
                DOBS = DOBS.trim();
                businessNameS = oNotNull(realtBN.getText()).toString();
                businessNameS = businessNameS.trim();

                newUserInput = new NewUserInput(usernameS, firstNameS, lastNameS, passwordS, emailS,
                                                             phoneS, false, businessNameS, DOBS, ssn);


                // Add calls to Create Account here
            }
        });
        JPanel btnHolder = new JPanel();
        btnHolder.add(signInSubmit);
        windowContainer.add(btnHolder);

        return windowContainer;
    }

    public JPanel buildInputGrid() {
        JPanel textBoxHolder = new JPanel();
        textBoxHolder.setMaximumSize(new Dimension(400,150));
        textBoxHolder.setLayout(new GridLayout(5,2));

        InputField userNameInp = createInputField("Username");
        username = userNameInp.getTextField();
        InputField pwInp = createInputField("Password");
        password = pwInp.getTextField();
        InputField firstInput = createInputField("First Name");
        firstName = firstInput.getTextField();
        InputField lastInput = createInputField("Last Name");
        lastName = lastInput.getTextField();
        InputField emailInput = createInputField("Email");
        email = emailInput.getTextField();
        InputField phoneInput = createInputField("Phone");
        phone = phoneInput.getTextField();
        InputField dobInput = createInputField("Date of Birth (Consumer)");
        conDOB = dobInput.getTextField();
        InputField ssnInput = createInputField("SSN (Consumer)");
        conSSN = ssnInput.getTextField();
        InputField realtInput = createInputField("Business Name (Realtor)");
        realtBN = realtInput.getTextField();

        textBoxHolder.add(userNameInp);
        textBoxHolder.add(pwInp);
        textBoxHolder.add(firstInput);
        textBoxHolder.add(lastInput);
        textBoxHolder.add(emailInput);
        textBoxHolder.add(phoneInput);
        textBoxHolder.add(dobInput);
        textBoxHolder.add(ssnInput);
        textBoxHolder.add(realtInput);

        return textBoxHolder;
    }

    public Object oNotNull(Object o) {
        if (o != null) {
            return o;
        }
        return "";
    }

    public static int toNum(String n) {
        int num;
        try {
            num = Integer.parseInt(n);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return num;
    }

    public InputField createInputField(String label) {
        return new InputField(label);
    }

}
