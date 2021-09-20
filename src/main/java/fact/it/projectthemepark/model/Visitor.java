// Carlos Duarte 1ITF6 r0841640
package fact.it.projectthemepark.model;

import java.util.ArrayList;

public class Visitor extends Person {
    private int yearOfBirth, themeParkCode;
    private ArrayList<String> wishList = new ArrayList<>();


    public Visitor(String firstName, String surName) {
        super(firstName, surName);
        themeParkCode = -1;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getThemeParkCode() {
        return themeParkCode;
    }

    public void setThemeParkCode(int themeParkCode) {
        this.themeParkCode = themeParkCode;
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public boolean addToWishList(String attractionName) {
        if(wishList.size() < 5) {
            wishList.add(attractionName);
            return true;
        }
        else{
            return false;
        }
    }

    public int getNumberOfWishes() {
        return wishList.size();
    }

    @Override
    public String toString() {
        return "Visitor " + super.toString() + " with theme park code " + themeParkCode;
    }
}
