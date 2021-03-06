import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author shshree Testing whether a given string is a pangram
 */
public class Pangrams {

	/**
	 * 
	 * @param panRef
	 * @return boolean
	 *
	 */
	public static boolean isPangram(String panRef) {

		if (panRef == null) {
			throw new NullPointerException("ERRORCODE: Value cannot be null");
		}

		if (panRef.length() < 26) {
			throw new InputMismatchException(
					"ERRORCODE: String doesn't qualify to be pangram so further checks won't happen");
		}
		String str = panRef.toLowerCase().replaceAll("\\s+", "");
		Pattern regex = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
		// matcher to find if there is any special character in string
		Matcher matcher = regex.matcher(str);

		if (matcher.find()) {
			throw new InputMismatchException("ERROCODE1: Invalid input value");
		} else {
			boolean[] alphabets = new boolean[26];
			for (int i = 0; i < str.length(); i++) {
				alphabets[str.charAt(i) - 97] = true;
			}
			for (int i = 0; i < 26; i++) {
				if (alphabets[i] == false) {
					return false;
				}
			}
			return true;
		}
	}
}
