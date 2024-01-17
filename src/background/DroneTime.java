package background;

import java.util.Objects;
import java.util.logging.Logger;

import javax.swing.JTextField;

public class DroneTime extends Thread {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private double seconds;   
	private int timezonehour;
	private int timezonemin;
	private double exact_Time;
	private final static Logger LOG = Logger.getLogger(DroneTime.class.getName());
	
	//divides time String into attributes for the exact time
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
			timezonehour = Integer.valueOf(sub[6]);
			timezonemin = Integer.valueOf(sub[7]);
		}
		catch (NumberFormatException e) {
			System.out.println("Something other than a number was assigned to a time attribute!");
			e.printStackTrace();
		}
		if(year<2023||month>12||day>31||hour>24||minute>60||seconds>60) {
			LOG.severe("This is not possible by our undertanding of time documentation!!");
			return;
		}
		
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		exact_Time = ((double)year * 365.25+(double)month*30.437+(double)day)*86400
					 +(double)hour*3600+(double)minute*60+seconds;
	}
	
	//compares if current time object is greater than another(only compares up to days)
	public boolean greater(DroneTime other) {
		
		double thisDays = (double)year * 365.25+(double)month*30.437+(double)day;
		double otherDays = (double)other.year * 365.25+(double)other.month*30.437+(double)other.day;
		if(thisDays >otherDays)return true;
		if(thisDays == otherDays)return greaterSecs(other);
		return false;
		
		
	}
	
	//compares up to seconds
	public boolean greaterSecs(DroneTime other) {
		double thisSecs = (double)hour*3600+(double)minute*60+seconds;
		double otherSecs = (double)other.hour*3600+(double)other.minute*60+other.seconds;
		if(thisSecs >otherSecs)return true;
		return false;
		
	}
	
	
	
	//get exact number of seconds
	public double getExactTime() {
		return exact_Time;
	}
	
	//test with toString method
	
	public String toString() {
		Months monthName = Months.values()[month-1];
		return year+"/"+monthName+"/"+day+"\t  "+hour+":"+minute+":"+seconds;
	}

	public static DroneTime stringifier(JTextField a,JTextField b,JTextField c, JTextField d, JTextField e) {
		String x = new String(a.getText()+"-"+b.getText()+"-"+c.getText()+"T"+d.getText()+":"+e.getText()+":0+0:0");
		return new DroneTime(x);
	}
	/*
	public boolean isEqualToTheDate(DroneDate obj) {
		if (obj==null) {
			throw new NullPointerException();
		}
		
		return obj.getDay()==day&&obj.getMonth()==month && obj.getYear()==year;
	
		
	}
	*/

	
	
	
}
