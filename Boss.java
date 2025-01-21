public class Boss extends Adventurer{
    private int godpts, godptsMax;

    public Boss(String name, int hp){
        super(name, hp);
        godptsMax = 300;
        this.godpts = godptsMax / 2;
      }

      public String getSpecialName(){
        return "god points";
      }

      public int getSpecial(){
        return godpts;
      }

      public int getSpecialMax(){
        return godptsMax;
      }

      public void setSpecial(int newgodpts){
        godpts = newgodpts;
      }

      public String attack(Adventurer other){
        if (getSpecial() >= 10){
          other.applyDamage(12);
          setSpecial(getSpecial() - 10);
          return other.getSpecialName() + " has been punished by God and sucked 15 HP.";
        }else{
          applyDamage(8);
          return getSpecialName() + " was out of God points and he crashed out! He endured 8 HP of damage.";
        }
      }

      public String support(){
        setSpecial(getSpecial() + 10);
        if (getHP() + 10 > getmaxHP()){
          setHP(getmaxHP());
        }else{
          setHP(getHP() + 10);
        }
        return getSpecialName() + " got 10 God points and healed 10 HP.";
      }


      public String support(Adventurer other){
        if (getSpecial() >= 5){
            setSpecial(getSpecial() - 4);
            if (other.getHP() + 10 > other.getmaxHP()){
              other.setHP(other.getmaxHP());
            }else{
              other.setHP(other.getHP() + 10);
            }
            return other.getSpecialName() + " was healed.";
          }
          else{
          return getSpecialName() + " has too little God Points! Are they still a god?";
        }
      }


      public String specialAttack(Adventurer other){
        if (getSpecial() >= 35){
          other.applyDamage(25);
          setSpecial(getSpecial() - 35);
          return other.getSpecialName() + " was smited.";
        }else{
          return getSpecialName() + "is not powerful enough for this attack.";
        }
      }
}
