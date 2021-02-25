
package halil_ıbrahim_ozturk_hw3;

import java.io.File;// Import the File class
import java.io.IOException;//general class of exceptions 
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.StringTokenizer;//allows an application to break a string into tokens

public class EEM480DataBase implements DB_Interface {//implement Database interface
   Customer[] customerArray = new Customer[100];//new customer object
   int size = 0;//initialize from 0

   public static void main(String[] args) {
       EEM480DataBase companyDatabase = new EEM480DataBase(); //new database object
       companyDatabase.readFromFile("E:\\Mydrive\\Mydata.txt");//read from file always
       companyDatabase.listItems(5);//print items according to ID of customer  which scan from txt file
   }

   @Override
   public void addCustomer(Customer newCustomer) {//add new customer ( new list)
       customerArray[size] = newCustomer;//new list
       size++;//new size
       //add the customer object to the customer array.
   }

   @Override
   public void listItems(int ID) { //listing items of customer
       //list all the items that customer with ID to the screen.
       for (Customer customer : customerArray) {//task condition
           if (customer != null && customer.getID() == ID) {//determine ID
               Item item = customer.getLink();
               System.out.println(customer.toString() + " Item List:");//once customer name ,surname and ıd
               while (item != null) {
                   System.out.println(item.toString());//printing items
                   item = item.getLink();
               }
               break;
           }
       }

   }

   @Override
   public Customer getNewCustomer(String Name, String SurName, int ID) {
       //gets an information of new customer 
       //from user. The information will contain Name,
       //Surname and ID.
       Customer cust = new Customer(); //new object
       cust.setID(ID);
       cust.setName(Name);
       cust.setSurName(SurName);
       return cust;
   }

   @Override
   public void addNewItem(Integer ID, String ItemName, String Date, float Price) throws Exception {
       //adds the new item to the linked list of 
       //corresponding array location which contains the ID. 
       //If ID is not found, IDNotFoundException has to be thrown.
       boolean flag = false; //create a condition for readability(to make easy algorithm)
       for (Customer customer : customerArray) { //task condition
           if (customer != null && customer.getID() == ID) {//find the ID
               Item item = customer.getLink();
               Item y = item;//add new item 
               if (item == null) {
                   Item itm = new Item();//new item object
                   //set methods to determine item informations
                   itm.setItemName(ItemName);
                   itm.setDate(Date);
                   itm.setPrice(Price);
                   itm.setLink(null);
                   customer.setLink(itm);
               } else {
                   while (y != null) {
                       if (y.getLink() == null) {
                           Item itm = new Item();
                           itm.setItemName(ItemName);
                           itm.setDate(Date);
                           itm.setPrice(Price);
                           itm.setLink(null);
                           y.setLink(itm);
                           break;
                       } else {
                           y = y.getLink();
                       }
                   }
                   customer.setLink(item);
               }
              
               flag = true;
               break;
           }
       }
       if (!flag) {
           throw new Exception();
       }
   }

   @Override
   public Float getTotalTradeofCustomer(int ID) {
       //gets the ID of the user and 
       //finds the total amount of expenses of her/him and
       //put the result on screen.
       float trade = 0;
       for (Customer customer : customerArray) {
           if (customer != null && customer.getID() == ID) {
               Item item = customer.getLink();
               while (item != null) {
                   trade += item.getPrice();
                   item = item.getLink();
               }
               break;
           }
       }
       return trade;
   }

   @Override
   public Float getTotalTrade() {
       //finds and shows the total amount of trades of the company
       float trade = 0;
       for (Customer customer : customerArray) {
           if (customer != null) {
               Item item = customer.getLink();
               while (item != null) {
                   trade += item.getPrice();
                   item = item.getLink();
               }
           }
       }
       return trade;
   }

   @Override
   public void readFromFile(String path) {
       prepareData(path, " ");
               System.out.println("The content of file has been read");
               //read the trade text data from file.

   }

   public void prepareData(String filepath, String delim) {
       File file = new File(filepath);//file object

       try (Scanner sc = new Scanner(file)) {//using scanner function to scan text file
           while (sc.hasNextLine()) {

               StringTokenizer st = new StringTokenizer(sc.nextLine(), delim);
               int j = 0;
               Customer customer = null;
               Item newItem = null;
               while (st.hasMoreTokens()) {
                   if (j == 0) {
                       String value = st.nextToken();
                       try {
                           int id = Integer.parseInt(value);
                           customer = search_Customer(id);//returns the customer object of ID
                           Item item = customer.getLink();
                           Item y = item;
                           if (item == null) {
                               newItem = new Item();
                               newItem.setLink(null);//set methods
                               customer.setLink(newItem);//set methods
                           } else {
                               while (y != null) {
                                   if (y.getLink() == null) {
                                       newItem = new Item();
                                       newItem.setLink(null);//set methods
                                       y.setLink(newItem);//set methods
                                       break;
                                   } else {
                                       y = y.getLink();//get methods
                                   }
                               }
                               customer.setLink(item);

                           }

                       } catch (NumberFormatException e) {
                           customer = new Customer();
                           customer.setName(value);
                       }

                   } else if (j == 1) {
                       String value = st.nextToken();
                       if (newItem != null) {
                           newItem.setItemName(value);
                       } else {
                           customer.setSurName(value);
                       }

                   } else if (j == 2) {
                       String value = st.nextToken();
                       if (newItem != null) {
                           newItem.setDate(value);
                       } else {
                           customer.setID(Integer.parseInt(value));
                       }
                   } else if (j == 3) {
                       String value = st.nextToken();
                       if (newItem != null) {
                           newItem.setPrice(Float.parseFloat(value));
                       }
                   }
                   j++;
               }
               if (newItem == null) {
                   customerArray[size] = customer;
                   size++;
               } else {
                   for (int i = 0; i < size; i++) {
                       Customer custom = customerArray[i];
                       if (custom.getID() == customer.getID()) {
                           customerArray[i] = customer;
                           break;
                       }

                   }
               }
           }

       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }

   }

   @Override
   public Customer search_Customer(int ID) {
       //returns the customer object of ID
       for (Customer customer : customerArray) {
           if (customer != null && customer.getID() == ID)
               return customer;
       }
       return null;
   }

}