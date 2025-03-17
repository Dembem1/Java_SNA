// User class
// It should store: userId, userName, workplace, hometown, password, friends(use FriendList class for data structure) and posts(use PostList class for data structure)
// add a constructor and get/set methods for all the fields

public class User {
    private int userID;
    private String username;
    private String workplace;
    private String hometown;
    private String password;
    

    public User(int userID, String username, String workplace, String hometown, String password) {
        this.userID = userID;
        this.username = username;
        this.workplace = workplace;
        this.hometown = hometown;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getHometown() {
        return hometown;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
