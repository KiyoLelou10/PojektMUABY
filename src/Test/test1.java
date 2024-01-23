package Test;
import frontend.Firstwindow;
import frontend.LoadingScreen;
import background.DroneTime;

import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.SysexMessage;

import background.Count;
import background.DroneBuilder;
import background.Speedclasses;
import frontend.Firstwindow;

public class test1 extends Thread {
	
	/*
	 * At first the LOG level is set to sever in order to only display severe messages.
	 * This method starts the loading screen. Afterwards it immediately starts fetching all the data from the API.
	 * When this is finished the loading screen is closed and the first window is opened.
	 * It also starts a thread which automatically refreshes the drone data in the background.
	 */
	public static void main(String[] args) throws InterruptedException {

		Logger log = Logger.getLogger("");
		log.setLevel(Level.SEVERE);
		test1 thread1= new test1();
		thread1.start();
		LoadingScreen load = new LoadingScreen();
		DroneBuilder x = new DroneBuilder();
		load.dispose();
		Firstwindow window= new Firstwindow();
		
	}
	
	@Override
	public void run() {
		Logger log = Logger.getLogger(test1.class.getName());
		log.info("This is Thread working");
		while(true) {
			//every 10 minutes the drone data is updated
			try {
				sleep(600000);
				DroneBuilder y = new DroneBuilder();
				log.info("This thread is working");
			} 
			catch (InterruptedException e) {
				System.err.println("Thread has been interrupted.");
				e.printStackTrace();
			}
		}
	}
	
}
