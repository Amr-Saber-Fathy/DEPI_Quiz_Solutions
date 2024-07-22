package subProjectATM;

public class Client {

	private static int clientID = 0;
	private String clientName = "";
	private String clientSSR = "";
	private String clientPhoneNumber = "";
	private String clientAddress = "";
	private BankAccount clientBankAccount = null;
	
	//Constructors
	protected Client() 
	{
		increaseClientID();
	}
	
	protected Client(String clientName) 
	{
		this();
		setClientName(clientName);
	}
	
	protected Client(String clientName, String clientSSR) 
	{
		this(clientName);
		setClientSSR(clientSSR);
	}
	
	protected Client(String clientName, String clientSSR, String clientPhoneNumber) 
	{
		this(clientName, clientSSR);
		setClientPhoneNumber(clientPhoneNumber);
	}
	
	protected Client(String clientName, String clientSSR, String clientPhoneNumber, String clientAddress) 
	{
		this(clientName, clientSSR, clientPhoneNumber);
		setClientAddress(clientAddress);
	}
	
	protected Client(String clientName, String clientSSR, String clientPhoneNumber, String clientAddress, BankAccount clientBankAccount) 
	{
		this(clientName, clientSSR, clientPhoneNumber, clientAddress);
		setClientBankAccount(clientBankAccount);
	}

	//Getters and Setters
	protected int getClientID() {
		return clientID;
	}

	protected void increaseClientID() {
		clientID++;
	}

	protected String getClientName() {
		return clientName;
	}

	protected void setClientName(String clientName) {
		this.clientName = clientName;
	}

	protected String getClientSSR() {
		return clientSSR;
	}

	protected void setClientSSR(String clientSSR) {
		this.clientSSR = clientSSR;
	}

	protected String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	protected void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	protected String getClientAddress() {
		return clientAddress;
	}

	protected void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	protected BankAccount getClientBankAccount() {
		return clientBankAccount;
	}

	protected void setClientBankAccount(BankAccount clientBankAccount) {
		this.clientBankAccount = clientBankAccount;
	}
	
}
