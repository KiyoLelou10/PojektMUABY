package Test;
import frontend.Firstwindow;
import frontend.Loading_Screen;
import background.DroneTime;

import javax.sound.midi.SysexMessage;

import background.Count;
import background.DroneBuilder;
import background.Speedclasses;
import frontend.Firstwindow;

public class test1 extends Thread {

	
	public static void main(String[] args) throws InterruptedException {
//		
//		for(int i=0;i< Speedclasses.slowlist.size();i++) {
//			System.out.print(Speedclasses.slowlist.get(i));
//			
//		}
		
		test1 thread1= new test1();
		thread1.start();
		Loading_Screen load = new Loading_Screen();
		DroneBuilder x = new DroneBuilder();
		load.dispose();
		Firstwindow window= new Firstwindow();
		
		
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("THis is Thread working");
		while(true) {
			
			//every 5 minutes the drone data is updated
			try {
				sleep(300000);
				DroneBuilder y = new DroneBuilder();
				System.out.println("This is working");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	
}
