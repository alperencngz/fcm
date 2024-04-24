package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public interface PageView {
    void setVisible();
    void setNonVisible();
    
	public static final JFrame frame = new JFrame();
	
	JButton getButtonSubmit();
}