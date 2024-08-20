package mainRun;

import java.util.Scanner;

import facility.Equipment;
import facility.GymHall;
import papers.ExercisePlan;
import papers.Subscription;
import people.Admin;
import people.Trainee;
import people.Trainer;
import sqlConnection.SQLConnection;
import sqlConnection.SearchData;

public class MainRun {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String email = "";
		String pass = "";
		int choice = 0;

		//GymHall hall1 = new GymHall("Main Hall");

		System.out.println("Please Enter your Email : ");
		email = scanner.nextLine();
		System.out.println("Please Enter your Password : ");
		pass = scanner.nextLine();
		//		System.out.println(SearchData.checkAdmin(email));
		//		System.out.println(SearchData.checkAdminPass(email, pass));
		if(SearchData.checkAdmin(email) && SearchData.checkAdminPass(email, pass)) 
		{
			Admin admin = new Admin("Amr", 25, email, "01563248975", pass);
			while(choice != 10) {
				System.out.println("Hello");
				System.out.println("Please Choose the number of the command you want : ");
				System.out.println("1-Add Trainer");
				System.out.println("2-Remove Trainer");
				System.out.println("3-Add Trainee");
				System.out.println("4-Remove Trainee");
				System.out.println("5-Add Hall");
				System.out.println("6-Remove Hall");
				System.out.println("7-Add Equipment");
				System.out.println("8-Remove Equipment");
				System.out.println("9-Move Equipment");
				System.out.println("10-Exit Program");
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

					Trainer trainer = new Trainer(tName, tAge, tSalary, tEmail, tPhone, tPassword, tWorkingHours, tHallno);
					admin.addTrainer(trainer);
					break;
				}
				case 2: {
					clearTerminal();
					//Remove Trainer
					System.out.println("Please Enter Trainer ID : ");
					int tID = scanner.nextInt();
					scanner.nextLine();
					admin.removeTrainer(tID);
					break;
				}
				case 3: {
					clearTerminal();
					//Add Trainee
					System.out.println("Please Enter Trainee Name : ");
					String tName = scanner.nextLine();
					System.out.println("Please Enter Trainee Age : ");
					int tAge = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Please Enter Trainee Email : ");
					String tEmail = scanner.nextLine();
					System.out.println("Please Enter Trainee Phone : ");
					String tPhone = scanner.nextLine();
					System.out.println("Please Enter Trainee Password : ");
					String tPassword = scanner.nextLine();
					System.out.println("Please Enter Trainee Subscription Type : ");
					String tSub = scanner.nextLine();
					System.out.println("Please Enter Exercise Plan Duration : ");
					int exPlanDuration = scanner.nextInt();
					scanner.nextLine();

					Subscription sub = new Subscription(tSub);
					ExercisePlan exPlan = new ExercisePlan(exPlanDuration);
					exPlan.addStep("Do 4*13 Pushup");
					exPlan.addStep("Do 4*13 Caplecross");
					exPlan.addStep("Do 3*13 Butterfly");

					Trainee trainee101 = new Trainee(tName, tAge, tEmail, tPhone, tPassword, sub, exPlan);

					SQLConnection.insertExercisePlan(exPlan);
					SQLConnection.insertSubscription(sub);
					SQLConnection.insertTrainee(trainee101);
					break;
				}
				case 4: {
					clearTerminal();
					//Remove Trainee
					System.out.println("Please Enter Trainee ID : ");
					int tID = scanner.nextInt();
					scanner.nextLine();
					admin.removeTrainee(tID);
					break;
				}
				case 5: {
					clearTerminal();
					//Add Hall
					System.out.println("Please Enter Hall Name : ");
					String hallName = scanner.nextLine();
					
					GymHall hall = new GymHall(hallName);
					admin.addHall(hall);
					break;
				}
				case 6: {
					clearTerminal();
					//Remove Hall
					System.out.println("Please Enter Hall ID : ");
					int hallID = scanner.nextInt();
					scanner.nextLine();
					admin.removeHall(hallID);
					break;
				}
				case 7: {
					clearTerminal();
					//Add Equipment
					System.out.println("Please Enter Equipment Name : ");
					String eqName = scanner.nextLine();
					System.out.println("Please Enter Equipment Type : ");
					String eqType = scanner.nextLine();
					System.out.println("Please Enter Hall ID : ");
					int hallID = scanner.nextInt();
					scanner.nextLine();
					
					Equipment eq = new Equipment(eqName, eqType);
					admin.addEquipment(hallID, eq);
					break;
				}
				case 8: {
					clearTerminal();
					//Remove Equipment
					System.out.println("Please Enter Equipment ID : ");
					int eqID = scanner.nextInt();
					scanner.nextLine();
					
					admin.removeEquipment(eqID);
					break;
				}
				case 9: {
					clearTerminal();
					//Move Equipment
					
					break;
				}
				case 10: {
					break;
				}
				default:
					System.out.println("Invalid Choice: " + choice);
				}
			}
		}

		scanner.close();
	}


	public static void clearTerminal() 
	{
		//		System.out.print("\033[" + "2J");
	}
}



