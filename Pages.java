// Background color: 245, 235, 224
// Buttons color: 214, 204, 194
// Background for posts color: 227, 213, 202
// Font: Arial

// https://icons8.com/icons
// https://www.flaticon.com/

import java.awt.event.*;
import java.util.Set;

import javax.swing.*;
import java.awt.*;

public class Pages {
    // colors
    static final Color BACKGROUND_COLOR = new Color(0xDFDFDF);
    static final Color BUTTON_COLOR = new Color(0xD6CCC2);
    static final Color TEXT_COLOR = new Color(0x000000);

    // fonts
    static final Font HEADER_FONT = new Font("Montserrat", Font.BOLD, 24);
    static final Font BODY_FONT = new Font("Montserrat", Font.PLAIN, 16);

    // styled buttons
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BODY_FONT);
        button.setForeground(TEXT_COLOR);
        button.setBackground(new Color(0xADD8E6)); // light blue color
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0x87CEEB)); // darker light blue color
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0xADD8E6)); // light blue color
            }
        });
        return button;
}

    // styled text fields
    public static JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        textField.setFont(BODY_FONT);
        textField.setForeground(TEXT_COLOR);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            SingIn_Register.SingIn_Register();
        });
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
        panel.setBackground(new java.awt.Color(223, 223, 223));
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
        
        JButton loginButton = Pages.createStyledButton("Login");
        loginButton.setBounds(175, 350, 150, 30);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());
                SocialNetwork socialNetwork = new SocialNetwork();
                if (socialNetwork.isUserExist(username, password)) {
                    // add user to the social network
                    User user = socialNetwork.getUser("social_network_data.txt", username);
                    Homepage.homepage(user);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(175, 385, 150, 30);
        registerButton.setBorderPainted(false); 
        registerButton.setContentAreaFilled(false); 
        registerButton.setFocusPainted(false); 
        registerButton.setOpaque(false); 
        panel.add(registerButton);

        // Add action listener for the button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationInfo.registrationInfo();
                frame.dispose();
            }
        });

        // Label for the app name
        JLabel appNameLabel = new JLabel("Socialise YS");
        appNameLabel.setBounds(180, 680, 200, 50); 
        appNameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 26));
        appNameLabel.setForeground(new Color(32, 100, 114)); 
        panel.add(appNameLabel);
        frame.add(panel); 
        frame.setVisible(true);
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
        panel.setBackground(new java.awt.Color(223, 223, 223));
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
        panel.setBackground(new java.awt.Color(223, 223, 223));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());
                String workplace = workplaceText.getText();
                String hometown = hometownText.getText();

                SocialNetwork socialNetwork = new SocialNetwork();
                if (socialNetwork.isUsernameValid("social_network_data.txt", username)) {
                    if (socialNetwork.saveUserToFile("social_network_data.txt", username, workplace, hometown, password)) {
                        User user = Homepage.getLoggedInUser();
                        Homepage.homepage(user);
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
    private static User loggedInUser;

    static void homepage(User user) {
        loggedInUser = user;

        JFrame frame = new JFrame("Homepage");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(223, 223, 223));
        panel.setLayout(null);

        //first post and username
        JTextField userName = new JTextField();
        userName.setBounds(50, 50, 200, 30);
        userName.setBackground(new java.awt.Color(200, 200, 200));
        userName.setEditable(false);
        panel.add(userName);

        JTextField postContent = new JTextField();
        postContent.setBounds(50, 100, 400, 200);
        postContent.setBackground(new java.awt.Color(190, 190, 190));
        postContent.setEditable(false);
        panel.add(postContent);

        SocialNetwork socialNetwork = new SocialNetwork();
        String[] randomUserInfo = socialNetwork.getRandomUserPost("social_network_data.txt");

        if (randomUserInfo.length > 1) {
            userName.setText(randomUserInfo[0]);   // Set username
            postContent.setText(randomUserInfo[1]); // Set post content
        } else {
            userName.setText("No users found");
            postContent.setText("");
        }

        //second post and username

        JTextField userName2 = new JTextField();
        userName2.setBounds(50, 350, 200, 30);
        userName2.setBackground(new java.awt.Color(200, 200, 200));
        userName2.setEditable(false);
        panel.add(userName2);

        JLabel userIcon = new JLabel(new ImageIcon("Icons/user3.png"));
        userIcon.setBounds(20, 350, 30, 30);
        panel.add(userIcon);
        
        int iconY = userName2.getBounds().y + (userName2.getBounds().height - userIcon.getBounds().height) / 2;
        
        JTextField postContent2 = new JTextField();
        postContent2.setBounds(50, 400, 400, 200);
        postContent2.setBackground(new java.awt.Color(190, 190, 190));
        postContent2.setEditable(false);
        panel.add(postContent2);

        String[] randomUserInfo2 = socialNetwork.getRandomUserPost("social_network_data.txt");
        
        if (randomUserInfo2.length > 1) {
            userName2.setText(randomUserInfo2[0]);   // Set username
            postContent2.setText(randomUserInfo2[1]); // Set post content
        } else {
            userName2.setText("No users found");
            postContent2.setText("");
        }

        ImageIcon homeIcon = new ImageIcon("Icons/home3.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends3.png");
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

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost3.png");
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

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile3.png");
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

    public static User getLoggedInUser() {
        return loggedInUser; // Retrieve the user from any other page
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
        panel.setBackground(new java.awt.Color(223, 223, 223));
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

        JTextArea userArea = new JTextArea("");
        userArea.setBounds(50, 70, 100, 100);
        userArea.setBackground(new java.awt.Color(227, 213, 202));
        userArea.setEditable(false);
        panel.add(userArea);

        JTextArea userDetailArea = new JTextArea("");
        userDetailArea.setBounds(50, 170, 100, 100);
        userDetailArea.setBackground(new java.awt.Color(227, 213, 202));
        userDetailArea.setEditable(false);
        panel.add(userDetailArea);

        ImageIcon searchIcon = new ImageIcon("Icons/search3.png");
        JButton searchButton = new JButton(searchIcon);
        searchButton.setBounds(250, 50, 25, 25);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNetwork socialNetwork = new SocialNetwork();
                String searchUsername = searchField.getText();
                String[] userDetails = socialNetwork.searchUser("social_network_data.txt", searchUsername);
                if (!userDetails.equals("User not found")) {
                    userArea.setText(userDetails[1]);
                    userDetailArea.setText(
                        userDetails[0] + 
                        userDetails[2] + 
                        userDetails[3] + 
                        userDetails[4]
                    );
                    //JOptionPane.showMessageDialog(frame, "User found", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    userArea.setText("User not found");
                    userDetailArea.setText("No user info");
                    //JOptionPane.showMessageDialog(frame, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                userArea.revalidate();
                userArea.repaint();
                userDetailArea.revalidate();
                userDetailArea.repaint();
            }
        });
        panel.add(searchButton);

  

        ImageIcon homeIcon = new ImageIcon("Icons/home3.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = Homepage.getLoggedInUser();
                Homepage.homepage(user);
                frame.dispose();
            }
        });
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends3.png");
        JButton findFriendsButton = new JButton(findFriendsIcon);
        findFriendsButton.setBounds(150, 700, 25, 25);
        findFriendsButton.setBorderPainted(false);
        findFriendsButton.setContentAreaFilled(false);
        findFriendsButton.setFocusPainted(false);
        findFriendsButton.setOpaque(false);
        panel.add(findFriendsButton);

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost3.png");
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

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile3.png");
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
//################################################################
//################## ADD POST PAGE ###############################
//################################################################
class AddPost {
    static void addPost() {
        JFrame frame = new JFrame("Add a Post");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(223, 223, 223));
        panel.setLayout(null);
        frame.add(panel);

        JLabel postLabel = new JLabel("Write your post:");
        postLabel.setBounds(50, 50, 150, 30);
        panel.add(postLabel);

        JTextField postInfo = new JTextField();
        postInfo.setBounds(50, 100, 380, 150);
        postInfo.setBackground(new java.awt.Color(200, 200, 200));
        panel.add(postInfo);

        JButton uploadPost = new JButton("Post");
        uploadPost.setBounds(50, 270, 100, 40);
        uploadPost.setBackground(new Color(100, 150, 200));
        uploadPost.setForeground(Color.WHITE);
        uploadPost.setFocusPainted(false);
        panel.add(uploadPost);
        User user = Homepage.getLoggedInUser();

        uploadPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String postContent = postInfo.getText();

                // write save method to save post to social_network_data.txt
                if (!postContent.isEmpty()){
                    // save post to file
                    // add user  id to this method 
                    SocialNetwork.savePostToFile("social_network_data.txt", user.getUserID(), postContent);
                    JOptionPane.showMessageDialog(frame, "Post uploaded successfully!");
                    postInfo.setText(""); // Clear input field
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Post cannot be empty!");
                }
            }
        });
        panel.add(uploadPost);

        ImageIcon homeIcon = new ImageIcon("Icons/home3.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Homepage.homepage(user);
                frame.dispose();
            }
        });
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends3.png");
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

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost3.png");
        JButton addPostButton = new JButton(addPostIcon);
        addPostButton.setBounds(250, 700, 25, 25);
        addPostButton.setBorderPainted(false);
        addPostButton.setContentAreaFilled(false);
        addPostButton.setFocusPainted(false);
        addPostButton.setOpaque(false);
        panel.add(addPostButton);

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile3.png");
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
    }
}

class Profile {
    static void profile() {
        User user = Homepage.getLoggedInUser();

        JFrame frame = new JFrame("User Profile");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(223, 223, 223));
        panel.setLayout(null);
        frame.add(panel);

        JTextField userIDField = new JTextField("User ID: " + user.getUserID());
        userIDField.setBounds(50, 50, 400, 30);
        userIDField.setEditable(false);
        panel.add(userIDField);

        JTextField usernameField = new JTextField("Username: " + user.getUsername());
        usernameField.setBounds(50, 100, 400, 30);
        usernameField.setEditable(false);
        panel.add(usernameField);

        JTextField companyField = new JTextField("Company: " + user.getWorkplace());
        companyField.setBounds(50, 150, 400, 30);
        companyField.setEditable(false);
        panel.add(companyField);

        JTextField cityField = new JTextField("City: " + user.getHometown());
        cityField.setBounds(50, 200, 400, 30);
        cityField.setEditable(false);
        panel.add(cityField);

        JTextField passwordField = new JTextField("Password: " + user.getPassword());
        passwordField.setBounds(50, 250, 400, 30);
        passwordField.setEditable(false);
        panel.add(passwordField);

         // Display Friends List
         JTextArea friendsListArea = new JTextArea();
         friendsListArea.setBounds(50, 300, 400, 150);
         friendsListArea.setEditable(false);
 
         // Get the Set of friends from FriendList
         Set<User> friends = user.getFriends().getFriends(); // Get the Set<User> from FriendList
 
         // Check if the user has friends and display them
         if (friends.isEmpty()) {
             friendsListArea.setText("No friends in your list.");
         } else {
             StringBuilder friendsListText = new StringBuilder("Friends List:\n");
             // Iterate through the Set of friends and display their usernames
             for (User friend : friends) {
                 friendsListText.append(friend.getUsername()).append("\n");
             }
             friendsListArea.setText(friendsListText.toString());
         }
         panel.add(friendsListArea);

        ImageIcon homeIcon = new ImageIcon("Icons/home3.png");
        JButton homeButton = new JButton(homeIcon);
        homeButton.setBounds(50, 700, 25, 25);
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage.homepage(user);
                frame.dispose();
            }
        });
        panel.add(homeButton);

        ImageIcon findFriendsIcon = new ImageIcon("Icons/findFriends3.png");
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

        ImageIcon addPostIcon = new ImageIcon("Icons/addPost3.png");
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

        ImageIcon userProfileIcon = new ImageIcon("Icons/userProfile3.png");
        JButton userProfileButton = new JButton(userProfileIcon);
        userProfileButton.setBounds(350, 700, 25, 25);
        userProfileButton.setBorderPainted(false);
        userProfileButton.setContentAreaFilled(false);
        userProfileButton.setFocusPainted(false);
        userProfileButton.setOpaque(false);
        panel.add(userProfileButton);
    }
}
