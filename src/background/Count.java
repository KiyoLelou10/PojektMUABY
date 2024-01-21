package background;

import java.util.ArrayList;

public class Count{
	
	//list of all drones
	private static ArrayList<Drones> list = new ArrayList<>();
	protected static boolean activityFlag = false;
	
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
			if(x.getMaxSpeed() < 35)Speedclasses.slowList.add(x);
			if(x.getMaxSpeed() >= 35 && x.getMaxSpeed() < 60)Speedclasses.averageList.add(x);
			if(x.getMaxSpeed() >= 60)Speedclasses.fastList.add(x);
		}	
	}
	
	public static void printlist() {
		System.out.println(list.toString());
	}
	
	static public boolean isFlag() {
		return activityFlag;
	}

	static protected void clearList() {
		list.clear();
	}
	
}
