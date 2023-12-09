package background;

import java.util.logging.Logger;

public class DroneTypes extends Dronemethods implements Comparison{
	protected int typeid;
	protected static int entity = 0;
	protected String manufacturer;
	protected String typename;
	protected int max_speed;
	protected int battery_capacity;
	protected int control_range;
	protected int max_carriage;
	private final static Logger LOG = Logger.getLogger(DroneTypes.class.getName());
	
	public DroneTypes(int id, String manu,String name, int maxspeed,int batterycap,int controlrange,int maxcarr) throws ValueLessZeroException,NullPointerException{
		
		typeid = id;
		manufacturer = manu;
		typename = name;
		max_speed = maxspeed;
		battery_capacity = batterycap;
		control_range = controlrange;
		max_carriage= maxcarr;
		
		if(typeid <= 0) {
			LOG.severe("Drone was given with id <= 0");
			return;
		}
		if(max_speed<0 || battery_capacity<0 || control_range<0 || max_carriage<0)throw new ValueLessZeroException("Drone id:" + typeid +
				" has (an) attributes");
		if(typename == null || manufacturer == null)throw new NullPointerException();
		entity++;
		
	}
	
	
	
	
	
	
	
	
	//get-methods
	public int getId() {
		
		return typeid;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public String getTypename() {
		return typename;
	}


	public int getMax_speed() {
		return max_speed;
	}


	public int getBattery_capacity() {
		return battery_capacity;
	}


	public int getControl_range() {
		return control_range;
	}


	public int getMax_carriage() {
		return max_carriage;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nThe drone : " +typeid +
				"\nHas the manufacturer: " + manufacturer+
				"\nIts typename is: " +typename+
				"\nIts max. speed is: " +max_speed+
				"\nIts battery capacity is: " +battery_capacity+
				"\nIts control range is: "+control_range+
				"\nIts max. carriage is: "+max_carriage;
	}

	@Override
	public boolean equals(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.max_speed == other.max_speed;
	}

	@Override
	public boolean opmore(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.max_speed > other.max_speed;
	}

	@Override
	public boolean opless(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.max_speed < other.max_speed;
	}




	


	
		
}
