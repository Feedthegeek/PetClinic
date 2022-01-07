/*
 * Pet Clinic Program for CSCI 110
 * I pledge that this program is of my own hand.
 * Author: Nicholas Herrick 
 * Due Date: 12/17/21
 */
package petclinic2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program retrieves input from user to check and update balances owed for
 * procedures done at a veterinary clinic.
 *
 * @author nicholasherrick
 */
public class PetClinic2 {

    /**
     * @param args the command line arguments
     * @throws IOException if file can not be read
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();

        Scanner inFS = null;                            // File Scanner
        Scanner dogScan = null;                         // String Scanner for string dogInfo
        Scanner scan = new Scanner(System.in);          // Scanner for user input
        FileInputStream fileInput = null;               // InputStream for Scanner InFS
        String dogInfo, dogName, dogBreed, custName;    // dogInfo for storing string to be parsed by dogScan
        int custID = -1;                                // Customer ID initialized 
        int pNum;                                       // Procedure Number
        double custBalance, dogWeight;                  // Customer Balance, Dog Weight
        Customer c;                                     // Customer helper object

        // Attempt to open file
        fileInput = new FileInputStream("customers.txt");
        inFS = new Scanner(fileInput);

        // Check if file hasNext 
        // Parse customer and dog information from file
        // Build ArrayLists for customers and custDogs
        while (inFS.hasNext()) {
            Dog tempDog;
            ArrayList<Dog> custDogs = new ArrayList<>();
            custID = inFS.nextInt();
            custName = inFS.nextLine().replaceFirst(" ", "");
            dogInfo = inFS.nextLine();
            custBalance = inFS.nextDouble();

            dogScan = new Scanner(dogInfo);
            // Check if dogScan hasNext
            while (dogScan.hasNext()) {     // Parse dog information from dogScan
                dogName = dogScan.next();   // and build tempDog for appending to ArrayList
                dogBreed = dogScan.next().replace('_', ' ');
                dogWeight = dogScan.nextDouble();
                tempDog = new Dog(dogName, dogBreed, dogWeight);
                custDogs.add(tempDog);

            }
            // Construct Customer, pass Dogs and append to ArrayList
            c = new Customer(custID, custName, custBalance, custDogs);
            customers.add(c);

        }
        fileInput.close();

        display(customers); // Display file contents

        System.out.println("Please enter customer ID number: (0 to end) ");
        custID = scan.nextInt();
        while (custID != 0) {
        
        int i = searchCustID(customers, custID); // Check if ID matches
            if (i >= 0) {
                System.out.println("Please enter the dog's name: ");
                dogName = scan.next();
                // Search to determine if dogName matches
                if (searchByName(customers.get(i).getDogs(), dogName) >= 0) {
                    System.out.printf("Enter procedure number (1-4):\n");
                    pNum = scan.nextInt(); // Get procedure number and pass to methods
                    System.out.printf("You have selected %s\n", getProcedureName(pNum - 1));
                    System.out.printf("The charge for that procedure is $%.2f\n", getCharge(pNum - 1));
                    customers.get(i).setBalance(customers.get(i).getBalance() + getCharge(pNum - 1));
                    System.out.printf("Your balance is now $%.2f.\n", customers.get(i).getBalance());
                    System.out.println("Please enter customer ID number: (0 to end) ");
                    custID = scan.nextInt();
                    
                } else {
                    System.out.printf("Dog named %s could not be found for customer %s.\n", dogName, customers.get(i).getName());
                }
               
            } else { System.out.printf("Customer ID %d could not be found, please enter a valid ID number (0 to quit).\n", custID);
                custID = scan.nextInt();
            }
        }
        scan.close();
        // Display file contents at end of user entries
        display(customers);

    }
    
    /**
     *
     * @param procedureNumber array of values for charge of procedures
     * @return charge value for charge[procedureNumber]
     */
    public static double getCharge(int procedureNumber) {
        double[] charge = new double[4];
        charge[0] = 45.00;
        charge[1] = 75.00;
        charge[2] = 50.00;
        charge[3] = 250.00;
        if (procedureNumber >= 0) {
            return charge[procedureNumber];
        }
        return 0;
    }

    /**
     *
     * @param procedureNumber store of procedures in array
     * @return index of procedure passed to method
     */
    public static String getProcedureName(int procedureNumber) {

        String[] procedures = new String[4];
        procedures[0] = "Wellness Check";
        procedures[1] = "Overnight Visit";
        procedures[2] = "X Rays";
        procedures[3] = "Surgery";

        if (procedureNumber >= 0) {
            return procedures[procedureNumber];
        }
        return "That procedure number is not found.";
    }

    /**
     *
     * @param cust array list of customers
     * @param target custID to be searched for
     * @return index if found, else -1
     */
    public static int searchCustID(ArrayList<Customer> cust, int target) {
        for (int i = 0; i < cust.size(); i++) {
            if (cust.get(i).getCustID() == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param theDogs ArrayList dogs from customer for target
     * @param target is target
     * @return i if found, else -1
     */
    public static int searchByName(ArrayList<Dog> theDogs, String target) {
        for (int i = 0; i < theDogs.size(); i++) {
            if (theDogs.get(i).getName().equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param customer displays formatted toString of customer
     */
    public static void display(ArrayList<Customer> customer) {
        System.out.printf("%s\n", customer.toString().replace("[", "").replace("]", "")
                .replace(",", ""));
    }
}
