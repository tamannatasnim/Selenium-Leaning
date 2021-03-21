package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProvidedFrom {
	@DataProvider(name = "LoginDataProvide1")
	public Object[][] getData1(){
		Object[][] data = {{"Admin", "Admin@user"}};
		return data;
	}
	@DataProvider(name = "LoginDataProvide2")
	public Object[][] getData2(){
		Object[][] data = {{"Admin1","Admin@user"}, {"Admin","Admin@"}};
		return data;
	}
	@DataProvider(name = "LoginDataProvide3")
	public Object[][] getData3(){
		Object[][] data = {{"","Admin@user"}, {"Admin",""}, {"",""}};
		return data;
	}

}
