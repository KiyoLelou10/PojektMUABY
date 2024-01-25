package background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
* Class for the three distinct speed classes of the drones.
* 
* @author andrej,yunsee
* @version 1.0
*/
public class SpeedClasses {
	protected static ArrayList<Drones> slowList = new ArrayList<>();
	protected static ArrayList<Drones> averageList = new ArrayList<>();
	protected static ArrayList<Drones> fastList = new ArrayList<>();
	protected static String name;
	
	/**Function for clearing the lists.*/
	protected static void clearList() {
		slowList.clear();
		averageList.clear();
		fastList.clear();
	}

	/**
	 * The following 3 getter-methods return the respective lists but also set the String 'name' to the method name.
	 * This is done to save the current list accessed by the user.
	 * @return the respective list.
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
	
	/**@return method name in order to know in the front end which list is currently being accessed.*/
	public static String getName() throws Exception {
		if(name == null)throw new Exception("Utilizing this method at this point does not make sense");
		return name;
	} 
	
	/**
	 * Not really practical as this sort algorithm is in O(n^2), presumably the Collections.sort algorithm is at least in = (n*log(n)).
	 * This method was created as a possible solution if sorting the lists by hand.
	*/
	public static void sortSlowListBeautifully() {
		int i= 0;
		int j = 0;
		for(Drones x: slowList) {
			for(Drones y : slowList) {
				j++;
				DroneDynamics d1 = x.getList().get(x.getList().size()-1);
				DroneDynamics d2 = y.getList().get(y.getList().size()-1);
				if(d1.isMore(d2)) {
					Drones f = x;
					slowList.set(i, y);
					slowList.set(j, f);
				}
			}
			i++;
		}
	}
}