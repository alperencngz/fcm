package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Main;
import gui.CustomerPage;
import gui.FactoryPage;
import gui.MainPage;

public class MainControl {

    public MainControl(MainPage mainPage) {
        mainPage.getButtonCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate and open FactoryPage
                FactoryPage factoryPage = new FactoryPage();
                // Instantiate FactoryControl with the newly created FactoryPage
                new FactoryControl(factoryPage);
                mainPage.setNonVisible();
            }
        });

        mainPage.getButtonCustomer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate CustomerPage
                CustomerPage customerPage = new CustomerPage(Main.foodList, mainPage);
                // Instantiate CustomerControl with the newly created CustomerPage
                new CustomerControl(customerPage);
                mainPage.setNonVisible();
            }
        });
    }
}