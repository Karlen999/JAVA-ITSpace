package adportal.storage.impl;

import adportal.model.User;
import adportal.storage.UserStorage;
import adportal.util.FileUtil;

import java.util.HashMap;
import java.util.Map;

public class UserStorageFileImpl implements UserStorage {

    private Map<String, User> userMap;

    public UserStorageFileImpl(){

        userMap = FileUtil.deserializeUserMap();
    }

    @Override
    public void add(User user) {

        userMap.put(user.getPhoneNumber(), user);
        FileUtil.serializeUserMap(userMap);
    }

    @Override
    public User getByPhone(String phone) {
        return userMap.get(phone);
    }
}
