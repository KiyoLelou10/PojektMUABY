package background;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

/**
* Class for attributes of drones.
* 
* @author andrej,yunsee
* @version 1.0
*/
public class Drones extends DroneTypes {
	
	private final static Logger LOG = Logger.getLogger(Drones.class.getName());
	/**This list should contain all drone dynamics for the specific drone object.*/ 
	private ArrayList<DroneDynamics> dynamicList = new ArrayList<>();
	private int droneID;
	private DroneTime created;
	private String serialNumber;
	private int carriageWeight;
	private String carriageType;
	
	/**
	 * Alongside the normal and obvious things the constructor is meant to do, it also appends each
	 * created object to the list of all drones. 
	 * @param are all the values the drones have, these are provided by the API. 
	 */
	public Drones(int droneID,String created, String serialNumber, int carriageWeight, String carriageType,
			 int typeID,String manufacturer, String name, int maxSpeed,int batteryCapacity,
			 int corntrolRange,int maxCarriage,int weight) throws ValueLessZeroException{
		 
		 super(typeID,manufacturer,name,maxSpeed,batteryCapacity,corntrolRange,maxCarriage,weight);
		 this.droneID = droneID;
		 this.created = new DroneTime(created);
		 this.serialNumber = serialNumber;
		 this.carriageWeight = carriageWeight;
		 this.carriageType = carriageType;
		 
		 if(droneID <= 0) {
			LOG.severe("Drone was given with id <= 0");
			return;
		 }
		 
		 if(carriageWeight < 0)throw new ValueLessZeroException("Carriage weight of id: " + droneID + "cannot be"); 
		 Count.append(this); 
   }
	 
	public String toString() {
		return 	super.toString()+
				"\nIts drone id is: " + droneID +
				"\nIt was created on: " + created + 
				"\nIts serialnumber is: " + serialNumber +
				"\nIts carriage weight is: " + carriageWeight +
				"\nIts carriage type is: " + carriageType +
				"\n" + dynamicList.get(dynamicList.size()-1).toString()+".\n";
	}
	
	/**
	 * This method takes the list of all drones and compares the object's ID to each ID in the list. 
	 * If the IDs match, these objects of drone dynamics are added to this objects's list of drone dynamics.
	 */
	public void getDynamics() {
			for(DroneDynamics x: DroneBuilder.getDynamicsList()) {
				if(x.getId() == this.droneID) {
					this.dynamicList.add(x);
				}
			}
			sortDynamics();
	 }	
	 
	/**Sorts drone dynamics of drones based on the time of observation: latest observations at the end.*/
	public void sortDynamics() {
		Collections.sort(dynamicList,Comparator.comparing(DroneDynamics::getExactTime));
	} 
	 
	public int getDroneID() {
		return droneID;
	}

	public DroneTime getCreated() {
		return created;
	}

	public String getSerialnumber() {
		return serialNumber;
	}

	public int getCarriageWeight() {
		return carriageWeight;
	}

	public String getCarriageType() {
		return carriageType;
	}
	
	public ArrayList<DroneDynamics> getList() {
		return dynamicList;
	}
	
	public int getCurrentDroneSpeed() {
		return dynamicList.get(dynamicList.size()-1).getSpeed();
	}
	
	/**
	 * This method is responsible for returning a list of drone dynamics between two time stamps.
	 * where the drone was turned on. The loop is also broken from if the current time exceeds the later time stamp.
	 *@param is the beginning and end time indicating the time period which is of relevance here.
	 *@return is a list of drone dynamics containing all drone dynamics in the time period, when the drone was 'on'. 
	 */
	public ArrayList<DroneDynamics> getCurrentDroneDynamics(DroneTime beginning, DroneTime end){
		ArrayList<DroneDynamics> currentDroneDynamics= new ArrayList<DroneDynamics>();
		for(DroneDynamics current: dynamicList) {
			if(isInside(current, beginning, end)) {
				currentDroneDynamics.add(current);
			}
			if(current.getExactTime()>end.getExactTime())break;
		}
		return currentDroneDynamics;
	}
	
	/**
	 * This method has three time stamps and checks whether the first is between the other two and whether 
	 * the drone was on.
	 * @param are a drone dynamic and the begging/end time.
	 * @return true if the time of the drone dynamic is between the beginning and end time.
	*/
	private boolean isInside(DroneDynamics current, DroneTime beginning, DroneTime end) {
		if(current.getExactTime() >= beginning.getExactTime() && 
		   current.getExactTime() <= end.getExactTime() && 
		   current.getStatus().equals("ON")) {
			 return true;
		}
		return false;
	}
	
	public int getDynamicSize() {
		return dynamicList.size();
	}
	
}
