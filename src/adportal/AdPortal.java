package adportal;


import adportal.model.AD;
import adportal.model.Category;
import adportal.model.Gender;
import adportal.model.User;
import adportal.storage.AdStorage;
import adportal.storage.UserStorage;

import java.util.Date;
import java.util.Scanner;

public class AdPortal implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static UserStorage userStorage = new UserStorage();
    private static AdStorage adStorage = new AdStorage();
    private static User Login;

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number ");
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();

            }
        }
    }

    private static void login() {
        System.out.println("Please input phoneNumber and password for login");
        String loginStr = scanner.nextLine();
        String[] loginData = loginStr.split(",");
        try {
            Login = userStorage.Login(loginData[0], loginData[1]);
            if (userStorage.isEmpty()){
                register();
            }else {
                printLoginCommands();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        Commands.printLoginCommands();
    }

    private static void register() {
        System.out.println("Please input name, surname, gender, age, phoneNumber, password");
        try {
            String userStr = scanner.nextLine();
            String[] userData = userStr.split(",");
            User user = new User();
            user.setName(userData[0]);
            user.setSurname(userData[1]);
            user.setGender(Gender.valueOf(userData[2].toUpperCase()));
            user.setAge(Integer.parseInt(userData[3]));
            user.setPhoneNumber(userData[4]);
            user.setPassword(userData[5]);
            userStorage.addUser(user);
            System.out.println("Your registration was successful");
        }catch (Exception e){
            System.out.println("Your registration is failed, try again");
            register();
        }
    }

    private static void printLoginCommands() {
        User user = new User();
        boolean isRun = true;
        while (isRun) {
            Commands.printLoginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number ");
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_NEW_AD:
                    addAdver();
                    break;
                case PRINT_MY_ALL_ADS:
                    printMyAllAds();
                    break;
                case PRINT_ALL_ADS:
                    printAllAds();
                    break;
                case PRINT_AD_BY_CATEGORY:
                    printAdByCategory();
                    break;
                case DELETE_MY_ALL_ADS:
                    deleteMyAllAds();
                    break;
                case DELETE_AD_BY_TITLE:
                    deleteAdByTitle();
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }


    private static void addAdver() {
        System.out.println("Please input title, text, price, date, category, author");
        AD ad = new AD();
        try {
            String adverStr = scanner.nextLine();
            String[] adverData = adverStr.split(",");
            ad.setTitle(adverData[0]);
            ad.setText(adverData[1]);
            ad.setPrice(Integer.parseInt(adverData[2]));
            ad.setDate(new Date());
            ad.setCategory(Category.valueOf(adverData[4].toUpperCase()));
            ad.setAuthor(Login);
            adStorage.add(ad);
            System.out.println("Post was added");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Post doesn't added, please try again");
            addAdver();
        }
    }

    private static void printMyAllAds() {
        adStorage.printMyAllAds(Login);
    }

    private static void printAllAds() {
        adStorage.printAllAds();
    }

    private static void printAdByCategory() {
        System.out.println("Please input category");
        String category = scanner.nextLine();
        adStorage.printAdByCategory(Category.valueOf(category.toUpperCase()));
    }

    private static void deleteMyAllAds() {
        adStorage.deleteMyAllAds(Login);
    }

    private static void deleteAdByTitle() {
        System.out.println("Please input title for delete");
        String title = scanner.nextLine();
        adStorage.deleteAdByTitle(title);
    }






}
