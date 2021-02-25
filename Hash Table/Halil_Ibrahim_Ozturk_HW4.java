/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halil_ıbrahim_ozturk_hw4;

import java.awt.Desktop;//for open the file 
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;//to show message dialog


/**
 *
 * @author halilibrahim
 */
public class Halil_Ibrahim_Ozturk_HW4 implements HW4_Interface {

    String [] hashArray;
    
    int arraySize;
    int size =0; //counter for number of elements in hash table
    
    
    int collusion =0;       //number of cullusion occur when creating hash structure
    int hashFunc1;      //double hash functions
    int hashFunc2 ;    
    
    int sameword; //if there is a same word when it place on index number then frequency of word increase 
        
    public static void main(String[] args) {
        // TODO code application logic here
       Halil_Ibrahim_Ozturk_HW4 table = new Halil_Ibrahim_Ozturk_HW4(); //create a new object of hash table of Halil_Ibrahim_Ozturk_HW4 class

       table.ReadFileandGenerateHash("file.txt",5000); //Create the
//open address hash structure with the size given by the user. The file which
//contains a very long text will be parsed and during the parsing hash table must
//be modified by the words.


            table.DisplayResult("wordlist.txt");// All the words in the text and
//their frequency has to be displayed in a text file.
            
            
            table.DisplayResult();// All the words in the text and their frequency
//has to be displayed on the screen.



           table.DisplayResultOrdered("orderedwordlist.txt");// All the words and in the
//text and their frequency has to be displayed in a text file in an ordered
//fashion. The most repeated words will be listed at the beginning and the least
//repeated words at the end


          System.out.println(table.showMaxRepeatedWord());// The most repeated word has to be
//returned.

              System.out.println("The status of the word you searched for is found in the text : ("+table.checkWord("the")+")");
              // Checks whether myword is found in the text.
              
              
            System.out.println("The frequency of the word you questioned : ("+table.showFrequency("as") + ") (If it is -1 , there is no word you questioned.) ");
//            The frequency of myword in the text
//file will be given. If there is no myword in the text -1 must be returned.
            
            
          System.out.println("There are " + table.TestEfficiency() +" collusion occured.");  
// Returns the number of collusions during parsing the file.
    }   
     
    @Override
    public Integer GetHash(String mystring) {
        
        // generate an integer value (hash
//index) related to the input word. If collusion occurs the collusion has
//to be solved by double hash method.
        
//Double hashing used with open-addressing in hash tables to resolve hash collisions


        sameword=0;
        
            //return preferred index posiition
            
            
               int hashVal=mystring.hashCode();// sum of ascii codes of word
        
        hashVal=   hashVal % arraySize;     //hash function 1
        if(hashVal<0){
            
            
            hashVal +=arraySize;
            
        }
        hashFunc1=hashVal;
        // first index position means no collusion
        
        
        
        
        
        
        hashVal =mystring.hashCode();
        hashVal =hashVal %arraySize;
        
        if(hashVal<0){
            
            
            hashVal += arraySize;
            
            
        }
        
        
        
        boolean isPrime=false;
        int primeNumber;
        //for loop determine prime number less than array size 
        for(int i=arraySize-1;true;i--){
            
             for( int j=2;j*j<=i;j++){
            
            if(i %j==0){
                
                isPrime=false;
                                break;

            }else{
                                        isPrime=true;

                
            }
            
            
            
            
        }
            
            
            
            if(isPrime){
                
                
                
                
                primeNumber=i;
                
                
                
                
                      break;
            }
        }
        
        
        
        
        
        
        //using prime number less than array size
                hashFunc2= primeNumber - hashVal % primeNumber;     //hash function 2  = double hashing

                
                
                
                  hashVal = hashFunc1;
        
        int stepSize = hashFunc2 ;  //double hash occur when every on full index number  (not null)
        
        
        StringBuffer sb = new StringBuffer();
        
        
        while (hashArray[hashVal]!=null){
            
            
            // determine words and their frequency on the hash table
            
           String word = hashArray[hashVal];
           String number =hashArray[hashVal];
           number= number.split(" ")[1]; 
           int frequency = Integer.parseInt(number);
           
           
           
           word=word.split(" ")[0];


            if(word.equals(mystring)){ // if words equals each other then just frequency increase 
                       // System.out.println("="+word+"="+mystring+"="+"++++++++++++++++++"+frequency);
                        
                        frequency++;
                        hashArray[hashVal]=word+" "+frequency;
                       // System.out.println(hashArray[hashVal]);
                        sameword=1; 

                break;

                
            }else
            
            
             collusion ++;
            
            
            // double hashing algorithm 
            
            
            hashVal = hashVal + stepSize;
            hashVal =hashVal % arraySize;
            
            
            
            
            
        }
        
        
        return hashVal; 
        
        
    }

    @Override
    public void ReadFileandGenerateHash(String filename, int size) {
        
        // Create the
//open address hash structure with the size given by the user. The file which
//contains a very long text will be parsed and during the parsing hash table modified by the words.
        
        
        
        arraySize =size;
        //Get text from txt file 
        String data = ""; 
        try { 
            data = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException ex) {
            Logger.getLogger(Halil_Ibrahim_Ozturk_HW4.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        //delete punctutaions 
        data = data. replaceAll (", $", "");
            
        
        
         System.out.println(data); 
         
         

        //delete some punctutations and usused spaces 
   
       data = data.replace("--","");
       data = data.replace("  "," ");
       
                //split data into word 

       String[] splitted = data.replaceAll("[,.?:;]", "").replace("--", "").replace("\r\n", " ").split(" "); 

    for ( String ss : splitted) {
        
       
        //System.out.println(ss);

    }
         
         
     // Creating object of the
        // class linked list
        LinkedList<String> wordlist = new LinkedList<String>();
        LinkedList<String> hashindexlist = new LinkedList<String>();

        // Adding elements to the linked list
    
        for ( String ss : splitted) {
        
           wordlist.add(ss);

                      

                  
    }
        
        
                 //Halil_Ibrahim_Ozturk_HW4 table = new Halil_Ibrahim_Ozturk_HW4 ();

                    
                    
        //System.out.println(wordlist);
        //get sum of ascii codes and generate hash indexes for all words
        
        int hashindex ;
        
      for(String wl : wordlist){
            
            
            System.out.println(" + " + wl +" - ");
            
            
            

    
     
            
            
        }
        

         

        
        
        //creating hash structure
            
          
       
        
        
        //determine size is prime or not ? because for performing high quality hash structure it must be prime number
         boolean isPrime=true;
                    int getNextPrime;
               
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    //for loop determine state of prime
                    
                    
                    
        for(int i=2;i*i<=arraySize;i++){
            
            if(arraySize %i==0){
                
                isPrime=false;
                break;
            }else{
                                        isPrime=true;

                
            }
            
            
            
            
        }
        
        
        
         if (isPrime){
            
            
            hashArray=new String[arraySize];
            
            
            
        }else{
             
             // if it is not prime determine next prime greater than array size 
             
             
             
             for(int i=arraySize;true;i++){
            
             for( int j=2;j*j<=i;j++){
            
            if(i %j==0){
                
                isPrime=false;
                                break;

            }else{
                                        isPrime=true;

                
            }
            
            
            
            
        }
            
            
            
            if(isPrime){
                
                
                
                
                getNextPrime=i;
                
                // new array size 
                
                 hashArray=new String[getNextPrime];
                      arraySize=getNextPrime;
                System.out.println("Hash table size given "+ size+ "is not a prime ");
                      
                      System.out.println("Hash table size changed to "+ getNextPrime);
                      break;
            }
        }
             
             
            
         
                      
                      

                      
       }
        
        
        
        
        
        
        
        
         
          for(String wl : wordlist){
            
            int key =GetHash(wl); // determine key of word which adress of hash table means index number 
            
            // key consist of hash functions which made of sum of ascii codes and their modulo
            // if index number is null key made of hash function1  but it is full then hash func1 and hash func2 is both used with double hash method 
            
        
        if(sameword==0){
            // determine frequency of word
            
            hashArray[key]= wl + " 1 "  ;// put words on the hash table with initialize first word with frequency of 1 
        
        System.out.println("inserted word :" + wl);
        
        size++; //full of budget hash table size 
        }else{
            sameword=0;
            
                    System.out.println("same word :" + wl ); // do not put word on hash table because already exist and just increase frequency of word

            
        }
        
    
     
            
            
        }
        
        
        
        
        // print of all of hash table with full and empty budgets and their contents 
        
        System.out.println("Table: ");    
           for(int i=0 ; i<arraySize; i++ ){                 
               if(hashArray[i]!=null){                 // if it is null put words       
                   System.out.println(hashArray[i] + " ");       // word on the budgets of hash table  
               }else{          
                  System.out.print("** ");     //null budgets                   
               }
               System.out.println("");        
        }  
        
        
        
        
        
        
        
        
        

        
        
        
        
        

        
        
       
         
         
    }   
          
    @Override
    public void DisplayResult(String Outputfile) {
        // All the words in the text and
//their frequency has to be displayed in a text file.
        
        try {
      FileWriter myWriter = new FileWriter(Outputfile);//create txt file 
      
     // System.out.println("Table: ");    
             int b=0;//for newline on the 10th  lines
           myWriter.write("All the words in the text and their frequencies are as follows:\r\n");

           for(int i=0 ; i<arraySize; i++ ){  
               
               if(hashArray[i]!=null){      
                   
                   b=b+1;
      myWriter.write( " / "+hashArray[i] );
             if(b%9==0){
                myWriter.write("\r\n");

          
      }
      
               }else{          
               }
               
               
               
               
               
               
        }  
      
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

            try  
            {  
            //constructor of file class having file as argument  
            File file = new File(Outputfile);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
            System.out.println("not supported");  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         //checks file exists or not  
            desktop.open(file);              //opens the specified file  
            }  
            catch(Exception e)  
            {  
            e.printStackTrace();  
            }  

    }

    @Override
    public void DisplayResult() {
        
// All the words in the text and their frequency
//has to be displayed on the screen.
        
         int b=0;//for newline on the 10th  lines
 

        
        String message = "All the words in the text and their frequencies are as follows:\r\n";
        for(int i=0 ; i<arraySize; i++ ){                 
               if(hashArray[i]!=null){           
                   message = message + "/" +hashArray[i];
                   b++;
                   
                   if(b%9==0){
                       
                       message= message + "\r\n";
                       
                   }
               }else{          
               }
        }  
        
        
        
    JOptionPane.showMessageDialog(null, message);//JOptionPane used to display words and frequencies on hash table on the screen
        
    }

    @Override
    public void DisplayResultOrdered(String Outputfile) {
        
        // All the words and in the
//text and their frequency has to be displayed in a text file in an ordered
//fashion. The most repeated words will be listed at the beginning and the least
//repeated words at the end
                LinkedList<String> list = new LinkedList<String>();
               
                   // ArrayList<Integer> frequencylist = new ArrayList<Integer>();
    //ArrayList<String> wordlist = new ArrayList<String>();
    
                    
                // determine frequencies on hash table and then descending order and print
                for(int i=0 ; i<arraySize; i++ ){                 
               if(hashArray[i]!=null){                        
                   list.add(hashArray[i]);
               }else{          
               }
               
               
               
                }
                
                
                                    int size = list.size();
                                    
                                    
                                    //seperate frequency list and word list from each other  they will be combine with same indexes in next print stage
                                    
                                                      int [] frequencylist ;
                                                      frequencylist = new int[size];
                                                      
                                                      
                                                       String [] wordlist ;
                                                      wordlist = new String[size];


                                              StringBuffer sb = new StringBuffer();
                                              
                                              

                for (int i =0; i<list.size();i++) {
        
                    
                      
           String word = list.get(i);
           String number =list.get(i);
                number= number.split(" ")[1];
            int frequency = Integer.parseInt(number);// frequencies on the hash table is String form and they converted in this line
           word=word.split(" ")[0];
            wordlist[i]=word;
            frequencylist[i]=frequency;


           

           
                  
    }
                
                                 

               
              int n = frequencylist.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (frequencylist[j] < frequencylist[j+1]) 
                { 
                    
                    //order by frequency and then words order same as frequency
                    // swap arr[j+1] and arr[j] 
                    int temp = frequencylist[j]; 
                    String wordtemp = wordlist[j]; 

                    frequencylist[j] = frequencylist[j+1]; 
                    frequencylist[j+1] = temp; 
                    
                     wordlist[j] = wordlist[j+1]; 
                    wordlist[j+1] = wordtemp; 
                    
                } 
                
                LinkedList<String> orderedlist = new LinkedList<String>();

        for(int i = 0 ; i<n;i++){
            
           // System.out.println(frequencylist[i]+ " --- "+wordlist[i]);
            

                               orderedlist.add("<--"+wordlist[i]+" ("+frequencylist[i]+")"); // combining words and their frequencies

        }
        
                  
               
               
                           //System.out.println(orderedlist);

               
               
               
           
           
               
               
               
               
               
               
               
                           
                           
                           
                           
                            try {
      FileWriter myWriter = new FileWriter(Outputfile);
      
     // System.out.println("Table: ");    
             
           myWriter.write("The words in the text are in descending order according to their frequency:\r\n");

          for ( String ol : orderedlist) {
        
       
           myWriter.write(ol+"--> \r\n");

           
         
    }
      
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
// open the txt file on desktop
            try  
            {  
            //constructor of file class having file as argument  
            File file = new File(Outputfile);   
            if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
            {  
            System.out.println("not supported");  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(file.exists())         //checks file exists or not  
            desktop.open(file);              //opens the specified file  
            }  
            catch(Exception e)  
            {  
            e.printStackTrace();  
            }  
               
               
         

    }                

    @Override
    public int showFrequency(String myword) {

//The frequency of myword in the text
//file will be given. If there is no myword in the text -1 must be returned.
            int     frequencyofword; 
            
            
            
        
        int hashVal = GetHash(myword); // determine key of word to find index number
        
                    String word=hashArray[hashVal];
                    
                    
        

            //int stepSize = hashFunc2 (myword);





            if(sameword==1){
// same methods on GetHash method and ReadAndGenerateHash method
                      word=word.split(" ")[1];


                    frequencyofword=Integer.parseInt(word);





            }else{

                    frequencyofword=-1;
        }
        
       // return hashArray[hashVal];
                return frequencyofword;

        
        
        
    }

    @Override
    public String showMaxRepeatedWord() {
//        The most repeated word has to be
//returned.
        
        LinkedList<String> list2 = new LinkedList<String>();
               
                
                    // A similar method to DisplatResultOrdered 
                    //get first word on this ordered list because it is max frequency
                
                for(int i=0 ; i<arraySize; i++ ){                 
               if(hashArray[i]!=null){                        
                   list2.add(hashArray[i]);
               }else{          
               }
               
               
               
                }
                
                
                                    int size2 = list2.size();
                                    
                                    
                                                      int [] frequencylist ;
                                                      frequencylist = new int[size2];
                                                      
                                                      
                                                       String [] wordlist ;
                                                      wordlist = new String[size2];


                                              StringBuffer sb = new StringBuffer();
                                              
                                              

                for (int i =0; i<list2.size();i++) {
        

                      
           String word = list2.get(i);
           String number =list2.get(i);
                number= number.split(" ")[1];
            int frequency = Integer.parseInt(number);
           word=word.split(" ")[0];
            wordlist[i]=word;
            frequencylist[i]=frequency;


           

           
                  
    }
                
                                 

               
              int n = frequencylist.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (frequencylist[j] < frequencylist[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = frequencylist[j]; 
                    String wordtemp = wordlist[j]; 

                    frequencylist[j] = frequencylist[j+1]; 
                    frequencylist[j+1] = temp; 
                    
                     wordlist[j] = wordlist[j+1]; 
                    wordlist[j+1] = wordtemp; 
                    
                } 
                
                LinkedList<String> orderedlist = new LinkedList<String>();

        for(int i = 0 ; i<n;i++){
            
           // System.out.println(frequencylist[i]+ " --- "+wordlist[i]);
            

                               orderedlist.add(" ' " +wordlist[i]+" ' "+" is the most repeated word in the text.");

        }  
               
              
              
           
 
               
//               String max;
//               max =orderedlist.getFirst();
//               
//                
//                max= max.split(" ")[0];
                        
                           
                           
                  return orderedlist.getFirst();//top of list with max. frequency
                            

              
               
         
    }

    @Override
    public boolean checkWord(String myword) {
// Checks whether myword is found in the text.
            boolean isfound=false;
            int hashVal = GetHash(myword);

            //int stepSize = hashFunc2 (myword);





            if(sameword==1){


                isfound=true;







            }else{

                            isfound=false;

        }
        
       // return hashArray[hashVal];
                return isfound;


    }

    @Override
    public float TestEfficiency() {
//           Returns the number of collusions during parsing the file.
        return collusion;
        // collusion already calculated on GetHash method
        
    }
       
}
