package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.*;
import background.Drones;
import background.Speedclasses;

public class SpeedWindow extends JFrame {

    private JFrame frame;
    protected Method meth;

    // Constructor for SpeedWindow
    public SpeedWindow(ArrayList<Drones> list) {
        // Initialize the frame and method
        frame = initialize();

        String methodName;
        try {
            // Get the method name using reflection
            methodName = Speedclasses.getName();
            meth = Speedclasses.class.getMethod(methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the content panel and set its layout
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1, 10, 8));

        // Create the header panel using the helper method
        JPanel headerPanel = giveHeaderPanel();
        contentPanel.add(headerPanel);

        // Iterate over the list of drones and create data panels
        for (Drones i : list) {
            JPanel data = giveDataPanel(i);
            data.setFont(new Font("MV Boli", Font.ITALIC, 15));
            contentPanel.add(data);
        }

        // Create a scroll pane and add it to the frame
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    // Helper method to initialize the frame
    protected JFrame initialize() {
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.getContentPane().setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 10, 8));
        frame.setVisible(true);
        return frame;
    }

    // Helper method to create a data panel for a drone
    protected JPanel giveDataPanel(Drones drone) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 10));

        // Create an array of labels
        JLabel[] labels = new JLabel[5];
        labels[0] = createJLabelWithValue(String.valueOf(drone.getId()));
        labels[1] = createJLabelWithValue(drone.getManufacturer());
        labels[2] = createJLabelWithValue(String.valueOf(drone.getMaxSpeed()));
        labels[3] = createJLabelWithValue(String.valueOf(drone.getMaxCarriage()));
        labels[4] = createJLabelWithValue(String.valueOf(drone.getControlRange()));

        JButton j6 = giveNavigationButton("More Info", Color.blue);
        j6.addActionListener(e -> {
            dispose();
            AdditionalInfo info = new AdditionalInfo(drone, meth);
        });

        // Add labels to the data panel using a for each loop
        for (JLabel label : labels) {
            dataPanel.add(label);
        }
        dataPanel.add(j6);

        return dataPanel;
    }

    // Method to create the header panel
    protected JPanel giveHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));

        // Create an array of header labels
        JLabel[] headerLabels = new JLabel[5];
        headerLabels[0] = createHeaderJLabelWithValue("Drone Id");
        headerLabels[1] = createHeaderJLabelWithValue("Manufacturer");
        headerLabels[2] = createHeaderJLabelWithValue("Max Speed");
        headerLabels[3] = createHeaderJLabelWithValue("Max Carriage ");
        headerLabels[4] = createHeaderJLabelWithValue("Control Range");

        JButton backButton = giveNavigationButton("<- Back", Color.RED);
        backButton.addActionListener(e -> {
            frame.dispose();
            DroneGui gui = new DroneGui();
        });

        JButton refreshButton = giveNavigationButton("Refresh", Color.DARK_GRAY);
        refreshButton.addActionListener(e -> {
            frame.dispose();
            try {
                ArrayList<Drones> list = (ArrayList<Drones>) meth.invoke(null);
                new SpeedWindow(list);
            } catch (Exception e1) {
                e1.printStackTrace();
                new DroneGui();
            }
        });

        // Add header labels to the header panel using a loop
        for (JLabel label : headerLabels) {
            headerPanel.add(label);
        }
        headerPanel.add(backButton);
        headerPanel.add(refreshButton);

        return headerPanel;
    }

    // Method to create a JLabel with a specified value
    private JLabel createJLabelWithValue(String text) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(70, 15));
        label.setText(text);
        label.setFont(new Font("Mv Boli", Font.PLAIN, 16));
        return label;
    }

    // Method to create a header JLabel with a specified value
    private JLabel createHeaderJLabelWithValue(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        return label;
    }

    // Override the dispose method to handle frame disposal
    @Override
    public void dispose() {
        frame.dispose();
    }

    // Method to create a navigation button with a specified text and color
    private JButton giveNavigationButton(String Text, Color color) {
        JButton button = new JButton(Text);
        button.setSize(300, 75);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }
}
