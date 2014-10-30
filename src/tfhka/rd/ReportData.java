package tfhka.rd;

import java.util.Date;
import java.util.GregorianCalendar;
import tfhka._private.Format;

/**
 * Representa una estructura para almacenar los datos de los reportes X y Z
 */
public class ReportData {
    
     public BasicInfoClass BasicInfo;
     public InvoicesAccumulatedClass InvoicesAccumulated;
     public CreditNotesAccumulatedClass CreditNotesAccumulated;
     public OtherAccumulatedClass OtherAccumulated;
    
    // <editor-fold defaultstate="collapsed" desc="BasicInfoClass">
      public static class BasicInfoClass
      {
	// region Variables Globales
	
		private int numberOfLastZReport;
		private Date ZReportDate;
		private int numberOfLastTransaction;
		private Date lastTransactionDate; // (includes the hour)
		private int numberOfLastNonFiscal;
		private int amountInvoiceCanceled;
		private int amountDocumentsSale;
		private int amountDocumentsNoSale;
		private int totalTechnicalInterventions;
                
                	// endregion
		// region Propiedades
		// / <summary>
		// / Retorna el n�mero del ultimo reporte Z efectuado.
		// / </summary>
		
		public int getNumberOfLastZReport() {
			return numberOfLastZReport;
		}
	
		// / <summary>
		// / Retorna la fecha del ultimo reporte Z efectuado.
		// / </summary>
		public Date getZReportDate() {
			return ZReportDate;
		}
	
		// / <summary>
		// / Retorna el n�mero de la ultima factura emitida.
		// / </summary>
		public int getNumberOfLastTransaction() {
			return numberOfLastTransaction;
		}
	
		// / <summary>
		// / Retorna la fecha y la hora de la ultima transaccion emitida.
		// / </summary>
		public Date getLastTransactionDate() {
			return lastTransactionDate;
		}
                
                // / <summary>
		// / Retorna el n�mero del �ltimo Documento No Fiscal.
		// / </summary>
		public int getNumberOfLastNonFiscal() {
			return numberOfLastNonFiscal;
		}
	
		// / <summary>
		// / Retorna el n�mero de facturas canceladas.
		// / </summary>
		public int getAmountInvoiceCanceled() {
			return amountInvoiceCanceled;
		}
	
		// / <summary>
		// / Retorna la cantidad de documentos de venta.
		// / </summary>
		public int getAmountDocumentsSale() {
			return amountDocumentsSale;
		}
	
		// / <summary>
		// / Retorna la cantidad de documentos de no venta.
		// / </summary>
		public int getAmountDocumentsNoSale() {
			return amountDocumentsNoSale;
		}
                
                // / <summary>
		// / Retorna la Cantidad de intervenciones t�cnicas.
		// / </summary>
		public int getTotalTechnicalInterventions() {
			return totalTechnicalInterventions;
		}
                	// region Constructor
	// / <summary>
	// / Creates a new instance of ReportData
	// / </summary>
	// / <param name="trama">Cadena de caracteres que contiene la data de
	// reportes</param>
	public BasicInfoClass(String trama) { 
		if (trama != null) {
			if (trama.length() > 0) // 344 DT230
			{
				try {
					String[] arrayParameter = trama.split(String.valueOf((char) 0X0A));
					if (arrayParameter.length > 1) {
						this.numberOfLastZReport = Integer.parseInt(arrayParameter[0]);
						int y = Integer.parseInt(arrayParameter[1].substring(0,2));
						int m = Integer.parseInt(arrayParameter[1].substring(2,4));
						int d = Integer.parseInt(arrayParameter[1].substring(4,6));
						int hh = Integer.parseInt(arrayParameter[2].substring(0, 2));
						int min = Integer.parseInt(arrayParameter[2].substring(2, 4));

						if (m == 0 && d == 0 && y == 0) {
							m = 1;
							d = 1;
							y = 1;
							hh = 0;
							min = 0;
						}

						// Date cal = new Date(y, m, d, hh, min, 0);
						GregorianCalendar cal = new GregorianCalendar();
						cal.set(y + 2000, m - 1, d, hh, min, 0);

						this.ZReportDate = cal.getTime();
						this.numberOfLastTransaction = Integer.parseInt(arrayParameter[3]);

						y = Integer.parseInt(arrayParameter[4].substring(0, 2)) /*+ 2000*/;
						m = Integer.parseInt(arrayParameter[4].substring(2, 4));
						d = Integer.parseInt(arrayParameter[4].substring(4, 6));

						hh = Integer.parseInt(arrayParameter[5].substring(0, 2));
						min = Integer.parseInt(arrayParameter[5].substring(2, 4));

						if (m == 0 && d == 0 && y == 0) {
							m = 1;
							d = 1;
							y = 1;

						}
						cal.set(y + 2000, m - 1, d, hh, min, 0);

						this.lastTransactionDate = cal.getTime();
						this.numberOfLastNonFiscal = Integer
								.parseInt(arrayParameter[6]);
						this.amountInvoiceCanceled = Integer
								.parseInt(arrayParameter[7]);
						this.amountDocumentsSale = Integer
								.parseInt(arrayParameter[8]);
						this.amountDocumentsNoSale = Integer
								.parseInt(arrayParameter[9]);
						this.totalTechnicalInterventions = 
								Integer.parseInt(arrayParameter[10]);

					}
				} catch (ArrayIndexOutOfBoundsException aexp) {
					return;
				} catch (NumberFormatException nfexp) {
					return;
				}catch (StringIndexOutOfBoundsException nfexp) {
					return;
				}

			}
		}
	}
      }
    // </editor-fold>
      
    // <editor-fold defaultstate="collapsed" desc="InvoicesAccumulatedClass">
      public static class InvoicesAccumulatedClass
      {
		private double totalInvoiceFinalClient; // Facturas para Consumidor Final
		private double tax4InvoiceFinalClient;
		private double tax1InvoiceFinalClient;
		private double tax5InvoiceFinalClient;
		private double tax2InvoiceFinalClient;
		private double tax3InvoiceFinalClient;
		private double totalHomeOperationInvoiceFinalClient;
                
		private double totalInvoiceFiscalCredit; // Factura con Credito Fiscal
		private double tax4InvoiceFiscalCredit;
		private double tax1InvoiceFiscalCredit;
		private double tax5InvoiceFiscalCredit;
		private double tax2InvoiceFiscalCredit;
		private double tax3InvoiceFiscalCredit;
		private double totalHomeOperationInvoiceFiscalCredit;
                
                // / <summary>
		// / Retorna el monto total de Factura para Consumidor Final almacenado.
		// / </summary>
		public double getTotalInvoiceFinalClient() {
			return totalInvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 4 de Factura para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTax4InvoiceFinalClient() {
			return tax4InvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 1 de Factura para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTax1InvoiceFinalClient() {
			return tax1InvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 5 de Factura para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTax5InvoiceFinalClient() {
			return tax5InvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 2 de Factura para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTax2InvoiceFinalClient() {
			return tax2InvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 3 de Factura para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTax3InvoiceFinalClient() {
			return tax3InvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de Factura con Credito Fiscal almacenado.
		// / </summary>
		public double getTotalInvoiceFiscalCredit() {
			return totalInvoiceFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 4 de Factura con credito Fiscal
		// almacenado.
		// / </summary>
		public double getTax4InvoiceFiscalCredit() {
			return tax4InvoiceFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 1 de Factura con credito Fiscal
		// almacenado.
		// / </summary>
		public double getTax1InvoiceFiscalCredit() {
			return tax1InvoiceFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 5 de Factura con credito Fiscal
		// almacenado.
		// / </summary>
		public double getTax5InvoiceFiscalCredit() {
			return tax5InvoiceFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 2 de Factura con credito Fiscal
		// almacenado.
		// / </summary>
	
		public double getTax2InvoiceFiscalCredit() {
			return tax2InvoiceFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 3 de Factura con credito Fiscal
		// almacenado.
		// / </summary>
		public double getTax3InvoiceFiscalCredit() {
			return tax3InvoiceFiscalCredit;
		}
                
                // / <summary>
		// / Retorna el Total desde inicio de Operaci�n de facturas consumidor
		// final.
		// / </summary>
		public double getTotalHomeOperationInvoiceFinalClient() {
			return totalHomeOperationInvoiceFinalClient;
		}
	
		// / <summary>
		// / Retorna el Total desde inicio de Operaci�n de facturas cr�dito fiscal.
		// / </summary>
		public double getTotalHomeOperationInvoiceFiscalCredit() {
			return totalHomeOperationInvoiceFiscalCredit;
		}
                
                public InvoicesAccumulatedClass(String trama) {  
		if (trama != null) {
			if (trama.length() > 0) {
				try {
					String[] arrayParameter = trama.split(String
							.valueOf((char) 0X0A));
					if (arrayParameter.length > 1) {

						this.totalInvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[0]);
						this.tax1InvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[1]);
						this.tax2InvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[2]);
						this.tax3InvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[3]);
						this.tax4InvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[4]);
						this.tax5InvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[5]);
						this.totalHomeOperationInvoiceFinalClient = Format.DOUBLE.formatValue(arrayParameter[6]);
						this.totalInvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[7]);
						this.tax1InvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[8]);
						this.tax2InvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[9]);
						this.tax3InvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[10]);
						this.tax4InvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[11]);
						this.tax5InvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[12]);
						this.totalHomeOperationInvoiceFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[13]);

					}
				} catch (ArrayIndexOutOfBoundsException aexp) {
					return;
				} catch (NumberFormatException nfexp) {
					return;
				}

			}

		}
	}
      
      }
         
      // </editor-fold>
  
    // <editor-fold defaultstate="collapsed" desc="CreditNotesAccumulatedClass">	
    public static class CreditNotesAccumulatedClass
      {
                private double totalCreditNoteFinalClient; // Notas de Credito para													// Consumidor Final
		private double tax4CreditNoteFinalClient;
		private double tax1CreditNoteFinalClient;
		private double tax5CreditNoteFinalClient;
		private double tax2CreditNoteFinalClient;
		private double tax3CreditNoteFinalClient;
		private double totalHomeOperationCreditNoteFinalClient;
                
		private double totalCreditNoteFiscalCredit; // Notas de Credito con credito													// Fiscal
		private double tax1CreditNoteFiscalCredit;
		private double tax2CreditNoteFiscalCredit;
		private double tax3CreditNoteFiscalCredit;
		private double tax4CreditNoteFiscalCredit;
		private double tax5CreditNoteFiscalCredit;
		private double totalHomeOperationCreditNoteFiscalCredit;
                
                // / <summary>
		// / Retorna el monto total de Nota de Credito con credito Fiscal
		// almacenado.
		// / </summary>
		public double getTotalCreditNoteFiscalCredit() {
			return totalCreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 1 de la Nota de Credito con credito
		// Fiscal almacenado.
		// / </summary>
		public double getTax1CreditNoteFiscalCredit() {
			return tax1CreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 2 de la Nota de Credito con credito
		// Fiscal almacenado.
		// / </summary>
		public double getTax2CreditNoteFiscalCredit() {
			return tax2CreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 3 de la Nota de Credito con credito
		// Fiscal almacenado.
		// / </summary>
		public double getTax3CreditNoteFiscalCredit() {
			return tax3CreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 4 de la Nota de Credito con credito
		// Fiscal almacenado.
		// / </summary>
		public double getTax4CreditNoteFiscalCredit() {
			return tax4CreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 5 de la Nota de Credito con credito
		// Fiscal almacenado.
		// / </summary>
		public double getTax5CreditNoteFiscalCredit() {
			return tax5CreditNoteFiscalCredit;
		}
	
		// / <summary>
		// / Retorna el monto total de Nota de Credito para Consumidor Final
		// almacenado.
		// / </summary>
		public double getTotalCreditNoteFinalClient() {
			return totalCreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 1 de la Nota de Credito para
		// Consumidor Final almacenado.
		// / </summary>
		public double getTax1CreditNoteFinalClient() {
			return tax1CreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 2 de la Nota de Credito para
		// Consumidor Final almacenado.
		// / </summary>
		public double getTax2CreditNoteFinalClient() {
			return tax2CreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 3 de la Nota de Credito para
		// Consumidor Final almacenado.
		// / </summary>
		public double getTax3CreditNoteFinalClient() {
			return tax3CreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 4 de la Nota de Credito para
		// Consumidor Final almacenado.
		// / </summary>
		public double getTax4CreditNoteFinalClient() {
			return tax4CreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el monto total de impuesto 5 de la Nota de Credito para
		// Consumidor Final almacenado.
		// / </summary>
		public double getTax5CreditNoteFinalClient() {
			return tax5CreditNoteFinalClient;
	
		}		
	
		// / <summary>
		// / Retorna el Total desde inicio de Operaci�n de notas de cr�dito
		// consumidor final.
		// / </summary>
		public double getTotalHomeOperationCreditNoteFinalClient() {
			return totalHomeOperationCreditNoteFinalClient;
		}
	
		// / <summary>
		// / Retorna el Total desde inicio de Operaci�n de notas de cr�dito para
		// cr�dito fiscal.
		// / </summary>
		public double getTotalHomeOperationCreditNoteFiscalCredit() {
			return totalHomeOperationCreditNoteFiscalCredit;
		}
                
                public CreditNotesAccumulatedClass(String trama) {  
		if (trama != null) {
			if (trama.length() > 0) {
				try {
					String[] arrayParameter = trama.split(String
							.valueOf((char) 0X0A));
					if (arrayParameter.length > 1) {

						this.totalCreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[0]);
						this.tax1CreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[1]);
						this.tax2CreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[2]);
						this.tax3CreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[3]);
						this.tax4CreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[4]);
						this.tax5CreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[5]);
						this.totalHomeOperationCreditNoteFinalClient = Format.DOUBLE.formatValue(arrayParameter[6]);
						this.totalCreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[7]);
						this.tax1CreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[8]);
						this.tax2CreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[9]);
						this.tax3CreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[10]);
						this.tax4CreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[11]);
						this.tax5CreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[12]);
						this.totalHomeOperationCreditNoteFiscalCredit = Format.DOUBLE.formatValue(arrayParameter[13]);

					}
				} catch (ArrayIndexOutOfBoundsException aexp) {
					return;
				} catch (NumberFormatException nfexp) {
					return;
				}

			}

		}
	}

    }
     // </editor-fold>	
	
    // <editor-fold defaultstate="collapsed" desc="OtherAccumulatedClass">
    public static class OtherAccumulatedClass{
        
                private double exonerationItbis;
		private double exonerationItbisCreditnote;
		private double vouchersCanceled;
		private double itemsRepayment;
		private double itemsDiscount;
		private double itemsSurcharge;
		private double subtotalDiscount;
		private double subtotalSurcharge;
		private double totalMeansPayment1;
		private double totalMeansPayment2;
		private double totalMeansPayment3;
		private double totalMeansPayment4;
		private double totalMeansPayment5;
		private double totalMeansPayment6;
		private double totalMeansPayment7;
		private double totalMeansPayment8;
		private double totalMeansPayment9;
		private double totalMeansPayment10;
		private double totalMeansPaymentCreditnote;
		private double totalDonations;			
		// / <summary>
		// / Retorna la Exoneraci�n ITBIS.
		// / </summary>
		public double getExonerationItbis() {
			return exonerationItbis;
		}
	
		// / <summary>
		// / Retorna las notas de credito de Exoneraci�n ITBIS.
		// / </summary>
		public double getExonerationItbisCreditnote() {
			return exonerationItbisCreditnote;
		}
	
		// / <summary>
		// / Retorna los Comprobantes cancelados.
		// / </summary>
		public double getVouchersCanceled() {
			return vouchersCanceled;
		}
	
		// / <summary>
		// / Retorna las Devoluciones de items.
		// / </summary>
		public double getItemsRepayment() {
			return itemsRepayment;
		}
	
		// / <summary>
		// / Retorna los Descuentos sobre �tems.
		// / </summary>
		public double getItemsDiscount() {
			return itemsDiscount;
		}
	
		// / <summary>
		// / Retorna los Recargos sobre �tems.
		// / </summary>
		public double getItemsSurcharge() {
			return itemsSurcharge;
		}
	
		// / <summary>
		// / Retorna los Descuentos a subtotal.
		// / </summary>
		public double getSubtotalDiscount() {
			return subtotalDiscount;
		}
	
		// / <summary>
		// / Retorna los Recargos a subtotal.
		// / </summary>
		public double getSubtotalSurcharge() {
			return subtotalSurcharge;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (1).
		// / </summary>
		public double getTotalMeansPayment1() {
			return totalMeansPayment1;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (2).
		// / </summary>
		public double getTotalMeansPayment2() {
			return totalMeansPayment2;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (3).
		// / </summary>
		public double getTotalMeansPayment3() {
			return totalMeansPayment3;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (4).
		// / </summary>
		public double getTotalMeansPayment4() {
			return totalMeansPayment4;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (5).
		// / </summary>
		public double getTotalMeansPayment5() {
			return totalMeansPayment5;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (6).
		// / </summary>
		public double getTotalMeansPayment6() {
			return totalMeansPayment6;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (7).
		// / </summary>
		public double getTotalMeansPayment7() {
			return totalMeansPayment7;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (8).
		// / </summary>
		public double getTotalMeansPayment8() {
			return totalMeansPayment8;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (9).
		// / </summary>
		public double getTotalMeansPayment9() {
			return totalMeansPayment9;
		}
	
		// / <summary>
		// / Retorna el Total de medio de pago (10).
		// / </summary>
		public double getTotalMeansPayment10() {
			return totalMeansPayment10;
		}
	
		// / <summary>
		// / Retorna el Total medio de pago Nota de Cr�dito.
		// / </summary>
		public double getTotalMeansPaymentCreditnote() {
			return totalMeansPaymentCreditnote;
		}
	
		// / <summary>
		// / Retorna el Total Donaciones.
		// / </summary>
		public double getTotalDonations() {
			return totalDonations;
		}		
	
		// end region.

	public OtherAccumulatedClass(String trama) { 
		if (trama != null) {
			if (trama.length() > 0) {
				try {
					String[] arrayParameter = trama.split(String
							.valueOf((char) 0X0A));
					if (arrayParameter.length > 1) {

						this.exonerationItbis = Format.DOUBLE.formatValue(arrayParameter[0]);
						this.exonerationItbisCreditnote = Format.DOUBLE.formatValue(arrayParameter[1]);
						this.vouchersCanceled = Format.DOUBLE.formatValue(arrayParameter[2]);
						this.itemsRepayment = Format.DOUBLE.formatValue(arrayParameter[3]);
						this.itemsDiscount = Format.DOUBLE.formatValue(arrayParameter[4]);
						this.itemsSurcharge = Format.DOUBLE.formatValue(arrayParameter[5]);
						this.subtotalDiscount = Format.DOUBLE.formatValue(arrayParameter[6]);
						this.subtotalSurcharge = Format.DOUBLE.formatValue(arrayParameter[7]);
						this.totalMeansPayment1 = Format.DOUBLE.formatValue(arrayParameter[8]);
						this.totalMeansPayment2 = Format.DOUBLE.formatValue(arrayParameter[9]);
						this.totalMeansPayment3 = Format.DOUBLE.formatValue(arrayParameter[10]);
						this.totalMeansPayment4 = Format.DOUBLE.formatValue(arrayParameter[11]);
						this.totalMeansPayment5 = Format.DOUBLE.formatValue(arrayParameter[12]);
						this.totalMeansPayment6 = Format.DOUBLE.formatValue(arrayParameter[13]);
						this.totalMeansPayment7 = Format.DOUBLE.formatValue(arrayParameter[14]);
						this.totalMeansPayment8 = Format.DOUBLE.formatValue(arrayParameter[15]);
						this.totalMeansPayment9 = Format.DOUBLE.formatValue(arrayParameter[16]);
						this.totalMeansPayment10 = Format.DOUBLE.formatValue(arrayParameter[17]);
						this.totalMeansPaymentCreditnote = Format.DOUBLE.formatValue(arrayParameter[18]);
						this.totalDonations = Format.DOUBLE.formatValue(arrayParameter[19]);
					}
				} catch (ArrayIndexOutOfBoundsException aexp) {
					return;
				} catch (NumberFormatException nfexp) {
					return;
				}

			}

		}
	}
    }
    // </editor-fold>
   
                private int part1 = 1;
		private int part2 = 2;
		private int part3 = 3;
		private int part4 = 4;

	public void ReportDataArray(String trama) {
		if (trama != null) {
			if (trama.length() > 0) // 344 DT230
			{
				String[] arrayParameter = trama.split(String.valueOf((char) 0X0A));

				if (arrayParameter.length > 1) {
					if (Integer.parseInt(arrayParameter[0]) == this.part1) {
						this.BasicInfo = new ReportData.BasicInfoClass(trama);
					} else if (Integer.parseInt(arrayParameter[1]) == this.part2) {
						this.InvoicesAccumulated = new ReportData.InvoicesAccumulatedClass(trama);
					} else if (Integer.parseInt(arrayParameter[2]) == this.part3) {
						this.CreditNotesAccumulated = new ReportData.CreditNotesAccumulatedClass(trama);
					} else if (Integer.parseInt(arrayParameter[3]) == this.part4) {
						this.OtherAccumulated = new OtherAccumulatedClass(trama); 
					}

				}

			}

		}
	}

}