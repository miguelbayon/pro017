

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test0450.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test0450
{
    /**
     * Default constructor for test class Test0450
     */
    public Test0450()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testCommit01()
    {
        Enigma enigma = new Enigma();
        Mecanismo mecanismo01 = new MecanismoMultiplicacionPrimo(7);
        
        assertEquals(35084, enigma.encripta(mecanismo01, 5012));
        assertEquals(63000, enigma.encripta(mecanismo01, 9000));
        assertEquals(-1,    enigma.encripta(mecanismo01, 10));        
        assertEquals(5012,  enigma.desencripta(mecanismo01, 35084));        
        assertEquals(9000,  enigma.desencripta(mecanismo01, 63000));              
        assertEquals(-1,  enigma.desencripta(mecanismo01, 70)); 
    }
    
    @Test
    public void testCommit02()
    {
        Enigma enigma = new Enigma();
        Mecanismo mecanismo02 = new MecanismoOffset(2);            
        
        assertEquals(3682,  enigma.encripta(mecanismo02, 3460));
        assertEquals(9165,  enigma.encripta(mecanismo02, 9943));
        assertEquals(-1,    enigma.encripta(mecanismo02, 10));
        assertEquals(3460,  enigma.desencripta(mecanismo02, 3682));
        assertEquals(9943,  enigma.desencripta(mecanismo02, 9165));
        assertEquals(-1,  enigma.desencripta(mecanismo02, 12));
    }

    @Test
    public void testCommit03()
    {
        Enigma enigma = new Enigma();
        Mecanismo mecanismo03 = new MecanismoSumatorioParcial(7);
                       
        assertEquals(279,   enigma.encripta(mecanismo03, 24));
        assertEquals(84,    enigma.encripta(mecanismo03, 14));
        assertEquals(-1,    enigma.encripta(mecanismo03, 10));        
        assertEquals(14,    enigma.desencripta(mecanismo03, 84));
        assertEquals(24,    enigma.desencripta(mecanismo03, 279));
        assertEquals(-1,    enigma.desencripta(mecanismo03, 46));
    }
    
    @Test
    public void testFuncionamientoCompleto()
    {
        Enigma enigma = new Enigma();
        Mecanismo mecanismo01 = new MecanismoMultiplicacionPrimo(7);
        Mecanismo mecanismo02 = new MecanismoOffset(2);  
        Mecanismo mecanismo03 = new MecanismoSumatorioParcial(7);        
        
        assertEquals(35084, enigma.encripta(mecanismo01, 5012));
        assertEquals(63000, enigma.encripta(mecanismo01, 9000));
        assertEquals(-1,    enigma.encripta(mecanismo01, 8));        
        assertEquals(5012,  enigma.desencripta(mecanismo01, 35084));        
        assertEquals(9000,  enigma.desencripta(mecanismo01, 63000));              
        assertEquals(-1,    enigma.desencripta(mecanismo01, 70));      
        
        assertEquals(3682,  enigma.encripta(mecanismo02, 3460));
        assertEquals(9165,  enigma.encripta(mecanismo02, 9943));
        assertEquals(-1,    enigma.encripta(mecanismo02, 10));
        assertEquals(3460,  enigma.desencripta(mecanismo02, 3682));
        assertEquals(9943,  enigma.desencripta(mecanismo02, 9165));
        assertEquals(-1,    enigma.desencripta(mecanismo02, 12));    
                       
        assertEquals(279,   enigma.encripta(mecanismo03, 24));
        assertEquals(84,    enigma.encripta(mecanismo03, 14));
        assertEquals(-1,    enigma.encripta(mecanismo03, 10));        
        assertEquals(14,    enigma.desencripta(mecanismo03, 84));
        assertEquals(24,    enigma.desencripta(mecanismo03, 279));
        assertEquals(-1,    enigma.desencripta(mecanismo03, 46));
    }    
}
