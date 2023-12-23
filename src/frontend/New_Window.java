package frontend;

import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class New_Window extends JFrame {
	protected JButton backbutton;
	protected JButton infobutton;
	protected JPanel  panel1;
	protected JLabel text;
	
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
				dispose();
			}
		});
		backbutton.setBounds(10, 10, 114, 27);
		panel1.add(backbutton);		
		
		for(int i = 0;i<5;i++) {
			text = new JLabel();
			text.setText("Drone id: "+i+" Manufacturer: qdh Max. speed: "+20*(i+1));
			text.setBounds(10, 50+50*i, 500, 27);
			text.setForeground(Color.red);
			panel1.add(text);
			
			infobutton = new JButton("Info");
			infobutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			infobutton.setBounds(1000,50+50*i,114,27);
			panel1.add(infobutton);
		}
		
		
    }
}