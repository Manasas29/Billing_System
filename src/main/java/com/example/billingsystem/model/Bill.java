
package com.example.billingsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the entire bill, holding a list of items and calculating totals.
 */
public class Bill {
    private List<Item> items;
    private double taxRate; // e.g., 0.10 for 10%
    private double discountPercentage; // e.g., 0.05 for 5%

    /**
     * Constructs a new Bill with an empty list of items and default tax/discount rates.
     */
    public Bill() {
        this.items = new ArrayList<>();
        this.taxRate = 0.10; // Default 10% tax
        this.discountPercentage = 0.05; // Default 5% discount
    }

    /**
     * Constructs a new Bill with specified items, tax rate, and discount percentage.
     * @param items The list of items in the bill.
     * @param taxRate The tax rate (e.g., 0.10 for 10%).
     * @param discountPercentage The discount percentage (e.g., 0.05 for 5%).
     */
    public Bill(List<Item> items, double taxRate, double discountPercentage) {
        this.items = items;
        this.taxRate = taxRate;
        this.discountPercentage = discountPercentage;
    }

    // Getters and Setters

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    /**
     * Calculates the subtotal of all items in the bill.
     * @return The sum of all item total prices.
     */
    public double getSubtotal() {
        return items.stream()
                .mapToDouble(Item::getTotalPrice)
                .sum();
    }

    /**
     * Calculates the tax amount based on the subtotal and tax rate.
     * @return The calculated tax amount.
     */
    public double getTaxAmount() {
        return getSubtotal() * taxRate;
    }

    /**
     * Calculates the discount amount based on the subtotal and discount percentage.
     * @return The calculated discount amount.
     */
    public double getDiscountAmount() {
        return getSubtotal() * discountPercentage;
    }

    /**
     * Calculates the grand total of the bill (subtotal + tax - discount).
     * @return The final grand total.
     */
    public double getGrandTotal() {
        return getSubtotal() + getTaxAmount() - getDiscountAmount();
    }
}
