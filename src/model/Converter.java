package model;

public class Converter {
	
	
	
	

	public static void main(String[] args) {
		DB db = DB.getInstance();
		OO o = OO.getInstance();
		db.getDataFromRDB();
		o.SaveData();
		System.out.println("Data migrated successfully!");
	}

}
