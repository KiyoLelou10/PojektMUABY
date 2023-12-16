package drone_drone;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

//Create the class for the new window
public class Information_Window extends JFrame {

 private List<String> information;

 public Information_Window(List<String> information) {
     this.information = information;
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     setSize(300, 300);
     setLayout(null);
     setVisible(true);

     // Create buttons for each piece of information
     int i = 0;
     for (String droneinfo : information) {
         JButton button = new JButton(droneinfo);
         button.setBounds(10, 10 + (i * 30), 200, 30);
         add(button);
     }
 }
}
