package data.zConfuse;

public class DataConfuser {
	public static String encrypt(String text) {
		/*String res = "";
		char c;
		for (int i=0; i<text.length(); ++i) {
			c = (char)(text.charAt(i) - 12);
			res += c;
		}
		return res;*/
		return text;
	}
	
	public static String decrypt(String text) {
		/*String res = "";
		char c;
		for (int i=0; i<text.length(); ++i) {
			c = (char)(text.charAt(i) + 12);
			res += c;
		}
		return res;*/
		return text;
	}
}
