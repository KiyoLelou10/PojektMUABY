package frontend;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import background.Drones;

public class Aditional_Info extends JFrame{



	private JFrame frame;

	protected Border border;





	public Aditional_Info(Drones drone) {
		initialize();
	}



	private void initialize() {
		border = BorderFactory.createLineBorder(Color.green);
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
/*
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