import java.sql.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated  method stub
		 System.out.println("Hello, World!");
	        String url = "jdbc:mysql://localhost:3306/java";
	        String username = "root";
	        String password = "";

	        Person person = new Person("John Doe", 25);

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            // Create the SQL INSERT statement
	            String sql = "INSERT INTO persons (name, age) VALUES (?, ?)";

	            // Create a prepared statement
	            PreparedStatement statement = connection.prepareStatement(sql);

	            // Set the parameter values from the object
	            statement.setString(1, person.getName());
	            statement.setInt(2, person.getAge());

	            // Execute the INSERT statement
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Record inserted successfully!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
