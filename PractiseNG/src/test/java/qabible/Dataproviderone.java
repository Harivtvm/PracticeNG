package qabible;

import org.testng.annotations.DataProvider;

public class Dataproviderone {
	@DataProvider(name="simpleformtext1")
	public Object[][] simpleformtext1list()
	{
		return new Object[][] {{"Menu"},{"Single Input Field"},{"Two Input Fields"}};
	}

}
