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

  public String attack(Adventurer other){
    if (getSpecial() >= 2){
      other.applyDamage(4);
      applyDamage(2);
      setSpecial(getSpecial() - 2);
      return other.getSpecialName() + " has been poisioned.";
    }else{
      applyDamage(6);
      return getSpecialName() + " is starving.";
    }
  }

  public String support(){
    setSpecial(getSpecial() + 6);
    setHP(getHP() + 3);
    return getSpecialName() + " has grown more berries.";
  }

  public String support(Adventurer other){
    if (getSpecial() >= 6){
      if (other.getSpecialName().substring(0, 6).equals("Farmer")){
        other.setSpecial(other.getSpecial() + 6);
        setSpecial(getSpecial() - 6);
        return "Berries have been traded.";
      }else{
        setSpecial(getSpecial() - 6);
        other.setHP(other.getHP() + 18);
        return other.getSpecialName() + " was fed and healed.";
      }
    }else{
      return "Not enough berries.";
    }
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 7){
      other.applyDamage(10);
      setSpecial(getSpecial() - 7);
      applyDamage(5);
      return other.getSpecialName() + " is covered in poison.";
    }else{
      return "More berries are needed for a bomb.";
    }
  }
}
