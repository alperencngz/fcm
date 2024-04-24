package gui;

import javax.swing.*;

import app.FoodItem;

import java.awt.*;

public class RatePage extends BaseView {
	
    private JFrame frame;
    private JTextArea detailsArea;
    private JTextField commentField;
    private JComboBox<Integer> ratingDropdown;
    private JButton submitButton;
    private JButton mainMenuButton;
    
    private MainPage mainPage; // reference to MainPage
    private FoodItem foodItem;

    public RatePage(FoodItem foodItem, MainPage mainPage) {
    	
    	this.mainPage = mainPage;
    	this.foodItem = foodItem;   	
        // frame setup
        frame = new JFrame("Rate " + foodItem.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // main panel with BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        // Scrollable food details area
        detailsArea = new JTextArea(6, 20);
        detailsArea.setEditable(false);
        displayFoodDetails(foodItem);
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        mainPanel.add(scrollPane);

        // Comment section
        mainPanel.add(new JLabel("Comment:"));
        commentField = new JTextField();
        commentField.setMaximumSize(new Dimension(Integer.MAX_VALUE, commentField.getPreferredSize().height));
        mainPanel.add(commentField);

        // Rating section
        mainPanel.add(new JLabel("Rating:"));
        Integer[] ratings = {1, 2, 3, 4, 5};
        ratingDropdown = new JComboBox<>(ratings);
        ratingDropdown.setMaximumSize(new Dimension(Integer.MAX_VALUE, ratingDropdown.getPreferredSize().height));
        mainPanel.add(ratingDropdown);

        // Buttons in a separate panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        mainMenuButton = new JButton("Main Menu");
        buttonPanel.add(mainMenuButton);
        mainPanel.add(buttonPanel);

        // Show frame
        frame.setVisible(true);
    }

    public void displayFoodDetails(FoodItem foodItem) {
        StringBuilder details = new StringBuilder();
        details.append("Name: '").append(foodItem.getName()).append("'\n");
        details.append("Category: '").append(foodItem.getCategory()).append("'\n");
        details.append("Expiry Date: '").append(foodItem.getExpiryDate()).append("'\n");
        details.append("Origin: '").append(foodItem.getOrigin()).append("'\n");
        details.append("Price: ").append(foodItem.getPrice()).append("\n");
        details.append("Warehouse Location: '").append(foodItem.getWarehouseLocation()).append("'\n");
        details.append("Receive Date: '").append(foodItem.getReceiveDate()).append("'\n");
        details.append("Transporter Company: '").append(foodItem.getTransporterCompany()).append("'\n");
        details.append("Office Location: '").append(foodItem.getOfficeLocation()).append("'\n");
        details.append("Food Source: '").append(foodItem.getFoodSource()).append("'\n");
        details.append("Food Destination: '").append(foodItem.getFoodDestination()).append("'\n");
        details.append("Expected Delivery Date: '").append(foodItem.getExpectedDeliveryDate()).append("'\n");
        
        String comment = foodItem.getComment();
        String rating = foodItem.getRating();
        
        if (comment != null && !comment.isEmpty()) {
            details.append("Comment: '").append(comment).append("'\n");
        } else {
            details.append("Comment: 'No comment provided'\n");
        }

        if (rating != null && !rating.isEmpty()) {
            details.append("Rating: ").append(rating).append("\n");
        } else {
            details.append("Rating: 'No rating provided'\n");
        }

        detailsArea.setText(details.toString());
    }

    // Getters for buttons, if needed
    public JButton getButtonSubmit() {
        return submitButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    // Other methods and getters
    
    public JTextField getTextFieldCommentField() { return commentField; }
    
    public void showMainPage() {
        if (mainPage != null) {
            mainPage.setVisible();
        }
    }
    
    public JComboBox<Integer> getRatingDropdown() {
        return ratingDropdown;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }
    

    public void setNonVisible() {
        frame.setVisible(false);
    }
    
	public void setVisible() {
		frame.setVisible(false);
	}
}