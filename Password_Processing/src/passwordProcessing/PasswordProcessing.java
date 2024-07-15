package passwordProcessing;

public class PasswordProcessing {

	//Variables
	protected String password ;
	protected String encPassword ;
	protected int key ;
	
	//Constructor
	public PasswordProcessing()
	{
		this.password = "";
		this.encPassword = "";
		this.key = 0;
	}
	
	//getters
	public String getPassword()
	{
		return this.password;
	}
	
	public String getEncPassword()
	{
		return this.encPassword;
	}
	
	public int getKey()
	{
		return this.key;
	}
	
	//setters
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	public void setEncPassword(String encPass)
	{
		this.encPassword = encPass;
	}
	
	public void setKey(int key)
	{
		this.key = key;
	}
}
