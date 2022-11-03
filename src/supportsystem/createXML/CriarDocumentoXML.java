/*
 * Cria um documento XML simples
 */
package supportsystem.createXML;

import java.util.ArrayList;
import supportsystem.xml.ManipuladorXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import supportsystem.dao.VendaDTO;
import java.lang.String;

public class CriarDocumentoXML {

    public static ArrayList<VendaDTO> main(ArrayList<VendaDTO> vendaXML) {

        Document doc = ManipuladorXML.newDocument();
        
        // <venda> 
        Element venda = doc.createElement("Venda");
        doc.appendChild(venda);
        for (int i = 0; i < vendaXML.size(); i++) {
        //transformar id_venda int to string
        float y = vendaXML.get(i).getId_venda();
        String idvenda = Integer.toString((int) y);
        Element id_venda = doc.createElement("idVenda");
        id_venda.setTextContent(idvenda);
        venda.appendChild(id_venda);
        }
        
        //<vendedor>
        Element vendedor = doc.createElement("Vendedor");
        venda.appendChild(vendedor);
        for (int i = 0; i < vendaXML.size(); i++) {
            //transformar id_vendedor int to string
            float x = vendaXML.get(i).getId_vendedor();
            String id_vendedor = Integer.toString((int) x);
            Element idvendedor = doc.createElement("idVendedor");
            idvendedor.setTextContent(id_vendedor);
            vendedor.appendChild(idvendedor);
             // <Nome vendedor>
            Element nomevendedor = doc.createElement("Nome");
            nomevendedor.setTextContent(vendaXML.get(i).getNome_vendedor());
            vendedor.appendChild(nomevendedor);
        }
        
        //<Cliente>
        Element cliente = doc.createElement("Cliente");
        venda.appendChild(cliente);
        for (int i = 0; i < vendaXML.size(); i++) {
            //transformar id_vendedor int to string
            float x = vendaXML.get(i).getId_cliente();
            String id_cliente = Integer.toString((int) x);
            Element idcliente = doc.createElement("idCliente");
            idcliente.setTextContent(id_cliente);
            cliente.appendChild(idcliente);
             // <Nome vendedor>
            Element nomecliente = doc.createElement("Nome");
            nomecliente.setTextContent(vendaXML.get(i).getNome_cliente());
            cliente.appendChild(nomecliente);
        }        
        
         // <Produto> 
        Element produto = doc.createElement("Produto");
        venda.appendChild(produto);
        for (int i = 0; i < vendaXML.size(); i++) {

            // <Nome>
            Element nome = doc.createElement("Nome");
            nome.setTextContent(vendaXML.get(i).getNome_item());
            produto.appendChild(nome);

            //transformar valor venda int to string
            float y = vendaXML.get(i).getValor_venda();
            String valvenda = Integer.toString((int) y);
            // <Valor>
            Element valor = doc.createElement("Valor");
            valor.setTextContent(valvenda);
            produto.appendChild(valor);

            //manipular nome venda
            ManipuladorXML.writeXmlFile(doc, "./Venda.xml");

        }
        
        return null;
    }
}
