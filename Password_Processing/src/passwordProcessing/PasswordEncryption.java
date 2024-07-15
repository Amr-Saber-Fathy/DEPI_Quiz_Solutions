package passwordProcessing;

public class PasswordEncryption extends PasswordProcessing{

	public void encryptPassword()
	{
		if(password.isEmpty() || key == 0)
		{
			System.out.println("Please make sure that you entered a password and a key");
		}
		else {
			char[] passwordArr = password.toCharArray();
			char[] encpasswordArr = new char[passwordArr.length];
			for(int index=0 ; index < passwordArr.length ; index++)
			{
				encpasswordArr[index] = (char)((passwordArr[index] + (char)key));
			}
			
			encPassword = "";
			
			for(int i=0 ; i< encpasswordArr.length ; i++)
			{
				encPassword += encpasswordArr[i];
			}
		}
	}
}
