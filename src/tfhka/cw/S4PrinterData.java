/*
 * S4PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.cw;

/**
 *
 * @author The Factory
 */
public class S4PrinterData {
    //region Variables Globales

        private double[] accumulatedMountsAllMeansOfPayment;
        				 

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorna una lista de los montos acumulados de los 16 medios de pagos
        /// </summary>
        

		public double[] getAccumulatedMountsAllMeansOfPayment() {
			return accumulatedMountsAllMeansOfPayment;
		}

		public void setAccumulatedMountsAllMeansOfPayment(
				double[] accumulatedMountsAllMeansOfPayment) {
			this.accumulatedMountsAllMeansOfPayment = accumulatedMountsAllMeansOfPayment;
		}
        //endregion

        //region Constructor
        /// <summary>
        /// Crea una nueva instancia de la clase S4PrinterData.
        /// <param name="trama">Cadena de caracteres que cntiene la data subida del PC del estado S4</param>
        /// </summary>
		public S4PrinterData(String trama) {
			if (trama != null) {
				if (trama.length() > 0) {
					try {
						String[] arrayParameter = trama.split(String
								.valueOf((char) 0X0A));
						if (arrayParameter.length > 1) {
	                        int limit = arrayParameter.length;
	                        this.accumulatedMountsAllMeansOfPayment = new double[limit];

                            int ite = 0;
							double valor = 0.00;
							while (ite < limit) {
								String cadena = arrayParameter[ite];
	
								if (ite == 0) {
									valor = this
											.doValueDecimal(cadena.substring(2));
								} else {
									valor = this.doValueDecimal(cadena);
								}
	
								this.accumulatedMountsAllMeansOfPayment[ite] = valor;
	
								++ite;
							}

                            this.setAccumulatedMountsAllMeansOfPayment(accumulatedMountsAllMeansOfPayment);
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

        //region Metodos Privados


		private double doValueDecimal(String tramaString) {
			// ////////////////////////////
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
