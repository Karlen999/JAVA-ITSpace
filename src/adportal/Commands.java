package adportal;

public interface Commands {
    //main commands
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int MAIN_PRINT_ALL_ADS = 3;

    //user commands
    int LOGOUT = 0;
    int ADD = 1;
    int PRINT_ALL_ADS = 2;
    int PRINT_ALL_MY_ADS = 3;
    int PRINT_ADS_BY_CATEGORY = 4;
    int DELETE_MY_ALL_ADS = 5;
    int DELETE_MY_AD_BY_TITLE = 6;


    static void printMainCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + LOGIN + " for LOGIN");
        System.out.println("Please input " + REGISTER + " for REGISTER");
        System.out.println("Please input " + MAIN_PRINT_ALL_ADS + " for PRINT_ALL_ADS");
    }

    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for LOGOUT");
        System.out.println("Please input " + ADD + " for ADD");
        System.out.println("Please input " + PRINT_ALL_ADS + " for PRINT_ALL_ADS");
        System.out.println("Please input " + PRINT_ALL_MY_ADS + " for PRINT_ALL_MY_ADS");
        System.out.println("Please input " + PRINT_ADS_BY_CATEGORY + " for PRINT_ADS_BY_CATEGORY");
        System.out.println("Please input " + DELETE_MY_ALL_ADS + " for DELETE_MY_ALL_ADS");
        System.out.println("Please input " + DELETE_MY_AD_BY_TITLE + " for DELETE_MY_AD_BY_TITLE");
    }
}
