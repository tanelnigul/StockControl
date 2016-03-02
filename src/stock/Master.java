package stock;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Master extends JFrame implements ActionListener { // main GUI

    JButton check = new JButton("Check Stock"); // adds the button "check" with the label "check stock" to the program
    JButton purchase = new JButton("Purchase Item"); // adds the button "purchase" with the label "purchase item" to the program
    JButton stock = new JButton("Update Stock"); // adds the button "stock" with the label "update stock" to the program
    JButton quit = new JButton("Exit"); // adds the button "quit" with the label "exit" to the program

    public static void main(String[] args) {
        // The main method, needed to run the program.
        // The program can only be run from this class.
        Master master = new Master();
    }

    public Master() {
        setLayout(new BorderLayout()); // sets the GUI layout
        setSize(450, 100); // sets the size of the window
        setTitle("Master"); // sets the title of the window, on the top left corner

        // close application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // disables the windows close button

        JPanel top = new JPanel(); // constructor to another java class
        top.add(new JLabel("Select an option by clicking one of the buttons below")); // adds a text label to the GUI
        add("North", top); // assembles "north" to the top part of the GUI

        JPanel bottom = new JPanel();
        bottom.add(check); // adds the button to the layout
        check.addActionListener(this); // adds an action listener to "check" button
        bottom.add(purchase); // adds the button to the layout
        purchase.addActionListener(this); // adds an action listener to "purchase" button
        bottom.add(stock); // adds the button to the layout
        stock.addActionListener(this); // adds an action listener to "stock" button
        bottom.add(quit); // adds the button to the layout
        quit.addActionListener(this); // adds an action listener to "quit" button
        add("South", bottom); // assembles "south" to the bottom part of the GUI

        setResizable(false); // disables windows resizing
        setVisible(true); // a necessary line of code to make the GUI visible
    }

    @Override
    public void actionPerformed(ActionEvent e) { // decides what happens when an action has occured
        if (e.getSource() == check) { // if the button "check" has been pressed...
            CheckStock checkStock = new CheckStock(); // ...then run this constructor
        }

        if (e.getSource() == purchase) { // if the button "purchase" has been pressed...
            PurchaseItem purchaseItem = new PurchaseItem(); // ...then run this constructor
        }

        if (e.getSource() == stock) { // if the button "quit" has been pressed...
            UpdateStock updateStock = new UpdateStock(); // ...then run this constructor
        }

        if (e.getSource() == quit) { // if the button "quit" has been pressed...
            StockData.close(); // ...then close the StockData class...
            System.exit(0); // ...and close the program
        }

    }
}
