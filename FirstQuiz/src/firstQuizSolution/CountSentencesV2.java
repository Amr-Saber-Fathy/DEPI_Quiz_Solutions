package firstQuizSolution;

import java.util.Scanner;

public class CountSentencesV2 {

	static int counter = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Sentences : ");
		String userInput = scanner.nextLine();
		scanner.close();
		
		int sentencesNumber = noSentences(userInput);
		System.out.println("Number of Sentences = " + sentencesNumber);

	}
	
	public static int noSentences(String str) {
		int index = 0;
		
		if(str.contains(".")) {
			index = str.indexOf(".");
			counter++;
			return noSentences(str.substring(index+1, str.length()));
		}
		else {
			return counter;
		}
	}

}
