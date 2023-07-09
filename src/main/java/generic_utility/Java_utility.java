package generic_utility;

import java.util.Random;

public class Java_utility {
	public int getRanNum()
	{
		/**
		 * @return
		 * @author Soundarya
		 */
		Random ran = new Random();
		int data = ran.nextInt(1000);
		return data;
		
		
	}

}
