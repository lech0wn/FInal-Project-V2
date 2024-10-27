package src.site;

import javax.swing.*;

public class Main {

    private static final String DB_URL = "jdbc:sqlite:C:/iAcademy/Database/groupdatabase.db";

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });

        // Creates a table if there aren't any
        User.createUsersTable();
        Order.createOrdersTable();
        Sales.createSalesTable();
        Promotions.createPromotionsTable();
        Meal.createMealsTable();
        Inventory.createInventoryTable();

        //Add the required data if needed
        //User.addUser("Jarod", "A", "Admin");
//        User.addUser("Charisse", "B", "Guest");
//        User.addUser("Deniella", "C", "Leader");
//        User.addUser("Annissa", "Balaga", "Member");


        Order.addOrders("September 9, 2024", "1000 Pesos", "1", "5");
        Sales.addSales("October 21, 2024", "1", "2000 Pesos");
        Promotions.addPromotions("Buy One Take One", "1");

        // Example login attempt
        //String username = "Annissa"; // Replace with actual username input
        //String password = "Balaga"; // Replace with actual password input
        //User.authenticateUser(username, password);

        // Meal CRUD
        Meal.addMeal("Pancakes", "Yummy", "Breakfast", "Vegetarian", "Not Spicy", "500 g", "700 kcal", "1", "Flour, Milk, Pancake");
        //Meal.editMeal("Pancakes", "Fluffy and delicious", "Breakfast", "Vegetarian", "Not Spicy", "550 g", "750 kcal", "1", "Flour, Milk, Eggs", 1);
        //Meal.deleteMeal(1);
        Meal.listMeal();

        // Inventory CRUD
        Inventory.addInventory(1, 10);
        //Inventory.editInventory(1, 123);
        //Inventory.deleteInventory(1);
        Inventory.listInventory();

    }
}