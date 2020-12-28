package adportal.storage;

import adportal.model.AD;
import adportal.model.Category;
import adportal.model.User;

import java.util.HashSet;
import java.util.Set;

public class AdStorage {

    private Set<AD> storages = new HashSet<>();

    public void add(AD value) {
        storages.add(value);
    }

    public int getSize() {
        return storages.size();
    }

    public boolean isEmpty() {
        return storages.isEmpty();
    }

    public void printMyAllAds(User user) {
        for (AD storage : storages) {
            if (storage.getAuthor().equals(user)) {
                System.out.println(storage.getTitle());
                System.out.println(storage.getText());
                System.out.println(storage.getPrice());
                System.out.println(storage.getDate());
                System.out.println(storage.getAuthor().getName());
            }
        }
    }

    public void printAllAds() {
        for (AD storage : storages) {
            System.out.println(storage.getTitle());
            System.out.println(storage.getText());
            System.out.println(storage.getPrice());
            System.out.println(storage.getDate());
            System.out.println(storage.getAuthor().getName());
        }
    }

    public void printAdByCategory(Category category) {
        for (AD storage : storages) {
            if (storage.getCategory().equals(category)) {
                System.out.println(storage);
            }
        }
    }

    public void deleteMyAllAds(User author) {
        for (AD storage : storages) {
            if (storage.getAuthor().equals(author)) {
                storages.remove(author);
            }
        }
    }

    public void deleteAdByTitle(String title) {
        for (AD storage : storages) {
            if (storage.getTitle().equals(title)) {
                storages.remove(title);
            }
        }
    }
}
