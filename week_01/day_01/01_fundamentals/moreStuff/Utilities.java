import java.util.ArrayList;

public class Utilities{

  public void printArray(ArrayList<String> someArr) {
    for (int i = 0; i < someArr.size(); i++) {
      someArr.set(i, someArr.get(i) + " is cool");
    }
  }

  public String sumArray(ArrayList<Integer> numberArray){
    Integer sum = 0;
    for (Integer oneNumber: numberArray){
      sum += oneNumber;
    }
    if(sum > 100){
      return "The sum is Big !!!"+ sum;
    }else {
      return "The sum is less than 100"+ sum;
    }
  }
}