package firstQuizSolution;

import java.util.Scanner;

public class CountSentences {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your Sentences : ");

		String userInput = scanner.nextLine();

		scanner.close();
		
		String[] sentences = userInput.split("(?<=[.!?])\\s*");
		
		for(String sentence : sentences) 
		{
			System.out.println(sentence.trim());
		}

	}

}
