package people;

import facility.GymHall;

public class Trainer extends Person{

	private int workingHours = 0;
	private GymHall assignedHall = null;
	
	
	////////////Constructor//////////////
	public Trainer(String personName, int personAge, String personEmail, String personPhone, int workingHours, GymHall assignedHall) {
		super(personName, personAge, personEmail, personPhone);
		this.setWorkingHours(workingHours);
		this.setAssignedHall(assignedHall);
	}
/////////////////////////////////////////////////

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		if(workingHours <= 6) {
			System.out.println("Invalid Working Hours => Working Hours must be greater than 6 hours");
		}
		else {
			this.workingHours = workingHours;
		}
	}

	public GymHall getAssignedHall() {
		return assignedHall;
	}

	public void setAssignedHall(GymHall assignedHall) {
		if(assignedHall == null) {
			System.out.println("Invalid Gym Hall");
		}
		else {
			this.assignedHall = assignedHall;
		}
	}

	
	
	
}
