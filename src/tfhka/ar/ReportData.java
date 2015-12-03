package tfhka.ar;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar; 
import java.util.List;
/** 
* Representa una estructura para almacenar los datos de los reportes X y Z
*/ 
public class ReportData {
	  /* Creates a new instance of ReportX 
     *@param trama cadena de caracteres que contiene la data de reportes
     */
    public ReportData(String pTrama1, String pTrama2, String pTrama3, String pTrama4, String pTrama5, String pTrama6, String pTrama7, String pTrama8, String pTrama9, String pTrama10, String pTrama11)
    {
     
    }  
    public static class FirstPackageClass{
            public int packageNumber ;
            public int zReportNumber ;
            public Date lastZReportDateTime ;
            public int lastTicketNumber ;
            public int lastTicketInvoiceANumber ;
            public int lastTicketInvoiceBNumber ;
            public int lastTicketInvoiceCNumber ;
            public int lastTicketInvoiceDNumber ;
            public int lastTicketInvoiceMNumber ;
            //
            public int lastCreditNoteNumber ;
            public int lastCreditNoteANumber ;
            public int lastCreditNoteBNumber ;
            public int lastCreditNoteCNumber ;
            public int lastCreditNoteMNumber ;
            //
            public int lastDebitNoteANumber ;
            public int lastDebitNoteBNumber ;
            public int lastDebitNoteCNumber ;
            public int lastDebitNoteMNumber ;
            //
            public int lastReceiptANumber ;
            public int lastReceiptBNumber ;
            public int lastReceiptCNumber ;
            public int lastReceiptMNumber ;
            //
            public Date lastFiscalDocumentDate ;
            public Date lastFiscalDocumentTime ;
            //
            public int lastDNFHDateNumber  ;
            public int lastDNFHCancelationNumber ;
            public int lastDNFHCreditOrDebitCardNumber ;
            public int lastDNFHTicketRomotionalRaffleStubNumber ;
            public int lastDNFHPharmacyNumber ;
            public int lastDNFHParkingRaffleStubNumber ;
            public int lastDNFHDeliveryRaffleStubNumber ;
            public int lastDNFHJournalReportNumber ;
            public int lastDNFHServicePaymentRaffleStubNumber ;
            public int lastDNFHCreditNoteNumber ;
            public int lastDNFHReportCounterNumber;
            public int lastDNFHGenericDocument ;
            /*
          public FirstPackageClass(String pTrama) 
            {
                if (pTrama != null)
                {
                    try
                    {
                        int index = 0;

                        String[] arrayParameter = pTrama.split("" + (char)0X0A);
                        if (arrayParameter.length > 1)
                        {
                            
                            this.zReportNumber = int.Parse(arrayParameter[index]); index++;

                            int y = int.Parse(arrayParameter[index].Substring(0, 2)) + 2000;
                            int m = int.Parse(arrayParameter[index].Substring(2, 2));
                            int d = int.Parse(arrayParameter[index].Substring(4, 2)); index++;

                            int hh = int.Parse(arrayParameter[index].Substring(0, 2));
                            int min = int.Parse(arrayParameter[index].Substring(2, 2)); 

                            if (m == 0 && d == 0 && y == 2000)
                            {
                                m = 1;
                                d = 1;
                                y = 1;
                                hh = 0;
                                min = 0;
                            }

                            DateTime zDT = new DateTime(y, m, d, hh, min, 0);
                            this.lastZReportDateTime = zDT; index++;

                            this.lastTicketNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastTicketInvoiceANumber = int.Parse(arrayParameter[index]); index++;
                            this.lastTicketInvoiceBNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastTicketInvoiceCNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastTicketInvoiceDNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastTicketInvoiceMNumber = int.Parse(arrayParameter[index]); index++;

                            this.lastCreditNoteNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastCreditNoteANumber = int.Parse(arrayParameter[index]); index++;
                            this.lastCreditNoteBNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastCreditNoteCNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastCreditNoteMNumber = int.Parse(arrayParameter[index]); index++;

                            this.lastReceiptANumber = int.Parse(arrayParameter[index]); index++;
                            this.lastReceiptBNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastReceiptCNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastReceiptMNumber = int.Parse(arrayParameter[index]); index++;

                            int y2 = int.Parse(arrayParameter[index].Substring(0,2)) + 2000; 
                            int m2 = int.Parse(arrayParameter[index].Substring(2,2));
                            int d2 = int.Parse(arrayParameter[index].Substring(4, 2)); index++;

                            int hh2 = int.Parse(arrayParameter[index].Substring(0, 2));
                            int min2 = int.Parse(arrayParameter[index].Substring(2, 2));

                            if (y2 == 2000 && m2 == 0 && d2 == 0)
	                        {
		                        m2 = 1;
                                d2 = 1;
                                y2 = 1;
                                hh2 = 0; 
                                min2 =0;
	                        }

                            DateTime fdDT = new DateTime(y2, m2, d2, hh2, min2, 0);
                            this.lastFiscalDocumentDate = fdDT; index++;

                            this.lastDNFHCancelationNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHCreditOrDebitCardNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHTicketRomotionalRaffleStubNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHPharmacyNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHParkingRaffleStubNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHDeliveryRaffleStubNumber = int.Parse(arrayParameter[index]); ; index++;
                            this.lastDNFHJournalReportNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHServicePaymentRaffleStubNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHCreditNoteNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHReportCounterNumber = int.Parse(arrayParameter[index]); index++;
                            this.lastDNFHGenericDocument = int.Parse(arrayParameter[index]); index++;
                            

                        }
                    }
                    catch (Exception ex)
                    {
                      return;
                    } 
                }
                else
                {

                }


            }
}
*/
     public static class SecondPackageClass
        {
           // Propiedades
            //
            public int quantityCanceledTickets ;
            public int quantityCanceledTicketsA ;
            public int quantityCanceledTicketsB ;
            public int quantityCanceledTicketsC ;
            public int quantityCanceledTicketsM ;
            //
            public int quantityCanceledCreditNotes ;
            public int quantityCanceledCreditNotesA ;
            public int quantityCanceledCreditNotesB ;
            public int quantityCanceledCreditNotesC ;
            public int quantityCanceledCreditNotesM ;
            //
            public int quantityCanceledDebitNotesA ;
            public int quantityCanceledDebitNotesB ;
            public int quantityCanceledDebitNotesC ;
            public int quantityCanceledDebitNotesM ;
            //
            public int quantityCanceledReceiptA ;
            public int quantityCanceledReceiptB ;
            public int quantityCanceledReceiptC ;
            public int quantityCanceledReceiptM ;
            //
            public int quantityTickets ;
            public int quantityTicketsA ;
            public int quantityTicktesB ;
            public int quantityTicketsC ;
            public int quantityTicketsM ;
            //
            public int quantityCreditNotes ;
            public int quantityCreditNotesA ;
            public int quantityCreditNotesB ;
            public int quantityCreditNotesC ;
            public int quantityCreditNotesM ;
            //
            public int quantityDebitNotesA ;
            public int quantityDebitNotesB ;
            public int quantityDebitNotesC ;
            public int quantityDebitNotesM ;
            //
            public int quantityReceiptA ;
            public int quantityReceiptB ;
            public int quantityReceiptC ;
            public int quantityReceiptM ;
            //
            public int quantityDNFHDate ;
            public int quantityDNFHCancellation ;
            public int quantityDNFHCreditOrDebitCard ;
            public int quantityDNFHTicketRomotionalRaffleStub ;
            public int quantityDNFHPharmacy ;
            public int quantityDNFHParkingRaffleStub ;
            public int quantityDNFHDeliveryRaffleStub ;
            public int quantityDNFHJournalReport ;
            public int quantityDNFHServicePaymentRaffleStub ;
            public int quantityDNFHCreditNote ;
            public int quantityDNFHReportCounter;
            public int quantityDNFHGenericDocument ;
            //
            public int quantityTechnicalInterventions ;



           ////////

           // Constructor

            public SecondPackageClass(String pTrama) 
            {
                if (pTrama != null)
                {
                    try
                    {
                        String[] arrayParameter = pTrama.split("" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                       
                            List<Integer> lstFields = new ArrayList<Integer>();
                            //
                            lstFields.add(this.quantityCanceledTickets);
                            lstFields.add(this.quantityCanceledTicketsA);
                            lstFields.add(this.quantityCanceledTicketsB);
                            lstFields.add(this.quantityCanceledTicketsC);
                            lstFields.add(this.quantityCanceledTicketsM);
                            //
                            lstFields.add(this.quantityCanceledCreditNotes);
                            lstFields.add(this.quantityCanceledCreditNotesA);
                            lstFields.add(this.quantityCanceledCreditNotesB);
                            lstFields.add(this.quantityCanceledCreditNotesC);
                            lstFields.add(this.quantityCanceledCreditNotesM);
                            //
                            lstFields.add(this.quantityCanceledDebitNotesA);
                            lstFields.add(this.quantityCanceledDebitNotesB);
                            lstFields.add(this.quantityCanceledDebitNotesC);
                            lstFields.add(this.quantityCanceledDebitNotesM);
                            //
                            lstFields.add(this.quantityCanceledReceiptA);
                            lstFields.add(this.quantityCanceledReceiptB);
                            lstFields.add(this.quantityCanceledReceiptC);
                            lstFields.add(this.quantityCanceledReceiptM);
                            //
                            lstFields.add(this.quantityTickets);
                            lstFields.add(this.quantityTicketsA);
                            lstFields.add(this.quantityTicktesB);
                            lstFields.add(this.quantityTicketsC);
                            lstFields.add(this.quantityTicketsM);
                            //
                            lstFields.add(this.quantityCreditNotes);
                            lstFields.add(this.quantityCreditNotesA);
                            lstFields.add(this.quantityCreditNotesB);
                            lstFields.add(this.quantityCreditNotesC);
                            lstFields.add(this.quantityCreditNotesM);
                            //
                            lstFields.add(this.quantityDebitNotesA);
                            lstFields.add(this.quantityDebitNotesB);
                            lstFields.add(this.quantityDebitNotesC);
                            lstFields.add(this.quantityDebitNotesM);
                            //
                            lstFields.add(this.quantityReceiptA);
                            lstFields.add(this.quantityReceiptB);
                            lstFields.add(this.quantityReceiptC);
                            lstFields.add(this.quantityReceiptM);
                            //
                            lstFields.add(this.quantityDNFHDate);
                            lstFields.add(this.quantityDNFHCancellation);
                            lstFields.add(this.quantityDNFHCreditOrDebitCard);
                            lstFields.add(this.quantityDNFHTicketRomotionalRaffleStub);
                            lstFields.add(this.quantityDNFHPharmacy);
                            lstFields.add(this.quantityDNFHParkingRaffleStub);
                            lstFields.add(this.quantityDNFHDeliveryRaffleStub);
                            lstFields.add(this.quantityDNFHJournalReport);
                            lstFields.add(this.quantityDNFHServicePaymentRaffleStub);
                            lstFields.add(this.quantityDNFHCreditNote);
                            lstFields.add(this.quantityDNFHReportCounter);
                            lstFields.add(this.quantityDNFHGenericDocument);
                            //
                            lstFields.add(this.quantityTechnicalInterventions);
                             
            
                            for (int index = 0; index < lstFields.size(); index++)
                            {
                                lstFields.set(index, Integer.valueOf( arrayParameter[index]));
                            }
                        }
                    }
                    catch (Exception ex)
                    {
                     return;
                    }
                }
                else
                {

                }
            
            }

           ////////

        }

        public static class ThirdPackageClass
        {
           // Propiedades
            //
            public double ExemptTicket ;
            public double NotImposedTicket ;
            //
            public double TaxableIncome1 ;
            public double TicketTaxRate1 ;
            public double TaxableIncome2 ;
            public double TicketTaxRate2 ;
            public double TaxableIncome3 ;
            public double TicketTaxRate3 ;
            public double TaxableIncome4 ;
            public double TicketTaxRate4 ;
            public double TaxableIncome5 ;
            public double TicketTaxRate5 ;
            public double TaxableIncome6 ;
            public double TicketTaxRate6 ;
            public double TaxableIncome7 ;
            public double TicketTaxRate7 ;
            public double TaxableIncome8 ;
            public double TicketTaxRate8 ;
            public double TaxableIncome9 ;
            public double TicketTaxRate9 ;
            public double TaxableIncome10 ;
            public double TicketTaxRate10 ;
            //
            public double ExemptTicketInvoiceA ;
            public double NotImposedInvoiceA ;
            //
            public double TicketInvoiceATaxableIncome1 ;
            public double TicketinvoiceATaxRate1 ;
            public double TicketInvoiceATaxableIncome2 ;
            public double TicketinvoiceATaxRate2 ;
            public double TicketInvoiceATaxableIncome3 ;
            public double TicketinvoiceATaxRate3 ;
            public double TicketInvoiceATaxableIncome4 ;
            public double TicketinvoiceATaxRate4 ;
            public double TicketInvoiceATaxableIncome5 ;
            public double TicketinvoiceATaxRate5 ;
            public double TicketInvoiceATaxableIncome6 ;
            public double TicketinvoiceATaxRate6 ;
            public double TicketInvoiceATaxableIncome7 ;
            public double TicketinvoiceATaxRate7 ;
            public double TicketInvoiceATaxableIncome8 ;
            public double TicketinvoiceATaxRate8 ;
            public double TicketInvoiceATaxableIncome9 ;
            public double TicketinvoiceATaxRate9 ;
            public double TicketInvoiceATaxableIncome10 ;
            public double TicketinvoiceATaxRate10 ;
            //

           ////////

           // Constructor

            public ThirdPackageClass(String pTrama) 
            {
                if (true)
                {
                    try
                    {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptTicket);
                            lstFields.add(this.NotImposedTicket);
                            //
                            lstFields.add(this.TaxableIncome1);
                            lstFields.add(this.TicketTaxRate1);
                            lstFields.add(this.TaxableIncome2);
                            lstFields.add(this.TicketTaxRate2);
                            lstFields.add(this.TaxableIncome3);
                            lstFields.add(this.TicketTaxRate3);
                            lstFields.add(this.TaxableIncome4);
                            lstFields.add(this.TicketTaxRate4);
                            lstFields.add(this.TaxableIncome5);
                            lstFields.add(this.TicketTaxRate5);
                            lstFields.add(this.TaxableIncome6);
                            lstFields.add(this.TicketTaxRate6);
                            lstFields.add(this.TaxableIncome7);
                            lstFields.add(this.TicketTaxRate7);
                            lstFields.add(this.TaxableIncome8);
                            lstFields.add(this.TicketTaxRate8);
                            lstFields.add(this.TaxableIncome9);
                            lstFields.add(this.TicketTaxRate9);
                            lstFields.add(this.TaxableIncome10);
                            lstFields.add(this.TicketTaxRate10);
                            //
                            lstFields.add(this.ExemptTicketInvoiceA);
                            lstFields.add(this.NotImposedInvoiceA);
                            //
                            lstFields.add(this.TicketInvoiceATaxableIncome1);
                            lstFields.add(this.TicketinvoiceATaxRate1);
                            lstFields.add(this.TicketInvoiceATaxableIncome2);
                            lstFields.add(this.TicketinvoiceATaxRate2);
                            lstFields.add(this.TicketInvoiceATaxableIncome3);
                            lstFields.add(this.TicketinvoiceATaxRate3);
                            lstFields.add(this.TicketInvoiceATaxableIncome4);
                            lstFields.add(this.TaxableIncome4);
                            lstFields.add(this.TicketInvoiceATaxableIncome5);
                            lstFields.add(this.TaxableIncome5);
                            lstFields.add(this.TicketInvoiceATaxableIncome6);
                            lstFields.add(this.TaxableIncome6);
                            lstFields.add(this.TicketInvoiceATaxableIncome7);
                            lstFields.add(this.TaxableIncome7);
                            lstFields.add(this.TicketInvoiceATaxableIncome8);
                            lstFields.add(TaxableIncome8);
                            lstFields.add(this.TicketInvoiceATaxableIncome9);
                            lstFields.add(TaxableIncome9);
                            lstFields.add(this.TicketInvoiceATaxableIncome10);
                            lstFields.add(TaxableIncome10);


                            for (int index = 0; index < lstFields.size(); index++)
                            {
                                lstFields.set(index, Double.valueOf(arrayParameter[index]));
                            }

                        }
                    }
                    catch (Exception ex)
                    {
                        
                        return;
                    }
                }
                else
                {

                }
            }

           ////////
        }

        public static class FourthPackageClass
        {
           // Propiedades
            //
            public double ExemptTicketInvoiceB ;
            public double NotImposedTicketB ;
            //        
            public double TicketInvoiceBTaxableIncome1 ;
            public double TicketInvoiceBTaxRate1 ;
            public double TicketInvoiceBTaxableIncome2 ;
            public double TicketInvoiceBTaxRate2 ;
            public double TicketInvoiceBTaxableIncome3 ;
            public double TicketInvoiceBTaxRate3 ;
            public double TicketInvoiceBTaxableIncome4 ;
            public double TicketInvoiceBTaxRate4 ;
            public double TicketInvoiceBTaxableIncome5 ;
            public double TicketInvoiceBTaxRate5 ;
            public double TicketInvoiceBTaxableIncome6 ;
            public double TicketInvoiceBTaxRate6 ;
            public double TicketInvoiceBTaxableIncome7 ;
            public double TicketInvoiceBTaxRate7 ;
            public double TicketInvoiceBTaxableIncome8 ;
            public double TicketInvoiceBTaxRate8 ;
            public double TicketInvoiceBTaxableIncome9 ;
            public double TicketInvoiceBTaxRate9 ;
            public double TicketInvoiceBTaxableIncome10 ;
            public double TicketInvoiceBTaxRate10 ;
            //
            public double ExemptTicketInvoiceC ;
            public double NotImposedInvoiceC ;
            //
            public double TicketInvoiceCTaxableIncome1 ;
            public double TicketInvoiceCTaxRate1 ;
            public double TicketInvoiceCTaxableIncome2 ;
            public double TicketInvoiceCTaxRate2 ;
            public double TicketInvoiceCTaxableIncome3 ;
            public double TicketInvoiceCTaxRate3 ;
            public double TicketInvoiceCTaxableIncome4 ;
            public double TicketInvoiceCTaxRate4 ;
            public double TicketInvoiceCTaxableIncome5 ;
            public double TicketInvoiceCTaxRate5 ;
            public double TicketInvoiceCTaxableIncome6 ;
            public double TicketInvoiceCTaxRate6 ;
            public double TicketInvoiceCTaxableIncome7 ;
            public double TicketInvoiceCTaxRate7 ;
            public double TicketInvoiceCTaxableIncome8 ;
            public double TicketInvoiceCTaxRate8 ;
            public double TicketInvoiceCTaxableIncome9 ;
            public double TicketInvoiceCTaxRate9 ;
            public double TicketInvoiceCTaxableIncome10 ;
            public double TicketInvoiceCTaxRate10 ;
            //
           ////////

           // Constructor

            public FourthPackageClass(String pTrama) 
            {
                if (true)
                {
                    try
                    {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptTicketInvoiceB);
                            lstFields.add(this.NotImposedTicketB);
                            //
                            lstFields.add(this.TicketInvoiceBTaxableIncome1);
                            lstFields.add(this.TicketInvoiceBTaxRate1);
                            lstFields.add(this.TicketInvoiceBTaxableIncome2);
                            lstFields.add(this.TicketInvoiceBTaxRate2);
                            lstFields.add(this.TicketInvoiceBTaxableIncome3);
                            lstFields.add(this.TicketInvoiceBTaxRate3);
                            lstFields.add(this.TicketInvoiceBTaxableIncome4);
                            lstFields.add(this.TicketInvoiceBTaxRate4);
                            lstFields.add(this.TicketInvoiceBTaxableIncome5);
                            lstFields.add(this.TicketInvoiceBTaxRate5);
                            lstFields.add(this.TicketInvoiceBTaxableIncome6);
                            lstFields.add(this.TicketInvoiceBTaxRate6);
                            lstFields.add(this.TicketInvoiceBTaxableIncome7);
                            lstFields.add(this.TicketInvoiceBTaxRate7);
                            lstFields.add(this.TicketInvoiceBTaxableIncome8);
                            lstFields.add(this.TicketInvoiceBTaxRate8);
                            lstFields.add(this.TicketInvoiceBTaxableIncome9);
                            lstFields.add(this.TicketInvoiceBTaxRate9);
                            lstFields.add(this.TicketInvoiceBTaxableIncome10);
                            lstFields.add(this.TicketInvoiceBTaxRate10);
                            //
                            lstFields.add(this.ExemptTicketInvoiceC);
                            lstFields.add(this.NotImposedInvoiceC);
                            //
                            lstFields.add(this.TicketInvoiceCTaxableIncome1);
                            lstFields.add(this.TicketInvoiceCTaxRate1);
                            lstFields.add(this.TicketInvoiceCTaxableIncome2);
                            lstFields.add(this.TicketInvoiceCTaxRate2);
                            lstFields.add(this.TicketInvoiceCTaxableIncome3);
                            lstFields.add(this.TicketInvoiceCTaxRate3);
                            lstFields.add(this.TicketInvoiceCTaxableIncome4);
                            lstFields.add(this.TicketInvoiceCTaxRate4);
                            lstFields.add(this.TicketInvoiceCTaxableIncome5);
                            lstFields.add(this.TicketInvoiceCTaxRate5);
                            lstFields.add(this.TicketInvoiceCTaxableIncome6);
                            lstFields.add(this.TicketInvoiceCTaxRate6);
                            lstFields.add(this.TicketInvoiceCTaxableIncome7);
                            lstFields.add(this.TicketInvoiceCTaxRate7);
                            lstFields.add(this.TicketInvoiceCTaxableIncome8);
                            lstFields.add(this.TicketInvoiceCTaxRate8);
                            lstFields.add(this.TicketInvoiceCTaxableIncome9);
                            lstFields.add(this.TicketInvoiceCTaxRate9);
                            lstFields.add(this.TicketInvoiceCTaxableIncome10);
                            lstFields.add(this.TicketInvoiceCTaxRate10);


                            for (int index = 0; index < lstFields.size(); index++)
                            {
                                lstFields.set(index, Double.valueOf(arrayParameter[index]));
                            }

                        }
                    }
                    catch (Exception ex)
                    {
                        
                        return;
                    }
                }
                else
                {

                }
            }

           ////////
        }

        public static class FifthPackageClass
        {
           // Propiedades
            //
            public double ExemptTicketInvoiceM ;
            public double NotImposedTicketM ;
            //        
            public double TicketInvoiceMTaxableIncome1 ;
            public double TicketInvoiceMTaxRate1 ;
            public double TicketInvoiceMTaxableIncome2 ;
            public double TicketInvoiceMTaxRate2 ;
            public double TicketInvoiceMTaxableIncome3 ;
            public double TicketInvoiceMTaxRate3 ;
            public double TicketInvoiceMTaxableIncome4 ;
            public double TicketInvoiceMTaxRate4 ;
            public double TicketInvoiceMTaxableIncome5 ;
            public double TicketInvoiceMTaxRate5 ;
            public double TicketInvoiceMTaxableIncome6 ;
            public double TicketInvoiceMTaxRate6 ;
            public double TicketInvoiceMTaxableIncome7 ;
            public double TicketInvoiceMTaxRate7 ;
            public double TicketInvoiceMTaxableIncome8 ;
            public double TicketInvoiceMTaxRate8 ;
            public double TicketInvoiceMTaxableIncome9 ;
            public double TicketInvoiceMTaxRate9 ;
            public double TicketInvoiceMTaxableIncome10 ;
            public double TicketInvoiceMTaxRate10 ;
            //
            public double ExemptCreditNote ;
            public double NotImposedCreditNote ;
            //
            public double CreditNoteTaxableIncome1 ;
            public double CreditNoteTaxRate1 ;
            public double CreditNoteTaxableIncome2 ;
            public double CreditNoteTaxRate2 ;
            public double CreditNoteTaxableIncome3 ;
            public double CreditNoteTaxRate3 ;
            public double CreditNoteTaxableIncome4 ;
            public double CreditNoteTaxRate4 ;
            public double CreditNoteTaxableIncome5 ;
            public double CreditNoteTaxRate5 ;
            public double CreditNoteTaxableIncome6 ;
            public double CreditNoteTaxRate6 ;
            public double CreditNoteTaxableIncome7 ;
            public double CreditNoteTaxRate7 ;
            public double CreditNoteTaxableIncome8 ;
            public double CreditNoteTaxRate8 ;
            public double CreditNoteTaxableIncome9 ;
            public double CreditNoteTaxRate9 ;
            public double CreditNoteTaxableIncome10 ;
            public double CreditNoteTaxRate10 ;
            //
           ////////

           // Constructor

            public FifthPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptTicketInvoiceM);
                            lstFields.add(this.NotImposedTicketM);

                            lstFields.add(this.TicketInvoiceMTaxableIncome1);
                            lstFields.add(this.TicketInvoiceMTaxRate1);
                            lstFields.add(this.TicketInvoiceMTaxableIncome2);
                            lstFields.add(this.TicketInvoiceMTaxRate2);
                            lstFields.add(this.TicketInvoiceMTaxableIncome3);
                            lstFields.add(this.TicketInvoiceMTaxRate3);
                            lstFields.add(this.TicketInvoiceMTaxableIncome4);
                            lstFields.add(this.TicketInvoiceMTaxRate4);
                            lstFields.add(this.TicketInvoiceMTaxableIncome5);
                            lstFields.add(this.TicketInvoiceMTaxRate5);
                            lstFields.add(this.TicketInvoiceMTaxableIncome6);
                            lstFields.add(this.TicketInvoiceMTaxRate6);
                            lstFields.add(this.TicketInvoiceMTaxableIncome7);
                            lstFields.add(this.TicketInvoiceMTaxRate7);
                            lstFields.add(this.TicketInvoiceMTaxableIncome8);
                            lstFields.add(this.TicketInvoiceMTaxRate8);
                            lstFields.add(this.TicketInvoiceMTaxableIncome9);
                            lstFields.add(this.TicketInvoiceMTaxRate9);
                            lstFields.add(this.TicketInvoiceMTaxableIncome10);
                            lstFields.add(this.TicketInvoiceMTaxRate10);

                            lstFields.add(this.ExemptCreditNote);
                            lstFields.add(this.NotImposedCreditNote);

                            lstFields.add(this.CreditNoteTaxableIncome1);
                            lstFields.add(this.CreditNoteTaxRate1);
                            lstFields.add(this.CreditNoteTaxableIncome2);
                            lstFields.add(this.CreditNoteTaxRate2);
                            lstFields.add(this.CreditNoteTaxableIncome3);
                            lstFields.add(this.CreditNoteTaxRate3);
                            lstFields.add(this.CreditNoteTaxableIncome4);
                            lstFields.add(this.CreditNoteTaxRate4);
                            lstFields.add(this.CreditNoteTaxableIncome5);
                            lstFields.add(this.CreditNoteTaxRate5);
                            lstFields.add(this.CreditNoteTaxableIncome6);
                            lstFields.add(this.CreditNoteTaxRate6);
                            lstFields.add(this.CreditNoteTaxableIncome7);
                            lstFields.add(this.CreditNoteTaxRate7);
                            lstFields.add(this.CreditNoteTaxableIncome8);
                            lstFields.add(this.CreditNoteTaxRate8);
                            lstFields.add(this.CreditNoteTaxableIncome9);
                            lstFields.add(this.CreditNoteTaxRate9);
                            lstFields.add(this.CreditNoteTaxableIncome10);
                            lstFields.add(this.CreditNoteTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////


        }

        public static class SixthPackageClass
        {

           // Propiedades
            //
            public double ExemptCreditNoteA ;
            public double NotImposedCreditNoteA ;
            //        
            public double CreditNoteATaxableIncome1 ;
            public double CreditNoteATaxRate1 ;
            public double CreditNoteATaxableIncome2 ;
            public double CreditNoteATaxRate2 ;
            public double CreditNoteATaxableIncome3 ;
            public double CreditNoteATaxRate3 ;
            public double CreditNoteATaxableIncome4 ;
            public double CreditNoteATaxRate4 ;
            public double CreditNoteATaxableIncome5 ;
            public double CreditNoteATaxRate5 ;
            public double CreditNoteATaxableIncome6 ;
            public double CreditNoteATaxRate6 ;
            public double CreditNoteATaxableIncome7 ;
            public double CreditNoteATaxRate7 ;
            public double CreditNoteATaxableIncome8 ;
            public double CreditNoteATaxRate8 ;
            public double CreditNoteATaxableIncome9 ;
            public double CreditNoteATaxRate9 ;
            public double CreditNoteATaxableIncome10 ;
            public double CreditNoteATaxRate10 ;
            //
            public double ExemptCreditNoteB ;
            public double NotImposedCreditNoteB ;
            //
            public double CreditNoteBTaxableIncome1 ;
            public double CreditNoteBTaxRate1 ;
            public double CreditNoteBTaxableIncome2 ;
            public double CreditNoteBTaxRate2 ;
            public double CreditNoteBTaxableIncome3 ;
            public double CreditNoteBTaxRate3 ;
            public double CreditNoteBTaxableIncome4 ;
            public double CreditNoteBTaxRate4 ;
            public double CreditNoteBTaxableIncome5 ;
            public double CreditNoteBTaxRate5 ;
            public double CreditNoteBTaxableIncome6 ;
            public double CreditNoteBTaxRate6 ;
            public double CreditNoteBTaxableIncome7 ;
            public double CreditNoteBTaxRate7 ;
            public double CreditNoteBTaxableIncome8 ;
            public double CreditNoteBTaxRate8 ;
            public double CreditNoteBTaxableIncome9 ;
            public double CreditNoteBTaxRate9 ;
            public double CreditNoteBTaxableIncome10 ;
            public double CreditNoteBTaxRate10 ;

           ////////

           // Constructor

            public SixthPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptCreditNoteA);
                            lstFields.add(this.NotImposedCreditNoteA);

                            lstFields.add(this.CreditNoteATaxableIncome1);
                            lstFields.add(this.CreditNoteATaxRate1);
                            lstFields.add(this.CreditNoteATaxableIncome2);
                            lstFields.add(this.CreditNoteATaxRate2);
                            lstFields.add(this.CreditNoteATaxableIncome3);
                            lstFields.add(this.CreditNoteATaxRate3);
                            lstFields.add(this.CreditNoteATaxableIncome4);
                            lstFields.add(this.CreditNoteATaxRate4);
                            lstFields.add(this.CreditNoteATaxableIncome5);
                            lstFields.add(this.CreditNoteATaxRate5);
                            lstFields.add(this.CreditNoteATaxableIncome6);
                            lstFields.add(this.CreditNoteATaxRate6);
                            lstFields.add(this.CreditNoteATaxableIncome7);
                            lstFields.add(this.CreditNoteATaxRate7);
                            lstFields.add(this.CreditNoteATaxableIncome8);
                            lstFields.add(this.CreditNoteATaxRate8);
                            lstFields.add(this.CreditNoteATaxableIncome9);
                            lstFields.add(this.CreditNoteATaxRate9);
                            lstFields.add(this.CreditNoteATaxableIncome10);
                            lstFields.add(this.CreditNoteATaxRate10);

                            lstFields.add(this.ExemptCreditNoteB);
                            lstFields.add(this.NotImposedCreditNoteB);

                            lstFields.add(this.CreditNoteBTaxableIncome1);
                            lstFields.add(this.CreditNoteBTaxRate1);
                            lstFields.add(this.CreditNoteBTaxableIncome2);
                            lstFields.add(this.CreditNoteBTaxRate2);
                            lstFields.add(this.CreditNoteBTaxableIncome3);
                            lstFields.add(this.CreditNoteBTaxRate3);
                            lstFields.add(this.CreditNoteBTaxableIncome4);
                            lstFields.add(this.CreditNoteBTaxRate4);
                            lstFields.add(this.CreditNoteBTaxableIncome5);
                            lstFields.add(this.CreditNoteBTaxRate5);
                            lstFields.add(this.CreditNoteBTaxableIncome6);
                            lstFields.add(this.CreditNoteBTaxRate6);
                            lstFields.add(this.CreditNoteBTaxableIncome7);
                            lstFields.add(this.CreditNoteBTaxRate7);
                            lstFields.add(this.CreditNoteBTaxableIncome8);
                            lstFields.add(this.CreditNoteBTaxRate8);
                            lstFields.add(this.CreditNoteBTaxableIncome9);
                            lstFields.add(this.CreditNoteBTaxRate9);
                            lstFields.add(this.CreditNoteBTaxableIncome10);
                            lstFields.add(this.CreditNoteBTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////

        }

        public static class SeventhPackageClass
        { 
           // Propiedades
            //
            public double ExemptCreditNoteC ;
            public double NotImposedCreditNoteC ;
            //        
            public double CreditNoteCTaxableIncome1 ;
            public double CreditNoteCTaxRate1 ;
            public double CreditNoteCTaxableIncome2 ;
            public double CreditNoteCTaxRate2 ;
            public double CreditNoteCTaxableIncome3 ;
            public double CreditNoteCTaxRate3 ;
            public double CreditNoteCTaxableIncome4 ;
            public double CreditNoteCTaxRate4 ;
            public double CreditNoteCTaxableIncome5 ;
            public double CreditNoteCTaxRate5 ;
            public double CreditNoteCTaxableIncome6 ;
            public double CreditNoteCTaxRate6 ;
            public double CreditNoteCTaxableIncome7 ;
            public double CreditNoteCTaxRate7 ;
            public double CreditNoteCTaxableIncome8 ;
            public double CreditNoteCTaxRate8 ;
            public double CreditNoteCTaxableIncome9 ;
            public double CreditNoteCTaxRate9 ;
            public double CreditNoteCTaxableIncome10 ;
            public double CreditNoteCTaxRate10 ;
            //
            public double ExemptCreditNoteM ;
            public double NotImposedCreditNoteM ;
            //
            public double CreditNoteMTaxableIncome1 ;
            public double CreditNoteMTaxRate1 ;
            public double CreditNoteMTaxableIncome2 ;
            public double CreditNoteMTaxRate2 ;
            public double CreditNoteMTaxableIncome3 ;
            public double CreditNoteMTaxRate3 ;
            public double CreditNoteMTaxableIncome4 ;
            public double CreditNoteMTaxRate4 ;
            public double CreditNoteMTaxableIncome5 ;
            public double CreditNoteMTaxRate5 ;
            public double CreditNoteMTaxableIncome6 ;
            public double CreditNoteMTaxRate6 ;
            public double CreditNoteMTaxableIncome7 ;
            public double CreditNoteMTaxRate7 ;
            public double CreditNoteMTaxableIncome8 ;
            public double CreditNoteMTaxRate8 ;
            public double CreditNoteMTaxableIncome9 ;
            public double CreditNoteMTaxRate9 ;
            public double CreditNoteMTaxableIncome10 ;
            public double CreditNoteMTaxRate10 ;

           ////////

           // Constructor

            public SeventhPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptCreditNoteC);
                            lstFields.add(this.NotImposedCreditNoteC);

                            lstFields.add(this.CreditNoteCTaxableIncome1);
                            lstFields.add(this.CreditNoteCTaxRate1);
                            lstFields.add(this.CreditNoteCTaxableIncome2);
                            lstFields.add(this.CreditNoteCTaxRate2);
                            lstFields.add(this.CreditNoteCTaxableIncome3);
                            lstFields.add(this.CreditNoteCTaxRate3);
                            lstFields.add(this.CreditNoteCTaxableIncome4);
                            lstFields.add(this.CreditNoteCTaxRate4);
                            lstFields.add(this.CreditNoteCTaxableIncome5);
                            lstFields.add(this.CreditNoteCTaxRate5);
                            lstFields.add(this.CreditNoteCTaxableIncome6);
                            lstFields.add(this.CreditNoteCTaxRate6);
                            lstFields.add(this.CreditNoteCTaxableIncome7);
                            lstFields.add(this.CreditNoteCTaxRate7);
                            lstFields.add(this.CreditNoteCTaxableIncome8);
                            lstFields.add(this.CreditNoteCTaxRate8);
                            lstFields.add(this.CreditNoteCTaxableIncome9);
                            lstFields.add(this.CreditNoteCTaxRate9);
                            lstFields.add(this.CreditNoteCTaxableIncome10);
                            lstFields.add(this.CreditNoteCTaxRate10);

                            lstFields.add(this.ExemptCreditNoteM);
                            lstFields.add(this.NotImposedCreditNoteM);

                            lstFields.add(this.CreditNoteMTaxableIncome1);
                            lstFields.add(this.CreditNoteMTaxRate1);
                            lstFields.add(this.CreditNoteMTaxableIncome2);
                            lstFields.add(this.CreditNoteMTaxRate2);
                            lstFields.add(this.CreditNoteMTaxableIncome3);
                            lstFields.add(this.CreditNoteMTaxRate3);
                            lstFields.add(this.CreditNoteMTaxableIncome4);
                            lstFields.add(this.CreditNoteMTaxRate4);
                            lstFields.add(this.CreditNoteMTaxableIncome5);
                            lstFields.add(this.CreditNoteMTaxRate5);
                            lstFields.add(this.CreditNoteMTaxableIncome6);
                            lstFields.add(this.CreditNoteMTaxRate6);
                            lstFields.add(this.CreditNoteMTaxableIncome7);
                            lstFields.add(this.CreditNoteMTaxRate7);
                            lstFields.add(this.CreditNoteMTaxableIncome8);
                            lstFields.add(this.CreditNoteMTaxRate8);
                            lstFields.add(this.CreditNoteMTaxableIncome9);
                            lstFields.add(this.CreditNoteMTaxRate9);
                            lstFields.add(this.CreditNoteMTaxableIncome10);
                            lstFields.add(this.CreditNoteMTaxRate10);

                            for(int index = 0; index<lstFields.size(); index++)
                            {
                                lstFields.set(index, Double.valueOf(arrayParameter[index]));
                            }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////
        
        }

        public static class EightPackageClass{
            
           // Propiedades
            //
            public double ExemptDebitNoteA ;
            public double NotImposedDebitNoteA ;
            //        
            public double DebitNoteATaxableIncome1 ;
            public double DebitNoteATaxRate1 ;
            public double DebitNoteATaxableIncome2 ;
            public double DebitNoteATaxRate2 ;
            public double DebitNoteATaxableIncome3 ;
            public double DebitNoteATaxRate3 ;
            public double DebitNoteATaxableIncome4 ;
            public double DebitNoteATaxRate4 ;
            public double DebitNoteATaxableIncome5 ;
            public double DebitNoteATaxRate5 ;
            public double DebitNoteATaxableIncome6 ;
            public double DebitNoteATaxRate6 ;
            public double DebitNoteATaxableIncome7 ;
            public double DebitNoteATaxRate7 ;
            public double DebitNoteATaxableIncome8 ;
            public double DebitNoteATaxRate8 ;
            public double DebitNoteATaxableIncome9 ;
            public double DebitNoteATaxRate9 ;
            public double DebitNoteATaxableIncome10 ;
            public double DebitNoteATaxRate10 ;
            //
            public double ExemptDebitNoteB ;
            public double NotImposedDebitNoteB ;
            //
            public double DebitNoteBTaxableIncome1 ;
            public double DebitNoteBTaxRate1 ;
            public double DebitNoteBTaxableIncome2 ;
            public double DebitNoteBTaxRate2 ;
            public double DebitNoteBTaxableIncome3 ;
            public double DebitNoteBTaxRate3 ;
            public double DebitNoteBTaxableIncome4 ;
            public double DebitNoteBTaxRate4 ;
            public double DebitNoteBTaxableIncome5 ;
            public double DebitNoteBTaxRate5 ;
            public double DebitNoteBTaxableIncome6 ;
            public double DebitNoteBTaxRate6 ;
            public double DebitNoteBTaxableIncome7 ;
            public double DebitNoteBTaxRate7 ;
            public double DebitNoteBTaxableIncome8 ;
            public double DebitNoteBTaxRate8 ;
            public double DebitNoteBTaxableIncome9 ;
            public double DebitNoteBTaxRate9 ;
            public double DebitNoteBTaxableIncome10 ;
            public double DebitNoteBTaxRate10 ;

           ////////

           // Constructor

            public EightPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptDebitNoteA);
                            lstFields.add(this.NotImposedDebitNoteA);

                            lstFields.add(this.DebitNoteATaxableIncome1);
                            lstFields.add(this.DebitNoteATaxRate1);
                            lstFields.add(this.DebitNoteATaxableIncome2);
                            lstFields.add(this.DebitNoteATaxRate2);
                            lstFields.add(this.DebitNoteATaxableIncome3);
                            lstFields.add(this.DebitNoteATaxRate3);
                            lstFields.add(this.DebitNoteATaxableIncome4);
                            lstFields.add(this.DebitNoteATaxRate4);
                            lstFields.add(this.DebitNoteATaxableIncome5);
                            lstFields.add(this.DebitNoteATaxRate5);
                            lstFields.add(this.DebitNoteATaxableIncome6);
                            lstFields.add(this.DebitNoteATaxRate6);
                            lstFields.add(this.DebitNoteATaxableIncome7);
                            lstFields.add(this.DebitNoteATaxRate7);
                            lstFields.add(this.DebitNoteATaxableIncome8);
                            lstFields.add(this.DebitNoteATaxRate8);
                            lstFields.add(this.DebitNoteATaxableIncome9);
                            lstFields.add(this.DebitNoteATaxRate9);
                            lstFields.add(this.DebitNoteATaxableIncome10);
                            lstFields.add(this.DebitNoteATaxRate10);

                            lstFields.add(this.ExemptDebitNoteB);
                            lstFields.add(this.NotImposedDebitNoteB);

                            lstFields.add(this.DebitNoteBTaxableIncome1);
                            lstFields.add(this.DebitNoteBTaxRate1);
                            lstFields.add(this.DebitNoteBTaxableIncome2);
                            lstFields.add(this.DebitNoteBTaxRate2);
                            lstFields.add(this.DebitNoteBTaxableIncome3);
                            lstFields.add(this.DebitNoteBTaxRate3);
                            lstFields.add(this.DebitNoteBTaxableIncome4);
                            lstFields.add(this.DebitNoteBTaxRate4);
                            lstFields.add(this.DebitNoteBTaxableIncome5);
                            lstFields.add(this.DebitNoteBTaxRate5);
                            lstFields.add(this.DebitNoteBTaxableIncome6);
                            lstFields.add(this.DebitNoteBTaxRate6);
                            lstFields.add(this.DebitNoteBTaxableIncome7);
                            lstFields.add(this.DebitNoteBTaxRate7);
                            lstFields.add(this.DebitNoteBTaxableIncome8);
                            lstFields.add(this.DebitNoteBTaxRate8);
                            lstFields.add(this.DebitNoteBTaxableIncome9);
                            lstFields.add(this.DebitNoteBTaxRate9);
                            lstFields.add(this.DebitNoteBTaxableIncome10);
                            lstFields.add(this.DebitNoteBTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////
        
        }

        public static class NinthPackageClass{
            
           // Propiedades
            //
            public double ExemptDebitNoteC ;
            public double NotImposedDebitNoteC ;
            //        
            public double DebitNoteCTaxableIncome1 ;
            public double DebitNoteCTaxRate1 ;
            public double DebitNoteCTaxableIncome2 ;
            public double DebitNoteCTaxRate2 ;
            public double DebitNoteCTaxableIncome3 ;
            public double DebitNoteCTaxRate3 ;
            public double DebitNoteCTaxableIncome4 ;
            public double DebitNoteCTaxRate4 ;
            public double DebitNoteCTaxableIncome5 ;
            public double DebitNoteCTaxRate5 ;
            public double DebitNoteCTaxableIncome6 ;
            public double DebitNoteCTaxRate6 ;
            public double DebitNoteCTaxableIncome7 ;
            public double DebitNoteCTaxRate7 ;
            public double DebitNoteCTaxableIncome8 ;
            public double DebitNoteCTaxRate8 ;
            public double DebitNoteCTaxableIncome9 ;
            public double DebitNoteCTaxRate9 ;
            public double DebitNoteCTaxableIncome10 ;
            public double DebitNoteCTaxRate10 ;
            //
            public double ExemptDebitNoteM ;
            public double NotImposedDebitNoteM ;
            //
            public double DebitNoteMTaxableIncome1 ;
            public double DebitNoteMTaxRate1 ;
            public double DebitNoteMTaxableIncome2 ;
            public double DebitNoteMTaxRate2 ;
            public double DebitNoteMTaxableIncome3 ;
            public double DebitNoteMTaxRate3 ;
            public double DebitNoteMTaxableIncome4 ;
            public double DebitNoteMTaxRate4 ;
            public double DebitNoteMTaxableIncome5 ;
            public double DebitNoteMTaxRate5 ;
            public double DebitNoteMTaxableIncome6 ;
            public double DebitNoteMTaxRate6 ;
            public double DebitNoteMTaxableIncome7 ;
            public double DebitNoteMTaxRate7 ;
            public double DebitNoteMTaxableIncome8 ;
            public double DebitNoteMTaxRate8 ;
            public double DebitNoteMTaxableIncome9 ;
            public double DebitNoteMTaxRate9 ;
            public double DebitNoteMTaxableIncome10 ;
            public double DebitNoteMTaxRate10 ;

           ////////

           // Constructor

            public NinthPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptDebitNoteC);
                            lstFields.add(this.NotImposedDebitNoteC);

                            lstFields.add(this.DebitNoteCTaxableIncome1);
                            lstFields.add(this.DebitNoteCTaxRate1);
                            lstFields.add(this.DebitNoteCTaxableIncome2);
                            lstFields.add(this.DebitNoteCTaxRate2);
                            lstFields.add(this.DebitNoteCTaxableIncome3);
                            lstFields.add(this.DebitNoteCTaxRate3);
                            lstFields.add(this.DebitNoteCTaxableIncome4);
                            lstFields.add(this.DebitNoteCTaxRate4);
                            lstFields.add(this.DebitNoteCTaxableIncome5);
                            lstFields.add(this.DebitNoteCTaxRate5);
                            lstFields.add(this.DebitNoteCTaxableIncome6);
                            lstFields.add(this.DebitNoteCTaxRate6);
                            lstFields.add(this.DebitNoteCTaxableIncome7);
                            lstFields.add(this.DebitNoteCTaxRate7);
                            lstFields.add(this.DebitNoteCTaxableIncome8);
                            lstFields.add(this.DebitNoteCTaxRate8);
                            lstFields.add(this.DebitNoteCTaxableIncome9);
                            lstFields.add(this.DebitNoteCTaxRate9);
                            lstFields.add(this.DebitNoteCTaxableIncome10);
                            lstFields.add(this.DebitNoteCTaxRate10);

                            lstFields.add(this.ExemptDebitNoteM);
                            lstFields.add(this.NotImposedDebitNoteM);

                            lstFields.add(this.DebitNoteMTaxableIncome1);
                            lstFields.add(this.DebitNoteMTaxRate1);
                            lstFields.add(this.DebitNoteMTaxableIncome2);
                            lstFields.add(this.DebitNoteMTaxRate2);
                            lstFields.add(this.DebitNoteMTaxableIncome3);
                            lstFields.add(this.DebitNoteMTaxRate3);
                            lstFields.add(this.DebitNoteMTaxableIncome4);
                            lstFields.add(this.DebitNoteMTaxRate4);
                            lstFields.add(this.DebitNoteMTaxableIncome5);
                            lstFields.add(this.DebitNoteMTaxRate5);
                            lstFields.add(this.DebitNoteMTaxableIncome6);
                            lstFields.add(this.DebitNoteMTaxRate6);
                            lstFields.add(this.DebitNoteMTaxableIncome7);
                            lstFields.add(this.DebitNoteMTaxRate7);
                            lstFields.add(this.DebitNoteMTaxableIncome8);
                            lstFields.add(this.DebitNoteMTaxRate8);
                            lstFields.add(this.DebitNoteMTaxableIncome9);
                            lstFields.add(this.DebitNoteMTaxRate9);
                            lstFields.add(this.DebitNoteMTaxableIncome10);
                            lstFields.add(this.DebitNoteMTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////
        
        }

        public static class TenthPackageClass{
            
           // Propiedades
            //
            public double ExemptReceiptA ;
            public double NotImposedReceiptA ;
            //        
            public double ReceiptATaxableIncome1 ;
            public double ReceiptATaxRate1 ;
            public double ReceiptATaxableIncome2 ;
            public double ReceiptATaxRate2 ;
            public double ReceiptATaxableIncome3 ;
            public double ReceiptATaxRate3 ;
            public double ReceiptATaxableIncome4 ;
            public double ReceiptATaxRate4 ;
            public double ReceiptATaxableIncome5 ;
            public double ReceiptATaxRate5 ;
            public double ReceiptATaxableIncome6 ;
            public double ReceiptATaxRate6 ;
            public double ReceiptATaxableIncome7 ;
            public double ReceiptATaxRate7 ;
            public double ReceiptATaxableIncome8 ;
            public double ReceiptATaxRate8 ;
            public double ReceiptATaxableIncome9 ;
            public double ReceiptATaxRate9 ;
            public double ReceiptATaxableIncome10 ;
            public double ReceiptATaxRate10 ;
            //
            public double ExemptReceiptB ;
            public double NotImposedReceiptB ;
            //
            public double ReceiptBTaxableIncome1 ;
            public double ReceiptBTaxRate1 ;
            public double ReceiptBTaxableIncome2 ;
            public double ReceiptBTaxRate2 ;
            public double ReceiptBTaxableIncome3 ;
            public double ReceiptBTaxRate3 ;
            public double ReceiptBTaxableIncome4 ;
            public double ReceiptBTaxRate4 ;
            public double ReceiptBTaxableIncome5 ;
            public double ReceiptBTaxRate5 ;
            public double ReceiptBTaxableIncome6 ;
            public double ReceiptBTaxRate6 ;
            public double ReceiptBTaxableIncome7 ;
            public double ReceiptBTaxRate7 ;
            public double ReceiptBTaxableIncome8 ;
            public double ReceiptBTaxRate8 ;
            public double ReceiptBTaxableIncome9 ;
            public double ReceiptBTaxRate9 ;
            public double ReceiptBTaxableIncome10 ;
            public double ReceiptBTaxRate10 ;

           ////////

           // Constructor

            public TenthPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptReceiptA);
                            lstFields.add(this.NotImposedReceiptA);

                            lstFields.add(this.ReceiptATaxableIncome1);
                            lstFields.add(this.ReceiptATaxRate1);
                            lstFields.add(this.ReceiptATaxableIncome2);
                            lstFields.add(this.ReceiptATaxRate2);
                            lstFields.add(this.ReceiptATaxableIncome3);
                            lstFields.add(this.ReceiptATaxRate3);
                            lstFields.add(this.ReceiptATaxableIncome4);
                            lstFields.add(this.ReceiptATaxRate4);
                            lstFields.add(this.ReceiptATaxableIncome5);
                            lstFields.add(this.ReceiptATaxRate5);
                            lstFields.add(this.ReceiptATaxableIncome6);
                            lstFields.add(this.ReceiptATaxRate6);
                            lstFields.add(this.ReceiptATaxableIncome7);
                            lstFields.add(this.ReceiptATaxRate7);
                            lstFields.add(this.ReceiptATaxableIncome8);
                            lstFields.add(this.ReceiptATaxRate8);
                            lstFields.add(this.ReceiptATaxableIncome9);
                            lstFields.add(this.ReceiptATaxRate9);
                            lstFields.add(this.ReceiptATaxableIncome10);
                            lstFields.add(this.ReceiptATaxRate10);

                            lstFields.add(this.ExemptReceiptB);
                            lstFields.add(this.NotImposedReceiptB);

                            lstFields.add(this.ReceiptBTaxableIncome1);
                            lstFields.add(this.ReceiptBTaxRate1);
                            lstFields.add(this.ReceiptBTaxableIncome2);
                            lstFields.add(this.ReceiptBTaxRate2);
                            lstFields.add(this.ReceiptBTaxableIncome3);
                            lstFields.add(this.ReceiptBTaxRate3);
                            lstFields.add(this.ReceiptBTaxableIncome4);
                            lstFields.add(this.ReceiptBTaxRate4);
                            lstFields.add(this.ReceiptBTaxableIncome5);
                            lstFields.add(this.ReceiptBTaxRate5);
                            lstFields.add(this.ReceiptBTaxableIncome6);
                            lstFields.add(this.ReceiptBTaxRate6);
                            lstFields.add(this.ReceiptBTaxableIncome7);
                            lstFields.add(this.ReceiptBTaxRate7);
                            lstFields.add(this.ReceiptBTaxableIncome8);
                            lstFields.add(this.ReceiptBTaxRate8);
                            lstFields.add(this.ReceiptBTaxableIncome9);
                            lstFields.add(this.ReceiptBTaxRate9);
                            lstFields.add(this.ReceiptBTaxableIncome10);
                            lstFields.add(this.ReceiptBTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////
        
        }

        public static class EleventhPackageClass{
            
           // Propiedades
            //
            public double ExemptReceiptC ;
            public double NotImposedReceiptC ;
            //        
            public double ReceiptCTaxableIncome1 ;
            public double ReceiptCTaxRate1 ;
            public double ReceiptCTaxableIncome2 ;
            public double ReceiptCTaxRate2 ;
            public double ReceiptCTaxableIncome3 ;
            public double ReceiptCTaxRate3 ;
            public double ReceiptCTaxableIncome4 ;
            public double ReceiptCTaxRate4 ;
            public double ReceiptCTaxableIncome5 ;
            public double ReceiptCTaxRate5 ;
            public double ReceiptCTaxableIncome6 ;
            public double ReceiptCTaxRate6 ;
            public double ReceiptCTaxableIncome7 ;
            public double ReceiptCTaxRate7 ;
            public double ReceiptCTaxableIncome8 ;
            public double ReceiptCTaxRate8 ;
            public double ReceiptCTaxableIncome9 ;
            public double ReceiptCTaxRate9 ;
            public double ReceiptCTaxableIncome10 ;
            public double ReceiptCTaxRate10 ;
            //
            public double ExemptDebitNoteM ;
            public double NotImposedDebitNoteM ;
            //
            public double ReceiptMTaxableIncome1 ;
            public double ReceiptMTaxRate1 ;
            public double ReceiptMTaxableIncome2 ;
            public double ReceiptMTaxRate2 ;
            public double ReceiptMTaxableIncome3 ;
            public double ReceiptMTaxRate3 ;
            public double ReceiptMTaxableIncome4 ;
            public double ReceiptMTaxRate4 ;
            public double ReceiptMTaxableIncome5 ;
            public double ReceiptMTaxRate5 ;
            public double ReceiptMTaxableIncome6 ;
            public double ReceiptMTaxRate6 ;
            public double ReceiptMTaxableIncome7 ;
            public double ReceiptMTaxRate7 ;
            public double ReceiptMTaxableIncome8 ;
            public double ReceiptMTaxRate8 ;
            public double ReceiptMTaxableIncome9 ;
            public double ReceiptMTaxRate9 ;
            public double ReceiptMTaxableIncome10 ;
            public double ReceiptMTaxRate10 ;

           ////////

           // Constructor

            public EleventhPackageClass(String pTrama)
            {
                if (true)
	            {
		            try 
	                {
                        String[] arrayParameter = pTrama.split( "" + (char)0X0A);

                        if (arrayParameter.length > 1)
                        {
                            List<Double> lstFields = new ArrayList<Double>();

                            lstFields.add(this.ExemptReceiptC);
                            lstFields.add(this.NotImposedReceiptC);

                            lstFields.add(this.ReceiptCTaxableIncome1);
                            lstFields.add(this.ReceiptCTaxRate1);
                            lstFields.add(this.ReceiptCTaxableIncome2);
                            lstFields.add(this.ReceiptCTaxRate2);
                            lstFields.add(this.ReceiptCTaxableIncome3);
                            lstFields.add(this.ReceiptCTaxRate3);
                            lstFields.add(this.ReceiptCTaxableIncome4);
                            lstFields.add(this.ReceiptCTaxRate4);
                            lstFields.add(this.ReceiptCTaxableIncome5);
                            lstFields.add(this.ReceiptCTaxRate5);
                            lstFields.add(this.ReceiptCTaxableIncome6);
                            lstFields.add(this.ReceiptCTaxRate6);
                            lstFields.add(this.ReceiptCTaxableIncome7);
                            lstFields.add(this.ReceiptCTaxRate7);
                            lstFields.add(this.ReceiptCTaxableIncome8);
                            lstFields.add(this.ReceiptCTaxRate8);
                            lstFields.add(this.ReceiptCTaxableIncome9);
                            lstFields.add(this.ReceiptCTaxRate9);
                            lstFields.add(this.ReceiptCTaxableIncome10);
                            lstFields.add(this.ReceiptCTaxRate10);

                            lstFields.add(this.ExemptDebitNoteM);
                            lstFields.add(this.NotImposedDebitNoteM);

                            lstFields.add(this.ReceiptMTaxableIncome1);
                            lstFields.add(this.ReceiptMTaxRate1);
                            lstFields.add(this.ReceiptMTaxableIncome2);
                            lstFields.add(this.ReceiptMTaxRate2);
                            lstFields.add(this.ReceiptMTaxableIncome3);
                            lstFields.add(this.ReceiptMTaxRate3);
                            lstFields.add(this.ReceiptMTaxableIncome4);
                            lstFields.add(this.ReceiptMTaxRate4);
                            lstFields.add(this.ReceiptMTaxableIncome5);
                            lstFields.add(this.ReceiptMTaxRate5);
                            lstFields.add(this.ReceiptMTaxableIncome6);
                            lstFields.add(this.ReceiptMTaxRate6);
                            lstFields.add(this.ReceiptMTaxableIncome7);
                            lstFields.add(this.ReceiptMTaxRate7);
                            lstFields.add(this.ReceiptMTaxableIncome8);
                            lstFields.add(this.ReceiptMTaxRate8);
                            lstFields.add(this.ReceiptMTaxableIncome9);
                            lstFields.add(this.ReceiptMTaxRate9);
                            lstFields.add(this.ReceiptMTaxableIncome10);
                            lstFields.add(this.ReceiptMTaxRate10);

                            for (int index = 0; index < lstFields.size(); index++)
			                {
                                            
			                    lstFields.set(index, Double.valueOf(arrayParameter[index]));
			                }

                        }
                        else
                        {

                        }
	                }
	                catch (Exception ex)
	                {
		
		                return;
	                }
	            }
            
            }

           ////////
        
        }

        
  
      /*  
    public FirstPackageClass FirstPackage;
    public SecondPackageClass SecondPackage;
    public ThirdPackageClass ThirdPackage;
    public FourthPackageClass FourthPackage;
    public FifthPackageClass FifthPackage;
    public SixthPackageClass SixthPackage;
    public SeventhPackageClass SeventhPackage;
    public EightPackageClass EigthPackage;
    public NinthPackageClass NinthPackage;
    public TenthPackageClass TenthPackage;
    public EleventhPackageClass EleventhPackage;   
    */
}
}
