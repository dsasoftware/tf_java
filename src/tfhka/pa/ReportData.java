package tfhka.pa;
import java.util.Date;
import java.util.GregorianCalendar; 
import java.lang.*;
/** 
* Representa una estructura para almacenar los datos de los reportes X y Z
*/ 
public class ReportData {
        private int numberOfLastZReport;
        private Date ZReportDate;
        private int numberOfLastInvoice;
        private Date lastInvoiceDate; //(includes the hour)
        private double freeSalesTax;
        private double generalRate1Tax;
        private double reducedRate2Tax;
        private double additionalRate3Tax;
        private double totalVenta;  
        private double totalVentaDevolution;
        private double totalVentaDebitNote;      
        private int numberOfLastCreditNote;
        private int numberOfLastDebitNote;     
        private int numberOfLastDNF;       
    /** Creates a new instance of ReportX 
     *@param trama cadena de caracteres que contiene la data de reportes
     */
	public ReportData(String trama) {
		if (trama != null) {
			if (trama.length() >= 126) {

				this.setNumberOfLastZReport(Integer.parseInt(trama.substring(0,
						4)));
				GregorianCalendar cal = new GregorianCalendar();
				cal.set(Integer.parseInt(trama.substring(5, 7)) + 2000,
						Integer.parseInt(trama.substring(7, 9)) - 1,
						Integer.parseInt(trama.substring(9, 11)),
						Integer.parseInt(trama.substring(12, 14)),
						Integer.parseInt(trama.substring(14, 16)));
				this.setZReportDate(cal.getTime());

				this.setNumberOfLastInvoice(Integer.parseInt(trama.substring(
						84, 92)));
				cal.set(Integer.parseInt(trama.substring(103, 105)) + 2000,
						Integer.parseInt(trama.substring(105, 107)) - 1,
						Integer.parseInt(trama.substring(107, 109)),
						Integer.parseInt(trama.substring(110, 112)),
						Integer.parseInt(trama.substring(112, 114)));
				this.setLastInvoiceDate(cal.getTime());
     
       
         // Innovice
                    double valor = Double.parseDouble(trama.substring(17, 25)) + Double.parseDouble(trama.substring(25, 27)) / 100;
                    this.freeSalesTax = valor;                  
                    valor = Double.parseDouble(trama.substring(28, 34)) + Double.parseDouble(trama.substring(34, 36)) / 100;
                    this.generalRate1Tax = valor;                  
                    valor = Double.parseDouble(trama.substring(38, 46)) + Double.parseDouble(trama.substring(46, 48)) / 100;
                    this.reducedRate2Tax = valor;                
                    valor = Double.parseDouble(trama.substring(50, 58)) + Double.parseDouble(trama.substring(58, 60)) / 100;
                    this.additionalRate3Tax = valor;
                   //Total Venta
                    valor = Double.parseDouble(trama.substring(62, 70)) + Double.parseDouble(trama.substring(70, 72)) / 100;
                    this.totalVenta = valor;                
                    // Total Devolucion
                    valor = Double.parseDouble(trama.substring(74, 82)) + Double.parseDouble(trama.substring(82, 84)) / 100;
                    this.totalVentaDevolution = valor;                  
                   //Total Nota Debito
                    valor = Double.parseDouble(trama.substring(86, 94)) + Double.parseDouble(trama.substring(94, 96)) / 100;
                    this.totalVentaDebitNote = valor;
                
                    this.numberOfLastCreditNote = Integer.parseInt(trama.substring(116, 123));
                    this.numberOfLastDebitNote = Integer.parseInt(trama.substring(125, 132));
                    this.numberOfLastDNF = Integer.parseInt(trama.substring(133, 141));
          }
        }
    }
     /**
      * Retorna el n�mero del ultimo reporte Z efectuado.
      */
    public int getNumberOfLastZReport() {
        return numberOfLastZReport;
    }

    private void setNumberOfLastZReport(int numberOfLastZReport) {
        this.numberOfLastZReport = numberOfLastZReport;
    }
     /**
      * Retorna la fecha  del ultimo reporte Z efectuado.
      */
    public Date getZReportDate() {
        return ZReportDate;
    }

    private void setZReportDate(Date ZReportDate) {
        this.ZReportDate = ZReportDate;
    }
     /**
      * Retorna el n�mero de la ultima factura emitida.
      */
    public int getNumberOfLastInvoice() {
        return numberOfLastInvoice;
    }

    private void setNumberOfLastInvoice(int numberOfLastInvoice) {
        this.numberOfLastInvoice = numberOfLastInvoice;
    }
    /**
      * Retorna la fecha y la hora de la ultima factura emitida.
      */
    public Date getLastInvoiceDate() {
        return lastInvoiceDate;
    }

    private void setLastInvoiceDate(Date lastInvoiceDate) {
        this.lastInvoiceDate = lastInvoiceDate;
    }
    /**
      * Retorna el monto total Exento almacenado.
      */
    public double getFreeSalesTax() {
        return freeSalesTax;
    }
        
     /**
      * Retorna el monto total de IVA General � Tasa(1) almacenado.
      */
    public double getGeneralRate1Tax() {
        return generalRate1Tax;
    }
     /**
      * Retorna el monto total de IVA Reducido � Tasa(2) almacenado.
      */
    public double getReducedRate2Tax() {
        return reducedRate2Tax;
    }
   
    /**
      * Retorna el monto total de IVA Adicional � Tasa(3) almacenado.
      */
    public double getAdditionalRate3Tax() {
        return additionalRate3Tax;
    } 

	/**
	 * Retorna el monto total neto de las ventas almacenado.
	 **/
	public double getTotalVenta() // TotalVenta
	{
		return this.totalVenta;

	}

	/**
	 * Retorna el monto total de monto en Devolución almacenado.
	 **/
	public double getTotalVentaDevolution() // TotalVentaDevolution
	{
		return this.totalVentaDevolution;

	}

	/**
	 * Retorna el monto total de monto en Nota de Débito almacenado.
	 **/
	public double getTotalVentaDebitNote() // TotalVentaDebitNote
	{
		return this.totalVentaDebitNote;

	}

	/**
	 * Retorna el n�mero de la �ltima Nota de Credito � Devoluci�n.
	 */
	public int getNumberOfLastCreditNote() {
		return numberOfLastCreditNote;
	}

	/**
	 * Retorna el n�mero de la �ltima Nota de Debito.
	 */
	public int getOfLastDebitNote() {
		return this.numberOfLastDebitNote;
	}

	/**
	 * Retorna el número del último Documento No Fiscal.
	 **/
	public int getNumberOfLastDNF() {
		return this.numberOfLastDNF;
	}
}
