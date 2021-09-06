    
public class Monkey extends RescueAnimal{
    // Instance variables
	private double tailLength;
	private double height;
	private double bodyLength;
	private String species;
	
	// Default Constructor
	public Monkey(String name, String gender, int age,
    double weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, double tailLength, 
    double height, double bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
		setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
	}
	
	// Mutators and Accessors
	
	// Tail Length
	public void setTailLength(double tailLength ) {
		this.tailLength = tailLength;
	}
  
	public double getTailLength() {
		return tailLength;
	}
	
	// Height
	public void setHeight(double height) {
		this.height= height;
	}
  
	public double getHeight() {
		return height;
	}	
	
	// Body Length
	public void setBodyLength(double bodyLength ) {
		this.bodyLength = bodyLength;
	}
  
	public double getBodyLength() {
		return bodyLength;
	}
	
	// Species
	public void setSpecies(String species) {
		this.species = species;
	}
  
	public String getSpecies() {
		return species;
	}

	
} 
  



