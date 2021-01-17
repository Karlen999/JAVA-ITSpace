package adportal.storage.impl;

import adportal.model.Ad;
import adportal.model.Category;
import adportal.model.User;
import adportal.storage.AdStorage;
import adportal.util.FileUtil;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdStorageFileImpl implements AdStorage {

    private List<Ad> adList;

    public AdStorageFileImpl(){
        adList = FileUtil.deserializeAdList();
    }

    @Override
    public void add(Ad ad) {

        adList.add(ad);
        FileUtil.serializeAdList(adList);
    }

    @Override
    public void printAllAds() {
        System.out.println(adList);
    }

    @Override
    public void printMyAds(User user) {
        for (Ad ad : adList) {
            if (ad.getUser().equals(user)) {
                System.out.println(ad);
            }
        }
    }

    @Override
    public void printByCategory(Category category) {
        for (Ad ad : adList) {
            if (ad.getCategory() == category) {
                System.out.println(ad);
            }
        }
    }

    @Override
    public void deleteMyAds(User user) {
        for (Ad ad : adList) {
            if (ad.getUser().equals(user)) {
                adList.remove(ad);
            }
        }
        FileUtil.serializeAdList(adList);
    }

    @Override
    public void deleteAdByTitle(String title, User currentUser) {
        Iterator<Ad> iterator = adList.iterator();
        while (iterator.hasNext()) {
            Ad ad = iterator.next();
            if (ad.getTitle().equals(title) && ad.getUser().equals(currentUser)) {
                iterator.remove();
            }
        }
        FileUtil.serializeAdList(adList);

    }
}