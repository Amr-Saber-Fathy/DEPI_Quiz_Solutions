package people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ManagerControl {

	static List<Admin> admins = new ArrayList<Admin>(Arrays.asList());
	
	void addAdmin(Admin admin);
	void removeAdmin(Admin admin);
	
}
