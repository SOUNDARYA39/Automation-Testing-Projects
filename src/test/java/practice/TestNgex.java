package practice;

import org.testng.annotations.Test;

public class TestNgex {
// we can also give enable=false instead of invocationcount to not execute the method
	@Test (invocationCount = 0,priority = 1)
	public void createContact()
	{
		
        System.out.println("create contact");
	}
	@Test(invocationCount = 1, priority = 2)
	public void modifyContact()
	{
		
        System.out.println("modify contact");
	}

	@Test(invocationCount = 3, priority = -1)
	public void deleteContact()
	{
		
        System.out.println("delete contact");
	}

}
