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
	protected JTextField txtWelcomeToOur;
	protected JButton btnNewButton;
	protected JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Firstwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 907, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtWelcomeToOur = new JTextField();
		txtWelcomeToOur.setForeground(new Color(0, 128, 255));
		txtWelcomeToOur.setText("                                               Welcome to our Dronesimulator |  Would you like to express the Drone world?");
		txtWelcomeToOur.setBounds(118, 447, 667, 57);
		frame.getContentPane().add(txtWelcomeToOur);
		txtWelcomeToOur.setColumns(14);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/drone3.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(130, 34, 640, 402);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Yes please :)");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drone_Gui newDroneGui = new Drone_Gui();
				newDroneGui.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(190, 515, 198, 75);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("No not interested!!!");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drone_Gui newDroneGui = new Drone_Gui();
				newDroneGui.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(530, 515, 198, 75);
		frame.getContentPane().add(btnNewButton_1);
	}
}
