package background;



public class DroneTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private double seconds;
	private int timezonehour;
	private int timezonemin;
	
	
	
	//divides time String into attributes for the exact time
	public DroneTime(String time) {
		String sub[] = time.split("[-T:+]");
		year = Integer.valueOf(sub[0]);
		month = Integer.valueOf(sub[1]);
		day = Integer.valueOf(sub[2]);
		hour = Integer.valueOf(sub[3]);
		minute = Integer.valueOf(sub[4]);
		seconds = Double.valueOf(sub[5]);
		timezonehour = Integer.valueOf(sub[6]);
		timezonemin = Integer.valueOf(sub[7]);
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
		double result = ((double)year * 365.25+(double)month*30.437+(double)day)*86400
						+(double)hour*3600+(double)minute*60+seconds;
		return result;
	}
	
	//test with toString method
	
	public String toString() {
		Months monthName = Months.values()[month-1];
		return year+"/"+monthName+"/"+day+"\t  "+hour+":"+minute+":"+seconds;
	}
	
	
}
