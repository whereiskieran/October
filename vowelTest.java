import java.util.Scanner;

public class vowelTest {

	public static void main(String[] args) {


		String input = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("User input Please enter text ");

		input = sc.nextLine();


		int consonents = 0;
		int vowels = 0;
		input = input.toUpperCase();
		System.out.println("Test Input is "+input);

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O'
					|| input.charAt(i) == 'U') {
				vowels++;
			}
			else
			{
				consonents++;
			}
		
		
	}
		System.out.println("Vowels are "+vowels);
		System.out.println("Consonents are "+consonents);
	}
}
//	public static int countVowels(String in) {
//		int vowels = 0;
//		int count = 0;
//		int consonents = 0;
//
//		in = in.toUpperCase();
//
//		for (int i = 0; i < in.length(); i++) {
//			char ch = in.charAt(i);
//
//			if (in.charAt(i) == 'A' || in.charAt(i) == 'E' || in.charAt(i) == 'I' || in.charAt(i) == 'O'
//					|| in.charAt(i) == 'U') {
//				vowels++;
//			}
//
//		}
//
//		return vowels;
//	}


