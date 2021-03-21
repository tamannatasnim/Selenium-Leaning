package assertion_TestNG;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
@Ignore
public class IgonorTest {

	@Test
	public void test1() {
		System.out.println("I am inside the test 1.....");
	}
	@Test
	public void test2() {
		System.out.println("I am inside the test 2.....");
	}
}
class IgonorTest2 {

	@Test
	public void test3() {
		System.out.println("I am inside the test 3.....");
	}
	@Test
	public void test4() {
		System.out.println("I am inside the test 4.....");
	}
}
