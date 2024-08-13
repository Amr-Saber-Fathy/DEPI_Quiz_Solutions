package people;

public abstract class Person {

	private static int personID = 0;
	private String personName = "";
	private int personAge = 0;
	private String personEmail = ""; 
	private String personPhone = "";
	
	//////////////////Constructor/////////////
	public Person(String personName, int personAge, String personEmail, String personPhone) 
	{
		setPersonID();
		this.setPersonName(personName);
		this.setPersonAge(personAge);
		this.setPersonEmail(personEmail);
		this.setPersonPhone(personPhone);
	}

	
	//////////Getters and Setters/////////////
	public int getPersonID() {
		return personID;
	}

	private void setPersonID() {
		Person.personID ++;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if(personName == null || personName == "" || personName.length() <= 2) {
			System.out.println("Invalid Name");
		}
		else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if(personAge <= 10 || personAge >= 90) {
			System.out.println("Invalid Age");
		}
		else {
			this.personAge = personAge;
		}
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		if(personEmail == null || personEmail == "" || personEmail.length() <= 15 || !(personEmail.contains("@"))) {
			System.out.println("Invalid Email");
		}
		else {
			this.personEmail = personEmail;
		}
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		if(personPhone == null || personPhone == "" || personPhone.length() < 11) {
			System.out.println("Invalid Phone Number");
		}
		else {
			this.personPhone = personPhone;
		}
	}
	
	
}
