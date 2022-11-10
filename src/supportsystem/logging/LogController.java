/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.logging;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 *
 * @author joao.vmr
 */
public class LogController {
    
    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LogController.class.getPackage().getName());

    public static void createLog (String mensagem, String nivel) {
        try {
            Properties conf = getLogConf();

            Handler handler = new FileHandler(conf.getProperty("arquivo"), Boolean.parseBoolean(conf.getProperty("acrescentar")));
            java.util.logging.Logger.getLogger("").addHandler(handler);

            // define o formato de saída  
            if (conf.getProperty("formato-saida").equalsIgnoreCase("XML")) {
                handler.setFormatter(new XMLFormatter());
            } else if (conf.getProperty("formato-saida").equalsIgnoreCase("SIMPLE")) {
                handler.setFormatter(new SimpleFormatter());
            }

            

            if(nivel.equals("S")){
            logger.severe(mensagem);
            }
            if(nivel.equals("W")){
            logger.warning(mensagem);
            }
            if(nivel.equals("I")){
            logger.info(mensagem);
            }
            
            
            

        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }

    }
   
//    configurações do Log
    private static Properties getLogConf() {
        Properties conf = new Properties();
        
        
        conf.setProperty("arquivo", "SystemLog.log");
        conf.setProperty("acrescentar", "true");
        conf.setProperty("formato-saida", "SIMPLE");
        //conf.setProperty("formato-saida", "XML");

        return conf;
    }
    
}
