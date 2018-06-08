import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CuentakilometrosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CuentakilometrosTest
{
    /**
     * Default constructor for test class CuentakilometrosTest
     */
    public CuentakilometrosTest()
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
        Cuentakilometros cuentaki1 = new Cuentakilometros();
        assertEquals(50, cuentaki1.calcularKilometros("10 5"));
        assertEquals(78, cuentaki1.calcularKilometros("5 2 3 7"));
        assertEquals(266, cuentaki1.calcularKilometros("12 5 15 1 6"));
        assertEquals(0, cuentaki1.calcularKilometros(""));
        assertEquals(50, cuentaki1.calcularKilometros("25"));
        assertEquals(550, cuentaki1.calcularKilometros("13 9 22 14 7 8"));
    }
}
