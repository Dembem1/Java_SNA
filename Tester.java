// Tester class
// run the program and check all the methods 

import java.util.Scanner;

public class Tester {
    // testing post and postList classes
    public static void main(String[] args) {
        // create a post using constructor 2
        Post p1 = new Post(1, "Hello, this is my first post");

        // display post
        p1.displayPost();

        // create a small menu to test a post list class
        PostList pl = new PostList();
        Scanner s = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Posts Menu");
            System.out.println("1. Add Post");
            System.out.println("2. Delete Post");
            System.out.println("3. Search post");
            System.out.println("4. Display posts");
            System.out.println("5. Scroll posts");
            System.out.println("6. Exit");
            System.out.print("Please select an option (1-5): ");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {

                case 1:
                // ask for postID and content
                System.out.println("Enter post ID:");
                int postID = s.nextInt();
                s.nextLine();
                System.out.println("Enter post content:");
                String content = s.nextLine();
                
                // add a post to the post list
                pl.addPost(new Post(postID, content));

                // exit the program
                System.out.println("do you want to leave the program?");
                String answer = s.nextLine();
                if (answer.equals("yes")){
                    return;
                } 
                else {
                    break;
                }

                case 2:
                // ask for postID to delete
                System.out.println("Enter post ID to delete:");
                int postIDDelete = s.nextInt();

                //remove a post from the post list
                pl.removePost(pl.searchPost(postIDDelete));
                
                // exit the program 
                System.out.println("do you want to leave the program?");
                String answer2 = s.nextLine();
                if (answer2.equals("yes")){
                    return;
                } 
                else {
                    break;
                }

                case 3:
                System.out.println("Enter post ID ro search:");
                int postIDSearch = s.nextInt();

                // search for a post
                Post p = pl.searchPost(postIDSearch);
                if (p != null){
                    p.displayPost();
                }
                else{
                    System.out.println("Post not found");
                }

                // exit the program
                System.out.println("do you want to leave the program?");
                s.nextLine();
                String answer3 = s.nextLine();
                if (answer3.equals("yes")){
                    return;
                } 
                else {
                    break;
                }

                case 4:
                // display all posts
                pl.displayPosts();

                // exit the program
                System.out.println("do you want to leave the program?");
                String answer4 = s.nextLine();
                if (answer4.equals("yes")){
                    return;
                } 
                else {
                    break;
                }

                case 5:
                // scroll through posts
                pl.scrollPosts();

                // exit the program
                System.out.println("do you want to leave the program?");
                String answer5 = s.nextLine();
                if (answer5.equals("yes")){
                    return;
                } 
                else {
                    break;
                }

                case 6:
                // Display who is waiting 
                System.out.println("Exiting the program.....");
                    return;

                default:
                    System.out.println("Invalid choice. Please choose between 1 and 5.");

            }
        }
    }
}
