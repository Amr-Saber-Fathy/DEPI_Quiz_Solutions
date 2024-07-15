package passwordProcessing;

public class PasswordDecryption extends PasswordProcessing{

	public void decryptPassword()
	{
		if(encPassword.isEmpty() || key == 0)
		{
			System.out.println("Please make sure that you entered an Encrypted password and a key");
		}
		else {
			char[] encpasswordArr = encPassword.toCharArray();
			char[] passwordArr = new char[encpasswordArr.length];
			for(int index=0 ; index < encpasswordArr.length ; index++)
			{
				passwordArr[index] = (char)((encpasswordArr[index] - (char)key));
			}
			
			password = "";
			
			for(int i=0 ; i< passwordArr.length ; i++)
			{
				password += passwordArr[i];
			}
		}
	}
}
