package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionEx {

	@Test
	public void a1()
	{
		System.out.println("step1");
		String exep="soundarya";
		String actual="Soundarya";
		Assert.assertEquals(actual, exep);
		System.out.println("step2");

	}
	
	@Test
	public void a2()
	{
		System.out.println("step3");
		Assert.assertEquals(false, false);
		System.out.println("step4");
	}
}
