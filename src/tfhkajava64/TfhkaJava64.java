/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfhkajava64;
import tfhka.*;
/**
 *
 * @author Pablo Moya
 */
public class TfhkaJava64 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Tfhka tf = new Tfhka("COM4");
             if(tf.IndPuerto)
           {System.out.println("Puerto Abierto");}
           else
           {System.out.println("Error al Abrir Puerto");}
          boolean rp =  tf.SendCmd("D");
            
             System.out.println("Salida = "+rp);
        }
        catch(PrinterExeption pe)
        {
             System.out.println("Error = "+pe.getMessage());
        }
        
    }
}
