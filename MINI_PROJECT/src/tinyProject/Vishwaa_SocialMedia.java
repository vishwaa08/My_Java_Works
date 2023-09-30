package tinyProject;

//NAME : M.VISHWAA
//Enrollment no : EBEON0723817736
//Batch code : 2023-10226
//Mini project Topic : MINI SOCIAL MEDIA APPLICATION
//
//
//DESCRIPTION : my project is a simple social media application like Whatsapp where I focused on the user registration, posting messages 
//and viewing messages.




 

import java.util.ArrayList;//k1 - import
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vishwaa_SocialMedia {//c1-Class concept k2-public k3 - class
    public static void main(String[] args) {//c2-static, c3-access modifiers concept k4 - static k5 - void
        Scanner scanner = new Scanner(System.in);//c4 - predefined Scanner method k6 - new
        SocialMedia platform = new SocialMedia();//c5 - object creation

        while (true) {//c6 - looping statement k7 - while
            System.out.println("Welcome to Mini Social Media Platform!");
            System.out.println("1. Register User");
            System.out.println("2. Post Message");
            System.out.println("3. View Posts");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt(); //c7 - primitive datatype k8 - int
            scanner.nextLine(); 

            switch (choice) {//c8 - switch statement k8 - switch
                case 1:  // k9 - case
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();//c9 - String concept
                    platform.registerUser(username);//c10 -function call in SocialMedia class through platform object
                    System.out.println(username + " has been registered.");
                    break;// k10 - break
                case 2:
                    System.out.print("Enter your username: ");
                    String poster = scanner.nextLine();
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    platform.postMessage(poster, message);
                    System.out.println("Message posted.");
                    break;
                case 3:
                   
                    String postviewer = scanner.nextLine();
                    platform.viewPosts(postviewer);
                    break;
                case 4:
                    System.out.println("Thanks for using Mini Social Media Platform!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

class SocialMedia {
    private Map<String, List<String>> usersPosts;//c11 - map concept,c12 - Encapsulation concept k11 - private

    public SocialMedia() {//c13 - constructor concept
        usersPosts = new HashMap<>();//c14 - HashMap concept
    }

    public void registerUser(String username) {
        if (!usersPosts.containsKey(username)) {//c15 - containskey method in Hashmap k12 - if
            usersPosts.put(username, new ArrayList<>());//c16 - ArrayList concept
        }
    }

    public void postMessage(String poster, String message) {
        if (usersPosts.containsKey(poster)) {
            List<String> posts = usersPosts.get(poster);//c17 - generics,c18 - list
            posts.add(message);
        } else {
            System.out.println("User does not exist. Please register first.");
        }
    }

    public void viewPosts(String postviewer) {
    	System.out.println(usersPosts.get(postviewer));

    }
}

