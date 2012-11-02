/*
 * S5PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka;

/**
 *
 * @author The Factory
 */
public class S5PrinterData {
    private String RIF;
    private String registeredMachineNumber;
    private int numberMemoryAudit;
    private double capacityTotalMemoryAudit;
    private double disponyCapacityMemoryAudit;
    private int numberDocumentRegisters;
    
     /** Creates a new instance of S5PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S5 de la impresora fiscal subidos al PC
     */
    public S5PrinterData(String trama)
    {
        if (trama != null && trama.length() == 41)
        {
        this.setRIF(trama.substring(2,13));
        this.setRegisteredMachineNumber(trama.substring(13,23));
        this.setNumberMemoryAudit(Integer.parseInt(trama.substring(23,27)));
        this.setCapacityTotalMemoryAudit(Double.parseDouble(trama.substring(27,31)));
        this.setDisponyCapacityMemoryAudit(Double.parseDouble(trama.substring(31,35)));
        this.setNumberDocumentRegisters(Integer.parseInt(trama.substring(35,41)));
        }
        
    }
     /** Retorna el RIF de fiscalización de la impresora fiscal*/
    public String getRIF() {
        return RIF;
    }
    /** Retorna el numero de registro o serial  de la impresora fiscal*/
    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }
    /** Retorna el numero correspondiente a la memoria de auditoría en la impresora fiscal*/
    public int getNumberMemoryAudit() {
        return numberMemoryAudit;
    }
    /** Retorna la capacidad total en MB de la memoria de auditoria*/
    public double getCapacityTotalMemoryAudit() {
        return capacityTotalMemoryAudit;
    }
    /** Retorna la disponibilidad de espacio en MB de la memoria de auditoria*/
    public double getDisponyCapacityMemoryAudit() {
        return disponyCapacityMemoryAudit;
    }
    /** Retorna la cantidad de documento registrado en la memoria de auditoria*/
    public int getNumberDocumentRegisters() {
        return numberDocumentRegisters;
    }

    private void setRIF(String RIF) {
        this.RIF = RIF;
    }

    private void setRegisteredMachineNumber(String registeredMachineNumber) {
        this.registeredMachineNumber = registeredMachineNumber;
    }

    private void setNumberMemoryAudit(int numberMemoryAudit) {
        this.numberMemoryAudit = numberMemoryAudit;
    }

    private void setCapacityTotalMemoryAudit(double capacityTotalMemoryAudit) {
        this.capacityTotalMemoryAudit = capacityTotalMemoryAudit;
    }

    private void setDisponyCapacityMemoryAudit(double disponyCapacityMemoryAudit) {
        this.disponyCapacityMemoryAudit = disponyCapacityMemoryAudit;
    }

    private void setNumberDocumentRegisters(int numberDocumentRegisters) {
        this.numberDocumentRegisters = numberDocumentRegisters;
    }
    
}
