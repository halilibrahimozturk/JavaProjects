/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture.pkg1.fraction;

import static lecture.pkg1.fraction.Fraction.add;

/**
 *
 * @author Emin
 */
public class Lecture1Fraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Fraction f1 = new Fraction(3, 4);
      Fraction f2 = new Fraction(1, 3);
      f1.new_variable = 7;
     // f1.num = 5;
      System.out.print(f1 + " + " + f2 + " = ");
      System.out.println(add(f1, f2));
      f1.addOn(f2);
      System.out.println("Using addOn() changes f1 to " + f1);
      System.out.println("f1 = " + f1);
      System.out.println("f2 = " + add(f1,f2));

    }
    
}
