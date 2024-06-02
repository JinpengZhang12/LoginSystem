import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

    // create Jframe
    JFrame frame = new JFrame();
    HashMap<String, String> logininfo = new HashMap<String, String>();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel passwordLabel = new JLabel("password: ");
    JLabel messagJLabel = new JLabel();

    LoginPage(HashMap<String, String> loginInfoOrginal) {
        logininfo = loginInfoOrginal;

        userIDLabel.setBounds(50, 100, 75, 25);
        passwordLabel.setBounds(50, 150, 75, 25);

        messagJLabel.setBounds(125, 250, 250, 35);
        messagJLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        // don't select the text inside of the button
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);

        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        // add to frame
        frame.add(userIDLabel);
        frame.add(passwordLabel);
        frame.add(messagJLabel);
        frame.add(passwordField);
        frame.add(userIDField);
        frame.add(loginButton);
        frame.add(resetButton);

        // set exit function
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the terminal
        frame.setSize(420, 420);
        // no layout manager
        frame.setLayout(null);
        // set frame is visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // function for login button
        // to get the id and password for verifying
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(passwordField.getPassword());
            // check if the text in hash map
            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(password)) {
                    messagJLabel.setForeground(Color.green);
                    messagJLabel.setText("Login successful");
                    // turn off the page
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                } else {
                    messagJLabel.setForeground(Color.red);
                    messagJLabel.setText("Wrong password");
                }
            } else {
                messagJLabel.setForeground(Color.red);
                messagJLabel.setText("Username not found");
            }
        }
        // function for reset button
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            passwordField.setText("");
        }
    }

}
