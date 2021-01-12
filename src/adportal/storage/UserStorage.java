package adportal.storage;

import adportal.model.User;

public interface UserStorage {

    void add(User user);

    User getByPhone(String phone);

}