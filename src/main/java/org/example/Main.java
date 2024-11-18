package org.example;

import org.example.Databases.mealsDatabase;

import javax.swing.*;

public class Main {
    public static  void main (String[] args) {

        System.out.println("All meals: " + mealsDatabase.getMeals());
        System.out.println("Vegetarian meals: " + mealsDatabase.getVegetarianMeals());
        System.out.println("Non-Vegetarian meals: " + mealsDatabase.getNonVegetarianMeals());

        JFrame frame = new JFrame();
        new LoginPage(frame);
    }
}
