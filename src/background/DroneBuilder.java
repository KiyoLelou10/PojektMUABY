package background;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

/**
* Class for fetching all data from the API.
* 
* @author andrej,yunsee
* @since 1.8
* @version 1.0
*/
public class DroneBuilder implements Runnable {
	
	private static ArrayList<DroneDynamics> dynamicsList = new ArrayList<DroneDynamics>();
	private static final String USER_AGENT = "Kiyotaka";
	private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/drones";
	private static final String TOKEN = "Token f9590ca1e9c14e24c99e1adeb03429c10318c8d6";
	private static final String ENDPOINT_URL2 = "http://dronesim.facets-labs.com/api/dronedynamics/";
	private static String response;
	private static JSONObject dataFile;
	private static int droneCount;
	private static int dynamicCount;
	private int droneID,carriageWeight;
	private String created,serialNumber,carriageType;
	
	/**
	 * This constructor links our class instances with their various respective drone data received by the API.
	 * This constructor also clears the list containing all old instances of the drones and overwrites them with the new.
	 * It starts by receiving the amount of drones, afterwards it receives the drones data.   
	 */
	public DroneBuilder(){
		Count.clearList();
		setCountDrone();
		readAPI(ENDPOINT_URL+"/?limit="+droneCount+"&format=json");
		dronesBuilder();
	}
	
	/**This Thread is responsible for enquiring the number of dynamics and afterwards reading the whole data */
	@Override
	public void run() {
		setCountDynamics();
		readDynamics();
		Count.createLists();
	}
	
	private void readDynamics() {
		readAPI(ENDPOINT_URL2+"?limit="+dynamicCount+"&format=json");
		droneDynamicBuilder();
	}
	
	/**Reads the amount Drones and Dynamics, these are saved in count attributes.*/
	private void setCountDrone() {
		readAPI(ENDPOINT_URL+"/?format=json");
		droneCount = Integer.valueOf(response.split("[:,]")[1]);
	}
	
	private void setCountDynamics() {
		readAPI(ENDPOINT_URL2+"?format=json");
		dynamicCount = Integer.valueOf(response.split("[:,]")[1]);
		
		Logger LOG = Logger.getLogger(DroneBuilder.class.getName());
		LOG.info("These are the dynamics: " +dynamicCount +"/"+droneCount);
	}
	
	/**
	 * This method is responsible for gaining access to the drone API, through an access token. 
	 * It then follows up by reading all data available on the URL, this is afterwards saved in a JSON object attribute.  
	 */
	public static void readAPI(String x) {
		URL url;
		try {
			url = new URL(x);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", TOKEN);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null && "next" != null) {
				response.append(inputLine);
			}
			in.close();
			DroneBuilder.response = response.toString();
			dataFile = new JSONObject(DroneBuilder.response);
		} 
		catch (MalformedURLException e) {
			System.err.println("Malformed URL: " + e.getLocalizedMessage());
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.err.println("General IO Exception: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * The following three methods utilize the respective JSON object (response string) and generate our classes attributes 
	 * by splitting set JSON object. Afterwards objects of the respective classes are instantiated.  
	*/
	private void dronesBuilder() {
		JSONArray jsonFile = dataFile.getJSONArray("results");
		for (int i = 0; i < jsonFile.length(); i++) {
			JSONObject dataFile = jsonFile.getJSONObject(i);
			created = dataFile.getString("created");
			carriageType = dataFile.getString("carriage_type");
			carriageWeight = dataFile.getInt("carriage_weight");
			droneID = dataFile.getInt("id");
			serialNumber = dataFile.getString("serialnumber");
			String droneType = dataFile.getString("dronetype");
			droneTypesBuilder(droneType);
		}
	}
	private void droneTypesBuilder(String droneType) {
		readAPI(droneType);
		int typeID = dataFile.getInt("id");
		String manufacturer = dataFile.getString("manufacturer");
		String typeName = dataFile.getString("typename");
		int weight = dataFile.getInt("weight");
		int maxSpeed = dataFile.getInt("max_speed");
		int batteryCapacity = dataFile.getInt("battery_capacity");
		int controlRange = dataFile.getInt("control_range");
		int maxcarr = dataFile.getInt("max_carriage");	
		try{
			Drones newDrone = new Drones(droneID,created,serialNumber,carriageWeight,carriageType,
					typeID,manufacturer,typeName,maxSpeed,batteryCapacity,controlRange,maxcarr,weight);		
		}
		catch(ValueLessZeroException | NullPointerException e) {
			System.err.println("A attribute was provided which is less or zero, "
					+ "even though this is impossible for set attribute");
			e.printStackTrace();
		}
	}
	
	private void droneDynamicBuilder() {
		JSONArray jsonFile = dataFile.getJSONArray("results");
		for (int i = 0; i < jsonFile.length(); i++) {
			JSONObject dataFile = jsonFile.getJSONObject(i);
			String Status = dataFile.getString("status");
			String time = dataFile.getString("timestamp");
			double longitude = dataFile.getDouble("longitude");
			double latitude = dataFile.getDouble("latitude");
			int batteryStatus = dataFile.getInt("battery_status");
			String lastSeen = dataFile.getString("last_seen");
			int speed = dataFile.getInt("speed");
			String drone = dataFile.getString("drone");
			double roll = dataFile.getDouble("align_roll");
			double pitch = dataFile.getDouble("align_pitch");
			double yaw = dataFile.getDouble("align_yaw");
			int id = getID(drone);
			try {
				DroneDynamics x = new DroneDynamics(id, speed, latitude, longitude, time, lastSeen, 
						batteryStatus, Status,roll,pitch,yaw);
				dynamicsList.add(x);
			}
			catch(ValueLessZeroException e) {
				System.err.println("A attribute was provided which is less zero, "
						+ "even though this is impossible for set attribute");
				e.printStackTrace();
			}	
		}
	}
	
	private int getID(String drone) {
		int id = Integer.valueOf(drone.split("/")[5]);
		return id;
	}
	
	public static ArrayList<DroneDynamics> getDynamicsList(){
		return dynamicsList;
	}

	
	
}
