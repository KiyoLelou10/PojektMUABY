package Test;
import frontend.Firstwindow;
import frontend.Loading_Screen;
import background.DroneTime;

import java.util.logging.Level;
import java.util.logging.Logger;

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
		Logger log = Logger.getLogger("");
		log.setLevel(Level.SEVERE);
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
		Logger log = Logger.getLogger(test1.class.getName());
		log.info("THis is Thread working");
		while(true) {
			
			//every 10 minutes the drone data is updated
			try {
			
				sleep(600000);
				DroneBuilder y = new DroneBuilder();
				
				log.info("This thread is working");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	
}
