/*
 * S4PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka;

/**
 *
 * @author The Factory
 */
public class S4PrinterData {
    private double[] listCumulaMountsMeansPayments;
    /** Creates a new instance of S4PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S4 de la impresora fiscal subidos al PC
     */
    public S4PrinterData(String trama)
    {
       if (trama != null && trama.length() ==162)
       {
           this.listCumulaMountsMeansPayments = new double[16];
           int ite = 0;
           int i = 2, j = 10, k = 12;
           double valor = 0.00;
           while (ite <16)
           {
              //valor = Double.parseDouble(trama.substring(i,j)) + Double.parseDouble(trama.substring(j,k))/100;
               valor = Double.parseDouble(trama.substring(i,j)); // para evitar errores con numeros negativos...
              if (valor < 0)
                  valor -= Double.parseDouble(trama.substring(j,k))/100;
              else
                  valor += Double.parseDouble(trama.substring(j,k))/100;
              this.listCumulaMountsMeansPayments[ite] = valor;
              i = k;
              j = i + 8;
              k = j + 2;
           ++ite;
           }
           
           this.setListCumulaMountsMeansPayments(listCumulaMountsMeansPayments);
           
       } else if (trama != null && trama.length() == 314) // DT230
           {
             this.listCumulaMountsMeansPayments = new double[24];
             int ite = 0;
             int i = 2, j = 10,  k = 12;
             double valor = 0.00;
             while (ite < 24)
             {
               valor = Double.parseDouble(trama.substring(i, j)); // para ver la operación en dos pasos...

               if (valor < 0)
               {
                 valor -= Double.parseDouble(trama.substring(j, k)) / 100;
               }
               else
               {
                 valor += Double.parseDouble(trama.substring(j, k)) / 100;
               }

               this.listCumulaMountsMeansPayments[ite] = valor;
                 i = k;
                 j = i + 8;
                 k = j + 2;

               ++ite;
             }
               this.setListCumulaMountsMeansPayments(listCumulaMountsMeansPayments);
       }
    }
     /**Retorna una lista de los montos acumulados de los 16 medios de pagos*/
    public double[] getListCumulaMountsMeansPayments() {
        return listCumulaMountsMeansPayments;
    }

    private void setListCumulaMountsMeansPayments(double[] listCumulaMountsMeansPayments) {
        this.listCumulaMountsMeansPayments = listCumulaMountsMeansPayments;
    }
    
}
