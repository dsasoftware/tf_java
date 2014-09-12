package tfhka.rd;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import gnu.io.*;
//import javax.comm.*;
import tfhka._private.TfhkaRaiz;
import tfhka.*;

/** 
* Representa una Libreria de Clase para Protocolo de Comunicacion Directo
* de la impresora fiscal con apliciones java, empleando la API de comunicacion RXTXcomm.jar.
*/ 
public final  class Tfhka extends TfhkaRaiz {

	// Declaracion de los Atributos a utilizar
	private static Enumeration listaPuertos;
	private static CommPortIdentifier idPuerto;
        /**Objeto de tipo ReportData que se carga al subir reporte X ??� Z del PC por medio de los m??�todos getZReport()  y  getXReport()*/
	private ReportData ReportePC;
         /**Objeto de tipo AcumuladosX que se carga al subir reporte X4, X5 y X7 del PC por medio de los metodos getX4Report(), getX5Report()  y  getX7Report()*/
	private AcumuladosX ReporteAcumX;
        /**Arreglo de Objetos de tipo ReportData que se cargan al subir lectura de memoria fiscal del PC mediante los m??�todos getZReport(Date fecha1, Date fecha2)
         * y getZReport(int nroZ1, int nroZ2).
         */
	private ReportData[] ReporteArrayPC;
         /**Objeto de tipo PrinterStatus que se carga al leer Status y Error de la impresora por medio del m??�todo getPrinterStatus()*/       
	private PrinterStatus StatusErrorPrinter;
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

        tempBuffer = new byte[1000];

        OpenFpctrl(puerto);
        comPort = puerto;


        // PortReceiveStatus = _SerialPortReceiveStatus.Espera;
        PortReceiveStatus = Espera;
        _dataReady = false;
        _bytesRecibidos = 0;
        _auxBytesRecibidos = 0;
        setSerialPortReceiveTimeout(20); // El timeout por defecto se aument� de 10 a 20
        setSendCmdRetryAttempts(2);   // Por defecto no se intenta reenviar un comando fallido
        setSendCmdRetryInterval(5000); // Tiempo en milisegundos a esperan antes de reenviar un comando fallido por NAK
         if(!UsandoLineasControl)
        UsandoLineasControl = false; // Esto s�lo para iniciar la propiedad, realemnte se sabr� si se usan l�neas de control a abrir el puerto
    }
        /**
	*Inicializa una nueva instancia de la clase Tfhka
        */
        public Tfhka()
        {
            tempBuffer = new byte[1000]; 
            //PortReceiveStatus = _SerialPortReceiveStatus.Espera;
             PortReceiveStatus = Espera;
            _dataReady = false;
            _bytesRecibidos = 0;
            _auxBytesRecibidos = 0;
            setSerialPortReceiveTimeout(20); // El timeout por defecto se aument� de 10 a 20
            setSendCmdRetryAttempts(2);   // Por defecto no se intenta reenviar un comando fallido
            setSendCmdRetryInterval(5000); // Tiempo en milisegundos a esperan antes de reenviar un comando fallido por NAK
               UsandoLineasControl = false; // Esto s�lo para iniciar la propiedad, realemnte se sabr� si se usan l�neas de control a abrir el puerto

        }           
	/**
         * Metodo para la Configuracion del Puerto.
         * Retorna la indicaci?n de apertura.
	 *@param IpPortName Nombre del Puerto Serial
         */
    public boolean OpenFpctrl(String IpPortName)
    {
        this.Terminar = IpPortName;
        boolean puerto = false;

        try
        {

            listaPuertos = CommPortIdentifier.getPortIdentifiers();
            while (listaPuertos.hasMoreElements())
            {
                idPuerto = (CommPortIdentifier) listaPuertos.nextElement();
                if (idPuerto.getPortType() == CommPortIdentifier.PORT_SERIAL)
                {
                    // idPuerto.getName().equals("/dev/term/a") )
                    // idPuerto.getName().equals("COM1") )
                    if (idPuerto.getName().equals(IpPortName))
                    {
                        // Si el puerto no esta en uso, se intenta abrir
                        puertoSerie = (SerialPort) idPuerto.open(
                                "AplEscritura", 2000);
                        puerto = true;

                        // Se obtiene un canal de salida					
                        salida = puertoSerie.getOutputStream();
                        entrada = puertoSerie.getInputStream();
                        puerto = puerto && true;


                        // Se fijan los parametros de comunicacion del puerto

                        puertoSerie.setSerialPortParams(9600,
                                SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                                SerialPort.PARITY_EVEN);
                        //puertoSerie.enableReceiveTimeout(10000);
                        puertoSerie.notifyOnCTS(true);

                        puerto = puerto && true;


                        // Se establecen las notificaciones de Eventos
                        puertoSerie.notifyOnOutputEmpty(true);
                        puertoSerie.addEventListener(this);
                        puertoSerie.notifyOnDataAvailable(true);

                        puerto = puerto && true;

                    }

                }

            }

			this.IndPuerto = puerto;

			if (puerto == true) {
				if (ManipulaCTS_RTS()) {
					UsandoLineasControl = true;
					puertoSerie.notifyOnCTS(true);
					Estado = "Puerto Abierto";
				} else if (CheckFprinter()) {
					UsandoLineasControl = false;
					puertoSerie.setRTS(false);
					Estado = "Puerto Abierto";
				} else {
					Estado = "Impresora no detectada";
					this.IndPuerto = false;
					puerto = this.IndPuerto;
				}

			} else {
				Estado = "Error al Abrir puerto";
			}

			return puerto;

		} catch (java.util.TooManyListenersException e) {
			Estado = e.getMessage();
			return false;
		} catch (PortInUseException e) {
			Estado = e.getMessage();
			return false;
		} catch (IOException e) {
			Estado = e.getMessage();
			return false;
		} catch (UnsupportedCommOperationException e) {
			Estado = e.getMessage();
			return false;
		} catch (Exception ioe) {
			Estado = ioe.getMessage();
			return false;
		}

	}

    /**
     * Metodo para Cerrar el Puerto serie
     */
	public void CloseFpctrl() {
		try {
			puertoSerie.close();
			this.IndPuerto = false;

		} catch (NullPointerException e) {
		}
	}

    /**
     * Metodo para Chequear la conexi?n de la Impresora.
     */
    public boolean CheckFprinter()
    {

        if (!IndPuerto)
        {
            Estado = "Port Closed";
            return false;
        }

        int bytesRecibidos = 0;
        int timeoutActual = _SerialPortReceiveTimeout;

        _SerialPortReceiveTimeout = 2;
        try
        {
            bytesRecibidos = SerialPortWriteAndRead(new char[] { ENQ }, false);

            if (bytesRecibidos < 0)
            {
                bytesRecibidos = SerialPortWriteAndRead(new char[] { ENQ }, false);
            }

            _SerialPortReceiveTimeout = timeoutActual;

            if (bytesRecibidos >= 5) // por seguridad le dejamos el mayor o igual a 5 ( >=5 ), o se deja en == 5
            {
                this.ReiniciarVariables();
                return true;
            }
            else
            {
                this.ReiniciarVariables();
                return false;
            }

        }
        catch (IOException e4)
        {
            Estado = e4.getMessage();
            this.ReiniciarVariables();

            return false;
        }
        catch (NullPointerException e1)
        {
            Estado = e1.getMessage();
            this.ReiniciarVariables();

            return false;
        }
    }
         /// <summary>
        /// M�todo para Chequear la Apertura de Gaveta
        /// </summary>
        public boolean CheckDrawer() // Error ortogr�fico corregido
        {        
 
            int bytesRecibidos = 0;

                if (!IndPuerto)   //  Misma observaci�n de la funcion CheckFprinter()
                {
                    return false;
                }
        try {
            bytesRecibidos = SerialPortWriteAndRead(new char[] { ENQ },false); // ENQ
        } catch (IOException ex) {
            Logger.getLogger(Tfhka.class.getName()).log(Level.SEVERE, null, ex);
        }


                if (bytesRecibidos >= 5)
                {
                    int byteGav = (int)bResp[2] & 0x0008;

                    this.ReiniciarVariables();

                    if (byteGav == 0x0008)
                    { return true; }
                    else
                    { return false; }
                }
                else
                {
                    this.ReiniciarVariables();

                    return false;
                }

        }
	/**
	 *Metodo para el Envio de Comandos
	 *@param cmd Comando en trama ? cadena de caracteres ASCII
         *@throws PrinterException Error de  transacci?n.
         */
public boolean SendCmd(String sCMD) throws PrinterException
    {
        Mensaje = STX + sCMD + ETX + LRC;

        char[] cCMD = Mensaje.toCharArray();
        int bytesRecibidos = 0;
        int Reintentos = 0;
        cCMD[cCMD.length - 1] = Do_XOR(sCMD);
        try
        {
            // Se env�a el mensaje                        
            bytesRecibidos = SerialPortWriteAndRead(cCMD, true);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Tfhka.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ((bytesRecibidos == 1) && (bResp[0] == (byte) ACK)) // bien, ACK
        {
            // this.envio = "Status: 00  Error: 00";
            this.ReiniciarVariables();
            return true;
        }
        else
        {

            while ((bResp[0] == (byte) NAK) && (Reintentos < getSendCmdRetryAttempts()))
            {
                try
                {
                    Thread.sleep(getSendCmdRetryInterval()); // Esperamos unos pocos milisegundos antes de reintentar enviar el comando por NAK
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Tfhka.class.getName()).log(Level.SEVERE, null, ex);
                }
                try
                {
                    // Se reenv�a el mensaje                        
                    bytesRecibidos = SerialPortWriteAndRead(cCMD, true);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Tfhka.class.getName()).log(Level.SEVERE, null, ex);
                }
                ++Reintentos;
            }

            this.ReiniciarVariables();

            if ((bytesRecibidos == 1) && (bResp[0] == (byte) ACK)) // bien, ACK
            {
                return true;
            }
            else if ((bytesRecibidos == 1) && (bResp[0] == (byte) NAK)) // bien, ACK
            {
                //   this.envio = "Status: 00  Error: 89";
                return false;
            }
            else if (bytesRecibidos == -1)
            {
                StatusErrorPrinter = new PrinterStatus(0, 89, false, status, error);

                throw new PrinterException("Error de Comunicacion.", StatusErrorPrinter);
            }
            else
            {
                return false;
            }

        }
    }
	/**
	 *Metodo para el Envio de Comandos por medio de un Archivo.txt o .dat.
         *Retorna el numero de linea procedades del archivo.
	 *@param file Ruta de ubicaci?n o Nombre del archivo.txt o .dat. Ejemplo: "C/User/Desktop/mi_file.dat"
         */
	public int SendFileCmd(String file) { // Lee un archivo
				
			BufferedReader entradaf;
			try {
				FileReader fr = new FileReader(file);
				entradaf = new BufferedReader(fr);
				String s;
                                int ite = 0;
				while ((s = entradaf.readLine()) != null) {
					boolean rep = SendCmd(s);
                                        if(rep)
                                        {++ite;}
				}
				entradaf.close();
				
				return ite;
                                
			} catch (java.io.FileNotFoundException fnfex) {				
                                Estado = fnfex.getMessage();
				return -1;
			} catch (java.io.IOException ioex) {				
                                  Estado = ioex.getMessage();
				return 0;
			}catch (PrinterException pex)
                        {    
                            Estado = pex.getMessage();
                            return 0;
                        }		

	}
	/**
	 *Subes los Distintos Status de la Impresora al PC y lo copia en un
	 *Archivo.txt.
	 *@param Cmd Comando o trama 
	 *@param file Ruta o Nombre del archivo.txt o .dat 
         */
    public boolean UploadStatusCmd(String Cmd, String file)
    {

        int interv = 0;
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salidaf = new PrintWriter(bw);

            interv = this.SubirDataStatus(Cmd);

            salidaf.println(sDataSubida);
            salidaf.close();

            if (interv != 0)
            {
                Estado = " Status: 00  Error: 00";
                this.ReiniciarVariables();
                return true;
            }
            else
            {
                Estado = "Sin repuesta";
                this.ReiniciarVariables();
                return false;
            }

        }
        catch (java.io.IOException ioex)
        {
            Estado = ioex.getMessage();
            this.ReiniciarVariables();
            return false;
        }
        catch (NullPointerException e2)
        {
            Estado = e2.getMessage();
            this.ReiniciarVariables();
            return false;
        }
    }

	/**
	 *Sube uno ? varios Reportes al PC y lo carga en un archivo.txt
	 *@param Cmd Comando o trama 
	 *@param file Ruta o Nombre del archivo.txt o .dat 
         */
	public boolean UploadReportCmd(String Cmd, String file)
    {

        String lineno = "";
        int interv = 0;

        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salidaf = new PrintWriter(bw);

 
            interv = this.SubirDataReport(Cmd);

   
            /*
             for(Object contenido : this.dataLectorFisc)
             {
             lineno += (String)contenido + "\r\n";
             }
             */
            for (int i = 0; i < this.dataLectorFisc.size(); i++)
            {
                Object contenido = this.dataLectorFisc.get(i);
                lineno += (String) contenido + "\r\n";
            }

            salidaf.println(lineno);
            salidaf.close();

            if (interv != 0)
            {
                Estado = " Status: 00  Error: 00";
                this.ReiniciarVariables();
                return true;
            }
            else
            {
                Estado = "Sin repuesta";
                this.ReiniciarVariables();
                return false;
            }


        }
        catch (java.io.IOException ioex)
        {
            Estado = ioex.getMessage();
            this.ReiniciarVariables();
            return false;
        }
        catch (NullPointerException e2)
        {
            Estado = e2.getMessage();
            this.ReiniciarVariables();
            return false;
        }
    }
       
	/**
	 * Lee el Status y Error de la Impresora Fiscal
	 */
	   public
            boolean ReadFpStatus()
    {
        int bytesRecibidos = 0;
        try
        {
            int timeoutActual = _SerialPortReceiveTimeout;

            _SerialPortReceiveTimeout = 2;

            bytesRecibidos = SerialPortWriteAndRead(new char[]
                    {
                        ENQ
                    }, false); // solicitamos ENQ

            if (bytesRecibidos < 0)
            {
                bytesRecibidos = SerialPortWriteAndRead(new char[]
                        {
                            ENQ
                        }, false);
            }

            _SerialPortReceiveTimeout = timeoutActual;


            int st = 0, er = 0, lrc = 0;

            if (bytesRecibidos == 5)
            {
                for (int i = 0; i < 5; ++i)
                {
                    if (i == 1)
                    {
                        st = (int) bResp[i];
                    }
                    else if (i == 2)
                    {
                        er = (int) bResp[i];
                    }
                    else if (i == 4)
                    {
                        lrc = (int) bResp[i];
                    }

                }

                if ((st ^ er ^ 0x03) != lrc)
                {
                    DarStatus_Error(0, 144);
                }
                else
                {
                    DarStatus_Error(st, er);
                }

                if (status != null && error != null)
                {
                    this.estado = "OK...";
                    this.ReiniciarVariables();
                    return true;
                }
                else
                {
                    this.estado = "No hay Repuesta";
                    this.ErroValid = false;
                    this.descripStatus = "No Answer";
                    this.descripError = "No Answer";
                    this.ReiniciarVariables();
                    return false;
                }
            }
            else
            {
                DarStatus_Error(0, 137);
                this.ReiniciarVariables();
                return false;
            }
        }
        catch (IOException e)
        {
            Estado = "Error... " + e.getMessage();
            this.ReiniciarVariables();
            return false;
        }
        catch (NullPointerException e1)
        {
            Estado = "Error... " + e1.getMessage();
            this.ReiniciarVariables();
            return false;
        }
    }
        /**
	 *Retorna un objeto PrinterStatus con  la informacion del status y error  de la impresora
	 */ 
        public PrinterStatus getPrinterStatus()
        {
          this.ReadFpStatus();
          
          if (status == null && error == null)
              this.DarStatus_Error(0,128);
          
          this.StatusErrorPrinter = new PrinterStatus(Integer.parseInt(this.status),Integer.parseInt(this.error),this.ErroValid,this.descripStatus,this.descripError);
          
          return StatusErrorPrinter;
        }
        
        // <editor-fold defaultstate="collapsed" desc="SubReportesX">
        /**
	 *Retorna un objeto  de tipo ReportData  con todas la informaci?n para la carga de un reporte X actual("U0X").
         *@throws PrinterException Error de  transacci?n.
	 */
	public ReportData.BasicInfoClass getX01Report() throws PrinterException {
		try {
                        ReportData.BasicInfoClass report;
			int rep = this.SubirDataReport("U0X01");

			if (rep > 0) {
				report = new ReportData.BasicInfoClass(this.sDataSubida);
				// this.ReportePC = new ReportData(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReportePC = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.InvoicesAccumulatedClass getX02Report() throws PrinterException {
		try {
                     ReportData.InvoicesAccumulatedClass report;
			int rep = this.SubirDataReport("U0X02");

			if (rep > 0) {
				report = new ReportData.InvoicesAccumulatedClass(this.sDataSubida);				
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReportePC = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.CreditNotesAccumulatedClass getX03Report() throws PrinterException {
		try {
                        ReportData.CreditNotesAccumulatedClass report;
			int rep = this.SubirDataReport("U0X03");

			if (rep > 0) {
				report = new ReportData.CreditNotesAccumulatedClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReportePC = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.OtherAccumulatedClass getX04Report() throws PrinterException {
		try {
                        ReportData.OtherAccumulatedClass report;
			int rep = this.SubirDataReport("U0X04");

			if (rep > 0) {
				report = new ReportData.OtherAccumulatedClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReportePC = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="SubReportesZ">
	/**
	 * Retorna un objeto de tipo ReportData con todas la informaci?n del ?ltimo
	 * reporte Z reaizado ("U0Z").
	 * 
	 * @throws PrinterException
	 *             Error de transacci?n.
	 */
	public ReportData.BasicInfoClass getZ01Report() throws PrinterException {
		try {
                        ReportData.BasicInfoClass report;
			int rep = this.SubirDataReport("U0Z01");
			if (rep > 0) {
				report = new ReportData.BasicInfoClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			this.ReportePC = null;
			Estado = ex.getMessage();
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.InvoicesAccumulatedClass getZ02Report() throws PrinterException {
		try {
                        ReportData.InvoicesAccumulatedClass report;
			int rep = this.SubirDataReport("U0Z02");
			if (rep > 0) {
				report = new ReportData.InvoicesAccumulatedClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			this.ReportePC = null;
			Estado = ex.getMessage();
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.CreditNotesAccumulatedClass getZ03Report() throws PrinterException {
		try {
                        ReportData.CreditNotesAccumulatedClass report;
			int rep = this.SubirDataReport("U0Z03");
			if (rep > 0) {
				report = new ReportData.CreditNotesAccumulatedClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			this.ReportePC = null;
			Estado = ex.getMessage();
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	public ReportData.OtherAccumulatedClass getZ04Report() throws PrinterException {
		try {
                        ReportData.OtherAccumulatedClass report;
			int rep = this.SubirDataReport("U0Z04");
			if (rep > 0) {
				report = new ReportData.OtherAccumulatedClass(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				report = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return report;

		} catch (NullPointerException ex) {
			this.ReportePC = null;
			Estado = ex.getMessage();
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="AcumuladosX">
	/**
	 * Retorna un objeto de tipo AcumuladosX con todas la informaci?n para la
	 * carga de un reporte X2 actual (U0X4).
	 * 
	 * @throws PrinterException
	 *             Error de transaccion.
	 */
	public AcumuladosX getX2Report() throws PrinterException {
		try {

			int rep = this.SubirDataReport("U0X2");

			if (rep > 0) {
				this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteAcumX = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteAcumX;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReporteAcumX = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	/**
	 * Retorna un objeto de tipo AcumuladosX con todas la informaci?n para la
	 * carga de un reporte X3 actual (U0X4).
	 * 
	 * @throws PrinterException
	 *             Error de transaccion.
	 */
	public AcumuladosX getX3Report() throws PrinterException {
		try {

			int rep = this.SubirDataReport("U0X3");

			if (rep > 0) {
				this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteAcumX = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteAcumX;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReporteAcumX = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	/**
	 * Retorna un objeto de tipo AcumuladosX con todas la informaci?n para la
	 * carga de un reporte X4 actual (U0X4).
	 * 
	 * @throws PrinterException
	 *             Error de transaccion.
	 */
	public AcumuladosX getX4Report() throws PrinterException {
		try {

			int rep = this.SubirDataReport("U0X4");

			if (rep > 0) {
				this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteAcumX = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteAcumX;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReporteAcumX = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	/**
	 * Retorna un objeto de tipo AcumuladosX con todas la informaci?n para la
	 * carga de un reporte X5 actual (U0X5).
	 * 
	 * @throws PrinterException
	 *             Error de transaccion.
	 */
	public AcumuladosX getX5Report() throws PrinterException {
		try {

			int rep = this.SubirDataReport("U0X5");

			if (rep > 0) {
				this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteAcumX = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteAcumX;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReporteAcumX = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}

	/**
	 * Retorna un objeto de tipo AcumuladosX con todas la informaci?n para la
	 * carga de un reporte X7 actual (U0X7).
	 * 
	 * @throws PrinterException
	 *             Error de transaccion.
	 */
	public AcumuladosX getX7Report() throws PrinterException {
		try {

			int rep = this.SubirDataReport("U0X7");

			if (rep > 0) {
				this.ReporteAcumX = new AcumuladosX(this.sDataSubida);
				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteAcumX = null;
				Estado = "Sin repuesta";
				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteAcumX;

		} catch (NullPointerException ex) {
			Estado = ex.getMessage();
			this.ReporteAcumX = null;
			throw new PrinterException(Estado, getPrinterStatus());
		}

	}
        // </editor-fold>
            
       /**
	*Retorna un arreglo de objetos  ReportData Z con todos sus atributos por rango de n??�meros
	*@param StartReportNumber N??�mero del  Z inicial a subir
        *@param EndReportNumber N??�mero del  Z final a subir
        *@throws PrinterException Error de  transacci??�n.
        */
        public ReportData[] getZReport(int StartReportNumber, int EndReportNumber ) throws PrinterException
        {  
		String IntervaloNi = String.valueOf(StartReportNumber);
		while (IntervaloNi.length() < 6) {
			IntervaloNi = "0" + IntervaloNi;
		}
		String IntervaloNf = String.valueOf(EndReportNumber);
		while (IntervaloNf.length() < 6) {
			IntervaloNf = "0" + IntervaloNf;
		}
		  
          try {  
            int rep =  this.SubirDataReport("U3A" + IntervaloNi + IntervaloNf);
		   	if (rep > 0) {
				int m = 0;
				this.ReporteArrayPC = new ReportData[this.dataLectorFisc.size()];
				/*
				 * for(Object contenido : this.dataLectorFisc) {
				 * this.ReporteArrayPC[m] = new ReportData((String)contenido);
				 * ++m; }
				 */
				for (int i = 0; i < this.ReporteArrayPC.length; i++) {
					Object contenido = this.ReporteArrayPC[i];
					ReportData report = new ReportData();
					report.ReportDataArray(String.valueOf(contenido));		
					this.ReporteArrayPC[rep / 4] = report;
					for (int j = 0; j < 4; ++j) {
						this.ReporteArrayPC[m].ReportDataArray(String.valueOf(contenido));
						++m;
					}
				}

				Estado = " Status: 00  Error: 00";
			} else {
				this.ReporteArrayPC = null;
				Estado = "Sin repuesta";

				if (StartReportNumber > EndReportNumber)
					this.Estado = "The original number can not be greater than the final number";

				throw new PrinterException(Estado, getPrinterStatus());
			}

			return ReporteArrayPC;

		} catch (NullPointerException ex) {
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
        public ReportData[] getZReport(Date StartDate, Date EndDate)throws PrinterException
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
					ReportData report = new ReportData();
					report.ReportDataArray((String)contenido);
					this.ReporteArrayPC[rep/4] = report;
					for(int j = 0; j < 4 ; j++){
					this.ReporteArrayPC[h].ReportDataArray((String)contenido);
					++h;
				}
//					Object contenido = this.dataLectorFisc.get(i);
//					this.ReporteArrayPC[rep/4] = new ReportData();
//					for(int j = 0; j < 4 ; j++){
//						this.ReporteArrayPC[h].ReportDataArray((String)contenido);
//					}
					
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
     *@throws PrinterException Error de  transacci?n. //Modificado
     */
      public void printZReport() throws PrinterException
      {  
        boolean rep =  this.SendCmd("I0Z0"); 
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
           this.S1Estado = new S1PrinterData(this.sDataSubida);
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
     *Sube el estado S24 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el Base imponible tasa 3.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS24PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S24");
		
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
     *Sube el estado S25 de la Impresora fiscal y retorna un objeto de tipo S2PrinterData con el Base imponible tasa 3.
     *@throws PrinterException Error de  transacci?n.
     */
      public S2PrinterData getS25PrinterData() throws PrinterException
      {
        try
	  {
        int rep = this.SubirDataStatus("S25");
		
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
