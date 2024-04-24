package gui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends BaseView implements PageView {

    private JButton buttonCreate; // Declare the button
    private JButton buttonCustomer; // Declare the customer button
    private JFrame frame;

    public MainPage() {
        // frame
        this.frame = new JFrame("Main Menu");
        int width = 300;
        int height = 300;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainPanel
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new FlowLayout());

        // buttons
        buttonCreate = new JButton("Create Food Item"); // Initialize the button
        mainPanel.add(buttonCreate);

        buttonCustomer = new JButton("Customer Page"); // Initialize the customer button
        mainPanel.add(buttonCustomer);

        frame.setVisible(true);
    }

    // Method to get the create button
    public JButton getButtonCreate() {
        return buttonCreate;
    }
    
    // Method to get the customer button
    public JButton getButtonCustomer() {
        return buttonCustomer;
    }
    
    public void  setNonVisible() {
    	frame.setVisible(false);
    }
    
    public void  setVisible() {
    	frame.setVisible(true);
    }

	@Override
	public JButton getButtonSubmit() {
		// Since no submit button, returns null
		return null;
	}
}