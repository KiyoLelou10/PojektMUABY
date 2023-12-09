package background;


import java.util.logging.Logger;
import java.util.ArrayList;

public class DroneDynamics extends Dronemethods implements Comparison{
	
	
	private int id;
	//private int battery_capacity;
	private int speed;
	private double latitude;
	private double longitude;
	private String time;
	private String lastSeen;
	private int BatteryStatus; 
	private String Status;
	
	private final static Logger LOG = Logger.getLogger(DroneDynamics.class.getName());
	
	public DroneDynamics(int id,int speed,double latitude, 
			double longitude,String time,String last,int battstat,String stat) throws ValueLessZeroException{
		
		this.id = id;
		this.speed = speed;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = time;
		lastSeen = last;
		BatteryStatus = battstat;
		if(stat.equals("OF"))this.Status = "OFF";
		else if(stat.equals("ON"))this.Status = "ON";
		else {
			LOG.severe("Status cannot be neither on or off");
			return;
		}
		
		if(getSpeed() <0)throw new ValueLessZeroException("Speed of id: " + id + "cannot be");
		if(getBatteryStatus() <0)throw new ValueLessZeroException("Batterie status of" +id + "cannot be");
		if(getLongitude() <0)throw new ValueLessZeroException("Longitude of" +id + "cannot be");
		if(getLatitude() <0)throw new ValueLessZeroException("Latitude of" +id + "cannot be");
		/*if(getBatteryStatus() > this.battery_capacity) {
			LOG.severe("Batterie of cannot exceed 2147483647 off");
			return;
		}*/
		
		
		
		
		
	}
	
	
	

	
	
	
	
	

	public String toString() {
	
		return "Its speed is currently: " +speed+
				"\nIts current coordinates are: " +latitude +"/"+ longitude+
				"\nIt was last seen on: "+ lastSeen+
				"\nIts battery status is currently: " +BatteryStatus+
				"\nIts Status is: " +Status+"\n";
		
		
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public int getBatteryStatus() {
		return BatteryStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		
		
		return this.speed == other.speed;
	}

	







	@Override
	public boolean opmore(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		return this.getSpeed()>other.getSpeed();
	}









	@Override
	public boolean opless(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		return this.getSpeed()<other.getSpeed();
	}

	

}
