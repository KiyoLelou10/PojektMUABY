package background;

import java.util.ArrayList;
import java.util.LinkedList;


public class Count{
	private static ArrayList<Drones> list = new ArrayList<>();
	
	
	static protected void append(Drones object) {
		list.add(object);
		for(Drones x : list)x.getDynamics();
		createLists();
	}
	
	static private void createLists() {
		
		
		for(Drones x: list) {
			if(x.getMax_speed() < 35)Speedclasses.slowlist.add(x);
			if(x.getMax_speed() >= 35 && x.getMax_speed() < 60)Speedclasses.averagelist.add(x);
			if(x.getMax_speed() >= 60)Speedclasses.fastlist.add(x);
		}
		
	}
	
	public static void printlist() {
		System.out.println(list.toString());
	}

	
	
}
