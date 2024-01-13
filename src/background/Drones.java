package background;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

public class Drones extends DroneTypes {
	
	protected ArrayList<DroneDynamics> list = new ArrayList<>();
	protected int droneid;
	protected DroneTime created;
	protected String serialnumber;
	protected int carriage_weight;
	protected String carriage_type;
	private final static Logger LOG = Logger.getLogger(Drones.class.getName());
	
	
	 public Drones(int id,String creat, String number, int carrweight, String carrtype,
			 int typeid,String manufacturer, String name, int maxspeed,int batterycap,int corntrolrange,int maxxcarr,int weight) throws ValueLessZeroException{
		 super(typeid,manufacturer,name,maxspeed,batterycap,corntrolrange,maxxcarr,weight);
		 
		 droneid = id;
		 created = new DroneTime(creat);
	
		 
		 serialnumber = number;
		 carriage_weight = carrweight;
		 carriage_type = carrtype;
		 
		if(droneid <= 0) {
			LOG.severe("Drone was given with id <= 0");
			return;
		}
		if(carriage_weight<0)throw new ValueLessZeroException("Carriage weight of id: " +typeid + "cannot be"); 
		//getDynamics();
		Count.append(this); 
		
	 }
	 
	 //get the time values of when the drone was created
	 
	 
	 
	
	 public void getDynamics() {
			for(DroneDynamics x: DroneBuilder.list) {
				if(x.getId() == this.droneid) {
					this.list.add(x);
				}
			}
			sortDynamics();
			
	 }	
	 
	 
	//sort drone dynamics of drones based on the time of observation
	public void sortDynamics() {
		Collections.sort(list,Comparator.comparing(DroneDynamics::getExactTime));
	} 
	 
	 
	//get-methods
	public int getDroneid() {
		return droneid;
	}

	public DroneTime getCreated() {
		return created;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public int getCarriage_weight() {
		return carriage_weight;
	}

	public String getCarriage_type() {
		return carriage_type;
	}
	
	public ArrayList<DroneDynamics> getList() {
		return list;
	}
	
	public int get_Current_Drone_Speed() {
		return list.get(list.size()-1).getSpeed();
	}
	
	public ArrayList<DroneDynamics> getCurrentDroneDynamics(DroneDate obj){
		ArrayList<DroneDynamics> currentDroneDynamics= new ArrayList<DroneDynamics>();
		
		for(DroneDynamics a: list) {
			
			if(a.getTime().isEqualToTheDate(obj)) {
				currentDroneDynamics.add(a);
			}
			
		}
		
		
		
		return currentDroneDynamics;
	}

	public String toString() {
		
		return 	super.toString()+
				"\nIts drone id is: " +droneid +
				"\nIt was created on: " + created+
				"\nIts serialnumber is: " +serialnumber+
				"\nIts carriage weight is: " +carriage_weight+
				"\nIts carriage type is: " +carriage_type+
				"\n"+list.get(list.size()-1).toString()+".\n";
	}



	
		
	
}
