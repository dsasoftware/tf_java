
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
private Date lastInvoiceDate; //(includes the hour)
//Facturas
private double freeSalesTax;
private double generalRate1Sale;
private double generalRate1Tax;
private double reducedRate2Sale;
private double reducedRate2Tax;
private double additionalRate3Sal;
private double additionalRate3Tax;
//Nota de Creditos
private double freeTaxDevolution;
private double generalRateDevolution;
private double generalRateTaxDevolution;
private double reducedRateDevolution;
private double reducedRateTaxDevolution;
private double additionalRateDevolution;
private double additionalRateTaxDevolution;
// Notas de Debito
private double freeTaxDebit; 
private double generalRateDebit;
private double generalRateTaxDebit;
private double reducedRateDebit;
private double reducedRateTaxDebit;
private double additionalRateDebit;
private double additionalRateTaxDebit;

private int numberOfLastInvoice;
private int numberOfLastCreditNote;
private int numberOfLastDebitNote;
private int numberOfLastNonFiscal;

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
       
          } else if (trama.length() == 329) // DT230
                {

                  this.numberOfLastZReport = Integer.parseInt(trama.substring(0, 4));
                  GregorianCalendar cal = new GregorianCalendar();
                  cal.set(Integer.parseInt(trama.substring(4, 6)) + 2000, Integer.parseInt(trama.substring(6, 8)) - 1, Integer.parseInt(trama.substring(8, 10)), Integer.parseInt(trama.substring(10, 12)), Integer.parseInt(trama.substring(12, 14)));
                 this.setZReportDate(cal.getTime());
                
                this.setNumberOfLastInvoice(Integer.parseInt(trama.substring(14, 22)));
                cal.set(Integer.parseInt(trama.substring(22, 24)) + 2000, Integer.parseInt(trama.substring(24, 26)) - 1, Integer.parseInt(trama.substring(26, 28)), Integer.parseInt(trama.substring(28, 30)), Integer.parseInt(trama.substring(30, 32)));
                this.setLastInvoiceDate(cal.getTime());

                  this.setNumberOfLastCreditNote(Integer.parseInt(trama.substring(32, 40)));
                  this.setNumberOfLastDebitNote(Integer.parseInt(trama.substring(40, 48)));
                  this.setNumberOfLastNonFiscal(Integer.parseInt(trama.substring(48, 56)));

                  //////////////////////////////
                  double valor = Double.parseDouble(trama.substring(56, 67)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(67,69)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(67,69)) / 100;
                  this.freeSalesTax = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(69, 80)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(80, 82)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(80, 82)) / 100;
                  this.generalRate1Sale = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(82, 93)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(93, 95)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(93, 95)) / 100;
                  this.generalRate1Tax = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(95, 106)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(106, 108)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(106, 108)) / 100;
                  this.reducedRate2Sale = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(108, 119)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(119, 121)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(119, 121)) / 100;
                  this.reducedRate2Tax = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(121, 132)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(132,134)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(132, 134)) / 100;
                  this.additionalRate3Sal = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(134, 145)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(145, 147)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(145, 147)) / 100;
                  this.additionalRate3Tax = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(147, 158)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(158, 160)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(158, 160)) / 100;
                  this.freeTaxDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(160, 171)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(171, 173)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(171, 173)) / 100;
                  this.generalRateDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(173, 184)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(184, 186)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(184, 186)) / 100;
                  this.generalRateTaxDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(186, 197)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(197, 199)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(197, 199)) / 100;
                  this.reducedRateDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(199, 210)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(210, 212)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(210, 212)) / 100;
                  this.reducedRateTaxDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(212, 223)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(223, 225)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(223, 225)) / 100;
                  this.additionalRateDebit = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(225, 236)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(236, 238)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(236, 238)) / 100;
                  this.additionalRateTaxDebit = valor;
                  //////////////////////////////



                  valor = Double.parseDouble(trama.substring(238, 249)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(249, 251)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(249, 251)) / 100;
                  this.freeTaxDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(251, 262)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(262, 264)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(262, 264)) / 100;
                  this.generalRateDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(264, 275)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(275, 277)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(275, 277)) / 100;
                  this.generalRateTaxDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(277, 288)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(288, 290)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(288, 290)) / 100;
                  this.reducedRateDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(290, 301)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(301, 303)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(301, 303)) / 100;
                  this.reducedRateTaxDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(303, 314)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(314, 316)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(314, 316)) / 100;
                  this.additionalRateDevolution = valor;
                  //////////////////////////////

                  valor = Double.parseDouble(trama.substring(316, 327)); // para evitar errores con numeros negativos...
                  if (valor < 0)
                    valor -= Double.parseDouble(trama.substring(327, 329)) / 100;
                  else
                    valor += Double.parseDouble(trama.substring(327, 329)) / 100;
                  this.additionalRateTaxDevolution = valor;
                  //////////////////////////////
      

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
    /**
      * Retorna el número de la última Nota de Débito ó Devolución.
      */
    public int getNumberOfLastDebitNote() {
        return numberOfLastDebitNote;
    }

   private void setNumberOfLastDebitNote(int numberOfLastDebitNote) {
        this.numberOfLastDebitNote = numberOfLastDebitNote;
    }
   /**
      * Retorna el número de la última Nota de Débito ó Devolución.
      */
    public int getNumberOfLastNonFiscal() {
        return numberOfLastNonFiscal;
    }

   private void setNumberOfLastNonFiscal(int numberOfLastNonFiscal) {
        this.numberOfLastNonFiscal = numberOfLastNonFiscal;
    }
    /**
      * Retorna el monto total Exento en Nota de debito almacenado.
      */
    public double getFreeTaxDebitNote() {
        return freeTaxDebit;
    }

    private void setFreeTaxDebitNote(double freeTaxDebit) {
        this.freeTaxDebit = freeTaxDebit;
    }
    /**
      * Retorna el monto total de Base Imponible General en Nota de debito almacenado.
      */
    public double getGeneralRateDebitNote() {
        return generalRateDebit;
    }

   private void setGeneralRateDebitNote(double generalRateDebit) {
        this.generalRateDebit = generalRateDebit;
    }
    /**
      * Retorna el monto total de IVA General ó Tasa(1) en Nota de debito almacenado.
      */
    public double getGeneralRateTaxDebitNote() {
        return generalRateTaxDebit;
    }

   private void setGeneralRateTaxDebitNote(double generalRateTaxDebit) {
        this.generalRateTaxDebit = generalRateTaxDebit;
    }
    /**
      * Retorna el monto total de Base Imponible Reducida en Nota de debito almacenado.
      */
    public double getReducedRateDebitNote() {
        return reducedRateDebit;
    }

   private void setReducedRateDebitNote(double reducedRateDebit) {
        this.reducedRateDebit = reducedRateDebit;
    }
    /**
      * Retorna el monto total de IVA Reducido ó Tasa(2) en Nota de debito almacenado.
      */
    public double getReducedRateTaxDebitNote() {
        return reducedRateTaxDebit;
    }

    private void setReducedRateTaxDebitNote(double reducedRateTaxDebit) {
        this.reducedRateTaxDebit= reducedRateTaxDebit;
    }
    /**
      * Retorna el monto total de Base Imponible Adicional en Nota de debito almacenado.
      */
    public double getAdditionalRateDebitNote() {
        return additionalRateDebit;
    }

   private void setAdditionalRateDebitNote(double additionalRateDebit) {
        this.additionalRateDebit = additionalRateDebit;
    }
     /**
      * Retorna el monto total de IVA Adicional ó Tasa(3) en Nota de debito almacenado.
      */
    public double getAdditionalRateTaxDebitNote() {
        return additionalRateTaxDebit;
    }

   private void setAdditionalRateTaxDebitNote(double additionalRateTaxDebit) {
        this.additionalRateTaxDebit = additionalRateTaxDebit;
    }
}
