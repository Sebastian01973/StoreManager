package models.comparators;

import models.Store;

import java.util.Comparator;

public class StoreComparator implements Comparator<Store> {

    @Override
    public int compare(Store s1, Store s2) {
        return s1.getAddress().compareTo(s2.getAddress());
    }
}
