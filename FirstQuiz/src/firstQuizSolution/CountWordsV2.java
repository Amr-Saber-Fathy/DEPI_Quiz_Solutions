package firstQuizSolution;

import java.util.Scanner;

public class CountWordsV2 {

	static int counter = 1;
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Sentences : ");
		String userInput = scanner.nextLine();
		scanner.close();
		
		int wordsCounter = noWords(userInput);
		
		System.out.println("Number of Words = " + wordsCounter);
	}

	
	public static int noWords(String str) {
		int index = 0;
		
		if(str.contains(" ")) {
			index = str.indexOf(" ");
			counter++;
			return noWords(str.substring(index+1, str.length()));
		}
		else {
			return counter;
		}
	}
}

