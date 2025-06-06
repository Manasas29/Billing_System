
package com.example.billingsystem.controller;
// package com.example.billingsystem.controller;

import com.example.billingsystem.model.Bill;
import com.example.billingsystem.model.Item;
import com.example.billingsystem.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for handling billing-related web requests.
 * It serves the main HTML page and provides REST endpoints for managing items and bill calculations.
 */
@Controller
public class BillingController {

    private final BillingService billingService;

    /**
     * Autowires the BillingService into this controller.
     * Spring automatically injects an instance of BillingService.
     * @param billingService The service to be injected.
     */
    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    /**
     * Handles GET requests to the root URL ("/").
     * This method serves the main HTML page (index.html) which contains the billing form and table.
     * @param model The Spring Model object to pass data to the view (though not strictly needed for this simple page).
     * @return The name of the Thymeleaf template to render (index.html).
     */
    @GetMapping("/")
    public String index(Model model) {
        // You could add initial data to the model here if needed, but for dynamic JS, it's not strictly necessary.
        return "index"; // Refers to src/main/resources/templates/index.html
    }

    /**
     * Handles POST requests to "/api/add-item".
     * This endpoint receives item data from the frontend (as JSON in the request body),
     * adds it to the billing service, and returns a success response.
     * @param item The Item object received from the request body.
     * @return A ResponseEntity indicating success.
     */
    @PostMapping("/api/add-item")
    @ResponseBody // Indicates that the return value should be bound directly to the web response body (JSON).
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        billingService.addItem(item);
        return ResponseEntity.ok("Item added successfully!");
    }

    /**
     * Handles GET requests to "/api/bill".
     * This endpoint returns the current state of the bill (items, subtotal, tax, discount, grand total)
     * as a JSON object. This is consumed by the frontend JavaScript to update the display.
     * @return The current Bill object.
     */
    @GetMapping("/api/bill")
    @ResponseBody // Indicates that the return value should be bound directly to the web response body (JSON).
    public Bill getBill() {
        return billingService.getBill();
    }

    /**
     * Handles POST requests to "/api/clear-bill".
     * This endpoint clears all items from the current bill.
     * @return A ResponseEntity indicating success.
     */
    @PostMapping("/api/clear-bill")
    @ResponseBody
    public ResponseEntity<String> clearBill() {
        billingService.clearBill();
        return ResponseEntity.ok("Bill cleared successfully!");
    }
}
