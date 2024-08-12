package dataProvider;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	@DataProvider(name="invalidUserCredentials")
	
	public Object[][] verifyUserCredentialsData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="poojapremkuma1@gmail.com";
		data[0][1]="poojapremkumar";
		
		
		data[1][0]="poojapremkumar@gmail.com";
		data[1][1]="poojapremkumar11";
		
		data[2][0]="poojapremkur@gmail.com";
		data[2][1]="poojapremk575";
		
		return data;
	}

}
