// FriendList class
// It should use Set<User> hashSet<User> data structure to store the list of friends
// Methods: addFriend(User u), removeFriend(User u), displayFriends(), getFriend(), isFriend(User u) - check if the friend in a friendList

import java.util.HashSet;
import java.util.Set;

public class FriendList {
    private Set<User> friends;

    public FriendList() {
        this.friends = new HashSet<>();
    }

    // add a friend
    public void addFriend(User user) {
        friends.add(user);
    }

    // remove a friend
    public void removeFriend(User user) {
        friends.remove(user);
    }

    // check if someone is a friend
    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    // display all friends
    public void displayFriends() {
        if (friends.isEmpty()) {
            System.out.println("No friends in your list.");
        } else {
            System.out.println("Your Friends:");
            for (User friend : friends) {
                System.out.println("- " + friend.getUsername());
            }
        }
    }

    // get the Set of friends
    public Set<User> getFriends() {
        return friends;
    }

    // get comma-separated friend IDs (for saving to a file)
    public String getFriendsIDs() {
        StringBuilder ids = new StringBuilder();
        for (User friend : friends) {
            ids.append(friend.getUserID()).append(",");
        }
        return ids.length() > 0 ? ids.substring(0, ids.length() - 1) : ""; // Remove trailing comma
    }
}
