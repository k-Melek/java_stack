import java.util.ArrayList;

public class CafeUtil {


  public int getStreakGoal() {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
  }

  public double getOrderTotal(double[] items){
    double total = 0.0;
    for (double oneItem : items ) {
      total += oneItem;
    }
    return total;
  }

  public void displayMenu(ArrayList<String> items) {
    for(int i = 0; i < items.size(); i++) {
      String item = items.get(i);
      System.out.println(i +" : " + item);
    }
  }

  public void addCustomer(ArrayList<String> customers){
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();
    System.out.println("Hello, "+ userName +"!");
  }
}