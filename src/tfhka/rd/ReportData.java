package tfhka.rd;

import java.util.Date;
import java.util.GregorianCalendar; 
import java.lang.*;
/** 
* Representa una estructura para almacenar los datos de los reportes X y Z
*/ 
public class ReportData {
    //region Variables Globales

        private int numberOfLastZReport;
        private Date ZReportDate;
        private int numberOfLastTransaction;
        private Date lastTransactionDate; //(includes the hour)
        private int numberOfLastNonFiscal;

        private double totalInvoiceFinalClient; // Facturas para Consumidor Final
        private double tax4InvoiceFinalClient;
        private double tax1InvoiceFinalClient;
        private double tax5InvoiceFinalClient;
        private double tax2InvoiceFinalClient;       
        private double tax3InvoiceFinalClient;

        private double totalInvoiceCreditFiscal; // Factura con Credito Fiscal
        private double tax4InvoiceCreditFiscal;
        private double tax1InvoiceCreditFiscal;
        private double tax5InvoiceCreditFiscal;
        private double tax2InvoiceCreditFiscal;       
        private double tax3InvoiceCreditFiscal;

        private double totalCreditNoteFinalClient; // Notas de Credito para Consumidor Final
        private double tax4CreditNoteFinalClient;
        private double tax1CreditNoteFinalClient;
        private double tax5CreditNoteFinalClient;
        private double tax2CreditNoteFinalClient;
        private double tax3CreditNoteFinalClient;

        private double totalCreditNoteCreditFiscal; //Notas de Credito con credito Fiscal
        private double tax1CreditNoteCreditFiscal;
        private double tax2CreditNoteCreditFiscal;
        private double tax3CreditNoteCreditFiscal;
        private double tax4CreditNoteCreditFiscal;
        private double tax5CreditNoteCreditFiscal;

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna el número del ultimo reporte Z efectuado.
        /// </summary>
        public int getNumberOfLastZReport()
        {
           return numberOfLastZReport; 
        }
        /// <summary>
        ///  Retorna la fecha  del ultimo reporte Z efectuado.
        /// </summary>
        public Date getZReportDate()
        {
             return ZReportDate; 
        }
        /// <summary>
        ///  Retorna el número de la ultima factura emitida.
        /// </summary>
        public int getNumberOfLastTransaction()
        {
             return numberOfLastTransaction; 

        }
        /// <summary>
        /// Retorna la fecha y la hora de la ultima transaccion emitida.
        /// </summary>
        public Date getLastTransactionDate()
        {
           return lastTransactionDate; 

        }
        /// <summary>
        /// Retorna el monto total de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTotalInvoiceFinalClient()
        {
           return totalInvoiceFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax4InvoiceFinalClient()
        {
           return tax4InvoiceFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax1InvoiceFinalClient()
        {
            return tax1InvoiceFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax5InoviceFinalClient()
        {
             return tax5InvoiceFinalClient; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax2InvoiceFinalClient()
        {
              return tax2InvoiceFinalClient; 

        }    
        /// <summary>
        /// Retorna el monto total de impuesto 3 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax3InvoiceFinalClient()
        {
              return tax3InvoiceFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de Factura con Credito Fiscal almacenado.
        /// </summary>
        public double getTotalInvoiceCreditFiscal()
        {
              return totalInvoiceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax4InvoiceCreditFiscal()
        {
             return tax4InvoiceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax1InvoiceCreditFiscal()
        {
             return tax1InvoiceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax5InvoiceCreditFiscal()
        {
            return tax5InvoiceCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax2InoviceCreditFiscal()
        {
             return tax2InvoiceCreditFiscal; 
        }       
        /// <summary>
        /// Retorna el monto total de impuesto 3 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax3InvoiceCreditFiscal()
        {
             return tax3InvoiceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTotalCreditNoteCreditFiscal()
        {
             return totalCreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax1CreditNoteCreditFiscal()
        {
            return tax1CreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax2CreditNoteCreditFiscal()
        {
            return tax2CreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 3 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax3CreditNoteCreditFiscal()
        {
            return tax3CreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax4CreditNoteCreditFiscal()
        {
             return tax4CreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax5CreditNoteCreditFiscal()
        {
             return tax5CreditNoteCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTotalCreditNoteFinalClient()
        {
             return totalCreditNoteFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax1CreditNoteFinalClient()
        {
            return tax1CreditNoteFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax2CreditNoteFinalClient()
        {
             return tax2CreditNoteFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 3 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax3CreditNoteFinalClient()
        {
            return tax3CreditNoteFinalClient; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax4CreditNoteFinalClient()
        {
            return tax4CreditNoteFinalClient; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax5CreditNoteFinalClient()
        {
            return tax5CreditNoteFinalClient; 

        }
        /// <summary>
        /// Retorna el número del último Documento No Fiscal.
        /// </summary>
        public int getNumberOfLastNonFiscal()
        {
            return numberOfLastNonFiscal; 

        }

        //endregion

        //region Constructor
        /// <summary>
        /// Creates a new instance of ReportData
        /// </summary>
        /// <param name="trama">Cadena de caracteres que contiene la data de reportes</param>   
        public ReportData(String trama)
        {
            if (trama != null)
            {
                if (trama.length() > 0) //344 DT230
                {
                    try
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
                            this.numberOfLastTransaction = Integer.parseInt(arrayParameter[3]);

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

                            this.lastTransactionDate = cal.getTime();
                            this.numberOfLastNonFiscal = Integer.parseInt(arrayParameter[6]);

                            this.totalInvoiceFinalClient = this.doValueDecimal(arrayParameter[7]);
                            this.tax1InvoiceFinalClient = this.doValueDecimal(arrayParameter[8]);
                            this.tax2InvoiceFinalClient = this.doValueDecimal(arrayParameter[9]);
                            this.tax3InvoiceFinalClient = this.doValueDecimal(arrayParameter[10]);
                            this.tax4InvoiceFinalClient = this.doValueDecimal(arrayParameter[11]);
                            this.tax5InvoiceFinalClient = this.doValueDecimal(arrayParameter[12]);
                            this.totalInvoiceCreditFiscal = this.doValueDecimal(arrayParameter[13]);
                            this.tax1InvoiceCreditFiscal = this.doValueDecimal(arrayParameter[14]);
                            this.tax2InvoiceCreditFiscal = this.doValueDecimal(arrayParameter[15]);
                            this.tax3InvoiceCreditFiscal = this.doValueDecimal(arrayParameter[16]);
                            this.tax4InvoiceCreditFiscal = this.doValueDecimal(arrayParameter[17]);
                            this.tax5InvoiceCreditFiscal = this.doValueDecimal(arrayParameter[18]);
                            this.totalCreditNoteFinalClient = this.doValueDecimal(arrayParameter[19]);
                            this.tax1CreditNoteFinalClient = this.doValueDecimal(arrayParameter[20]);
                            this.tax2CreditNoteFinalClient = this.doValueDecimal(arrayParameter[21]);
                            this.tax3CreditNoteFinalClient = this.doValueDecimal(arrayParameter[22]);
                            this.tax4CreditNoteFinalClient = this.doValueDecimal(arrayParameter[23]);
                            this.tax5CreditNoteFinalClient = this.doValueDecimal(arrayParameter[24]);
                            this.totalCreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[25]);
                            this.tax1CreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[26]);
                            this.tax2CreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[27]);
                            this.tax3CreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[28]);
                            this.tax4CreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[29]);
                            this.tax5CreditNoteCreditFiscal = this.doValueDecimal(arrayParameter[30]);

                        }
                    }
                    catch (ArrayIndexOutOfBoundsException aexp)
                    {
                        return;
                    }
                    catch (NumberFormatException nfexp)
                    {
                        return;
                    }
             
                }
            }
        }

        //endregion

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

        //endregion
}
