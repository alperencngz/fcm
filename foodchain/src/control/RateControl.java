package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.FoodItem;
import gui.RatePage;

public class RateControl {
	
	private RatePage ratePage;
	private boolean isUpdated;

    public RateControl(RatePage ratePage) {
    	this.ratePage = ratePage;
    	
        ratePage.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the main page and hide the rate page
                ratePage.showMainPage();
                ratePage.setNonVisible();
            }
        });
        
        ratePage.getButtonSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Submit
            	isUpdated = updateFoodItemWithRateDetails();
            	
            	if (isUpdated) {
            		String comment = ratePage.getFoodItem().getComment();
            		String rating = ratePage.getFoodItem().getRating();
            		System.out.println(comment + rating);
            	}
            	
            }
        });
        // Add other action listeners if necessary
    }
    
    private boolean updateFoodItemWithRateDetails() {
    	// Retrieve the comment and rating from the RatePage
    	try {
    		
    		String comment = ratePage.getTextFieldCommentField().getText();
            String rating = ratePage.getRatingDropdown().getSelectedItem().toString();

            validateStringField(comment, "Comment");

            // Update the FoodItem object
            FoodItem foodItem = ratePage.getFoodItem();
            foodItem.setComment(comment);
            foodItem.setRating(rating);

            // Refresh the RatePage to display updated details
            ratePage.displayFoodDetails(foodItem);

            return true;
    		
    	} catch (IllegalArgumentException ex) {
    		
    		JOptionPane.showMessageDialog(null, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
    		
    	}
    	
    }
    

    private void validateStringField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }
}