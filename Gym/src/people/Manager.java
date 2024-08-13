package people;

public class Manager extends Admin implements ManagerControl{

	public Manager(String personName, int personAge, String personEmail, String personPhone) {
		super(personName, personAge, personEmail, personPhone);
	}

	@Override
	public void addAdmin(Admin admin) {
		if(admin == null) {
			System.out.println("Inalid Data for Admin");
		}
		else {
			Manager.admins.add(admin);
		}
	}

	@Override
	public void removeAdmin(Admin admin) {
		if(Manager.admins.contains(admin)) {
			Manager.admins.remove(admin);
		}
		else {
			System.out.println("This Admin doesn't exist");
		}
	}

}
