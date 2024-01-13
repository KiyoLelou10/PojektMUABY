package background;

public class DroneDate {
	
	
	private int minute;
	private int hour;
	private int day;
	private int month;
	private int year;
	
	
	public DroneDate(int minute, int hour, int day, int month, int year) {
		super();
		this.minute = minute;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	
	public double get_Exact_Time() {
		return year*5256000+(double)month*43800.048+day*1440+60*hour+minute;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	

}
