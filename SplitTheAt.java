public class SplitTheAt {

	public static void main(String[] args) {

		// rules
		// 1, An email address must have one ‘@’ symbol only
		// 2, One dot symbol on RHS of ‘@’ sign
		// 3, At least two characters before the ‘’@’
		// 4, At least 4 characters after the ‘@’

		String in = "kieran@this.com";
		int at = in.indexOf('@');
		int dot = in.indexOf('.');

		String s = "dss+text after the plus + and ++";

		String a = null;
		String b = null;
		String c = null;

		if (s.contains("+")) {
			String parts[] = s.split("[+]");

			a = parts[0]; // i want to strip part after +
			b = parts[1];
			//c = parts[2];
		}
		System.out.println("Text before the first + '" + s + "'");
		System.out.println("Text + '" + a + "'");
		System.out.println("Text + '" + c + "'");
		System.out.println("Text + '" + c + "'");

	}
}
