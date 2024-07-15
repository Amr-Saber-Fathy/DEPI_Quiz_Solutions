package firstQuizSolution;

import java.util.Scanner;

public class CountWords {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Sentences : ");
		
		String userInput = scanner.nextLine();
		
		scanner.close();
		
		String[] words = userInput.split(" ");
		
		for(String word : words)
		{
			System.out.println(word);
		}

	}

}
