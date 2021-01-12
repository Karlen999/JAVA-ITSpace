package blog;

import blog.exception.PostNotFoundException;
import blog.model.Post;
import blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Scanner;

public class Blog implements PostCommands {

    private static Scanner scanner = new Scanner(System.in);
    private static PostStorageImpl postStorage = new PostStorageImpl();

    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            printPostCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                command = -1;
            }

            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addPost();
                    break;
                case GET_POST:
                    getPostByTitle();
                    break;
                case POSTS_BY_CATEGORY:
                    getPostsByCategory();
                    break;
                case ALL_POSTS:
                    postStorage.printAllPosts();
                    break;
                case SEARCH_POST:
                    searchPostsByKeyword();
                    break;
                default:
                    System.out.println("Wrong command !!!");
            }
        }
    }

    private static void printPostCommands() {
        System.out.println("Please input " + EXIT + " for exit Blog");
        System.out.println("Please input " + ADD_POST + " for add post");
        System.out.println("Please input " + GET_POST + " for search post by title");
        System.out.println("Please input " + POSTS_BY_CATEGORY + " for search by category");
        System.out.println("Please input " + ALL_POSTS + " for print all posts");
        System.out.println("Please input " + SEARCH_POST + " for search posts by keyword");

    }

    private static void addPost() {
        System.out.println("Please input  title, text, category, createdDate");
        String postDataStr = scanner.nextLine();
        String[] postData = postDataStr.split(",");
        if (postData.length == 4) {
            String title = postData[0];
            String text = postData[1];
            String category = postData[2];
            Date createdDate = new Date();
            Post post = new Post(title, text, category, createdDate);
            postStorage.add(post);
            System.out.println("Post was added!");

        } else {
            System.out.println("Please input valid data!!!");
            addPost();
        }
    }

    private static void getPostByTitle() {
        System.out.println("Please input title for search post");
        String postTitle = scanner.nextLine();
        try {
            System.out.println(postStorage.getPostByTitle(postTitle));
        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getPostsByCategory() {
        System.out.println("Please input category for search by category");
        String postByCategory = scanner.nextLine();
        postStorage.printPostsByCategory(postByCategory);
    }


    private static void searchPostsByKeyword() {
        System.out.println("Please input keyword for search by title or text");
        String postByCategory = scanner.nextLine();
        postStorage.searchPostsByKeyword(postByCategory);
    }
}