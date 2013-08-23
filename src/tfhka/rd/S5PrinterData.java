/*
 * S5PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.rd;

/**
 *
 * @author The Factory
 */
public class S5PrinterData {
    private String RNC;
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
         if (trama != null)
            {
                if (trama.length() > 0)
                {
                    try
                    {
                        String[] arrayParameter = trama.split(String.valueOf((char)0X0A));
                        if (arrayParameter.length >= 6)
                        {
                            this.setRNC(arrayParameter[0].substring(2));
                            this.setRegisteredMachineNumber(arrayParameter[1]);
                            this.setNumberMemoryAudit(Integer.parseInt(arrayParameter[2]));
                            this.setCapacityTotalMemoryAudit(this.doValueDecimal(arrayParameter[3]));
                            this.setDisponyCapacityMemoryAudit(this.doValueDecimal(arrayParameter[4]));
                            this.setNumberDocumentRegisters(Integer.parseInt(arrayParameter[5]));
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
     /** Retorna el RNC de fiscalización de la impresora fiscal*/
    public String getRNC() {
        return RNC;
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

    private void setRNC(String RNC) {
        this.RNC = RNC;
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
