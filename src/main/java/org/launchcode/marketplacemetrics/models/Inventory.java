package org.launchcode.marketplacemetrics.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private int id;


    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.00", message = "Price must be 0.00 or greater")
    @Digits(integer=10, fraction = 2, message = "Price must be between 0 and 1,000,000,000 with a maximum of 2 decimal places.")
    private BigDecimal price;

    @NotNull(message = "Please select a category.")
    private InventoryCategory category;

    public Inventory(String name, BigDecimal price, InventoryCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Inventory() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public InventoryCategory getCategory() {
        return category;
    }

    public void setCategory(InventoryCategory category) {
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
