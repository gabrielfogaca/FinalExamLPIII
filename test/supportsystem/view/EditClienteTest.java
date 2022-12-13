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
        cliente.setNome_cliente("Gabriel");
        cliente.setId_tipo_cliente(1);
        cliente.setId_operador(1);
        
        clienteDao.editarCliente(cliente);
        
        Integer idcliente = 1;
        
        clienteDao.ProcurarClienteParaTeste(idcliente);
        
        
        
        
        assertEquals(cliente, );
        
        
        
        fail("The test case is a prototype.");
    }
    
}
