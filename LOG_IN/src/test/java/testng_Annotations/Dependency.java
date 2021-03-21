package testng_Annotations;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Dependency {
	@Test
	void startcar() {
		System.err.println(" Car Started");
		Assert.fail();
	}
	@Test (dependsOnMethods = {"startcar"})
	void drivecar() {
		System.err.println(" Car Driving");
	}
	@Test (dependsOnMethods = {"drivecar"})
	void stopcar() {
		System.err.println(" Car Stoped");
	}
	@Test (dependsOnMethods = {"startcar", "stopcar"}, alwaysRun = true)
	void parkcar() {
		System.err.println(" Car Parked");
	}
}
