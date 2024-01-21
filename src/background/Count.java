package background;

import java.util.ArrayList;

public class Count{
	//list of all drones
	private static ArrayList<Drones> list = new ArrayList<>();
	protected static boolean activity_flag = false;
	
	static protected void append(Drones object) {
		list.add(object);	
	}
	
	/*
	 * This Method is responsible for dividing the list of all drones into three lists which are later referenced
	 * in the front end. Before this is done the lists need to be cleared, this is done because the front end has an 
	 * automatic and non-automatic way to refresh the data. 
	 * When accessing the new drone data the old should be deleted. 
	 */
	static public void createLists() {
		Speedclasses.clearList();
		for(Drones x: list) {
			if(x.getMax_speed() < 35)Speedclasses.slowlist.add(x);
			if(x.getMax_speed() >= 35 && x.getMax_speed() < 60)Speedclasses.averagelist.add(x);
			if(x.getMax_speed() >= 60)Speedclasses.fastlist.add(x);
		}
		
	}
	
	public static void printlist() {
		System.out.println(list.toString());
	}
	
	static public boolean isFlag() {
		return activity_flag;
	}

	static protected void clearList() {
		list.clear();
	}
	
}
