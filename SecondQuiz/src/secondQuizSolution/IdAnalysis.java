package secondQuizSolution;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class IdAnalysis {

//	public enum Governorate {
//	    CAIRO(1),
//	    ALEXANDRIA(2),
//	    PORT_SAID(3),
//	    SUEZ(4),
//	    DAMIETTA(11),
//	    DAKAHLIA(12),
//	    SHARQIA(13),
//	    QALYUBIA(14),
//	    KAFR_EL_SHEIKH(15),
//	    GHARBIA(16),
//	    MONUFIA(17),
//	    BEHEIRA(18),
//	    ISMAILIA(19),
//	    GIZA(21),
//	    BENI_SUEF(22),
//	    FAIYUM(23),
//	    MINYA(24),
//	    ASYUT(25),
//	    SOHAG(26),
//	    QENA(27),
//	    ASWAN(28),
//	    LUXOR(29),
//	    RED_SEA(31),
//	    NEW_VALLEY(32),
//	    MATROUH(33),
//	    NORTH_SINAI(34),
//	    SOUTH_SINAI(35);
//	    
//		int codeNum;
//	    Governorate(int codeNum)
//	    {
//	    	this.codeNum = codeNum;
//	    }
//	    
//	    public int getCode() {
//	        return codeNum;
//	    }
//	    
//	    public static Governorate fromCode(int code) {
//	        for (Governorate governorate : Governorate.values()) {
//	            if (governorate.getCode() == code) {
//	                return governorate;
//	            }
//	        }
//	        throw new IllegalArgumentException("No governorate with code " + code);
//	    }
//	};
	
	public static void main(String[] args) {
		Governorates gover = new Governorates();
		try (Scanner data = new Scanner(System.in)) {
			System.out.println("Please enter your Id : ");
			String userID = data.nextLine();
			System.out.println("Your ID is : " + userID);
			
			int decate = Integer.parseInt(userID.substring(0, 1));
			int years = Integer.parseInt(userID.substring(1, 3));
			int bornYrear = (decate*10 -1)*100 + years;
			int month = Integer.parseInt(userID.substring(3, 5));
			//System.out.println("Your ID is : " + month);
			int day = Integer.parseInt(userID.substring(5, 7));
			int governorate = Integer.parseInt(userID.substring(7, 9));
			
			
			Calendar calender = Calendar.getInstance();
			calender.set(bornYrear, month-1 , day);
			Date birthDate = calender.getTime();
			
			System.out.println("You were born in : " + birthDate);
			System.out.println("You were born in : " + gover.getGovernorateByCode(governorate));
			
		}

	}

}
