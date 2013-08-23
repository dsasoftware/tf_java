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

        private double totalInoviceClientFinal; // Facturas para Consumidor Final
        private double tax4InoviceClientFinal;
        private double tax1InoviceClientFinal;
        private double tax5InoviceClientFinal;
        private double tax2InoviceClientFinal;       
        private double tax3InoviceClientFinal;

        private double totalInoviceCreditFiscal; // Factura con Credito Fiscal
        private double tax4InoviceCreditFiscal;
        private double tax1InoviceCreditFiscal;
        private double tax5InoviceCreditFiscal;
        private double tax2InoviceCreditFiscal;       
        private double tax3InoviceCreditFiscal;

        private double totalNoteCreditClientFinal; // Notas de Credito para Consumidor Final
        private double tax4NoteCreditClientFinal;
        private double tax1NoteCreditClientFinal;
        private double tax5NoteCreditClientFinal;
        private double tax2NoteCreditClientFinal;
        private double tax3NoteCreditClientFinal;

        private double totalNoteCreditCreditFiscal; //Notas de Credito con credito Fiscal
        private double tax1NoteCreditCreditFiscal;
        private double tax2NoteCreditCreditFiscal;
        private double tax3NoteCreditCreditFiscal;
        private double tax4NoteCreditCreditFiscal;
        private double tax5NoteCreditCreditFiscal;

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
        public double getTotalInoviceClientFinal()
        {
           return totalInoviceClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax4InoviceClientFinal()
        {
           return tax4InoviceClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax1InoviceClientFinal()
        {
            return tax1InoviceClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax5InoviceClientFinal()
        {
             return tax5InoviceClientFinal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax2InoviceClientFinal()
        {
              return tax2InoviceClientFinal; 

        }    
        /// <summary>
        /// Retorna el monto total de impuesto 3 de Factura para Consumidor Final almacenado.
        /// </summary>
        public double getTax3InoviceClientFinal()
        {
              return tax3InoviceClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de Factura con Credito Fiscal almacenado.
        /// </summary>
        public double getTotalInoviceCreditFiscal()
        {
              return totalInoviceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax4InoviceCreditFiscal()
        {
             return tax4InoviceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax1InoviceCreditFiscal()
        {
             return tax1InoviceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax5InoviceCreditFiscal()
        {
            return tax5InoviceCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax2InoviceCreditFiscal()
        {
             return tax2InoviceCreditFiscal; 
        }       
        /// <summary>
        /// Retorna el monto total de impuesto 3 de Factura con credito Fiscal almacenado.
        /// </summary>
        public double getTax3InoviceCreditFiscal()
        {
             return tax3InoviceCreditFiscal; 
        }
        /// <summary>
        /// Retorna el monto total de Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTotalNoteCreditCreditFiscal()
        {
             return totalNoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax1NoteCreditCreditFiscal()
        {
            return tax1NoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax2NoteCreditCreditFiscal()
        {
            return tax2NoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 3 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax3NoteCreditCreditFiscal()
        {
            return tax3NoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax4NoteCreditCreditFiscal()
        {
             return tax4NoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de la Nota de Credito con credito Fiscal almacenado.
        /// </summary>
        public double getTax5NoteCreditCreditFiscal()
        {
             return tax5NoteCreditCreditFiscal; 

        }
        /// <summary>
        /// Retorna el monto total de Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTotalNoteCreditClientFinal()
        {
             return totalNoteCreditClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 1 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax1NoteCreditClientFinal()
        {
            return tax1NoteCreditClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 2 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax2NoteCreditClientFinal()
        {
             return tax2NoteCreditClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 3 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax3NoteCreditClientFinal()
        {
            return tax3NoteCreditClientFinal; 
        }
        /// <summary>
        /// Retorna el monto total de impuesto 4 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax4NoteCreditClientFinal()
        {
            return tax4NoteCreditClientFinal; 

        }
        /// <summary>
        /// Retorna el monto total de impuesto 5 de la Nota de Credito para Consumidor Final almacenado.
        /// </summary>
        public double getTax5NoteCreditClientFinal()
        {
            return tax5NoteCreditClientFinal; 

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

                            this.totalInoviceClientFinal = this.doValueDecimal(arrayParameter[7]);
                            this.tax1InoviceClientFinal = this.doValueDecimal(arrayParameter[8]);
                            this.tax2InoviceClientFinal = this.doValueDecimal(arrayParameter[9]);
                            this.tax3InoviceClientFinal = this.doValueDecimal(arrayParameter[10]);
                            this.tax4InoviceClientFinal = this.doValueDecimal(arrayParameter[11]);
                            this.tax5InoviceClientFinal = this.doValueDecimal(arrayParameter[12]);
                            this.totalInoviceCreditFiscal = this.doValueDecimal(arrayParameter[13]);
                            this.tax1InoviceCreditFiscal = this.doValueDecimal(arrayParameter[14]);
                            this.tax2InoviceCreditFiscal = this.doValueDecimal(arrayParameter[15]);
                            this.tax3InoviceCreditFiscal = this.doValueDecimal(arrayParameter[16]);
                            this.tax4InoviceCreditFiscal = this.doValueDecimal(arrayParameter[17]);
                            this.tax5InoviceCreditFiscal = this.doValueDecimal(arrayParameter[18]);
                            this.totalNoteCreditClientFinal = this.doValueDecimal(arrayParameter[19]);
                            this.tax1NoteCreditClientFinal = this.doValueDecimal(arrayParameter[20]);
                            this.tax2NoteCreditClientFinal = this.doValueDecimal(arrayParameter[21]);
                            this.tax3NoteCreditClientFinal = this.doValueDecimal(arrayParameter[22]);
                            this.tax4NoteCreditClientFinal = this.doValueDecimal(arrayParameter[23]);
                            this.tax5NoteCreditClientFinal = this.doValueDecimal(arrayParameter[24]);
                            this.totalNoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[25]);
                            this.tax1NoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[26]);
                            this.tax2NoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[27]);
                            this.tax3NoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[28]);
                            this.tax4NoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[29]);
                            this.tax5NoteCreditCreditFiscal = this.doValueDecimal(arrayParameter[30]);

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
