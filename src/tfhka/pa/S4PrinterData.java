/*
 * S4PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.pa;

/**
 *
 * @author The Factory
 */
public class S4PrinterData {
    private double[] accumulatedMountsAllMeansOfPayment;
    /** Creates a new instance of S4PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S4 de la impresora fiscal subidos al PC
     */
	public S4PrinterData(String trama) {
		if (trama != null && trama.length() >= 162) {
           this.accumulatedMountsAllMeansOfPayment = new double[16];
           int ite = 0;
           int i = 2, j = 10, k = 12;
           double valor = 0.00;
			while (ite < 16) {
	              valor = Double.parseDouble(trama.substring(i,j)) + Double.parseDouble(trama.substring(j,k))/100;
	              this.accumulatedMountsAllMeansOfPayment[ite] = valor;
	              i = k;
	              j = i + 8;
	              k = j + 2;
           ++ite;
           }
           
           this.setAccumulatedMountsAllMeansOfPayment(accumulatedMountsAllMeansOfPayment);
       }
    }
     /**Retorna una lista de los montos acumulados de los 16 medios de pagos*/
	public double[] getAccumulatedMountsAllMeansOfPayment() {
		return accumulatedMountsAllMeansOfPayment;
	}
	public void setAccumulatedMountsAllMeansOfPayment(
			double[] accumulatedMountsAllMeansOfPayment) {
		this.accumulatedMountsAllMeansOfPayment = accumulatedMountsAllMeansOfPayment;
	}

    
}
