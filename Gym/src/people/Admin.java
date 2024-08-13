package people;

import facility.Equipment;
import facility.GymHall;
import papers.ExercisePlan;

public class Admin extends Person implements AdminControl{

	public Admin(String personName, int personAge, String personEmail, String personPhone) {
		super(personName, personAge, personEmail, personPhone);
	}

	@Override
	public void addHall(GymHall hall) {
		if(hall == null) {
			System.out.println("Invalid Data for a Hall");
		}
		else {
			Admin.allHalls.add(hall);
		}
	}

	@Override
	public void removeHall(GymHall hall) {
		if(hall == null || !(Admin.allHalls.contains(hall))) {
			System.out.println("This Hall doesn't exist");
		}
		else {
			Admin.allHalls.remove(hall);
		}
	}

	@Override
	public void addEquipment(GymHall hall, Equipment equipment) {
		if(hall == null || equipment == null || !(Admin.allHalls.contains(hall))) {
			System.out.println("An Error occurred");
		}
		else {
			//index = Admin.allHalls.indexOf(hall);
			Admin.allEquipments.get(Admin.allHalls.indexOf(hall)).add(equipment);
		}
	}

	@Override
	public void removeEquipment(GymHall hall, Equipment equipment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assigneTrainer(Trainer trainer, GymHall hall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTraineePlan(Trainee trainee, ExercisePlan plan) {
		// TODO Auto-generated method stub
		
	}

	//////////Additional Methods/////////////
	
}
