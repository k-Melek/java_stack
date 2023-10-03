import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("Mocha", 4.5);
        Item item2 = new Item("Latte", 3.2);
        Item item3 = new Item("Drip Coffee", 2.5);
        Item item4 = new Item("Cappuccino", 4.9);

        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);

        // order2.addItem(item1);
        // System.out.println("Order 2 (Updated):");
        // System.out.printf("Name: %s\n", order2.getName());
        // System.out.printf("Total: %.2f\n", order2.getTotal());

        order2.addItem(item1);
        order3.addItem(item4);
        order4.addItem(item2);

        System.out.println("Order 1 (Cindhuri):");
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %.2f\n", order1.getTotal());
        System.out.printf("Ready: %s\n", order1.isReady());
        System.out.println("Items: " + order1.getItems());

        System.out.println("\nOrder 2 (Jimmy):");
        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %.2f\n", order2.getTotal());
        System.out.printf("Ready: %s\n", order2.isReady());
        System.out.println("Items: " + order2.getItems());

        System.out.println("\nOrder 3 (Noah):");
        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %.2f\n", order3.getTotal());
        System.out.printf("Ready: %s\n", order3.isReady());
        System.out.println("Items: " + order3.getItems());

        System.out.println("\nOrder 4 (Sam):");
        System.out.printf("Name: %s\n", order4.getName());
        System.out.printf("Total: %.2f\n", order4.getTotal());
        System.out.printf("Ready: %s\n", order4.isReady());
        System.out.println("Items: " + order4.getItems());

    }
}
