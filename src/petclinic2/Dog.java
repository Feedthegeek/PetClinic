package petclinic2;

/**
 * This class is for a Dog's information
 * @author nicholasherrick
 */
public class Dog {

    /**
     * Initializing Constructor
     *
     * @param name Name of dog
     * @param breed Breed of dog
     * @param weight Weight of dog
     */
    private String name;
    private String breed;
    private double weight;

    /**
     * Default Constructor
     */
    public Dog() {
        name = "None";
        breed = "None";
        weight = -1;
    }

    /**
     * Parameterized Constructor
     * @param dogName  Name of dog
     * @param dogBreed Breed of dog
     * @param dogWeight Weight of dog
     */
    
    public Dog(String dogName, String dogBreed, double dogWeight) {
        name = dogName;
        breed = dogBreed;
        weight = dogWeight;
    }

   

    /**
     * @return dog name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name dog name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return dog breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed dog breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return dog weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight dog weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /**
     * 
     * @return formatted printout out of Dog information
     */
     public String toString() {
               return String.format("\n%-10s | %12s | %10.2f\n", name, breed, weight);
    }
    
}
