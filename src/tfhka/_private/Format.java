/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka._private;

/**
 *
 * @author pmoya
 */
public abstract class Format {
    public static final Format DOUBLE = new FormatDouble();
    protected abstract double doValueDecimal(String tramaString);
    
    public double formatValue(String value) { 
        if (value == null) {
            return 0.0;
        } else {
            return doValueDecimal(value);
        }
    }
    
    private static class FormatDouble extends Format
    {      
      protected double doValueDecimal(String tramaString) {
                    // ////////////////////////////
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
    }
}
