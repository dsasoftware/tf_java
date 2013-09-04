/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka.rd;

/** 
* Representa una estructura para almacenar los datos de los reportes X acumulados en las diferentes bases y tasas
*/ 
public class AcumuladosX {
    
    /*
     * Variables Globales
     */

   private double _cumulativeExcConsF;
   private double _rateTaxBaseConsF1;
   private double _rateTaxBaseConsF2;
   private double _rateTaxBaseConsF3;
   private double _rateTaxBaseConsF4;
   private double _rateTaxBaseConsF5;
   private double _taxRateConsF1;
   private double _taxRateConsF2;
   private double _taxRateConsF3;
   private double _taxRateConsF4;
   private double _taxRateConsF5;
   
   private double _cumulativeNcExcConsF;
   private double _rateTaxBaseNcConsF1;
   private double _rateTaxBaseNcConsF2;
   private double _rateTaxBaseNcConsF3;
   private double _rateTaxBaseNcConsF4;
   private double _rateTaxBaseNcConsF5;
   private double _taxRateNcConsF1;
   private double _taxRateNcConsF2;
   private double _taxRateNcConsF3;
   private double _taxRateNcConsF4;
   private double _taxRateNcConsF5;
   
   /*
    *Constructor
    */
    public AcumuladosX(String trama)
    {
      if (trama != null)
      {
        if (trama.length() >  0) // DT230
        {

        try{
        	
        	String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
        	this._cumulativeExcConsF = this.doValueDecimal(arrayParameter[1]);
        	this._rateTaxBaseConsF1 = this.doValueDecimal(arrayParameter[2]);
        	this._rateTaxBaseConsF2 = this.doValueDecimal(arrayParameter[3]);
        	this._rateTaxBaseConsF3 = this.doValueDecimal(arrayParameter[4]);
        	this._rateTaxBaseConsF4 = this.doValueDecimal(arrayParameter[5]);
        	this._rateTaxBaseConsF5 = this.doValueDecimal(arrayParameter[6]);
        	this._taxRateConsF1 = this.doValueDecimal(arrayParameter[7]);
        	this._taxRateConsF2 = this.doValueDecimal(arrayParameter[8]);
        	this._taxRateConsF3 = this.doValueDecimal(arrayParameter[9]);
        	this._taxRateConsF4 = this.doValueDecimal(arrayParameter[10]);
        	this._taxRateConsF5 = this.doValueDecimal(arrayParameter[11]);
        	this._cumulativeNcExcConsF = this.doValueDecimal(arrayParameter[12]);
        	this._rateTaxBaseNcConsF1 = this.doValueDecimal(arrayParameter[13]);
        	this._rateTaxBaseNcConsF2 = this.doValueDecimal(arrayParameter[14]);
        	this._rateTaxBaseNcConsF3 = this.doValueDecimal(arrayParameter[15]);
        	this._rateTaxBaseNcConsF4 = this.doValueDecimal(arrayParameter[16]);
        	this._rateTaxBaseNcConsF5 = this.doValueDecimal(arrayParameter[17]);
        	this._taxRateNcConsF1 = this.doValueDecimal(arrayParameter[18]);
        	this._taxRateNcConsF2 = this.doValueDecimal(arrayParameter[19]);
        	this._taxRateNcConsF3 = this.doValueDecimal(arrayParameter[20]);
        	this._taxRateNcConsF4 = this.doValueDecimal(arrayParameter[21]);
        	this._taxRateNcConsF5 = this.doValueDecimal(arrayParameter[22]);
        	
        }
        catch (ArrayIndexOutOfBoundsException aexp)
        {
            return;
        }
        catch (NumberFormatException nfexp)
        {
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

	public double get_cumulativeExcConsF() {
		return _cumulativeExcConsF;
	}

	public double get_rateTaxBaseConsF1() {
		return _rateTaxBaseConsF1;
	}

	public double get_rateTaxBaseConsF2() {
		return _rateTaxBaseConsF2;
	}

	public double get_rateTaxBaseConsF3() {
		return _rateTaxBaseConsF3;
	}

	public double get_rateTaxBaseConsF4() {
		return _rateTaxBaseConsF4;
	}

	public double get_rateTaxBaseConsF5() {
		return _rateTaxBaseConsF5;
	}

	public double get_taxRateConsF1() {
		return _taxRateConsF1;
	}

	public double get_taxRateConsF2() {
		return _taxRateConsF2;
	}

	public double get_taxRateConsF3() {
		return _taxRateConsF3;
	}

	public double get_taxRateConsF4() {
		return _taxRateConsF4;
	}

	public double get_taxRateConsF5() {
		return _taxRateConsF5;
	}

	public double get_cumulativeNcExcConsF() {
		return _cumulativeNcExcConsF;
	}

	public double get_rateTaxBaseNcConsF1() {
		return _rateTaxBaseNcConsF1;
	}

	public double get_rateTaxBaseNcConsF2() {
		return _rateTaxBaseNcConsF2;
	}

	public double get_rateTaxBaseNcConsF3() {
		return _rateTaxBaseNcConsF3;
	}

	public double get_rateTaxBaseNcConsF4() {
		return _rateTaxBaseNcConsF4;
	}

	public double get_rateTaxBaseNcConsF5() {
		return _rateTaxBaseNcConsF5;
	}

	public double get_taxRateNcConsF1() {
		return _taxRateNcConsF1;
	}

	public double get_taxRateNcConsF2() {
		return _taxRateNcConsF2;
	}

	public double get_taxRateNcConsF3() {
		return _taxRateNcConsF3;
	}

	public double get_taxRateNcConsF4() {
		return _taxRateNcConsF4;
	}

	public double get_taxRateNcConsF5() {
		return _taxRateNcConsF5;
	}
    
	//u0x3
	
    
    
    
}
