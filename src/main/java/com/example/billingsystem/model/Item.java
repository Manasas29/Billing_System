
package com.example.billingsystem.model;

/**
 * Represents a single item in the billing system.
 */
public class Item {
    private String name;
    private int quantity;
    private double unitPrice;

    // Default constructor for Spring/JSON deserialization
    public Item() {
    }

    /**
     * Constructs a new Item.
     * @param name The name of the item.
     * @param quantity The quantity of the item.
     * @param unitPrice The price per unit of the item.
     */
    public Item(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters for all fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Calculates the total price for this item (quantity * unitPrice).
     * @return The total price of the item.
     */
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
}
