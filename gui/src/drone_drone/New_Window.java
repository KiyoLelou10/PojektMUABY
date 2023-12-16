package drone_drone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class New_Window extends JFrame {

    public New_Window() {
        JLabel label = new JLabel("New Window");
        label.setBounds(0, 0, 200, 200);
        add(label);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }
}