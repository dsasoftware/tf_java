/*
 * S1PrinterData.java
 *
 * Created on 4 de junio de 2009, 01:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author The Factory
 */
public class S1PrinterData {
    
private int cashierNumber;
private double totalDailySales;
private int lastInvoiceNumber;
private int quantityOfInvoicesToday;
private int numberNonFiscalDocuments;
private int quantityNonFiscalDocuments;
private int dailyClosureCounter;
private int auditReportsCounter;
private String RIF;
private String registeredMachineNumber;
private Date currentPrinterDateTime; 
private int lastNCNumber;
private int quantityOfNCToday;
    /** Creates a new instance of S1PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S1 de la impresora fiscal subidos al PC
     */
    public S1PrinterData(String trama)
    {  
        if (trama != null && trama.length() >= 88)
        { 
            this.setCashierNumber(Integer.parseInt(trama.substring(2,4)));
            //double valor =  Double.parseDouble(trama.substring(4,19)) +  Double.parseDouble(trama.substring(19,21))/100;
            double valor = Double.parseDouble(trama.substring(4,19)); // para evitar errores con numeros negativos...
               if (valor < 0) valor -= Double.parseDouble(trama.substring(19, 21)) / 100; else valor += Double.parseDouble(trama.substring(19, 21)) / 100;
            this.setTotalDailySales(valor);
            this.setLastInvoiceNumber(Integer.parseInt(trama.substring(21,29)));  
            this.setQuantityOfInvoicesToday(Integer.parseInt(trama.substring(29,34)));  
            this.setNumberNonFiscalDocuments(Integer.parseInt(trama.substring(34,42)));  
            this.setQuantityNonFiscalDocuments(Integer.parseInt(trama.substring(42,47)));  
            this.setDailyClosureCounter(Integer.parseInt(trama.substring(47,51)));  
            this.setAuditReportsCounter(Integer.parseInt(trama.substring(51,55)));  
            this.setRIF(trama.substring(55,66));
            this.setRegisteredMachineNumber(trama.substring(66,76));   
            
            String hr = trama.substring(76,78);
            String mn = trama.substring(78,80);
            String sg = trama.substring(80,82);
            
            String dd = trama.substring(82,84);
            String mm = trama.substring(84,86);
            String aa = trama.substring(86,88);
            
         GregorianCalendar cal = new GregorianCalendar(); 
         cal.set(Integer.parseInt(aa)+2000,Integer.parseInt(mm)-1,Integer.parseInt(dd),Integer.parseInt(hr),Integer.parseInt(mn),Integer.parseInt(sg));
          
         this.setCurrentPrinterDateTime(cal.getTime());
         if(trama.length() > 88)
         {
         this.setLastNCNumber(Integer.parseInt(trama.substring(88,96)));  
         this.setQuantityOfNCsToday(Integer.parseInt(trama.substring(96,101))); 
         }
        }
    }
     /**Retorna el n�mero del cajero activo*/
    public int getCashierNumber() {
        return cashierNumber;
    }
     /**Retorna el monto total de las ventas diaria*/
    public double getTotalDailySales() {
        return totalDailySales;
    }
     /**Retorna el n�mero de la ultima factura emitida*/
    public int getLastInvoiceNumber() {
        return lastInvoiceNumber;
    }
     /**Retorna la cantidad de facturas emitidas en el d�a*/
    public int getQuantityOfInvoicesToday() {
        return quantityOfInvoicesToday;
    }
     /**Retorna el n�mero del �ltimo documento no fiscal emitido*/
    public int getNumberNonFiscalDocuments() {
        return numberNonFiscalDocuments;
    }
     /**Retorna la cantidad de documentos no fiscales*/
    public int getQuantityNonFiscalDocuments() {
        return quantityNonFiscalDocuments;
    }
     /**Retorna el numero de contador de cierre diario*/
    public int getDailyClosureCounter() {
        return dailyClosureCounter;
    }
     /**Retorna el numero de contador de reporte de auditor�a*/
    public int getAuditReportsCounter() {
        return auditReportsCounter;
    }
     /**
        * Retorna el número de la ultima nota de credito emitida
        **/
        public int getLastNCNumber()
        {
            return lastNCNumber;
        }
        /**
        * Retorna la cantidad de notas de creditos emitidas en el día
        **/
        public int getQuantityOfNCsToday()
        {
            return quantityOfNCToday;
        }
        private void setLastNCNumber(int lNCNumber)
        {
            this.lastNCNumber = lNCNumber;
        }

        private void setQuantityOfNCsToday(int qNCsToday)
        {
            this.quantityOfNCToday = qNCsToday;
        }
    /**Retorna el RIF de la raz�n social de fiscalizaci�n de la impresora fiscal*/
    public String getRIF() {
        return RIF;
    }
    /**Retorna el n�mero de serial de la impresora fiscal*/
    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }
    /**Retorna la fecha y la hora de la impresora fiscal*/
    public Date getCurrentPrinterDateTime() {
        return currentPrinterDateTime;
    }

    private void setCashierNumber(int cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    private void setTotalDailySales(double totalDailySales) {
        this.totalDailySales = totalDailySales;
    }

    private void setLastInvoiceNumber(int lastInvoiceNumber) {
        this.lastInvoiceNumber = lastInvoiceNumber;
    }

    private void setQuantityOfInvoicesToday(int quantityOfInvoicesToday) {
        this.quantityOfInvoicesToday = quantityOfInvoicesToday;
    }

    private void setNumberNonFiscalDocuments(int numberNonFiscalDocuments) {
        this.numberNonFiscalDocuments = numberNonFiscalDocuments;
    }

    private void setQuantityNonFiscalDocuments(int quantityNonFiscalDocuments) {
        this.quantityNonFiscalDocuments = quantityNonFiscalDocuments;
    }

    private void setDailyClosureCounter(int dailyClosureCounter) {
        this.dailyClosureCounter = dailyClosureCounter;
    }

    private void setAuditReportsCounter(int auditReportsCounter) {
        this.auditReportsCounter = auditReportsCounter;
    }

    private void setRIF(String RIF) {
        this.RIF = RIF;
    }

    private void setRegisteredMachineNumber(String registeredMachineNumber) {
        this.registeredMachineNumber = registeredMachineNumber;
    }

    private void setCurrentPrinterDateTime(Date currentPrinterDateTime) {
        this.currentPrinterDateTime = currentPrinterDateTime;
    }
    
}
