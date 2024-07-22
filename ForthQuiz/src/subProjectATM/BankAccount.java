package subProjectATM;

public class BankAccount {

	private static int accountID = 0;
	private String accountNumber = "";
	private int amountOfCurrency = 0;
	
	//Constructors
	protected BankAccount() 
	{
		increaseAccountID();
	}
	
	protected BankAccount(String accountNumber) 
	{
		this();
		setAccountNumber(accountNumber);
	}
	
	protected BankAccount(String accountNumber, int amountOfCurrency) 
	{
		this(accountNumber);
		setAmountOfCurrency(amountOfCurrency);
	}

	//Getters and Setters
	protected int getAccountID() {
		return accountID;
	}

	protected void increaseAccountID() {
		accountID++;
	}

	protected String getAccountNumber() {
		return accountNumber;
	}

	protected void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	protected int getAmountOfCurrency() {
		return amountOfCurrency;
	}

	protected void setAmountOfCurrency(int amountOfCurrency) {
		this.amountOfCurrency = amountOfCurrency;
	}
	
}
