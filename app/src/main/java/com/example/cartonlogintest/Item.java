package com.example.cartonlogintest;

import java.util.ArrayList;

public class Item {
    private String name;
    private boolean test;

    public Item(String tempName, boolean temp){
        name = tempName;
        test = temp;
    }

    public String getName(){
        return name;
    }

    public boolean getTest(){
        return test;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTest(Boolean test){
        this.test = test;
    }
    private static int lastContactId = 0;

    public static ArrayList<Item> createPantryList(int numItems) {
        ArrayList<Item> contacts = new ArrayList<Item>();
        for (int i = 1; i <= numItems; i++) {
            contacts.add(new Item("Item num " + ++lastContactId, i <= numItems / 2));
        }
        return contacts;
    }
}
