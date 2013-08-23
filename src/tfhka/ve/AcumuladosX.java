/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka.ve;

/** 
* Representa una estructura para almacenar los datos de los reportes X acumulados en las diferentes bases y tasas
*/ 
public class AcumuladosX {
    
    /*
     * Variables Globales
     */

    private double freeTax; 
    private double generalRate1;
    private double generalRate1Tax;
    private double reducedRate2;
    private double reducedRate2Tax;
    private double additionalRate3;
    private double additionalRate3Tax;
  
   /*
    *Constructor
    */
    public AcumuladosX(String trama)
    {
      if (trama != null)
      {
        if (trama.length() == 119) // DT230
        {

          double valor = Double.parseDouble(trama.substring(1, 15)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(15, 17)) / 100;
          else
            valor += Double.parseDouble(trama.substring(15, 17)) / 100;
          this.freeTax = valor;

          valor = Double.parseDouble(trama.substring(18, 32)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(32, 34)) / 100;
          else
            valor += Double.parseDouble(trama.substring(32, 34)) / 100;
          this.generalRate1 = valor;

          valor = Double.parseDouble(trama.substring(35, 49)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(49, 51)) / 100;
          else
            valor += Double.parseDouble(trama.substring(49, 51)) / 100;
          this.reducedRate2 = valor;

          valor = Double.parseDouble(trama.substring(52, 66)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(66, 68)) / 100;
          else
            valor += Double.parseDouble(trama.substring(66,68)) / 100;
          this.additionalRate3 = valor;

          valor = Double.parseDouble(trama.substring(69, 83)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(83, 85)) / 100;
          else
            valor += Double.parseDouble(trama.substring(83, 85)) / 100;
          this.generalRate1Tax = valor;

          valor = Double.parseDouble(trama.substring(86, 100)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(100, 102)) / 100;
          else
            valor += Double.parseDouble(trama.substring(100, 102)) / 100;
          this.reducedRate2Tax = valor;

          valor = Double.parseDouble(trama.substring(103, 117)); // para evitar errores con numeros negativos...
          if (valor < 0)
            valor -= Double.parseDouble(trama.substring(117, 119)) / 100;
          else
            valor += Double.parseDouble(trama.substring(117, 119)) / 100;
          this.additionalRate3Tax = valor;
        }
      }

    }
    
    /*
     * Propiedades
     */
    /*
    * Retorna el monto total Exento almacenado.
    */
    public double getFreeTax()
    {
        return freeTax;
    }
    /*
    * Retorna el monto total de Base Imponible General almacenado.
    */
    public double getGeneralRate1()
    {
        return generalRate1;
    }
    /*
    * Retorna el monto total de IVA General ó Tasa(1) almacenado.
    */
    public double getGeneralRate1Tax()
    {
        return generalRate1Tax;

    }
    /*
    * Retorna el monto total de Base Imponible Reducida almacenado.
    */
    public double getReducedRate2()
    {
        return reducedRate2;
    }
    /*
    * Retorna el monto total de IVA Reducido ó Tasa(2) almacenado.
    */
    public double getReducedRate2Tax()
    {
        return reducedRate2Tax;
    }
    /*
    * Retorna el monto total de Base Imponible Adicional almacenado.
    */
    public double getAdditionalRate3()
    {     
        return additionalRate3;
    }
    /*
    * Retorna el monto total de IVA Adicional ó Tasa(3) almacenado.
    */
    public double getAdditionalRate3Tax()
    {
        return additionalRate3Tax;
    }
}
