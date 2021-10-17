import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static ArrayList<String> monkeySpeciesList = new ArrayList<String>() {
        {
            add("capuchin");
            add("guenon");
            add("macaque");
            add("marmoset");
            add("squirrel monkey");
            add("tamarin");
        }
    };

    // Instance variables (if needed)
    
    private static String name = "none";
    private static String breed = "none";
    private static String gender = "none";
    private static int age = 0;
    private static double weight = 0.0;
    private static String acquisitionDate = "none";
    private static String acquisitionCountry = "none";
    private static String trainingStatus = "none";
    private static boolean reserved = false;
    private static String inServiceCountry = "none";
    private static double tailLength = 0.0;
    private static double height = 0.0;
    private static double bodyLength = 0.0;
    private static String species = "none";

    private static ArrayList<Dog> availableDogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> availableMonkeyList = new ArrayList<Monkey>();
    private static int numberAvailableDogs;
    private static int numberAvailableMonkeys;
  

    public static void main(String[] args) {
        String userInput;
        Scanner scnr = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        displayMenu();

        do {
            
            userInput = scnr.nextLine();

            switch (userInput) {

                case "1" : intakeNewDog(scnr);
                break;
                    
                case "2": intakeNewMonkey(scnr);
                break;
                
                case "3": reserveAnimal(scnr);
                break;
                
                case "4": printAnimals("dog");
                break;
                    
                case "5": printAnimals("monkey");
                break;

                case "6": printAnimals("available");
                break;
                
                case "q": System.out.print("Exitting System...");
                break;
                
                default: System.out.println("Enter a valid menu choice.");
            
            }

            System.out.println("\nPress Enter to continue...");    
            scnr.nextLine();   // waits for enter to be pressed
            displayMenu();
            
        } while (!userInput.equalsIgnoreCase("q"));
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are available");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", 1, 25.6, "05-12-2019", "United States", "in service", false,
                "Canada");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", 3, 35.2, "02-03-2020", "United States", "in service", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", 4, 25.6, "12-12-2019", "Canada", "in service", false,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Monk", "male", 1, 25.6, "05-12-2019", "united states", "in service", false, "united states", 14.2, 25.6, 30.0, "capuchin" );
        Monkey monkey2 = new Monkey("Chimp", "male", 3, 35.2, "02-03-2020", "united states", "in service", false, "united states", 30.0, 5.6, 19.8, "squirrel monkey");
        Monkey monkey3 = new Monkey("Alex", "female", 4, 25.6, "12-12-2019", "canada", "in service", false, "Canada", 44.2, 15.6, 22.1, "tamarin");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    public static void intakeNewDog(Scanner scanner) {
        
        // Takes user input for new dog's information
        String animalType = "dog";
        String testVar;
        String testType;

        // Name
        testVar = "Name";    
        testType = "letter";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // checks if this dog is a new dog    
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system.");
                return; // returns to menu
            }    
        }

        // Breed     
        testVar = "Breed";      
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // Gender
        testVar ="Gender";
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Age
        testVar = "Age";    
        testType = "integer";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        scanner.nextLine();    // reads newline character after age input

        // Weight
        testVar = "Weight";
        testType = "number";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // Acquistion Date
        testVar = "Acquisition date";
        testType = "date";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Acquisition Country
        testVar = "Acquisition country";    
        testType = "letter";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // Training status
        testVar = "Training status";    
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
                
        // Service Country  
        testVar = "Service country";
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // If made this far, dog is not a duplicate and can be added to the system
        // Add the code to instantiate a new dog and add it to the appropriate list
                
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
        reserved, inServiceCountry);
        dogList.add(newDog);
        
        System.out.println("\n" + name + " has been added to our system.");
    }

    public static void intakeNewMonkey(Scanner scanner) {
        // Takes user input for new monkey's information
        
        String animalType = "monkey";
        String testVar = " ";
        String testType = " ";

        // Name
        testVar = "Name";    
        testType = "letter";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // checks if this monkey is a new monkey   
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey is already in our system.");
                return; // returns to menu
            }    
        }
    
        //  Species
        testVar = "Species";    
        testType = "letter";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // Gender
        testVar ="Gender";
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Age
        testVar = "Age";    
        testType = "integer";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        scanner.nextLine();  // reads newline character after age input

        // Weight
        testVar = "Weight";
        testType = "number";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);       

        // Acquistion Date
        testVar = "Acquisition date";
        // testType not needed since date has its own format type
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // Acquisition Country
        testVar = "Acquisition country";    
        testType = "letter";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Tail Length
        testVar = "Tail length";    
        testType = "number";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Height   
        testVar = "Height";    
        testType = "number";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
        
        // Body Length
        testVar = "Body length";    
        testType = "number";   
        askUserForInputUntilValid(scanner, testVar, testType, animalType); 
        scanner.nextLine(); // reads newline character after body length input
        
        // Training status
        testVar = "Training status";    
        testType = "letter"; 
        askUserForInputUntilValid(scanner, testVar, testType, animalType);
         
        // Service Country  
        testVar = "Service country";
        testType = "letter";
        askUserForInputUntilValid(scanner, testVar, testType, animalType);

        // If made this far, dog is not a duplicate and can be added to the system
        // Add the code to instantiate a new monkey and add it to the appropriate list
        Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
        reserved, inServiceCountry, tailLength, height, bodyLength, species);
        monkeyList.add(newMonkey);
        
        System.out.println("\n" + name + " has been added to our system.");
    }
    

    public static void reserveAnimal(Scanner scanner) {
        boolean validAnimalType = false;
        int choice = 0;
        String inputType;
        String inputCountry;
        boolean validNumberChoice = false;

        do {
            // gets animal type from user
            
            System.out.println("Would you like to reserve a monkey or a dog?");
            inputType = scanner.nextLine();

            
            if (inputType.equalsIgnoreCase("dog")) {
                validAnimalType = true;

                // gets service country from user
                System.out.println("What country would you like this dog to be serviced in?");
                inputCountry = scanner.nextLine();
                
                // Prints formatted headers for dogs' info
                System.out.printf("%-5s %-11s %-16s %-10s %-8s %-10s %-15s %-16s  %-19s %-10s %6s \n","No.", "Name", "Breed", "Gender", "Age", "Weight", "Acq. Date", "Acq. Location", "Training Status", "Reserved", "Service Location");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                // prints available dogs given the specefic inputCountry
                printAvailableDogList(inputCountry, "specefic");
               
                
                if (numberAvailableDogs > 0) {    
                    System.out.println("\nEnter the number correspnding to the dog you want to reserve.");

                    // keep asking user for input choice until choice is a number. Strings and doubles are not allowed
                    do {
                        if (scanner.hasNextInt()) {
                            choice = scanner.nextInt();
                            validNumberChoice = true;

                            // keep asking for user choice until choice number is within range
                            while(!(0 < choice && choice <= numberAvailableDogs)) {
                                System.out.println("\nThis is not a valid choice.\n"
                                                +"Please try again.\n"
                                                + "\nEnter the number correspnding to the dog you want to reserve.");
                                
                                if (scanner.hasNextInt())
                                    choice = scanner.nextInt();
                                else {
                                    choice = -1; // sets choice outside of range of availableDogsList if a non int type is entered as input

                                    scanner.nextLine(); // reads newline and waits for input on next line
                                }
                            }   
                        }

                        else {
                            System.out.println("\nThis is not a valid choice.\n"
                                                +"Please try again.\n"
                                                + "\nEnter the number correspnding to the dog you want to reserve.");
                            scanner.nextLine();
                        } 
                    } while(!validNumberChoice);


                    // reserves dog at index chosen by user and then removes the dog from the list of available dogs
                    Dog chosenDog = availableDogList.get(choice-1);
                    chosenDog.setReserved(true);
                    System.out.println("\nYou have reserved " + chosenDog.getName() + "!");
                    availableDogList.clear(); // clear out availableDogList to prevent duplicates from being added if printAvailableDogList is called again
                    
                    // reads newline character after int choice input
                    scanner.nextLine(); 
                }
            }

            else if (inputType.equalsIgnoreCase("monkey")) {
                validAnimalType = true;
                validNumberChoice = false;
                // gets service country from user
                System.out.println("What country would you like this monkey to be serviced in?");
                inputCountry = scanner.nextLine();
                
                // Prints formatted headers for monkeys' info
                System.out.printf("%-5s %-9s %-18s %-11s %-8s %-10s %-14s %-10s %-15s %-15s %-16s %-19s %-10s %6s \n","No.", "Name", "Species", "Gender", "Age", "Weight", "Tail Length", "Height","Body Length", "Acq. Date", "Acq. Location", "Training Status", "Reserved", "Service Location");
                System.out.println
                ("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                // prints available monkeys given the specefic inputCountry
                printAvailableMonkeyList(inputCountry, "specefic");
               
                if (numberAvailableMonkeys > 0) {
                    
                    System.out.println("\nEnter the number correspnding to the monkey you want to reserve.");

                    // keep asking user for input choice until choice is a number. Strings are not allowed
                    do {
                        if (scanner.hasNextInt()) {
                            choice = scanner.nextInt();
                            validNumberChoice = true;

                            // keep asking for user choice until choice number is within range
                            while(!(0 < choice && choice <= numberAvailableMonkeys)) {
                                System.out.println("\nThis is not a valid choice.\n"
                                                +"Please try again.\n"
                                                + "\nEnter the number correspnding to the monkey you want to reserve.");
                                
                                if (scanner.hasNextInt())
                                    choice = scanner.nextInt();
                                else {
                                    choice = -1; // sets choice outside of range of availableMonkeyList if a non int type is entered as input
                                    
                                    scanner.nextLine(); // reads newline and waits for input on next line
                                }
                            }   
                        }

                        else {
                            System.out.println("\nThis is not a valid choice.\n"
                                                +"Please try again.\n"
                                                + "\nEnter the number correspnding to the monkey you want to reserve.");
                            scanner.nextLine();
                        } 
                    } while(!validNumberChoice);


                    // reserves monkey at index chosen by user and then removes the dog from the list of available dogs
                    Monkey chosenMonkey = availableMonkeyList.get(choice-1);
                    chosenMonkey.setReserved(true);
                    System.out.println("\nYou have reserved " + chosenMonkey.getName() + "!");
                    availableMonkeyList.clear(); // clear out availableMonkeyList to prevent duplicates from being added if printAvailableMonkeyList is called again
                    
                    // reads newline character after int choice input
                    scanner.nextLine(); 
                }
            }

            else     
                System.out.println("\nEnter either monkey or dog.\n");
            
        } while (!validAnimalType);   
    }
    
    public static void printAnimals(String listType) {
        // print dog list
        if (listType.equals("dog")) 
            printAllDogs("all");

        // print monkey list
        else if (listType.equals("monkey")) 
            printAllMonkeys("all");                                                     

        // print available list
        else if (listType.equals("available")) {
            System.out.println("Available Dogs:\n\n" );
            printAllDogs("available");
            System.out.println("\n\nAvailable Monkeys:\n");
            printAllMonkeys("available");
        }
    }

    public static void printAllDogs(String listType) {
        int i = 0;

        // Prints formatted headers for dogs' info
        System.out.printf("%-5s %-11s %-16s %-10s %-8s %-10s %-15s %-16s  %-19s %-10s %6s \n","No.", "Name", "Breed", "Gender", "Age", "Weight", "Acq. Date", "Acq. Location", "Training Status", "Reserved", "Service Location");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        if (listType.equals("all")) {
            for (Dog dog : dogList) {
                ++i;
                
                System.out.printf("#" + i + "|   " + "%-10s %-18s %-10s %-8d %-10.2f %-15s %-16s %-19s %-10s %6s",
                                    dog.getName(), dog.getBreed(), dog.getGender(),dog.getAge(), dog.getWeight(), dog.getAcquisitionDate(), dog.getAcquisitionLocation(), dog.getTrainingStatus(), dog.getReserved(), dog.getInServiceLocation() +"\n");

            }
        }
        
        else if (listType.equals("available")) {
            printAvailableDogList("", "all");

            
        }

        
    }

    public static void printAllMonkeys(String listType) {
        int i=0;
        
        // Prints formatted headers for monkeys' info
        System.out.printf("%-5s %-9s %-18s %-11s %-8s %-10s %-14s %-10s %-15s %-15s %-16s %-19s %-10s %6s \n","No.", "Name", "Species", "Gender", "Age", "Weight", "Tail Length", "Height","Body Length", "Acq. Date", "Acq. Location", "Training Status", "Reserved", "Service Location");
        System.out.println
        ("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if (listType.equals("all")) {
            for (Monkey monkey : monkeyList) {
                ++i;
                System.out.printf("#" + i + "|   " + "%-10s %-18s %-10s %-8d %-10.2f %-14.2f %-10.2f %-15.2f %-15s %-16s  %-19s %-10s %6s",
                                    monkey.getName(), monkey.getSpecies(), monkey.getGender(),monkey.getAge(), monkey.getWeight(), monkey.getTailLength(), monkey.getHeight(), monkey.getBodyLength(), monkey.getAcquisitionDate(), monkey.getAcquisitionLocation(), monkey.getTrainingStatus(), monkey.getReserved(), monkey.getInServiceLocation() +"\n");
            }
        }

        else if (listType.equals("available")) {
            printAvailableMonkeyList("", "all");
            
        }
    }
    
    public static void printAvailableDogList(String country, String countryType) {
        boolean inCountry = true;
        int i = 0;
        // Adds dog to a temp list if it is available.
        // The temp list will be printed to the user once printAllDogs("available") is called

        availableDogList.clear();
        // Handles which dogs from the dog list will be added to the available dog list. 
        for (Dog dog : dogList) {
            
            if (countryType.equals("specefic")) // if reserveAnimal() is called
                inCountry = dog.getInServiceLocation().equalsIgnoreCase(country);

            else if (countryType.equals("all")) // if printAllAnimals() is called
                inCountry = true;

            if (inCountry &&
                dog.getTrainingStatus().equalsIgnoreCase("in service") &&
                dog.getReserved() == false) {
             
                availableDogList.add(dog);
            }
        }

        if (!availableDogList.isEmpty()) {
              
            // Prints the dogs in the available dog list
            for (Dog dog : availableDogList) {
                ++i;
                
                // Prints dogs' info
                System.out.printf("#" + i + "|   " + "%-10s %-18s %-10s %-8d %-10.2f %-15s %-16s %-19s %-10s %6s",
                                    dog.getName(), dog.getBreed(), dog.getGender(),dog.getAge(), dog.getWeight(), dog.getAcquisitionDate(), dog.getAcquisitionLocation(), dog.getTrainingStatus(), dog.getReserved(), dog.getInServiceLocation() +"\n");
            }
            numberAvailableDogs = i;
        }
        else {   
            numberAvailableDogs = 0;
            System.out.println("There are no dog's available here.\n");
         
        }
    }

    public static void printAvailableMonkeyList(String country, String countryType){      
        boolean inCountry = true;
        int i = 0;
        // Adds monkey to a temp list if it is available.
        // The temp list will be printed to the user once printAllMonkeys("available") is called

        availableMonkeyList.clear();
        // Handles which monkeys from the monkey list will be added to the available monkey list. 
        for (Monkey monkey : monkeyList) {
            
            if (countryType.equals("specefic")) // if reserveAnimal() is called
                inCountry = monkey.getInServiceLocation().equalsIgnoreCase(country);

            else if (countryType.equals("all")) // if printAllAnimals() is called
                inCountry = true;

            if (inCountry &&
                monkey.getTrainingStatus().equalsIgnoreCase("in service") &&
                monkey.getReserved() == false) {
             
                availableMonkeyList.add(monkey);
            }
        }

        if (!availableMonkeyList.isEmpty()) {
              
            // Prints the monkeys in the available monkey list
            for (Monkey monkey : availableMonkeyList) {
                ++i;
                
                // Prints monkeys' info
                System.out.printf("#" + i + "|   " + "%-10s %-18s %-10s %-8d %-10.2f %-14.2f %-10.2f %-15.2f %-15s %-16s  %-19s %-10s %6s",
                                monkey.getName(), monkey.getSpecies(), monkey.getGender(),monkey.getAge(), monkey.getWeight(), monkey.getTailLength(), monkey.getHeight(), monkey.getBodyLength(), monkey.getAcquisitionDate(), monkey.getAcquisitionLocation(), monkey.getTrainingStatus(), monkey.getReserved(), monkey.getInServiceLocation() +"\n");
            }
            numberAvailableMonkeys = i;
        }
        else {   
            numberAvailableMonkeys = 0;
            System.out.println("There are no monkeys available here.\n");
         
        }
    }
   
    public static void askUserForInputUntilValid(Scanner scr, String test, String type, String animalType) {
        boolean valid = false;
        // Ask for input until input is valid
        do {
            System.out.print("What is the " + animalType + "'s " + test);

            // Adds format requests for each user input
            switch (test) {
                
                case "Gender": System.out.println(" (male or female):");
                break;
                
                case "Age":    System.out.println(" (round to nearest year):");
                break;

                case "Weight": System.out.println(" (in lbs.):");
                break;
                
                case "Acquisition date": System.out.println(" (MM-DD-YYYY):");
                break;
                
                case "Tail length": System.out.println(" (in inches):");
                break;

                case "Height": System.out.println(" (in inches.):");
                break;

                case "Body length": System.out.println(" (in inches.):");
                break;

                default: System.out.println("");
            }

            valid = validInput(scr, type, test);  // Validity checker
            
        }
        while (!valid);
    }

    public static boolean validInput(Scanner scr, String type, String test) {
        
        // checks that species input for monkey is valid
        boolean isSpecies = false;
        String inputStr;
        int inputInt;
        double inputDouble;
        String inputDate;
           

        if (test == "Species") {
            
            // checks that input is in monkey species list
            
            inputStr = scr.nextLine();
            for (String listSpecies : monkeySpeciesList)  {
                if (inputStr.equalsIgnoreCase(listSpecies)) {
                    isSpecies = true;    
                }
            }

            if (isSpecies) {
                species = inputStr.toLowerCase();
                return true;
            }

            else {
                System.out.println("This is not a valid species.\n\n" 
                + "The list of valid monkey species\'are:"
                + "\n\t-Capuchin"
                + "\n\t-Guenon"
                + "\n\t-Macaque"
                + "\n\t-Marmoset"
                + "\n\t-Squirrel Monkey"
                + "\n\t-Tamarin\n\n"
                + "Please Try again.");

                return false;
            }
        }
    

        // Int type validity test
        else if (scr.hasNextInt() && type == "integer") {
            inputInt = scr.nextInt();
            if (inputInt < 0) {
                System.out.println("\nEnter a valid number.\n");
                return false;
            } 
            else {
                // sets age for new dog/monkey constructor
                if (test == "Age")  {
                    age = inputInt;
                }
                return true;
            }
        } 
        
        // Double type validity test
        else if (scr.hasNextDouble() && type == "number") {
            inputDouble = scr.nextDouble();
            
            if (inputDouble < 0) {
                System.out.println("Enter a valid number.");
                return false;
            }
            
            // Sets double values for corresponding attributes in constructor
            else {
                if (test == "Weight") weight = inputDouble;
                else if (test == "Tail length") tailLength = inputDouble;
                else if (test == "Height") height = inputDouble;
                else if (test == "Body length") bodyLength = inputDouble;

                return true;
            }
        }    

        // String type validity test
        else if (scr.hasNext("[A-Za-z]*") && type == "letter") {
            inputStr = scr.nextLine();
            switch (test) {
            
                case "Name": name = inputStr;
                break;

                case "Breed": breed = inputStr.toLowerCase();   
                break;

                case "Gender": {

                    // gender needs to be male or female
                    if (inputStr.equalsIgnoreCase("male") || 
                        inputStr.equalsIgnoreCase("female")) {

                        gender = inputStr.toLowerCase();
                    }

                    else {
                        System.out.println("\nEnter either male or female\n");
                        return false;
                    }

                break;
                }    
                case "Acquisition country": acquisitionCountry = inputStr.toLowerCase();
                break;
                
                case "Training status": trainingStatus = inputStr.toLowerCase();
                break;

                case "Service country": inServiceCountry = inputStr.toLowerCase();
                break;

            }
            // If made this far, no exception has been thrown, thus input is valid.
            return true;

        }

        // Date type validity test    
        else if (test=="Acquisition date") {
            inputDate = scr.next();
            if(validDate(inputDate)) {
                acquisitionDate = inputDate;
                scr.nextLine();  // reads newline character after date
                return true;
            }
            else {
                System.out.println("\nDate must be in MM-DD-YYYY format.\n");
                return false;
            }
        }

            // If none of the validity tests pass...
            else   {
                System.out.println("\n" + "Only " + type + "s can be entered for attribute: " + test
                + "\n"
                + "Please try again.\n");
                scr.nextLine();
                return false;
            }
        }
  
    public static boolean validDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
  
            try {
                
                sdf.parse(date);
                // strict mode - check 30 or 31 days, leap year
                sdf.setLenient(false);
                return true;
                
    
            } catch (ParseException e) {
                
                return false;
            }
            
    }

}
