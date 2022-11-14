/*
 * Ler os valores das Tags do arquivo XML
 */
package supportsystem.createXML;

import supportsystem.xml.ManipuladorXML;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import supportsystem.models.Produto;

public class LerValoresXML {

    public static Produto lerXML(String path) {

        try {

            Document doc = ManipuladorXML.readXmlFile(path);

            // Read NODE values
            XPathExpression e1 = ManipuladorXML.getXPathExpression("//Produto/id_item");
            String id_item = (String) e1.evaluate(doc, XPathConstants.STRING);

            XPathExpression e2 = ManipuladorXML.getXPathExpression("//Produto/nome_item");
            String nome_item = (String) e2.evaluate(doc, XPathConstants.STRING);

            XPathExpression e3 = ManipuladorXML.getXPathExpression("//Produto/preco");
            String preco = ((String) e3.evaluate(doc, XPathConstants.STRING));

            XPathExpression e4 = ManipuladorXML.getXPathExpression("//Produto/qtd");
            String qtd = ((String) e4.evaluate(doc, XPathConstants.STRING));

            Produto produtoXML = new Produto();
            produtoXML.setNome_item(nome_item);
            produtoXML.setPreco(Float.parseFloat(preco));
            produtoXML.setQtd(Integer.parseInt(qtd));

            return produtoXML;

        } catch (XPathExpressionException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
