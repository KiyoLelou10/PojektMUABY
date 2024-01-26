package frontend;

import java.awt.*;
import javax.swing.*;

/**
* Class for loading frame.
* 
* @author Utkarsh, Bilal, Mohit
* @version 1.0
*/
public class LoadingScreen extends JFrame {
    
	private JFrame frame;

    public LoadingScreen() {
        JFrame frame = initialize();
        /** Create a JLabel for displaying text and a GIF */
        JLabel gifLabel = new JLabel("Loading the data..................");
        ImageIcon gifIcon = new ImageIcon("images/gif4.gif");
        gifLabel.setIcon(gifIcon);
        
        /**
         * Set the alignment and positioning for the label
         * Set font and color for the label
         */
        gifLabel.setVerticalAlignment(JLabel.TOP);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        gifLabel.setHorizontalTextPosition(JLabel.CENTER);
        gifLabel.setVerticalTextPosition(JLabel.BOTTOM);
        gifLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gifLabel.setForeground(Color.GRAY);
        /**
         * Add the GIF label to the frame
         * Set layout and pack the frame
         */
        frame.add(gifLabel);
        frame.setLayout(new FlowLayout());
        frame.pack();
        centerFrameOnScreen(frame);
    }

    protected JFrame initialize() {
        frame = new JFrame();
        frame.getContentPane().setEnabled(false);
        frame.setUndecorated(true);
        frame.setVisible(true);
        return frame;
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    private void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);
    }
    
}
