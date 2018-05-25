import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CreadorDeTablerosTest.
 */
public class Test6345
{
    /**
     * Default constructor for test class CreadorDeTablerosTest
     */
    public Test6345()
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
    public void test01()
    {
        CreadorDeTableros creadorD1 = new CreadorDeTableros();
        String resultado = "";
        resultado += "|----------------|\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|  ##  ##  ##  ##|\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|##  ##  ##  ##  |\n";
        resultado += "|----------------|\n";
        assertEquals(resultado, creadorD1.devolverTablero("2 #"));
        
        resultado = "";
        resultado += "|--------|\n";
        resultado += "| @ @ @ @|\n";
        resultado += "|@ @ @ @ |\n";
        resultado += "| @ @ @ @|\n";
        resultado += "|@ @ @ @ |\n";
        resultado += "| @ @ @ @|\n";
        resultado += "|@ @ @ @ |\n";
        resultado += "| @ @ @ @|\n";
        resultado += "|@ @ @ @ |\n";        
        resultado += "|--------|\n";
        assertEquals(resultado, creadorD1.devolverTablero("1 @"));   
        
        resultado = "";
        resultado += "|------------------------|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";    
        resultado += "|XXX   XXX   XXX   XXX   |\n";  
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|XXX   XXX   XXX   XXX   |\n";    
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";    
        resultado += "|XXX   XXX   XXX   XXX   |\n";  
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";    
        resultado += "|XXX   XXX   XXX   XXX   |\n";  
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";
        resultado += "|   XXX   XXX   XXX   XXX|\n";    
        resultado += "|XXX   XXX   XXX   XXX   |\n";  
        resultado += "|XXX   XXX   XXX   XXX   |\n"; 
        resultado += "|XXX   XXX   XXX   XXX   |\n";         
        resultado += "|------------------------|\n";
        assertEquals(resultado, creadorD1.devolverTablero("3 X"));        
        
    }
}

