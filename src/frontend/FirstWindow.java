package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
* Class for first window frame.
* 
* @author Utkarsh, Bilal
* @version 1.0
*/
public class FirstWindow extends Frame {

    protected JFrame frame;
    private JLabel text;
    private JButton yesButton;
    private JButton noButton;
    private JLabel label;

    public FirstWindow() {
        frame = initialize();
        JLabel frontLabel = createLabelWithTextAndImage("Welcome to the World of Drones, Would you like to explore this Universe??", "images/drone4.png");
        frontLabel.setBounds(10, 10, 1000, 1000);
        frame.add(frontLabel, BorderLayout.CENTER);
        JPanel panel = createPanel();
        JButton primaryButton = giveNavigationButton("Yes Please !!", Color.BLUE);
        JButton secondaryButton = giveNavigationButton("Not Interseted !!", Color.RED);
        panel.add(primaryButton);
        panel.add(secondaryButton);
        frame.add(panel, BorderLayout.SOUTH);
        
        /** Set frame properties and make it visible */
        frame.pack();
        frame.setExtendedState(MAXIMIZED_BOTH);
    }

    /** Assigns some of the initial configuration to the window**/
   private JFrame initialize() {
        JFrame frame = new JFrame();

        /** Get screen dimensions */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth());
        int height = (int) (screenSize.getHeight());
        frame.getContentPane().setEnabled(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        return frame;
    }

    /**
     * Creates a JLabel with an image and text.
     * This method sets up a JLabel with a specified image and text. The image is resized to fit
     * the label, and the text is displayed below the image. Both the image and text are centered
     * to ensure proper alignment and readability, preventing any overlap between them.
     * @param text The text to be displayed on the JLabel.
     * @param imgPath The path to the image file to be displayed on the JLabel.
     * @return A JLabel with the specified image and text, formatted for proper alignment and readability.
     */
    private JLabel createLabelWithTextAndImage(String text, String imgPath) {
        JLabel label = new JLabel();
        label.setText(text);
        ImageIcon img = new ImageIcon(imgPath);
        Image resizedImage = img.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(resizedImage));

        /** Alignment of image and text*/
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Segoe UI", Font.BOLD, 30));
        label.setForeground(Color.GRAY);
        return label;
    }

    
    /**
     * Creates a JButton with a standard size and specific color, primarily used for navigation.
     * This method sets up a JButton with specified text and background color. The text color is
     * set to white by default. The button size is standardized to maintain a consistent design
     * across different windows. Additionally, an action listener is attached to the button which,
     * when activated, disposes the current window and opens a new instance of DroneGUI.
     * @param text The text to be displayed on the button.
     * @param color The background color of the button.
     * @return A JButton with the specified text and background color, along with a predefined action listener.
     */
    private JButton giveNavigationButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setSize(300, 75);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);

        button.addActionListener(e -> {
            dispose();
        	DroneGui newDroneGui = new DroneGui();
            
        });
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }
    
    /**
   	 * Gives a Panel with standard configuration.
   	 * @return a panel with flow layout and empty borders to ensure good spacing between the components and this panel.
   	 */
    private JPanel createPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel.setBorder(new EmptyBorder(0, 0, 160, 0));
        return panel;
    }
    
    @Override
    public void dispose() {
    	frame.dispose();
    }
    
}
