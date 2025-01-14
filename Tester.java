public class Tester{
  public static void main(String[] args){
    Adventurer a1 = Game.createRandomAdventurer("BOB");
    System.out.println(a1.getSpecialName());
    System.out.println(a1.getHP());

    Game.drawBackground();
  }
}
