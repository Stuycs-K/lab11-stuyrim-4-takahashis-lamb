public class Farmer extends Adventurer{
  private int berries, berriesMax;
  

  public Farmer(String name, int berries){
    super(name, 30);
    this.berries = berries;
    berriesMax = 64;
  }

  public String getSpecialName(){
    return "Farmer " + getName().substring(0, 2);
  }

  public int getSpecial(){
    return berries;
  }

  public int getSpecialMax(){
    return berriesMax;
  }

  public void setSpecial(int newBerry){
    berries = newBerry;
  }
}
