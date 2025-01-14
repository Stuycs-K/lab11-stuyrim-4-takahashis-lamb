import java.util.*;

public class Tester{
  public static void main(String[] args){
    ArrayList<Adventurer> party = new ArrayList<Adventurer>();


    Adventurer a1 = Game.createRandomAdventurer("BOB");
    Adventurer a2 = Game.createRandomAdventurer("REBECCA");
    Adventurer a3 = Game.createRandomAdventurer("JAMES");

    party.add(a1); party.add(a2); party.add(a3);

    Game.drawBackground();


/* METHODS THAT NEED DEBUGGING

    Game.TextBox(10, 75, 30, 80, "hello world")
    Game.drawParty(party, 10);
*/
  }
}
