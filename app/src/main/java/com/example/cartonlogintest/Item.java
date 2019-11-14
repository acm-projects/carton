package com.example.cartonlogintest;

import java.util.ArrayList;

public class Item {
    private String name;
    private double price;
    private String label;
    private String quantity;

    public Item(String tempName, double price, String label, String quantity){
        name = tempName;
        this.price = price;
        this.label = label;
        this.quantity = quantity;
    }
    public Item(String tempName){
        name = tempName;
        price = 0.0;
        label = " ";
        quantity = "1";
    }

    public String getName(){
        return name;
    }

    public double getPrice() { return price; }

    public String getLabel() { return label; }

    public String getQuantity() { return quantity;}

    public void setLabel(String label) { this.label = label; }

    public void setQuantity(String quantity) { this.quantity = quantity; }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price) { this.price = price;}

    public static ArrayList<Item> createNewGroceryList() {
        ArrayList<Item> list = new ArrayList<Item>();
        Item temp = new Item("Milk",5.0,"Diary","1 Gallon");
        list.add(temp);
        temp = new Item("Eggs",5.0,"Diary","1 Dozen");
        list.add(temp);
        temp = new Item("Ground Beef",4.99,"Meat","1 Pound");
        list.add(temp);
        temp = new Item("Bananas",2.35,"Produce","6");
        list.add(temp);
        temp = new Item("Cheese",2.45,"Diary","12 Singles");
        list.add(temp);
        temp = new Item("Bread",3.95,"Grains","1 Loaf");
        list.add(temp);
        return list;
    }

    public static ArrayList<Item> addItem(ArrayList<Item> groceryList, Item temp){
        groceryList.add(temp);
        return groceryList;
    }

    public static ArrayList<Item> createPantryList(String currentPantry) {
        ArrayList<Item> contacts = new ArrayList<Item>();
        while(currentPantry != "\0"){
            //contacts.add()
        }
        return contacts;
    }
}
