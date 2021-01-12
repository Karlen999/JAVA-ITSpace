package adportal.storage;

import adportal.model.Ad;
import adportal.model.Category;
import adportal.model.User;

import java.util.HashSet;
import java.util.Set;

public interface AdStorage {

    void add(Ad ad);

    void printAllAds();

    void printMyAds(User user);

    void printByCategory(Category category);

    void deleteMyAds(User user);

    void deleteAdByTitle(String title, User currentUser);

}