package miniproj_package;

public class Mob {

	public static int mob[]=new int[10];

	public static int getMob(int i) {
		return mob[i];
	}

	public static void setMob(int mob,int i) {
		Mob.mob[i] = mob;
	}

}
