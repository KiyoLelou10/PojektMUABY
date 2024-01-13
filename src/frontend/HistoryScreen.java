package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import background.DroneDate;
import background.Drones;

public class HistoryScreen extends JFrame {
	protected JFrame frame;
	protected JTextField minute[];
	protected JTextField hour[];
	protected JTextField day[];
	protected JTextField month[];
	protected JTextField year[];
	

	public HistoryScreen(Drones drone) {
		// TODO Auto-generated constructor stub
		frame = initialize();

		JLabel label = createJLabelWithValue("Search the dynamics!!!");
		int i = 0;
		JPanel panels1 = createDatePanel(drone,i);
		JPanel panels2 = createDatePanel(drone,i++);
		
		
		
		JButton submitButton = giveMeFirstNavigationButton("Submit", Color.BLUE);
		submitButton.addActionListener(e->{
			
			
			
		});
		
		panels2.add(submitButton);
		
		panels1.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		panels2.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		label.setBorder(BorderFactory.createEmptyBorder(20, 10, 25, 10));
		frame.add(label, BorderLayout.NORTH);
		frame.add(panels1, BorderLayout.CENTER);
		frame.add(panels2, BorderLayout.AFTER_LAST_LINE);
		

		centerFrameOnScreen(frame);
		frame.pack();
		frame.setVisible(true);

	}

	public JPanel createDatePanel(Drones drone,int i) {
		JPanel panel = new JPanel(new GridLayout(6, 1,10,15));

		JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));

		minute[i] = giveMeTextField("MI", 10);
		hour[i] = giveMeTextField("HH", 10);
		day[i] =  giveMeTextField("DD", 10);
		month[i] = giveMeTextField("MM", 10);
		year[i] = giveMeTextField("YYYY", 10);
		
		inputPanel.add(hour[i]);
		inputPanel.add(minute[i]);
		inputPanel.add(day[i]);
		inputPanel.add(month[i]);
		inputPanel.add(year[i]);

		
		
		
		panel.add(inputPanel);


		return panel;
	}

	protected JFrame initialize() {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setEnabled(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setExtendedState(MAXIMIZED_BOTH);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 4, screenSize.height / 4);

		return frame;

	}
	
	
	public JTextField giveMeTextField(String text, int len) {
        JTextField textField = new JTextField(text, len);
        textField.setHorizontalAlignment(JTextField.CENTER); 
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); 
        textField.setSize(50, 50);
        return textField;
    }
	
	

	@Override
	public void dispose() {

		frame.dispose();
	}

	private void centerFrameOnScreen(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setLocationRelativeTo(null);
	}

	private JButton giveMeFirstNavigationButton(String Text, Color color) {
		JButton button = new JButton(Text);
		button.setFocusable(false);
		button.setBackground(color);
		button.setForeground(Color.WHITE);

		button.setFont(new Font("Segoe UI", Font.BOLD, 14));
		return button;
	}
	
	
	private JLabel createJLabelWithValue(String text) {
		JLabel j1= new JLabel();
		j1.setPreferredSize(new Dimension(70,15));
		j1.setText(text);
		j1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		return j1;
		
	}

}