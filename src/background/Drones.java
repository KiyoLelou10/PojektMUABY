package background;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Drones extends DroneTypes {
	
	protected ArrayList<DroneDynamics> list = new ArrayList<>();
	protected int droneid;
	protected String created;
	protected String serialnumber;
	protected int carriage_weight;
	protected String carriage_type;
	private final static Logger LOG = Logger.getLogger(Drones.class.getName());
	
	 public Drones(int id,String creat, String number, int carrweight, String carrtype,
			 int typeid,String manufacturer, String name, int maxspeed,int batterycap,int corntrolrange,int maxxcarr) throws ValueLessZeroException{
		 super(typeid,manufacturer,name,maxspeed,batterycap,corntrolrange,maxxcarr);
		 
		 droneid = id;
		 created = creat;
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
	
	 public void getDynamics() {
			for(DroneDynamics x: DroneBuilder.list) {
				if(x.getId() == this.droneid) {
					this.list.add(x);
				}
			}
		}	
	 
	//get-methods
	public int getDroneid() {
		return droneid;
	}

	public String getCreated() {
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
