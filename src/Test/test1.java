package Test;


import background.DroneTime;

import javax.sound.midi.SysexMessage;

import background.Count;
import background.DroneBuilder;
import background.Speedclasses;

public class test1 {

	public static void main(String[] args) {
		DroneBuilder x = new DroneBuilder();
		for(int i=0;i< Speedclasses.slowlist.size();i++) {
			System.out.print(Speedclasses.slowlist.get(i));
		}
	}
	
}
