/*
 * S2PrinterData.java
 *
 * Created on 4 de junio de 2009, 04:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.rd;

/**
 *
 * @author The Factory
 */
public class S2PrinterData {
   //region Variables Globales

        private double subTotalBases;
        private double sudTotalTax;
        private String dataDummy;
        private double amountPayable;
        private int numberPaymentsMade;
        private int typeDocument;
        private int quantityArticles;
      
        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna el monto subtotal de las bases imponibles y exento de una transacci�n activa
        /// </summary>
        public double getSubTotalBases()
        {
            return subTotalBases;
        }
        /// <summary>
        /// Retorna el monto total de los IVA(s) de una transacci�n activa
        /// </summary>
        public double getSudTotalTax()
        {
            return sudTotalTax;
        }
        /// <summary>
        /// Retorna una data de relleno y el nuero de items de una transacci�n cuando esta activada esta modalidad
        /// </summary>
        public String getDataDummy()
        {
            return dataDummy;
        }
        /// <summary>
        /// Retorna monto total por pagar en una transacci�n activa
        /// </summary>
        public double getAmountPayable()
        {
            return amountPayable;
        }
        /// <summary>
        /// Retorna la cantidad de pagos realizados
        /// </summary>
        public int getNumberPaymentsMade()
        {
            return numberPaymentsMade;
        }
        /// <summary>
        /// Retorna el tipo de documento en transaccion
        /// </summary>
        public int getTypeDocument()
        {
            return this.typeDocument;
        }
        /// <summary>
        /// Retorna la cantidad de articulos en transaccion
        /// </summary>
        public int getQuantityArticles()
        {
            return this.quantityArticles;
        }

        private void setQuantityArticles(int value)
        {
            this.quantityArticles = value;
        }

        private void setSubTotalBases(double subTotalBases)
        {
            this.subTotalBases = subTotalBases;
        }

        private void setSudTotalTax(double sudTotalTax)
        {
            this.sudTotalTax = sudTotalTax;
        }

        private void setDataDummy(String dataDummy)
        {
            this.dataDummy = dataDummy;
        }

        private void setAmountPayable(double amountPayable)
        {
            this.amountPayable = amountPayable;
        }

        private void setNumberPaymentsMade(int numberPaymentsMade)
        {
            this.numberPaymentsMade = numberPaymentsMade;
        }

        private void setTypeDocument(int type)
        {
            this.typeDocument = type;
        }

        //endregion

        //region Constructor
        /// <summary>
        /// Crea una nueva instancia de la clase S2PrinterData.
        /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S2</param>
        /// </summary>
        public S2PrinterData(String trama)
        {
            if (trama != null)
            {
                if (trama.length() > 0)
                {
                    try
                    {
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                        if (arrayParameter.length > 1)
                        {
                            this.setSubTotalBases(this.doValueDecimal(arrayParameter[0].substring(2)));
                            this.setSudTotalTax(this.doValueDecimal(arrayParameter[1]));
                            this.setDataDummy(arrayParameter[2]);
                            this.setQuantityArticles(Integer.parseInt(arrayParameter[3]));
                            this.setAmountPayable(this.doValueDecimal(arrayParameter[4]));
                            this.setNumberPaymentsMade(Integer.parseInt(arrayParameter[5]));
                            this.setTypeDocument(Integer.parseInt(arrayParameter[6]));
                        }
                    }catch(ArrayIndexOutOfBoundsException are)
                    {
                        return;
                    }catch (NumberFormatException nfexp)
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