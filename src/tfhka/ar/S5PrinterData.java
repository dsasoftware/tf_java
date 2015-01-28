/*
 * S5PrinterData.java
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
public class S5PrinterData {
    private String CUIT;
    private String serialMachineNumber;
    private int auditMemoryEjNumber;
    private double auditMemoryEjTotalCapacity;
    private double AuditMemoryEjFreeCapacity;
    private int quantityOfDocuments;
    
     /** Creates a new instance of S5PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S5 de la impresora fiscal subidos al PC
     */
		public S5PrinterData(String trama) {
			if (trama != null) {
				if (trama.length() > 0) {
					try {
						String[] arrayParameter = trama.split(String
								.valueOf((char) 0X0A));
						if (arrayParameter.length >= 4) {
							this.setCUIT(arrayParameter[0]);
							this.setSerialMachineNumber(arrayParameter[1]);
							this.setAuditMemoryEjNumber(Integer
									.parseInt(arrayParameter[2]));
							this.setAuditMemoryEjTotalCapacity(this
									.doValueDecimal(arrayParameter[3]));
							this.setAuditMemoryEjFreeCapacity(this
									.doValueDecimal(arrayParameter[4]));
							this.setQuantityOfDocuments(Integer
									.parseInt(arrayParameter[5]));
						}
					} catch (ArrayIndexOutOfBoundsException | NumberFormatException | StringIndexOutOfBoundsException are) {
						return;
					}
				}
			}
	
		}
     /** Retorna el RIF de fiscalización de la impresora fiscal*/
    public String getCUIT() {
        return this.CUIT;
    }
    /** Retorna el numero de registro o serial  de la impresora fiscal*/
    public String getSerialMachineNumber() {
        return this.serialMachineNumber;
    }
    /** Retorna el numero correspondiente a la memoria de auditoría en la impresora fiscal*/
    public int getAuditMemoryEjNumber() {
		return auditMemoryEjNumber;
	}
    /** Retorna la capacidad total en MB de la memoria de auditoria*/
    public double getAuditMemoryEjTotalCapacity() {
		return auditMemoryEjTotalCapacity;
	}
	/** Retorna la disponibilidad de espacio en MB de la memoria de auditoria*/

    public double getAuditMemoryEjFreeCapacity() {
		return AuditMemoryEjFreeCapacity;
	}
	/** Retorna la cantidad de documento registrado en la memoria de auditoria*/
    public int getQuantityOfDocuments() {
        return this.quantityOfDocuments;
    }

	private void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    private void setSerialMachineNumber(String serialMachineNumber) {
        this.serialMachineNumber = serialMachineNumber;
    }

    public void setAuditMemoryEjNumber(int auditMemoryNumber) {
		this.auditMemoryEjNumber = auditMemoryNumber;
	}

    public void setAuditMemoryEjTotalCapacity(double auditMemoryTotalCapacity) {
		this.auditMemoryEjTotalCapacity = auditMemoryTotalCapacity;
	}
	public void setAuditMemoryEjFreeCapacity(double auditMemoryFreeCapacity) {
		AuditMemoryEjFreeCapacity = auditMemoryFreeCapacity;
	}
	private void setQuantityOfDocuments(int quantityOfDocuments) {
        this.quantityOfDocuments = quantityOfDocuments;
    }
    
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
}
