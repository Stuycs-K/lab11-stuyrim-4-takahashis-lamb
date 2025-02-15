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
    for(int i = 2; i <= 79; i++){
      drawText(Text.colorize("━", Text.BOLD), 1, i);
      drawText(Text.colorize("━", Text.BOLD), 2, i);

      drawText(Text.colorize("━", Text.BOLD), 7, i);
      drawText(Text.colorize("━", Text.BOLD), 8, i);

      drawText(Text.colorize("━", Text.BOLD), 16, i);
      drawText(Text.colorize("━", Text.BOLD), 17, i);

      drawText(Text.colorize("━", Text.BOLD), 22, i);
      drawText(Text.colorize("━", Text.BOLD), 23, i);

      drawText(Text.colorize("━", Text.BOLD), HEIGHT, i);
      drawText(Text.colorize("━", Text.BOLD), HEIGHT - 1, i);
    }
    for(int i = 2; i <= 29; i++){
      drawText(Text.colorize("┃", Text.BOLD), i, 1);
      drawText(Text.colorize("┃", Text.BOLD), i, 2);
      drawText(Text.colorize("┃", Text.BOLD), i, WIDTH);
      drawText(Text.colorize("┃", Text.BOLD), i, WIDTH - 1);
    }

    drawText(Text.colorize("┏", Text.BOLD), 1, 1);
    drawText(Text.colorize("┓", Text.BOLD), 1, WIDTH);
    drawText(Text.colorize("┗", Text.BOLD), HEIGHT, 1);
    drawText(Text.colorize("┛", Text.BOLD), HEIGHT, WIDTH);

    drawText(Text.colorize("┏", Text.BOLD), 2, 2);
    drawText(Text.colorize("┓", Text.BOLD), 2, WIDTH - 1);
    drawText(Text.colorize("┗", Text.BOLD), HEIGHT - 1, 2);
    drawText(Text.colorize("┛", Text.BOLD), HEIGHT - 1, WIDTH - 1);

    drawText(Text.colorize("┗", Text.BOLD), 7, 2);
    drawText(Text.colorize("┏", Text.BOLD), 8, 2);
    drawText(Text.colorize("┛", Text.BOLD), 7, WIDTH - 1);
    drawText(Text.colorize("┓", Text.BOLD), 8, WIDTH - 1);

    drawText(Text.colorize("┗", Text.BOLD), 16, 2);
    drawText(Text.colorize("┏", Text.BOLD), 17, 2);
    drawText(Text.colorize("┛", Text.BOLD), 16, WIDTH - 1);
    drawText(Text.colorize("┓", Text.BOLD), 17, WIDTH - 1);

    drawText(Text.colorize("┗", Text.BOLD), 22, 2);
    drawText(Text.colorize("┏", Text.BOLD), 23, 2);
    drawText(Text.colorize("┛", Text.BOLD), 22, WIDTH - 1);
    drawText(Text.colorize("┓", Text.BOLD), 23, WIDTH - 1);
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
    String[] words = text.split(" ");

    for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
        drawText(" ", row + i, col + j);
      }
    }

    int currentwidth = 0;
    int currentline = row;
    Text.go(row, col);
    for (int i = 0; i < words.length; i++){
      if (words[i].length() + currentwidth + 1 < width){
        System.out.print(words[i] + " ");
        currentwidth += words[i].length() + 1;
      }
      else{
        currentwidth = 0;
        currentline++;
        drawText(words[i] + " ", currentline, col);
        currentwidth += words[i].length() + 1;
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(String name){
      int randomcounter = (int) (Math.random() * 3);
      if(randomcounter == 0){
        return new CodeWarrior(name);
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
      TextBox(startRow, 3, 75, 4, "");
      
      int startCol = 3;
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
    double percent = (double)hp / maxHP;
    if (percent < 0.25){
      return Text.colorize(output, Text.RED);
    }
    else if (percent >= 0.75){
      return Text.colorize(output, Text.WHITE);
    }else{
      return Text.colorize(output, Text.YELLOW);
    }
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    //draw player party
    drawParty(party, 18);

    //draw enemy party
    drawParty(enemies, 3);

    Text.go(24, 3);

  }

  public static boolean checkdeadparty(ArrayList<Adventurer> party){
    for (int i = 0; i < party.size(); i++){
      if (party.get(i).getHP() <= 0){
        TextBox(9, 3, 75, 1, party.get(i).getName() + " is dead");
        party.remove(i);  // Removes dead players, so they can't be used.
        i--;
      }
    }
    if (party.size() == 0){ // entire team is dead
      TextBox(9, 3, 75, 1, "Your team has been defeated.");
      TextBox(10, 3, 75, 1, Text.colorize("YOU LOSE", Text.RED));
      try{
        Thread.sleep(2000);
      } catch(InterruptedException e){
        e.printStackTrace();
      }
      TextBox(9, 3, 75, 1, " ");
      TextBox(9, 3, 75, 1, Text.colorize("GAME OVER", Text.BLUE));
      try{
        Thread.sleep(2000);
      } catch(InterruptedException e){
        e.printStackTrace();
      }
      quit();
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean checkdeadenemy(ArrayList<Adventurer> enemies){
    for (int i = 0; i < enemies.size(); i++){
      if (enemies.get(i).getHP() <= 0){ // Removes dead enemies, so opposing player can't use them.
        TextBox(9, 3, 75, 1, enemies.get(i).getName() + " is dead");
        enemies.remove(i);
        i--;
      }
    }
    if (enemies.size() == 0){
      TextBox(9, 3, 75, 1, "The other team has died.");
      TextBox(10, 3, 75, 1, Text.colorize("YOU WIN!", Text.YELLOW));
      try{
        Thread.sleep(2000);
      } catch(InterruptedException e){
        e.printStackTrace();
      }
      TextBox(10, 3, 75, 1, "");
      TextBox(9, 3, 75, 1, Text.colorize("GAME OVER", Text.BLUE));
      try{
        Thread.sleep(2000);
      } catch(InterruptedException e){
        e.printStackTrace();
      }
      quit();
      return true;
    }
    else{
      return false;
    }
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(24, 3);

      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void drawmove(String move){
    TextBox(9, 3, 75, 7, move);
  }

  public static void run(){
    //Clear and initialize
    Text.reset();
    Text.hideCursor();
    Text.clear();
    drawBackground();

    Scanner in = new Scanner(System.in);

    TextBox(24, 3, 75, 1, "How many opponents would you like to play against?(1-3)");
    Text.go(24, 59);
    int amountenemy = in.nextInt();

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

    TextBox(24, 3, 75, 1, "How many allies would you like to play with?(1-3)");
    Text.go(24, 53);
    int amountparty = in.nextInt();
    in.nextLine();

    TextBox(24, 3, 75, 1, "What do you want their names to be?(in name, name2 format)");
    Text.go(24, 62);
    String partynames = in.nextLine();

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

    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    
    

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){

      String preprompt = "Command for "+party.get(whichPlayer)+": attack/special/support/quit + enemy number: ";

      if (!partyTurn && whichOpponent >= enemies.size()) {
        whichOpponent = 0;
        turn++;
        partyTurn = true;
      }
      


      //example debug statment
      //TextBox(24,3,75,1,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );


      //display event based on last turn's input
      if(partyTurn && whichPlayer < party.size()){
        //Read user input
        TextBox(24, 3, 75, 1, preprompt);
        Text.go(24, 3 + preprompt.length());
        int personchoice = 0;
        input = in.nextLine();
        if(input.equals("q") || input.equals("quit")){
          TextBox(9, 3, 75, 1, "Game aborted.");
          quit();
          return;
        }
        try{
          personchoice = Integer.parseInt(input.substring(input.length() - 1, input.length())) - 1;  
        } catch(NumberFormatException e){
          TextBox(9, 3, 75, 1, "Invalid input.");
          Text.showCursor();
          Text.go(1, 1);
        }
        //Process user input for the last Adventurer:
        String move = "";
        if(input.startsWith("attack") || input.startsWith("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          move = party.get(whichPlayer).attack(enemies.get(personchoice));
          drawmove(move);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special") || input.startsWith("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          move = party.get(whichPlayer).specialAttack(enemies.get(personchoice));
          drawmove(move);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          if(whichPlayer == personchoice){
            move = party.get(whichPlayer).support();
          }
          else{
            move = party.get(whichPlayer).support(party.get(personchoice));
          }
          drawmove(move);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        if(checkdeadparty(party)){
          drawScreen(party, enemies);
          quit();
          return;
        }
        if(checkdeadenemy(enemies)){
          drawScreen(party, enemies);
          quit();
          return;
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;

        if(whichPlayer >= party.size()){
          whichPlayer = 0;
          partyTurn = false;
          String prompt = "press enter to see enemy turn";
          TextBox(24, 3, 75, 1, prompt);
          Text.go(24, 4 + prompt.length());
          input = userInput(in);
        }

      
        drawScreen(party, enemies);


        //This is after the player's turn, and allows the user to see the enemy turn
        //done with one party member
      }
        
      else{
        //not the party turn!
        partyTurn = false;
        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        String move = "";
        int randperson = (int)(Math.random() * party.size());
        int randmove = (int)(Math.random() * 8);
        if(randmove <= 4){ //increases chance of normal attack, not sustainable to have same chance of regular and special attack
          //implement attack
          move = enemies.get(whichOpponent).attack(party.get(randperson));
          drawmove(move);
        }
        else if(randmove == 5 || randmove == 6){
          //implement special
          move = enemies.get(whichOpponent).specialAttack(party.get(randperson));
          drawmove(move);
        }
        else{
          //implement support
          int randsupport = (int)(Math.random() * enemies.size());
          if(randsupport == whichOpponent){
            move = enemies.get(whichOpponent).support();
          }
          else{
            move = enemies.get(whichOpponent).support(enemies.get(randsupport));
          }
          drawmove(move);
        }

        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

        if(checkdeadparty(party)){
          drawScreen(party, enemies);
          quit();
          return;
        }
        if(checkdeadenemy(enemies)){
          drawScreen(party, enemies);
          quit();
          return;
        }


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";
        TextBox(24, 3, 75, 1, prompt);
        Text.go(24, 4 + prompt.length());
        input = userInput(in);

        whichOpponent++;

        if(whichOpponent >= enemies.size()){
          whichOpponent = 0;
          partyTurn = true;
          turn++;
        }

        drawScreen(party, enemies);
      }//end of one enemy.

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();

  }
}
