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
        return other.getName() + " has been stabbed.";
      }else{
        applyDamage(8); 
        return getName() + " is not getting enough Vitamin D and instead attacked themself!";
      }
    }
  
    public String support(){
      setSpecial(getSpecial() + 10); 
      if (getHP() + 10 > getmaxHP()){
        setHP(getmaxHP());
      }else{
        setHP(getHP() + 10);
      }
      return getName() + " has harvested more energy from the sun.";
    }
  
    public String support(Adventurer other){
      if (getSpecial() >= 5){ 
        if (other.getSpecialName().equals("sunpower")){
          other.setSpecial(other.getSpecial() + 5); 
          setSpecial(getSpecial() - 5); 
          return "Sun energy have been traded.";
        }else{
          setSpecial(getSpecial() - 4); 
          if (other.getHP() + 10 > other.getmaxHP()){
            other.setHP(other.getmaxHP());
          }else{
            other.setHP(other.getHP() + 10); 
          }
          return other.getName() + " was healed.";
        }
      }else{
        return "Not enough energy from the sun.";
      }
    }
  
    public String specialAttack(Adventurer other){
      if (getSpecial() >= 20){ 
        other.applyDamage(20); 
        setSpecial(getSpecial() - 20);
        return other.getName() + " is shot down by lightning.";
      }else{
        return "More energy from the sun is needed to convert to create a lightning strike.";
      }
    }
}
