package background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Speedclasses {
	protected static ArrayList<Drones> slowList = new ArrayList<>();
	protected static ArrayList<Drones> averageList = new ArrayList<>();
	protected static ArrayList<Drones> fastList = new ArrayList<>();
	protected static String name;
	
	public static void  printslow() {
		System.out.println(slowList.toString());
	}
	
	//function for clearing the lists
	protected static void clearList() {
		slowList.clear();
		averageList.clear();
		fastList.clear();
	}

	/*
	 * The following 3 getter-methods return the respective lists but also set the String 'name' to the method name.
	 * This is done to save the current list accessed by the user.
	 */
	public static ArrayList<Drones> getSlowlist() throws ListIsEmptyException {
		if(slowList.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getSlowlist");
		return slowList;
	}

	public static ArrayList<Drones> getAveragelist() throws ListIsEmptyException {
		if(averageList.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getAveragelist");
		return averageList;
	}

	public static ArrayList<Drones> getFastlist() throws ListIsEmptyException {
		if(fastList.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getFastlist");
		return fastList;
	}
	
	public static void sortSpeedClasses() {
		Collections.sort(slowList,Comparator.comparing(Drones::getCurrentDroneSpeed));
		Collections.sort(averageList,Comparator.comparing(Drones::getCurrentDroneSpeed));
		Collections.sort(fastList,Comparator.comparing(Drones::getCurrentDroneSpeed));
	}
	
	//this method is used to know in the front end which list is currently used
	public static String getName() throws Exception {
		if(name == null)throw new Exception("Utilizing this method at this point does not make sense");
		return name;
	} 
	
	/*not really practical as this sort algorithm is in O(n^2), presumably the Collections.sort algorithm is at
	least in = (n*log(n)) this method was created a possible solution if sorting the lists by hand*/
	public static void sort_Slow_Class_Beatifully() {
		int i= 0;
		int j = 0;
		for(Drones x: slowList) {
			for(Drones y : slowList) {
				j++;
				DroneDynamics d1 = x.getList().get(x.getList().size()-1);
				DroneDynamics d2 = y.getList().get(y.getList().size()-1);
				if(d1.opmore(d2)) {
					Drones f = x;
					slowList.set(i, y);
					slowList.set(j, f);
				}
			}
			i++;
		}
	}
}
