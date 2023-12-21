package drone_drone;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Firstwindow {

	protected JFrame frame;
	protected JTextField txt;
	protected JButton yesbutton;
	protected JButton nobutton;
	protected JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Firstwindow window = new Firstwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Firstwindow() {
		initialize();
	}

	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 907, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setForeground(new Color(0, 128, 255));
		txt.setText("                                               Welcome to our Dronesimulator |  Would you like to express the Drone world?");
		txt.setBounds(118, 447, 667, 57);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		label = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/drone3.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(130, 34, 640, 402);
		frame.getContentPane().add(label);
		
		yesbutton = new JButton("Yes please :)");
		yesbutton.setForeground(new Color(0, 0, 255));
		yesbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drone_Gui newDroneGui = new Drone_Gui();
				newDroneGui.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		yesbutton.setBounds(190, 515, 198, 75);
		frame.getContentPane().add(yesbutton);
		
		nobutton = new JButton("No not interested!!!");
		nobutton.setForeground(new Color(255, 0, 0));
		nobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drone_Gui newDroneGui = new Drone_Gui();
				newDroneGui.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		nobutton.setBounds(530, 515, 198, 75);
		frame.getContentPane().add(nobutton);
		
	}
	
	
	
}
