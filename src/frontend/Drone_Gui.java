package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Drone_Gui extends JFrame {

	protected JFrame  frame;
	protected JLabel  label1;
	protected JButton backbutton;
	protected JButton quickbutton;
	protected JButton middlebutton;
	protected JButton slowbutton;
	

	public Drone_Gui() {
		JFrame frame= initialize();
		JLabel frontLabel= JlabelwithTextAndImage("Here we Present our Three Categories", "images/drone2.jpg");
		frontLabel.setBounds(10,10,1000,1000);
		frame.add(frontLabel, BorderLayout.CENTER);
		JPanel panel= givePanel();
		JButton primaryButton= giveMeFirstNavigationButton("Slow Drones!!", Color.DARK_GRAY);
		JButton secondaryButton= giveMeFirstNavigationButton("Medium Speed Drones  !!", Color.blue);
		JButton tertiaryButton= giveMeFirstNavigationButton("Fast Speed Drones!!", new Color(231, 3, 119));
		panel.add(primaryButton);
		panel.add(secondaryButton);
		panel.add(tertiaryButton);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
		
	}

     public void windowClosing(WindowEvent e) {
         // When closing the second frame, show the main frame again
        Firstwindow window1 = new Firstwindow();
        window1.frame.setVisible(true);
        System.exit(0);
     }
     
     
 	protected JFrame initialize() {
		frame = new JFrame();
		
		
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	     int width = (int)screenSize.getWidth();
	     int height = (int)screenSize.getHeight();
	          
	    frame.getContentPane().setEnabled(false);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		return frame;
		
		
	} 
 	
	private JLabel JlabelwithTextAndImage(String text,String imgPath) {
		JLabel a= new JLabel();
		a.setText(text);
		//adding image 
		ImageIcon img= new ImageIcon(imgPath);
		Image resizedImage= img.getImage().getScaledInstance(700, 400,Image.SCALE_SMOOTH);
		a.setIcon(new ImageIcon(resizedImage));
		
		
		//Alignment of image and text 
		a.setVerticalAlignment(JLabel.TOP);
		a.setHorizontalAlignment(JLabel.CENTER);
		a.setHorizontalTextPosition(JLabel.CENTER);
		a.setVerticalTextPosition(JLabel.TOP);
		a.setIconTextGap(30);
		
		a.setFont(new Font("Sans-serif", Font.BOLD, 30));
		a.setForeground(Color.DARK_GRAY);
		return a;
	}
	

	
	//Copied from the first window code, refer to first window for more intititive thinking
	private JButton giveMeFirstNavigationButton(String Text, Color color) {
		JButton button= new JButton(Text);
		button.setSize(300,75);
		button.setFocusable(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);
		button.addActionListener(e->{
			speedWindow newDroneGui = new speedWindow();
			frame.dispose();
			
		});
		
		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		return button;
	}
	
	private JPanel givePanel() {
		JPanel panel= new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50,0));
		panel.setBorder(new EmptyBorder(0, 0, 140, 0));
		return panel;
	}
	
 	
 	
 	
 	
 	


}
