package frontend;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import background.*;

public class speedWindow extends JFrame {
	
//	public speedWindow() {
//		JFrame frame=initialize();
//	}
	private JFrame frame;

	public speedWindow(ArrayList<Drones> list) {
		frame=initialize();
		//Content panel is thought to act as a one division in a frame which could
		//be adjusted to a scroll pane
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(0, 1, 10, 8));
		JPanel headerPanel= GiveHeaderPlanner();
		contentPanel.add(headerPanel);
		
		for(Drones i: list) {
			JPanel data= giveDataPanel(i);
			data.setFont(new Font("MV Boli", Font.ITALIC, 15));
			contentPanel.add(data);
			}
			//This code is taken from Internet to add a scroller 
		 	JScrollPane scrollPane = new JScrollPane(contentPanel,
		 	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        frame.add(scrollPane, BorderLayout.CENTER);
		
		
		
	}

	
	
	protected JFrame initialize() {
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	    int width = (int)screenSize.getWidth();
//	    int height = (int)screenSize.getHeight();
	    frame.setExtendedState(MAXIMIZED_BOTH);
	    frame.getContentPane().setEnabled(false);
//		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1,10,8));
		
		frame.setVisible(true);
		
		
		
		return frame;
		
		
	}
	
	
	protected JPanel giveDataPanel(Drones drone) {
		JPanel dataPanel=new JPanel();
		dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 10));
		JLabel j1= createJLabelWithValue(String.valueOf(drone.getId()));
		JLabel j2= createJLabelWithValue(drone.getManufacturer());
		JLabel j3= createJLabelWithValue(String.valueOf(drone.getMax_speed()));
		JLabel j4= createJLabelWithValue(String.valueOf(drone.getMax_carriage()));
		JLabel j5= createJLabelWithValue(String.valueOf(drone.getControl_range()));
		JButton j6= giveMeFirstNavigationButton("More Info", Color.blue);
		j6.addActionListener(e->{
			dispose();
			Aditional_Info info= new Aditional_Info(drone);
		});

		dataPanel.add(j1);
		dataPanel.add(j2);
		dataPanel.add(j3);
		dataPanel.add(j4);
		dataPanel.add(j5);
		dataPanel.add(j6);

		
		
		
		return dataPanel;
	}
	
	
	protected JPanel GiveHeaderPlanner() {
		
		JPanel headerPanel=new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
		
		
		
		JLabel j1= createHeaderJLabelWithValue("Drone Id");
		JLabel j2= createHeaderJLabelWithValue("Manufacturer");
		JLabel j3= createHeaderJLabelWithValue("Max Speed");
		JLabel j4= createHeaderJLabelWithValue("Max Carriage ");
		JLabel j5= createHeaderJLabelWithValue("Control Range");
		JButton J6= giveMeFirstNavigationButton("<- Back", Color.RED);
		J6.addActionListener(e->{
			frame.dispose();
			Drone_Gui gui= new Drone_Gui();
			
		});

		headerPanel.add(j1);
		headerPanel.add(j2);
		headerPanel.add(j3);
		headerPanel.add(j4);
		headerPanel.add(j5);
		headerPanel.add(J6);

		
		
		
		return headerPanel;
	}
	

	
	private JLabel createJLabelWithValue(String text) {
		JLabel j1= new JLabel();
		j1.setPreferredSize(new Dimension(70,15));
		j1.setText(text);
		j1.setFont(new Font("Mv Boli", Font.PLAIN, 16));
		return j1;
		
	}
	
	private JLabel createHeaderJLabelWithValue(String text) {
		JLabel j1= new JLabel();
		j1.setText(text);
		j1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		return j1;
		
	}
	
	@Override
		public void dispose() {
			frame.dispose();
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
	
}
