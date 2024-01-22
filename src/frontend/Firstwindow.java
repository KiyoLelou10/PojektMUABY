package frontend;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.print.event.PrintJobListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Firstwindow extends Frame {

	protected JFrame frame;
	protected JLabel txt;
	protected JButton yesbutton;
	protected JButton nobutton;
	protected JLabel label;

	public Firstwindow() {
		JFrame frame=initialize(); //All the default properties are set 
		
		JLabel frontLabel= JlabelwithTextAndImage("Welcome to the World of Drones, Would you like to explore this Universe??", "images/drone4.png");
		frontLabel.setBounds(10,10,1000,1000);
		frame.add(frontLabel, BorderLayout.CENTER);

		JPanel panel= givePanel();
		JButton primaryButton= giveMeFirstNavigationButton("Yes Please !!", Color.BLUE);
		JButton secondaryButton= giveMeFirstNavigationButton("Not Interseted !!", Color.RED);

		panel.add(primaryButton);
		panel.add(secondaryButton);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setExtendedState(MAXIMIZED_BOTH);
	}

	protected JFrame initialize() {
		frame = new JFrame();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int)(screenSize.getWidth());
	    int height = (int)(screenSize.getHeight());
	          
	    frame.getContentPane().setEnabled(false);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		return frame;
	}
	
	private JLabel JlabelwithTextAndImage(String text,String imgPath) {
		JLabel a= new JLabel();
		a.setText(text);

		//adding image 
		ImageIcon img= new ImageIcon(imgPath);
		Image resizedImage= img.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
		a.setIcon(new ImageIcon(resizedImage));
		
		//Alignment of image and text 
		a.setVerticalAlignment(JLabel.TOP);
		a.setHorizontalAlignment(JLabel.CENTER);
		a.setHorizontalTextPosition(JLabel.CENTER);
		a.setVerticalTextPosition(JLabel.BOTTOM);
		
		a.setFont(new Font("Segoe UI", Font.BOLD, 30));
		a.setForeground(Color.GRAY);
		
		return a;
	}
	
	//it is supposed to be a joke: To have similar type of navigation button 
	private JButton giveMeFirstNavigationButton(String Text, Color color) {
		JButton button= new JButton(Text);
		button.setSize(300,75);
		button.setFocusable(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);
		button.addActionListener(e->{
			Drone_Gui newDroneGui = new Drone_Gui();
			frame.dispose();
		});
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		return button;
	}
	
	private JPanel givePanel() {
		JPanel panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50,0));
		panel.setBorder(new EmptyBorder(0, 0, 160, 0));
		
		return panel;
	}
}
