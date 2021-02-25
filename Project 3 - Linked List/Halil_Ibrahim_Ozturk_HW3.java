/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halil_ıbrahim_ozturk_hw3;

/**
 *
 * @author halilibrahim
 */
public class Halil_Ibrahim_Ozturk_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        EEM480DataBase MyDataBase =new EEM480DataBase();
        Customer DummyCustomer =new Customer();
        MyDataBase.readFromFile("C:\\Mydrive\\Mydata.txt");
        Float exps = MyDataBase.getTotalTradeofCustomer(13456);
        System.out.println(MyDataBase.search_Customer(13456)+"Total Expense :"+exps);
        System.out.println(" The Total Trade : " + MyDataBase.getTotalTrade());
        MyDataBase.listItems(13456);
        Customer newc =new Customer ();
        newc=MyDataBase.getNewCustomer("Ali","Veli",4950);
        MyDataBase.addCustomer(newc);
        MyDataBase.addNewItem(4950,"Karburator","Monday",(float)145.8);
        MyDataBase.addNewItem(4950,"Laptop","Tuesday",2340);
        System.out.println("The total trade :"+ MyDataBase.getTotalTrade());
        MyDataBase.listItems(4950);
    }
    
}
