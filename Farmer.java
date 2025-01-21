public class Farmer extends Adventurer{
  private int berries, berriesMax;
  

  public Farmer(String name){
    super(name, 30);
    berriesMax = 64;
    this.berries = berriesMax / 2;
  }

  public String getSpecialName(){
    return "berries"; 
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
      setSpecial(getSpecial() - 2);
      return other.getName() + " has been poisioned.";
    }else{
      applyDamage(6);
      return getName() + " is starving.";
    }
  }

  public String support(){
    setSpecial(getSpecial() + 6);
    if (getHP() + 3 > getmaxHP()){
      setHP(getmaxHP());
    }else{
      setHP(getHP() + 3);
    }
    return getName() + " has grown more berries.";
  }

  public String support(Adventurer other){
    if (getSpecial() >= 6){
      if (other.getSpecialName().equals("berries")){
        other.setSpecial(other.getSpecial() + 6);
        setSpecial(getSpecial() - 6);
        return "Berries have been traded.";
      }else{
        setSpecial(getSpecial() - 6);
        if (other.getHP() + 18 > other.getmaxHP()){
          other.setHP(other.getmaxHP());
        }else{
          other.setHP(getHP() + 18);
        }
        return other.getName() + " was fed and healed.";
      }
    }else{
      return "Not enough berries.";
    }
  }

  public String specialAttack(Adventurer other){
    if (getSpecial() >= 7){
      other.applyDamage(10);
      setSpecial(getSpecial() - 7);
      return other.getName() + " is covered in poison.";
    }else{
      return "More berries are needed for a bomb.";
    }
  }
}
