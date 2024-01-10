package background;

import java.util.ArrayList;

public class Speedclasses {
	protected static ArrayList<Drones> slowlist = new ArrayList<>();
	protected static ArrayList<Drones> averagelist = new ArrayList<>();
	protected static ArrayList<Drones> fastlist = new ArrayList<>();
	
	public static void  printslow() {
		System.out.println(slowlist.toString());
	}
	
	//function for clearing the list
	protected static void clearList() {
		slowlist.clear();
		averagelist.clear();
		fastlist.clear();
	}

	public static ArrayList<Drones> getSlowlist() {
		return slowlist;
	}

	public static ArrayList<Drones> getAveragelist() {
		return averagelist;
	}

	public static ArrayList<Drones> getFastlist() {
		return fastlist;
	}
	
}
