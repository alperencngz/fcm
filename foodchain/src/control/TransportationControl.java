package control;

import gui.TransportationPage;
import gui.WarehousePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.FoodItem;
import app.Main;

public class TransportationControl {

    private TransportationPage transportationPage;
    private boolean isUpdated;

    public TransportationControl(TransportationPage transportationPage) {
        this.transportationPage = transportationPage;
        isUpdated = false;

        // Set up the listener for the "Add Shipping Details" button
        transportationPage.getButtonSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isUpdated = updateFoodItemWithShippingDetails();
                System.out.println("Transportation Button clicked");

                // You can manage the next step (like opening the WarehousePage) 
                // from the place where TransportationControl is instantiated.
                
                if (isUpdated()) {
                    WarehousePage warehousenPage = new WarehousePage();
                    new WarehouseControl(warehousenPage); // Add this line to bind
                    
                    transportationPage.setNonVisible();
                }
            }
        });
    }

    private boolean updateFoodItemWithShippingDetails() {
        try {
            // Get values from text fields
            String transporterCompany = transportationPage.getTextFieldCompanyName().getText();
            String officeLocation = transportationPage.getTextFieldOfficeLocation().getText();
            String foodSource = transportationPage.getTextFieldFoodSource().getText();
            String foodDestination = transportationPage.getTextFieldFoodDestination().getText();
            String deliveryDate = transportationPage.getTextFieldExpectedDeliveryDate().getText();

            // Validate inputs
            validateStringField(transporterCompany, "Transporter Company");
            validateStringField(officeLocation, "Office Location");
            validateStringField(foodSource, "Food Source");
            validateStringField(foodDestination, "Food Destination");
            validateDateFormat(deliveryDate);

            // Retrieve the last FoodItem from the foodList
            FoodItem lastFoodItem = Main.foodList.isEmpty() ? null : Main.foodList.get(Main.foodList.size() - 1);

            if (lastFoodItem != null) {
                // Set transportation-related information
                lastFoodItem.setTransporterCompany(transporterCompany);
                lastFoodItem.setOfficeLocation(officeLocation);
                lastFoodItem.setFoodSource(foodSource);
                lastFoodItem.setFoodDestination(foodDestination);
                lastFoodItem.setExpectedDeliveryDate(deliveryDate);
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

    // You may include other validation methods as needed

    public boolean isUpdated() {
        return isUpdated;
    }
}