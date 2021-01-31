package jdbcexample;


import jdbcexample.manager.UserManager;
import jdbcexample.model.User;

import java.util.List;

public class JdbcExample {

    public static void main(String[] args) {

        UserManager userManager = new UserManager();

        User user = User.builder()
                .name("petros")
                .surname("petrosyan")
                .email("petros@gmail.com")
                .password("petros")
                .build();

        System.out.println("Before " + user);
        userManager.addUser(user);
        System.out.println("After " + user);

//        List<User> users = userManager.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        userManager.deleteUser(1);
//
//        users = userManager.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User userById = userManager.getUserById(2);
//        System.out.println(userById);
//
//        userById.setName("Poxos");
//        userById.setSurname("Poxosyan");
//        userManager.updateUser(userById);
//        System.out.println(userManager.getUserById(2));

    }
}
