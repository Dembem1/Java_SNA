// Post class 
// It should contain: postID, content, likes
// methods: get/set, addLike(), removeLike(), displayPost()

public class Post {
    // instance variables
    private int postID;
    private String content;
    private int likes;

    // constructor 1
    public Post(){
        postID = 0;
        content = "none";
        likes = 0;
    }

    // constructor 2
    public Post(int postID, String content){
        this.postID = postID;
        this.content = content;
        likes = 0;
    }

    // get methods
    public int getPostID(){
        return postID;
    }
    public String getContent(){
        return content;
    }
    public int getLikes(){
        return likes;
    }

    // set methods
    public void setPostID(int postID) {
        this.postID = postID;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    // main methods
    public void addLike(){
        likes++;
    }
    public void removeLike(){
        if (likes > 0){
            likes--;
        }
        else{
            System.out.println("Post unliked");
        }
    }
    public void displayPost(){
        System.out.println("Post ID: " + postID);
        System.out.println("Post content: " + content);
        System.out.println("Post likes:" + likes);
    }
}