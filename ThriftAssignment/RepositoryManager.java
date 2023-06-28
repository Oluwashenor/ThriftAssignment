import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class RepositoryManager {
	  String url = "jdbc:mysql://localhost:3306/java";
      String username = "root";
      String password = "";

      public void saveUser(String name, String email) {
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
              String sql = "INSERT INTO thrift (name, email) VALUES (?, ?)";
              PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1, name);
              statement.setString(2, email);
              int rowsInserted = statement.executeUpdate();
              if (rowsInserted > 0) {
                  System.out.println("User inserted successfully!");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      
      public User addMoney (int id, float amount) {
    	  User updatedRow = null;
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	  
        	  String selectSql = "SELECT * FROM thrift WHERE id = ?";
              PreparedStatement selectStatement = connection.prepareStatement(selectSql);
              selectStatement.setInt(1, id);
              ResultSet resultSet = selectStatement.executeQuery();
              if (resultSet.next()) {
            	  amount = amount + resultSet.getFloat("amount");   
              }
        	  String sql = "UPDATE thrift SET amount = ? WHERE id = ?";
        	  PreparedStatement statement = connection.prepareStatement(sql);
        	  statement.setFloat(1, amount);
        	  statement.setInt(2, id);
              int rowsInserted = statement.executeUpdate();
              if (rowsInserted > 0) {
                  System.out.println("Amount Added Successfully!");
                  // Retrieve the updated row
                  String selectSql2 = "SELECT * FROM thrift WHERE id = ?";
                  PreparedStatement selectStatement2 = connection.prepareStatement(selectSql2);
                  selectStatement2.setInt(1, id);
                  resultSet = selectStatement.executeQuery();
                  if (resultSet.next()) {
                      updatedRow = new User();
                      updatedRow.setName(resultSet.getString("name"));
                      updatedRow.setAmount(resultSet.getFloat("amount"));
                      // Add other columns as needed
                  }
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return updatedRow;
      }
      
      public User removeMoney (int id, float amount) {
    	  User updatedRow = null;
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	  
        	  String selectSql = "SELECT * FROM thrift WHERE id = ?";
              PreparedStatement selectStatement = connection.prepareStatement(selectSql);
              selectStatement.setInt(1, id);
              ResultSet resultSet = selectStatement.executeQuery();
              if (resultSet.next()) {
            	  if(amount > resultSet.getFloat("amount")) {
            		  System.out.println("Insuffcient Funds!");
            		  return null;
            	  }
            	  amount = resultSet.getFloat("amount") - amount;   
              }
        	  String sql = "UPDATE thrift SET amount = ? WHERE id = ?";
        	  PreparedStatement statement = connection.prepareStatement(sql);
        	  statement.setFloat(1, amount);
        	  statement.setInt(2, id);
              int rowsInserted = statement.executeUpdate();
              if (rowsInserted > 0) {
                  System.out.println("Amount Wthdrawn Successfully!");
                  // Retrieve the updated row
                  String selectSql2 = "SELECT * FROM thrift WHERE id = ?";
                  PreparedStatement selectStatement2 = connection.prepareStatement(selectSql2);
                  selectStatement2.setInt(1, id);
                  resultSet = selectStatement.executeQuery();
                  if (resultSet.next()) {
                      updatedRow = new User();
                      updatedRow.setName(resultSet.getString("name"));
                      updatedRow.setAmount(resultSet.getFloat("amount"));
                      // Add other columns as needed
                  }
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return updatedRow;
      }

      
      
      public User balance(int id) {
    	  User updatedRow = null;
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	  
        	  String selectSql = "SELECT * FROM thrift WHERE id = ?";
              PreparedStatement selectStatement = connection.prepareStatement(selectSql);
              selectStatement.setInt(1, id);
              ResultSet resultSet = selectStatement.executeQuery();
              if (resultSet.next()) {
            	  updatedRow = new User();
                  updatedRow.setName(resultSet.getString("name"));
                  updatedRow.setAmount(resultSet.getFloat("amount"));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return updatedRow;
      }
      
      public User getUser(int id) {
    	  User updatedRow = null;
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	  
        	  String selectSql = "SELECT * FROM thrift WHERE id = ?";
              PreparedStatement selectStatement = connection.prepareStatement(selectSql);
              selectStatement.setInt(1, id);
              ResultSet resultSet = selectStatement.executeQuery();
              if (resultSet.next()) {
            	  updatedRow = new User();
                  updatedRow.setName(resultSet.getString("name"));
                  updatedRow.setAmount(resultSet.getFloat("amount"));
                  System.out.println(resultSet.getInt("id") + " --- " + resultSet.getString("name") + " --- " +resultSet.getFloat("amount"));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return updatedRow;
      }

      public User getUsers() {
    	  User updatedRow = null;
    	  List<User> users = new ArrayList<User>();
          try (Connection connection = DriverManager.getConnection(url, username, password)) {
        	  
        	  String selectSql = "SELECT * FROM thrift";
              PreparedStatement selectStatement = connection.prepareStatement(selectSql);
             
              ResultSet resultSet = selectStatement.executeQuery();
              System.out.println(resultSet);
              while (resultSet.next()) {
            	  updatedRow = new User();
                  updatedRow.setName(resultSet.getString("name"));
                  updatedRow.setAmount(resultSet.getFloat("amount"));
                  System.out.println(resultSet.getInt("id") + " --- " + resultSet.getString("name") + " --- " +resultSet.getFloat("amount"));
                  users.add(updatedRow);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return updatedRow;
      }

  }
