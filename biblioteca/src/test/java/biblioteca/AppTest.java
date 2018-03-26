package biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private App app;
	
	
	@Before
	public void testBe() {
		app = new App();
	}
	
	@Test
	public void test() {
		app.testLogger();
		assertTrue(true);
	}
}
