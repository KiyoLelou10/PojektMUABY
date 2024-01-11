
package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading_Screen extends JFrame {
	 protected JFrame frame;
	 
	public Loading_Screen() {
		JFrame frame = initialize();
		centerFrameOnScreen(frame);
        JLabel gifLabel = new JLabel("Loading data....................");
        ImageIcon gifIcon = new ImageIcon("images/gif4.gif");
        gifLabel.setIcon(gifIcon);
        gifLabel.setVerticalAlignment(JLabel.TOP);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        gifLabel.setHorizontalTextPosition(JLabel.CENTER);
        gifLabel.setVerticalTextPosition(JLabel.BOTTOM);
		
        gifLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gifLabel.setForeground(Color.GRAY);
        frame.add(gifLabel);
        frame.setLayout(new FlowLayout());
        frame.pack();
 
    }
	
	protected JFrame initialize() {
		frame = new JFrame();
	    frame.getContentPane().setEnabled(false);
        frame.setUndecorated(true);
		//frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		return frame;
		
		
	}
    private void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);
    }
}












/*package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Loading_Screen extends JFrame {
	
	
	
	protected JFrame frame;
	
	public Loading_Screen() {
		JFrame frame=initialize(); 
		
		JLabel frontLabel= JlabelwithTextAndImage("Welcome to the World of Drones, Would you like to explore this Universe??", "images/loading gif.gif");
		frontLabel.setBounds(10,10,1000,1000);
		frame.add(frontLabel, BorderLayout.CENTER);
		frame.pack();
	}
	protected JFrame initialize() {
		frame = new JFrame();
		
		
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = (int)(screenSize.getWidth());
	        int height = (int)(screenSize.getHeight());
	          
	    frame.getContentPane().setEnabled(false);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		//frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		return frame;
		
		
	}
	
	
	private JLabel JlabelwithTextAndImage(String text,String imgPath) {
		JLabel a= new JLabel();
		a.setText(text);
		//adding image 
		ImageIcon img= new ImageIcon(imgPath);
		Image resizedImage= img.getImage().getScaledInstance(400, 400,Image.SCALE_SMOOTH);
		a.setIcon(new ImageIcon(resizedImage));
		
		
		//Alignment of image and text 
		a.setVerticalAlignment(JLabel.TOP);
		a.setHorizontalAlignment(JLabel.CENTER);
		a.setHorizontalTextPosition(JLabel.CENTER);
		a.setVerticalTextPosition(JLabel.BOTTOM);
		
		a.setFont(new Font("Segoe UI", Font.BOLD, 30));
		a.setForeground(Color.GRAY);
		return a;
	}
}
	
	
	
	
	
	
	
	
	
	
	
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
*/