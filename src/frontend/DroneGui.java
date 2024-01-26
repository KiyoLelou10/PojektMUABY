package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import background.ListIsEmptyException;
import background.SpeedClasses;

/**
* Class for drone gui frame which gives the user the opportunity to decide between the speed classes.
* 
* @author Utkarsh, Bilal, Mohit
* @version 1.0
*/
public class DroneGui extends JFrame {

    /** 
     *  Instance of itself, Back button was triggering this window twice so to avoid this,
     *  getting the current instance made more sense
     */
    private static DroneGui instance = null;
    private JFrame frame;

    public DroneGui() {
        frame = initialize();
        /** Create a JLabel with text and image */
        JLabel frontLabel = createLabelWithTextAndImage("Here we Present our Three Categories", "images/drone2.jpg");
        frontLabel.setBounds(10, 10, 1000, 1000);
        frame.add(frontLabel, BorderLayout.CENTER);
        
        /** Create a panel and buttons */
        JPanel panel = createPanel();
        JButton primaryButton = giveNavigationButton("Slow Speed Drones!!", Color.DARK_GRAY);
        JButton secondaryButton = giveNavigationButton("Medium Speed Drones!!", Color.blue);
        JButton tertiaryButton = giveNavigationButton("Fast Speed Drones!!", new Color(231, 3, 119));
        panel.add(primaryButton);
        panel.add(secondaryButton);
        panel.add(tertiaryButton);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        /** When closing the second frame, show the main frame again */
        FirstWindow window1 = new FirstWindow();
        window1.frame.setVisible(true);
        System.exit(0);
    }

    private JFrame initialize() {
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        frame.getContentPane().setEnabled(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        return frame;
    }
    
    
    /**
     * Creates a JLabel with an image and text.
     * This method sets up a JLabel with a specified image and text. The image is resized to fit
     * the label, and the text is displayed below the image. Both the image and text are centered
     * to ensure proper alignment and readability, preventing any overlap between them.
     *
     * @param text The text to be displayed on the JLabel.
     * @param imgPath The path to the image file to be displayed on the JLabel.
     * @return A JLabel with the specified image and text, formatted for proper alignment and readability.
     */
    private JLabel createLabelWithTextAndImage(String text, String imgPath) {
        JLabel label = new JLabel();
        label.setText(text);
        /**
         * Adding image
         * Alignment of image and text
         */
        ImageIcon img = new ImageIcon(imgPath);
        Image resizedImage = img.getImage().getScaledInstance(700, 400, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(resizedImage));
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIconTextGap(30);
        label.setFont(new Font("Sans-serif", Font.BOLD, 30));
        label.setForeground(Color.DARK_GRAY);
        return label;
    }

    /**
     * Creates a JButton with a standard size and specific color, primarily used for navigation.
     * This method sets up a JButton with specified text and background color. The text color is
     * set to white by default. The button size is standardized to maintain a consistent design
     * across different windows. Additionally, an action listener is attached to the button which,
     * when activated, disposes the current window and opens a new instance of DroneGUI.
     *
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
        button.setActionCommand(text);
        button.addActionListener(commonListener);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }
    
    /**
     * Create a Jlabel with some standard configuration. This is done to ensure common panel styles among all the classes.
     * @return a Jlabel with the layout set to flowlayout. Borders has been added to have proper spacing between other components and this panel.
     */
    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel.setBorder(new EmptyBorder(0, 0, 140, 0));
        return panel;
    }

    /** ActionListener for the common button this will open the  respective list corresponding to the users wish*/
    ActionListener commonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            frame.dispose();
            Logger LOG = Logger.getLogger(DroneGui.class.getName());
            if ("Slow Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(SpeedClasses.getSlowlist());
                } catch (ListIsEmptyException f) {
                	f.printStackTrace();
                    DroneGui problem = new DroneGui();
                }
                LOG.info("Slow Drone Action");
            } else if ("Medium Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(SpeedClasses.getAveragelist());
                } catch (ListIsEmptyException f) {
                    f.printStackTrace();
                    DroneGui problem = new DroneGui();
                }
                LOG.info("Medium Drone Action");
            } else if ("Fast Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(SpeedClasses.getFastlist());
                } catch (ListIsEmptyException f) {
                    f.printStackTrace();
                    DroneGui problem = new DroneGui();
                }
                LOG.info("Fast Drone Action");
            }
        }
    };

    /** Singleton pattern to get an instance of DroneGui */
    public static DroneGui getInstance() {
        if (instance == null) {
            instance = new DroneGui();
        }
        return instance;
    }
    
}
