package utilities;

import com.github.javafaker.Faker;

	public final class RandomDataUtility {

	    private static final Faker faker = new Faker();
	    private RandomDataUtility() {
	        throw new UnsupportedOperationException("Random data Utility class");
	    }
	    public static String getPrefix() {
	        return faker.name().prefix();
	    }

	    public static String getFirstName() {
	        return faker.name().firstName();
	    }

	   
	    public static String getLastName() {
	        return faker.name().lastName();
	    }
	    
	    public static String getUserName()
	    {
	    return faker.name().username();
	    }
	    
	    public static String getEditLastName() {
	        return faker.name().lastName();
	    }
	}


