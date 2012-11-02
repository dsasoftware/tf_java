/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package _private;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.comm.*;
import gnu.io.*;
import tfhka.*;

/**
 *
 * @author Pablo Moya
 */
public abstract class TfhkaRaiz implements SerialPortEventListener{
    
   // protected enum _SerialPortReceiveStatus { Espera, Recibiendo, LRC, Listo};
   // protected _SerialPortReceiveStatus PortReceiveStatus;
    public static final int Espera = 0;
    public static final int Recibiendo = 1;
    public static final int inLRC = 2;
    public static final int Listo = 3;
    protected int PortReceiveStatus;
    protected int _SerialPortReceiveTimeout;
    protected int _SendCmdRetryAttempts;
    protected int _SendCmdRetryInterval;
    protected boolean UsandoLineasControl;
    protected boolean _dataReady;
    protected int _bytesRecibidos; // Exclusivo para el evento de recepción de datos
    protected int _auxBytesRecibidos;
    protected byte[] bResp;
    protected byte[] tempBuffer;
    protected byte[] _dataBuffer;
    protected byte[] _emptyBuffer = new byte[20]; //Debe estar vacío, por eso su nombre "_emptyBuffer"
    protected static SerialPort puertoSerie;
    protected static OutputStream salida;
    protected static InputStream entrada;
    public String Estado;
     // Caracteres de control
    protected char
        STX = (char)02,
        ETX = (char)03,
        EOT = (char)04,
        ENQ = (char)05,
        ACK = (char)06,
        NAK = (char)21,
        LRC = ' ',
        ETB = (char)23;
    
    protected String Mensaje, estado, comPort, sDataSubida;;
    protected String status, error, descripStatus, descripError;
    protected ArrayList dataLectorFisc = new ArrayList();
    protected boolean CTS = false, DSR = false, CD = false, ErroValid = false;
     /**Variable que indica apertura del puerto
         * Si el puerto esta abierto IndPuerto = true;
         * Si el puerto esta cerrado IndPuerto = false;
         */
    public boolean IndPuerto = false;
     /**Objeto de tipo ReportData que se carga al subir reporte X ??½ Z del PC por medio de los m??½todos getZReport()  y  getXReport()*/
        public ReportData ReportePC;
        /**Arreglo de Objetos de tipo ReportData que se cargan al subir lectura de memoria fiscal del PC mediante los m??½todos getZReport(Date fecha1, Date fecha2)
         * y getZReport(int nroZ1, int nroZ2).
         */
        public ReportData[] ReporteArrayPC;
        /**Objeto de tipo PrinterStatus que se carga al leer Status y Error de la impresora por medio del m??½todo getPrinterStatus()*/
        public PrinterStatus StatusErrorPrinter;
         /**Objeto de tipo S1PrinterData que carga informaci??½n cuando se hace una subida de estado S1 por el m??½todo  getS1PrinterData()*/
        public S1PrinterData S1Estado;
        /**Objeto de tipo S2PrinterData que carga informaci??½n cuando se hace una subida de estado S2 por el m??½todo  getS2PrinterData()*/
        public S2PrinterData S2Estado;
        /**Objeto de tipo S3PrinterData que carga informaci??½n cuando se hace una subida de estado S3 por el m??½todo  getS3PrinterData()*/
        public S3PrinterData S3Estado;
        /**Objeto de tipo S4PrinterData que carga informaci??½n cuando se hace una subida de estado S4 por el m??½todo  getS4PrinterData()*/
        public S4PrinterData S4Estado;
        /**Objeto de tipo S5PrinterData que carga informaci??½n cuando se hace una subida de estado S5 por el m??½todo  getS5PrinterData()*/
        public S5PrinterData S5Estado;
		/**Objeto de tipo S6PrinterData que carga informaci??½n cuando se hace una subida de estado S6 por el m??½todo  getS6PrinterData()*/
        public S6PrinterData S6Estado;
        /**Objeto de tipo S7PrinterData que carga informaci??½n cuando se hace una subida de estado S7 por el m??½todo  getS7PrinterData()*/
        public S7PrinterData S7Estado;
   
         public int getSerialPortReceiveTimeout()
         {
             if (UsandoLineasControl)
                {
                    return _SerialPortReceiveTimeout;
                }
                else
                {
                    return 40; // Valor del TimeOut en "Modo emergencia"
                }
         }
         
        public boolean setSerialPortReceiveTimeout(int valueInSeconds) 
        {          
            if (valueInSeconds >= 5 && valueInSeconds <= 80)  // El tiempo de espera o Timeout configurable está en un rango de 5 - 80 segundos
            {
                 _SerialPortReceiveTimeout = valueInSeconds;
                 return true;
            }
            else
            {
                return false;
            }
        } 
        
        public int getSendCmdRetryAttempts() 
        {  
                if (UsandoLineasControl)
                {
                    return _SendCmdRetryAttempts;
                }
                else
                {
                    return 5;
                }                   
        }
         
        public boolean setSendCmdRetryAttempts(int value) 
        {
             if (value >= 0 && value <= 5)
                {
                    _SendCmdRetryAttempts = value;
                    return true;
                }
             else
             {
                 return false;
             }
          
        }

        public int getSendCmdRetryInterval() 
        {          
                if (UsandoLineasControl)
                {
                    return _SendCmdRetryInterval;
                }
                else
                {
                    return 10000;
                }
                  
        }
        
        public boolean setSendCmdRetryInterval(int valueInMilliseconds) 
        {           
                if (valueInMilliseconds >= 50 && valueInMilliseconds <= 10000)
                {
                    _SendCmdRetryInterval = valueInMilliseconds;
                    return true;
                }          
                else
                {
                    return false;
                }
        }
        
        public byte[] getSerialPortInputBuffer()
        {          
                _dataReady = false; // Si leemos datos en el buffer serial de forma manual, para casos extremadamente extraños.
                return _dataBuffer;
        }
        
        public boolean getSerialPortDataReady()
        {

                return _dataReady;
        }
        
        /*
    protected enum _SerialPortReceiveStatus {
          Espera(0), Recibiendo(1), LRC(2), Listo(3);
          
          private int valor;
          
         _SerialPortReceiveStatus(int valor) {
         this.valor = valor;
          }
         public int getValor() {
           return valor;
          }
      }
      */
     /*Manejadores de Eventos*/
       /**
         * Metodos Implemantados
         * Efectua los eventos en el puerto serial
         * @param SerialPortEvent e Evento en el  Puerto Serial
         */
     
  //  @Override
public void serialEvent(SerialPortEvent e)
    {
  // Determine type of event.
 switch (e.getEventType()) {
      case SerialPortEvent.BI:
      case SerialPortEvent.OE:
      case SerialPortEvent.FE:
      case SerialPortEvent.PE:
      case SerialPortEvent.CD:
      case SerialPortEvent.CTS:
      case SerialPortEvent.DSR:
      case SerialPortEvent.RI:
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:        
          break;
      case SerialPortEvent.DATA_AVAILABLE:
          try
          { // Si el puerto está cerrado, no hace nada
            if (!IndPuerto) return;
           
            byte rcvdByte;
            
           while (entrada.available() > 0)
           {   
               switch (PortReceiveStatus)
               {
                    case Espera:                 
                         rcvdByte = (byte)entrada.read();
                           tempBuffer[_auxBytesRecibidos] = rcvdByte;
                        if (rcvdByte == (byte)STX) // STX
                        {   
                           // PortReceiveStatus = _SerialPortReceiveStatus.Recibiendo;
                             PortReceiveStatus = Recibiendo;
                            _auxBytesRecibidos++;
                            Thread.sleep(2); // Tiempo suficiente para recibir 6 caracteres
                        }
                        else if ((rcvdByte == (byte)ACK) || (rcvdByte == (byte)NAK) || (rcvdByte == (byte)ENQ) || (rcvdByte == (byte)EOT))
                        {	// ACK NAK ENQ EOT 	
                            _auxBytesRecibidos++;
                            //PortReceiveStatus = _SerialPortReceiveStatus.Listo;
                            PortReceiveStatus = Listo;
                        }
                        else
                        {
                            _auxBytesRecibidos = 0;
                            //PortReceiveStatus = _SerialPortReceiveStatus.Espera;
                            PortReceiveStatus = Espera;
                        }
                        break;
                    
                    case Recibiendo:                       

                        // Recibe los bytes que estén por leerse desde el buffer de entrada
                        _auxBytesRecibidos += entrada.read(tempBuffer, _auxBytesRecibidos, entrada.available());

                        if (tempBuffer[_auxBytesRecibidos - 1] == (byte)EOT) //EOT, este es un caso especial, por el problema detectado en el firmware de las impresoras
                        {
                            if (_auxBytesRecibidos >= 3) // Para evitar errores de acceso fuera de límites
                            {
                                if (tempBuffer[_auxBytesRecibidos - 3] == (byte)ETX)
                                {
                                    _auxBytesRecibidos = 1;
                                    tempBuffer[0] = (byte)EOT;
                                }
                            }
                           // PortReceiveStatus = _SerialPortReceiveStatus.Listo;
                             PortReceiveStatus = Listo;
                        }
                        else if ((tempBuffer[_auxBytesRecibidos - 2] == (byte)ETX) || (tempBuffer[_auxBytesRecibidos - 2] == (byte)ETB)) // ETX y ETB respectivamente
                        {
                            //PortReceiveStatus = _SerialPortReceiveStatus.Listo;
                             PortReceiveStatus = Listo;
                        }
                        else
                        {
                            Thread.sleep(10); // 10ms -> Tiempo suficiente para recibir aprox 30 caracteres
                        }
                        break;
                        
                     case inLRC:
                          rcvdByte = (byte)entrada.read();
                        tempBuffer[_auxBytesRecibidos] = rcvdByte;
                        _auxBytesRecibidos++;
                        //PortReceiveStatus.valor++; // listo
                        PortReceiveStatus++; // listo
                        break;
                         
                     default:
                        break;
               }
               
                //if (PortReceiveStatus == _SerialPortReceiveStatus.Listo)
                 if (PortReceiveStatus == Listo)
                { 
                    _dataBuffer = new byte[_auxBytesRecibidos];
                   // Array.Copy(tempBuffer, 0, _dataBuffer, 0, _auxBytesRecibidos);
                    _dataBuffer = tempBuffer;
                    _bytesRecibidos = _auxBytesRecibidos;
                    _auxBytesRecibidos = 0;
                    _dataReady = true;
                }
           }
          }catch(IOException ioe)
           {}
          catch(InterruptedException ie)
          {}
        
          break;
        }
        
        }
    
    /*Metodos privados*/
    /// <summary>
        /// Función privada de uso exclusivo de la función "SerialPortWriteAndRead" que lee el buffer de datos 
        /// recibidos por el metodo SerialPortReceiveEvent y retorna la cantidad de bytes recibidos
        /// </summary>
        /// <param name="OutByteBuffer">Buffer donde se colocará lo recibido de la impresora (Requiere el uso de la palabra clave "out")</param>
private int getAnswer()
{
    //out byte[] OutByteBuffer
    byte[] OutByteBuffer = null;
    int LocalBytesRecibidos;
    boolean timeExpired = false;
    StopWatch cronometro = new StopWatch();

    cronometro.start();
    // Espera mientras los datos están listos o se acabe el tiempo
    while ((!_dataReady) && (!timeExpired))
    {

        if (cronometro.getElapsedTime() > getSerialPortReceiveTimeout() * 1000)
        {
            timeExpired = true; // Se venció el  tiempo
        }

    }

    if (cronometro.running)
    {
        cronometro.stop(); // Detengo cuenta del cronometro
    }

    if (timeExpired)
    {
        OutByteBuffer = _emptyBuffer;
        bResp = OutByteBuffer;
        return -1; // -1 significa timeOut
    }
    else
    {

        OutByteBuffer = _dataBuffer;
        bResp = OutByteBuffer;
        _dataReady = false;

        LocalBytesRecibidos = _bytesRecibidos;
        _bytesRecibidos = 0;
        //PortReceiveStatus = _SerialPortReceiveStatus.Espera;
        PortReceiveStatus = Espera;

        return LocalBytesRecibidos;
    }
} /// <summary>
/// Función que escribe la trama a la impresora y retorna la cantidad de bytes leídos y un Array de bytes con la respuesta
/// (Depende de getAnswer)
/// </summary>
/// <param name="bResp">Buffer donde se colocará lo recibido de la impresora (Requiere el uso de la palabra clave "out")</param>
protected  int SerialPortWriteAndRead(char[] cTrama, boolean bEsperarCTS) throws IOException
{
    int bytesRecibidos = 0;         // Cantidad de bytes recibidos, siempre se debe comparar con la cantidad esperada de bytes
    byte[] vectorbyte = new byte[cTrama.length];
    // out  byte[] bResp
    try
    {
        // Vacío los buffers de entrada / salida         
        if (entrada.available() > 0)
        {
            entrada.reset(); // Port.DiscardInBuffer();      
        }

        salida.flush();//Port.DiscardOutBuffer();

        int x = 0;
        while (x < cTrama.length)
        {
            vectorbyte[x] = (byte) cTrama[x];
            ++x;
        }

        _dataReady = false;

        //  PortReceiveStatus = _SerialPortReceiveStatus.Espera;
        PortReceiveStatus = Espera;

        if (UsandoLineasControl)
        {
            if(bEsperarCTS)
            {
                if (Wait_CTS(40000))
                {
             // Pues esperó... y si entra aca es TRUE
                }
                else
                {
                    bResp = _emptyBuffer;
                    return -2; // -2 significa timeOut por RTS/CTS
                }
            }
        }

       salida.write(vectorbyte, 0, cTrama.length);   // Escribimos el comando a la impresora (Aquí ya tienen STX, CMD, ETX y LRC)
 
    }
    catch (IOException ex)
    {
        throw ex;
    }

    bytesRecibidos = getAnswer();  // Recibimos la respuesta en bResp, junto con la cantidad de bytes recibidos
    // Si hubo timeout, bytesRecibidos contiene -1
    return bytesRecibidos;
     
}
/// <summary>
///Metodo para reiniciar los elementos de repuesta
/// </summary>
protected  void ReiniciarVariables()
{
    this.dataLectorFisc = new ArrayList();
} 
/// <summary>
/// Método Exclusivo para los métodos SendCmd y SendCmd_Archivos, calcula el LRC de una trama y lo retorna como un char
/// </summary>
/// <param name="cmd">Comando o trama a la cual se le calculará el LRC</param>
protected  char Do_XOR(String sCMD)
{
    char[] cCMD = sCMD.toCharArray();   // cCMD = Comando en modo char            
    int LRC_AUX = 0;                // Acumulador para el checksum
    int CheckSum = 0;                // Checksum/LRC final

    for (int i = 0; i < cCMD.length; i++)
    {
        if ((i == 0) && (cCMD[i] == STX))
        {
            // no hacer nada, dejar LRC_AUX en cero...
        }
        else if (LRC_AUX == 0) // si no se ha inicializado LRC_AUX lo inciamos
        {
            LRC_AUX = cCMD[i];
        }
        else if (cCMD[i] != ETX) // si LRC_AUX ya fue inicado y no es ETX
        {
            LRC_AUX ^= cCMD[i];
        }
        else         // En caso de que se envíe el ETX dentro de la trama...
        {
            CheckSum = LRC_AUX ^ ETX;    // Se asigna a CheckSum el último Xor con ETX (03)
            return (char)CheckSum;      // Salgo de la función retornando el CheckSum
        }
    }

    CheckSum = LRC_AUX ^ ETX;    // Finalmente se asigna a CheckSum el último Xor, con ETX (03)
    return (char)CheckSum;      // Retorno el checksum por si no lo voy a tomar desde la variable global
}
/// <summary>
/// Método Exclusivo para los métodos UploadStatus y UploadReport
/// </summary>
/// <param name="cmd">Comando o trama</param>
/// <param name="bResp">Respuesta desde la impresora</param>
    protected int SendCmd_Archivos(String sCMD)
    {
        //, out byte[] bResp
        //byte[] bResp;
        Do_XOR(sCMD);

        Mensaje = STX + sCMD + ETX + ' ';

        //////
        char[] cCMD = Mensaje.toCharArray();

        int bytesRecibidos = 0;

        cCMD[cCMD.length - 1] = Do_XOR(sCMD);

        try
        {
               // Se envía el mensaje y recibe respuesta...   
            bytesRecibidos = SerialPortWriteAndRead(cCMD, true);

            if(bytesRecibidos < 0) // Timeout por RTS/CTS o por Falta de respuesta de la impresora
            {
                // No esperamos tiempo extra antes de reenviar el comando pues ya se esperó el timeout
                // Se envía el mensaje y recibe respuesta...                     
                bytesRecibidos = SerialPortWriteAndRead(cCMD, true);
                // Si falla la segunda vez... pues se retorna el valor de bytesRecibidos
            }

            //Retorno la cantidad de caracteres recibidos en la trama de repuesta de la impresora
            return bytesRecibidos;
        }
        catch (IOException e)
        {
            estado = "Error... " + e.getMessage();
            //bResp = null;
            return 0;
        }
        catch (NullPointerException e1)
        {
            estado = "Error... " + e1.getMessage();
            //bResp = null;
            return 0;
        }

    }
// / <summary>
// / Establece el Status y Error en Hexadecimal de la Impresora Reciebiendo
// dos parametros enteros de los mismos
// / </summary>
// / <param name="st">Estado</param>
// / <param name="er">Error</param>
protected String DarStatus_Error(int st, int er) {

    int st_aux = st;

    st = st & (~0x04);  


    if((st & 0x6A) == 0x6A)// En modo fiscal y carga completa de la memoria fiscal y en emision de documentos NO fiscales    
    {
        status = "12";
        this.descripStatus = "In Fiscal Mode, Memory Full, in Non Fiscal Transaction";
    }
    else if ((st & 0x69) == 0x69)// En modo fiscal y carga completa de la memoria
    // fiscal y en emision de documentos fiscales
    {
        status = "11";
        this.descripStatus = "In Fiscal Mode, Memory Full, in Fiscal Transaction";
    }
    else if ((st & 0x68) == 0x68)// En modo fiscal y carga completa de la memoria
    // fiscal y en espera
    {
        status = "10";
        this.descripStatus = "In Fiscal Mode Memory Full and Wait";
    }
    else if ((st & 0x72) == 0x72)// En modo fiscal y cercana carga completa de la
    // memoria fiscal y en emision de documentos NO
    // fiscales
    {
        status = "09";
        this.descripStatus = "In Fiscal Mode, Fiscal Memory Near Full, in Non Fiscal Transaction";
    }
    else if ((st & 0x71) == 0x71) // En modo fiscal y cercana carga completa de la
    // memoria fiscal y en emision de documentos
    // fiscales
    {
        status = "08";
        this.descripStatus = "In Fiscal Mode, Fiscal Memory Near Full, in Fiscal Transaction";
    }
    else if ((st & 0x70) == 0x70)// En modo fiscal y cercana carga completa de la
    // memoria fiscal y en espera
    {
        status = "07";
        this.descripStatus = "In Fiscal Mode, Fiscal Memory Near Full and Wait";
    }
    else if ((st & 0x62) == 0x62)// En modo fiscal e imprimiendo documentos No fiscales
    {
        status = "06";
        this.descripStatus = "In Fiscal Mode, in Non Fiscal Transaction";
    }
    else if ((st & 0x61) == 0x61) // En modo fiscal e imprimiendo documentos fiscales
    {
        status = "05";
        this.descripStatus = "In Fiscal Mode, in Fiscal Transaction";
    }
    else if ((st & 0x60) == 0x60)  // En modo fiscal y en espera.
    {
        status = "04";
        this.descripStatus = "In Fiscal Mode and Wait";
    }
    else if ((st & 0x42) == 0x42)// En modo de prueba e imprimiendo documentos No fiscales.
    {
        status = "03";
        this.descripStatus = "In Non Fiscal Mode, in Non Fiscal Transaction";
    }
    else if ((st & 0x41) == 0x41)// En modo de prueba e imprimiendo facturas.
    {
        status = "02";
        this.descripStatus = "In Non Fiscal Mode, in Fiscal Transaction";
    }
    else if ((st & 0x40) == 0x40)// En modo de prueba y en espera.
    {
        status = "01";
        this.descripStatus = "In Non Fiscal Mode and Wait";
    }
    else if ((st & 0x00) == 0x00) // Estatus Desconocido.
    {
        status = "00";
        this.descripStatus = "Unknowed Status";
    }




    if ((er & 0x6C) == 0x6C)// Memoria Fiscal LLena
    {
        error = "108";
        this.descripError = "Fiscal Memory Full";
        this.ErroValid = false;
    }
    else if ((er & 0x64) == 0x64)// Error de la memoria Fiscal
    {
        error = "100";
        this.descripError = "Memory Fiscal Error";
        this.ErroValid = false;
    }
    else if ((er & 0x60) == 0x60)// Error Fiscal
    {
        error = "96";
        this.descripError = "Fiscal Error";
        this.ErroValid = false;
    }
    else if ((er & 0x5C) == 0x5C)// Comando invalido
    {
        error = "92";
        this.descripError = "Invalid Commando";
        this.ErroValid = false;
    }
    else if ((er & 0x58) == 0x58)// No hay asignadas directivas
    {
        error = "88";
        this.descripError = "No Directives Assigned";
        this.ErroValid = false;
    }
    else if ((er & 0x54) == 0x54)// Tasa invalida
    {
        error = "84";
        this.descripError = "Invalid Tax";
        this.ErroValid = false;
    }
    else if ((er & 0x50) == 0x50)// Comando Invalido valor invalido
    {
        error = "80";
        this.descripError = "Command Invalid / Invalid Value";
        this.ErroValid = false;
    }
    else if ((er & 0x43) == 0x43)// Fin de la entrega de papel y error mecanico
    {
        error = "03";
        this.descripError = "Ends of Paper and Mechanic Error";
        this.ErroValid = true;
    }
    else if ((er & 0x42) == 0x42)// Error de indole mecanico
    {
        error = "02";
        this.descripError = "Mechanic Error with Paper";
        this.ErroValid = true;
    }
    else if ((er & 0x41) == 0x41)// Fin de la Entrega de papel
    {
        error = "01";
        this.descripError = "End of Paper";
        this.ErroValid = true;
    }
    else if ((er & 0x40) == 0x40) // No hay Error
    {
        error = "00";
        this.descripError = "No Error";
        this.ErroValid = true;
    }


    if ((st_aux & 0x04) == 0x04)// Buffer completo debe enviar el comando de reinicio
    {
        error = "112";
        this.descripError = "Buffer Full";
        this.ErroValid = false;
    }
    else if (er == 128)// Error en la comunicacion
    {
        error = "128";
        this.descripError = "Communication Error";
        this.ErroValid = false;
    }
    else if (er == 137)// No hay respuesta
    {
        error = "137";
        this.descripError = "No Answer";
        this.ErroValid = false;
    }
    else if (er == 144)// Error LRC
    {
        error = "144";
        this.descripError = "LRC Error";
        this.ErroValid = false;
    }
    else if (er == 145)// Error Interno API
    {
        error = "145";
        this.descripError = "Intern API Error";
        this.ErroValid = false;
    }
    else if (er == 153)// Error en la apertura de archivo
    {
        error = "153";
        this.descripError = "Opening File Error";
        this.ErroValid = false;
    }
    else if (er == 71)// No hay rolo de papel para Factura
    {
        error = "71";
        this.descripError = "No roll paper bill";
        this.ErroValid = false;
    }

    Estado = "Status: " + status + "  " + "Error: " + error;

        return Estado;

}
/// <summary>
/// Consulta y hace el intento de trabajr con las señales CTS y RTS antes de ejecutar metodos de escrituras
/// </summary>
protected boolean ManipulaCTS_RTS()
{

    boolean resp;
    try
    {
        resp = Wait_CTS(4000);
        return resp;
    }
    catch (NullPointerException e5)
    {
        estado = "Error... " + e5.getMessage();
        ////Port.RtsEnable = false;
        return false;
    }
}
/// <summary>
/// Metodo para esperar que la señal CTS se ponga en true (Si lo hace en un tiempo determinado, sino, pues no).
/// </summary>
private boolean Wait_CTS(int timeout)
{
    if (!IndPuerto) return false;

        puertoSerie.setRTS(true);
        
        
        
        
        long tiempoEsperaCTS = timeout; // se esperan 4 segundos para que se coloque en TRUE la señal CTS antes de decir que no
        long lastTime = 0;
        StopWatch crono = new StopWatch();
        crono.start();
        
        this.CTS = puertoSerie.isCTS(); 
        
        // Espera mientras se coloca en true el CTS o se acabe el tiempo
        while (!CTS) 
        {
            if (crono.getElapsedTime() > lastTime + 100) // Para que no se tire 3, cuando se monitorea el puerto
            {
                lastTime = crono.getElapsedTime();
                this.CTS = puertoSerie.isCTS(); 
            }

            if ((crono.getElapsedTime() > tiempoEsperaCTS) && (CTS == false)) // 4 segundos
            {
                CTS = false;
                return false; // Se venció el  tiempo
            }

        }

        if (crono.running)
        {
            crono.stop(); // Detengo cuenta del cronometro
        }

        return true;

}
 /// <summary>
/// Extae Data de los Reportes de la maquina  al PC y lo copia en el Array "dataLectorFisc"
/// </summary>
/// <param name="Cmd">Comando o trama</param>
protected int SubirDataReport(String sCMD)
    {
        int lineasProcesadas = 0;
        int bytesLeidos;
        byte bitParada;
        String trama = "";
        int ascii = 0;
        int n1 = 0;

        // Envio comando de reporte "U..."
        bytesLeidos = SendCmd_Archivos(sCMD);
        
        
        if ((bytesLeidos > 0) && (bResp[0] == (byte) ENQ)) // Si llega el ENQ
        {
            this.ReiniciarVariables();
            try
            { 
                Thread.sleep(100); // para evitar problemas de que la maquina no esté lista para procesar
                bytesLeidos = SerialPortWriteAndRead(new char[]{ACK}, false); // --> ACK    
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            catch (IOException ex)
            {
                Logger.getLogger(TfhkaRaiz.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while ((bytesLeidos > 0) && (bResp[0] != EOT)&& (bResp[0] != NAK)) // si es 1, debería ser EOT en casos normales
                                                                               // y si es NAK es por error de la impresora...
            {  
                int Pos_ETX = bytesLeidos - 2;
                int Pos_LRC = bytesLeidos - 1;
                
                for (n1 = 0; n1 < bytesLeidos; n1++)
                {
                    ascii = bResp[n1];
                    
                    if (!(n1 == 0 || n1 == Pos_ETX || n1 == Pos_LRC || ascii == 03))
                    {
                        if (ascii != 10) // != 0x0A
                        {
                            trama += (char) ascii;
                        }
                    }
                }
                
                this.dataLectorFisc.add(trama);  // Cuando son muchos bloques...
                if (lineasProcesadas == 0) // Cuando es un solo bloque pues es el primero...
                {
                    sDataSubida = trama;
                }
                trama = "";
                
                bitParada = bResp[Pos_ETX];
                bResp = null;
                
                if (bitParada == (byte) ETB || bitParada == (byte) ETX)
                {
                    try
                    {
                        if (!(bitParada == (byte) ETX && lineasProcesadas == 0))
                        {
                            bytesLeidos = SerialPortWriteAndRead(new char[]  {ACK}, false);
                        } // OJO ANTES DE ENVIAR ACK SE DEBERÍA CALCULAR EL CHECKSUM DE LA TRAMA RECIBIDA
                        else
                        {
                            bytesLeidos = 0;
                        }
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(TfhkaRaiz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                ++lineasProcesadas;              
            }            
        }
        
        return lineasProcesadas;
    }


/// <summary>
/// Extae Data de los Status (S1, S2 ... Sx) de la maquina  al PC y lo copia en una variable string
/// </summary>
/// <param name="Cmd">Comando o trama</param>
protected int SubirDataStatus(String sCMD)
{    
   //, out string sDataSubida
    int bytesLeidos;
    String trama = "";
    int ascii = 0;
    int n1 = 0;


    bytesLeidos = SendCmd_Archivos(sCMD);

    if (bytesLeidos > 0)
    {  
        this.ReiniciarVariables();

        int Pos_ETX = bytesLeidos - 2;
        int Pos_LRC = bytesLeidos - 1;

        for (n1 = 0; n1 < bytesLeidos; n1++)
        { 
            ascii =  bResp[n1];

            if (!(n1 == 0 || n1 == Pos_ETX || n1 == Pos_LRC || ascii == 03))
            {

                if (ascii != 10)
                {
                    trama += (char)ascii;
                }

            }

        }
    }

    sDataSubida = trama;

    return n1;

}

protected  static byte[] String2ByteArray(String str)
{ 
 byte[] textBytes = null;
try {
    textBytes = str.getBytes("UTF-8");
} catch (UnsupportedEncodingException ex) {
    Logger.getLogger(TfhkaRaiz.class.getName()).log(Level.SEVERE, null, ex);
}

    return textBytes;
}
/*
    Copyright (c) 2005, Corey Goldberg

    StopWatch.java is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.
*/

private class StopWatch {
    
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    
    //elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
             elapsed = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }
    
    
    //elaspsed time in seconds
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        }
        else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }
}   
     
}