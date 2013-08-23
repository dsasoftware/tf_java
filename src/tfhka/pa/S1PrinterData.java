/*
 * S1PrinterData.java
 *
 * Created on 4 de junio de 2009, 01:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.pa;

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
private int lastNCNumber;
private int quantityOfNCToday;
private int lastNoteDebitNumber;
private int quantityOfNoteDebitToday;
private int numberNonFiscalDocuments;
private int quantityNonFiscalDocuments;
private int dailyClosureCounter;
private int auditReportsCounter;
private String RIF;
private String DV;
private String registeredMachineNumber;
private Date currentPrinterDateTime; 
    /** Creates a new instance of S1PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S1 de la impresora fiscal subidos al PC
     */
    public S1PrinterData(String trama)
    {  
        if (trama != null && trama.length() >= 128)
        { 
            this.setCashierNumber(Integer.parseInt(trama.substring(2,4)));
            double valor =  Double.parseDouble(trama.substring(4,19)) +  Double.parseDouble(trama.substring(19,21))/100;
            this.setTotalDailySales(valor);
            //Factura
            this.setLastInvoiceNumber(Integer.parseInt(trama.substring(21,29)));  
            this.setQuantityOfInvoicesToday(Integer.parseInt(trama.substring(29,34)));
            //Nota Credito
             this.setLastNCNumber(Integer.parseInt(trama.substring(34, 42)));
             this.setQuantityOfNCsToday(Integer.parseInt(trama.substring(42, 47)));
             // Nota Debito 
             this.setLastNoteDebitNumber(Integer.parseInt(trama.substring(47, 55)));
             this.setQuantityOfNoteDebitsToday(Integer.parseInt(trama.substring(55, 60)));
            //DNF
            this.setNumberNonFiscalDocuments(Integer.parseInt(trama.substring(60,68)));  
            this.setQuantityNonFiscalDocuments(Integer.parseInt(trama.substring(68,73)));  
            
            this.setDailyClosureCounter(Integer.parseInt(trama.substring(73,77)));  
            this.setAuditReportsCounter(Integer.parseInt(trama.substring(77,81)));  
            this.setRIF(trama.substring(81,101));
            this.setDV(trama.substring(101, 103));
            this.setRegisteredMachineNumber(trama.substring(103,116));   
            
            String hr = trama.substring(116,118);
            String mn = trama.substring(118,120);
            String sg = trama.substring(120,122);
            
            String dd = trama.substring(122,124);
            String mm = trama.substring(124,126);
            String aa = trama.substring(126,128);
            
         GregorianCalendar cal = new GregorianCalendar(); 
         cal.set(Integer.parseInt(aa)+2000,Integer.parseInt(mm)-1,Integer.parseInt(dd),Integer.parseInt(hr),Integer.parseInt(mn),Integer.parseInt(sg));
          
         this.setCurrentPrinterDateTime(cal.getTime());
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
        /**
        * Retorna el número de la ultima nota de débito emitida
        **/
        public int getLastNDNumber()
        {
            return lastNoteDebitNumber;
        }
        /**
        * Retorna la cantidad de notas de deditos emitidas en el día
        **/
        public int getQuantityOfNDsToday()
        {
            return quantityOfNoteDebitToday;
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
    /**Retorna el RIF de la raz�n social de fiscalizaci�n de la impresora fiscal*/
    public String getRUC() {
        return RIF;
    }
      /**
       * Retorna el DV de la razón social de fiscalización de la impresora fiscal
      **/
     public String getDV()
        {
            return DV;
        }
    /**Retorna el n�mero de serial de la impresora fiscal*/
    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }
    /**Retorna la fecha y la hora de la impresora fiscal*/
    public Date getCurrentPrinterDateTime() {
        return currentPrinterDateTime;
    }

    private void setCashierNumber(int c) {
        this.cashierNumber = c;
    }

    private void setTotalDailySales(double tSales) {
        this.totalDailySales = tSales;
    }

    private void setLastInvoiceNumber(int lInvoiceNumber) {
        this.lastInvoiceNumber = lInvoiceNumber;
    }

    private void setQuantityOfInvoicesToday(int q) {
        this.quantityOfInvoicesToday = q;
    }
     private void setLastNCNumber(int lNCNumber)
        {
            this.lastNCNumber = lNCNumber;
        }

        private void setQuantityOfNCsToday(int qNCsToday)
        {
            this.quantityOfNCToday = qNCsToday;
        }

        private void setLastNoteDebitNumber(int value)
        {
            this.lastNoteDebitNumber = value;
        }

        private void setQuantityOfNoteDebitsToday(int value)
        {
            this.quantityOfNoteDebitToday = value;
        }
    private void setNumberNonFiscalDocuments(int n) {
        this.numberNonFiscalDocuments = n;
    }

    private void setQuantityNonFiscalDocuments(int q) {
        this.quantityNonFiscalDocuments = q;
    }

    private void setDailyClosureCounter(int d) {
        this.dailyClosureCounter = d;
    }

    private void setAuditReportsCounter(int audit) {
        this.auditReportsCounter = audit;
    }

    private void setRIF(String r) {
        this.RIF = r;
    }
    
     private void setDV(String dv)
        {
            this.DV = dv;
        }

    private void setRegisteredMachineNumber(String reg) {
        this.registeredMachineNumber = reg;
    }

    private void setCurrentPrinterDateTime(Date currentTime) {
        this.currentPrinterDateTime = currentTime;
    }
    
}
