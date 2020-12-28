package adportal;

public interface Commands {

    // Login, Register commands
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    //user Ad commands
    int LOGOUT = 0;
    int ADD_NEW_AD = 1;
    int PRINT_MY_ALL_ADS = 2;
    int PRINT_ALL_ADS = 3;
    int PRINT_AD_BY_CATEGORY = 4;
    int DELETE_MY_ALL_ADS = 5;
    int DELETE_AD_BY_TITLE = 6;

    static void printCommands(){
        System.out.println("Please Input " + EXIT + " For Exit AdPortal ");
        System.out.println("Please Input " + LOGIN + " For Login AdPortal ");
        System.out.println("Please Input " + REGISTER + " For Register AdPortal ");
    }

    static void printLoginCommands(){
        System.out.println("Please Input " + LOGOUT + " For Logout to AdPortal");
        System.out.println("Please Input " + ADD_NEW_AD + " For Add New Advertisment to AdPortal");
        System.out.println("Please Input " + PRINT_MY_ALL_ADS + " For Print My All Advertisments");
        System.out.println("Please Input " + PRINT_ALL_ADS + " For Print All Advertisments");
        System.out.println("Please Input " + PRINT_AD_BY_CATEGORY + " For Print Advertisments By Category");
        System.out.println("Please Input " + DELETE_MY_ALL_ADS + " For Delete My All Advertisments");
        System.out.println("Please Input " + DELETE_AD_BY_TITLE + " For Delete Advertisments By Title");
    }
}
