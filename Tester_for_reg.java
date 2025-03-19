import java.io.*;
import java.util.Scanner;

public class Tester_for_reg {
    public static void main(String[] args) {
        String fileName = "users.txt";
        Scanner sr = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = sr.nextLine();
        System.out.println("Enter your password: ");
        String password = sr.nextLine();

        if (isUsernameTaken(fileName, username)) {
            System.out.println("Username already exists. Please try a different one.");
        } else {
            saveUserToFile(fileName, username, password);
            System.out.println("Registration successful!");
        }
    }

    private static boolean isUsernameTaken(String username, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void saveUserToFile(String fileName, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
            e.printStackTrace();
        }
    }
}
