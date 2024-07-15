package secondQuizSolution;

import java.util.Scanner;

public class Adding16DigitsV2 {

	public static void main(String[] args) {
		
		StringBuilder result = new StringBuilder();
		String first16Digits;
		String secon16Digits;
		long tempresult = 0;
		int carry = 0;
		Scanner data = new Scanner(System.in);
		System.out.println("Please enter the first 16 digits number : ");
		first16Digits = data.nextLine();
		System.out.println("Please enter the second 16 digits number : ");
		secon16Digits = data.nextLine();
		
		for(int i = first16Digits.length() ; i > 0 ; i-=8) 
		{
			tempresult = Long.parseLong(first16Digits.substring(i-8, i)) + 
						 Long.parseLong(secon16Digits.substring(i-8, i)) + carry;
			
			if(tempresult > 99999999) 
			{
				carry = (int) (tempresult / 100000000);
				tempresult -= carry*100000000;
			}
			else 
			{
				carry = 0;
			}
			result.insert(0, tempresult);
		}
		
		if(carry > 0) 
		{
			result.insert(0,carry);
		}
		
		//result.reverse();
		
		System.out.println(first16Digits + " + " + secon16Digits + " = " + result);
		
		data.close();
	}

}
