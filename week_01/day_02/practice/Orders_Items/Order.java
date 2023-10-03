import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public boolean isReady() {
        return ready;
    }

    public void markAsReady() {
        ready = true;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}