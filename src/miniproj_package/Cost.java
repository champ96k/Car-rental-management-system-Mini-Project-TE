package miniproj_package;

public class Cost {

	public static int cost[]=new int[10];
	
	public static int getCost(int i) {
		return cost[i];
	}

	public static void setCost(int cost,int i) {
		
		Cost.cost[i] = cost;
	}
	
}
