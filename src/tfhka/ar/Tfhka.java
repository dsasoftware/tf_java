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
        /**Objeto de tipo ReportData que se carga al subir reporte X ??ï¿½ Z del PC por medio de los m??ï¿½todos getZReport()  y  getXReport()*/
        private ReportData ReportePC;

        /**Arreglo de Objetos de tipo ReportData que se cargan al subir lectura de memoria fiscal del PC mediante los m??ï¿½todos getZReport(Date fecha1, Date fecha2)
         * y getZReport(int nroZ1, int nroZ2).
         */
        private ReportData[] ReporteArrayPC;       
         /**Objeto de tipo S1PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S1 por el m??ï¿½todo  getS1PrinterData()*/
        private S1PrinterData S1Estado;
        /**Objeto de tipo S2PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S2 por el m??ï¿½todo  getS2PrinterData()*/
        private S2PrinterData S2Estado;
        /**Objeto de tipo S3PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S3 por el m??ï¿½todo  getS3PrinterData()*/
        private S3PrinterData S3Estado;
        /**Objeto de tipo S4PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S4 por el m??ï¿½todo  getS4PrinterData()*/
        private S4PrinterData S4Estado;
        /**Objeto de tipo S5PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S5 por el m??ï¿½todo  getS5PrinterData()*/
        private S5PrinterData S5Estado;
        /**Objeto de tipo S6PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S6 por el m??ï¿½todo  getS6PrinterData()*/
        private S6PrinterData S6Estado;
        /**Objeto de tipo S7PrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S7 por el m??ï¿½todo  getS7PrinterData()*/
        private S7PrinterData S7Estado;
        //PARAMETROS AGREGADOS
        /**Objeto de tipo S8EPrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S8E por el m??ï¿½todo  getS8EPrinterData()*/
        private S8EPrinterData S8EEstado;
        /**Objeto de tipo S8PPrinterData que carga informaci??ï¿½n cuando se hace una subida de estado S8P por el m??ï¿½todo  getS8EPrinterData()*/
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
        /*
        #region SubReportes X

        /// <summary>
        /// Sube la información acumulada de ventas actuales, 1er paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FirstPackageClass GetX01Report()
        {

            int rep = 0;
            ReportData.FirstPackageClass Report;
            rep = this.SubirDataReport("U0X00");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FirstPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 2do paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SecondPackageClass GetX02Report()
        {

            int rep = 0;
            ReportData.SecondPackageClass Report;
            rep = this.SubirDataReport("U0X01");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SecondPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 3er paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.ThirdPackageClass GetX03Report()
        {

            int rep = 0;
            ReportData.ThirdPackageClass Report;
            rep = this.SubirDataReport("U0X02");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.ThirdPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 4to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FourthPackageClass GetX04Report()
        {

            int rep = 0;
            ReportData.FourthPackageClass Report;
            rep = this.SubirDataReport("U0X03");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FourthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 5to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FifthPackageClass GetX05Report()
        {

            int rep = 0;
            ReportData.FifthPackageClass Report;
            rep = this.SubirDataReport("U0X04");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FifthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 6to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SixthPackageClass GetX06Report()
        {

            int rep = 0;
            ReportData.SixthPackageClass Report;
            rep = this.SubirDataReport("U0X05");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SixthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 7mo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SeventhPackageClass GetX07Report()
        {

            int rep = 0;
            ReportData.SeventhPackageClass Report;
            rep = this.SubirDataReport("U0X06");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SeventhPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 8vo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.EightPackageClass GetX08Report()
        {

            int rep = 0;
            ReportData.EightPackageClass Report;
            rep = this.SubirDataReport("U0X07");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.EightPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, 9no paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.NinthPackageClass GetX09Report()
        {

            int rep = 0;
            ReportData.NinthPackageClass Report;
            rep = this.SubirDataReport("U0X08");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.NinthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, 10mo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.TenthPackageClass GetX10Report()
        {

            int rep = 0;
            ReportData.TenthPackageClass Report;
            rep = this.SubirDataReport("U0X09");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.TenthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, undécimo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.EleventhPackageClass GetX11Report()
        {

            int rep = 0;
            ReportData.EleventhPackageClass Report;
            rep = this.SubirDataReport("U0X10");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.EleventhPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        #endregion

        #region SubReportes Z

        /// <summary>
        /// Sube la información acumulada de ventas actuales, 1er paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FirstPackageClass GetZ01Report()
        {

            int rep = 0;
            ReportData.FirstPackageClass Report;
            rep = this.SubirDataReport("U0Z00");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FirstPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 2do paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SecondPackageClass GetZ02Report()
        {

            int rep = 0;
            ReportData.SecondPackageClass Report;
            rep = this.SubirDataReport("U0Z01");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SecondPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 3er paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.ThirdPackageClass GetZ03Report()
        {

            int rep = 0;
            ReportData.ThirdPackageClass Report;
            rep = this.SubirDataReport("U0Z02");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.ThirdPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 4to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FourthPackageClass GetZ04Report()
        {

            int rep = 0;
            ReportData.FourthPackageClass Report;
            rep = this.SubirDataReport("U0Z03");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FourthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 5to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.FifthPackageClass GetZ05Report()
        {

            int rep = 0;
            ReportData.FifthPackageClass Report;
            rep = this.SubirDataReport("U0Z04");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.FifthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 6to paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SixthPackageClass GetZ06Report()
        {

            int rep = 0;
            ReportData.SixthPackageClass Report;
            rep = this.SubirDataReport("U0Z05");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SixthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 7mo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.SeventhPackageClass GetZ07Report()
        {

            int rep = 0;
            ReportData.SeventhPackageClass Report;
            rep = this.SubirDataReport("U0Z06");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.SeventhPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }


        /// <summary>
        /// Sube la información acumulada de ventas actuales, 8vo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.EightPackageClass GetZ08Report()
        {

            int rep = 0;
            ReportData.EightPackageClass Report;
            rep = this.SubirDataReport("U0Z07");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.EightPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, 9no paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.NinthPackageClass GetZ09Report()
        {

            int rep = 0;
            ReportData.NinthPackageClass Report;
            rep = this.SubirDataReport("U0Z08");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.NinthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, 10mo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.TenthPackageClass GetZ10Report()
        {

            int rep = 0;
            ReportData.TenthPackageClass Report;
            rep = this.SubirDataReport("U0Z09");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.TenthPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        
        /// <summary>
        /// Sube la información acumulada de ventas actuales, undécimo paquete.
        /// <exception cref="PrinterException">Thrown cuando ocurre un error en la transacción con la impresora fiscal</exception>
        /// </summary>
        public ReportData.EleventhPackageClass GetZ11Report()
        {

            int rep = 0;
            ReportData.EleventhPackageClass Report;
            rep = this.SubirDataReport("U0Z10");

            if (rep > 0) // Se procesó al menos una línea
            {
                string dataArray = null;
                foreach (string contenido in this.dataLectorFisc)
                {
                    dataArray = contenido;
                }

                Report = new ReportData.EleventhPackageClass(dataArray);


                this.ReiniciarVariables();
            }
            else
            {
                this.ReiniciarVariables();
                throw new PrinterException(Estado);
            }

            return Report;


        }

        #endregion

      */
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
