/*
 * S3PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.cw;

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
          private int typeTax6;
        private double tax6;
          private int typeTax7;
        private double tax7;
          private int typeTax8;
        private double tax8;
          private int typeTax9;
        private double tax9;
          private int typeTax10;
        private double tax10;
        
        private int[] allSystemFlags;

        //endregion

        //region Propiedades
        /// <summary>
        /// Retorta el modo de la tasa 1. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido
        /// </summary>
		public int getTypeTax1() {
			return typeTax1;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 1
		// / </summary>
		public double getTax1() {
			return tax1;
		}
	
		// / <summary>
		// / Retorta el modo de la tasa 2. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax2() {
			return typeTax2;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 2
		// / </summary>
		public double getTax2() {
			return tax2;
		}
	
		// / <summary>
		// / Retorta el modo de la tasa 3. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax3() {
			return typeTax3;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 3
		// / </summary>
		public double getTax3() {
			return tax3;
		}
	
		// / <summary>
		// / Retorta el modo de la tasa 4. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax4() {
			return typeTax4;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 4
		// / </summary>
		public double getTax4() {
			return tax4;
		}
	
		// / <summary>
		// / Retorta el modo de la tasa 5. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax5() {
			return typeTax5;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax5() {
			return tax5;
		}
                
                // / <summary>
		// / Retorta el modo de la tasa 6. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax6() {
			return typeTax6;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax6() {
			return tax6;
		}
                
                // / <summary>
		// / Retorta el modo de la tasa 7. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax7() {
			return typeTax7;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax7() {
			return tax7;
		}
	
                // / <summary>
		// / Retorta el modo de la tasa 8. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax8() {
			return typeTax8;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax8() {
			return tax8;
		}
                
                // / <summary>
		// / Retorta el modo de la tasa 9. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax9() {
			return typeTax9;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax9() {
			return tax9;
		}
                
                // / <summary>
		// / Retorta el modo de la tasa 10. Modo = 1 es Impuesto Incluido; Modo = 2
		// es Impuesto Excluido
		// / </summary>
		public int getTypeTax10() {
			return typeTax10;
		}
	
		// / <summary>
		// / Retorta el valor en porcentaje (%) de tasa 5
		// / </summary>
		public double getTax10() {
			return tax10;
		}
		// / <summary>
		// / Retorta un arreglo de 63 valores enteros correspondiente a la
		// configuraci�n de los flags del 0 al 63.
		// / Ejemplo; systemFlags0to63[0] = 1, quiere decil que el flags n�mero 0
		// est� configurado en 1.
		// / </summary>

	
		private void setTypeTax1(int typeTax1) {
			this.typeTax1 = typeTax1;
		}
	
		public int[] getAllSystemFlags() {
			return allSystemFlags;
		}

		public void setAllSystemFlags(int[] allSystemFlags) {
			this.allSystemFlags = allSystemFlags;
		}

		private void setTax1(double tax1) {
			this.tax1 = tax1;
		}
	
		private void setTypeTax2(int typeTax2) {
			this.typeTax2 = typeTax2;
		}
	
		private void setTax2(double tax2) {
			this.tax2 = tax2;
		}
	
		private void setTypeTax3(int typeTax3) {
			this.typeTax3 = typeTax3;
		}
	
		private void setTax3(double tax3) {
			this.tax3 = tax3;
		}
	
		private void setTax4(double tax4) {
			this.tax4 = tax4;
		}
	
		private void setTypeTax4(int typeTax4) {
			this.typeTax4 = typeTax4;
		}
	
		private void setTax5(double tax5) {
			this.tax5 = tax5;
		}
	
	
		private void setTypeTax5(int typeTax5) {
			this.typeTax5 = typeTax5;
		}
                
                private void setTax6(double tax6) {
			this.tax6 = tax6;
		}
	
	
		private void setTypeTax6(int typeTax6) {
			this.typeTax6 = typeTax6;
		}
                
                private void setTax7(double tax7) {
			this.tax7 = tax7;
		}
	
	
		private void setTypeTax7(int typeTax7) {
			this.typeTax7 = typeTax7;
		}
                
                private void setTax8(double tax8) {
			this.tax8 = tax8;
		}
	
	
		private void setTypeTax8(int typeTax8) {
			this.typeTax8 = typeTax8;
		}
                
                private void setTax9(double tax9) {
			this.tax9 = tax9;
		}
	
	
		private void setTypeTax9(int typeTax9) {
			this.typeTax9 = typeTax9;
		}
                
                private void setTax10(double tax10) {
			this.tax10 = tax10;
		}
	
	
		private void setTypeTax10(int typeTax10) {
			this.typeTax10 = typeTax10;
		}
	
		// endregion
	
		// region Constructor
		// / <summary>
		// / Crea una nueva instancia de la clase S3PrinterData.
		// / <param name="trama">Cadena de caracteres que cntiene la data subida del
		// PC del estado S3</param>
		// / </summary>
		public S3PrinterData(String trama) {
			if (trama != null) {
				if (trama.length() > 0) {
					try {
						String[] arrayParameter = trama.split(String
								.valueOf((char) 0X0A));
						if (arrayParameter.length > 1) {
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
                                   this.setTypeTax6(Integer.parseInt(arrayParameter[5].substring(0, 1)));
	                           this.setTax6(this.doValueDecimal(arrayParameter[5].substring(1)));
                                   this.setTypeTax7(Integer.parseInt(arrayParameter[6].substring(0, 1)));
	                           this.setTax7(this.doValueDecimal(arrayParameter[6].substring(1)));
                                   this.setTypeTax8(Integer.parseInt(arrayParameter[7].substring(0, 1)));
	                           this.setTax8(this.doValueDecimal(arrayParameter[7].substring(1)));
                                    this.setTypeTax9(Integer.parseInt(arrayParameter[8].substring(0, 1)));
	                           this.setTax9(this.doValueDecimal(arrayParameter[8].substring(1)));
                                    this.setTypeTax10(Integer.parseInt(arrayParameter[9].substring(0, 1)));
	                           this.setTax10(this.doValueDecimal(arrayParameter[9].substring(1)));
	
	                           int indice = arrayParameter[10].length()/2;
	
	                           this.allSystemFlags = new int[indice];
	                           int a = 0;
	                           int b = 2;
	                           int ite = 0;
	
								while (ite < indice) {
									this.allSystemFlags[ite] = Integer
											.parseInt(arrayParameter[5].substring(a, b));
		
									a = a + 2;
									b = b + 2;
		
									++ite;
								}
	
	                           this.setAllSystemFlags(allSystemFlags);
                       }
					} catch (ArrayIndexOutOfBoundsException are) {
						return;
					} catch (NumberFormatException nfexp) {
						return;
					} catch (StringIndexOutOfBoundsException sfexp) {
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
