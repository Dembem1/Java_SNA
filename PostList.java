// PostList class
// It should use a LinkedList structure to store the list of posts
// Methods: addPost(Post p), removePost(Post p), searchPost(), likePost(), unlikePost(), displayPosts(), scrollPosts()
import java.util.LinkedList;
import java.util.Scanner;

public class PostList {
    // new variable that will store a LinkedList of Post objects
    LinkedList<Post> posts;

    // constructor
    public PostList(){
        posts = new LinkedList<Post>();
    }
    
    // get posts
    public LinkedList<Post> getPosts(){
        return posts;
    }
    
    // add post method
    public void addPost(Post p){
        posts.add(p);
        System.out.println("Post added successfully");
    }

    // remove post method
    public void removePost(Post p){
        posts.remove(p);
        System.out.println("Post removed successfully");
    }

    // search post method
    public Post searchPost(int postID){
        for (Post p : posts){
            if (p.getPostID() == postID){
                return p;
            }
        }
        return null;
    }

    // like post method
    public void likePost(int postID){
        Post p = searchPost(postID);

        if (p != null){
            p.addLike();
            System.out.println("Post liked successfully");
        }
        else{
            System.out.println("Post not found");
        }
    }

    // unlike post method
    public void unlikePost(int postID){
        Post p = searchPost(postID);
        
        if (p != null){
            p.removeLike();
            System.out.println("Post unliked successfully");
        }
        else{
            System.out.println("Post not found");
        }
    }

    // display posts method
    public void displayPosts(){
        System.out.println("Displaying all posts");
        int index = 1;

        for (Post p : posts){
            System.out.println("Post " + index);
            p.displayPost();
            index++;
        }
    }

    // scroll through posts method
    public void scrollPosts(){
        // scrolling through posts
        Scanner s = new Scanner(System.in);
        System.out.println("Scrolling through posts");
        int index = 1;

        for (Post p : posts){
            // display post
            System.out.println("Post " + index);
            p.displayPost();

            // like post??
            System.out.println("Do you want to like this post?");
            String answer = s.nextLine();
            if (answer.equals("yes")){
                p.addLike();
            }

            // unlike post??
            System.out.println("Do you want to unlike this post?");
            String answer2 = s.nextLine();
            if (answer2.equals("yes")){
                p.removeLike();
            }

            // exit post??
            System.out.println("Do you want to exit scrolling?");
            String answer3 = s.nextLine();
            if (answer3.equals("yes")){
                break;
            }

            // move to past post??
            System.out.println("Do you want to move? Type 'previous' to move to the previous post or 'next' to move to the next post");
            String answer4 = s.nextLine();
            if (answer4.equals("previous")){
                index--;
                if (index < 1){
                    index = 1;
                }
            }
            else{
                index++;
            }
        }
    }
}