package assertion_TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Retry_rerun {
		@Test
		public void test1() {
			System.out.println("I am inside the test 1.....");
		}
		@Test
		public void test2() {
			System.out.println("I am inside the test 2.....");
			//int i = 1/0;
		}
		@Test
		public void test3() {
			System.out.println("I am inside the test 3.....");
			Assert.assertTrue(1>2);
		}
	}

