/*
 * S5PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.pa;

/**
 *
 * @author The Factory
 */
public class S5PrinterData {
    private String RIF;
    private String DV;
    private String registeredMachineNumber;
    private int AuditMemoryNumber;
    private double auditMemoryTotalCapacity;
    private double AuditMemoryFreeCapacity;
    private int numberRegisteredDocuments;
    
     /** Creates a new instance of S5PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S5 de la impresora fiscal subidos al PC
     */
	public S5PrinterData(String trama) {
		if (trama != null && trama.length() >= 55) {
        this.setRIF(trama.substring(2,22));
        this.setDV(trama.substring(22,24));
        this.setRegisteredMachineNumber(trama.substring(24,37));
        this.setAuditMemoryNumber(Integer.parseInt(trama.substring(37,41)));
        this.setAuditMemoryTotalCapacity(Double.parseDouble(trama.substring(41,45)));
        this.setAuditMemoryFreeCapacity(Double.parseDouble(trama.substring(45,49)));
        this.setNumberRegisteredDocuments(Integer.parseInt(trama.substring(49,55)));
        }
        
    }

	/** Retorna el RIF de fiscalizaci�n de la impresora fiscal */
	/**
	 * Retorna el DV de la razón social de fiscalización de la impresora
	 * fiscal
	 **/
	public String getDV() {
		return DV;
	}
    /** Retorna el numero de registro o serial  de la impresora fiscal*/
    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }
    /** Retorna el numero correspondiente a la memoria de auditor�a en la impresora fiscal*/

	private void setRIF(String RIF) {
		this.RIF = RIF;
	}

	public String getRIF() {
		return RIF;
	}
	public int getAuditMemoryNumber() {
		return AuditMemoryNumber;
	}
	public double getAuditMemoryTotalCapacity() {
		return auditMemoryTotalCapacity;
	}
	public double getAuditMemoryFreeCapacity() {
		return AuditMemoryFreeCapacity;
	}
	public int getNumberRegisteredDocuments() {
		return numberRegisteredDocuments;
	}
	private void setDV(String dv) {
        this.DV = dv;
    }

    private void setRegisteredMachineNumber(String registeredMachineNumber) {
        this.registeredMachineNumber = registeredMachineNumber;
    }
	public void setAuditMemoryNumber(int auditMemoryNumber) {
		AuditMemoryNumber = auditMemoryNumber;
	}
	public void setAuditMemoryTotalCapacity(double auditMemoryTotalCapacity) {
		this.auditMemoryTotalCapacity = auditMemoryTotalCapacity;
	}
	public void setAuditMemoryFreeCapacity(double auditMemoryFreeCapacity) {
		AuditMemoryFreeCapacity = auditMemoryFreeCapacity;
	}
	public void setNumberRegisteredDocuments(int numberRegisteredDocuments) {
		this.numberRegisteredDocuments = numberRegisteredDocuments;
	}
    
}
