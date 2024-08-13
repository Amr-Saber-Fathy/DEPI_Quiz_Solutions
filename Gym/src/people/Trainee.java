package people;

import papers.ExercisePlan;
import papers.Subscription;

public class Trainee extends Person{

	private Subscription subcription = null;
	private ExercisePlan plan = null;
	
	public Trainee(String personName, int personAge, String personEmail, String personPhone, Subscription subcription, ExercisePlan plan) {
		super(personName, personAge, personEmail, personPhone);
		this.setSubcription(subcription);
		this.setPlan(plan);
	}

	public Subscription getSubcription() {
		return subcription;
	}

	public void setSubcription(Subscription subcription) {
		if(subcription == null) {
			System.out.println("Invalid Subscription Data");
		}
		else {
			this.subcription = subcription;
		}
	}

	public ExercisePlan getPlan() {
		return plan;
	}

	public void setPlan(ExercisePlan plan) {
		if(plan == null) {
			System.out.println("Invalid Exercise Plan");
		}
		else {
			this.plan = plan;
		}
	}
}
