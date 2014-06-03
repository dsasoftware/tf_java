/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tfhka.cw;

/**
 *
 * @author Pablo (Ing. Proyect)
 */
public class S7PrinterData {

        private String MICR;
       
        /// <summary>
        /// Retorna una cadena con la lectura del MICR del cheque
        /// </summary>
		public String getMICR() {
			return MICR;
		}
	
		private void getMICR(String MICR) {
			this.MICR = MICR;
		}
	
		// / <summary>
		// / Crea una nueva instancia de la clase S7PrinterData.
		// / <param name="trama">Cadena de caracteres que cntiene la data subida del
		// PC del estado S7</param>
		// / </summary>
		public S7PrinterData(String trama) {
			if (trama != null && trama.length() >= 41) {
				this.getMICR(trama.substring(2, 41));
	
			}
		}

}
