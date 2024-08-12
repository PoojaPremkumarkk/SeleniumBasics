package dataprovider;


	import org.testng.annotations.DataProvider;

	public class DataProviders {
		@DataProvider(name="invalidUserCredentials")
		
		public Object[][] verifyUserCredentialsData()
		{
			Object[][] data=new Object[3][2];
			data[0][0]="admin";
			data[0][1]="12345678678";
			
			
			data[1][0]="admin1";
			data[1][1]="123456";
			
			data[2][0]="admin12";
			data[2][1]="34645575";
			
			return data;
		}

	}


