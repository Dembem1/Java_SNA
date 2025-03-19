// Background color: 245, 235, 224
// Buttons color: 214, 204, 194
// Background for posts color: 227, 213, 202
// Font: Arial

// https://icons8.com/icons
// https://www.flaticon.com/


import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class Pages {
    public static void main(String[] args) {
        SingIn_Register.SingIn_Register();
    }
}

class SingIn_Register {
    static void SingIn_Register() {
        JFrame frame = new JFrame("Registration Page");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 235, 224));
        panel.setLayout(null);

        // Create username label and text field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(150, 200, 200, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 230, 200, 25);
        panel.add(userText);

        // Create password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 270, 200, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 300, 200, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(175, 350, 150, 30);
        loginButton.setBackground(new java.awt.Color(214, 204, 194));
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage.homepage();
            }
        });

        // Create register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(175, 375, 150, 30);
        registerButton.setBorderPainted(false); // Remove button border
        registerButton.setContentAreaFilled(false); // Make the button area transparent
        registerButton.setFocusPainted(false); // Remove focus highlight
        registerButton.setOpaque(false); // Ensure full transparency
        panel.add(registerButton);

        // Add action listener for the button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationInfo.registrationInfo();
            }
        });

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}

class RegistrationInfo {
    static void registrationInfo() {
        JFrame frame = new JFrame("Registration Page");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 235, 224));
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(150, 100, 200, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 130, 200, 25);
        panel.add(userText);

        // Create password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 170, 200, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 200, 25);
        panel.add(passwordField);

        JLabel workplaceLabel = new JLabel("Workplace:");
        workplaceLabel.setBounds(150, 240, 200, 25);
        panel.add(workplaceLabel);

        JTextField workplaceText = new JTextField();
        workplaceText.setBounds(150, 270, 200, 25);
        panel.add(workplaceText);

        JLabel hometownLabel = new JLabel("Hometown:");
        hometownLabel.setBounds(150, 310, 200, 25);
        panel.add(hometownLabel);

        JTextField hometownText = new JTextField();
        hometownText.setBounds(150, 340, 200, 25);
        panel.add(hometownText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(175, 400, 150, 30);
        registerButton.setBackground(new java.awt.Color(214, 204, 194));
        panel.add(registerButton);

        frame.add(panel);
    }    
}

class Homepage {
    static void homepage() {
        JFrame frame = new JFrame("Homepage");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 235, 224));
        panel.setLayout(null);

        ImageIcon homeIcon = new ImageIcon("home.png");
        Image scaled = homeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(scaled);

        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 50, 50, 50);
        panel.add(homeButton);

        frame.add(panel);
    }
}

class FindFriends {
    static void findFriends() {

    }
}

class Profile {
    static void profile() {

    }
}