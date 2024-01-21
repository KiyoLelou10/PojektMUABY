package background;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class Drones extends DroneTypes {
	
	private final static Logger LOG = Logger.getLogger(Drones.class.getName());
	//This list should contain all drone dynamics for the specific drone object 
	protected ArrayList<DroneDynamics> dynamicList = new ArrayList<>();
	protected int droneId;
	protected DroneTime created;
	protected String serialNumber;
	protected int carriageWeight;
	protected String carriageType;
	
	/*
	 * Alongside the normal and obvious things the constructor is meant to do it also appends each
	 * created object to the list of all drones.  
	 * 
	 */
	public Drones(int DroneId,String created, String serialNumber, int carriageWeight, String carriageType,
			 int typeId,String manufacturer, String name, int maxSpeed,int batteryCapacity,
			 int corntrolRange,int maxxCarriage,int weight) throws ValueLessZeroException{
		 
		 super(typeId,manufacturer,name,maxSpeed,batteryCapacity,corntrolRange,maxxCarriage,weight);
		 droneId = DroneId;
		 this.created = new DroneTime(created);
		 this.serialNumber = serialNumber;
		 this.carriageWeight = carriageWeight;
		 this.carriageType = carriageType;
		 if(droneId <= 0) {
			LOG.severe("Drone was given with id <= 0");
			return;
		 }
		 if(carriageWeight<0)throw new ValueLessZeroException("Carriage weight of id: " +typeid + "cannot be"); 
		 getDynamics();
		 Count.append(this); 
   }
	 
	public String toString() {
		return 	super.toString()+
				"\nIts drone id is: " +droneId +
				"\nIt was created on: " + created+
				"\nIts serialnumber is: " +serialNumber+
				"\nIts carriage weight is: " +carriageWeight+
				"\nIts carriage type is: " +carriageType+
				"\n"+dynamicList.get(dynamicList.size()-1).toString()+".\n";
	}
	
	/*
	 * This method takes the list of all drones and compares the objects id to each ID's in the list. 
	 * If the ID's match this object of drone dynamics is added to this objects's list of drone dynamics
	 */
	public void getDynamics() {
			for(DroneDynamics x: DroneBuilder.getDynamicsList()) {
				if(x.getId() == this.droneId) {
					this.dynamicList.add(x);
				}
			}
			sortDynamics();
	 }	
	 
	 
	//sort drone dynamics of drones based on the time of observation: latest observations at the end.
	public void sortDynamics() {
		Collections.sort(dynamicList,Comparator.comparing(DroneDynamics::getExactTime));
	} 
	 
	public int getDroneid() {
		return droneId;
	}

	public DroneTime getCreated() {
		return created;
	}

	public String getSerialnumber() {
		return serialNumber;
	}

	public int getCarriage_weight() {
		return carriageWeight;
	}

	public String getCarriage_type() {
		return carriageType;
	}
	
	public ArrayList<DroneDynamics> getList() {
		return dynamicList;
	}
	
	public int get_Current_Drone_Speed() {
		return dynamicList.get(dynamicList.size()-1).getSpeed();
	}
	
	/*
	 * This method is responsible for returning a list of drone dynamics between two time stamps
	 * where the drone was on. The loop is also broken from if the current time exceeds the later time stamp.
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
	
	/*
	 * this method has three time stamps and checks whether the first is between the other two and whether 
	 * the drone was on.
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
