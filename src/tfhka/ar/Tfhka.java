package tfhka.ar;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import tfhka._private.TfhkaRaiz;
import tfhka.*;

/** 
* Representa una Libreria de Clase para Protocolo de Comunicacion Directo
* de la impresora fiscal con apliciones java, empleando la API de comunicacion RXTXcomm.jar.
*/ 
public final  class Tfhka extends TfhkaCommon {

	// Declaracion de los Atributos a utilizar
        /**Objeto de tipo ReportData que se carga al subir reporte X ??� Z del PC por medio de los m??�todos getZReport()  y  getXReport()*/
        private ReportData ReportePC;
         /**Objeto de tipo AcumuladosX que se carga al subir reporte X4, X5 y X7 del PC por medio de los metodos getX4Report(), getX5Report()  y  getX7Report()*/
        private AcumuladosX ReporteAcumX;
        /**Arreglo de Objetos de tipo ReportData que se cargan al subir lectura de memoria fiscal del PC mediante los m??�todos getZReport(Date fecha1, Date fecha2)
         * y getZReport(int nroZ1, int nroZ2).
         */
        private ReportData[] ReporteArrayPC;       
         /**Objeto de tipo S1PrinterData que carga informaci??�n cuando se hace una subida de estado S1 por el m??�todo  getS1PrinterData()*/
        private S1PrinterData S1Estado;
        /**Objeto de tipo S2PrinterData que carga informaci??�n cuando se hace una subida de estado S2 por el m??�todo  getS2PrinterData()*/
        private S2PrinterData S2Estado;
        /**Objeto de tipo S3PrinterData que carga informaci??�n cuando se hace una subida de estado S3 por el m??�todo  getS3PrinterData()*/
        private S3PrinterData S3Estado;
        /**Objeto de tipo S4PrinterData que carga informaci??�n cuando se hace una subida de estado S4 por el m??�todo  getS4PrinterData()*/
        private S4PrinterData S4Estado;
        /**Objeto de tipo S5PrinterData que carga informaci??�n cuando se hace una subida de estado S5 por el m??�todo  getS5PrinterData()*/
        private S5PrinterData S5Estado;
        /**Objeto de tipo S6PrinterData que carga informaci??�n cuando se hace una subida de estado S6 por el m??�todo  getS6PrinterData()*/
        private S6PrinterData S6Estado;
        /**Objeto de tipo S7PrinterData que carga informaci??�n cuando se hace una subida de estado S7 por el m??�todo  getS7PrinterData()*/
        private S7PrinterData S7Estado;
        //PARAMETROS AGREGADOS
        /**Objeto de tipo S8EPrinterData que carga informaci??�n cuando se hace una subida de estado S8E por el m??�todo  getS8EPrinterData()*/
        private S8EPrinterData S8EEstado;
        /**Objeto de tipo S8PPrinterData que carga informaci??�n cuando se hace una subida de estado S8P por el m??�todo  getS8EPrinterData()*/
        private S8PPrinterData S8PEstado;
        
        
        /**Nombre del puerto serial a manejar*/
	public String Terminar;
	/**
	*Inicializa una nueva instancia de la clase Tfhka, Conecta y define el
	*puerto a manejar en la clase
	*@param puerto Nombre del Puerto Serial 
        */
   public Tfhka(String puerto) 
    { 
        super(puerto);
    }
        /**
	*Inicializa una nueva instancia de la clase Tfhka
        */
        public Tfhka()
        {
            super();
        }           	
        /**
	 *Retorna un objeto  de tipo ReportData  con todas la informaci?n para la carga de un reporte X actual("U0X").
         *@throws PrinterException Error de  transacci?n.
	 */
    public ReportData getXReport() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U0X");

            if (rep > 0)
            {
                this.ReportePC = new ReportData(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReportePC = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReportePC;

        }
        catch (NullPointerException ex)
        {
            Estado = ex.getMessage();
            this.ReportePC = null;
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
     /**
	 *Retorna un objeto  de tipo ReportData  con todas la informaci?n para la carga de un reporte X2 actual("U1X").
         *@throws PrinterException Error de  transacci?n.
	 */
    public ReportData getX2Report() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U1X");

            if (rep > 0)
            {
                this.ReportePC = new ReportData(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReportePC = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReportePC;

        }
        catch (NullPointerException ex)
        {
            Estado = ex.getMessage();
            this.ReportePC = null;
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
     /**
	 *Retorna un objeto  de tipo AcumuladosX  con todas la informaci?n para la carga de un reporte X4 actual (U0X4).
         *@throws PrinterException Error de  transaccion.
	 */
    public AcumuladosX getX4Report() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U0X4");

            if (rep > 0)
            {
                this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReporteAcumX  = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReporteAcumX;

        }
        catch (NullPointerException ex)
        {
            Estado = ex.getMessage();
            this.ReporteAcumX  = null;
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
     /**
	 *Retorna un objeto  de tipo AcumuladosX  con todas la informaci?n para la carga de un reporte X5 actual (U0X5).
         *@throws PrinterException Error de  transaccion.
	 */
    public AcumuladosX getX5Report() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U0X5");

            if (rep > 0)
            {
                this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReporteAcumX  = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReporteAcumX;

        }
        catch (NullPointerException ex)
        {
            Estado = ex.getMessage();
            this.ReporteAcumX  = null;
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
     /**
	 *Retorna un objeto  de tipo AcumuladosX  con todas la informaci?n para la carga de un reporte X7 actual (U0X7).
         *@throws PrinterException Error de  transaccion.
	 */
    public AcumuladosX getX7Report() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U0X7");

            if (rep > 0)
            {
                this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReporteAcumX  = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReporteAcumX;

        }
        catch (NullPointerException ex)
        {
            Estado = ex.getMessage();
            this.ReporteAcumX  = null;
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
        /**
	 *Retorna un objeto  de tipo ReportData  con todas la informaci?n del ?ltimo reporte Z reaizado ("U0Z").
         *@throws PrinterException Error de  transacci?n.
	 */
        public ReportData getZReport() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U0Z");
            if (rep > 0)
            {
                this.ReportePC = new ReportData(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReportePC = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReportePC;

        }
        catch (NullPointerException ex)
        {
            this.ReportePC = null;
            Estado = ex.getMessage();
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
        /**
	 *Retorna un objeto  de tipo ReportData  con todas la informaci?n del ?ltimo reporte Z2 reaizado ("U1Z").
         *@throws PrinterException Error de  transacci?n.
	 */
        public ReportData getZ2Report() throws PrinterException
    {
        try
        {

            int rep = this.SubirDataReport("U1Z");
            if (rep > 0)
            {
                this.ReportePC = new ReportData(this.sDataSubida);
                Estado = " Status: 00  Error: 00";
            }
            else
            {
                this.ReportePC = null;
                Estado = "Sin repuesta";
                throw new PrinterException(Estado, getPrinterStatus());
            }

            return ReportePC;

        }
        catch (NullPointerException ex)
        {
            this.ReportePC = null;
            Estado = ex.getMessage();
            throw new PrinterException(Estado, getPrinterStatus());
        }

    }
       /**
	*Retorna un arreglo de objetos  ReportData Z con todos sus atributos por rango de n??�meros
	*@param StartReportNumber N??�mero del  Z inicial a subir
        *@param EndReportNumber N??�mero del  Z final a subir
        *@throws PrinterException Error de  transacci??�n.
        */
        public ReportData[] getZReport(int StarttReportNumber, int EndReportNumber ) throws PrinterException
        {  
          String IntervaloNi =  String.valueOf(StarttReportNumber);
          while(IntervaloNi.length()<6)
          {
              IntervaloNi = "0" + IntervaloNi;
          }
          String IntervaloNf =  String.valueOf(EndReportNumber);
          while(IntervaloNf.length()<6)
          {
              IntervaloNf = "0" + IntervaloNf;
          }
		  
          try {
		  
           int rep =  this.SubirDataReport("U3A" + IntervaloNi + IntervaloNf);
		   
           if (rep > 0)
           { int  m=0;
           
            this.ReporteArrayPC = new ReportData[this.dataLectorFisc.size()];
            /*
             for(Object contenido : this.dataLectorFisc)
              {
                 this.ReporteArrayPC[m] = new ReportData((String)contenido);
                 ++m;
              }
              */
            for (int i = 0; i < this.dataLectorFisc.size(); i++) {  
                                  Object contenido = this.dataLectorFisc.get(i);  
                                  this.ReporteArrayPC[m] = new ReportData((String)contenido);
                 ++m;
                                }  
            
            Estado = " Status: 00  Error: 00";
           }
           else
           {
               this.ReporteArrayPC =  null;
               Estado = "Sin repuesta";
               
                if (StarttReportNumber > EndReportNumber)
              this.Estado = "The original number can not be greater than the final number";
               
               throw new PrinterException(Estado, getPrinterStatus());
           }
           
            return ReporteArrayPC;
			
			}catch (NullPointerException ex) {
            this.ReporteArrayPC = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
		
        }
         /**
	  *Retorna un arreglo de objetos de ReportData Z con todos sus atributos por rango de fechas
          *@param StartDate Fecha inicial del  Z a subir
          *@param EndDate Fecha final del  Z a subir
          *@throws PrinterException Error de  transacci??�n.
          */
        public ReportData[] getZReport(Date StarttDate, Date EndDate)throws PrinterException
        {  
            Calendar Cale = Calendar.getInstance();
            Calendar Cale2 = Calendar.getInstance();
           Cale.setTime(StarttDate);       
           
           int y =   Cale.get(Calendar.YEAR);
           int m = Cale.get(Calendar.MONTH);
           int d = Cale.get(Calendar.DAY_OF_MONTH);
           
           Cale2.setTime(EndDate); 
           
           int y2 =   Cale2.get(Calendar.YEAR);
           int m2 = Cale2.get(Calendar.MONTH);
           int d2 = Cale2.get(Calendar.DAY_OF_MONTH);
         
          String Day = String.valueOf(d);
       while(Day.length()<2)
    {
        Day = "0" + Day;
    }
      String Mess = String.valueOf(m+1);
       while(Mess.length()<2)
    {
       Mess = "0" + Mess;
    }
       String Ano = String.valueOf(y).substring(2,4);
        String Day2 = String.valueOf(d2);
       while(Day2.length()<2)
    {
        Day2 = "0" + Day2;
    }
      String Mess2 = String.valueOf(m2+1);
       while(Mess2.length()<2)
    {
       Mess2 = "0" + Mess2;
    }
       String Ano2 = String.valueOf(y2).substring(2,4);
       
        String IntervaloFi =  Day + Mess + Ano;
        String IntervaloFf =  Day2 + Mess2 + Ano2;
        
		try
		{
		
		int rep =  this.SubirDataReport("U2A" + IntervaloFi + IntervaloFf);
		
            if (rep>0)
           {  
               int  h=0;
           
            this.ReporteArrayPC = new ReportData[this.dataLectorFisc.size()];
            /*
             for(Object contenido : this.dataLectorFisc)
              {
                 this.ReporteArrayPC[h] = new ReportData((String)contenido);
                 ++h;
              }
              */
              for (int i = 0; i < this.dataLectorFisc.size(); i++) {  
                                  Object contenido = this.dataLectorFisc.get(i);  
                                 this.ReporteArrayPC[h] = new ReportData((String)contenido);
                 ++h;
                                }  
             
                Estado = " Status: 00  Error: 00";
            }
           else
           {
             this.ReporteArrayPC = null;
             Estado = "Sin repuesta";
             
              if (Integer.parseInt(Ano + Mess + Day )>Integer.parseInt(Ano2 + Mess2 + Day2))
            		   this.Estado = "The date can not be larger than the final date";
             
             throw new PrinterException(Estado, getPrinterStatus());
           }
         
            return ReporteArrayPC;
			
			}catch (NullPointerException ex) {
            this.ReporteArrayPC = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
		
        }
        /**
   	  *Imprime Reporte de Lectura de Memoria Fiscal por rango de fechas
             *@param StartDate Fecha inicial del  Z a imprimir
             *@param EndDate Fecha final del  Z a imprimir
             *@throws PrinterException Error de  transacci?n.
             */
           public void printZReport(Date StartDate, Date EndDate)throws PrinterException
           {  
               Calendar Cale = Calendar.getInstance();
               Calendar Cale2 = Calendar.getInstance();
              Cale.setTime(StartDate);       
              
              int y =   Cale.get(Calendar.YEAR);
              int m = Cale.get(Calendar.MONTH);
              int d = Cale.get(Calendar.DAY_OF_MONTH);
              
              Cale2.setTime(EndDate); 
              
              int y2 =   Cale2.get(Calendar.YEAR);
              int m2 = Cale2.get(Calendar.MONTH);
              int d2 = Cale2.get(Calendar.DAY_OF_MONTH);
            
             String Day = String.valueOf(d);
          while(Day.length()<2)
       {
           Day = "0" + Day;
       }
         String Mess = String.valueOf(m+1);
          while(Mess.length()<2)
       {
          Mess = "0" + Mess;
       }
          String Ano = String.valueOf(y).substring(2,4);
           String Day2 = String.valueOf(d2);
          while(Day2.length()<2)
       {
           Day2 = "0" + Day2;
       }
         String Mess2 = String.valueOf(m2+1);
          while(Mess2.length()<2)
       {
          Mess2 = "0" + Mess2;
       }
          String Ano2 = String.valueOf(y2).substring(2,4);
          
           String IntervaloFi =  Day + Mess + Ano;
           String IntervaloFf =  Day2 + Mess2 + Ano2;
           
            boolean rep =  this.SendCmd("I2A" + IntervaloFi + IntervaloFf);
               if (!rep)
              {  
            	   if (Integer.parseInt(Ano + Mess + Day )>Integer.parseInt(Ano2 + Mess2 + Day2))
            		   this.Estado = "The date can not be larger than the final date";
            	   
               throw new PrinterException(Estado, getPrinterStatus());
              }
           }
  /**
   *Imprime un Reporte de Lectura de Memoria Fiscal por rango de n?meros
   *@param StartReportNumber N?mero del  Z inicial a imprimir
   *@param EndReportNumber N?mero del  Z final a imprimir
   *@throws PrinterException Error de  transacci?n.
   */
   public void printZReport(int StartReportNumber, int EndReportNumber ) throws PrinterException
   {  
     String IntervaloNi =  String.valueOf(StartReportNumber);
     while(IntervaloNi.length()<6)
     {
         IntervaloNi = "0" + IntervaloNi;
     }
     String IntervaloNf =  String.valueOf(EndReportNumber);
     while(IntervaloNf.length()<6)
     {
         IntervaloNf = "0" + IntervaloNf;
     }

      boolean rep =  this.SendCmd("I3A" + IntervaloNi + IntervaloNf);
      if (!rep)
      { 
              if (StartReportNumber > EndReportNumber)
              this.Estado = "The original number can not be greater than the final number";

              throw new PrinterException(Estado, getPrinterStatus());
      }


   }
   /**
     *Imprime un Reporte X.
     *@throws PrinterException Error de  transacci?n.
     */
       public void printXReport() throws PrinterException
       {  
         boolean rep =  this.SendCmd("I0X");
         if(!rep)
           throw new PrinterException(Estado, getPrinterStatus());

       }
    /**
     *Imprime un Reporte Z.
     *@throws PrinterException Error de  transacci?n.
     */
      public void printZReport() throws PrinterException
      {  
        boolean rep =  this.SendCmd("I0Z"); 
        if(!rep)
          throw new PrinterException(Estado, getPrinterStatus());

      }
     /**
     *Sube el estado S1 de la Impresora fiscal y retorna un objeto de tipo S1PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S1PrinterData getS1PrinterData() throws PrinterException
      {
	  try
	  {
        int rep = this.SubirDataStatus("S1");
		
        if(rep>0)
        {
            //S1 is empty yet
//           this.S1Estado = new S1PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S1Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S1Estado;
		
		} catch (NullPointerException ex) {
            this.S1Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
		
      }
      /**
     *Sube el estado S2 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS2PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S2");
		
        if(rep>0)
        {
           this.S2Estado = new S2PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S2Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S2Estado;
		
		}catch (NullPointerException ex) {
            this.S2Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S2E de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el subtotal Exento.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS2EPrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S2E");
		
        if(rep>0)
        {
           this.S2Estado = new S2PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S2Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S2Estado;
		
		}catch (NullPointerException ex) {
            this.S2Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S21 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el Base imponible tasa 1.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS21PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S21");
		
        if(rep>0)
        {
           this.S2Estado = new S2PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S2Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S2Estado;
		
		}catch (NullPointerException ex) {
            this.S2Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
       /**
     *Sube el estado S22 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el Base imponible tasa 2.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS22PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S22");
		
        if(rep>0)
        {
           this.S2Estado = new S2PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S2Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S2Estado;
		
		}catch (NullPointerException ex) {
            this.S2Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
       /**
     *Sube el estado S23 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el Base imponible tasa 3.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS23PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S23");
		
        if(rep>0)
        {
           this.S2Estado = new S2PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S2Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S2Estado;
		
		}catch (NullPointerException ex) {
            this.S2Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S3 de la Impresora fiscal y retorna un objeto de tipo S3PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S3PrinterData getS3PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S3");
		
        if(rep>0)
        {
           this.S3Estado = new S3PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S3Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S3Estado;
		
		} catch (NullPointerException ex) {
            this.S3Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S4 de la Impresora fiscal y retorna un objeto de tipo S4PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S4PrinterData getS4PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S4");
		
        if(rep>0)
        {
           this.S4Estado = new S4PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S4Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S4Estado;
		
		} catch (NullPointerException ex) {
            this.S4Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S5 de la Impresora fiscal y retorna un objeto de tipo S5PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S5PrinterData getS5PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S5");
		
        if(rep>0)
        {
           this.S5Estado = new S5PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S5Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S5Estado;
		
		} catch (NullPointerException ex) {
            this.S5Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
	   /**
     *Sube el estado S6 de la Impresora fiscal y retorna un objeto de tipo S6PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S6PrinterData getS6PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S6");
		
        if(rep>0)
        {
           this.S6Estado = new S6PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S6Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S6Estado;
		
		} catch (NullPointerException ex) {
            this.S6Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
     *Sube el estado S7 de la Impresora fiscal y retorna un objeto de tipo S7PrinterData con los par$)G"gmetros de informaci?n.
     *@throws PrinterException Error de  transacci?n.
     */
      public S7PrinterData getS7PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S7");
		
        if(rep>0)
        {
           this.S7Estado = new S7PrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S7Estado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S7Estado;
		
		}catch (NullPointerException ex) {
            this.S7Estado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
       *Sube el estado S8E de la Impresora fiscal y retorna un objeto de tipo S8EPrinterData con los parametros de informaci?n.
       *@throws PrinterException "??????????".
       */
      public S8EPrinterData getS8EPrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S8E");
		
        if(rep>0)
        {
           this.S8EEstado = new S8EPrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S8EEstado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S8EEstado;
		
		}catch (NullPointerException ex) {
            this.S8EEstado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
      /**
       *Sube el estado S8P de la Impresora fiscal y retorna un objeto de tipo S8PrinterData con los parametros de informaci?n.
       *@throws PrinterException "??????????".
       */
      public S8PPrinterData getS8PPrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S8P");
		
        if(rep>0)
        {
           this.S8PEstado = new S8PPrinterData(this.sDataSubida);
           Estado = " Status: 00  Error: 00";
        }
        else
        {
             this.S8PEstado = null;
             Estado = "Sin repuesta";
            throw new PrinterException(Estado, getPrinterStatus());
        }
        
        return S8PEstado;
		
		}catch (NullPointerException ex) {
            this.S8PEstado = null;
            Estado = ex.getMessage();
                throw new PrinterException(Estado, getPrinterStatus());
        }
      }
}
