import java.util.ArrayList;

public class Test{
  public static void main(String[] args) {

    ArrayList<String> coolStrings = new ArrayList<String>();
    coolStrings.add("Bob");
    coolStrings.add("Mary");
    coolStrings.add("Spector");

    //create instance
    Utilities printCool = new Utilities();
    printCool.printArray(coolStrings);

    

    ArrayList<Integer> numberArray = new ArrayList<Integer>();

    numberArray.add(56);
    numberArray.add(22);
    numberArray.add(33);
    // Create a new instance

    Utilities instance2 = new Utilities();
    String result = instance2.sumArray(numberArray);
    System.out.println(result);

  }
}