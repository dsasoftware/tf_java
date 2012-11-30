/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tfhka;

/**
 *
 * @author Pablo (Ing. Proyect)
 */
public class S6PrinterData {

        private String Bit_Facturacion;
        private String Bit_Slip;
        private String Bit_Validacion;
 

        /// <summary>
        /// Indica la presencia de papel en la estacion de facturacion
        /// </summary>
        public String getBit_Facturacion()
        {
            return Bit_Facturacion;
        }
        private void getBit_Facturacion(String Bit_Facturacion)
        {
            this.Bit_Facturacion = Bit_Facturacion;
        }

        /// <summary>
        /// Indica la presencia de papel en la estacion de Slip/Chequera
        /// </summary>
        public String getBit_Slip()
        {
            return Bit_Slip;
        }
        private void getBit_Slip(String Bit_Slip)
        {
            this.Bit_Slip = Bit_Slip;
        }
        
        /// <summary>
        /// Indica la presencia de papel en la estacion de Validacion
        /// </summary>
        public String getBit_Validacion()
        {
            return Bit_Validacion;
        }
        private void getBit_Validacion(String Bit_Validacion)
        {
            this.Bit_Validacion = Bit_Validacion;
        }
 


       /// <summary>
       /// Crea una nueva instancia de la clase S6PrinterData.
       /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S6</param>
       /// </summary>
       public S6PrinterData(String trama)
       { 
           if (trama != null)
           {
               if(trama.length() > 0)
               {
               this.getBit_Facturacion(trama.substring(2, 3));
               this.getBit_Slip(trama.substring(3, 4));
               this.getBit_Validacion(trama.substring(4, 5));
               }
               
           }
       }

   

}
