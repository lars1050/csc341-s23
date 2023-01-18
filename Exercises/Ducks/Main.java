public class Main {
  public static void main(String[] args) {

    System.out.println("^^^^^^^^  DUCKS  ^^^^^^^");

    Duck dottie = new Duck("dottie","raucaus");

    Mallard mrtee = new Mallard("Mr T","gentle giant");

    Lame zeus = new Lame("zeus","jaunty");

    Rubber lemon = new Rubber("lemon","sunny");

    Duck[] ducks = {dottie, mrtee, zeus, lemon};
    for (Duck d : ducks) {
      System.out.println("----------------------------");
      d.describe();
      d.fly();
      d.speak();
    }
  }
}
