import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GooglePlayTest02.
 *
 */
public class GooglePlayTest02
{
    /**
     * Default constructor for test class GooglePlayTest
     */
    public GooglePlayTest02()
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
    public void TestApartado03()
    {
        // Se crea la tienda
        GooglePlay googlePlay = new GooglePlay();
        
        // Se crean los usuarios de la tienda
        Usuario usuario1 = new Usuario("juan.fernandez@gmail.com");
        Usuario usuario2 = new Usuario("elena.perez@gmail.com");
        Usuario usuario3 = new Usuario("pedro.garcia@gmail.com");
        Usuario usuario4 = new Usuario("lorena.alonso@gmail.com");    

        // Se añaden los usuarios a la tienda
        googlePlay.addUsuario(usuario1);
        googlePlay.addUsuario(usuario2);                               
        googlePlay.addUsuario(usuario3);       
        googlePlay.addUsuario(usuario4);      
                         
        // Se crean los productos
        Producto aplicaci1 = new Aplicacion("Spotify", 18.5, Categoria.MULTIMEDIA);
        Producto aplicaci2 = new Aplicacion("WhatsApp", 22.32, Categoria.COMUNICACIONES);
        Producto aplicaci3 = new Aplicacion("Pokemon GO", 32.5, Categoria.JUEGOS); 
        Producto aplicaci4 = new Aplicacion("Gmail", 32.5, Categoria.PRODUCTIVIDAD);        
        Producto libro1 = new Libro("No culpes al karma", 2014, 329, true);
        Producto libro2 = new Libro("La chica del tren", 2015, 625, true);
        Producto libro3 = new Libro("El poder del ahora", 2011, 154, false);        
        Producto pelicula1 = new Pelicula("El renacido", 2015, 156, 1080);
        Producto pelicula2 = new Pelicula("Casablanca", 1942, 102, 480);
                        
        // Se añaden los productos a la tienda     
        googlePlay.addProducto(aplicaci1);        
        googlePlay.addProducto(aplicaci2);      
        googlePlay.addProducto(aplicaci3); 
        googlePlay.addProducto(aplicaci4);           
        googlePlay.addProducto(libro1);        
        googlePlay.addProducto(libro2);        
        googlePlay.addProducto(libro3);        
        googlePlay.addProducto(pelicula1);       
        googlePlay.addProducto(pelicula2);    
        
        // Se realizan la compra de un producto y luego se vuelve a querer comprar
        assertEquals(0.99, googlePlay.comprar("juan.fernandez@gmail.com", "Spotify"), 0.0001);
        assertEquals(-1, googlePlay.comprar("juan.fernandez@gmail.com", "Spotify"), 0.0001);        
    }       
    
    @Test
    public void TestApartado04()
    {
        // Se crea la tienda
        GooglePlay googlePlay = new GooglePlay();
        
        // Se crean los usuarios de la tienda
        Usuario usuario1 = new Usuario("juan.fernandez@gmail.com");
        Usuario usuario2 = new Usuario("elena.perez@gmail.com");
        Usuario usuario3 = new Usuario("pedro.garcia@gmail.com");
        Usuario usuario4 = new Usuario("lorena.alonso@gmail.com");    

        // Se añaden los usuarios a la tienda
        googlePlay.addUsuario(usuario1);
        googlePlay.addUsuario(usuario2);                               
        googlePlay.addUsuario(usuario3);       
        googlePlay.addUsuario(usuario4);      
                         
        // Se crean los productos
        Producto aplicaci1 = new Aplicacion("Spotify", 18.5, Categoria.MULTIMEDIA);
        Producto aplicaci2 = new Aplicacion("WhatsApp", 22.32, Categoria.COMUNICACIONES);
        Producto aplicaci3 = new Aplicacion("Pokemon GO", 32.5, Categoria.JUEGOS); 
        Producto aplicaci4 = new Aplicacion("Gmail", 32.5, Categoria.PRODUCTIVIDAD);        
        Producto libro1 = new Libro("No culpes al karma", 2014, 329, true);
        Producto libro2 = new Libro("La chica del tren", 2015, 625, true);
        Producto libro3 = new Libro("El poder del ahora", 2011, 154, false);        
        Producto pelicula1 = new Pelicula("El renacido", 2015, 156, 1080);
        Producto pelicula2 = new Pelicula("Casablanca", 1942, 102, 480);
                        
        // Se añaden los productos a la tienda     
        googlePlay.addProducto(aplicaci1);        
        googlePlay.addProducto(aplicaci2);      
        googlePlay.addProducto(aplicaci3); 
        googlePlay.addProducto(aplicaci4);           
        googlePlay.addProducto(libro1);        
        googlePlay.addProducto(libro2);        
        googlePlay.addProducto(libro3);        
        googlePlay.addProducto(pelicula1);       
        googlePlay.addProducto(pelicula2);    
        
        // Se realizan compras
        googlePlay.comprar("juan.fernandez@gmail.com", "Spotify");

        googlePlay.comprar("juan.fernandez@gmail.com", "Pokemon GO");       
        googlePlay.comprar("elena.perez@gmail.com", "Pokemon GO"); 
        
        googlePlay.comprar("juan.fernandez@gmail.com", "WhatsApp");
        googlePlay.comprar("elena.perez@gmail.com", "WhatsApp");
        googlePlay.comprar("pedro.garcia@gmail.com", "WhatsApp");        
                
        googlePlay.comprar("juan.fernandez@gmail.com", "El renacido");
        googlePlay.comprar("elena.perez@gmail.com", "El renacido");       ;
        googlePlay.comprar("pedro.garcia@gmail.com", "El renacido");      
        googlePlay.comprar("lorena.alonso@gmail.com", "El renacido"); 
        
        // Se piden los 3 productos de la tienda con más ventas
        assertEquals("\"El renacido\" (4) - \"Whatsapp\" (3) - \"Pokemon GO\" (2)", googlePlay.topVentas());
    }            
}

















