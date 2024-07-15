package secondQuizSolution;

import java.util.Scanner;

public class Adding16Digits {

	public static void main(String[] args) {
		
		StringBuilder result = new StringBuilder();
		String first16Digits;
		String secon16Digits;
		int tempresult = 0;
		int carry = 0;
		Scanner data = new Scanner(System.in);
		System.out.println("Please enter the first 16 digits number : ");
		first16Digits = data.nextLine();
		System.out.println("Please enter the second 16 digits number : ");
		secon16Digits = data.nextLine();
		
		for(int i = first16Digits.length() ; i > 0 ; i--) 
		{
			tempresult = Integer.parseInt(first16Digits.substring(i-1, i)) + 
						 Integer.parseInt(secon16Digits.substring(i-1, i)) + carry;
			
			if(tempresult > 9) 
			{
				carry = tempresult / 10;
				tempresult -= carry*10;
			}
			else 
			{
				carry = 0;
			}
			result.append(tempresult);
		}
		
		if(carry > 0) 
		{
			result.append(carry);
		}
		
		result.reverse();
		
		System.out.println(first16Digits + " + " + secon16Digits + " = " + result);
		
		data.close();
	}

}
