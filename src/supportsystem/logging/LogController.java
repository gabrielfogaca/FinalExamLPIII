/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.logging;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 *
 * @author joao.vmr
 */
public class LogController {

    static Properties conf = getLogConf();
    static Handler handler;
    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LogController.class.getPackage().getName());

    private static Handler getHandler() {

        if (handler == null) {

            try {
                handler = new FileHandler(conf.getProperty("arquivo"), Boolean.parseBoolean(conf.getProperty("acrescentar")));
            } catch (IOException ex) {
                Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.util.logging.Logger.getLogger("").addHandler(handler);
            if (conf.getProperty("formato-saida").equalsIgnoreCase("XML")) {
                handler.setFormatter(new XMLFormatter());
            } else if (conf.getProperty("formato-saida").equalsIgnoreCase("SIMPLE")) {
                handler.setFormatter(new SimpleFormatter());
            }

        }

        return handler;

    }

    public static void createLog(String mensagem, String nivel) {
        getHandler();
        if (nivel.equals("S")) {
            logger.severe(mensagem);
        }
        if (nivel.equals("W")) {
            logger.warning(mensagem);
        }
        if (nivel.equals("I")) {
            logger.info(mensagem);
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
