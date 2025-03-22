// Background color: 245, 235, 224
// Buttons color: 214, 204, 194
// Background for posts color: 227, 213, 202
// Font: Arial

// https://icons8.com/icons
// https://www.flaticon.com/

import java.awt.event.*;
import javax.swing.*;

public class Pages {
    public static void main(String[] args) {
        SingIn_Register.SingIn_Register();
    }
}
//###############################################################################
//######################## SING IN AND REGISTER PAGES ###########################
//###############################################################################
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
                String username = userText.getText();
                String password = new String(passwordField.getPassword());
                SocialNetwork socialNetwork = new SocialNetwork();
                if (socialNetwork.isUserExist(username, password)) {
                    Homepage.homepage();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
                frame.dispose();
            }
        });

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
//###############################################################################
//######################## REGISTRATION PAGE ####################################
//###############################################################################
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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());
                String workplace = workplaceText.getText();
                String hometown = hometownText.getText();

                SocialNetwork socialNetwork = new SocialNetwork();
                if (socialNetwork.isUsernameValid("social_network_data.txt", username)) {
                    if (socialNetwork.saveUserToFile("social_network_data.txt", 1, username, workplace, hometown, password)) {
                        Homepage.homepage();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to register", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(registerButton);

        frame.add(panel);
    }    
}
//###############################################################################
//######################## HOMEPAGE #############################################
//###############################################################################
class Homepage {
    static void homepage() {
        JFrame frame = new JFrame("Homepage");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 235, 224));
        panel.setLayout(null);

        ImageIcon homeIcon = new ImageIcon("Icons/home.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends.png");
        JButton findFriendsButton = new JButton(findFriendsIcon);
        findFriendsButton.setBounds(150, 700, 25, 25);
        findFriendsButton.setBorderPainted(false);
        findFriendsButton.setContentAreaFilled(false);
        findFriendsButton.setFocusPainted(false);
        findFriendsButton.setOpaque(false);
        findFriendsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindFriends.findFriends();
                frame.dispose();
            }
        });
        panel.add(findFriendsButton);

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost.png");
        JButton addPostButton = new JButton(addPostIcon);
        addPostButton.setBounds(250, 700, 25, 25);
        addPostButton.setBorderPainted(false);
        addPostButton.setContentAreaFilled(false);
        addPostButton.setFocusPainted(false);
        addPostButton.setOpaque(false);
        addPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPost.addPost();
                frame.dispose();
            }
        });
        panel.add(addPostButton);

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile.png");
        JButton userProfileButton = new JButton(userProfileIcon);
        userProfileButton.setBounds(350, 700, 25, 25);
        userProfileButton.setBorderPainted(false);
        userProfileButton.setContentAreaFilled(false);
        userProfileButton.setFocusPainted(false);
        userProfileButton.setOpaque(false);
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile.profile();
                frame.dispose();
            }
        });
        panel.add(userProfileButton);

        frame.add(panel);
    }
}
//###############################################################################
//######################## FIND FRIENDS #########################################
//###############################################################################
class FindFriends {
    static void findFriends() {
        JFrame frame = new JFrame("Find Friends");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(245, 235, 224));
        panel.setLayout(null);

        JTextField searchField = new JTextField("Search");
        searchField.setBounds(50, 50, 200, 25);
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search")) {
                    searchField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Search");
                    
                }
            }
        });
        panel.add(searchField);

        ImageIcon searchIcon = new ImageIcon("Icons/search.png");
        JButton searchButton = new JButton(searchIcon);
        searchButton.setBounds(250, 50, 25, 25);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);
        final String[] result = {""};
       searchButton.addActionListener(new ActionListener() {
    @Override
            public void actionPerformed(ActionEvent e) {
                SocialNetwork socialNetwork = new SocialNetwork();
                String userInfo = socialNetwork.searchUser("social_network_data.txt", searchField.getText());
        
                if (!userInfo.equals("User not found.")) {
                    JOptionPane.showMessageDialog(frame, userInfo, "User Found", JOptionPane.INFORMATION_MESSAGE);
                    user1.setText(userInfo); // Update JTextArea with user details
                } else {
                    JOptionPane.showMessageDialog(frame, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(searchButton);

        JPanel foundUsers = new JPanel();
        foundUsers.setBounds(50, 70, 400, 600);
        foundUsers.setBackground(new java.awt.Color(227, 113, 202));
        frame.add(foundUsers);

        JTextArea user1 = new JTextArea("User 1");
        user1.setBounds(50, 70, 400, 100);
        user1.setBackground(new java.awt.Color(227, 213, 202));
        user1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (result[0].equals("Found")) {
                    user1.setText("Found");
                } else {
                    user1.setText("Not found");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                user1.setBackground(new java.awt.Color(227, 213, 202));
            }
        });
        foundUsers.add(user1);

        ImageIcon homeIcon = new ImageIcon("Icons/home.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage.homepage();
                frame.dispose();
            }
        });
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends.png");
        JButton findFriendsButton = new JButton(findFriendsIcon);
        findFriendsButton.setBounds(150, 700, 25, 25);
        findFriendsButton.setBorderPainted(false);
        findFriendsButton.setContentAreaFilled(false);
        findFriendsButton.setFocusPainted(false);
        findFriendsButton.setOpaque(false);
        panel.add(findFriendsButton);

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost.png");
        JButton addPostButton = new JButton(addPostIcon);
        addPostButton.setBounds(250, 700, 25, 25);
        addPostButton.setBorderPainted(false);
        addPostButton.setContentAreaFilled(false);
        addPostButton.setFocusPainted(false);
        addPostButton.setOpaque(false);
        addPostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPost.addPost();
                frame.dispose();
            }
        });
        panel.add(addPostButton);

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile.png");
        JButton userProfileButton = new JButton(userProfileIcon);
        userProfileButton.setBounds(350, 700, 25, 25);
        userProfileButton.setBorderPainted(false);
        userProfileButton.setContentAreaFilled(false);
        userProfileButton.setFocusPainted(false);
        userProfileButton.setOpaque(false);
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile.profile();
                frame.dispose();
            }
        });
        panel.add(userProfileButton);
        frame.add(panel);
    }
}

class AddPost {
    static void addPost() {

    }
}

class Profile {
    static void profile() {

    }
}
