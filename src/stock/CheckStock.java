package stock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckStock extends JFrame implements ActionListener { // GUI of the Check Stock window

    JTextField stockNo = new JTextField(7); // adds the text field "stockNo" to the program with max. lenght of 7 characters
    JTextArea information = new JTextArea(20, 40); // adds the text area "information" to the program with the height of 3 lines and width of 50
    JButton check = new JButton("Check Stock"); // adds the button "check" with a label "Check Stock" to the program
    DecimalFormat pounds = new DecimalFormat("£#,##0.00"); // sets the formatting of decimals
    JLabel imageLabel = new JLabel(new ImageIcon("images/empty.jpg"));

    public CheckStock() {
        setLayout(new BorderLayout()); // sets the layout of the GUI
        setBounds(100, 100, 600, 270); // sets the bounds of the GUI
        setTitle("Check Stock"); // sets the title of the windows "Check Stock", located on the top left corner of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // enables the windows close button, sets it to default
        JPanel top = new JPanel(); // constructor for the top panel
        top.add(new JLabel("Enter Stock Number:")); // adds a label to the top of the layout
        top.add(stockNo); // adds the text field "stockNo" to the top of the layout
        top.add(check); // adds the button "check" to the top of the layout
        check.addActionListener(this); // adds an action listener to the button "check"
        add("North", top); // assembles "north" to the top part of the GUI
        JPanel middle = new JPanel(); // constructor for the middle panel
        middle.add(information); // adds the text area "information" to the middle of the layout
        add("Center", middle); // assembles "center" to the middle part of the GUI
        add("East", imageLabel);

        setResizable(false); // disables the window resizing
        setVisible(true); // a necessary line of code to make the GUI visible
    }

    @Override
    public void actionPerformed(ActionEvent e) { // decides what happens when an action has occured
        String key = stockNo.getText(); // saves the text from the "stockNo" field to the string "key"
        String name = StockData.getName(key); // gets the key from the StockData class and saves it under the string "name"
        if (name == null) { // if the there is no such name as inserted...
            information.setText("No such item in stock"); // ...then let the user know

        } else { // if there is however...
            information.setText(name); // ...set the text in the text area "information" to the name entered...
            information.append("\nPrice: " + pounds.format(StockData.getPrice(key))); // ...and show the price of that item...
            information.append("\nNumber in stock: " + StockData.getQuantity(key)); /// ...and show the stock of that item

            String imageFileName = "images\\" + key + ".jpg";
            File imageFile = new File(imageFileName);
            if (!imageFile.exists()) {
                imageFileName = "images\\empty.jpg";
            }
            imageLabel.setIcon(new ImageIcon(imageFileName));
        }
    }
}