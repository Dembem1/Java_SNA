// Social Network class
// It should store all users data in a ArrayList<User> data structure
// Should store all data in a file and read data from a file
// Handles user queries, friend recommendations, and file operations.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JTextArea;

import java.io.IOException;

public class SocialNetwork {
    // add an arrayList to store all users
    private ArrayList<User> users;

    // constructor
    public SocialNetwork() {
        this.users = new ArrayList<User>();
    }

    // add a user to the list
    public void addUser(User user) {
        users.add(user);
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
        }
                return false;
    }    

    // load all users data from a file
    public void loadFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            Map<Integer, User> userMap = new HashMap<>(); // Temporary storage to map userIDs to Users
            String line;

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                int userID = Integer.parseInt(userDetails[0]);
                User user = new User(userID, userDetails[1], userDetails[2], userDetails[3], userDetails[4]);
                users.add(user);
                userMap.put(userID, user);

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
            System.out.println("Social network data loaded successfully.");
            
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

    public boolean saveUserToFile(String fileName, int ID, String username, String hometown, String workplace, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.write(ID + "," + username + "," + hometown + "," + workplace + "," + password);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
            e.printStackTrace();
        }
        return false;
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
}
