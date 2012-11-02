
package tfhka;

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
private double generalRate1Sale;
private double generalRate1Tax;
private double reducedRate2Sale;
private double reducedRate2Tax;
private double additionalRate3Sal;
private double additionalRate3Tax;
private double freeTaxDevolution;
private double generalRateDevolution;
private double generalRateTaxDevolution;
private double reducedRateDevolution;
private double reducedRateTaxDevolution;
private double additionalRateDevolution;
private double additionalRateTaxDevolution;
private int numberOfLastCreditNote;
    /** Creates a new instance of ReportX 
     *@param trama cadena de caracteres que contiene la data de reportes
     */
    public ReportData(String trama)
    {
        if (trama != null)
        {
            if (trama.length() == 176)
            {

                this.setNumberOfLastZReport(Integer.parseInt(trama.substring(0, 4)));
                GregorianCalendar cal = new GregorianCalendar();
                cal.set(Integer.parseInt(trama.substring(4, 6)) + 2000, Integer.parseInt(trama.substring(6, 8)) - 1, Integer.parseInt(trama.substring(8, 10)));
                this.setZReportDate(cal.getTime());
                this.setNumberOfLastInvoice(Integer.parseInt(trama.substring(10, 18)));
                cal.set(Integer.parseInt(trama.substring(18, 20)) + 2000, Integer.parseInt(trama.substring(20, 22)) - 1, Integer.parseInt(trama.substring(22, 24)), Integer.parseInt(trama.substring(24, 26)), Integer.parseInt(trama.substring(26, 28)));
                this.setLastInvoiceDate(cal.getTime());

                //////////// Traido de las correcciones en la DLL de C# ///////////

                //////////////////////////////
                double valor = Double.parseDouble(trama.substring(28, 36)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(36, 38)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(36, 38)) / 100;
                }
                this.setFreeSalesTax(valor);

                //////////////////////////////
                valor = Double.parseDouble(trama.substring(38, 46)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(46, 48)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(46, 48)) / 100;
                }
                this.setGeneralRate1Sale(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(48, 56)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(56, 58)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(56, 58)) / 100;
                }
                this.setGeneralRate1Tax(valor);

                //////////////////////////////
                valor = Double.parseDouble(trama.substring(58, 66)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(66, 68)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(66, 68)) / 100;
                }
                this.setReducedRate2Sale(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(68, 76)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(76, 78)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(76, 78)) / 100;
                }
                this.setReducedRate2Tax(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(78, 86)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(86, 88)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(86, 88)) / 100;
                }
                this.setAdditionalRate3Sal(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(88, 96)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(96, 98)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(96, 98)) / 100;
                }
                this.setAdditionalRate3Tax(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(98, 106)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(106, 108)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(106, 108)) / 100;
                }
                this.setFreeTaxDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(108, 116)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(116, 118)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(116, 118)) / 100;
                }
                this.setGeneralRateDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(118, 126)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(126, 128)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(126, 128)) / 100;
                }
                this.setGeneralRateTaxDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(128, 136)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(136, 138)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(136, 138)) / 100;
                }
                this.setReducedRateDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(138, 146)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(146, 148)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(146, 148)) / 100;
                }
                this.setReducedRateTaxDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(148, 156)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(156, 158)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(156, 158)) / 100;
                }
                this.setAdditionalRateDevolution(valor);
                //////////////////////////////
                valor = Double.parseDouble(trama.substring(158, 166)); // para evitar errores con numeros negativos...
                if (valor < 0)
                {
                    valor -= Double.parseDouble(trama.substring(166, 168)) / 100;
                }
                else
                {
                    valor += Double.parseDouble(trama.substring(166, 168)) / 100;
                }
                this.setAdditionalRateTaxDevolution(valor);
                //////////////////////////////

                this.setNumberOfLastCreditNote(Integer.parseInt(trama.substring(168, 176)));
                /////////////////////////

        
        
        
        
        
        
        
        
          }
        }
    }
     /**
      * Retorna el número del ultimo reporte Z efectuado.
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
      * Retorna el número de la ultima factura emitida.
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

    private void setFreeSalesTax(double freeSalesTax) {
        this.freeSalesTax = freeSalesTax;
    }
     /**
      * Retorna el monto total de Base Imponible General almacenado.
      */
    public double getGeneralRate1Sale() {
        return generalRate1Sale;
    }

   private void setGeneralRate1Sale(double generalRate1Sale) {
        this.generalRate1Sale = generalRate1Sale;
    }
     /**
      * Retorna el monto total de IVA General ó Tasa(1) almacenado.
      */
    public double getGeneralRate1Tax() {
        return generalRate1Tax;
    }

   private void setGeneralRate1Tax(double generalRate1Tax) {
        this.generalRate1Tax = generalRate1Tax;
    }
     /**
      * Retorna el monto total de Base Imponible Reducida almacenado.
      */
    public double getReducedRate2Sale() {
        return reducedRate2Sale;
    }

    private void setReducedRate2Sale(double reducedRate2Sale) {
        this.reducedRate2Sale = reducedRate2Sale;
    }
     /**
      * Retorna el monto total de IVA Reducido ó Tasa(2) almacenado.
      */
    public double getReducedRate2Tax() {
        return reducedRate2Tax;
    }

    private void setReducedRate2Tax(double reducedRate2Tax) {
        this.reducedRate2Tax = reducedRate2Tax;
    }
    /**
      * Retorna el monto total de Base Imponible Adicional almacenado.
      */
    public double getAdditionalRate3Sal() {
        return additionalRate3Sal;
    }

    private void setAdditionalRate3Sal(double additionalRate3Sal) {
        this.additionalRate3Sal = additionalRate3Sal;
    }
    /**
      * Retorna el monto total de IVA Adicional ó Tasa(3) almacenado.
      */
    public double getAdditionalRate3Tax() {
        return additionalRate3Tax;
    }

    private void setAdditionalRate3Tax(double additionalRate3Tax) {
        this.additionalRate3Tax = additionalRate3Tax;
    }
    /**
      * Retorna el monto total Exento en Devolución almacenado.
      */
    public double getFreeTaxDevolution() {
        return freeTaxDevolution;
    }

    private void setFreeTaxDevolution(double freeTaxDevolution) {
        this.freeTaxDevolution = freeTaxDevolution;
    }
    /**
      * Retorna el monto total de Base Imponible General en Devolución almacenado.
      */
    public double getGeneralRateDevolution() {
        return generalRateDevolution;
    }

   private void setGeneralRateDevolution(double generalRateDevolution) {
        this.generalRateDevolution = generalRateDevolution;
    }
    /**
      * Retorna el monto total de IVA General ó Tasa(1) en Devolución almacenado.
      */
    public double getGeneralRateTaxDevolution() {
        return generalRateTaxDevolution;
    }

   private void setGeneralRateTaxDevolution(double generalRateTaxDevolution) {
        this.generalRateTaxDevolution = generalRateTaxDevolution;
    }
    /**
      * Retorna el monto total de Base Imponible Reducida en Devolución almacenado.
      */
    public double getReducedRateDevolution() {
        return reducedRateDevolution;
    }

   private void setReducedRateDevolution(double reducedRateDevolution) {
        this.reducedRateDevolution = reducedRateDevolution;
    }
    /**
      * Retorna el monto total de IVA Reducido ó Tasa(2) en Devolución almacenado.
      */
    public double getReducedRateTaxDevolution() {
        return reducedRateTaxDevolution;
    }

    private void setReducedRateTaxDevolution(double reducedRateTaxDevolution) {
        this.reducedRateTaxDevolution = reducedRateTaxDevolution;
    }
    /**
      * Retorna el monto total de Base Imponible Adicional en Devolución almacenado.
      */
    public double getAdditionalRateDevolution() {
        return additionalRateDevolution;
    }

   private void setAdditionalRateDevolution(double additionalRateDevolution) {
        this.additionalRateDevolution = additionalRateDevolution;
    }
     /**
      * Retorna el monto total de IVA Adicional ó Tasa(3) en Devolución almacenado.
      */
    public double getAdditionalRateTaxDevolution() {
        return additionalRateTaxDevolution;
    }

   private void setAdditionalRateTaxDevolution(double additionalRateTaxDevolution) {
        this.additionalRateTaxDevolution = additionalRateTaxDevolution;
    }
     /**
      * Retorna el número de la última Nota de Credito ó Devolución.
      */
    public int getNumberOfLastCreditNote() {
        return numberOfLastCreditNote;
    }

   private void setNumberOfLastCreditNote(int numberOfLastCreditNote) {
        this.numberOfLastCreditNote = numberOfLastCreditNote;
    }
  
    
}
