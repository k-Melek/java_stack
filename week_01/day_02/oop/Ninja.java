public class Ninja {
  // Member Variables
  private Integer health;
  private String name;
  private String weapon;
  private int damage;

  // CONSTRUCTOR // With 0 Args

  public Ninja() {  
    this.name = "anonymous";
    this.health = 250;
    this.damage = 75;
    this.weapon = "Punches";
  }

  // CONTRUCTOR overloading // All args

  public Ninja(String name, Integer health, String weapon, int damage) {  
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.weapon = weapon;
  }

  // Methods 
  public void displayStats(){
    System.out.println("Name: " + this.getName());
    System.out.println("Health: " + this.getHealth());
  }


  // Getters & Setters

  public String getName() {
    return this.name;
  }

  public void setName(String newName){
    this.name = newName;
  }

  public Integer getHealth() {
    return this.health;
  }

  public void setHeath(Integer newHeath){
    this.health = newHeath;
  }

  public String getWeapon() {
    return this.weapon;
  }

  public void setWeapon(String newWeapon){
    this.name = newWeapon;
  }

  public int getDamage() {
    return this.damage;
  }

  public void setDamage(int newDamage){
    this.damage = newDamage;
  }
}