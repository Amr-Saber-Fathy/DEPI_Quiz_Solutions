package firstQuizSolution;

import java.util.Arrays;
import java.util.Scanner;

public class WordOccurrence {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your Sentences : ");

		String userInput = scanner.nextLine();

		scanner.close();
		
		String[] words = userInput.split(" ");
		String[][] wordsCountArr = new String[words.length][2];
		int uniqueWords = 0;
		
		for(String word : words) 
		{
			boolean isFound = false;
			for(int i=0 ; i < uniqueWords ; i++) 
			{
				if(wordsCountArr[i][0].equals(word)) 
				{
					int counter = Integer.parseInt(wordsCountArr[i][1]);
					wordsCountArr[i][1] = String.valueOf(counter + 1);
					isFound = true;
					break;
				}
			}
			if(!isFound) 
			{
				wordsCountArr[uniqueWords][0] = word;
				wordsCountArr[uniqueWords][1] = "1";
				uniqueWords++;
			}
		}
		
		//Resize the Array
		wordsCountArr = Arrays.copyOf(wordsCountArr , uniqueWords);
		
		for(int i = 0 ; i < uniqueWords ; i++)
		{
			System.out.println(wordsCountArr[i][0] + " Occurred " + wordsCountArr[i][1] + " times");
		}
	}

}
