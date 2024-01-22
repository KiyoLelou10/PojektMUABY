package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import background.DroneDynamics;
import background.Drones;
import background.Speedclasses;

public class Aditional_Info extends JFrame {

    private JFrame frame;
    protected Border border;

    public Aditional_Info(Drones drone) {
        frame = initialize();
        JPanel panel1 = giveDataPanel(drone);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel1.setFont(new Font("Times New Roman", Font.BOLD, 40));

        JButton backbutton = giveMeFirstNavigationButton("<-Back", Color.red);
        backbutton.addActionListener(e -> {
            frame.dispose();
            frame.dispose();
            if (drone.getMaxSpeed() < 35) {
                JFrame frame = new speedWindow(Speedclasses.getSlowlist());
            } else if (drone.getMaxSpeed() >= 35 && drone.getMaxSpeed() < 60) {
                JFrame frame = new speedWindow(Speedclasses.getAveragelist());
            } else if (drone.getMaxSpeed() >= 60) {
                JFrame frame = new speedWindow(Speedclasses.getFastlist());
            }
        });

        JButton refresh = giveMeFirstNavigationButton("Refresh", Color.darkGray);
        refresh.addActionListener(e -> {
            frame.dispose();
            new Aditional_Info(drone);
        });

        JButton history = giveMeFirstNavigationButton("History", Color.blue);
        history.addActionListener(e -> {
            HistoryScreen histScreen = new HistoryScreen(drone);
        });

        frame.add(panel1);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backbutton);
        buttonPanel.add(refresh);
        buttonPanel.add(history);

        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
    }

    protected JFrame initialize() {
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.getContentPane().setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(20, 20, 20));
        frame.setVisible(true);
        frame.setResizable(true);
        return frame;
    }

    private JButton giveMeFirstNavigationButton(String text, Color color) {
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

        for (int i = 0; i < labels2.length; i++) {
            labels2[i].setFont(new Font("Segoe UI", Font.BOLD, 25));
            dataPanel.add(labels2[i]);
        }

        return dataPanel;
    }
}
