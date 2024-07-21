package subProjectATM;

public class Client {

	private int clientID = 1;
	private String clientName = "";
	private String clientSSR = "";
	private String clientPhoneNumber = "";
	private String clientAddress = "";
	private BankAccount clientBankAccount = null;
	
	//Constructors
	public Client() 
	{
		increaseClientID();
	}
	
	public Client(String clientName) 
	{
		this();
		setClientName(clientName);
	}
	
	public Client(String clientName, String clientSSR) 
	{
		this(clientName);
		setClientSSR(clientSSR);
	}
	
	public Client(String clientName, String clientSSR, String clientPhoneNumber) 
	{
		this(clientName, clientSSR);
		setClientPhoneNumber(clientPhoneNumber);
	}
	
	public Client(String clientName, String clientSSR, String clientPhoneNumber, String clientAddress) 
	{
		this(clientName, clientSSR, clientPhoneNumber);
		setClientAddress(clientAddress);
	}
	
	public Client(String clientName, String clientSSR, String clientPhoneNumber, String clientAddress, BankAccount clientBankAccount) 
	{
		this(clientName, clientSSR, clientPhoneNumber, clientAddress);
		setClientBankAccount(clientBankAccount);
	}

	//Getters and Setters
	public int getClientID() {
		return clientID;
	}

	private void increaseClientID() {
		this.clientID++;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSSR() {
		return clientSSR;
	}

	public void setClientSSR(String clientSSR) {
		this.clientSSR = clientSSR;
	}

	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public BankAccount getClientBankAccount() {
		return clientBankAccount;
	}

	public void setClientBankAccount(BankAccount clientBankAccount) {
		this.clientBankAccount = clientBankAccount;
	}
	
}
