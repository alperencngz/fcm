package gui;

import javax.swing.*;
import java.awt.*;

public class WarehousePage extends BaseView {
	
	private JFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldCategory;
    private JButton buttonSubmit;
	
    public WarehousePage() {

        // frame
        this.frame = new JFrame("Warehouse Page");
        int width = 300;
        int height = 300;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainPanel
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new GridLayout(3, 2));

        // attributes
        JLabel labelName = new JLabel("Warehouse Location");
        mainPanel.add(labelName);
        textFieldName = new JTextField();  // Use class field instead of local variable
        mainPanel.add(textFieldName);

        JLabel labelCategory = new JLabel("Date of Receiving");
        mainPanel.add(labelCategory);
        textFieldCategory = new JTextField();  // Use class field instead of local variable
        mainPanel.add(textFieldCategory);

        // button
        mainPanel.add(new JPanel());

        buttonSubmit = new JButton("Receive Product");  // Use class field instead of local variable
        mainPanel.add(buttonSubmit);

        frame.setVisible(true);
    }
    
    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldCategory() {
        return textFieldCategory;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }

	public void setNonVisible() {
		frame.setVisible(false);
	}
	
	public void setVisible() {
		frame.setVisible(false);
	}
}