/** Rubber ducks float and squeak. */
class Rubber extends Duck {

  /** Not a quacker */
  String sound = "squeak";

  /** Cannot fly */
  int speed = 0;
      
    public Rubber(String name, String personality) {
    }

    @Override
    public void fly() {
      System.out.println(name()+" floats at a speed of "+speed+" mph." );
    }
}