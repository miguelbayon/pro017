import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FlotaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FlotaTest
{
    private Coche coche1;
    private FurgonetaPequena furgonet1;
    private FurgonetaGrande furgonet2;
    private Camion camion1;
    private Flota flota1;

    /**
     * Default constructor for test class FlotaTest
     */
    public FlotaTest()
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
    public void testFlota01()
    {
        coche1 = new Coche(Marca.FIAT, 8, 2000, 4);
        furgonet1 = new FurgonetaPequena(Marca.FORD, 2, 456, 6);
        furgonet2 = new FurgonetaGrande(Marca.OPEL, 5, 20000, 1000);
        camion1 = new Camion(Marca.CITROEN, 6, 10000, 1500);
        
        flota1 = new Flota();
        
        flota1.addVehiculo(coche1);
        flota1.addVehiculo(furgonet1);
        flota1.addVehiculo(furgonet2);
        flota1.addVehiculo(camion1);        
        
        assertEquals(true, flota1.cumplenMedidas());
        
        assertNull(flota1.marcaMayoritaria());
        
        int[] arrayEsperado0 = {0, 8, 2000, 4, 1};
        assertArrayEquals(arrayEsperado0, flota1.getDatosVehiculo(0));
        int[] arrayEsperado1 = {1, 2, 456, 6};
        assertArrayEquals(arrayEsperado1, flota1.getDatosVehiculo(1));
        int[] arrayEsperado2 = {2, 5, 20000, 1000};
        assertArrayEquals(arrayEsperado2, flota1.getDatosVehiculo(2));
        int[] arrayEsperado3 = {3, 6, 10000, 1500};
        assertArrayEquals(arrayEsperado3, flota1.getDatosVehiculo(3));        
        
        Coche coche2 = new Coche(Marca.FORD, 10, 300000, 4);
        flota1.addVehiculo(coche2);
        
        assertEquals(false, flota1.cumplenMedidas());
        
        assertEquals(Marca.FORD, flota1.marcaMayoritaria());
        
        int[] arrayEsperado4 = {4, 10, 300000, 4, 2};
        assertArrayEquals(arrayEsperado4, flota1.getDatosVehiculo(4));        
        
        flota1.removeVehiculo(4); 
        assertEquals(true, flota1.cumplenMedidas());  
 
        Camion camion2 = new Camion(Marca.CITROEN, 7, 206000, 4000);
        flota1.addVehiculo(camion2);     
        assertEquals(Marca.CITROEN, flota1.marcaMayoritaria());
        assertEquals(false, flota1.cumplenMedidas());
        
        float1.removeVehiculo(5);
        assertEquals(true, flota1.cumplenMedidas()); 
    }
}

