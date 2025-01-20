import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
    quit();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(1, 1);
    for(int i = 1; i <= 80; i++){
      System.out.print("━");
    }
    for(int i = 1; i <= 30; i++){
      Text.go(i, 1);
      System.out.print("┃");
    }
    for(int i = 1; i <= 30; i++){
      Text.go(i, 80);
      System.out.print("┃");
    }
    for(int i = 1; i <= 80; i++){
      Text.go(30, i);
      System.out.print("━");
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int totalChar = width * height;
    Text.go(row, col);
    for (int i = 0; i < totalChar; i++){
      if (i < text.length()){
        System.out.print(text.substring(i, i + 1));
        if (col < col + width){
          col++;
          Text.go(row, col);
        }else{
          row++;
          Text.go(row, col);
        }
      }
      else{
        System.out.print(" ");
        if (col < col + width){
          col++;
          Text.go(row, col);
        }else{
          row++;
          Text.go(row, col);
        }
      }
    }
    /*
    if (text.length() <= width){
      Text.hideCursor();
      drawText(text, row, col);
    }else{
      Text.hideCursor();
      Text.go(row, col);
      for (int i = row; i > row - height; i--){
        for (int l = col; l < col + width; l++){
          int pos = ((startH - i) * width) + col - startW;
          if (pos <= text.length()){
            drawText(text.substring(pos, pos + 1), row, col);
          }else{
            Text.go(row, col);
            System.out.print(" ");
          }
        }
      }
      
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(String name){
      int randomcounter = (int) (Math.random() * 3);
      if(randomcounter == 0){
        return new CodeWarrior();
      }
      else if(randomcounter == 1){
        return new Farmer(name);
      }
      else{
        return new King(name);
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      int startCol = 2;
      for(int i = 0; i < party.size(); i++){
        drawText(party.get(i).getName(), startRow, startCol);
        drawText("HP: " + colorByPercent(party.get(i).getHP(), party.get(i).getmaxHP()), startRow + 1, startCol);
        drawText(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial() + "/" + party.get(i).getSpecialMax(), startRow + 2, startCol);
        startCol += 30;
      }


      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    int percent = (hp / maxHP) * 100;
    if (percent < 25){
      Text.colorize(output, 31);
    }
    else if (percent >= 75){
      Text.colorize(output, 37);
    }else{
      Text.colorize(output, 33);
    }
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    //draw player party
    drawParty(party, 20);

    //draw enemy party
    drawParty(enemies, 3);

    Text.go(24, 2);

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(24, 2);

      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written
      TextBox(24, 2, 1, 78, " ");

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void drawmove(String move, Adventurer action, Adventurer recipient){
    TextBox(8, 3, 76, 10, action.getName() + move + recipient.getName());
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    drawBackground();

    TextBox(24, 2, 78, 1, "How many opponents would you like to play against?(1-3)");
    Text.go(24, 58);
    Scanner amount = new Scanner(System.in);
    int amountenemy = amount.nextInt();

    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Adventurer James = createRandomAdventurer("JAMES");
    Adventurer Caroline = createRandomAdventurer("CAROLINE");
    Adventurer Madison = createRandomAdventurer("MADISON");
    Adventurer GodBoss = new Boss("MightyGod", 150);

    if(amountenemy == 1){
      enemies.add(GodBoss);
    }
    else if(amountenemy == 2){
      enemies.add(James); enemies.add(Caroline);
    }
    else{
      enemies.add(James); enemies.add(Caroline); enemies.add(Madison);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:0
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE

    TextBox(24, 2, 78, 1, "How many allies would you like to play with?(1-3)");
    Text.go(24, 52);
    int amountparty = amount.nextInt();
    amount.nextLine();

    TextBox(24, 2, 78, 1, "What do you want their names to be?(in name, name2 format)");
    Text.go(24, 61);
    String partynames = amount.nextLine();
    amount.close();

    String[] partyname = partynames.split(", ");
    
    //change player names, change from createRandom to specific types based on input
    if(amountparty == 1){
      Adventurer p1 = new King(partyname[0]);
      party.add(p1);
    }
    else if(amountparty == 2){
      Adventurer p1 = new King(partyname[0]);
      Adventurer p2 = new Farmer(partyname[1]);
      party.add(p1); party.add(p2);
    }
    else{
      Adventurer p1 = new King(partyname[0]);
      Adventurer p2 = new Farmer(partyname[1]);
      Adventurer p3 = new CodeWarrior(partyname[2]);
      party.add(p1); party.add(p2); party.add(p3);
    }


    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/support/quit + desired enemy number";
    

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);
      Scanner readinput = new Scanner(input);
      String move = readinput.next();
      int personchoice = readinput.nextInt();

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );


      //display event based on last turn's input
      if(partyTurn){
        TextBox(24, 2, 1, 78, preprompt);
        //Process user input for the last Adventurer:
        if(move.equals("attack") || move.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          party.get(whichPlayer).attack(enemies.get(personchoice));
          drawmove(" attacked ", party.get(whichPlayer), enemies.get(personchoice));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(move.equals("special") || move.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          party.get(whichPlayer).specialAttack(enemies.get(personchoice));
          drawmove(" used special attack on ", party.get(whichPlayer), enemies.get(personchoice));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(move.startsWith("su ") || move.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          party.get(whichPlayer).support(party.get(personchoice));
          drawmove(" supported ", party.get(whichPlayer), party.get(personchoice));
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        int randperson = (int)(Math.random() * party.size());
        int randmove = (int)(Math.random() * 8);
        if(randmove <= 4){ //increases chance of normal attack, not sustainable to have same chance of regular and special attack
          //implement attack
          enemies.get(whichOpponent).attack(party.get(randperson));
          drawmove(" attacked ", enemies.get(whichOpponent), party.get(randperson));
        }
        else if(randmove == 5 || randmove == 6){
          //implement special
          enemies.get(whichOpponent).specialAttack(party.get(randperson));
          drawmove(" used their special attack on ", enemies.get(whichOpponent), party.get(randperson));
        }
        else{
          //implement support
          int randsupport = (int)(Math.random() * enemies.size());
          enemies.get(whichOpponent).support(enemies.get(randsupport));
          drawmove(" supported ", enemies.get(whichOpponent), enemies.get(randsupport));
        }

        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
    Text.clear();
    Text.go(1, 1);
  }
}
