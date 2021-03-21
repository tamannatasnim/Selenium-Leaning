package listeners;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(listeners.Current_Listener_ITestListener.class)
public class Listenser_TNG {
	@Test
	void test1() {
		System.out.println("This is test 1 .....");
		Assert.assertEquals("A", "A");
	}
	@Test
	void test2() {
		System.out.println("This is test 2 .....");
		Assert.assertEquals("A", "B");
	}
	@Test
	void test3() {
		System.out.println("This is test 3 .....");
		throw new SkipException("This is a skip exception");
	}
}
