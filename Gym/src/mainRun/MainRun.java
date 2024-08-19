package mainRun;

import java.util.Scanner;

import facility.GymHall;
import people.Admin;
import people.Trainer;
import sqlConnection.SearchData;

public class MainRun {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String email = "";
		String pass = "";
		int choice = 0;
		
		GymHall hall1 = new GymHall("Main Hall");
		
		System.out.println("Please Enter your Email : ");
		email = scanner.nextLine();
		System.out.println("Please Enter your Password : ");
		pass = scanner.nextLine();
		if(SearchData.checkAdmin(email) && SearchData.checkAdminPass(email, pass)) 
		{
			Admin admin = new Admin("Amr", 25, email, "01563248975", pass);
			System.out.println("Hello");
			System.out.println("Please Choose the number of the command you want : ");
			System.out.println("1-Add Trainer");
			System.out.println("2-Remove Trainer");
			System.out.println("3-Add Trainee");
			System.out.println("4-Remove Trainee");
			System.out.println("5-Exit Program");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: {
				clearTerminal();
				System.out.println("Please Enter Trainer Name : ");
				String tName = scanner.nextLine();
				System.out.println("Please Enter Trainer Age : ");
				int tAge = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please Enter Trainer Salary : ");
				double tSalary = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please Enter Trainer Email : ");
				String tEmail = scanner.nextLine();
				System.out.println("Please Enter Trainer Phone : ");
				String tPhone = scanner.nextLine();
				System.out.println("Please Enter Trainer Password : ");
				String tPassword = scanner.nextLine();
				System.out.println("Please Enter Trainer Working Hours : ");
				int tWorkingHours = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please Enter Trainer Hall number : ");
				int tHallno = scanner.nextInt();
				scanner.nextLine();
				
				Trainer trainer = new Trainer(tName, tAge, tSalary, tEmail, tPhone, tPassword, tWorkingHours, hall1);
				admin.addTrainer(trainer);
				break;
			}
			case 2: {
				
			}
			case 3: {
				
			}
			case 4: {
				
			}
			case 5: {
				break;
			}
			default:
				System.out.println("Invalid Choice: " + choice);
			}
		}
		
		scanner.close();
	}

	
	public static void clearTerminal() 
	{
		try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

	

