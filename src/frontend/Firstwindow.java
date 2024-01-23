package frontend;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Firstwindow extends Frame {

    protected JFrame frame;
    protected JLabel txt;
    protected JButton yesbutton;
    protected JButton nobutton;
    protected JLabel label;

    // Constructor for Firstwindow
    public Firstwindow() {
        // Initialize the frame with initialize properties
        JFrame frame = initialize();

        // Create a JLabel with text and image
        JLabel frontLabel = createLabelWithTextAndImage("Welcome to the World of Drones, Would you like to explore this Universe??", "images/drone4.png");
        frontLabel.setBounds(10, 10, 1000, 1000);
        frame.add(frontLabel, BorderLayout.CENTER);

        // Create a panel and buttons
        JPanel panel = createPanel();
        JButton primaryButton = giveNavigationButton("Yes Please !!", Color.BLUE);
        JButton secondaryButton = giveNavigationButton("Not Interseted !!", Color.RED);
        panel.add(primaryButton);
        panel.add(secondaryButton);
        frame.add(panel, BorderLayout.SOUTH);

        // Set frame properties and make it visible
        frame.pack();
        frame.setExtendedState(MAXIMIZED_BOTH);
    }

    // Method to initialize the frame
    protected JFrame initialize() {
        JFrame frame = new JFrame();

        // Get screen dimensions
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

    // Helper method to create a JLabel with text and image
    private JLabel createLabelWithTextAndImage(String text, String imgPath) {
        JLabel label = new JLabel();
        label.setText(text);

        // Adding image
        ImageIcon img = new ImageIcon(imgPath);
        Image resizedImage = img.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(resizedImage));

        // Alignment of image and text
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("Segoe UI", Font.BOLD, 30));
        label.setForeground(Color.GRAY);

        return label;
    }

    // Method to create a navigation button
    private JButton giveNavigationButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setSize(300, 75);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);

        // Add ActionListener to the button
        button.addActionListener(e -> {
            DroneGui newDroneGui = new DroneGui();
            frame.dispose();
        });
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        return button;
    }

    // Method to create a panel
    private JPanel createPanel() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel.setBorder(new EmptyBorder(0, 0, 160, 0));

        return panel;
    }
}
