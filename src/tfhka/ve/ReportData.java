package tfhka.ve;

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
            try
              {
                if (trama.length() < 329)
                {
                  
                            String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                            if (arrayParameter.length > 1)
                            {
                                this.numberOfLastZReport = Integer.parseInt(arrayParameter[0]);
                                int y = Integer.parseInt(arrayParameter[1].substring(0, 2)) + 2000;
                                int m = Integer.parseInt(arrayParameter[1].substring(2, 4));
                                int d = Integer.parseInt(arrayParameter[1].substring(4, 6));

                                if (m == 0 && d == 0 && y == 2000)
                                {
                                    m = 1;
                                    d = 1;
                                    y = 1;
                                }

                                //   Date cal = new Date(y, m, d, hh, min, 0);
                            GregorianCalendar cal = new GregorianCalendar(); 
                            cal.set(y+2000,m-1,d);

                            this.ZReportDate = cal.getTime();
                            this.numberOfLastInvoice = Integer.parseInt(arrayParameter[2]);

                                y = Integer.parseInt(arrayParameter[3].substring(0, 2)) + 2000;
                                m = Integer.parseInt(arrayParameter[3].substring(2, 4));
                                d = Integer.parseInt(arrayParameter[3].substring(4, 6));

                                int h = Integer.parseInt(arrayParameter[4].substring(0, 2));
                                int min = Integer.parseInt(arrayParameter[4].substring(2, 4));
                                if (m == 0 && d == 0 && y == 2000)
                                {
                                    m = 1;
                                    d = 1;
                                    y = 1;

                                }
                                  cal.set(y+2000,m-1,d,h,min,0);

                                this.lastInvoiceDate = cal.getTime();
                                this.freeSalesTax = this.doValueDecimal(arrayParameter[5]);
                                this.generalRate1Sale = this.doValueDecimal(arrayParameter[6]);
                                this.generalRate1Tax = this.doValueDecimal(arrayParameter[7]);
                                this.reducedRate2Sale = this.doValueDecimal(arrayParameter[8]);
                                this.reducedRate2Tax = this.doValueDecimal(arrayParameter[9]);
                                this.additionalRate3Sal = this.doValueDecimal(arrayParameter[10]);
                                this.additionalRate3Tax = this.doValueDecimal(arrayParameter[11]);
                                this.freeTaxDevolution = this.doValueDecimal(arrayParameter[12]);
                                this.generalRateDevolution = this.doValueDecimal(arrayParameter[13]);
                                this.generalRateTaxDevolution = this.doValueDecimal(arrayParameter[14]);
                                this.reducedRateDevolution = this.doValueDecimal(arrayParameter[15]);
                                this.reducedRateTaxDevolution = this.doValueDecimal(arrayParameter[16]);
                                this.additionalRateDevolution = this.doValueDecimal(arrayParameter[17]);
                                this.additionalRateTaxDevolution = this.doValueDecimal(arrayParameter[18]);
                                this.numberOfLastCreditNote = Integer.parseInt(arrayParameter[19]);
                      }
          
                }
                else  // DT230
                {
                 
                         String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                         if (arrayParameter.length > 1)
                         {
                             this.numberOfLastZReport = Integer.parseInt(arrayParameter[0]);
                             int y = Integer.parseInt(arrayParameter[1].substring(0, 2)) + 2000;
                             int m = Integer.parseInt(arrayParameter[1].substring(2, 4));
                             int d = Integer.parseInt(arrayParameter[1].substring(4, 6));
                             int hh = Integer.parseInt(arrayParameter[2].substring(0, 2));
                             int min = Integer.parseInt(arrayParameter[2].substring(2, 4));

                             if (m == 0 && d == 0 && y == 2000)
                             {
                                 m = 1;
                                 d = 1;
                                 y = 1;
                                 hh = 0;
                                 min = 0;
                             }

                              //   Date cal = new Date(y, m, d, hh, min, 0);
                            GregorianCalendar cal = new GregorianCalendar(); 
                            cal.set(y+2000,m-1,d,hh,min,0);

                             this.ZReportDate = cal.getTime();
                             this.numberOfLastInvoice = Integer.parseInt(arrayParameter[3]);

                             y = Integer.parseInt(arrayParameter[4].substring(0, 2)) + 2000;
                             m = Integer.parseInt(arrayParameter[4].substring(2, 4));
                             d = Integer.parseInt(arrayParameter[4].substring(4, 6));

                             hh = Integer.parseInt(arrayParameter[5].substring(0, 2));
                             min = Integer.parseInt(arrayParameter[5].substring(2, 4));

                             if (m == 0 && d == 0 && y == 2000)
                             {
                                 m = 1;
                                 d = 1;
                                 y = 1;

                             }
                               cal.set(y+2000,m-1,d,hh,min,0);

                             this.lastInvoiceDate = cal.getTime();

                             this.numberOfLastCreditNote = Integer.parseInt(arrayParameter[6]);
                             this.numberOfLastDebitNote = Integer.parseInt(arrayParameter[7]);
                             this.numberOfLastNonFiscal = Integer.parseInt(arrayParameter[8]);

                             this.freeSalesTax = this.doValueDecimal(arrayParameter[9]);
                             this.generalRate1Sale = this.doValueDecimal(arrayParameter[10]);
                             this.generalRate1Tax = this.doValueDecimal(arrayParameter[11]);
                             this.reducedRate2Sale = this.doValueDecimal(arrayParameter[12]);
                             this.reducedRate2Tax = this.doValueDecimal(arrayParameter[13]);
                             this.additionalRate3Sal = this.doValueDecimal(arrayParameter[14]);
                             this.additionalRate3Tax = this.doValueDecimal(arrayParameter[15]);
                             this.freeTaxDebit = this.doValueDecimal(arrayParameter[16]);
                             this.generalRateDebit = this.doValueDecimal(arrayParameter[17]);
                             this.generalRateTaxDebit = this.doValueDecimal(arrayParameter[18]);
                             this.reducedRateDebit = this.doValueDecimal(arrayParameter[19]);
                             this.reducedRateTaxDebit = this.doValueDecimal(arrayParameter[20]);
                             this.additionalRateDebit = this.doValueDecimal(arrayParameter[21]);
                             this.additionalRateTaxDebit = this.doValueDecimal(arrayParameter[22]);
                             this.freeTaxDevolution = this.doValueDecimal(arrayParameter[23]);
                             this.generalRateDevolution = this.doValueDecimal(arrayParameter[24]);
                             this.generalRateTaxDevolution = this.doValueDecimal(arrayParameter[25]);
                             this.reducedRateDevolution = this.doValueDecimal(arrayParameter[26]);
                             this.reducedRateTaxDevolution = this.doValueDecimal(arrayParameter[27]);
                             this.additionalRateDevolution = this.doValueDecimal(arrayParameter[28]);
                             this.additionalRateTaxDevolution = this.doValueDecimal(arrayParameter[29]);

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
    //region Metodos Privados

        private double doValueDecimal(String tramaString)
        {
            //////////////////////////////
            int size = tramaString.length();
            int dif = size - 2;

            double valor = Double.parseDouble(tramaString.substring(0, dif));
            // para evitar errores con numeros negativos...
            if (valor < 0)
                valor -= Double.parseDouble(tramaString.substring(dif)) / 100;
            else
                valor += Double.parseDouble(tramaString.substring(dif)) / 100;

            return valor;
        }
}
