
package com.example.billingsystem.service;

import com.example.billingsystem.model.Bill;
import com.example.billingsystem.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service class for handling billing logic.
 * Manages the list of items and calculates bill totals.
 */
@Service
public class BillingService {

    // In-memory storage for items. In a real application, this would be a database.
    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the current bill.
     * @param item The item to be added.
     */
    public void addItem(Item item) {
        // Basic validation: ensure quantity and unit price are positive
        if (item.getQuantity() <= 0 || item.getUnitPrice() <= 0) {
            System.err.println("Warning: Item quantity and unit price must be positive. Item not added: " + item.getName());
            return;
        }
        this.items.add(item);
    }

    /**
     * Retrieves the current bill, including all items and calculated totals.
     * @return A Bill object containing all current items and their calculated totals.
     */
    public Bill getBill() {
        // Create a new Bill object using the current list of items.
        // The Bill class handles the calculation of subtotal, tax, discount, and grand total.
        return new Bill(Collections.unmodifiableList(items), 0.10, 0.05); // Pass current items, fixed tax (10%), fixed discount (5%)
    }

    /**
     * Clears all items from the current bill.
     * This can be used to start a new bill.
     */
    public void clearBill() {
        this.items.clear();
    }
}
