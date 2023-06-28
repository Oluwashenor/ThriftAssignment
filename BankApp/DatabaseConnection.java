import java.sql.*;
import java.util.Random;


public class DatabaseConnection {
	  String url = "jdbc:mysql://localhost:3306/java";
      String username = "root";
      String password = "";
      

public void createAccount(String name, String email, int pin) {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
    	
        String sql = "INSERT INTO bank (name, email, pin) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setInt(3, pin);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Account Created successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public int generateAccount() {
	int numberOfDigits = 5;
    int minRange = (int) Math.pow(10, numberOfDigits - 1);  // Minimum range for 5 digits is 10,000
    int maxRange = (int) Math.pow(10, numberOfDigits) - 1;  // Maximum range for 5 digits is 99,999
    
    Random random = new Random();
    int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

}
}

