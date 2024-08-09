package items.Clothing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface HaveSize {

	List<Object> availableSizes = new ArrayList<Object>(Arrays.asList());
	
	public void addAvailableSize(Object size);
	public void removeAvailableSize(Object size);
	
}
