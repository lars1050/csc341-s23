/** Generic Duck that flies and quacks. */
public class Duck {

  /** Preferred name */
  private String name;

  /** Known to be */
  private String personality;

  /** Rate of flying (mph) */
  private int speed = 10;

  /** Type of vocalization */
  private String sound = "quack";

  /** Default Constructor */
  public Duck() {
    name = "No Name";
    personality = "flat";
  }

  /** Constructor with initial information
   * @param name Refer to Duck using specified name
   * @param personality Duck's character
   */
  public Duck(String name, String personality) {
    name = name;
    personality = personality;
    System.out.println("Hi "+name+". You fly "+speed+" mph and say "+sound+".");
  }

  /** Prints general information */
  public void describe() {
    System.out.println(name+" has a "+personality+" personality.");
  }

  /** Prints type of vocalization */
  public void speak() {
    System.out.println(name+" says "+sound+".");
  }

  /** Prints type of flying and speed */
  public void fly() {
    System.out.println(name+" flies "+speed+" mph.");
  }

  //______________________________________________________________
  // All below are getters and setters for class member variables

  public void name(String value) { 
    name = value; 
  }
  public String name() { 
    return name; 
  }

  public void personality(String value) { 
    personality = value; 
  }
  public String personality() { 
    return personality; 
  }

  public void sound(String value) { 
    sound = value; 
  }
  public String sound() { 
    return sound; 
  }

  public void speed(int value) { 
    speed = value; 
  }
  public int speed() { 
    return speed; 
  }
}
