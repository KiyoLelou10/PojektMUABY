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

	protected JFrame  frame;
	protected JLabel  label1;
	protected JButton backbutton;
	protected JButton quickbutton;
	protected JButton middlebutton;
	protected JButton slowbutton;
	

	public Drone_Gui() {
		initialize();
	}

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
		
		quickbutton = new JButton();
		Image img1 = new ImageIcon(this.getClass().getResource("/quick1.png")).getImage();
		quickbutton.setIcon(new ImageIcon(img1));
		quickbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        List<String> information = Arrays.asList("Item 1", "Item 2", "Item 3");
		        Information_Window newWindow1 = new Information_Window(information);
		        newWindow1.setVisible(true);
		        frame.setVisible(false);
			}
		});
		quickbutton.setBounds(188, 658, 221, 122);
		frame.getContentPane().add(quickbutton);
		
		label1 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/drone4.png")).getImage();
		label1.setIcon(new ImageIcon(img));
		label1.setBounds(261, 30, 637, 620);
		frame.getContentPane().add(label1);
		
		middlebutton = new JButton();
		Image img2 = new ImageIcon(this.getClass().getResource("/middle.png")).getImage();
		middlebutton.setIcon(new ImageIcon(img2));
		middlebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_Window newWindow = new New_Window();
		        newWindow.setVisible(true);
		        frame.setVisible(false);
			}
		});
		middlebutton.setBounds(453, 658, 221, 122);
		frame.getContentPane().add(middlebutton);
		
		slowbutton = new JButton();
		Image img3 = new ImageIcon(this.getClass().getResource("/slow1.png")).getImage();
		slowbutton.setIcon(new ImageIcon(img3));
		slowbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_Window newWindow = new New_Window();
		        newWindow.setVisible(true);
		        frame.setVisible(false);
			}
		});
		slowbutton.setBounds(711, 658, 221, 122);
		frame.getContentPane().add(slowbutton);
		
		backbutton = new JButton("back");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Firstwindow newfirstwindow = new Firstwindow();
				newfirstwindow.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		backbutton.setBounds(10, 10, 114, 27);
		frame.getContentPane().add(backbutton);
	}
}
