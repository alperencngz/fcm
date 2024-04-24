package gui;

import javax.swing.*;
import java.awt.*;

public class TransportationPage extends BaseView {
    
	private JFrame frame;
    private JTextField textFieldCompanyName;
    private JTextField textFieldOfficeLocation;
    private JTextField textFieldFoodSource;
    private JTextField textFieldFoodDestination;
    private JTextField textFieldExpectedDeliveryDate;
    private JButton buttonSubmit;
    
    public TransportationPage() {
        this.frame = new JFrame("Transporter Page");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new GridLayout(6, 2));

        // Transporter Company
        mainPanel.add(new JLabel("Transporter Company"));
        textFieldCompanyName = new JTextField();
        mainPanel.add(textFieldCompanyName);

        // Office Location
        mainPanel.add(new JLabel("Office Location"));
        textFieldOfficeLocation = new JTextField();
        mainPanel.add(textFieldOfficeLocation);

        // Food Source
        mainPanel.add(new JLabel("Food Source"));
        textFieldFoodSource = new JTextField();
        mainPanel.add(textFieldFoodSource);

        // Food Destination
        mainPanel.add(new JLabel("Food Destination"));
        textFieldFoodDestination = new JTextField();
        mainPanel.add(textFieldFoodDestination);

        // Expected Delivery Date
        mainPanel.add(new JLabel("Expected Delivery Date"));
        textFieldExpectedDeliveryDate = new JTextField();
        mainPanel.add(textFieldExpectedDeliveryDate);

        // Submit button
        mainPanel.add(new JPanel());
        buttonSubmit = new JButton("Add Shipping Details");
        mainPanel.add(buttonSubmit);

        frame.setVisible(true);
    }
    
    public JTextField getTextFieldCompanyName() { return textFieldCompanyName; }
    public JTextField getTextFieldOfficeLocation() { return textFieldOfficeLocation; }
    public JTextField getTextFieldFoodSource() { return textFieldFoodSource; }
    public JTextField getTextFieldFoodDestination() { return textFieldFoodDestination; }
    public JTextField getTextFieldExpectedDeliveryDate() { return textFieldExpectedDeliveryDate; }
    public JButton getButtonSubmit() { return buttonSubmit; }
    
    public void  setNonVisible() {
    	frame.setVisible(false);
    }
    
    public void  setVisible() {
    	frame.setVisible(true);
    }
}