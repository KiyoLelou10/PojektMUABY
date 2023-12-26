package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;
import background.*;

public class speedWindow extends JFrame {
	
	public speedWindow() {
		JFrame frame=initialize();
	}

	public speedWindow(ArrayList<Drones> list) {
		JFrame frame=initialize();
		
		
	}

	
	
	protected JFrame initialize() {
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)screenSize.getWidth();
	    int height = (int)screenSize.getHeight();
	    frame.getContentPane().setEnabled(false);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(12,1,10,10));
		
		frame.setVisible(true);
		
		JPanel headerPanel= GiveHeaderPlanner();
		frame.add(headerPanel);
		
		return frame;
		
		
	}
	
	
	protected JPanel GiveHeaderPlanner() {
		
		JPanel headerPanel=new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 15));
		
		
		
		JLabel j1= createJLabelWithValue("Drone Id");
		JLabel j2= createJLabelWithValue("Manufacturer");
		JLabel j3= createJLabelWithValue("Max Speed");
		JLabel j4= createJLabelWithValue("Max Carriage ");
		JLabel j5= createJLabelWithValue("Control Range");
		JButton J6= giveMeFirstNavigationButton("<- Back", Color.RED);
		J6.addActionListener(e->{
			Drone_Gui gui= new Drone_Gui();
			dispose();
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
		j1.setText(text);
		j1.setFont(new Font("MV Boli", Font.BOLD, 18));
		return j1;
		
	}
	
	
	private JButton giveMeFirstNavigationButton(String Text, Color color) {
		JButton button= new JButton(Text);
		button.setSize(300,75);
		button.setFocusable(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);
		button.addActionListener(e->{
			Drone_Gui newDroneGui = new Drone_Gui();
			dispose();
			
		});
		
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		return button;
	}
	
	
	
	
}
