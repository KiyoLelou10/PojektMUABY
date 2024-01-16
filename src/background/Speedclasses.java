package background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Speedclasses {
	protected static ArrayList<Drones> slowlist = new ArrayList<>();
	protected static ArrayList<Drones> averagelist = new ArrayList<>();
	protected static ArrayList<Drones> fastlist = new ArrayList<>();
	protected static String name;
	
	
	public static void  printslow() {
		System.out.println(slowlist.toString());
	}
	
	//function for clearing the list
	protected static void clearList() {
		slowlist.clear();
		averagelist.clear();
		fastlist.clear();
	}

	public static ArrayList<Drones> getSlowlist() throws ListIsEmptyException {
		if(slowlist.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getSlowlist");
		return slowlist;
	}

	public static ArrayList<Drones> getAveragelist() throws ListIsEmptyException {
		if(averagelist.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getAveragelist");
		return averagelist;
	}

	public static ArrayList<Drones> getFastlist() throws ListIsEmptyException {
		if(fastlist.isEmpty() == true)throw new ListIsEmptyException();
		name = new String("getFastlist");
		return fastlist;
	}
	
	
	public static void sort_Speed_Classes() {
		Collections.sort(slowlist,Comparator.comparing(Drones::get_Current_Drone_Speed));
	}
	
	//this method is used to know in the front end which list is currently used
	public static String get_Name() throws Exception {
		if(name == null)throw new Exception("Utilizing this method at this point does not make sense");
		return name;
	} 
	
	
	
	/*not really practical as this sort algorithm is in O(n^2), presumably the Collections.sort algorithm is at
	least in = (n*log(n)) this method was created a possible solution if sorting the lists by hand*/
	public static void sort_Slow_Class_Beatifully() {
		int i= 0;
		int j = 0;
		for(Drones x: slowlist) {
			for(Drones y : slowlist) {
				j++;
				DroneDynamics d1 = x.getList().get(x.getList().size()-1);
				DroneDynamics d2 = y.getList().get(y.getList().size()-1);
				if(d1.opmore(d2)) {
					Drones f = x;
					slowlist.set(i, y);
					slowlist.set(j, f);
				}
				
			}
			i++;
		}
	}
}
