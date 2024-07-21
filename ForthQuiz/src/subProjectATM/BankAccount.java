package subProjectATM;

public class BankAccount {

	private int accountID = 0;
	private String accountNumber = "";
	private int amountOfCurrency = 0;
	
	//Constructors
	public BankAccount() 
	{
		increaseAccountID();
	}
	
	public BankAccount(String accountNumber) 
	{
		this();
		setAccountNumber(accountNumber);
	}
	
	public BankAccount(String accountNumber, int amountOfCurrency) 
	{
		this(accountNumber);
		setAmountOfCurrency(amountOfCurrency);
	}

	//Getters and Setters
	public int getAccountID() {
		return accountID;
	}

	private void increaseAccountID() {
		this.accountID++;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAmountOfCurrency() {
		return amountOfCurrency;
	}

	public void setAmountOfCurrency(int amountOfCurrency) {
		this.amountOfCurrency = amountOfCurrency;
	}
	
}
