package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import background.DroneDynamics;
import background.DroneTime;
import background.Drones;

public class HistoryScreen extends JFrame{
	protected JFrame frame;
	protected JLabel dynamicsLabel = new JLabel();
	protected JTextField minute1 =giveMeTextField("", 10);
	protected JTextField minute2=giveMeTextField("", 10);
	protected JTextField hour1=giveMeTextField("", 10);
	protected JTextField hour2=giveMeTextField("", 10);
	protected JTextField day1= giveMeTextField("", 10);
	protected JTextField day2=giveMeTextField("", 10);
	protected JTextField month1= giveMeTextField("", 10);
	protected JTextField month2=giveMeTextField("", 10);
	protected JTextField year1 = giveMeTextField("", 10);
	protected JTextField year2= giveMeTextField("", 10);
	protected JTextField[] textFields = {minute1, hour1, day1, month1, year1, minute2, hour2, day2, month2, year2};
	protected JButton submitButton;
	protected static boolean flag = false;
	
	public HistoryScreen(Drones drone) {
		// TODO Auto-generated constructor stub
		frame = initialize();
		flag = true;
		
		JLabel label = createJLabelWithValue("Search the dynamics! Max difference 10 min! In this order: min,h,dd,mm,yyyy");
		JPanel inputAndDynamicPanel = new JPanel(new BorderLayout());
		JPanel panels1 = createDatePanel(drone);
		addEnterKeyListenerToTextFields(textFields);
		panels1.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		label.setBorder(BorderFactory.createEmptyBorder(20, 10, 25, 10));
		
		frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();
                }
            }
        });
		
		frame.addWindowListener((WindowListener) new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        flag = false;
		        super.windowClosing(e);
		    }
		});
		frame.add(label, BorderLayout.NORTH);
		frame.add(panels1, BorderLayout.CENTER);

		centerFrameOnScreen(frame);
		frame.pack();
		frame.setVisible(true);
	}

	public JPanel createDatePanel(Drones drone) {
		JPanel panel = new JPanel(new GridLayout(7, 2,10,20));
		JPanel inputPanel1= createDurationPanel(minute1,hour1, day1, month1,year1);
		JPanel inputPanel2= createDurationPanel(minute2,hour2, day2, month2,year2);

		submitButton = giveMeFirstNavigationButton("Submit", Color.BLUE);
		submitButton.addActionListener(e->{
			
			String x = stringifier(year1, month1, day1, hour1, minute1);
			String y = stringifier(year2, month2, day2, hour2, minute2);
			DroneTime a = new DroneTime(x);
			DroneTime b = new DroneTime(y);
			
			boolean isDynamicsLabelAdded = panel.isAncestorOf(dynamicsLabel);

			if (isDynamicsLabelAdded) {
		        // Remove the dynamicsLabel from the panel
		        panel.remove(dynamicsLabel);
		        panel.revalidate();
		        panel.repaint();
		    }
			if(a.getExactTime()-b.getExactTime()>600 || a.getExactTime()-b.getExactTime()<-600) {
				JOptionPane f = new JOptionPane();
				f.showMessageDialog(this,"The difference must be less than 10 minutes","errorbox",JOptionPane.ERROR_MESSAGE);
				
			}
			else {
				dynamicsLabel = createJLabelWithValue("               Recorded " + drone.getCurrentDroneDynamics(a, b).size() + " dynamics where drone was 'ON'.");
				dynamicsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
				System.out.println(drone.getCurrentDroneDynamics(a, b).size());
				panel.add(dynamicsLabel);
	            frame.pack();
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
	
	/*@Override
	public void setDefaultCloseOperation(int operation) {
		System.out.println("Used");
		super.setDefaultCloseOperation(operation);
		flag = false;
	}*/
	
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
	private void addEnterKeyListenerToTextFields(JTextField... textFields) {
        for (JTextField textField : textFields) {
            textField.addActionListener(e -> focusNextTextField(textField));
        }
    }

    private void focusNextTextField(JTextField currentTextField) {
        // Find the index of the current text field
        int currentIndex = -1;
        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i] == currentTextField) {
                currentIndex = i;
                break;
            }
        }

        // Set focus to the next text field
        if (currentIndex != -1 && currentIndex < textFields.length - 1) {
            textFields[currentIndex + 1].requestFocus();
        }
    }
	
	

}
