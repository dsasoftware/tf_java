/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka;

/**
 *
 * @author pmoya
 */
public class Util {
    
    public static double doValueDecimal(String tramaString)
        {
            //////////////////////////////
            int size = tramaString.length();
            int dif = size - 2;

            double valor = Double.parseDouble(tramaString.substring(0, dif));
            // para evitar errores con numeros negativos...
            if (valor < 0)
                valor -= Double.parseDouble(tramaString.substring(dif)) / 100;
            else
                valor += Double.parseDouble(tramaString.substring(dif)) / 100;

            return valor;
        }
    
      public static double doValueDecimalThree(String tramaString)
        {
            //////////////////////////////
            int size = tramaString.length();
            int dif = size - 3;

            double valor = Double.parseDouble(tramaString.substring(0, dif));
            // para evitar errores con numeros negativos...
            if (valor < 0)
                valor -= Double.parseDouble(tramaString.substring(dif)) / 1000;
            else
                valor += Double.parseDouble(tramaString.substring(dif)) / 1000;

            return valor;
        }
}
