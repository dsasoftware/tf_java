/*
 * S1PrinterData.java
 *
 * Created on 4 de junio de 2009, 01:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.ve;

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
		private int lastCreditNoteNumber;
		private int quantityOfCreditNotesToday;
		private int lastDebitNoteNumber;
		private int quantityDebitNoteToday;
	    /** Creates a new instance of S1PrinterData
	     *@param trama Cadena de caracteres ASCII que contiene datos del S1 de la impresora fiscal subidos al PC
	     */
	    public S1PrinterData(String trama)
	    {  
	         if (trama != null)
	            {
	             try
	              {
	                if (trama.length()  < 116)
	                {           
	                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
	                        if (arrayParameter.length >= 12) // cuando menos
	                        {
	                            this.setCashierNumber(Integer.parseInt(arrayParameter[0].substring(2)));
	                            this.setTotalDailySales(Double.parseDouble(arrayParameter[1]));
	                            this.setLastInvoiceNumber(Integer.parseInt(arrayParameter[2]));
	                            this.setQuantityOfInvoicesToday(Integer.parseInt(arrayParameter[3]));
	                            this.setNumberNonFiscalDocuments(Integer.parseInt(arrayParameter[4]));
	                            this.setQuantityNonFiscalDocuments(Integer.parseInt(arrayParameter[5]));
	                            this.setDailyClosureCounter(Integer.parseInt(arrayParameter[6]));
	                            this.setAuditReportsCounter(Integer.parseInt(arrayParameter[7]));
	                            this.setRIF(arrayParameter[8]);
	                            this.setRegisteredMachineNumber(arrayParameter[9]);
	
	                            String hr = arrayParameter[10].substring(0, 2);
	                            String mn = arrayParameter[10].substring(2, 4);
	                            String sg = arrayParameter[10].substring(4, 6);
	
	                            String dd = arrayParameter[11].substring(0, 2);
	                            String mm = arrayParameter[11].substring(2, 4);
	                            String aa = arrayParameter[11].substring(4, 6);
	
	                            GregorianCalendar cal = new GregorianCalendar(); 
	                            cal.set(Integer.parseInt(aa)+2000,Integer.parseInt(mm)-1,Integer.parseInt(dd),Integer.parseInt(hr),Integer.parseInt(mn),Integer.parseInt(sg));
	
	                            this.setCurrentPrinterDateTime(cal.getTime());
	
	                            // compatible con nuevo firmware en adelante, las OKI no lo tienen
	                            if (arrayParameter.length >= 14) // compatible con nuevo firmware
	                            {
	                              this.setLastCreditNoteNumber(Integer.parseInt(arrayParameter[12]));
	                              this.setQuantityOfCreditNotesToday(Integer.parseInt(arrayParameter[13]));
	                            }
	                            else // firmware viejo...
	                            {
	                              this.setLastCreditNoteNumber(0);
	                              this.setQuantityOfCreditNotesToday(0);
	                            }
	
	                        }         
	
	                }
	                else // DT230
	                {              
	                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
	                        if (arrayParameter.length >= 16) // cuando menos para la DT
	                        {
	                            this.setCashierNumber(Integer.parseInt(arrayParameter[0].substring(2)));
	                            this.setTotalDailySales(Double.parseDouble(arrayParameter[1]));
	                            this.setLastInvoiceNumber(Integer.parseInt(arrayParameter[2]));
	                            this.setQuantityOfInvoicesToday(Integer.parseInt(arrayParameter[3]));
	                            this.setLastDebitNoteNumber(Integer.parseInt(arrayParameter[4]));
	                            this.setQuantityDebitNoteToday(Integer.parseInt(arrayParameter[5]));
	                            this.setLastCreditNoteNumber(Integer.parseInt(arrayParameter[6]));
	                            this.setQuantityOfCreditNotesToday(Integer.parseInt(arrayParameter[7]));
	                            this.setNumberNonFiscalDocuments(Integer.parseInt(arrayParameter[8]));
	                            this.setQuantityNonFiscalDocuments(Integer.parseInt(arrayParameter[9]));
	                            this.setAuditReportsCounter(Integer.parseInt(arrayParameter[10]));
	                            this.setDailyClosureCounter(Integer.parseInt(arrayParameter[11]));
	                            this.setRIF(arrayParameter[12]);
	                            this.setRegisteredMachineNumber(arrayParameter[13]);
	
	                            String hr = arrayParameter[14].substring(0,2);
	                            String mn = arrayParameter[14].substring(2,4);
	                            String sg = arrayParameter[14].substring(4,6);
	
	                            String dd = arrayParameter[15].substring(0,2);
	                            String mm = arrayParameter[15].substring(2,4);
	                            String aa = arrayParameter[15].substring(4,6);
	
	                            GregorianCalendar cal = new GregorianCalendar(); 
	                            cal.set(Integer.parseInt(aa)+2000,Integer.parseInt(mm)-1,Integer.parseInt(dd),Integer.parseInt(hr),Integer.parseInt(mn),Integer.parseInt(sg));
	
	                            this.setCurrentPrinterDateTime(cal.getTime());
	                        }
	
	                 }
	                }catch(ArrayIndexOutOfBoundsException are)
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
     /**Retorna el número del cajero activo*/
    public int getCashierNumber() {
        return cashierNumber;
    }
     /**Retorna el monto total de las ventas diaria*/
    public double getTotalDailySales() {
        return totalDailySales;
    }
     /**Retorna el número de la ultima factura emitida*/
    public int getLastInvoiceNumber() {
        return lastInvoiceNumber;
    }
     /**Retorna la cantidad de facturas emitidas en el día*/
    public int getQuantityOfInvoicesToday() {
        return quantityOfInvoicesToday;
    }
     /**Retorna el número del último documento no fiscal emitido*/
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
     /**Retorna el numero de contador de reporte de auditoría*/
    public int getAuditReportsCounter() {
        return auditReportsCounter;
    }
     /// <summary>
    /// Retorna  el número de la última nota de debito emitida
    /// </summary>
    public int getLastDebitNoteNumber()
    {
      return lastDebitNoteNumber;
    }
    /// <summary>
    /// Retorna la cantidad de notas de crédito emitidas en el día
    /// </summary>
    public int getQuantityDebitNoteToday()
    {
      return quantityDebitNoteToday;
    }

	/**
	 * Retorna el nÃºmero de la ultima nota de credito emitida
	 **/
	public int getLastCreditNoteNumber() {
		return lastCreditNoteNumber;
	}

	/**
	 * Retorna la cantidad de notas de creditos emitidas en el dÃ­a
	 **/

	public int getQuantityOfCreditNotesToday() {
		return quantityOfCreditNotesToday;
	}

	public void setLastCreditNoteNumber(int lastCreditNoteNumber) {
		this.lastCreditNoteNumber = lastCreditNoteNumber;
	}
	public void setQuantityOfCreditNotesToday(int quantityOfCreditNotesToday) {
		this.quantityOfCreditNotesToday = quantityOfCreditNotesToday;
	}
	/**Retorna el RIF de la razón social de fiscalización de la impresora fiscal*/
    public String getRIF() {
        return RIF;
    }
    /**Retorna el número de serial de la impresora fiscal*/
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

	private void setLastDebitNoteNumber(int lastDebitNoteNumber) {
		this.lastDebitNoteNumber = lastDebitNoteNumber;
	}

	private void setQuantityDebitNoteToday(int quantityDebitNoteToday) {
		this.quantityDebitNoteToday = quantityDebitNoteToday;
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
