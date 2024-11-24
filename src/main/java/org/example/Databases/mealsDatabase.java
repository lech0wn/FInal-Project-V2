package org.example.Databases;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mealsDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    //Create Meals Table
    public static void createMealsTable() {
        String mealsSql= "CREATE TABLE IF NOT EXISTS meals (" +
                "mealId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mealName TEXT, " +
                "description TEXT, " +
                "category TEXT, " +
                "ingredients TEXT, " +
                "dietType TEXT, " +
                "spice TEXT, " +
                "servingSize TEXT, " +
                "unit TEXT, " +
                "nutritionalValue TEXT, " +
                "imagePath TEXT);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(mealsSql);
                System.out.println("Meals table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Add Meals
    public static void addMeals(String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String unit, String nutritionalValue, String imagePath) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, ingredients, dietType, spice, servingSize, unit, nutritionalValue, imagePath) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, ingredients);
            preparedStatement.setString(5, dietType);
            preparedStatement.setString(6, spice);
            preparedStatement.setString(7, servingSize);
            preparedStatement.setString(8, unit);
            preparedStatement.setString(9, nutritionalValue);
            preparedStatement.setString(10, imagePath);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Update Meals
    public static void updateMeals (String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String nutritionalValue) {
        String updateMeals = "UPDATE meals SET description = ?, category = ?, ingredients = ?, dietType = ?, spice = ?, servingSize = ?, nutritionalValue = ? WHERE mealName = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(updateMeals)) {

            preparedStatement.setString(1, description);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3, ingredients);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spice);
            preparedStatement.setString(6, servingSize);
            preparedStatement.setString(7, nutritionalValue);
            preparedStatement.setString(8, mealName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete Meals
    public static void deleteMeal(int mealId) {
        String deleteSQL = "DELETE FROM Meals WHERE mealId = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            if (connection!=null) {
                System.out.println("Meal deleted successfully");
            }

            preparedStatement.setInt(1, mealId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully");
            } else {
                System.out.println("Meal does not exist.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Get Breakfast Meals to display in the Menu Page
    public static List<String[]> getBreakfastMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'breakfast'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'breakfast' AND dietType = 'vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'breakfast' AND dietType = 'non-vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Lunch Meals to display in the Menu Page
    public static List<String[]> getLunchMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'lunch'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Vegetarian Lunch Meals
    public static List<String[]> getLunchVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'lunch' AND dietType = 'vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Lunch Meals
    public static List<String[]> getLunchNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'lunch' AND dietType = 'non-vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }


    //Get Dinner Meals to display in the Menu Page
    public static List<String[]> getDinnerMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'dinner'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Vegetarian Dinner Meals
    public static List<String[]> getDinnerVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'dinner' AND dietType = 'vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Dinner Meals
    public static List<String[]> getDinnerNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, imagePath   FROM meals WHERE category = 'dinner' AND dietType = 'non-vegetarian'";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String mealId = resultSet.getString("mealId");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");
                String img = resultSet.getString("imagePath");
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients, img});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    public static void deleteMealByName(String mealName) {
        String deleteSQL = "DELETE FROM Meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            preparedStatement.setString(1, mealName);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Authenticate if the meal exists
    public static boolean authenticateMealName(String mealName) {
        String selectSQL = "SELECT * FROM meals WHERE mealName = ?";
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, mealName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
