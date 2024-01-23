package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import background.ListIsEmptyException;
import background.Speedclasses;

public class DroneGui extends JFrame {

    protected JFrame frame;
    // instance of itself, Back button was triggering this window twice so to avoid this, getting the current instance made more sense
    private static DroneGui instance = null;

    // Constructor for DroneGui
    public DroneGui() {
    	// Initialize the frame with initialize properties
        frame = initialize();
        
        // Create a JLabel with text and image
        JLabel frontLabel = createLabelWithTextAndImage("Here we Present our Three Categories", "images/drone2.jpg");
        frontLabel.setBounds(10, 10, 1000, 1000);
        frame.add(frontLabel, BorderLayout.CENTER);
        
        // Create a panel and buttons
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

    // Method to handle window closing event
    public void windowClosing(WindowEvent e) {
        // When closing the second frame, show the main frame again
        Firstwindow window1 = new Firstwindow();
        window1.frame.setVisible(true);
        System.exit(0);
    }

    // Method to initialize the frame
    protected JFrame initialize() {
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

    // Method to create a JLabel with text and image
    private JLabel createLabelWithTextAndImage(String text, String imgPath) {
        JLabel label = new JLabel();
        label.setText(text);
        /*
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

    // Method to create a navigation button
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

    // Method to create a panel
    private JPanel createPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel.setBorder(new EmptyBorder(0, 0, 140, 0));

        return panel;
    }

    // ActionListener for the common button
    ActionListener commonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            frame.dispose();
            if ("Slow Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(Speedclasses.getSlowlist());
                } catch (ListIsEmptyException f) {
                    System.out.println(f.getMessage());
                    DroneGui problem = new DroneGui();
                }
                System.out.println("Slow Drone Action");
            } else if ("Medium Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(Speedclasses.getAveragelist());
                } catch (ListIsEmptyException f) {
                    System.out.println(f.getMessage());
                    DroneGui problem = new DroneGui();
                }
                System.out.println("Medium Drone Action");
            } else if ("Fast Speed Drones!!".equals(command)) {

                try {
                    JFrame frame = new SpeedWindow(Speedclasses.getFastlist());
                } catch (ListIsEmptyException f) {
                    System.out.println(f.getMessage());
                    DroneGui problem = new DroneGui();
                }
                System.out.println("Fast Drone Action");
            }
        }
    };

    // Singleton pattern to get an instance of DroneGui
    public static DroneGui getInstance() {
        if (instance == null) {
            instance = new DroneGui();
        }
        return instance;
    }
}
