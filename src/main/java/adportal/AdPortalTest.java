package adportal;


import adportal.model.Ad;
import adportal.model.Category;
import adportal.model.Gender;
import adportal.model.User;
import adportal.storage.AdStorage;
import adportal.storage.UserStorage;
import adportal.storage.impl.AdStorageFileImpl;
import adportal.storage.impl.AdStorageImpl;
import adportal.storage.impl.UserStorageFileImpl;
import adportal.storage.impl.UserStorageImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class AdPortalTest implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static AdStorage adStorage;
    private static UserStorage userStorage;
    private static User currentUser = null;

    public static void main(String[] args) {

        System.out.println("Which storage you want to use");
        System.out.println("1 - HEAP[RAM]");
        System.out.println("2 - FILE[HDD]");
        int storage = Integer.parseInt(scanner.nextLine());
        if (storage == 2) {
            adStorage = new AdStorageFileImpl();
            userStorage = new UserStorageFileImpl();
        } else {
            adStorage = new AdStorageImpl();
            userStorage = new UserStorageImpl();
        }
        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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
                    break;
                case MAIN_PRINT_ALL_ADS:
                    printAllAds();
                    break;
                case IMPORT_USERS:
                    importFromXslx();
                    break;
                default:
                    System.out.println("invalid command, please try again!");
            }
        }
    }

    private static void importFromXslx() {
        System.out.println("Please select xlsx path");
        String xlsxPath = scanner.nextLine();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxPath);
            DataFormatter formatter = new DataFormatter();
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();

            for (int i = 1; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);

                String name = row.getCell(0).getStringCellValue();
                String surname = row.getCell(1).getStringCellValue();
                Gender gender = Gender.valueOf(row.getCell(2).getStringCellValue());
                Double age = row.getCell(3).getNumericCellValue();
                Cell phoneNumber = row.getCell(4);
                String phoneNumberStr = phoneNumber.getCellType() == CellType.NUMERIC ?
                        String.valueOf(Double.valueOf(phoneNumber.getNumericCellValue()).intValue()) : phoneNumber.getStringCellValue() ;
                Cell password = row.getCell(5);
                String passwordStr = password.getCellType() == CellType.NUMERIC ?
                        String.valueOf(Double.valueOf(password.getNumericCellValue()).intValue()) : password.getStringCellValue();

                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setGender(gender);
                user.setAge(age.intValue());
                user.setPhoneNumber(phoneNumberStr);
                user.setPassword(passwordStr);
                System.out.println(user);
                userStorage.add(user);
                System.out.println("Import was success!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while importing users");
        }
    }

    private static void printAllAds() {
        adStorage.printAllAds();
    }

    private static void register() {
        System.out.println("Please input name,surname,gender,age,phoneNumber,password");
        String userData = scanner.nextLine();
        String[] userDataArr = userData.split(",");
        User user = new User(userDataArr[0], userDataArr[1],
                Gender.valueOf(userDataArr[2]), Integer.parseInt(userDataArr[3]),
                userDataArr[4], userDataArr[5]);
        userStorage.add(user);
        System.out.println("Register was success!");
    }

    private static void login() {
        System.out.println("please input phoneNumber,password");
        String userCred = scanner.nextLine();
        String[] userDataArr = userCred.split(",");
        User user = userStorage.getByPhone(userDataArr[0]);
        if (user == null) {
            System.out.println("User does not exists!");
        } else {
            if (user.getPassword().equals(userDataArr[1])) {
                System.out.println("Welcome " + user.getName() + "!");
                currentUser = user;
                userLogin();
            } else {
                System.out.println("password is incorrect!");
            }

        }

    }

    private static void userLogin() {
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    currentUser = null;
                    isRun = false;
                    break;
                case ADD:
                    addAd();
                    break;
                case PRINT_ALL_ADS:
                    printAllAds();
                    break;
                case PRINT_ALL_MY_ADS:
                    adStorage.printMyAds(currentUser);
                    break;
                case PRINT_ADS_BY_CATEGORY:
                    printAdsByCategory();
                    break;
                case DELETE_MY_ALL_ADS:
                    adStorage.deleteMyAds(currentUser);
                    break;
                case DELETE_MY_AD_BY_TITLE:
                    deleteMyAdByTitle();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }

    }

    private static void deleteMyAdByTitle() {
        System.out.println("Please select your ad title");
        adStorage.printMyAds(currentUser);
        String title = scanner.nextLine();
        adStorage.deleteAdByTitle(title, currentUser);
    }

    private static void printAdsByCategory() {
        System.out.println("here is the categoryList");
        for (Category value : Category.values()) {
            System.out.println(value);
        }
        String categoryStr = scanner.nextLine();
        adStorage.printByCategory(Category.valueOf(categoryStr));
    }

    private static void addAd() {
        System.out.println("please input title,text,price,category");
        System.out.println("here is the categoryList");
        for (Category value : Category.values()) {
            System.out.println(value);
        }
        String adData = scanner.nextLine();
        String[] adDataArr = adData.split(",");
        Ad ad = new Ad(adDataArr[0], adDataArr[1], Double.parseDouble(adDataArr[2]),
                new Date(), Category.valueOf(adDataArr[3]), currentUser);
        adStorage.add(ad);
        System.out.println("Ad was added!");
    }

}
