package thirdQuizSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SSR_Validation {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your SSR : ");
		String userInput = scanner.nextLine();
		scanner.close();
		validationSSR(userInput);
	}

	public static void validationSSR(String userSSR) {
		List<Integer> governorateCodes = new ArrayList<Integer>(Arrays.asList(1,2,3,4,11,12,15,14,15,16,16,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35));
		if(userSSR.length() != 14) {
			System.out.println("Invalid SSR should be 14 digits");
		}
		else {
			try{
				Long.parseLong(userSSR);
				if(userSSR.charAt(0)!='2' && userSSR.charAt(0)!='3') {
					System.out.println("Invalid SSR please insue the decate number");
				}
				else if((Integer.parseInt(userSSR.substring(1, 3))<0)) {
					System.out.println("Invalid SSR please insue the year");
				}
				else if((Integer.parseInt(userSSR.substring(3, 5))>12) || (Integer.parseInt(userSSR.substring(3, 5))<1)) {
					System.out.println("Invalid SSR please insue the month");
				}
				else if((Integer.parseInt(userSSR.substring(5, 7))>31) || (Integer.parseInt(userSSR.substring(5, 7))<1)) {
					System.out.println("Invalid SSR please insue the day");
				}
				else if(!(governorateCodes.contains((Integer.parseInt(userSSR.substring(7, 9)))))) {
					System.out.println("Invalid SSR please insue the governorate");
				}
				else {
					System.out.println("Your SSR is valid");
				}
			}
			catch (Exception e) {
				System.out.println("Invalid SSR please remove any letters");
			}
		}
	}
	
}
