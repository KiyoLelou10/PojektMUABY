package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import background.DroneDynamics;
import background.DroneTime;
import background.Drones;

public class HistoryScreen extends JFrame{
	protected JFrame frame;
	protected JTextField minute1 =giveMeTextField("7", 10);
	protected JTextField minute2=giveMeTextField("12", 10);
	protected JTextField hour1=giveMeTextField("9", 10);
	protected JTextField hour2=giveMeTextField("9", 10);
	protected JTextField day1= giveMeTextField("26", 10);
	protected JTextField day2=giveMeTextField("26", 10);
	protected JTextField month1= giveMeTextField("12", 10);
	protected JTextField month2=giveMeTextField("12", 10);
	protected JTextField year1 = giveMeTextField("2023", 10);
	protected JTextField year2= giveMeTextField("2023", 10);


	public HistoryScreen(Drones drone) {
		// TODO Auto-generated constructor stub
		frame = initialize();

		JLabel label = createJLabelWithValue("Search the dynamics!!!");

		JPanel panels1 = createDatePanel(drone);
		
		
		
		
		
		
	
		
		panels1.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		
		label.setBorder(BorderFactory.createEmptyBorder(20, 10, 25, 10));
		frame.add(label, BorderLayout.NORTH);
		frame.add(panels1, BorderLayout.CENTER);

		centerFrameOnScreen(frame);
		frame.pack();
		frame.setVisible(true);

	}

	public JPanel createDatePanel(Drones drone) {
		JPanel panel = new JPanel(new GridLayout(6, 2,10,20));
		JPanel inputPanel1= createDurationPanel(minute1,hour1, day1, month1,year1);
		JPanel inputPanel2= createDurationPanel(minute2,hour2, day2, month2,year2);
		System.out.println(year1.getText());
		
		
		JButton submitButton = giveMeFirstNavigationButton("Submit", Color.BLUE);
		submitButton.addActionListener(e->{
			String x = stringifier(year1, month1, day1, hour1, minute1);
			String y = stringifier(year2, month2, day2, hour2, minute2);
			DroneTime a = new DroneTime(x);
			DroneTime b = new DroneTime(y);
			
			if(a.getExactTime()-b.getExactTime()>300 || a.getExactTime()-b.getExactTime()<-300) {
				JOptionPane f = new JOptionPane();
				f.showMessageDialog(this,"The difference must be less than 5 minutes","errorbox",JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				System.out.println(drone.getCurrentDroneDynamics(a, b));
			}
		});
		

		

		panel.add(inputPanel1);
		panel.add(inputPanel2);
		panel.add(submitButton);

		
		
		

		return panel;
	}
	
	private String stringifier(JTextField a,JTextField b,JTextField c, JTextField d, JTextField e) {
		String x = new String(a.getText()+"-"+b.getText()+"-"+c.getText()+"T"+d.getText()+":"+e.getText()+":0+0:0");
		return x;
	}
	
	
	
	public JPanel createDurationPanel(JTextField a, JTextField b, JTextField c, JTextField d,JTextField e){
		JPanel inputPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		inputPanel1.add(a);
		inputPanel1.add(b);
		inputPanel1.add(c);
		inputPanel1.add(d);
		inputPanel1.add(e);
		
		
		return inputPanel1;
		
	}
	
	
	

	protected JFrame initialize() {
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setEnabled(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
