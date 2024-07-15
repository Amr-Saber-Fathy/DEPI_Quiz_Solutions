package secondQuizSolution;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Governorates {

	
	private List<String> governorates = new ArrayList<>(Arrays.asList("", "CAIRO", "ALEXANDRIA", "PORT_SAID"
			, "SUEZ", "", "", "", "", "", "", "DAMIETTA", "DAKAHLIA", "SHARQIA", "QALYUBIA"
			, "KAFR_EL_SHEIKH", "GHARBIA", "MONUFIA", "BEHEIRA", "ISMAILIA", "", "GIZA", "BENI_SUEF"
			, "FAIYUM", "MINYA", "ASYUT", "SOHAG", "QENA", "ASWAN", "LUXOR", "", "RED_SEA", "NEW_VALLEY"
			, "MATROUH", "NORTH_SINAI", "SOUTH_SINAI"));
	
	//int[] x = {1,2,3,4,11,12,15,14,15,16,16,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35};
	
	public String getGovernorateByCode(int code) 
	{
		return governorates.get(code);
	}
	
	public int getCodeByGovernorate(String governorate) 
	{
		return governorates.indexOf(governorate);
	}
}
