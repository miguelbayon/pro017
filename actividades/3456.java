import java.util.ArrayList;

public class 3456
{
    
    public void metodo() 
    {
        int a = 0;
        Integer b = 0;
        String c = "Hola";
        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(2);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);        
        
        System.out.println();;
        System.out.println("Se intenta cambiar las 4 variables locales con un metodo...");
        metodoQueIntentaCambiarParametros(a, b, c, d);
        
        System.out.println();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);        
    }
    
    private void metodoQueIntentaCambiarParametros(int parametro1, Integer parametro2, String parametro3, ArrayList<Integer> parametro4) 
    {
        parametro1 = 10;
        parametro2 = 20;
        parametro3 = "Adios";
        parametro4.add(3);
        
    }
}
