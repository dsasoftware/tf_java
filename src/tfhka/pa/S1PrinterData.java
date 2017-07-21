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
private int lastCNNumber;
private int quantityOfCNToday;
private int lastDebitNoteNumber;
private int quantityOfDebitNoteToday;
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
            this.setLastInvoiceNumber(Integer.parseInt(trama.substring(23,31)));//21-29
            this.setQuantityOfInvoicesToday(Integer.parseInt(trama.substring(33,37)));
            //Nota Credito
             this.setLastCNNumber(Integer.parseInt(trama.substring(39, 46)));//34-42
             this.setQuantityOfCNsToday(Integer.parseInt(trama.substring(48, 52)));//42-47
             // Nota Debito 
             this.setLastDebitNoteNumber(Integer.parseInt(trama.substring(54, 61)));//47-55
             this.setQuantityOfDebitNotesToday(Integer.parseInt(trama.substring(63, 67)));//55-60
            //DNF
            this.setNumberNonFiscalDocuments(Integer.parseInt(trama.substring(69,76)));//60-68  
            this.setQuantityNonFiscalDocuments(Integer.parseInt(trama.substring(78,82)));//68-73  
            
            this.setDailyClosureCounter(Integer.parseInt(trama.substring(83,87)));//73-77  
            this.setAuditReportsCounter(Integer.parseInt(trama.substring(88,92)));//77-81  
            this.setRIF(trama.substring(94,113));//81-101
            this.setDV(trama.substring(114, 116));//101-103
            this.setRegisteredMachineNumber(trama.substring(117,120));//103-116   
            
            String hr = trama.substring(131,133);//116-118
            String mn = trama.substring(134,136);//118-120
            String sg = trama.substring(136,137);//120-122
            
            String dd = trama.substring(138,140);//122-124
            String mm = trama.substring(140,142);//124-126
            String aa = trama.substring(142,144);//126-128
            
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
	public int getLastCNNumber() {
		return lastCNNumber;
	}

	/**
	 * Retorna la cantidad de notas de creditos emitidas en el día
	 **/
	public int getQuantityOfCNsToday() {
		return quantityOfCNToday;
	}

	/**
	 * Retorna el número de la ultima nota de débito emitida
	 **/
	public int getLastNDNumber() {
		return lastDebitNoteNumber;
	}

	/**
	 * Retorna la cantidad de notas de deditos emitidas en el día
	 **/
	public int getQuantityOfNDsToday() {
		return quantityOfDebitNoteToday;
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
	public String getDV() {
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

	private void setLastCNNumber(int lCNNumber) {
		this.lastCNNumber = lCNNumber;
	}

	private void setQuantityOfCNsToday(int qCNsToday) {
		this.quantityOfCNToday = qCNsToday;
	}

	private void setLastDebitNoteNumber(int value) {
		this.lastDebitNoteNumber = value;
	}

	private void setQuantityOfDebitNotesToday(int value) {
		this.quantityOfDebitNoteToday = value;
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
    
	private void setDV(String dv) {
		this.DV = dv;
	}

    private void setRegisteredMachineNumber(String reg) {
        this.registeredMachineNumber = reg;
    }

    private void setCurrentPrinterDateTime(Date currentTime) {
        this.currentPrinterDateTime = currentTime;
    }
    
}
