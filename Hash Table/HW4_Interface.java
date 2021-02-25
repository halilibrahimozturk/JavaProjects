/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halil_ıbrahim_ozturk_hw4;

/**
 *
 * @author halilibrahim
 */
public interface HW4_Interface {
    
  
    
Integer GetHash(String mystring);
void ReadFileandGenerateHash(String filename, int size);
void DisplayResult(String Outputfile);
void DisplayResult();
void DisplayResultOrdered(String Outputfile);
int showFrequency(String myword);
String showMaxRepeatedWord();
boolean checkWord(String myword);
float TestEfficiency();
    
    
}
