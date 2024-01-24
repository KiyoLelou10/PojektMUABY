package background;

import java.util.ArrayList;

/**
* Class for creating a list of all drones and splitting them in three lists.
* 
* @author andrej,yunsee
* @version 1.0
*/
public class Count{
	
	/**List of all drones.*/
	private static ArrayList<Drones> droneList = new ArrayList<>();
	
	static protected void append(Drones object) {
		droneList.add(object);	
	}
	
	/**
	 * This Method is responsible for dividing the list of all drones into three lists which are later referenced
	 * in the front end. Before this is done the lists need to be cleared, this is done because the front end has an 
	 * automatic and non-automatic way to refresh the data. 
	 * When accessing the new drone data the old should be deleted. 
	 * It is also responsible for getting the dynamics of each drone.
	 */
	static public void createLists() {
		Speedclasses.clearList();
		for(Drones drone: droneList) {
			getDynamics(drone);
			if(drone.getMaxSpeed() < 35)Speedclasses.slowList.add(drone);
			if(drone.getMaxSpeed() >= 35 && drone.getMaxSpeed() < 60)Speedclasses.averageList.add(drone);
			if(drone.getMaxSpeed() >= 60)Speedclasses.fastList.add(drone);
		}	
	}
	
	private static void getDynamics(Drones drone) {
		drone.getDynamics();
	}
	
	public static void printlist() {
		System.out.println(droneList.toString());
	}
	
	static protected void clearList() {
		droneList.clear();
	}
	
}
