package halil_ıbrahim_ozturk_hw3;
public class Customer {
   private String Name;
   private String SurName;
   private int ID;
   private Item Link;
  
  
   public String toString() {
       String retstr = "Name " + Name;
       retstr += "Surname " + SurName;
       retstr += "ID " + ID;
       return retstr;
   }

   public String getName() {//get name (get method)
       return Name;
   }

   public void setName(String name) {//adding new customer name (set method)
       Name = name;
   }

   public String getSurName() { //getting surname (get method)
       return SurName;
   }

   public void setSurName(String surName) {//adding new customer name (set method)
       SurName = surName;
   }

   public int getID() {//(get method)
       return ID;
   }

   public void setID(int iD) {//(set method)
       ID = iD;
   }

   public Item getLink() {//(get method)
       return Link;
   }

   public void setLink(Item link) {//(set method)
       Link = link;
   }
  
  

}