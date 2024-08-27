package utilities;

import com.github.javafaker.Faker;



	public final class RandomDataUtility {

	    // Static Faker instance
	    private static final Faker faker = new Faker();

	    // Private constructor to prevent instantiation
	    private RandomDataUtility() {
	        throw new UnsupportedOperationException("Random data Utility class");
	    }

	    // Method to get a random prefix
	    public static String getPrefix() {
	        return faker.name().prefix();
	    }

	    // Method to get a random first name
	    public static String getFirstName() {
	        return faker.name().firstName();
	    }

	    // Method to get a random last name
	    public static String getLastName() {
	        return faker.name().lastName();
	    }
	    
	 // Method to get a random username
	    public static String getUserName()
	    {
	    return faker.name().username();
	    }
	    
	    public static String getEditLastName() {
	        return faker.name().lastName();
	    }
	}


