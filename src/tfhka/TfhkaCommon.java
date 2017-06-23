/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import tfhka._private.TfhkaRaiz;
import jssc.*;
import tfhka.ve.Tfhka;

/**
 *
 * @author pmoya
 */
public class TfhkaCommon extends TfhkaRaiz{
    
 public String Terminar;
  /**Objeto de tipo PrinterStatus que se carga al leer Status y Error de la impresora por medio del m??�todo getPrinterStatus()*/       
  private PrinterStatus StatusErrorPrinter;
 
 /**
	*Inicializa una nueva instancia de la clase Tfhka, Conecta y define el
	*puerto a manejar en la clase
	*@param puerto Nombre del Puerto Serial 
        */
   protected TfhkaCommon(String puerto)
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
        protected TfhkaCommon()
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
            
            this.init(IpPortName);
                     puerto = puertoSerie.openPort();
            puertoSerie.setParams(9600,
                                SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                                SerialPort.PARITY_EVEN);
            
            puertoSerie.addEventListener(this);

            this.IndPuerto = puerto;

            if (puerto == true)
            {
                if (ManipulaCTS_RTS())
                {
                    UsandoLineasControl = true;
                    puertoSerie.setRTS(true);
                    Estado = "Puerto Abierto";
                }
                else if (CheckFprinter())
                {
                    UsandoLineasControl = false;
                    puertoSerie.setRTS(false);
                    Estado = "Puerto Abierto";
                }else
                {
                   Estado = "Impresora no detectada";
                    this.IndPuerto = false;
                    puerto = this.IndPuerto;
                }
                
            }
            else
            {
                Estado = "Error al Abrir puerto";
            }


            return puerto;

        }
        catch (SerialPortException spe)
        {
            Estado = spe.getMessage();
            return false;
        }
        catch (Exception ioe)
        {
            Estado = ioe.getMessage();
            return false;
        }

    }
    
     /**
         * Metodo para la Configuracion del Puerto.
         * Retorna la indicaci?n de apertura.
	 *@param IpPortName Nombre del Puerto Serial
         *@param pBaudios Baudios de velocidad del Puerto Serial
         */
    public boolean OpenFpctrl(String IpPortName, int pBaudios)
    {
        this.Terminar = IpPortName;
        boolean puerto = false;

        try
        {
            
            this.init(IpPortName);
                     puerto = puertoSerie.openPort();
            puertoSerie.setParams(pBaudios,
                                SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                                SerialPort.PARITY_EVEN);
            
            puertoSerie.addEventListener(this);

            this.IndPuerto = puerto;

            if (puerto == true)
            {
                if (ManipulaCTS_RTS())
                {
                    UsandoLineasControl = true;
                    puertoSerie.setRTS(true);
                    Estado = "Puerto Abierto";
                }
                else if (CheckFprinter())
                {
                    UsandoLineasControl = false;
                    puertoSerie.setRTS(false);
                    Estado = "Puerto Abierto";
                }else
                {
                   Estado = "Impresora no detectada";
                    this.IndPuerto = false;
                    puerto = this.IndPuerto;
                }
                
            }
            else
            {
                Estado = "Error al Abrir puerto";
            }


            return puerto;

        }
        catch (SerialPortException spe)
        {
            Estado = spe.getMessage();
            return false;
        }
        catch (Exception ioe)
        {
            Estado = ioe.getMessage();
            return false;
        }

    }

    /**
     * Metodo para Cerrar el Puerto serie
     */
    public void CloseFpctrl()
    {
        try
        {
            puertoSerie.closePort();
            this.IndPuerto = false;

        }
        catch (NullPointerException e)
        {
        }
        catch (SerialPortException e)
        {
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
        catch (SerialPortException e4)
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
        } catch (SerialPortException ex) {
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
        catch (SerialPortException ex)
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
                catch (SerialPortException ex)
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
    public boolean UploadReportCmd(String Cmd, String file) {

        String lineno = "";
        int interv = 0;

        try {
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
            for (int i = 0; i < this.dataLectorFisc.size(); i++) {
                Object contenido = this.dataLectorFisc.get(i);
                lineno += (String) contenido + "\r\n";
            }

            salidaf.println(lineno);
            salidaf.close();

            if (interv != 0) {
                Estado = " Status: 00  Error: 00";
                this.ReiniciarVariables();
                return true;
            } else {
                Estado = "Sin repuesta";
                this.ReiniciarVariables();
                return false;
            }

        } catch (java.io.IOException ioex) {
            Estado = ioex.getMessage();
            this.ReiniciarVariables();
            return false;
        } catch (NullPointerException e2) {
            Estado = e2.getMessage();
            this.ReiniciarVariables();
            return false;
        }
    }
       
/**
 * Lee el Status y Error de la Impresora Fiscal
 */
    public boolean ReadFpStatus()
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
        catch (SerialPortException e)
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
        //METODO PARA SOLICITAR EL MODELO Y EL PAIS
/**Objeto de tipo SVPrinterData que carga informaci??�n cuando se solicita el modelo y el pais de la maquina por el metodo getModel() y getCountry()*/

	public SVPrinterData getSVPrinterData() throws PrinterException
	{
		SVPrinterData Status;
		int rep = 0;
		rep = this.SubirDataStatus("SV");
		if (rep > 0) // Se procesó al menos una línea
		{
			Status = new SVPrinterData(this.sDataSubida);
			this.ReiniciarVariables();
		}
		else
		{
                        Status = null;
                        Estado = "Sin Repuesta";
		      throw new PrinterException(Estado, null);			
		}
		return Status;
	} 
}
