/*
  * S3PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.ve;

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

                           int indice = arrayParameter[3].length()/2;

                           this.allSystemFlags = new int[indice];
                           int a = 0;
                           int b = 2;
                           int ite = 0;

                           while (ite < indice)
                           {
                               this.allSystemFlags[ite] = Integer.parseInt(arrayParameter[3].substring(a, b));

                               a = a + 2;
                               b = b + 2;

                               ++ite;
                           }

                           this.setAllSystemFlags(allSystemFlags);
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
    /**Retorta un arreglo de 20 valores enteros correspondiente a la configuraci�n de los flags del 0 al 19.
     * Ejemplo; systemFlags[0] = 1, quiere decil que el flags n�mero 0 est� configurado en 1.
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

}
