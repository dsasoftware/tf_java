/*
 * S3PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.pa;

/**
 *
 * @author The Factory
 */
public class S3PrinterData {
    private int typeTax1;
    private double tax1;
    private int typeTax2;
    private double tax2;
    private int typeTax3;
    private double tax3;
    private int[] allSystemFlags;
    
    /** Creates a new instance of S3PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S3 de la impresora fiscal subidos al PC
     */
	public S3PrinterData(String trama) {
		if (trama != null && trama.length() >= 57) {
          this.setTypeTax1(Integer.parseInt(trama.substring(2,3)));
          double valor = Double.parseDouble(trama.substring(3,5)) + Double.parseDouble(trama.substring(5,7))/100;
          this.setTax1(valor);
          this.setTypeTax2(Integer.parseInt(trama.substring(8,9)));//7-8
          valor = Double.parseDouble(trama.substring(9,11)) + Double.parseDouble(trama.substring(11,13))/100;
          this.setTax2(valor);
          this.setTypeTax3(Integer.parseInt(trama.substring(14,15)));
          valor = Double.parseDouble(trama.substring(15,17)) + Double.parseDouble(trama.substring(17,19))/100;
          this.setTax3(valor);
          
          this.allSystemFlags = new int[20];
          int a = 21;
          int b = 23;
          int ite = 0;
			while (ite < 20) {
				this.allSystemFlags[ite] = Integer.parseInt(trama.substring(
						a, b));

				a = b;
				b = b + 2;

				++ite;
			}
			this.setAllSystemFlags(allSystemFlags);
		}
    }
    /**Retorta el modo de la tasa 1. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido*/
    public int getTypeTax1() {
        return typeTax1;
    }
    /**Retorta el valor en porcentaje (%) de  tasa 1*/
    public double getTax1() {
        return tax1;
    }
    /**Retorta el modo de la tasa 2. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido*/
    public int getTypeTax2() {
        return typeTax2;
    }
    /**Retorta el valor en porcentaje (%) de  tasa 2*/
    public double getTax2() {
        return tax2;
    }
    /**Retorta el modo de la tasa 3. Modo = 1 es Impuesto Incluido; Modo = 2 es Impuesto Excluido*/
    public int getTypeTax3() {
        return typeTax3;
    }
    /**Retorta el valor en porcentaje (%) de  tasa 3*/
    public double getTax3() {
        return tax3;
    }
    /**Retorta un arreglo de 20 valores enteros correspondiente a la configuración de los flags del 0 al 19.
     * Ejemplo; systemFlags0to19[0] = 1, quiere decil que el flags número 0 está configurado en 1.
     */

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
    
}
