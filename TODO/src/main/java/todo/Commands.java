package todo;

public interface Commands {

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    int LOGOUT = 0;
    int ADD_NEW_TODO = 1;
    int MY_ALL_LIST = 2;
    int MY_TODO_LIST = 3;
    int MY_IN_PROGRESS_LIST = 4;
    int MY_FINISHED_LIST = 5;
    int CHANGE_TODO_STATUS = 6;
    int DELETE_TODO = 7;

    static void printMainCommands(){
        System.out.println("Please Input " + EXIT + " For Exit");
        System.out.println("Please Input " + LOGIN + " For Login");
        System.out.println("Please Input " + REGISTER + " For Register");
    }

    static void printUserCommands(){
        System.out.println("Please Input " + LOGOUT + " For LOGOUT");
        System.out.println("Please Input " + ADD_NEW_TODO + " For ADD_NEW_TODO");
        System.out.println("Please Input " + MY_ALL_LIST + " For MY_ALL_LIST");
        System.out.println("Please Input " + MY_TODO_LIST + " For MY_TODO_LIST");
        System.out.println("Please Input " + MY_IN_PROGRESS_LIST + " For MY_IN_PROGRESS_LIST");
        System.out.println("Please Input " + MY_FINISHED_LIST + " For MY_FINISHED_LIST");
        System.out.println("Please Input " + CHANGE_TODO_STATUS + " For CHANGE_TODO_STATUS");
        System.out.println("Please Input " + DELETE_TODO + " For DELETE_TODO");
    }
}