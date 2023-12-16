package drone_drone;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class Drone_Gui extends JFrame {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drone_Gui window = new Drone_Gui();
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
	public Drone_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
     public void windowClosing(WindowEvent e) {
         // When closing the second frame, show the main frame again
        Firstwindow window1 = new Firstwindow();
        window1.frame.setVisible(true);
        System.exit(0);
     }

	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1161, 980);
		frame.setDefaultCloseOperation(Drone_Gui.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Quick drones");
		Image img1 = new ImageIcon(this.getClass().getResource("/quick1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        List<String> information = Arrays.asList("Item 1", "Item 2", "Item 3");
		        Information_Window newWindow1 = new Information_Window(information);
		        newWindow1.setVisible(true);
		        frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(188, 658, 221, 122);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/drone4.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(261, 30, 637, 620);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Middle drones");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_Window newWindow = new New_Window();
		        newWindow.setVisible(true);
		        frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(453, 658, 221, 122);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Slow drones");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_Window newWindow = new New_Window();
		        newWindow.setVisible(true);
		        frame.setVisible(false);
			}
		});
		btnNewButton_1_2.setBounds(711, 658, 221, 122);
		frame.getContentPane().add(btnNewButton_1_2);
	}
}
