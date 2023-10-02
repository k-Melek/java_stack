import java.util.Arrays;
import java.util.ArrayList;

public class Test {

  public static void main(String[] args) {

    // System.out.println("Hello JAVA !");

  // === Variables ===
  // Primitive Types
  int luckyNumber = 3;
  boolean vote = true;
  double pi = 3.14;
  float tax = 9.25f;
  char letter = 'a';
  
  // System.out.println("this is my lucky number " + luckyNumber);

  Integer ticket = 65;
  String name = "bob";
  Double pie = 3.14;

  // ... String ----
  String a = "My name is john ";
  String b = "My name is bob";
  // System.out.println(a.indexOf('n'));
  // System.out.println(a.concat(b));


  //===== Arrays ======

  // fixed array
  int[] numbers;         // Declaring the variable
  numbers = new int[4];
  
  numbers[0] = 88;
  numbers[1] = 33;
  // numbers[2] = 44;
  numbers[3] = 11;

  // System.out.println(Arrays.toString(numbers));


  int[] myArray = {11, 22, 33, 44};

  // System.out.println(Arrays.toString(myArray));


  // ===== ArrayList =====
  ArrayList<Integer> listArray = new ArrayList<Integer>();

  listArray.add(5);
  listArray.add(22);
  listArray.add(3);
  listArray.add(14);

  listArray.add(2, 99);

  Integer lost = listArray.remove(0);
  // System.out.println(lost);


  // for(int i = 0; i < listArray.size(); i++) {
  //   System.out.println(listArray.get(i));
  // }



  ArrayList<String> names = new ArrayList<String>();
  
  names.add("Jane");
  names.add("Lucas");
  names.add("Ralph");
  names.add("Amy");

  System.out.println(names);
  }
}