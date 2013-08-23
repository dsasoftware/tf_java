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
    private int numberMemoryAudit;
    private double capacityTotalMemoryAudit;
    private double disponyCapacityMemoryAudit;
    private int numberDocumentRegisters;
    
     /** Creates a new instance of S5PrinterData
     *@param trama Cadena de caracteres ASCII que contiene datos del S5 de la impresora fiscal subidos al PC
     */
    public S5PrinterData(String trama)
    {
        if (trama != null && trama.length() >= 55)
        {
        this.setRIF(trama.substring(2,22));
        this.setDV(trama.substring(22,24));
        this.setRegisteredMachineNumber(trama.substring(24,37));
        this.setNumberMemoryAudit(Integer.parseInt(trama.substring(37,41)));
        this.setCapacityTotalMemoryAudit(Double.parseDouble(trama.substring(41,45)));
        this.setDisponyCapacityMemoryAudit(Double.parseDouble(trama.substring(45,49)));
        this.setNumberDocumentRegisters(Integer.parseInt(trama.substring(49,55)));
        }
        
    }
     /** Retorna el RIF de fiscalizaci�n de la impresora fiscal*/
    public String getRUC() {
        return RIF;
    }
    /**
     * Retorna el DV de la razón social de fiscalización de la impresora fiscal
    **/
       public String getDV()
       {
           return DV;
       }
    /** Retorna el numero de registro o serial  de la impresora fiscal*/
    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }
    /** Retorna el numero correspondiente a la memoria de auditor�a en la impresora fiscal*/
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

      private void setDV(String dv) {
        this.DV = dv;
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
