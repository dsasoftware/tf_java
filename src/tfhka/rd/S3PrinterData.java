/*
 * S3PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.rd;

/**
 *
 * @author The Factory
 */
public class S3PrinterData {
    //region Variables Globales

        private int typeTax1;
        private double tax1;
        private int typeTax2;
        private double tax2;
        private int typeTax3;
        private double tax3;
        private int typeTax4;
        private double tax4;
        private int typeTax5;
        private double tax5;
        private int[] systemFlags0to63;

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorta el modo de la tasa 1. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
        public int getTypeTax1()
        {
            return typeTax1;
        }
        /// <summary>
        /// Retorta el valor en porcentaje (%) de  tasa 1
        /// </summary>    
        public double getTax1()
        {
            return tax1;
        }
        /// <summary>
        /// Retorta el modo de la tasa 2. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
        public int getTypeTax2()
        {
            return typeTax2;
        }
        /// <summary>
        /// Retorta el valor en porcentaje (%) de  tasa 2
        /// </summary>
        public double getTax2()
        {
            return tax2;
        }
        /// <summary>
        /// Retorta el modo de la tasa 3. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
        public int getTypeTax3()
        {
            return typeTax3;
        }
        /// <summary>
        /// Retorta el valor en porcentaje (%) de  tasa 3
        /// </summary>
        public double getTax3()
        {
            return tax3;
        }
        /// <summary>
        /// Retorta el modo de la tasa 4. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
        public int getTypeTax4()
        {
            return typeTax4;
        }
        /// <summary>
        /// Retorta el valor en porcentaje (%) de  tasa 4
        /// </summary>
        public double getTax4()
        {
            return tax4;
        }
        /// <summary>
        /// Retorta el modo de la tasa 5. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
        public int getTypeTax5()
        {
            return typeTax5;
        }
        /// <summary>
        /// Retorta el valor en porcentaje (%) de  tasa 5
        /// </summary>
        public double getTax5()
        {
            return tax5;
        }
        /// <summary>
        /// Retorta un arreglo de 63 valores enteros correspondiente a la configuración de los flags del 0 al 63.
        /// Ejemplo; systemFlags0to63[0] = 1, quiere decil que el flags número 0 está configurado en 1.
        /// </summary>
        public int[] getSystemFlags0to63()
        {
            return systemFlags0to63;
        }

        private void setTypeTax1(int typeTax1)
        {
            this.typeTax1 = typeTax1;
        }

        private void setTax1(double tax1)
        {
            this.tax1 = tax1;
        }

        private void setTypeTax2(int typeTax2)
        {
            this.typeTax2 = typeTax2;
        }

        private void setTax2(double tax2)
        {
            this.tax2 = tax2;
        }

        private void setTypeTax3(int typeTax3)
        {
            this.typeTax3 = typeTax3;
        }

        private void setTax3(double tax3)
        {
            this.tax3 = tax3;
        }

        private void setTax4(double tax4)
        {
            this.tax4 = tax4;
        }

        private void setTypeTax4(int typeTax4)
        {
            this.typeTax4 = typeTax4;
        }

        private void setTax5(double tax5)
        {
            this.tax5 = tax5;
        }

        private void setSystemFlags0to63(int[] systemFlags0to63)
        {
            this.systemFlags0to63 = systemFlags0to63;
        }

        private void setTypeTax5(int typeTax5)
        {
            this.typeTax5 = typeTax5;
        }

        //endregion

        //region Constructor
        /// <summary>
        /// Crea una nueva instancia de la clase S3PrinterData.
        /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S3</param>
        /// </summary>
        public S3PrinterData(String trama)
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
                           this.setTypeTax1(Integer.parseInt(arrayParameter[0].substring(2,3)));
                           this.setTax1(this.doValueDecimal(arrayParameter[0].substring(3)));
                           this.setTypeTax2(Integer.parseInt(arrayParameter[1].substring(0, 1)));
                           this.setTax2(this.doValueDecimal(arrayParameter[1].substring(1)));
                           this.setTypeTax3(Integer.parseInt(arrayParameter[2].substring(0, 1)));
                           this.setTax3(this.doValueDecimal(arrayParameter[2].substring(1)));
                           this.setTypeTax4(Integer.parseInt(arrayParameter[3].substring(0, 1)));
                           this.setTax4(this.doValueDecimal(arrayParameter[3].substring(1)));
                           this.setTypeTax5(Integer.parseInt(arrayParameter[4].substring(0, 1)));
                           this.setTax5(this.doValueDecimal(arrayParameter[4].substring(1)));

                           int indice = arrayParameter[5].length()/2;

                           this.systemFlags0to63 = new int[indice];
                           int a = 0;
                           int b = 2;
                           int ite = 0;

                           while (ite < indice)
                           {
                               this.systemFlags0to63[ite] = Integer.parseInt(arrayParameter[5].substring(a, b));

                               a = a + 2;
                               b = b + 2;

                               ++ite;
                           }

                           this.setSystemFlags0to63(systemFlags0to63);
                       }
                  }
                    catch(ArrayIndexOutOfBoundsException are)
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

        //endregion 
}
