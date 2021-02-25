/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture.pkg1.fraction;

/**
 *
 * @author Emin
 */
public class Fraction {
    private int num;
    private int den;
    public int new_variable;
    
    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }
    
    public Fraction(int n){
        this(n,1);
    }
    
    public void addOn(Fraction f) {
        num = num* f.den + den * f.num;
        den *= f.den;
    }
       
    public static Fraction add(Fraction f1, Fraction f2) {
    int n = f1.num * f2.den + f1.den * f2.num;
    int d = f1.den * f2.den;
    return new Fraction(n, d);
    }
    @Override
    public String toString() {
        return (num + "/" + den) ;
    }

    
            
}


