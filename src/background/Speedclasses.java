package background;

import java.util.ArrayList;

public class Speedclasses {
	public static ArrayList<Drones> slowlist = new ArrayList<>();
	public static ArrayList<Drones> averagelist = new ArrayList<>();
	public static ArrayList<Drones> fastlist = new ArrayList<>();
	
	public static void  printslow() {
		System.out.println(slowlist.toString());
	}
	
	//function for clearing the list
	protected static void clearList() {
		slowlist.clear();
		averagelist.clear();
		fastlist.clear();
	}
	
}
