// Social Network class
// It should store all users data in a ArrayList<User> data structure
// Should store all data in a file and read data from a file
// Handles user queries, friend recommendations, and file operations.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.IOException;

public class SocialNetwork {
    // add an arrayList to store all users
    private ArrayList<User> users;
    private int userIdCounter = 1; // Start user IDs from 1

    // constructor
    public SocialNetwork() {
        this.users = new ArrayList<User>();
    }

    // Add user and automatically assign an ID
    public void addUser(String username, String workplace, String hometown, String password) {
        User newUser = new User(userIdCounter, username, workplace, hometown, password);
        users.add(newUser);
        userIdCounter++; // Increment ID for the next user
    }

    // get all user data by username and 'file name' method
    public static User getUser(String filename, String username) {
        Map<String, User> userMap = new HashMap<>(); // Store users by username

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            User currentUser = null;
            FriendList friendList = new FriendList();
            PostList postList = new PostList();

            while ((line = reader.readLine()) != null) {
                // Split user information
                String[] userData = line.split(",");
                if (userData.length < 5) continue; // Skip malformed lines
                
                int userID = Integer.parseInt(userData[0]);
                String name = userData[1];
                String workplace = userData[2];
                String hometown = userData[3];
                String password = userData[4];

                // Create User object and store it in map (for resolving friends later)
                User user = new User(userID, name, workplace, hometown, password, new FriendList(), new PostList());
                userMap.put(name, user); 

                if (name.equals(username)) {
                    currentUser = user;
                }
            }

            // If the user was found, go back through the file to fetch their friends and posts
            if (currentUser != null) {
                try (BufferedReader friendReader = new BufferedReader(new FileReader(filename))) {
                    boolean readingFriends = false;
                    
                    while ((line = friendReader.readLine()) != null) {
                        if (line.startsWith(currentUser.getUserID() + ",")) {
                            readingFriends = true; // Start reading their friends/posts
                            continue;
                        }
                        if (readingFriends) {
                            if (line.startsWith("Friends:")) {
                                String friendsData = line.substring(8).trim();
                                if (!friendsData.isEmpty()) {
                                    String[] friendNames = friendsData.split(";");
                                    for (String friendName : friendNames) {
                                        User friend = userMap.get(friendName.trim());
                                        if (friend != null) {
                                            friendList.addFriend(friend); // Add User object instead of String
                                        }
                                    }
                                }
                            } else if (line.startsWith("Posts:")) {
                                String postsData = line.substring(6).trim();
                                if (!postsData.isEmpty()) {
                                    String[] posts = postsData.split(";");
                                    for (String postData : posts) {
                                        String[] postParts = postData.split("\\|");
                                        if (postParts.length == 3) { // Ensure correct format
                                            int postID = Integer.parseInt(postParts[0]);
                                            String content = postParts[1];
                                            int likes = Integer.parseInt(postParts[2]);
                                            Post post = new Post(postID, content, likes);
                                            postList.addPost(post);
                                        }
                                    }
                                }
                                break; // Stop reading once posts are found
                            }
                        }
                    }
                }

                // Return user with populated friends and posts
                return new User(currentUser.getUserID(), currentUser.getUsername(), currentUser.getWorkplace(),
                        currentUser.getHometown(), currentUser.getPassword(), friendList, postList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if user is not found
    }

    // remove a user from the list
    public void removeUser(User user) {
        users.remove(user);
    }

    // find a user by ID
    public User findUser(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null; // User not found
    }

    // get userID
    

    // find a user by username
    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found 
    }

    // display all users in the network
    public void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    /* find mutual friends between two users
    public void findMutualFriends(User user1, User user2) {
        if (user1 == null || user2 == null) return; // if either user is not found

        System.out.println("Mutual friends of " + user1.getName() + " and " + user2.getName() + ":");
        for (User friend : user1.getFriendList().getFriends()) {
            if (user2.getFriendList().isFriend(friend)) {
                System.out.println("- " + friend.getName());
            }
        }
    } */

    // save all users data to a file
    public boolean saveToFile(String filename, int ID, String username, String workplace, String hometown, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (User user : users) {
                // Save user info
                writer.write(user.getUserID() + "," + user.getUsername() + "," + 
                             user.getWorkplace() + "," + user.getHometown() + "," + user.getPassword());
                writer.newLine();
    
                // Save friends (by userID)
                StringBuilder friendsLine = new StringBuilder("Friends:");
                for (User friend : user.getFriends().getFriends()) {
                    friendsLine.append(friend.getUserID()).append(",");
                }
                writer.write(friendsLine.toString());
                writer.newLine();
    
                // Save posts
                StringBuilder postsLine = new StringBuilder("Posts:");
                for (Post post : user.getPosts().getPosts()) {
                    postsLine.append(post.getPostID()).append("|")
                            .append(post.getContent().replace(",", " ")).append("|")
                            .append(post.getLikes()).append(";");
                }
                writer.write(postsLine.toString());
                writer.newLine();
            }
            writer.flush();  // Make sure data is written before closing
            return true;
            //System.out.println("Social network data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
            e.printStackTrace();
            return false;
        }
    }    

    // load all users data from a file
    public void loadFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            Map<Integer, User> userMap = new HashMap<>(); // Temporary storage to map userIDs to Users
            String line;
            int maxUserID = 0; // Track the highest user ID

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                int userID = Integer.parseInt(userDetails[0]);
                User user = new User(userID, userDetails[1], userDetails[2], userDetails[3], userDetails[4]);
                users.add(user);
                userMap.put(userID, user);

                // Keep track of the highest userID
                if (userID > maxUserID) {
                    maxUserID = userID;
                }

                // Read Friends
                line = reader.readLine();
                if (line.startsWith("Friends:")) {
                    String[] friends = line.substring(8).split(",");
                    for (String friendID : friends) {
                        if (!friendID.isEmpty()) {
                            int fID = Integer.parseInt(friendID);
                            if (userMap.containsKey(fID)) {
                                user.getFriends().addFriend(userMap.get(fID));
                            }
                        }
                    }
                }

                // Read Posts
                line = reader.readLine();
                if (line.startsWith("Posts:")) {
                    String[] posts = line.substring(6).split(";");
                    for (String postData : posts) {
                        if (!postData.isEmpty()) {
                            String[] postParts = postData.split("\\|");
                            int postID = Integer.parseInt(postParts[0]);
                            String content = postParts[1];
                            int likes = Integer.parseInt(postParts[2]);
                            Post post = new Post(postID, content);
                            for (int i = 0; i < likes; i++) {
                                post.setLikes(likes); // Restore likes
                            }
                            user.getPosts().addPost(post);
                        }
                    }
                }
            }
            // Set userIdCounter to the next available ID
            userIdCounter = maxUserID + 1;

            System.out.println("Data loaded successfully.");
            
        } catch (IOException e) {
            System.out.println("Error loading data from file.");
            e.printStackTrace();
        }
    }

    public boolean isUserExist(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("social_network_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1 && userDetails[1].equals(username) && userDetails[4].equals(password)) {
                    System.out.println("User exists.");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while checking user existence.");
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUsernameValid(String filename, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1 && userDetails[1].equals(username)) {
                    System.out.println("Username already exists.");
                    return false;
                } else {
                    System.out.println("Username is valid.");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveUserToFile(String fileName, String username, String hometown, String workplace, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            int lastID = getLastUserID(fileName); // Get last used ID
            int userID = lastID + 1; // Assign next available ID
            
            writer.newLine();
            writer.write(userID + "," + username + "," + hometown + "," + workplace + "," + password);
            writer.newLine();
            writer.flush();
            userIdCounter++;
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
            e.printStackTrace();
        }
        return false;
    }

    // get last user ID from the file
    private int getLastUserID(String fileName) {
        int maxID = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || !line.contains(",")) continue; // Ignore empty lines
                
                String[] userDetails = line.split(",");
                if (userDetails.length >= 1) {
                    try {
                        int userID = Integer.parseInt(userDetails[0]);
                        if (userID > maxID) {
                            maxID = userID;
                        }
                    } catch (NumberFormatException e) {
                        // Ignore invalid ID lines
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file to get last ID.");
            e.printStackTrace();
        }
        
        return maxID;
    }
    

    public String[] searchUser(String filename, String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1 && userDetails[1].equals(username)) {
                    System.out.println("User found.");
                    return new String[]{userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4]};
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while searching for user.");
            e.printStackTrace();
        }
        return null;
    }
    
    public String[] getRandomUserPost(String filename) {
        List<String[]> userPosts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentUser = null;

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 1) {
                    currentUser = userDetails[1]; // Get username from 2nd column
                }

                if (currentUser != null && line.startsWith("Posts:")) {
                    String[] postDetails = line.split("\\|");
                    if (postDetails.length > 1) {
                        userPosts.add(new String[]{currentUser, postDetails[1]}); // Username and Post
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userPosts.isEmpty()) {
            return new String[]{"No users found", ""};
        }

        Random random = new Random();
        return userPosts.get(random.nextInt(userPosts.size())); // Pick a random user post
    }

    public static void savePostToFile(String fileName, int userID, String postContent) {
        List<String> fileLines = new ArrayList<>();
        int maxPostID = 0;

        // Read file and store lines in a list
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileLines.add(line);

                // Find the highest post ID to ensure unique IDs
                if (line.startsWith("Posts:")) {
                    String[] posts = line.substring(6).split(";");
                    for (String postData : posts) {
                        if (!postData.isEmpty()) {
                            String[] postParts = postData.split("\\|");
                            int postID = Integer.parseInt(postParts[0]);
                            maxPostID = Math.max(maxPostID, postID);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
            return;
        }

        // Rewrite file with new post added
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < fileLines.size(); i++) {
                String line = fileLines.get(i);
                writer.write(line);
                writer.newLine();

                // If we find the user's section, add the post after it
                if (line.startsWith(userID + ",")) {
                    if (i + 1 < fileLines.size() && fileLines.get(i + 1).startsWith("Posts:")) {
                        // Append new post to existing "Posts:" section
                        String updatedPosts = fileLines.get(i + 1) + (maxPostID + 1) + "|" + postContent.replace(",", " ") + "|0;";
                        writer.write(updatedPosts);
                        writer.newLine();
                        i++; // Skip old posts line
                    } else {
                        // If no "Posts:" section exists, create one
                        writer.write("Posts:" + (maxPostID + 1) + "|" + postContent.replace(",", " ") + "|0;");
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}