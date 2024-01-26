package Test;
import frontend.FirstWindow;
import frontend.LoadingScreen;
import background.DroneTime;

import java.net.ConnectException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.SysexMessage;

import background.Count;
import background.DroneBuilder;
import background.SpeedClasses;
import frontend.FirstWindow;

/**
* Class for running the program it also automatically refreshes the data every 10 minutes. 
* 
* @author Andrej
* @since 1.8
* @version 1.0
*/
public class Test implements Runnable {
	
	/**
	 * At first the global LOG level is set to sever in order to only display severe messages.
	 * This method starts the loading screen. Afterwards it immediately starts fetching all the data from the API.
	 * When this is finished the loading screen is closed and the first window is opened.
	 * It also starts a thread which automatically refreshes the drone data in the background.
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Logger log = Logger.getLogger("");
		log.setLevel(Level.SEVERE);
		Test runnable= new Test();
		Thread autoRefreshThread = new Thread (runnable);
		autoRefreshThread.start();
		
		LoadingScreen load = new LoadingScreen();
		DroneBuilder drones = new DroneBuilder();
		Thread dynamicsThread = new Thread(drones);
		dynamicsThread.start();
		dynamicsThread.join();
		load.dispose();
		FirstWindow window= new FirstWindow();
	}
	
	@Override
	public void run() {
		Logger log = Logger.getLogger(Test.class.getName());
		log.info("This is Thread working");
		while(true) {
			/**every 10 minutes the drone data is updated*/
			try {
				Thread.sleep(600000);
				DroneBuilder drones = new DroneBuilder();
				log.info("This thread is working");
			} 
			catch (InterruptedException e) {
				System.err.println("Thread has been interrupted.");
				e.printStackTrace();
			}
		}
	}


	
}
