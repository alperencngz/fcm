package app;

import java.util.ArrayList;
import java.util.List;

import control.MainControl;
import gui.MainPage;

public class Main {
	
	public static final List<FoodItem> foodList = new ArrayList<>();
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainPage mainPage = new MainPage(); // Create an instance of MainPage
                new MainControl(mainPage); // Set up the control for the MainPage
            }
        });
    }
    
    public static void addFood(FoodItem food) {
        foodList.add(food);
    }
}