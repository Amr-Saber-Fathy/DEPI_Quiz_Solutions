package sqlConnection;

import java.time.LocalDate;

import facility.Equipment;
import facility.GymHall;
import papers.ExercisePlan;
import papers.Subscription;
import people.Admin;
import people.Manager;
import people.Trainee;
import people.Trainer;

public class TestInsertion {

	public static void main(String[] args) {

		GymHall hall1 = new GymHall("Main Hall");
		Trainer tainer101 = new Trainer("Ali", 24, 3500, "Test123@gmail.com", "01243126589", "test123", 8, hall1);
		SQLConnection.insertGymHall(hall1);
		SQLConnection.insertTrainer(tainer101);
		//////////////////////////////////////////////
		
		Subscription sub = new Subscription("Gold", LocalDate.now(), LocalDate.now().plusDays(30));
		ExercisePlan exPlan = new ExercisePlan(15);
		exPlan.addStep("Do 4*13 Pushup");
		exPlan.addStep("Do 4*13 Caplecross");
		exPlan.addStep("Do 3*13 Butterfly");
		
		Trainee trainee101 = new Trainee("Amr", 20, "Asf@gmail.com", "01260458974", "123456", sub, exPlan);
		
		SQLConnection.insertExercisePlan(exPlan);
		SQLConnection.insertSubscription(sub);
		SQLConnection.insertTrainee(trainee101);
		//////////////////////////////////////////////
		
		Admin admin = new Admin("Mohammed", 26, "Admin101@gmail.com", "01532648953", "Test123456");
		Manager manager = new Manager("Ibrahim", 30, "Manager123@gmail.com", "01126354789", "145632");
		
		SQLConnection.insertAdmin(admin);
		SQLConnection.insertManager(manager);
		////////////////////////////////////////////////
		
		Equipment eq = new Equipment("Bench Prss", "Bench Machine");
		SQLConnection.insertEquipment(eq);
		//////////////////////////////////////////////
		
		SQLConnection.addEqToHall(eq, hall1);
	}

}
