package frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import background.DroneTime;
import background.Drones;

/**
* Class for history window which provides the user with the amount of drone dynamics between two time stamps.
* 
* @author utkrash,bilal,andrej
* @version 1.0
*/
public class HistoryScreen extends JFrame {
	
	private JFrame frame;
    private JLabel dynamicsLabel = new JLabel();
    private JTextField minute1 = giveMeTextField("", 10);
    private JTextField minute2 = giveMeTextField("", 10);
    private JTextField hour1 = giveMeTextField("", 10);
    private JTextField hour2 = giveMeTextField("", 10);
    private JTextField day1 = giveMeTextField("", 10);
    private JTextField day2 = giveMeTextField("", 10);
    private JTextField month1 = giveMeTextField("", 10);
    private JTextField month2 = giveMeTextField("", 10);
    private JTextField year1 = giveMeTextField("", 10);
    private JTextField year2 = giveMeTextField("", 10);
    private JTextField[] textFields = { minute1, hour1, day1, month1, year1, minute2, hour2, day2, month2, year2 };
    private JButton submitButton;
    private static boolean flag = false;

    public HistoryScreen(Drones drone) {
        frame = initialize();
        /** The flag is set to true if a history window is opened */
        flag = true;
        JLabel label = createJLabelWithValue("Search the dynamics! Max difference 10 min! In this order: min,h,dd,mm,yyyy");
        JPanel inputAndDynamicPanel = new JPanel(new BorderLayout());
        JPanel panels1 = createDatePanel(drone);
        addEnterKeyListenerToTextFields(textFields);
        panels1.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
        label.setBorder(BorderFactory.createEmptyBorder(20, 10, 25, 10));

        /** Add a key listener to the frame for handling Enter key press*/
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();
                }
            }
        });
        /**
         *  Add a window listener to set flag to false when the window is closing.
         *  This is done for other classes to know whether there is an open history window.
         */
        frame.addWindowListener((WindowListener) new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                flag = false;
                super.windowClosing(e);
            }
        });
        /**
         * Add components to the frame
         * Set frame properties and make it visible
         */ 
        frame.add(label, BorderLayout.NORTH);
        frame.add(panels1, BorderLayout.CENTER);
        centerFrameOnScreen(frame);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel createDatePanel(Drones drone) {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 20));
        JPanel inputPanel1 = createDurationPanel(minute1, hour1, day1, month1, year1);
        JPanel inputPanel2 = createDurationPanel(minute2, hour2, day2, month2, year2);
        submitButton = giveNavigationButton("Submit", Color.BLUE);
        submitButton.addActionListener(e -> {
            DroneTime a = DroneTime.stringifier(year1, month1, day1, hour1, minute1);
            DroneTime b = DroneTime.stringifier(year2, month2, day2, hour2, minute2);
            boolean isDynamicsLabelAdded = panel.isAncestorOf(dynamicsLabel);
            if (isDynamicsLabelAdded) {
                /**
                 * Remove the dynamicsLabel from the panel if it is displayed,
                 * Ensures that every re-submit removes the old dynamicslabel with the old information.  
                 */
                panel.remove(dynamicsLabel);
                panel.revalidate();
                panel.repaint();
            }
            /** It is checked whether the time difference exceed 10 minutes. **/
            if (a.getExactTime() - b.getExactTime() > 600 || a.getExactTime() - b.getExactTime() < -600) {
                JOptionPane f = new JOptionPane();
                JOptionPane.showMessageDialog(this, "The difference must be less than 10 minutes", "errorbox",JOptionPane.ERROR_MESSAGE);

            }
            /** It will be displayed how many dynamics were recorded in the time interval when the drone was 'on'.**/
            else {
                dynamicsLabel = createJLabelWithValue(
                        "               Recorded " + drone.getCurrentDroneDynamics(a, b).size()
                      + " dynamics where drone was 'ON'.");
                dynamicsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                System.out.println(drone.getCurrentDroneDynamics(a, b).size());
                panel.add(dynamicsLabel);
                frame.pack();
            }
        });

        /** Add components to the panel */
        panel.add(inputPanel1);
        panel.add(inputPanel2);
        panel.add(submitButton);
        return panel;
    }

    /** Method to create a panel for duration input */
    public JPanel createDurationPanel(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e) {
        JPanel inputPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel1.add(a);
        inputPanel1.add(b);
        inputPanel1.add(c);
        inputPanel1.add(d);
        inputPanel1.add(e);
        return inputPanel1;
    }

    protected JFrame initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setEnabled(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 4, screenSize.height / 4);
        return frame;
    }

    public JTextField giveMeTextField(String text, int len) {
        JTextField textField = new JTextField(text, len);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setSize(50, 50);
        return textField;
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    private void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocationRelativeTo(null);
    }

    private JButton giveNavigationButton(String Text, Color color) {
        JButton button = new JButton(Text);
        button.setFocusable(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }

    /** Method to create a label with a specified value*/
    private JLabel createJLabelWithValue(String text) {
        JLabel j1 = new JLabel();
        j1.setPreferredSize(new Dimension(70, 15));
        j1.setText(text);
        j1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        return j1;
    }
    /**
     *This method takes an array of JTextField components as its parameters (using varargs JTextField... textFields).
     *It iterates through each JTextField in the array using an enhanced for loop (for each loop...)
     *For each JTextField it adds an ActionListener and calls the method focusNextTextField
     */
    private void addEnterKeyListenerToTextFields(JTextField... textFields) {
        for (JTextField textField : textFields) {
            textField.addActionListener(e -> focusNextTextField(textField));
        }
    }
    
    /**
     *This method is called when the Enter key is pressed on a text field
     *It determines the index (currentIndex) of the currently focused JTextField 
     *If the current index is found (currentIndex != -1) and is not the last index of the array (currentIndex < textFields.length - 1), it sets the focus to the next text field in the array using requestFocus()
     */
    private void focusNextTextField(JTextField currentTextField) {
        int currentIndex = -1;
        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i] == currentTextField) {
                currentIndex = i;
                break;
            }
        }
        if (currentIndex != -1 && currentIndex < textFields.length - 1) {
            textFields[currentIndex + 1].requestFocus();
        }
    }

    public static boolean isFlag() {
        return flag;
    }
    
}
