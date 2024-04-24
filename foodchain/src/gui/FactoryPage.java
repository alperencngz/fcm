package gui;

import javax.swing.*;
import java.awt.*;

public class FactoryPage extends BaseView {
    
	private JFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldCategory;
    private JTextField textFieldDate;
    private JTextField textFieldOrigin;
    private JTextField textFieldPrice;
    private JButton buttonSubmit;
    
    public FactoryPage() {
        this.frame = new JFrame("Factory Page");
        int width = 250;
        int height = 300;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainPanel
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new GridLayout(6, 2));

        // attributes
        mainPanel.add(new JLabel("Food Name"));
        textFieldName = new JTextField();
        mainPanel.add(textFieldName);

        mainPanel.add(new JLabel("Food Category"));
        textFieldCategory = new JTextField();
        mainPanel.add(textFieldCategory);

        mainPanel.add(new JLabel("Expiry Date"));
        textFieldDate = new JTextField();
        mainPanel.add(textFieldDate);

        mainPanel.add(new JLabel("Country of Origin"));
        textFieldOrigin = new JTextField();
        mainPanel.add(textFieldOrigin);

        mainPanel.add(new JLabel("Food Price"));
        textFieldPrice = new JTextField();
        mainPanel.add(textFieldPrice);

        // button
        mainPanel.add(new JPanel());
        buttonSubmit = new JButton("Add Food Item"); // Initialization without re-declaration
        mainPanel.add(buttonSubmit);

        frame.setVisible(true);
    }
    
    public JTextField getTextFieldName() { return textFieldName; }
    public JTextField getTextFieldCategory() { return textFieldCategory; }
    public JTextField getTextFieldDate() { return textFieldDate; }
    public JTextField getTextFieldOrigin() { return textFieldOrigin; }
    public JTextField getTextFieldPrice() { return textFieldPrice; }
    public JButton getButtonSubmit() { return buttonSubmit; }

	public void setNonVisible() {
		frame.setVisible(false);
	}
	
	public void setVisible() {
		frame.setVisible(false);
	}
}