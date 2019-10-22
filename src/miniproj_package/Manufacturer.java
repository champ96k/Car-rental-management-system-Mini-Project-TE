package miniproj_package;

public class Manufacturer {

	public static String manuf[]=new String[10];

	public static String getManuf(int i) {
		return manuf[i];
	}

	public static void setManuf(String manuf,int i) {
		Manufacturer.manuf[i] = manuf;
	}

}
