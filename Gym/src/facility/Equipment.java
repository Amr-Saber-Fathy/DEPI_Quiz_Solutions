package facility;

public class Equipment {

	private static int equipmentID = 0;
	private String equipmentName = "";
	private String equipmentType = "";
	
	public Equipment(String equipmentName, String equipmentType) 
	{
		setEquipmentID();
		this.setEquipmentName(equipmentName);
		this.setEquipmentType(equipmentType);
	}

	
	/////////Getters and Setters//////////////
	public static int getEquipmentID() {
		return equipmentID;
	}

	private static void setEquipmentID() {
		Equipment.equipmentID ++;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		if(equipmentName == null || equipmentName == "" || equipmentName.length() <= 3) {
			System.out.println("Invalid Equipment Name");
		}
		else {
			this.equipmentName = equipmentName;
		}
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		if(equipmentType == null || equipmentType == "" || equipmentType.length() <= 3) {
			System.out.println("Invalid Equipment Name");
		}
		else {
			this.equipmentType = equipmentType;
		}
	}
	
	
	
}
