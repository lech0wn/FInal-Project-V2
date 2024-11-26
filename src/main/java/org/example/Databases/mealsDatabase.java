package org.example.Databases;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
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
                "imageData BLOB);";

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
    public static void addMeals(String mealName, String description, String category, String ingredients, String dietType, String spice, String servingSize, String unit, String nutritionalValue, File imageFile) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, ingredients, dietType, spice, servingSize, unit, nutritionalValue, imageData) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals);
             FileInputStream fis = new FileInputStream(imageFile)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, ingredients);
            preparedStatement.setString(5, dietType);
            preparedStatement.setString(6, spice);
            preparedStatement.setString(7, servingSize);
            preparedStatement.setString(8, unit);
            preparedStatement.setString(9, nutritionalValue);
            preparedStatement.setBinaryStream(10, fis, (int) imageFile.length());
            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
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

            preparedStatement.setInt(1, mealId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully by ID.");
            } else {
                System.out.println("No meal found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Get Breakfast Meals to display in the Menu Page
    public static List<String[]> getBreakfastMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'breakfast'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get breakfast alphabetical meals
    public static List<String[]> getBreakfastSortedMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'breakfast'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        menu.sort(Comparator.comparing(meal -> meal[0]));

        return menu;
    }

    //Get Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients   FROM meals WHERE category = 'breakfast' AND dietType = 'vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Breakfast Meals
    public static List<String[]> getBreakfastNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'breakfast' AND dietType = 'non-vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Lunch Meals to display in the Menu Page
    public static List<String[]> getLunchMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'lunch'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get lunch alphabetical meals
    public static List<String[]> getLunchSortedMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'lunch'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        menu.sort(Comparator.comparing(meal -> meal[0]));

        return menu;
    }

    //Get Vegetarian Lunch Meals
    public static List<String[]> getLunchVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'lunch' AND dietType = 'vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Lunch Meals
    public static List<String[]> getLunchNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'lunch' AND dietType = 'non-vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }


    //Get Dinner Meals to display in the Menu Page
    public static List<String[]> getDinnerMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'dinner'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get dinner alphabetical meals
    public static List<String[]> getDinnerSortedMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'dinner'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        menu.sort(Comparator.comparing(meal -> meal[0]));

        return menu;
    }

    //Get Vegetarian Dinner Meals
    public static List<String[]> getDinnerVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'dinner' AND dietType = 'vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    //Get Non Vegetarian Dinner Meals
    public static List<String[]> getDinnerNonVegetarianMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients FROM meals WHERE category = 'dinner' AND dietType = 'non-vegetarian'";

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
                menu.add(new String[]{mealName, mealId, description, nutritionalValue, spice, servingSize, unit, dietType, ingredients});
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

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully by name.");
            } else {
                System.out.println("No meal found with the specified name.");
            }

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

    public static boolean isMealAvailable(String mealId) {
        String query = "SELECT quantity FROM Inventory WHERE mealId = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, mealId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int quantity = resultSet.getInt("quantity");

                    return quantity > 0;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] getMealByName(String mealName) {
        String[] menu = null;
        String query = "SELECT * FROM meals WHERE LOWER(mealName) = LOWER(?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, mealName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int mealId = resultSet.getInt("mealId");
                String name = resultSet.getString("mealName");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                String ingredients = resultSet.getString("ingredients");
                String dietType = resultSet.getString("dietType");
                String spice = resultSet.getString("spice");
                String servingSize = resultSet.getString("servingSize");
                String unit = resultSet.getString("unit");
                String nutritionalValue = resultSet.getString("nutritionalValue");

                menu = new String[] { name, String.valueOf(mealId), description, category, ingredients, dietType, spice, servingSize, unit, nutritionalValue};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public static byte[] getImageForMeal(String mealId) {
        String sql = "SELECT imageData FROM meals WHERE mealId = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, mealId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBytes("imageData"); // Get the binary data as a byte array
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no image is found
    }
}
