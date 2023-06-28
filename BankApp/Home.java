import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner scanner = new Scanner(System.in);
		 
		 while (true) {
	            displayOptions();

	            int option = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (option) {
	                case 1:
	                	createAccount(scanner);
	                    break;
//	                case 2:
//	                    updateAccount(scanner);
//	                    break;
//	                case 3:
//	                    getBalance(scanner);
//	                    break;
//	                case 4:
//	                	withdraw(scanner);
//	                    break;
//	                case 5:
//	                	getUser(scanner);
//	                    break;
//	                case 6:
//	                	getUsers(scanner);
//	                    break;
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
        System.out.println("2. Deposit");
        System.out.println("3. Get Balance");
        System.out.println("4. Widthdraw Money");
        System.out.println("5. Get User");
        System.out.println("7. Exit");
        System.out.print("Enter your option: ");
    }
	
	private static void createAccount(Scanner scanner) {
        System.out.println("Creating a new account...");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        
        DatabaseConnection database = new DatabaseConnection();
        database.createAccount(name, email, pin);

        // Perform account creation logic here (e.g., saving to database, etc.)
        System.out.println("Account created successfully!");
    } 

}
