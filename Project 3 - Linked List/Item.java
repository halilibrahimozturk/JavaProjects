package halil_ıbrahim_ozturk_hw3;

public class Item {
   String ItemName;
   String Date;
   float Price;
   Item Link;
public String toString() {
   return ItemName+" "+Date+" "+Price;
}
public String getItemName() {
   return ItemName;
}
public void setItemName(String itemName) {
   ItemName = itemName;
}
public String getDate() {
   return Date;
}
public void setDate(String date) {
   Date = date;
}
public float getPrice() {
   return Price;
}
public void setPrice(float price) {
   Price = price;
}
public Item getLink() {
   return Link;
}
public void setLink(Item link) {
   Link = link;
}


}