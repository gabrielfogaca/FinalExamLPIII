/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package supportsystem.view;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import supportsystem.dao.ClienteDAO;
import supportsystem.models.Cliente;

/**
 *
 * @author Gabriel
 */
public class EditClienteTest {
    
    private Cliente cliente;
    
    public EditClienteTest() {
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

    @Test
    public void testSomeMethod() throws SQLException {
        Cliente cliente = new Cliente();
        ClienteDAO clienteDao = new ClienteDAO();
        
        cliente.setId_cliente(1);
        cliente.setNome_cliente("Matheus Krhoze");
        cliente.setId_tipo_cliente(1);
        cliente.setId_operador(3);
        
        clienteDao.editarCliente(cliente);
        
        Integer idcliente = 1;
                
        Cliente Ccliente = clienteDao.ProcurarClienteParaTeste(idcliente);
        this.cliente = Ccliente;
        //verificar se os dados mudaram no banco
        int id_Ccliente = Ccliente.getId_cliente();
        String nome_Ccliente = Ccliente.getNome_cliente();
        int id_tipo_Ccliente = Ccliente.getId_tipo_cliente();
        int id_operador_Ccliente = Ccliente.getId_operador();

        
        
        System.out.println(cliente.getId_cliente()+ ' ' +id_Ccliente);
        assertEquals(cliente.getId_cliente(), id_Ccliente);
        
        System.out.println(cliente.getNome_cliente()+ ' ' +nome_Ccliente);
        assertEquals(cliente.getNome_cliente(), nome_Ccliente);
        
        System.out.println(cliente.getId_tipo_cliente()+ ' ' +id_tipo_Ccliente);
        assertEquals(cliente.getId_tipo_cliente(), id_tipo_Ccliente);
        
        System.out.println(cliente.getId_operador()+ ' ' +id_operador_Ccliente);
        assertEquals(cliente.getId_operador(), id_operador_Ccliente);
        

        //fail("The test case is a prototype.");
    }
    
}
