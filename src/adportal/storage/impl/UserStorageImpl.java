package adportal.storage.impl;

import adportal.model.User;
import adportal.storage.UserStorage;

import java.util.HashMap;
import java.util.Map;

public class UserStorageImpl implements UserStorage {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void add(User user) {
        userMap.put(user.getPhoneNumber(), user);
    }

    @Override
    public User getByPhone(String phone) {
        return userMap.get(phone);
    }
}
