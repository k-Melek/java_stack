public class AnotherFile {
  public void greeting() {
    System.out.println("Hello there !");
  }
  public String greeting(String name) {
    return "Greetings " + name;
  }

  public String greeting(String name, int times) {
    String phrase ="";
    for(int i = 0; i < times; i++){
      phrase += " Greeting " + name + "\n";
    }
    return phrase;
  }
}