package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class BaseView implements PageView {
	
	private static final JButton JButton = null;
	public static final JFrame frame = new JFrame();


	public void setVisible() {
		
	};
	
    public void setNonVisible() {
    	
    };
    
	
	public JButton getButtonSubmit() {
		return JButton;
	};
	
}
