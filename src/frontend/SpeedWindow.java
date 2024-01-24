package frontend;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.*;
import background.Drones;
import background.SpeedClasses;

/**
* Class for the speed window frames displaying the drone information of each drone in set list.
* 
* @author utkrash,bilal,mohit,andrej(partially)
* @version 1.0
*/
public class SpeedWindow extends JFrame {

    private JFrame frame;
    private Method method;
 
    public SpeedWindow(ArrayList<Drones> list) {
        frame = initialize();
        String methodName;
        try {
            /** 
             * Get the method name using reflection.
             * This is done to know which list is currently accessed.
             */
            methodName = SpeedClasses.getName();
            method = SpeedClasses.class.getMethod(methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1, 10, 8));
        JPanel headerPanel = giveHeaderPanel();
        contentPanel.add(headerPanel);
        /** Iterate over the list of drones and create data panels*/
        for (Drones i : list) {
            JPanel data = giveDataPanel(i);
            data.setFont(new Font("MV Boli", Font.ITALIC, 15));
            contentPanel.add(data);
        }
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

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

    protected JPanel giveDataPanel(Drones drone) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 130, 10));
        JLabel[] labels = new JLabel[5];
        labels[0] = createJLabelWithValue(String.valueOf(drone.getId()));
        labels[1] = createJLabelWithValue(drone.getManufacturer());
        labels[2] = createJLabelWithValue(String.valueOf(drone.getMaxSpeed()));
        labels[3] = createJLabelWithValue(String.valueOf(drone.getMaxCarriage()));
        labels[4] = createJLabelWithValue(String.valueOf(drone.getControlRange()));
        JButton j6 = giveNavigationButton("More Info", Color.blue);
        j6.addActionListener(e -> {
            dispose();
            AdditionalInfo info = new AdditionalInfo(drone, method);
        });
        for (JLabel label : labels) {
            dataPanel.add(label);
        }
        dataPanel.add(j6);
        return dataPanel;
    }

    protected JPanel giveHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 20));
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
                ArrayList<Drones> list = (ArrayList<Drones>) method.invoke(null);
                new SpeedWindow(list);
            } catch (Exception e1) {
                e1.printStackTrace();
                new DroneGui();
            }
        });
        for (JLabel label : headerLabels) {
            headerPanel.add(label);
        }
        headerPanel.add(backButton);
        headerPanel.add(refreshButton);
        return headerPanel;
    }

    private JLabel createJLabelWithValue(String text) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(70, 15));
        label.setText(text);
        label.setFont(new Font("Mv Boli", Font.PLAIN, 16));
        return label;
    }

    private JLabel createHeaderJLabelWithValue(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        return label;
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

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
