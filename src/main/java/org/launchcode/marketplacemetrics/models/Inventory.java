package org.launchcode.marketplacemetrics.models;

public class Inventory {

    private int id;
    private static int nextId = 1;

    private String name;
    private Integer price;
    private String category;

    public Inventory(String name, Integer price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
