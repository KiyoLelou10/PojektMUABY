package background;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DroneBuilder {
	
	private int droneid,carrweight,maxcarr;
	private String created,serialnumber,cartype;
	
	
	private String drone;
	private static String response;
	
	private static String droneType;
	public static ArrayList<DroneDynamics> list = new ArrayList<DroneDynamics>();
	
	private static final String USER_AGENT = "Kiyotaka";
	private static final String ENDPOINT_URL = "http://dronesim.facets-labs.com/api/drones";
	private static final String TOKEN = "Token f9590ca1e9c14e24c99e1adeb03429c10318c8d6";
	private static final String ENDPOINT_URL2 = "http://dronesim.facets-labs.com/api/dronedynamics/";
	
	public DroneBuilder() {
		getDynamics();
		APIreader(ENDPOINT_URL+"/?format=json");
		Dronesbuilder();
		APIreader("http://dronesim.facets-labs.com/api/drones/?limit=10&offset=10/&format=json");
		Dronesbuilder();
		//getDynamics();
		
		
	}
	
	public void getDynamics() {
		APIreader(ENDPOINT_URL2+"?format=json");
		DronedynamicBuilder();
		/*int i = 10;
		 while(i<=28800){
			APIreader(ENDPOINT_URL2+"?limit=10&offset="+i+"&format=json");
			DronedynamicBuilder();
			i = i+10;
			System.out.println(i);
		}*/
		
	}
	
	
	public static void APIreader(String x) {
		URL url;
		try {
			url = new URL(x);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", TOKEN);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = connection.getResponseCode();
		
			System.out.println("Response Code " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			DroneBuilder.response =response.toString();
		} catch (MalformedURLException e) {
			System.err.println("Malformed URL: " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("General IO Exception: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	}
	public void Dronesbuilder() {
		JSONObject wholeFile = new JSONObject(response);
		JSONArray jsonFile = wholeFile.getJSONArray("results");
		for (int i = 0; i < jsonFile.length(); i++) {
			JSONObject o = jsonFile.getJSONObject(i);
			created = o.getString("created");
			cartype = o.getString("carriage_type");
			carrweight = o.getInt("carriage_weight");
			droneid = o.getInt("id");
			serialnumber = o.getString("serialnumber");
			droneType = o.getString("dronetype");
			DronesTypesbuilder();
				
			
		}
		
	}
	public void DronesTypesbuilder() {
		APIreader(droneType);
		JSONObject o = new JSONObject(response);
		int typeid = o.getInt("id");
		String manu = o.getString("manufacturer");
		String name = o.getString("typename");
		int weight = o.getInt("weight");
		int maxspeed = o.getInt("max_speed");
		int battcap = o.getInt("battery_capacity");
		int contrange = o.getInt("control_range");
		maxcarr = o.getInt("max_carriage");	
		try{
			Drones x = new Drones(droneid,created,serialnumber,carrweight,cartype,typeid,manu,name,maxspeed,battcap,contrange,maxcarr,weight);		
			
		}
		catch(ValueLessZeroException | NullPointerException e) {
			e.printStackTrace();
		}
			
		
		
	}
	
	
	public void DronedynamicBuilder() {
		JSONObject wholeFile = new JSONObject(response);
		JSONArray jsonFile = wholeFile.getJSONArray("results");
		for (int i = 0; i < jsonFile.length(); i++) {
			JSONObject o = jsonFile.getJSONObject(i);
			String Status = o.getString("status");
			String time = o.getString("timestamp");
			double longitude = o.getDouble("longitude");
			double latitude = o.getDouble("latitude");
			int battstat = o.getInt("battery_status");
			String lastseen = o.getString("last_seen");
			int speed = o.getInt("speed");
			drone = o.getString("drone");
			double roll = o.getDouble("align_roll");
			double pitch = o.getDouble("align_pitch");
			double yaw = o.getDouble("align_yaw");
			
			int id = getid();
			DroneDynamics x = new DroneDynamics(id, speed, latitude, longitude, time, lastseen, battstat, Status,roll,pitch,yaw);
			list.add(x);
			
				
			
		}
	}
	
	public int getid() {
		APIreader(drone);
		JSONObject o = new JSONObject(response);
		int id = o.getInt("id");
		return id;
	}
	
}
