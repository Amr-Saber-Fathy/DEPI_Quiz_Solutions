package passwordProcessing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordEncryption myPass = new PasswordEncryption();
		myPass.setPassword("Amr");
		myPass.setKey(5);
		myPass.encryptPassword();
		System.out.println(myPass.getPassword());
		String myEncPass = myPass.getEncPassword();
		System.out.println(myEncPass);
		
		myPass.setPassword("dhy");
		
		PasswordDecryption myEncryption = new PasswordDecryption();
		myEncryption.setEncPassword("Frw");
		myEncryption.setKey(5);
		myEncryption.decryptPassword();
		String myDecPass = myEncryption.getPassword();
		System.out.println(myDecPass);
	}

}
