package control;

import gui.FactoryPage;
import gui.TransportationPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.FoodItem;
import app.Main;

public class FactoryControl {

    private FactoryPage factoryPage;
    private boolean isCreated;

    public FactoryControl(FactoryPage factoryPage) {
        this.factoryPage = factoryPage;

        // Set up the listener for the "Add Food Item" button
        factoryPage.getButtonSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCreated = createAndAddFoodItem();
                System.out.println("Factory Button clicked");
                
                if (isCreated) {
                    TransportationPage transportationPage = new TransportationPage();
                    new TransportationControl(transportationPage); // Add this line
                    
                    factoryPage.setNonVisible();
                }
            }
        });
    }

    private boolean createAndAddFoodItem() {
        try {
            // Get values from text fields
            String name = factoryPage.getTextFieldName().getText();
            String category = factoryPage.getTextFieldCategory().getText();
            String expiryDate = factoryPage.getTextFieldDate().getText();
            String origin = factoryPage.getTextFieldOrigin().getText();
            String price = factoryPage.getTextFieldPrice().getText();
            
            
            // Validate inputs
            validateStringField(name, "Name");
            validateStringField(category, "Category");
            validateStringField(origin, "Origin");
            validateDateFormat(expiryDate);
            double newprice = validatePrice(price);

            // Create a new FoodItem
            FoodItem foodItem = new FoodItem(name, category, expiryDate, origin, newprice);

            // Add the FoodItem to the list in Main
            Main.addFood(foodItem);
            return true;
        } catch (IllegalArgumentException ex) {
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

    private double validatePrice(String priceText) throws NumberFormatException {
        try {
            return Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Price must be a valid number.");
        }
    }
}