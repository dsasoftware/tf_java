/*
 * S2PrinterData.java
 *
 * Created on 4 de junio de 2009, 04:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.ve;

/**
 *
 * @author The Factory
 */
public class S2PrinterData {
    private double subTotalBases;
    private double subTotalTax;
    private String dataDummy;
    private double amountPayable;
    private int typeDocument;
    private int numberPaymentsMade;
    private double quantityArticles;
    private int condition;
    /** Creates a new instance of S2PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S2 de la impresora fiscal subidos al PC
     */
    
    public S2PrinterData(String trama) 
    { 
       if (trama != null)
            {
                try
                {
                if (trama.length() > 69) //DT230 VE
                {
                   
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                        if (arrayParameter.length > 1)
                        {
                            this.setSubTotalBases(tfhka.Util.doValueDecimal(arrayParameter[0].substring(2)));
                            this.setSubTotalTax(tfhka.Util.doValueDecimal(arrayParameter[1]));
                            this.setDataDummy(arrayParameter[2]);
                            this.setQuantityArticles(tfhka.Util.doValueDecimalThree(arrayParameter[3]));
                            this.setAmountPayable(tfhka.Util.doValueDecimal(arrayParameter[4]));
                            this.setNumberPaymentsMade(Integer.parseInt(arrayParameter[5]));
                            this.setTypeDocument(Integer.parseInt(arrayParameter[6]));
                        }
                   
                }
                else
                {
                    
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                        if (arrayParameter.length > 1)
                        {
                            this.setSubTotalBases(tfhka.Util.doValueDecimal(arrayParameter[0].substring(2)));
                            this.setSubTotalTax(tfhka.Util.doValueDecimal(arrayParameter[1]));
                            this.setDataDummy(arrayParameter[2]);
                            this.setAmountPayable(tfhka.Util.doValueDecimal(arrayParameter[3]));
                            this.setNumberPaymentsMade(Integer.parseInt(arrayParameter[4]));
                            this.setCondition(Integer.parseInt(arrayParameter[5]));
                        }
                   
                  }
                }
                catch(ArrayIndexOutOfBoundsException are)
                    {
                        return;
                    }catch (NumberFormatException nfexp)
                    {
                        return;
                    }catch (StringIndexOutOfBoundsException sfexp)
                    {
                        return;
                    }
            }
    }
    /**Retorna el monto subtotal de las bases imponibles y exento de una transacción activa*/
    public double getSubTotalBases() {
        return subTotalBases;
    }
    /**Retorna el monto total de los IVA(s) de una transacción activa*/
    public double getSubTotalTax() {
        return subTotalTax;
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
  /**Retorna el tipo de documento*/
    public int getTypeDocument()
    {         
        return this.typeDocument;
    }
    /* Retorna la cantidad de articulos en transaccion */
    public double getQuantityArticles()
    {
        return this.quantityArticles;
    }

    private void setSubTotalBases(double subTotalBases) {
        this.subTotalBases = subTotalBases;
    }
    
    private void setQuantityArticles(double value)
     {
       this.quantityArticles = value;
     }
    private void setSubTotalTax(double subTotalTax) {
        this.subTotalTax = subTotalTax;
    }

    private void setDataDummy(String dataDummy) {
        this.dataDummy = dataDummy;
    }
    
    private void setTypeDocument(int type)
    {
        this.typeDocument = type;
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
