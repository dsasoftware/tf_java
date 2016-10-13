/*
 * S2PrinterData.java
 *
 * Created on 4 de junio de 2009, 04:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.cw;

/**
 *
 * @author The Factory
 */
public class S2PrinterData {
   //region Variables Globales

        private double subTotalMax;
        private double subTotalTax;
        private String dataDummy;
        private double amountToPay;
        private int numberPaymentsMade;
        private int typeDocument;
        private double quantityArticles;
      
        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna el monto subtotal de las bases imponibles y exento de una transacción activa
        /// </summary>
		public double getSubTotalMax() {
			return subTotalMax;
		}
	
		// / <summary>
		// / Retorna el monto total de los IVA(s) de una transacción activa
		// / </summary>
		public double getSubTotalTax() {
			return subTotalTax;
		}
	
		// / <summary>
		// / Retorna una data de relleno y el nuero de items de una transacción
		// cuando esta activada esta modalidad
		// / </summary>
		public String getDataDummy() {
			return dataDummy;
		}
	
		// / <summary>
		// / Retorna monto total por pagar en una transacción activa
		// / </summary>
		public double getAmountToPay() {
			return amountToPay;
		}
	
		// / <summary>
		// / Retorna la cantidad de pagos realizados
		// / </summary>
		public int getNumberPaymentsMade() {
			return numberPaymentsMade;
		}
	
		// / <summary>
		// / Retorna el tipo de documento en transaccion
		// / </summary>
		public int getTypeDocument() {
			return this.typeDocument;
		}
	
		// / <summary>
		// / Retorna la cantidad de articulos en transaccion
		// / </summary>
		public double getQuantityArticles() {
			return this.quantityArticles;
		}
	
		private void setQuantityArticles(double value) {
			this.quantityArticles = value;
		}
	
		private void setSubTotalMax(double subTotalMax) {
			this.subTotalMax = subTotalMax;
		}
	
		private void setSubTotalTax(double subTotalTax) {
			this.subTotalTax = subTotalTax;
		}
	
		private void setDataDummy(String dataDummy) {
			this.dataDummy = dataDummy;
		}
	
		private void setAmountToPay(double amountToPay) {
			this.amountToPay = amountToPay;
		}
	
		private void setNumberPaymentsMade(int numberPaymentsMade) {
			this.numberPaymentsMade = numberPaymentsMade;
		}
	
		private void setTypeDocument(int type) {
			this.typeDocument = type;
		}
	
		// endregion
	
		// region Constructor
		// / <summary>
		// / Crea una nueva instancia de la clase S2PrinterData.
		// / <param name="trama">Cadena de caracteres que cntiene la data subida del
		// PC del estado S2</param>
		// / </summary>
		public S2PrinterData(String trama) {
			if (trama != null) {
				if (trama.length() > 0) {
					try {
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
						if (arrayParameter.length > 1) {
                            this.setSubTotalMax(tfhka.Util.doValueDecimal(arrayParameter[0].substring(2)));
                            this.setSubTotalTax(tfhka.Util.doValueDecimal(arrayParameter[1]));
                            this.setDataDummy(arrayParameter[2]);
                            this.setQuantityArticles(tfhka.Util.doValueDecimalThree(arrayParameter[3]));
                            this.setAmountToPay(tfhka.Util.doValueDecimal(arrayParameter[4]));
                            this.setNumberPaymentsMade(Integer.parseInt(arrayParameter[5]));
                            this.setTypeDocument(Integer.parseInt(arrayParameter[6]));
						}
					} catch (ArrayIndexOutOfBoundsException are) {
						return;
					} catch (NumberFormatException nfexp) {
						return;
					}
                }
            }
        }

        //endregion
}
