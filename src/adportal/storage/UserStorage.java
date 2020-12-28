package adportal.storage;

import adportal.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private Map<String, User> users = new HashMap<>();

    public void addUser(User user){
        users.put(user.getPhoneNumber(), user);
    }

    public User Login (String phoneNumber, String password){
        for (User user : users.values()) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public int getSize(){
        return users.size();
    }

    public boolean isEmpty(){
        return users.isEmpty();
    }

}
