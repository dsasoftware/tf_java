/*
 * S4PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.rd;

/**
 *
 * @author The Factory
 */
public class S4PrinterData {
    //region Variables Globales

        private double[] listCumulaMountsMeansPayments;

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna una lista de los montos acumulados de los 16 medios de pagos
        /// </summary>
        public double[] getListCumulaMountsMeansPayments()
        {
            return listCumulaMountsMeansPayments;
        }

        private void setListCumulaMountsMeansPayments(double[] listCumulaMountsMeansPayments)
        {
            this.listCumulaMountsMeansPayments = listCumulaMountsMeansPayments;
        }

        //endregion

        //region Constructor
        /// <summary>
        /// Crea una nueva instancia de la clase S4PrinterData.
        /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S4</param>
        /// </summary>
        public S4PrinterData(String trama)
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
                        int limit = arrayParameter.length - 1;
                        this.listCumulaMountsMeansPayments = new double[limit];

                            int ite = 0;
                            double valor = 0.00;
                            while (ite < limit)
                            {
                                String cadena = arrayParameter[ite];

                                if (ite == 0)
                                {  valor = this.doValueDecimal(cadena.substring(2)); }
                                else
                                {  valor = this.doValueDecimal(cadena); }


                                this.listCumulaMountsMeansPayments[ite] = valor;

                                ++ite;
                            }

                            this.setListCumulaMountsMeansPayments(listCumulaMountsMeansPayments);
                    }
                }
                    catch(ArrayIndexOutOfBoundsException are)
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
