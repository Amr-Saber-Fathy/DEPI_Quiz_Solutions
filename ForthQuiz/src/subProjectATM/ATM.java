package subProjectATM;

public class ATM {

	private int atmID = 0;
	private String location = "";
	private long remainingCurrency = 0;
	private Client client = null;
	
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
	
	public ATM(String location, long remainingCurrency) 
	{
		this(location);
		setRemainingCurrency(remainingCurrency);
	}
	
	public ATM(String location, long remainingCurrency, Client client) 
	{
		this(location, remainingCurrency);
		setClient(client);
	}
	
	//Getters and Setters
	public int getAtmID() {
		return atmID;
	}
	
	private void increaseAtmID() {
		this.atmID++;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public long getRemainingCurrency() {
		return remainingCurrency;
	}
	
	public void setRemainingCurrency(long remainingCurrency) {
		this.remainingCurrency = remainingCurrency;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
