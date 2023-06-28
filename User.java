
public class User {
	private String name;
    private String role;
    private int id;
    private float amount;

//    public User(String name, String role, int Id, float Amount) {
//        this.name = name;
//        this.role = role;
//        this.id = Id;
//        this.amount = Amount;
//    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
    public float getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }
    
    public void setName(String newName) {
    	name= newName;
    }
    
    public void setAmount(float newAmount) {
    	amount= newAmount;
    }
}
