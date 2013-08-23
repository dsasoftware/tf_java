/*
 * S1PrinterData.java
 *
 * Created on 4 de junio de 2009, 01:10 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.rd;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author The Factory
 */
public class S1PrinterData {
    
 //region Variables Globales

        private int cashierNumber;
        private double subTotalSalesClientFinal;
        private double subTotalSalesCreditFiscal;      
        private double subTotalNoteCreditClientFinal;     
        private double subTotalNoteCreditCreditFiscal;     
        private int lastNumberTransactionFiscal;     
        private int quantityTransactionToday;
        private int numberNonFiscalDocuments;
        private int quantityNonFiscalDocuments;
        private int dailyClosureCounter;
        private int auditReportsCounter;
        private String RNC;
        private String registeredMachineNumber;
        private Date currentPrinterDate;

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna el número del cajero activo.
        /// </summary>
        public int getCashierNumber()
        {
            return cashierNumber;
        }
        /// <summary>
        /// Retorna el número del último documento no fiscal emitido
        /// </summary>
        public int getNumberNonFiscalDocuments()
        {
            return numberNonFiscalDocuments;
        }
        /// <summary>
        /// Retorna la cantidad de documentos no fiscales
        /// </summary>
        public int getQuantityNonFiscalDocuments()
        {
            return quantityNonFiscalDocuments;
        }
        /// <summary>
        /// Retorna el numero de contador de cierre diario
        /// </summary>
        public int getDailyClosureCounter()
        {
            return dailyClosureCounter;
        }
        /// <summary>
        /// Retorna el numero de contador de reporte de auditoría
        /// </summary>
        public int getAuditReportsCounter()
        {
            return auditReportsCounter;
        }
        /// <summary>
        /// Retorna el RIF de la razón social de fiscalización de la impresora fiscal
        /// </summary>
        public String getRNC()
        {
            return RNC;
        }
        /// <summary>
        /// Retorna el número de serial de la impresora fiscal
        /// </summary>
        public String getRegisteredMachineNumber()
        {
            return registeredMachineNumber;
        }
        /// <summary>
        /// Retorna la fecha y la hora de la impresora fiscal
        /// </summary>
        public Date getCurrentPrinterDate()
        {
            return currentPrinterDate;
        }
        /// <summary>
        /// Retorna el sub total de las ventas de consumidor final
        /// </summary>
        public double getSubTotalSalesClientFinal()
        {
            return this.subTotalSalesClientFinal; 
        }
        /// <summary>
        /// Retorna el sub total de las ventas de credito fiscal
        /// </summary>
        public double getSubTotalSalesCreditFiscal()
        {
            return subTotalSalesCreditFiscal;
        }
        /// <summary>
        /// Retorna el sub total de las notas de credito de consumidor final
        /// </summary>
        public double getSubTotalNoteCreditClientFinal()
        {
            return this.subTotalNoteCreditClientFinal;
        }
        /// <summary>
        /// Retorna el sub total de las notas de credito de credito fiscal
        /// </summary>
        public double getSubTotalNoteCreditCreditFiscal()
        {
            return this.subTotalNoteCreditCreditFiscal;
        }
        /// <summary>
        /// Retorna el numero de la ultima transaccion fiscal
        /// </summary>
        public int getLastNumberTransactionFiscal()
        {
            return this.lastNumberTransactionFiscal;
        }
        /// <summary>
        /// Retorna la cantidad de transaccion fiscal en el dia
        /// </summary>
        public int getQuantityTransactionToday()
        {
            return this.quantityTransactionToday;
        }

        private void setQuantityTransactionToday(int value)
        {
            this.quantityTransactionToday = value;
        }

        private void setLastNumberTransactionFiscal(int value)
        {
            this.lastNumberTransactionFiscal = value;
        }
        private void setSubTotalNoteCreditCreditFiscal(double value)
        {
            this.subTotalNoteCreditCreditFiscal = value;
        }

        private void setSubTotalNoteCreditClientFinal(double value)
        {
            this.subTotalNoteCreditClientFinal = value;
        }

        private void setSubTotalSalesCreditFiscal(double value)
        {
            this.subTotalSalesCreditFiscal = value;
        }

        private void setSubTotalSalesClientFinal(double value)
        {
            this.subTotalSalesClientFinal = value;
        }

        private void setCashierNumber(int cashierNumber)
        {
            this.cashierNumber = cashierNumber;
        }

        private void setNumberNonFiscalDocuments(int numberNonFiscalDocuments)
        {
            this.numberNonFiscalDocuments = numberNonFiscalDocuments;
        }

        private void setQuantityNonFiscalDocuments(int quantityNonFiscalDocuments)
        {
            this.quantityNonFiscalDocuments = quantityNonFiscalDocuments;
        }

        private void setDailyClosureCounter(int dailyClosureCounter)
        {
            this.dailyClosureCounter = dailyClosureCounter;
        }

        private void setAuditReportsCounter(int auditReportsCounter)
        {
            this.auditReportsCounter = auditReportsCounter;
        }

        private void setRNC(String RNC)
        {
            this.RNC = RNC;
        }

        private void setRegisteredMachineNumber(String registeredMachineNumber)
        {
            this.registeredMachineNumber = registeredMachineNumber;
        }

        private void setCurrentPrinterDate(Date currentPrinterDate)
        {
            this.currentPrinterDate = currentPrinterDate;
        }

        //endregion

        //region Constructor
        /// <summary>
        /// Crea una nueva instancia de la clase S1PrinterData.
        /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S1</param>
        /// </summary>
        public S1PrinterData(String trama)
        {
            if (trama != null) //trama.length >= 139 DT230
             {
                 if (trama.length() > 0)
                 {
                   try
                    { 
                    String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                    if (arrayParameter.length > 1)
                    {  
                        this.setCashierNumber(Integer.parseInt(arrayParameter[0].substring(2)));
                        this.setSubTotalSalesClientFinal(this.doValueDecimal(arrayParameter[1]));
                        this.setSubTotalSalesCreditFiscal(this.doValueDecimal(arrayParameter[2]));
                        this.setSubTotalNoteCreditClientFinal(this.doValueDecimal(arrayParameter[3]));
                        this.setSubTotalNoteCreditCreditFiscal(this.doValueDecimal(arrayParameter[4]));
                        this.setLastNumberTransactionFiscal(Integer.parseInt(arrayParameter[5]));
                        this.setQuantityTransactionToday(Integer.parseInt(arrayParameter[6]));
                        this.setNumberNonFiscalDocuments(Integer.parseInt(arrayParameter[7]));
                        this.setQuantityNonFiscalDocuments(Integer.parseInt(arrayParameter[9]));
                        this.setAuditReportsCounter(Integer.parseInt(arrayParameter[9]));
                        this.setDailyClosureCounter(Integer.parseInt(arrayParameter[10]));
                        this.setRNC(arrayParameter[11]);
                        this.setRegisteredMachineNumber(arrayParameter[12]);

                        String hr = arrayParameter[13].substring(0, 2);
                        String mn = arrayParameter[13].substring(2, 4);
                        String sg = arrayParameter[13].substring(4, 6);

                        String dd = arrayParameter[14].substring(0, 2);
                        String mm = arrayParameter[14].substring(2, 4);
                        String aa = arrayParameter[14].substring(4, 6);

                          GregorianCalendar cal = new GregorianCalendar(); 
                          cal.set(Integer.parseInt(aa)+2000,Integer.parseInt(mm)-1,Integer.parseInt(dd),Integer.parseInt(hr),Integer.parseInt(mn),Integer.parseInt(sg));

                        this.setCurrentPrinterDate(cal.getTime());
                    }
                 }
                     catch(ArrayIndexOutOfBoundsException aoe)
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

       //endregion //endregion
}
