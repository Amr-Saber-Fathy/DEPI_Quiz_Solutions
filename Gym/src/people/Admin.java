package people;


import facility.Equipment;
import facility.GymHall;
import papers.ExercisePlan;
import sqlConnection.SQLConnection;

public class Admin extends Person implements AdminControl{

	public Admin(String personName, int personAge, String personEmail, String personPhone, String personPassword) {
		super(personName, personAge, personEmail, personPhone, personPassword);
	}

	@Override
	public void addHall(GymHall hall) {
		if(hall == null) {
			System.out.println("Invalid Data for a Hall");
		}
		else {
			//Admin.allHalls.add(hall);
			SQLConnection.insertGymHall(hall);
		}
	}

	@Override
	public void removeHall(int hallID) {
		if(hallID <= 0) {
			System.out.println("This Hall doesn't exist");
		}
		else {
			//Admin.allHalls.remove(hall);
			SQLConnection.removeHall(hallID);
		}
	}

	@Override
	public void addEquipment(int hallID, Equipment equipment) {
		if(hallID <= 0 || equipment == null) {
			System.out.println("An Error occurred");
		}
		else {
			//index = Admin.allHalls.indexOf(hall);
			//Admin.allEquipments.get(Admin.allHalls.indexOf(hall)).add(equipment);
			SQLConnection.insertEquipment(equipment);
			SQLConnection.addEqToHall(equipment, hallID);
		}
	}

	@Override
	public void removeEquipment(int eqID) {

		SQLConnection.removeEquipment(eqID);
	}

	@Override
	public void addTrainer(Trainer trainer) {
		
		SQLConnection.insertTrainer(trainer);
	}

	@Override
	public void removeTrainer(int trainerID) {
		
		SQLConnection.removeTrainer(trainerID);
	}

	@Override
	public void assigneTrainer(Trainer trainer, GymHall hall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrainee(Trainee trainee) {
		
		SQLConnection.insertTrainee(trainee);
	}

	@Override
	public void removeTrainee(int traineeID) {
		
		SQLConnection.removeTrainee(traineeID);
	}

	@Override
	public void changeTraineePlan(Trainee trainee, ExercisePlan plan) {
		// TODO Auto-generated method stub
		
	}

	//////////////////Additional Methods//////////////////////////
	Utils checkdiscount = (t -> {if(t.getPoints() >= 100) {
									return t.getSubcription().getPrice()*t.getSubcription().getDiscount();
									}
								else{
									return t.getSubcription().getPrice();
									}
						});
	
}
