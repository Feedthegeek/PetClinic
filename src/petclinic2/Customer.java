package petclinic2;
import java.util.ArrayList;

/**
 * This class is for a Customer's information
 * @author nicholasherrick
 */
public class Customer {
    /**
     * Initializing Constructor
     *
     * @param custID ID of Customer
     * @param name Name of Customer
     * @param dogs ArrayList of Customer's Dogs
     * @param balance Customer remaining balance
     */
    private int custID;
    private String name;
    private ArrayList<Dog> dogs = new ArrayList<>();
    private double balance;

    /**
     * Default constructor
     */
    public Customer() {
        custID = -1;
        name = "None";
        balance = 0.00;
        dogs = null;
    }
    /**
     * 
     * @param ID Customer ID
     * @param custName The name of the Customer
     * @param custBalance The remaining balance in dollars
     * @param custDogs The dogs assigned to customer
     */
    public Customer(int ID, String custName, double custBalance, ArrayList<Dog> custDogs){
        custID = ID;
        name = custName;
        balance = custBalance;
        dogs = custDogs;
        
    }
    /**
     * @return the custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(int custID) {
        this.custID = custID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dogs
     */
    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    /**
     * @param dogs the dogs to set
     */
    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * @return Printout of Customer information
     */
    public String toString(){
        return String.format("\nID# %d | %10s | Current Balance: $%.2f\n %5s\n" ,custID, name, balance, dogs.toString());
    }
    
    /**
     * @param other reference to check if ID is equal
     * @return do IDs match
     */
    public boolean equals(Object other){
        Customer temp = (Customer)other;
        return custID == temp.getCustID();
    }
}
