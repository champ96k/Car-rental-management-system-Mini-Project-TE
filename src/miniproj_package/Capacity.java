package miniproj_package;

public class Capacity {

	public static int capacity[]=new int[10];

	public static int getCapacity(int i) {
		return capacity[i];
	}

	public static void setCapacity(int capacity,int i) {
		Capacity.capacity[i] = capacity;
	}

}
