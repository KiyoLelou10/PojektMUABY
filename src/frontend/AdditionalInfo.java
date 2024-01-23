package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.*;

import background.DroneDynamics;
import background.Drones;
import background.ListIsEmptyException;

public class AdditionalInfo extends JFrame {

    private JFrame frame;
    protected Method meth;
    protected static HistoryScreen histScreen;

    // Constructor for AdditionalInfo
    public AdditionalInfo(Drones drone, Method meth) {
    	// Initialize the frame and set the method for dynamic retrieval
        frame = initialize();
        this.meth = meth;
        // Create and populate the data panel with drone information
        JPanel panel1 = giveDataPanel(drone);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Create navigation buttons for back, refresh, and history
        JButton backButton = giveNavigationButton("<- Back", Color.red);
        backButton.addActionListener(e -> {
        	// Dispose the current frame and navigate back to the previous screen
            frame.dispose();
            try {
                ArrayList<Drones> list = (ArrayList<Drones>) meth.invoke(null);
                new SpeedWindow(list);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton refreshButton = giveNavigationButton("Refresh", Color.darkGray);
        refreshButton.addActionListener(e -> {
        	// Dispose the current frame and refresh the data for the current drone
            frame.dispose();
            try {
                ArrayList<Drones> list = (ArrayList<Drones>) meth.invoke(null);
                for (Drones drone1 : list) {
                    if (drone1.getDroneID() == drone.getDroneID()) {
                        new AdditionalInfo(drone, meth);
                    }
                }
                if (histScreen.isFlag()) {
                    histScreen.dispose();
                    histScreen = new HistoryScreen(drone);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                new DroneGui();
            }
        });
        
        JButton historyButton = giveNavigationButton("History", Color.blue);
        historyButton.addActionListener(e -> {
        	// Display the history screen for the current drone
            histScreen = new HistoryScreen(drone);
        });
        
        // Add components to the frame
        frame.add(panel1);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(historyButton);
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
    }

    protected JFrame initialize() {
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

    private JButton giveNavigationButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setSize(300, 75);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }

    private JPanel giveDataPanel(Drones drone) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(30, 2));
        
        // Labels for drone information
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
        
        // Labels for DroneDynamics information
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
        
        // Adding DroneDynamics and drone labels to dataPanel
        for (int i = 0; i < labels1.length; i++) {
            labels1[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
            dataPanel.add(labels1[i]);
        }
        // Adding DroneDynamics and drone labels to dataPanel
        for (int i = 0; i < labels2.length; i++) {
            labels2[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
            dataPanel.add(labels2[i]);
        }

        return dataPanel;
    }
}
