package org.launchcode.marketplacemetrics.models;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class Inventory {

    private int id;
    private static int nextId = 1;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Price is required.")
    @Digits(integer=10, fraction = 2, message = "Price must be a number.")
    private BigDecimal price;

    @NotNull(message = "Please select a category.")
    private String category;

    public Inventory(String name, BigDecimal price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = nextId;
        nextId++;
    }

    public Inventory() {}

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        return id == inventory.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
