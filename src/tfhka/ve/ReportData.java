package tfhka.ve;

import java.util.Date;
import java.util.GregorianCalendar; 
/** 
* Representa una estructura para almacenar los datos de los reportes X y Z
*/ 
public class ReportData {
	private int numberOfLastZReport;
	private Date ZReportDate;
	private Date lastInvoiceDate; // (includes the hour)
	// Facturas
	private double freeSalesTax;
	private double generalRate1Sale;
	private double generalRate1Tax;
	private double reducedRate2Sale;
	private double reducedRate2Tax;
	private double additionalRate3Sale;
	private double additionalRate3Tax;
	// Nota de Creditos
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
                                int y = Integer.parseInt(arrayParameter[1].substring(0, 2)) /*+ 2000*/;
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
                            cal.set(y + 2000,m-1,d);

                            this.ZReportDate = cal.getTime();
                            this.numberOfLastInvoice = Integer.parseInt(arrayParameter[2]);

                                y = Integer.parseInt(arrayParameter[3].substring(0, 2)) /*+ 2000*/;
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
                                  cal.set(y + 2000,m-1,d,h,min,0);

                                this.lastInvoiceDate = cal.getTime();
                                this.freeSalesTax = this.doValueDecimal(arrayParameter[5]);
                                this.generalRate1Sale = this.doValueDecimal(arrayParameter[6]);
                                this.generalRate1Tax = this.doValueDecimal(arrayParameter[7]);
                                this.reducedRate2Sale = this.doValueDecimal(arrayParameter[8]);
                                this.reducedRate2Tax = this.doValueDecimal(arrayParameter[9]);
                                this.additionalRate3Sale = this.doValueDecimal(arrayParameter[10]);
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
                             int y = Integer.parseInt(arrayParameter[1].substring(0, 2)) /*+ 2000*/;
                             int m = Integer.parseInt(arrayParameter[1].substring(2, 4));
                             int d = Integer.parseInt(arrayParameter[1].substring(4, 6));
                             int hh = Integer.parseInt(arrayParameter[2].substring(0, 2));
                             int min = Integer.parseInt(arrayParameter[2].substring(2, 4));

                             if (m == 0 && d == 0 && y == 0/*2000*/)
                             {
                                 m = 1;
                                 d = 1;
                                 y = 1;
                                 hh = 0;
                                 min = 0;
                             }

                              //   Date cal = new Date(y, m, d, hh, min, 0);
                            GregorianCalendar cal = new GregorianCalendar(); 
                            cal.set(2000 + y,m-1,d,hh,min,0);

                             this.ZReportDate = cal.getTime();
                             this.numberOfLastInvoice = Integer.parseInt(arrayParameter[3]);

                             y = Integer.parseInt(arrayParameter[4].substring(0, 2)) /*+ 2000*/;
                             m = Integer.parseInt(arrayParameter[4].substring(2, 4));
                             d = Integer.parseInt(arrayParameter[4].substring(4, 6));

                             hh = Integer.parseInt(arrayParameter[5].substring(0, 2));
                             min = Integer.parseInt(arrayParameter[5].substring(2, 4));

                             if (m == 0 && d == 0 && y == 0/*2000*/)
                             {
                                 m = 1;
                                 d = 1;
                                 y = 1;

                             }
                               cal.set(2000 + y ,m-1,d,hh,min,0);

                             this.lastInvoiceDate = cal.getTime();

                             this.numberOfLastCreditNote = Integer.parseInt(arrayParameter[7]);
                             this.numberOfLastDebitNote = Integer.parseInt(arrayParameter[6]);
                             this.numberOfLastNonFiscal = Integer.parseInt(arrayParameter[8]);

                             this.freeSalesTax = this.doValueDecimal(arrayParameter[9]);
                             this.generalRate1Sale = this.doValueDecimal(arrayParameter[10]);
                             this.generalRate1Tax = this.doValueDecimal(arrayParameter[11]);
                             this.reducedRate2Sale = this.doValueDecimal(arrayParameter[12]);
                             this.reducedRate2Tax = this.doValueDecimal(arrayParameter[13]);
                             this.additionalRate3Sale = this.doValueDecimal(arrayParameter[14]);
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
      * Retorna el n�mero del ultimo reporte Z efectuado.
      */
   
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
	public int getNumberOfLastZReport() {
		return numberOfLastZReport;
	}
	public void setNumberOfLastZReport(int numberOfLastZReport) {
		this.numberOfLastZReport = numberOfLastZReport;
	}
	public Date getZReportDate() {
		return ZReportDate;
	}
	public void setZReportDate(Date zReportDate) {
		ZReportDate = zReportDate;
	}
	public Date getLastInvoiceDate() {
		return lastInvoiceDate;
	}
	public void setLastInvoiceDate(Date lastInvoiceDate) {
		this.lastInvoiceDate = lastInvoiceDate;
	}
	public double getFreeSalesTax() {
		return freeSalesTax;
	}
	public void setFreeSalesTax(double freeSalesTax) {
		this.freeSalesTax = freeSalesTax;
	}
	public double getGeneralRate1Sale() {
		return generalRate1Sale;
	}
	public void setGeneralRate1Sale(double generalRate1Sale) {
		this.generalRate1Sale = generalRate1Sale;
	}
	public double getGeneralRate1Tax() {
		return generalRate1Tax;
	}
	public void setGeneralRate1Tax(double generalRate1Tax) {
		this.generalRate1Tax = generalRate1Tax;
	}
	public double getReducedRate2Sale() {
		return reducedRate2Sale;
	}
	public void setReducedRate2Sale(double reducedRate2Sale) {
		this.reducedRate2Sale = reducedRate2Sale;
	}
	public double getReducedRate2Tax() {
		return reducedRate2Tax;
	}
	public void setReducedRate2Tax(double reducedRate2Tax) {
		this.reducedRate2Tax = reducedRate2Tax;
	}
	public double getAdditionalRate3Sale() {
		return additionalRate3Sale;
	}
	public void setAdditionalRate3Sale(double additionalRate3Sale) {
		this.additionalRate3Sale = additionalRate3Sale;
	}
	public double getAdditionalRate3Tax() {
		return additionalRate3Tax;
	}
	public void setAdditionalRate3Tax(double additionalRate3Tax) {
		this.additionalRate3Tax = additionalRate3Tax;
	}
	public double getFreeTaxDevolution() {
		return freeTaxDevolution;
	}
	public void setFreeTaxDevolution(double freeTaxDevolution) {
		this.freeTaxDevolution = freeTaxDevolution;
	}
	public double getGeneralRateDevolution() {
		return generalRateDevolution;
	}
	public void setGeneralRateDevolution(double generalRateDevolution) {
		this.generalRateDevolution = generalRateDevolution;
	}
	public double getGeneralRateTaxDevolution() {
		return generalRateTaxDevolution;
	}
	public void setGeneralRateTaxDevolution(double generalRateTaxDevolution) {
		this.generalRateTaxDevolution = generalRateTaxDevolution;
	}
	public double getReducedRateDevolution() {
		return reducedRateDevolution;
	}
	public void setReducedRateDevolution(double reducedRateDevolution) {
		this.reducedRateDevolution = reducedRateDevolution;
	}
	public double getReducedRateTaxDevolution() {
		return reducedRateTaxDevolution;
	}
	public void setReducedRateTaxDevolution(double reducedRateTaxDevolution) {
		this.reducedRateTaxDevolution = reducedRateTaxDevolution;
	}
	public double getAdditionalRateDevolution() {
		return additionalRateDevolution;
	}
	public void setAdditionalRateDevolution(double additionalRateDevolution) {
		this.additionalRateDevolution = additionalRateDevolution;
	}
	public double getAdditionalRateTaxDevolution() {
		return additionalRateTaxDevolution;
	}
	public void setAdditionalRateTaxDevolution(double additionalRateTaxDevolution) {
		this.additionalRateTaxDevolution = additionalRateTaxDevolution;
	}
	public double getFreeTaxDebit() {
		return freeTaxDebit;
	}
	public void setFreeTaxDebit(double freeTaxDebit) {
		this.freeTaxDebit = freeTaxDebit;
	}
	public double getGeneralRateDebit() {
		return generalRateDebit;
	}
	public void setGeneralRateDebit(double generalRateDebit) {
		this.generalRateDebit = generalRateDebit;
	}
	public double getGeneralRateTaxDebit() {
		return generalRateTaxDebit;
	}
	public void setGeneralRateTaxDebit(double generalRateTaxDebit) {
		this.generalRateTaxDebit = generalRateTaxDebit;
	}
	public double getReducedRateDebit() {
		return reducedRateDebit;
	}
	public void setReducedRateDebit(double reducedRateDebit) {
		this.reducedRateDebit = reducedRateDebit;
	}
	public double getReducedRateTaxDebit() {
		return reducedRateTaxDebit;
	}
	public void setReducedRateTaxDebit(double reducedRateTaxDebit) {
		this.reducedRateTaxDebit = reducedRateTaxDebit;
	}
	public double getAdditionalRateDebit() {
		return additionalRateDebit;
	}
	public void setAdditionalRateDebit(double additionalRateDebit) {
		this.additionalRateDebit = additionalRateDebit;
	}
	public double getAdditionalRateTaxDebit() {
		return additionalRateTaxDebit;
	}
	public void setAdditionalRateTaxDebit(double additionalRateTaxDebit) {
		this.additionalRateTaxDebit = additionalRateTaxDebit;
	}
	public int getNumberOfLastInvoice() {
		return numberOfLastInvoice;
	}
	public void setNumberOfLastInvoice(int numberOfLastInvoice) {
		this.numberOfLastInvoice = numberOfLastInvoice;
	}
	public int getNumberOfLastCreditNote() {
		return numberOfLastCreditNote;
	}
	public void setNumberOfLastCreditNote(int numberOfLastCreditNote) {
		this.numberOfLastCreditNote = numberOfLastCreditNote;
	}
	public int getNumberOfLastDebitNote() {
		return numberOfLastDebitNote;
	}
	public void setNumberOfLastDebitNote(int numberOfLastDebitNote) {
		this.numberOfLastDebitNote = numberOfLastDebitNote;
	}
	public int getNumberOfLastNonFiscal() {
		return numberOfLastNonFiscal;
	}
	public void setNumberOfLastNonFiscal(int numberOfLastNonFiscal) {
		this.numberOfLastNonFiscal = numberOfLastNonFiscal;
	}
}
