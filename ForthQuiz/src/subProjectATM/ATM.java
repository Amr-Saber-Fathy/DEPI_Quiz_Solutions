package subProjectATM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ATM {

	private static int atmID = 0;
	private String location = "";
	private long remainingCurrency = 0;
	private List<Integer> availableCash = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
	
	//Constructors
	public ATM() 
	{
		increaseAtmID();
	}
	
	public ATM(String location) 
	{
		this();
		setLocation(location);
	}
	
	public ATM(String location, List<Integer> availableCash) 
	{
		this(location);
		setAvailableCash(availableCash);
	}
	
	
	//Getters and Setters
	public int getAtmID() {
		return atmID;
	}
	
	private void increaseAtmID() {
		atmID++;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setAvailableCash(List<Integer> availableCash) {
		this.availableCash = availableCash;
	}
	
	public long calculateRemainingCurrency() {
		remainingCurrency = 0;
		int[] values = {10, 20, 50, 100, 200};
		for(int i=0; i< values.length; i++) 
		{
			remainingCurrency+= (long)(availableCash.get(i)*values[i]);
		}
		return remainingCurrency;
	}
	
	
}
