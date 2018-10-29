import java.util.Scanner;

public class VowelConstanentCount {

	public static void main(String[] args) {

		// 1, Get string from user
		// System.out.println(getUserInput());
		String usrInput = getUserInput();

		// 2, Count the vowels
		// System.out.println("Vowel count is " + countVowels(usrInput));

		// 3, Count the other letters as consonants
		// System.out.println("Consonants count is " + countConsonants(usrInput));

	}

	public static String getUserInput() {
		String input = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("User input Please enter text ");

		input = sc.nextLine();

		return input;
	}

	public static int countConsonants(String in) {
		int consonents = 0;
		in.toUpperCase();

		for (int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);

			if (in.charAt(i) == 'A' || in.charAt(i) == 'E' || in.charAt(i) == 'I' || in.charAt(i) == 'O'
					|| in.charAt(i) == 'U') {
				consonents++;
			}
		}
		return consonents;
	}

	public static int countVowels(String in) {
		int vowels = 0;
		int count = 0;
		int consonents = 0;

		in = in.toUpperCase();

		for (int i = 0; i < in.length(); i++) {
			char ch = in.charAt(i);

			if (in.charAt(i) == 'A' || in.charAt(i) == 'E' || in.charAt(i) == 'I' || in.charAt(i) == 'O'
					|| in.charAt(i) == 'U') {
				vowels++;
			}

		}

		return vowels;
	}

}
