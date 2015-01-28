/*
 * S4PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.ar;


/**
 *
 * @author The Factory
 */
public class S4PrinterData {
    private double[] accumulatedAmountsAllMeansOfPayment;
    /** Creates a new instance of S4PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S4 de la impresora fiscal subidos al PC
     */
    public S4PrinterData(String trama)
    {
		if (trama != null) {
			if (trama.length() > 0) {
				try {
					String[] arrayParameter = trama.split(String
							.valueOf((char) 0X0A));
					if (arrayParameter.length > 1) {
						int limit = arrayParameter.length - 1;
						this.accumulatedAmountsAllMeansOfPayment = new double[limit];

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

							this.accumulatedAmountsAllMeansOfPayment[ite] = valor;

							++ite;
						}

						this.setAccumulatedAmountsAllMeansOfPayment(accumulatedAmountsAllMeansOfPayment);
					}
				} catch (ArrayIndexOutOfBoundsException are) {
					return;
				} catch (NumberFormatException | IndexOutOfBoundsException nfexp) {
					return;
				}
			}
		}
    }
     /**Retorna una lista de los montos acumulados de los 24 medios de pagos*/

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
	public double[] getAccumulatedAmountsAllMeansOfPayment() {
		return accumulatedAmountsAllMeansOfPayment;
	}
	public void setAccumulatedAmountsAllMeansOfPayment(
			double[] accumulatedAmountsAllMeansOfPayment) {
		this.accumulatedAmountsAllMeansOfPayment = accumulatedAmountsAllMeansOfPayment;
	}
}
