public class Boss extends Adventurer{
/* EDIT NUMERICAL VALUES, MESSAGES

    private int , Max;

    public Boss(String name, int){
        super(name, );  
        this. = ;
        Max = ; 
      }
    
      public String getSpecialName(){
        return "Boss " + getName().substring(0, 2);
      }
    
      public int getSpecial(){
        return ;
      }
    
      public int getSpecialMax(){
        return Max;
      }
    
      public void setSpecial(int ){
        __ = __;
      }
    
      public String attack(Adventurer other){
        if (getSpecial() >= 4){ 
          other.applyDamage(7); 
          applyDamage(1); 
          setSpecial(getSpecial() - 4); 
          return other.getSpecialName() + " has been ________.";
        }else{
          applyDamage(8); 
          return getSpecialName() + " _______ and instead attacked themself!";
        }
      }
    
      public String support(){
        setSpecial(getSpecial() + 10); 
        setHP(getHP() + 5); 
        return getSpecialName() + " ______________.";
      }
    
      public String support(Adventurer other){
        if (getSpecial() >= 5){ 
          if (other.getSpecialName().substring(0, 4).equals("Boss")){
            other.setSpecial(other.getSpecial() + 5); 
            setSpecial(getSpecial() - 5); 
            return "_____________.";
          }else{
            setSpecial(getSpecial() - 4); 
            other.setHP(other.getHP() + 10); 
            return other.getSpecialName() + " was healed.";
          }
        }else{
          return "_____________.";
        }
      }
    
      public String specialAttack(Adventurer other){
        if (getSpecial() >= 10){ 
          other.applyDamage(15); 
          setSpecial(getSpecial() - 10); 
          applyDamage(3);
          return other.getSpecialName() + " _______________.";
        }else{
          return "_______________________________.";
        }
      }
   */ 
}
