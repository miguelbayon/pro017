## Tipos enumerados o enum en Java

Un _tipo enumerado_ o _enum_ es una clase “especial” (tanto en Java como en otros lenguajes) que define en el propio código  de la clase los posibles objetos que puede haber de ese tipo, indicándolos explícitamente en la implementación de la clase. 

Una limitación que tienen los enumerados respecto a una clase normal es que, si el tipo _enum_ tiene constructor, este debe de ser privado, para que ningún programador pueda crear más objetos de los indicados en el código.

Para explicar el concpeto de los ẗipos enumerados vamos a pensar en un programa de fúbtol donde estemos trabajando con jugadores. Uno de los atributos de un futbolista es su demarcación a la hora de jugar un partido de fútbol. Estas demarcaciones son finitas y, por tanto, se pueden enumerar en: portero, defensa, centrocampista y delantero. Con esta especificación podemos crearnos la siguiente clase enum llamada `Demarcación`:

```java
public enum Demarcacion
{
    PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
}
```

Así, en este ejemplo, el tipo `Demarcación` tendrá cuatro objetos de ese tipo en nuestro programa y solo cuatro. Por convenio los nombres de los objetos enumerados se escriben siempre en mayúsculas.

Es muy importante entender que un _enum_ en java es realmente una clase (cuyos objetos solo pueden ser los definidos en esta clase: PORTERO, ..., DELANTERO) que hereda de la clase `Enum(java.lang.Enum)`. Por tanto, los enumerados tienen una serie de métodos heredados de esa clase padre ([ver documentación](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html). 

A continuación vamos a mostrar algunos de los métodos más utilizados de los enumerados:
    
```java    
// Objeto enum de la clase Demarcación
Demarcacion delantero = Demarcacion.DELANTERO; 

// Devuelve un String con el nombre de la constante (DELANTERO)
delantero.name();     

// Devuelve un String con el nombre de la constante (DELANTERO)
delantero.toString(); 

// Devuelve un entero con la posición del enum según está declarada (3)
delantero.ordinal();    

// Compara el enum con el parámetro según el orden en el que están declarados lo enum
delantero.compareTo(Enum otro);    

// Devuelve un array que contiene todos los enum
Demarcacion.values();   
```
    

Vistos cuales son los métodos más utilizados dentro de los enumerados, vamos a poner un ejemplo para ver los resultados que nos devuelven estos métodos. Dado el siguiente fragmento de código:

```java
Demarcacion delantero = Demarcacion.DELANTERO;
Demarcacion defensa = Demarcacion.DEFENSA;

// Devuelve un String con el nombre de la constante
System.out.println("delantero.name() = " + delantero.name());
System.out.println("defensa.toString() = " + defensa.toString());

//  Devuelve un entero con la posición de la constante según está declarada.
System.out.println("delantero.ordinal() = " + delantero.ordinal());

// Compara el enum con el parámetro según el orden en el que están declaradas las constantes. 
System.out.println("delantero.compareTo(defensa)= " + delantero.compareTo(defensa));
System.out.println("delantero.compareTo(delantero)= " + delantero.compareTo(delantero));

// Recorre todas las constantes de la enumeración
for(Demarcacion d: Demarcacion.values()){
    System.out.println(d.toString() + " ");
}
```


Tenemos como salida los siguientes resultados:

    delantero.name() = DELANTERO
    defensa.toString() = DEFENSA
    delantero.ordinal() = 3
    delantero.compareTo(defensa) = 2
    delantero.compareTo(delantero) = 0
    PORTERO DEFENSA CENTROCAMPISTA DELANTERO


Como ya se ha dicho, un _enum_ es una clase especial que limita la creación de objetos a los especificados en su clase (por eso su constructor es privado, como se ve en el siguiente fragmento de código); pero estos objetos pueden tener atributos como cualquier otra clase. En la siguiente declaración de la clase, vemos un ejemplo en la que definimos un enumerado `Equipo` que va a tener dos atributos; el nombre y el puesto en el que quedaron en la liga del año pasado.

```java
public enum Equipo
{
    BARÇA("FC Barcelona",1), 
    REAL_MADRID("Real Madrid",2),
    SEVILLA("Sevilla FC",4), 
    VILLAREAL("Villareal",7); 

    private String nombreClub;
    private int puestoLiga;

    private Equipo (String nombreClub, int puestoLiga){
        this.nombreClub = nombreClub;
        this.puestoLiga = puestoLiga;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public int getPuestoLiga() {
        return puestoLiga;
    }	
}
```


Como se ve BARÇA, REAL_MADRID, etc. son los nombres de los objeto _enum_ (u objetos de la clase `Equipo`) que tendrán como atributos el “nombreClub” y “puestoLiga”. Como se ve en la clase definimos un constructor que es privado (es decir que solo es visible dentro de la clase `Equipo`) y solo definimos los métodos “get”. Para trabajar con los atributos de estos enumerados se hace de la misma manera que con cualquier otro objeto; se instancia un objeto y se accede a los atributos con los métodos get. 

En el siguiente fragmento de código vamos a ver como trabajar con enumerados que tienen atributos:

```java
// Creamos un objeto de tipo enum
Equipo villareal = Equipo.VILLAREAL;

// Devuelve un String con el nombre de la constante
System.out.println("villareal.name() = " + villareal.name());

// Devuelve el contenido de los atributos
System.out.println("villareal.getNombreClub() = " + villareal.getNombreClub());
System.out.println("villareal.getPuestoLiga() = " + villareal.getPuestoLiga());
```
    

Como salida de este fragmento de código tenemos lo siguiente:

    villareal.name() = VILLAREAL
    villareal.getNombreClub() = Villareal
    villareal.getPuestoLiga() = 7
    
    
Es muy importante entender que los _enum_ no son `Strings` sino que son objetos de una clase y que no se pueden crear otros objetos de esa clase desde cualquier otro lado que no sea dentro de esa clase. 

Es muy común (sobre todo cuando se esta aprendiendo que son los enumerados) que se interprete que un enumerado es una lista finita de `Strings` cuando en realidad es una lista finita de objetos de una determinada clase con sus atributos, constructor y métodos getter aunque estos sean privados.








