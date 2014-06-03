/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka.cw;

/** 
* Representa una estructura para almacenar los datos de los reportes X acumulados en las diferentes bases y tasas
*/ 
public class AcumuladosX {
    
    /*
     * Variables Globales 
     */

   private double cumulativeExc;
   private double rateTaxBase1;
   private double rateTaxBase2;
   private double rateTaxBase3;
   private double rateTaxBase4;
   private double rateTaxBase5;
   private double taxRate1;
   private double taxRate2;
   private double taxRate3;
   private double taxRate4;
   private double taxRate5;
   /*
    *Constructor
    */
		public AcumuladosX(String trama) {
			if (trama != null) {
				if (trama.length() > 0) // DT230
				{
	
					try {
			        	String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
			        	this.cumulativeExc = this.doValueDecimal(arrayParameter[1]);
			        	this.rateTaxBase1 = this.doValueDecimal(arrayParameter[2]);
			        	this.rateTaxBase2 = this.doValueDecimal(arrayParameter[3]);
			        	this.rateTaxBase3 = this.doValueDecimal(arrayParameter[4]);
			        	this.rateTaxBase4 = this.doValueDecimal(arrayParameter[5]);
			        	this.rateTaxBase5 = this.doValueDecimal(arrayParameter[6]);
			        	this.taxRate1 = this.doValueDecimal(arrayParameter[7]);
			        	this.taxRate2 = this.doValueDecimal(arrayParameter[8]);
			        	this.taxRate3 = this.doValueDecimal(arrayParameter[9]);
			        	this.taxRate4 = this.doValueDecimal(arrayParameter[10]);
			        	this.taxRate5 = this.doValueDecimal(arrayParameter[11]);
	
					} catch (ArrayIndexOutOfBoundsException aexp) {
						return;
					} catch (NumberFormatException nfexp) {
						return;
					}
				}
			}
	}
    
    /*
     * Propiedades
     */
    /*
    * Retorna el monto total Exento almacenado.
    */
  //region Metodos Privados

	private double doValueDecimal(String tramaString) {

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

	public double getCumulativeExc() {
		return cumulativeExc;
	}

	public double getRateTaxBase1() {
		return rateTaxBase1;
	}

	public double getRateTaxBase2() {
		return rateTaxBase2;
	}

	public double getRateTaxBase3() {
		return rateTaxBase3;
	}

	public double getRateTaxBase4() {
		return rateTaxBase4;
	}

	public double getRateTaxBase5() {
		return rateTaxBase5;
	}

	public double getTaxRate1() {
		return taxRate1;
	}

	public double getTaxRate2() {
		return taxRate2;
	}

	public double getTaxRate3() {
		return taxRate3;
	}

	public double getTaxRate4() {
		return taxRate4;
	}

	public double getTaxRate5() {
		return taxRate5;
	}
    
}
