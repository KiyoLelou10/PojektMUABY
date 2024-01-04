package frontend;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import background.DroneDynamics;
import background.Drones;

public class Aditional_Info extends JFrame{

	private JFrame frame;
	protected Border border;
	
	public Aditional_Info(Drones drone) {
		frame=initialize();
		JPanel panel1 = giveDataPanel(drone);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel1.setFont(new Font("Times New Roman",Font.BOLD,40));
        //getContentPane().add(panel1);
        JButton JB3= giveMeFirstNavigationButton("<-Back", Color.red);
		JB3.addActionListener(e->{
			System.out.print("This got clicked");
			frame.dispose();
			//THe JB3 Button should create an new instance of the class speedWindow! please add an argument to the constructor. 
		   // speedWindow guuu = new speedWindow(ArrayList<Drones> list);
			
		});
		
        JButton JB4= giveMeFirstNavigationButton("History", Color.blue);
		JB4.addActionListener(e->{
			// This Button should display the last 5 DroneDynamics !!
			System.out.print("This got clicked");
			frame.dispose();
	
			
		});
		
        frame.add(panel1);
        frame.add(JB3);
        frame.add(JB4);
    
	}

	protected JFrame initialize() {
	
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setExtendedState(MAXIMIZED_BOTH);
	    frame.getContentPane().setEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(20,20,20));
		frame.setVisible(true);
		return frame;
		
	}
	
	private JButton giveMeFirstNavigationButton(String Text, Color color) {
		JButton button= new JButton(Text);
		button.setSize(300,75);
		button.setFocusable(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		return button;
	}
	
    private JPanel giveDataPanel(Drones drone) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(30,2));
        JLabel j1 = new JLabel("Drone ID: \\n");
        JLabel j2 = new JLabel(String.valueOf(drone.getId()));
        JLabel j3 = new JLabel("Created: \n");
        JLabel j4 = new JLabel(String.valueOf(drone.getCreated()));
        JLabel j5 = new JLabel("Drone Number: \n");
        JLabel j6 = new JLabel(String.valueOf(drone.getDroneid()));
        JLabel j7 = new JLabel("Drone Carrweight: \n");
        JLabel j8 = new JLabel(String.valueOf(drone.getCarriage_weight()));
        JLabel j9 = new JLabel("Drone carrtype: \n");
        JLabel j10 = new JLabel(String.valueOf(drone.getCarriage_type()));
        JLabel j11 = new JLabel("Manufacturer: \n");
        JLabel j12 = new JLabel(String.valueOf(drone.getManufacturer()));
        JLabel j13 = new JLabel("Max Speed: \n");
        JLabel j14 = new JLabel(String.valueOf(drone.getMax_speed()));
        JLabel j15 = new JLabel("Max Carriage: \n");
        JLabel j16 = new JLabel(String.valueOf(drone.getMax_carriage()));
        JLabel j17 = new JLabel("Battery Capacity: \n");
        JLabel j18 = new JLabel(String.valueOf(drone.getBattery_capacity()));
        JLabel j19 = new JLabel("Control Range: \n");
        JLabel j20 = new JLabel(String.valueOf(drone.getControl_range()));
        DroneDynamics dd = drone.list.get(drone.list.size()-1);
        JLabel d1 = new JLabel("DroneDynamics ID: \n");
        JLabel d2 = new JLabel(String.valueOf(dd.getId()));
        JLabel d3 = new JLabel("DroneDynamics Latitude: \n");
        JLabel d4 = new JLabel(String.valueOf(dd.getLatitude()));
        JLabel d5 = new JLabel("DroneDynamics Speed: \n");
        JLabel d6 = new JLabel(String.valueOf(dd.getSpeed()));
        JLabel d7 = new JLabel("DroneDynamics Longitude: \n");
        JLabel d8 = new JLabel(String.valueOf(dd.getLongitude()));
        JLabel d9 = new JLabel("DroneDynamics Time: \n");
        JLabel d10 = new JLabel(String.valueOf(dd.getTime()));
        JLabel d11 = new JLabel("DroneDynamics LastSeen: \n");
        JLabel d12 = new JLabel(String.valueOf(dd.getLastSeen()));
        JLabel d13 = new JLabel("DroneDynamics BatteryStatus: \n");
        JLabel d14 = new JLabel(String.valueOf(dd.getBatteryStatus()));
        JLabel d15 = new JLabel("DroneDynamics Status: \n");
        JLabel d16 = new JLabel(String.valueOf(dd.getStatus()));
        JLabel d17 = new JLabel("DroneDynamics Roll: \n");
        JLabel d18 = new JLabel(String.valueOf(dd.getAlign_roll()));
        JLabel d19 = new JLabel("DroneDynamics Pitch: \n");
        JLabel d20 = new JLabel(String.valueOf(dd.getAlign_pitch()));
        JLabel d21 = new JLabel("DroneDynamics Yaw: \n");
        JLabel d22 = new JLabel(String.valueOf(dd.getAlign_yaw()));
        //JButton JB3= giveMeFirstNavigationButton("Back", Color.red);
        
        //dataPanel.add(JB3, BorderLayout.SOUTH);
        dataPanel.add(j1);
        dataPanel.add(j2);
        dataPanel.add(j3);
        dataPanel.add(j4);
        dataPanel.add(j5);
        dataPanel.add(j6);
        dataPanel.add(j7);
        dataPanel.add(j8);
        dataPanel.add(j9);
        dataPanel.add(j10);
        dataPanel.add(j11);
        dataPanel.add(j12);
        dataPanel.add(j13);
        dataPanel.add(j14);
        dataPanel.add(j15);
        dataPanel.add(j16);
        dataPanel.add(j17);
        dataPanel.add(j18);
        dataPanel.add(j19);
        dataPanel.add(j20);
        dataPanel.add(d1);
        dataPanel.add(d2);
        dataPanel.add(d3);
        dataPanel.add(d4);
        dataPanel.add(d5);
        dataPanel.add(d6);
        dataPanel.add(d7);
        dataPanel.add(d8);
        dataPanel.add(d9);
        dataPanel.add(d10);
        dataPanel.add(d11);
        dataPanel.add(d12);
        dataPanel.add(d13);
        dataPanel.add(d14);
        dataPanel.add(d15);
        dataPanel.add(d16);
        dataPanel.add(d17);
        dataPanel.add(d18);
        dataPanel.add(d19);
        dataPanel.add(d20);
        dataPanel.add(d21);
        dataPanel.add(d22);
        
        JLabel[] labels1 = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, d1, d2, d3, d4, d5, d6 ,d7 ,d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22};
        for (int i = 0; i < labels1.length; i++) {
            labels1[i].setFont(new Font("Segoe UI", Font.ITALIC, 40));
        }
        
        return dataPanel;
    }

}

		
		
		
		
		
		/*	border = BorderFactory.createLineBorder(Color.green);
		frame = new JFrame();
		//frame.getContentPane().setBackground(new Color(0, 0, 255));
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnNewButton.setBounds(1242, 71, 125, 45);
		frame.getContentPane().add(btnNewButton);

		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("MV Boli", Font.PLAIN, 16));
		btnHistory.setBounds(255, 71, 125, 45);
		frame.getContentPane().add(btnHistory);
		JLabel dronedetails = new JLabel("DroneDetails");
		dronedetails.setBounds(765, 126, 602, 584);
		frame.getContentPane().add(dronedetails);
		dronedetails.setBorder(border);	
		JLabel drone_image = new JLabel("drone_Image");
		drone_image.setBounds(255, 126, 490, 584);
		frame.getContentPane().add(drone_image);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drone_image.setBorder(border);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

	protected JPanel giveDataPanel(Drones drone) {
		JPanel dataPanel=new JPanel();
		dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 10));
		
		JLabel j1 = new JLabel("Drone ID: ");
        JLabel j2 = new JLabel(String.valueOf(drone.getDroneid()));
        JLabel j3 = new JLabel("Created: ");
        JLabel j4 = new JLabel(String.valueOf(drone.getCreated()));
        JLabel j5 = new JLabel("Drone Number: ");
        JLabel j6 = new JLabel(String.valueOf(drone.getId()));
        JLabel j7 = new JLabel("Drone Carrweight: ");
        JLabel j8 = new JLabel(String.valueOf(drone.getCarriage_weight()));
        JLabel j9 = new JLabel("Drone carrtype: ");
        JLabel j10 = new JLabel(String.valueOf(drone.getCarriage_type()));
        JLabel j11 = new JLabel("Manufacturer: ");
        JLabel j12 = new JLabel(String.valueOf(drone.getManufacturer()));
        JButton J7= giveMeFirstNavigationButton("", Color.blue);

        dataPanel.add(j1);
        dataPanel.add(j2);
        dataPanel.add(j3);
        dataPanel.add(j4);
        dataPanel.add(j5);
        dataPanel.add(j6);
        
        
		return dataPanel;
	}

private JButton giveMeFirstNavigationButton(String Text, Color color) {
	JButton button= new JButton(Text);
	button.setSize(300,75);
	button.setFocusable(false);
	button.setBackground(color);
	button.setForeground(Color.WHITE);
	button.addActionListener(e->{
		System.out.print("This got clicked");
		frame.dispose();
		speedWindow guuu = new speedWindow(null);
		
	});
	
	button.setFont(new Font("Segoe UI", Font.BOLD, 14));
	return button;
}
}




/*public class Aditional_Info extends JFrame {
    private Drones drone;
    public Aditional_Info(Drones drone) {
        this.drone = drone;
        initialize();
        
    }
    
    protected JFrame initialize() {
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setExtendedState(MAXIMIZED_BOTH);
	    frame.getContentPane().setEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1,10,8));
		frame.setVisible(true);
		
		return frame;
	}

    private void giveDataPanel() {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(0, 2, 10, 10));
        JLabel j1 = new JLabel("Drone ID: ");
        JLabel j2 = new JLabel(String.valueOf(drone.getDroneid()));
        JLabel j3 = new JLabel("Created: ");
        JLabel j4 = new JLabel(String.valueOf(drone.getCreated()));
        JLabel j5 = new JLabel("Drone Number: ");
        JLabel j6 = new JLabel(String.valueOf(drone.getId()));
        JLabel j7 = new JLabel("Drone Carrweight: ");
        JLabel j8 = new JLabel(String.valueOf(drone.getCarriage_weight()));
        JLabel j9 = new JLabel("Drone carrtype: ");
        JLabel j10 = new JLabel(String.valueOf(drone.getCarriage_type()));
        JLabel j11 = new JLabel("Manufacturer: ");
        JLabel j12 = new JLabel(String.valueOf(drone.getManufacturer()));
        JButton J7= giveMeFirstNavigationButton("More Info", Color.blue);

        dataPanel.add(j1);
        dataPanel.add(j2);
        dataPanel.add(j3);
        dataPanel.add(j4);
        dataPanel.add(j5);
        dataPanel.add(j6);

        setTitle("Drone Info");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(dataPanel);
    }

	private JButton giveMeFirstNavigationButton(String string, Color blue) {
		// TODO Auto-generated method stub
		return null;
	}
}*/