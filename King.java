public class King extends Adventurer{
    private int sunpower, sunpowerMax;
  

    public King(String name){
      super(name, 50); 
      sunpowerMax = 70; 
      this.sunpower = sunpowerMax / 2;

    }
  
    public String getSpecialName(){
      return "sunpower";
    }
  
    public int getSpecial(){
      return sunpower;
    }
  
    public int getSpecialMax(){
      return sunpowerMax;
    }
  
    public void setSpecial(int newsunpower){
      sunpower = newsunpower;
    }
  
    public String attack(Adventurer other){
      if (getSpecial() >= 4){ 
        other.applyDamage(7); 
        setSpecial(getSpecial() - 4); 
        return other.getSpecialName() + " has been stabbed.";
      }else{
        applyDamage(8); 
        return getSpecialName() + " is not getting enough Vitamin D and instead attacked themself!";
      }
    }
  
    public String support(){
      setSpecial(getSpecial() + 10); 
      setHP(getHP() + 5); 
      return getSpecialName() + " has harvested more energy from the sun.";
    }
  
    public String support(Adventurer other){
      if (getSpecial() >= 5){ 
        if (other.getSpecialName().substring(0, 4).equals("King")){
          other.setSpecial(other.getSpecial() + 5); 
          setSpecial(getSpecial() - 5); 
          return "Sun energy have been traded.";
        }else{
          setSpecial(getSpecial() - 4); 
          other.setHP(other.getHP() + 10); 
          return other.getSpecialName() + " was healed.";
        }
      }else{
        return "Not enough energy from the sun.";
      }
    }
  
    public String specialAttack(Adventurer other){
      if (getSpecial() >= 10){ 
        other.applyDamage(15); 
        setSpecial(getSpecial() - 10);
        return other.getSpecialName() + " is shot down by lightning.";
      }else{
        return "More energy from the sun is needed to convert to create a lightning strike.";
      }
    }
}
