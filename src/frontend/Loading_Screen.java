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
        JLabel gifLabel = new JLabel("Loading the data..................");
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
        centerFrameOnScreen(frame);
    }
	
	protected JFrame initialize() {
		frame = new JFrame();
	    frame.getContentPane().setEnabled(false);
        frame.setUndecorated(true);
		//frame.setExtendedState(MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		return frame;
	}

	@Override
	public void dispose() {
		frame.dispose();
	}
	
    private void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth()-frame.getWidth())/2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight())/ 2);
        frame.setLocation(centerX, centerY);
    }
}
