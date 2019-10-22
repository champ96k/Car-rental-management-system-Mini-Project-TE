package miniproj_package;

public class Carno {

	public static String carno[]=new String[10];

	public static String getCarno(int i) {
		return carno[i];
	}

	public static void setCarno(String carno,int i) {
		Carno.carno[i] = carno;
	}

}
