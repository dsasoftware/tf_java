package tfhka;

/**
 *
 * Representa una estructura para lanzar los errores en las operaciones con la impreosora fiscal.
 */
public class PrinterExeption extends Exception{
    /**Objeto PrinterStatus con informaci�n del Status y Error de la impresora al generarse la Excepci�n PrinterException*/
    private PrinterStatus StatusError;
    /** Creates a new instance of PrinterExeption
     *@param Mensaje Mensaje descriptivo del error generado
     */
    public PrinterExeption(String Mensaje,PrinterStatus printerStaErr) {
        super(Mensaje);
        this.setStatusError(printerStaErr);
    }
    /**Retorna un objeto de tipo PriterStatus con la informaci�n del estado y error de PrinterExeption*/
    public PrinterStatus getStatusError() {
        return StatusError;
    }

    private void setStatusError(PrinterStatus StatusError) {
        this.StatusError = StatusError;
    }
    
}
