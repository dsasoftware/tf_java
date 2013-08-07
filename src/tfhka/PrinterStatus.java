package tfhka;
/** 
 * Representa una estructura para almacenar la información del Status y Error de la impreosora fiscal.
 */ 
public  class  PrinterStatus {
 private int printerStatusCode;
 private String printerStatusDescription;
 private int printerErrorCode;
 private String printerErrorDescription;
 private boolean ErrorValidity;
  /** Creates a new instance of PrinterStatus 
     *@param status codigo de status
     *@param error codigo de error
     *@param valid indicador  de validez de error
     *@param StatusDescrp descripción del status
     *@param ErrorDescrip descripción del error
     */
    public PrinterStatus(int status, int error, boolean valid, String StatusDescrp, String ErrorDescrip) 
    {
        this.setPrinterStatusCode(status);
        this.setPrinterErrorCode(error);
        this.setErrorValidity(valid);  
        this.setPrinterStatusDescription(StatusDescrp);
        this.setPrinterErrorDescription(ErrorDescrip);
    }
    /**
      * Retorna el codigo del Status de la Impresora Fiscal.
      */
    public int getPrinterStatusCode() {
        return printerStatusCode;
    }

   private void setPrinterStatusCode(int printerStatusCode) {
        this.printerStatusCode = printerStatusCode;
    }
    /**
      * Retorna la descripción del Status de la Impresora Fiscal.
      */
    public String getPrinterStatusDescription() {
        return printerStatusDescription;
    }

    private void setPrinterStatusDescription(String printerStatusDescription) {
        this.printerStatusDescription = printerStatusDescription;
    }
     /**
      * Retorna el codigo del Error de la Impresora Fiscal.
      */
    public int getPrinterErrorCode() {
        return printerErrorCode;
    }

    private void setPrinterErrorCode(int printerErrorCode) {
        this.printerErrorCode = printerErrorCode;
    }
    /**
      * Retorna la descripción del Error de la Impresora Fiscal.
      */
    public String getPrinterErrorDescription() {
        return printerErrorDescription;
    }

   private void setPrinterErrorDescription(String printerErrorDescription) {
        this.printerErrorDescription = printerErrorDescription;
    }
    /**
      * Indica la validez  del Error de la Impresora Fiscal.
      */
    public boolean isErrorValidity() {
        return ErrorValidity;
    }

    private void setErrorValidity(boolean ErrorValidity) {
        this.ErrorValidity = ErrorValidity;
    }
    
}
