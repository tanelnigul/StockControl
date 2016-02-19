package stock;

import java.util.HashMap;
import java.util.Map;

public class StockData { // back-end of the program

    private static class Item {

        Item(String n, double p, int q) {
            name = n; // sets the name equal to "n"
            price = p; // sets the price equal to "p"
            quantity = q; // sets the quantity equal to "q"
        }

        // get methods
        public String getName() {
            return name; // gets the name as a string and returns it to whichever method is calling for it
        }

        public double getPrice() {
            return price; // gets the price as a double and returns it to whichever method is calling for it
        }

        public int getQuantity() {
            return quantity; // gets the quantity as an integer and returns it to whichever method is calling for it
        }

        // instance variables 
        private final String name; // hard-coded value for the string "name"
        private final double price; // hard-coded value for the double "price"
        private int quantity; // private class for the integer "quantity"
    }

    // with a Map you use put to insert a key, value pair 
    // and get(key) to retrieve the value associated with a key
    // You don't need to understand how this works!
    private final static Map<String, Item> stock = new HashMap(); // hard-coded value for the constructor

    static {
        // if you want to have extra stock items, put them in here
        // use the same style - keys should be Strings
        stock.put("00", new Item("Bath towel", 5.50, 10)); // adds an item to the stock, with the name "bath towel", item number "00", price of 5.50 and quantity of 10
        stock.put("11", new Item("Plebney light", 20.00, 5)); // adds an item to the stock, with the name "plebney light", item number "11", price of 20 and quantity of 5
        stock.put("22", new Item("Gorilla suit", 30.00, 7)); // adds an item to the stock, with the name "gorilla suit", item number "22", price of 30 and quantity of 7
        stock.put("33", new Item("Whizz games console", 50.00, 8)); // adds an item to the stock, with the name "whizz games console", item number "33", price of 50 and quantity of 8
        stock.put("44", new Item("Oven", 200.00, 4)); // adds an item to the stock, with the name "oven", item number "44", price of 200 and quantity of 4
    }

    public static String getName(String key) {
        Item item = stock.get(key); // gets  the item from the key from the class stock
        if (item == null) { // if the item entered does not exist
            return null; // null means no such item
        } else { // otherwise
            return item.getName(); // get the name of item
        }
    }

    public static double getPrice(String key) {
        Item item = stock.get(key); // gets the item from the key from the class stock
        if (item == null) { // if the item entered does not exist
            return -1.0; // negative price means no such item
        } else { // otherwise
            return item.getPrice(); // get the price of item
        }
    }

    public static int getQuantity(String key) {
        Item item = stock.get(key); // gets  the item from the key from the class stock
        if (item == null) { // if the item entered does not exist
            return -1; // negative quantity means no such item
        } else { // otherwise
            return item.getQuantity(); // get the quantity of item
        }
    }

	// update stock levels
    // extra is +ve if adding stock
    // extra is -ve if selling stock
    public static void update(String key, int extra) {
        Item item = stock.get(key); // gets the item from the key from the class stock
        if (item != null) { // if the item does not exist
            item.quantity += extra; // add the quantity of it by one (?)
        }
    }

    public static void close() {
        // Does nothing for this static version.
        // Write a statement to close the database when you are using one
    }

}
