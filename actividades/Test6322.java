import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test6322.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test6322
{
    /**
     * Default constructor for test class ContadorHuecosGofresTest
     */
    public Test6322()
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
        ContadorHuecosGofres contador1 = new ContadorHuecosGofres();
        String entrada = "";
        String resultado = "";  
        entrada = "";
        entrada += "3\n";
        entrada += "2 2\n";
        entrada += "3 2\n";
        entrada += "4 3\n";
        resultado = "";
        resultado += "Caso #1: 1\n";
        resultado += "Caso #2: 2\n";
        resultado += "Caso #3: 6\n";
        assertEquals(resultado, contador1.cuentaHuecosGofres(entrada));
        entrada = "";
        entrada = "30\n";        
        entrada += "2 2\n";
        entrada += "3 2\n";
        entrada += "4 3\n";
        entrada += "8 17\n";
        entrada += "11 16\n";
        entrada += "4 30\n";
        entrada += "6 42\n";
        entrada += "22 31\n";
        entrada += "23 32\n";
        entrada += "50 6\n";
        entrada += "22 34\n";
        entrada += "39 21\n";
        entrada += "58 7\n";
        entrada += "32 40\n";
        entrada += "13 61\n";
        entrada += "78 8\n";
        entrada += "26 62\n";
        entrada += "38 59\n";
        entrada += "62 42\n";
        entrada += "50 60\n";
        entrada += "66 63\n";
        entrada += "48 84\n";
        entrada += "40 95\n";
        entrada += "72 64\n";
        entrada += "47 93\n";
        entrada += "77 73\n";
        entrada += "78 84\n";
        entrada += "83 95\n";
        entrada += "85 97\n";
        entrada += "94 92\n";  
        resultado = "";   
        resultado += "Caso #1: 1\n";
        resultado += "Caso #2: 2\n";
        resultado += "Caso #3: 6\n";
        resultado += "Caso #4: 112\n";
        resultado += "Caso #5: 150\n";
        resultado += "Caso #6: 87\n";
        resultado += "Caso #7: 205\n";
        resultado += "Caso #8: 630\n";
        resultado += "Caso #9: 682\n";
        resultado += "Caso #10: 245\n";
        resultado += "Caso #11: 693\n";
        resultado += "Caso #12: 760\n";
        resultado += "Caso #13: 342\n";
        resultado += "Caso #14: 1209\n";
        resultado += "Caso #15: 720\n";
        resultado += "Caso #16: 539\n";
        resultado += "Caso #17: 1525\n";
        resultado += "Caso #18: 2146\n";
        resultado += "Caso #19: 2501\n";
        resultado += "Caso #20: 2891\n";
        resultado += "Caso #21: 4030\n";
        resultado += "Caso #22: 3901\n";
        resultado += "Caso #23: 3666\n";
        resultado += "Caso #24: 4473\n";
        resultado += "Caso #25: 4232\n";
        resultado += "Caso #26: 5472\n";
        resultado += "Caso #27: 6391\n";
        resultado += "Caso #28: 7708\n";
        resultado += "Caso #29: 8064\n";
        resultado += "Caso #30: 8463\n";        
        assertEquals(resultado, contador1.cuentaHuecosGofres(entrada));        
    }

}

