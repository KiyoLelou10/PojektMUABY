package background;


import java.util.logging.Logger;
import java.util.ArrayList;

public class DroneDynamics extends DroneMethods implements Comparison{
	
	private final static Logger LOG = Logger.getLogger(DroneDynamics.class.getName());
	private int id;
	private int speed;
	private double latitude;
	private double longitude;
	private DroneTime time;
	private DroneTime lastSeen;
	private int batteryStatus; 
	private String status;
	private double alignRoll;
	private double alignPitch;
	private double alignYaw;
	
	public DroneDynamics(int id,int speed,double latitude,double longitude,
			String time,String lastSeen,int batteryStatus,String status,
			double alignRoll,double alignPitch,double alignYaw) throws ValueLessZeroException{
		
		this.alignRoll = alignRoll;
		this.alignPitch = alignPitch;
		this.alignYaw = alignYaw;
		this.id = id;
		this.speed = speed;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = new DroneTime(time);
		this.lastSeen = new DroneTime(lastSeen);
		this.batteryStatus = batteryStatus;
		if(status.equals("OF"))this.status = "OFF";
		else if(status.equals("ON"))this.status = "ON";
		else {
			LOG.severe("Status cannot be neither on nor off");
			return;
		}
		
		if(getSpeed() < 0)throw new ValueLessZeroException("Speed of ID: " + id + "cannot be");
		if(getBatteryStatus() < 0)throw new ValueLessZeroException("Battery status of" + id + "cannot be");
		if(getLongitude() < 0)throw new ValueLessZeroException("Longitude of" + id + "cannot be");
		if(getLatitude() < 0)throw new ValueLessZeroException("Latitude of" + id + "cannot be");
	}
	
	public String toString() {
		return "Its speed is currently: " + speed+
				"\nIts current coordinates are: " + latitude + "/" + longitude+
				"\nIt was last seen on: " + lastSeen+
				"\nIts battery status is currently: " + batteryStatus+
				"\nIts Status is: " + status;
	}
	
	public double getExactTime() {
		return time.getExactTime();
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
		return batteryStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public DroneTime getTime() {
		return time;
	}
	
	public DroneTime getLastSeen() {
		return lastSeen;
	}
	
	public String getStatus() {
		return status;
	}
	
	public double getAlignRoll() {
		return alignRoll;
	}

	public double getAlignPitch() {
		return alignPitch;
	}

	public double getAlignYaw() {
		return alignYaw;
	}

	public boolean equals(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		return this.speed == other.speed;
	}

	@Override
	public boolean isMore(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		return this.getSpeed()>other.getSpeed();
	}

	@Override
	public boolean isLess(Object object) {
		DroneDynamics other = (DroneDynamics) object;
		return this.getSpeed()<other.getSpeed();
	}
	
}
