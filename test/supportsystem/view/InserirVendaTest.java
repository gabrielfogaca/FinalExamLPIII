/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package supportsystem.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import supportsystem.dao.VendaDAO;
import supportsystem.dao.VendaDTO;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.Produto;
import supportsystem.models.Vendedor;

/**
 *
 * @author Gabriel
 */
public class InserirVendaTest {
    
    public InserirVendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class InserirVenda.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        InserirVenda.main(args);
        String nome_cliente;
        String nome_vendedor;
        String nome_item;
        int id_cliente;
        int id_vendedor;
        float preco_item;
        int qtd;
        float valor_total;
        int qtd_estoque;


        id_cliente = 1;
        nome_cliente = "Matheus Krhoze";
        id_vendedor = 1;
        nome_vendedor = "Joao";
        nome_item = "Placa Mae b450 steel";
        preco_item = (float) 799.00;

        qtd = 10;
          
        valor_total = preco_item * Integer.valueOf(qtd);

        qtd_estoque = 17 - Integer.valueOf(qtd);

        VendaDTO vendadto = new VendaDTO();

        vendadto.setId_cliente(id_cliente);
        vendadto.setId_vendedor(id_vendedor);
        vendadto.setNome_cliente(nome_cliente);
        vendadto.setNome_vendedor(nome_vendedor);
        vendadto.setNome_item(nome_item);
        vendadto.setValor_venda(valor_total);
        vendadto.setQuantidade_produto(qtd_estoque);
        vendadto.setId_operador(3);

        
        assertEquals(7990.0, valor_total,0);
        
    }
    
}
