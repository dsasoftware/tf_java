/*
 * S5PrinterData.java
 *
 * Created on 4 de junio de 2009, 07:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tfhka.cw;

/**
 *
 * @author The Factory
 */
public class S5PrinterData {
	    private String RNC;
	    private String registeredMachineNumber;
	    private int AuditMemoryNumber;
	    private double auditMemoryTotalCapacity;
	    private double AuditMemoryFreeCapacity;
	    private int numberRegisteredDocuments;
	    
	     /** Creates a new instance of S5PrinterData
	     *@param trama Cadena de caracteres ASCII que contiene datos del S5 de la impresora fiscal subidos al PC
	     */
		public S5PrinterData(String trama) {
			if (trama != null) {
				if (trama.length() > 0) {
					try {
					String[] arrayParameter = trama.split(String
							.valueOf((char) 0X0A));
					if (arrayParameter.length >= 6) {
						this.setRNC(arrayParameter[0].substring(2));
						this.setRegisteredMachineNumber(arrayParameter[1]);
						this.setAuditMemoryNumber(Integer
								.parseInt(arrayParameter[2]));
						this.setAuditMemoryTotalCapacity(this
								.doValueDecimal(arrayParameter[3]));
						this.setAuditMemoryFreeCapacity(this
								.doValueDecimal(arrayParameter[4]));
						this.setNumberRegisteredDocuments(Integer
								.parseInt(arrayParameter[5]));
					}
				}
				 catch (ArrayIndexOutOfBoundsException are) {
									return;
								} catch (NumberFormatException nfexp) {
									return;
								} catch (StringIndexOutOfBoundsException sfexp) {
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

	    /** Retorna la cantidad de documento registrado en la memoria de auditoria*/
	
	    public int getAuditMemoryNumber() {
			return AuditMemoryNumber;
		}
		public void setAuditMemoryNumber(int auditMemoryNumber) {
			AuditMemoryNumber = auditMemoryNumber;
		}
		public double getAuditMemoryTotalCapacity() {
			return auditMemoryTotalCapacity;
		}
		public void setAuditMemoryTotalCapacity(double auditMemoryTotalCapacity) {
			this.auditMemoryTotalCapacity = auditMemoryTotalCapacity;
		}
		public double getAuditMemoryFreeCapacity() {
			return AuditMemoryFreeCapacity;
		}
		public void setAuditMemoryFreeCapacity(double auditMemoryFreeCapacity) {
			AuditMemoryFreeCapacity = auditMemoryFreeCapacity;
		}
		public int getNumberRegisteredDocuments() {
			return numberRegisteredDocuments;
		}
		public void setNumberRegisteredDocuments(int numberRegisteredDocuments) {
			this.numberRegisteredDocuments = numberRegisteredDocuments;
		}
		private void setRNC(String RNC) {
	        this.RNC = RNC;
	    }
	
	    private void setRegisteredMachineNumber(String registeredMachineNumber) {
	        this.registeredMachineNumber = registeredMachineNumber;
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
