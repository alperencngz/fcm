package control;

import gui.MainPage;
import gui.WarehousePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.FoodItem;
import app.Main;

public class WarehouseControl {

    private WarehousePage warehousePage;

    public WarehouseControl(WarehousePage warehousePage) {
        this.warehousePage = warehousePage;

        // Set up the listener for the "Receive Product" button
        warehousePage.getButtonSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updateFoodItemWithWarehouseDetails()) {
                    System.out.println("Warehouse Button clicked");

                    // Open MainPage
                    MainPage mainPage = new MainPage(); // Create an instance of MainPage
                    new MainControl(mainPage); // Set up the control for the MainPage
                    
                    warehousePage.setNonVisible();
                }
            }
        });
    }

    private boolean updateFoodItemWithWarehouseDetails() {
        try {
            // Get values from text fields
            String warehouseLocation = warehousePage.getTextFieldName().getText();
            String dateOfReceiving = warehousePage.getTextFieldCategory().getText();

            // Validate inputs
            validateStringField(warehouseLocation, "Warehouse Location");
            validateDateFormat(dateOfReceiving);

            // Retrieve the last FoodItem from the foodList
            FoodItem lastFoodItem = Main.foodList.isEmpty() ? null : Main.foodList.get(Main.foodList.size() - 1);

            if (lastFoodItem != null) {
                // Set warehouse-related information
                lastFoodItem.setWarehouseLocation(warehouseLocation);
                lastFoodItem.setDateOfReceiving(dateOfReceiving);
            } else {
                throw new IllegalStateException("No FoodItem found to update.");
            }

            return true;
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void validateStringField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }

    private void validateDateFormat(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Date must be in the format yyyy-MM-dd.");
        }
        // Additional validation for date correctness can be added here
    }

    // Add any additional methods or logic as needed
}