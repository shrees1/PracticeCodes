import java.util.InputMismatchException;

import javax.xml.bind.ValidationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PangramTest {
	// @Rule
	// public ExpectedException thrown = ExpectedException.none();

	Pangrams pangram = null;

	@Before
	public void setup() {
		pangram = new Pangrams();
	}

	@Test
	public void testValidCase() {
		String panRef = "The quick brown fox jumps over the lazy dog";
		Assert.assertTrue(Pangrams.isPangram(panRef));
	}

	@Test(expected = InputMismatchException.class)
	public void falseCaseTest() {
		String panRef = "Shikha Shree";
		Assert.assertFalse(Pangrams.isPangram(panRef));
	}

	@Test(expected = NullPointerException.class)
	public void testAllNull() {
		Assert.assertFalse(Pangrams.isPangram(null));
	}

	@Test(expected = InputMismatchException.class)
	public void testSpecialCharacters() {
		String panRef = "The quick ;p'[],./;;'';brown fox jumps over the lazy dog";
		Assert.assertFalse(Pangrams.isPangram(panRef));
	}

}
