package commonUtils;

import java.util.Random;

public class JavaUtil {

	public int getRandomNumber() {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int ran =r.nextInt(500);
		return ran;
	}

}
