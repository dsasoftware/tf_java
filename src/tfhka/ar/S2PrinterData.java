/*
 * S2PrinterData.java
 *
 * Created on 4 de junio de 2009, 04:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.ar;

/**
 *
 * @author The Factory
 */
public class S2PrinterData {
    private double exemptSalesSubtotal;
    private double subtotalTax;
    private String dataDummy;
    private double amountPayable;
    private int typeOfDocument;
    private int quantityOfPayments;
    private double quantityOfItems;
    /** Creates a new instance of S2PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S2 de la impresora fiscal subidos al PC
     */
    
    public S2PrinterData(String trama) 
    {
       if (trama != null)
            {
                try
                {
                if (trama.length() > 63) //DT230 VE
                {
                   
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                        if (arrayParameter.length > 1)
                        {
                            this.setExemptSalesSubtotal(tfhka.Util.doValueDecimal(arrayParameter[0].substring(13)));//13
                            this.setTaxesSubtotal(tfhka.Util.doValueDecimal(arrayParameter[1]));//13
                            this.setDataDummy(arrayParameter[2]);//13
                            this.setQuantityOfItems(tfhka.Util.doValueDecimal(arrayParameter[3]));//6
                            this.setAmountPayable(Integer.parseInt(arrayParameter[4]));//13
                            this.setQuantityOfPayments(Integer.parseInt(arrayParameter[5]));//4
                            this.setTypeOfDocument(Integer.parseInt(arrayParameter[6]));//1
                        }                   
                }
                else
                {                    
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));//63 chars
                        if (arrayParameter.length > 1)
                        {
                            this.setExemptSalesSubtotal(tfhka.Util.doValueDecimal(arrayParameter[0]));//13
                            this.setTaxesSubtotal(tfhka.Util.doValueDecimal(arrayParameter[1]));//13
                            this.setDataDummy(arrayParameter[2]);//13
                            this.setQuantityOfItems(tfhka.Util.doValueDecimal(arrayParameter[3]));//6
                            this.setAmountPayable(Integer.parseInt(arrayParameter[4]));//13
                            this.setQuantityOfPayments(Integer.parseInt(arrayParameter[5]));//4
                            this.setTypeOfDocument(Integer.parseInt(arrayParameter[6]));//1
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
    /**Retorna el monto subtotal de las ventas exentas*/
    public double getExemptSalesSubtotal() {
        return exemptSalesSubtotal;
    }
    /**Retorna el monto subtotal de los IVA(s) de una transacción activa*/
    public double getTaxesSubtotal() {
        return subtotalTax;
    }
    /**Para uso futuro*/
    public String getDataDummy() {
        return dataDummy;
    }
    /**Retorna monto total por pagar en una transacción activa*/
    public double getAmountPayable() {
        return amountPayable;
    }
    /**Retorna la cantidad de pagos realizados*/
    public int getQuantityOfPayments() {
        return quantityOfPayments;
    }

  /**Retorna el tipo de documento*/
    public int getTypeOfDocument()
    {         
        return this.typeOfDocument;
    }
    /* Retorna la cantidad de articulos en transaccion */
    public double getQuantityOfItems()
    {
        return this.quantityOfItems;
    }

    private void setExemptSalesSubtotal(double subTotalBases) {
        this.exemptSalesSubtotal = subTotalBases;
    }
    
    private void setQuantityOfItems(double value)
     {
       this.quantityOfItems = value;
     }
    private void setTaxesSubtotal(double subTotalTax) {
        this.subtotalTax = subTotalTax;
    }

    private void setDataDummy(String dataDummy) {
        this.dataDummy = dataDummy;
    }
    
    private void setTypeOfDocument(int type)
    {
        this.typeOfDocument = type;
    }

    private void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }

    private void setQuantityOfPayments(int numberPaymentsMade) {
        this.quantityOfPayments = numberPaymentsMade;
    }    
}
