package background;

import java.util.Objects;
import java.util.logging.Logger;

import javax.swing.JTextField;

public class DroneTime extends Thread {
	private final static Logger LOG = Logger.getLogger(DroneTime.class.getName());
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private double seconds;   
	private int timeZoneHour;
	private int timeZoneMin;
	private double exactTime;
	
	//Divides String time into DroneTime attributes for the exact time
	public DroneTime(String time) {
		String sub[] = time.split("[-T:+]");
		this.start();
		try {
			year = Integer.valueOf(sub[0]);
			month = Integer.valueOf(sub[1]);
			day = Integer.valueOf(sub[2]);
			hour = Integer.valueOf(sub[3]);
			minute = Integer.valueOf(sub[4]);
			seconds = Double.valueOf(sub[5]);
			timeZoneHour = Integer.valueOf(sub[6]);
			timeZoneMin = Integer.valueOf(sub[7]);
		}
		catch (NumberFormatException e) {
			System.err.println("Something other than a number was assigned to a time attribute!");
			e.printStackTrace();
		}
		if(year<2023||month>12||day>31||hour>24||minute>60||seconds>60) {
			LOG.severe("This is not possible by our understanding of time documentation!!");
			return;
		}
		
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("Could not join Threads which split the string time and calculate the exact time in seconds, respectively.");
		}
	}
	
	public String toString() {
		Months monthName = Months.values()[month-1];
		return year + "/" + monthName + "/" + day + "\t " + hour + ":" + minute + ":" + seconds;
	}
	
	//Calculates exact time in seconds, by converting each DroneTime attribute into seconds.
	@Override
	public void run() {
		exactTime = ((double)year*365.25 + (double)month*30.437 + (double)day)*86400
					 + (double)hour*3600 + (double)minute*60 + seconds;
	}
	
	//Compares if current DroneTime object is greater than another (only compares up to days).
	public boolean isGreater(DroneTime other) {
		
		double thisDays = (double)this.year*365.25 + (double)this.month*30.437 + (double)this.day;
		double otherDays = (double)other.year*365.25 + (double)other.month*30.437 + (double)other.day;
		if(thisDays > otherDays)return true;
		if(thisDays == otherDays)return isGreaterSeconds(other);
		return false;
	}
	
	//Compares up to seconds.
	public boolean isGreaterSeconds(DroneTime other) {
		double thisSeconds = (double)this.hour*3600 + (double)this.minute * 60 + this.seconds;
		double otherSeconds = (double)other.hour*3600 + (double)other.minute*60 + other.seconds;
		if(thisSeconds > otherSeconds)return true;
		return false;
	}
	
	//Gets exact time in seconds.
	public double getExactTime() {
		return exactTime;
	}

	/*
	 * Converts separate JTextField attributes a,b,c,d,e into a correctly formatted String timeString (by API convention).
	 * Then converts timeString into DroneTime object and returns it.
	 */
	public static DroneTime stringifier(JTextField a,JTextField b,JTextField c, JTextField d, JTextField e) {
		String timeString = new String(a.getText()+"-"+b.getText()+"-"+c.getText()+"T"+d.getText()+":"+e.getText()+":0+0:0");
		return new DroneTime(timeString);
	}
	
}
