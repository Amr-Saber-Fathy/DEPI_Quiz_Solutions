package secondQuizSolution;

import java.util.Scanner;

public class BuildingID {

	public static void main(String[] args) {
		Governorates gover = new Governorates();
		StringBuilder userID = new StringBuilder();
		String birthDate;
		String birthPlace;
		String lastFiveDigits;
		int userDecades;
		int userDecade;
		int userYear;
		int governorateCode;
		try (Scanner data = new Scanner(System.in)) {
			System.out.println("Please enter your BirthDate in form of dd/mm/yyyy : ");
			birthDate = data.nextLine();
			String[] dates = birthDate.split("/");
			System.out.println("Please enter your Birth Place : ");
			birthPlace = data.nextLine();
			governorateCode = gover.getCodeByGovernorate(birthPlace);
			System.out.println("Please enter your 5 digits ID code : ");
			lastFiveDigits = data.nextLine();
			userDecades = Integer.parseInt(dates[2]);
			userDecade = (userDecades / 1000) +1;
			userYear = (userDecades % 1000) % 100;
			userID.append(userDecade);
			if(userYear < 10) 
			{
				userID.append(0);
			}
			userID.append(userYear);
			userID.append(dates[1]);
			userID.append(dates[0]);
			if(governorateCode < 10) 
			{
				userID.append(0);
			}
			userID.append(governorateCode);
			userID.append(lastFiveDigits);
			
			System.out.println("Your ID is : " + userID);
		}

	}

}
