package drone_drone;

import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class New_Window extends JFrame {
	protected JButton backbutton;
	protected JPanel  panel1;
	
    public New_Window() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 739);
		panel1 = new JPanel();
		setContentPane(panel1);
		panel1.setLayout(null);

    	
        backbutton = new JButton("back");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drone_Gui newDroneGui = new Drone_Gui();
				newDroneGui.frame.setVisible(true);
				panel1.setVisible(false);
			}
		});
		backbutton.setBounds(10, 10, 114, 27);
		panel1.getRootPane().add(backbutton);
    }
}