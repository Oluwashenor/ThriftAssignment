import java.sql.*;
import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 
		 while (true) {
	            displayOptions();

	            int option = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (option) {
	                case 1:
	                    createNewAccount(scanner);
	                    break;
	                case 2:
	                    updateAccount(scanner);
	                    break;
	                case 3:
	                    getBalance(scanner);
	                    break;
	                case 4:
	                	withdraw(scanner);
	                    break;
	                case 5:
	                	getUser(scanner);
	                    break;
	                case 6:
	                	getUsers(scanner);
	                    break;
	                case 7:
	                    System.out.println("Exiting the program. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
		 
		 
	}
	
	private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Create a new account");
        System.out.println("2. Update Account");
        System.out.println("3. Get Balance");
        System.out.println("4. Widthdraw Money");
        System.out.println("5. Get User");
        System.out.println("6. Get All Users");
        System.out.println("7. Exit");
        System.out.print("Enter your option: ");
    }

    private static void createNewAccount(Scanner scanner) {
        System.out.println("Creating a new account...");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        RepositoryManager database = new RepositoryManager();
        database.saveUser(name, email);

        // Perform account creation logic here (e.g., saving to database, etc.)
        System.out.println("Account created successfully!");
    } 
    
    private static void updateAccount(Scanner scanner) {
        System.out.println("Trying to addmoney into your account.");

        System.out.print("Enter user's id: ");
        int id = scanner.nextInt();

        System.out.print("Enter amount in figures: ");
        float amount = scanner.nextFloat();
        
        RepositoryManager database = new RepositoryManager();
        User user = database.addMoney(id, amount);
        System.out.println(user.getAmount());
    }
    
    private static void getBalance(Scanner scanner) {
        System.out.println("Fetching your balance...");
        System.out.print("Enter user's id: ");
        int id = scanner.nextInt();
        RepositoryManager database = new RepositoryManager();
        User user = database.balance(id);
        System.out.println(user.getAmount());
    }
    
    private static void withdraw(Scanner scanner) {
        System.out.println("Widthdrawing............");

        System.out.print("Enter user's id: ");
        int id = scanner.nextInt();
        
        System.out.print("Enter amount in figures: ");
        float amount = scanner.nextFloat();
        
        RepositoryManager database = new RepositoryManager();
        User user = database.removeMoney(id,amount);
        System.out.println(user.getAmount());
    }
    
    private static void getUser(Scanner scanner) {
        System.out.println("Getting User............");
        System.out.print("Enter user's id: ");
        int id = scanner.nextInt();
        RepositoryManager database = new RepositoryManager();
        User user = database.getUser(id);
    }

    private static void getUsers(Scanner scanner) {
        System.out.println("Getting Users............");

        RepositoryManager database = new RepositoryManager();
        User user = database.getUsers();
    }
}
