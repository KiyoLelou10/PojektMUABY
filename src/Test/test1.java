package Test;


import background.DroneTime;
import background.Count;
import background.DroneBuilder;
import background.Speedclasses;

public class test1 {

	public static void main(String[] args) {
		DroneBuilder x = new DroneBuilder();
		Count.printlist();
		//tests time function
		DroneTime y = new DroneTime("2023-12-01T15:43:27.940361+01:00");
		System.out.println(y);
		
	}
	
}
