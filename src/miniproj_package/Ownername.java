package miniproj_package;

public class Ownername {

	public static String name[]=new String[10];

	public static String getName(int i) {
		return name[i];
	}

	public static void setName(String name,int i) {
		Ownername.name[i] = name;
	} 

}
