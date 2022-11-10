/*
 * Ler os valores das Tags do arquivo XML
 */

package supportsystem.createXML;

import supportsystem.xml.ManipuladorXML;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

public class LerValoresXML {
        public static void main(String[] args) {
     
        try {
            
            Document doc = ManipuladorXML.readXmlFile("./empregados.xml");
            
            // Read NODE values
            XPathExpression e1 = ManipuladorXML .getXPathExpression(" ");
            //XPathExpression e1 = XMLHandler .getXPathExpression("//empregado[nome='Maria']/nome");
            String nome = (String) e1.evaluate(doc, XPathConstants.STRING);
            
            XPathExpression e2 = ManipuladorXML.getXPathExpression("");
            //XPathExpression e2 = XMLHandler.getXPathExpression("//empregado[nome='Maria']/sobrenome");
            String sobrenome = ((String) e2.evaluate(doc, XPathConstants.STRING));
            
            System.out.println("Nome: "+nome);
            System.out.println("Sobrenome: "+sobrenome);
            
        } catch (XPathExpressionException ex) {
            System.out.println(ex);
        }
                
    }

}
