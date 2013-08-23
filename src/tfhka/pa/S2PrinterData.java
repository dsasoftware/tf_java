/*
 * S2PrinterData.java
 *
 * Created on 4 de junio de 2009, 04:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.pa;

/**
 *
 * @author The Factory
 */
public class S2PrinterData {
    private double subTotalBases;
    private double sudTotalTax;
    private String dataDummy;
    private double amountPayable;
    private int numberPaymentsMade;
    private int condition;
    /** Creates a new instance of S2PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S2 de la impresora fiscal subidos al PC
     */
    public S2PrinterData(String trama) 
    {
        if (trama != null && trama.length() == 69)
        {   
            double valor =  Double.parseDouble(trama.substring(3,14)) +  Double.parseDouble(trama.substring(14,16))/100;
            this.setSubTotalBases(valor);
            valor = Double.parseDouble(trama.substring(17,28)) +  Double.parseDouble(trama.substring(28,30))/100;
            this.setSudTotalTax(valor);
            this.setDataDummy(trama.substring(31,50));
            valor = Double.parseDouble(trama.substring(51,62)) +  Double.parseDouble(trama.substring(62,64))/100;
            this.setAmountPayable(valor);
            this.setNumberPaymentsMade(Integer.parseInt(trama.substring(64,68)));
            this.setCondition(Integer.parseInt(trama.substring(68,69)));
        }
    }
    /**Retorna el monto subtotal de las bases imponibles y exento de una transacción activa*/
    public double getSubTotalBases() {
        return subTotalBases;
    }
    /**Retorna el monto total de los IVA(s) de una transacción activa*/
    public double getSudTotalTax() {
        return sudTotalTax;
    }
    /**Retorna una data de relleno y el nuero de items de una transacción cuando esta activada esta modalidad*/
    public String getDataDummy() {
        return dataDummy;
    }
    /**Retorna monto total por pagar en una transacción activa*/
    public double getAmountPayable() {
        return amountPayable;
    }
    /**Retorna la cantidad de pagos realizados*/
    public int getNumberPaymentsMade() {
        return numberPaymentsMade;
    }
    /**Retorna la condición de la transacción*/
    public int getCondition() {
        return condition;
    }

    private void setSubTotalBases(double subTotalBases) {
        this.subTotalBases = subTotalBases;
    }

    private void setSudTotalTax(double sudTotalTax) {
        this.sudTotalTax = sudTotalTax;
    }

    private void setDataDummy(String dataDummy) {
        this.dataDummy = dataDummy;
    }

    private void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }

    private void setNumberPaymentsMade(int numberPaymentsMade) {
        this.numberPaymentsMade = numberPaymentsMade;
    }

    private void setCondition(int condition) {
        this.condition = condition;
    }
    
}
