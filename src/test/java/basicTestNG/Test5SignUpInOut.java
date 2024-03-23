package basicTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test5SignUpInOut {

	@Test
	public void signUp() {
		System.out.println("sign up");
	}
	
	@Test
	public void signIn() {
		System.out.println("sign in");
		Assert.assertEquals("pune", "Pune");
	}
	
	@Test(dependsOnMethods = "signIn")
	public void signOut() {
		System.out.println("sign out");
	}
}
