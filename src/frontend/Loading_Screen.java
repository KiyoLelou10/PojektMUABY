package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading_Screen extends JFrame {
	protected JFrame frame;
	protected JLabel text;
	protected JLabel label;
	
	public Loading_Screen() {
		 
		JFrame frame=initialize();
		text = new JLabel("Loading the data..."); 
		frame.add(text);
		
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
		frame.setVisible(true);
		
		return frame;
		
		
	}
	
	
	@Override
	public void dispose() {
		
		frame.dispose();
	}
}
