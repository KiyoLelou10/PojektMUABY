package frontend;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.*;
import background.DroneDynamics;
import background.Drones;

/**
* Class for additional info frame of drones displaying types and dynamics.
* 
* @author bilal,andrej(partially), utkarsh(partially)
* @version 1.0
*/
public class AdditionalInfo extends JFrame {

	private static HistoryScreen historyScreen;
    private JFrame frame;
    private Method method;

    public AdditionalInfo(Drones drone, Method method) {
    	/** Initialize the frame and set the method for dynamic retrieval (to know which list is currently accessed)*/
        frame = initialize();
        this.method = method;
        /** Create and populate the data panel with drone information */
        JPanel panel1 = giveDataPanel(drone);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /** Create navigation buttons for back, refresh, and history */
        JButton backButton = giveNavigationButton("<- Back", Color.red);
        backButton.addActionListener(e -> {
        	/** Dispose the current frame and navigate back to the previous screen */
            frame.dispose();
            try {
                ArrayList<Drones> list = (ArrayList<Drones>) method.invoke(null);
                new SpeedWindow(list);
            } catch (Exception e1) {
            	System.err.println("Invoking the method did not work or the lists were empty");
                e1.printStackTrace();
                /**Get back to screen without drone information*/
                new DroneGui();
            }
        });

        JButton refreshButton = giveNavigationButton("Refresh", Color.darkGray);
        refreshButton.addActionListener(e -> {
        	/** Dispose the current frame and refresh the data for the current drone */
            frame.dispose();
            try {
                ArrayList<Drones> list = (ArrayList<Drones>) method.invoke(null);
                for (Drones drone1 : list) {
                    if (drone1.getDroneID() == drone.getDroneID()) {
                        new AdditionalInfo(drone, method);
                    }
                }
                /**
                 * It is also checked whether the history screen is
                 * opened while refreshing, if so the history screen will also be refreshed 
                 */
                if (historyScreen.isFlag()) {
                    historyScreen.dispose();
                    historyScreen = new HistoryScreen(drone);
                }
            } catch (Exception e1) {
            	System.err.println("Invoking the method did not work or the lists were empty");
                e1.printStackTrace();
                /**Get back to screen without drone information*/
                new DroneGui();
            }
        });
        
        JButton historyButton = giveNavigationButton("History", Color.blue);
        historyButton.addActionListener(e -> {
        	/** Display the history screen for the current drone*/
            historyScreen = new HistoryScreen(drone);
        });
        
        /** Add components to the frame */
        frame.add(panel1);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(historyButton);
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
    }

    private JFrame initialize() {
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(20, 20, 20));
        frame.setVisible(true);
        frame.setResizable(true);
        return frame;
    }

    /**
     * Creates a JButton with a standard size and specific color, primarily used for navigation.
     * This method sets up a JButton with specified text and background color. The text color is
     * set to white by default. The button size is standardized to maintain a consistent design
     * across different windows. Additionally, an action listener is attached to the button which,
     * when activated, disposes the current window and opens a new instance of DroneGUI.
     *
     * @param text The text to be displayed on the button.
     * @param color The background color of the button.
     * @return A JButton with the specified text and background color, along with a predefined action listener.
     */
    
    private JButton giveNavigationButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setSize(300, 75);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }

    /**
     * Constructs a JPanel displaying  information for a specific drone and its dynamics.
     * The panel is organized in a grid layout, showing key drone attributes such as ID, creation date,
     * manufacturer, speed, carriage details, and battery capacity. Additionally, it displays the latest
     * dynamics of the drone including location, speed, time, battery status, and alignment. The information
     * is displayed in a series of labeled pairs for easy readability, with each label styled for emphasis.
     * This method is ideal for providing a detailed view of a drone's specifications and current status.
     * Moreover, Refresh button is there as well for fetching the latest information from the API in case data 
     * gets changed back there.
     *
     * @param drone The Drones object to display information from.
     * @return A JPanel displaying detailed information about the drone and its dynamics.
     */

    
    
    private JPanel giveDataPanel(Drones drone) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(30, 2));
        
        /** Labels for drone information */
        JLabel[] labels1 = {
            new JLabel("Drone ID: "), new JLabel(String.valueOf(drone.getId())),
            new JLabel("Created: "), new JLabel(String.valueOf(drone.getCreated())),
            new JLabel("Drone Number: "), new JLabel(String.valueOf(drone.getDroneID())),
            new JLabel("Drone Carrweight: "), new JLabel(String.valueOf(drone.getCarriageWeight())),
            new JLabel("Drone carrtype: "), new JLabel(String.valueOf(drone.getCarriageType())),
            new JLabel("Manufacturer: "), new JLabel(String.valueOf(drone.getManufacturer())),
            new JLabel("Max Speed: "), new JLabel(String.valueOf(drone.getMaxSpeed())),
            new JLabel("Max Carriage: "), new JLabel(String.valueOf(drone.getMaxCarriage())),
            new JLabel("Battery Capacity: "), new JLabel(String.valueOf(drone.getBatteryCapacity())),
            new JLabel("Control Range: "), new JLabel(String.valueOf(drone.getControlRange()))
        };
        
        /** Labels for DroneDynamics information */
        DroneDynamics dd = drone.getList().get(drone.getList().size() - 1);
        JLabel[] labels2 = {
            new JLabel("DroneDynamics ID: "), new JLabel(String.valueOf(dd.getId())),
            new JLabel("DroneDynamics Latitude: "), new JLabel(String.valueOf(dd.getLatitude())),
            new JLabel("DroneDynamics Speed: "), new JLabel(String.valueOf(dd.getSpeed())),
            new JLabel("DroneDynamics Longitude: "), new JLabel(String.valueOf(dd.getLongitude())),
            new JLabel("DroneDynamics Time: "), new JLabel(String.valueOf(dd.getTime())),
            new JLabel("DroneDynamics LastSeen: "), new JLabel(String.valueOf(dd.getLastSeen())),
            new JLabel("DroneDynamics BatteryStatus: "), new JLabel(String.valueOf(dd.getBatteryStatus() / drone.getBatteryCapacity() * 100) + "%"),
            new JLabel("DroneDynamics Status: "), new JLabel(String.valueOf(dd.getStatus())),
            new JLabel("DroneDynamics Roll: "), new JLabel(String.valueOf(dd.getAlignRoll())),
            new JLabel("DroneDynamics Pitch: "), new JLabel(String.valueOf(dd.getAlignPitch())),
            new JLabel("DroneDynamics Yaw: "), new JLabel(String.valueOf(dd.getAlignYaw()))
        };
        
        for (int i = 0; i < labels1.length; i++) {
            labels1[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
            dataPanel.add(labels1[i]);
        }
        for (int i = 0; i < labels2.length; i++) {
            labels2[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
            dataPanel.add(labels2[i]);
        }
        return dataPanel;
    }
    
}
