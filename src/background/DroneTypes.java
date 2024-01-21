package background;

import java.util.logging.Logger;

public class DroneTypes extends DroneMethods implements Comparison{
	protected static int entityCount = 0;
	private final static Logger LOG = Logger.getLogger(DroneTypes.class.getName());
	protected int typeID;
	protected String manufacturer;
	protected String typeName;
	protected int maxSpeed;
	protected int weight;
	protected int batteryCapacity;
	protected int controlRange;
	protected int maxCarriageWeight;
	
	public DroneTypes(int typeID,String manufacturer,String typeName,int maxSpeed,
			int batteryCapacity,int controlRange,int maxCarriage,int weight) throws ValueLessZeroException,NullPointerException{
		
		this.typeID = typeID;
		this.manufacturer = manufacturer;
		this.typeName = typeName;
		this.maxSpeed = maxSpeed;
		this.batteryCapacity = batteryCapacity;
		this.controlRange = controlRange;
		this.maxCarriageWeight= maxCarriage;
		this.weight = weight;
		
		if(typeID <= 0) {
			LOG.severe("Drone was given with id <= 0");
			return;
		}
		
		if(maxSpeed<0 || batteryCapacity<0 || controlRange<0 || maxCarriage<0 || weight<0)throw new ValueLessZeroException("Drone id:" + typeID +
				" has (an) attributes");
		if(typeName == null || manufacturer == null)throw new NullPointerException();
		entityCount++;
	}
	
	@Override
	public String toString() {
		return "\nThe drone : " +typeID +
				"\nHas the manufacturer: " + manufacturer+
				"\nIts typename is: " +typeName+
				"\nIts max. speed is: " +maxSpeed+
				"\nIts battery capacity is: " +batteryCapacity+
				"\nIts control range is: "+controlRange+
				"\nIts max. carriage is: "+maxCarriageWeight;
	}
	
	public int getId() {
		return typeID;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getTypename() {
		return typeName;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public int getControlRange() {
		return controlRange;
	}

	public int getMaxCarriage() {
		return maxCarriageWeight;
	}

	@Override
	public boolean equals(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.maxSpeed == other.maxSpeed;
	}

	@Override
	public boolean isMore(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.maxSpeed > other.maxSpeed;
	}

	@Override
	public boolean isLess(Object object) {
		DroneTypes other = (DroneTypes) object;
		return this.maxSpeed < other.maxSpeed;
	}

}
