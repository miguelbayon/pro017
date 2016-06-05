## El problema de la herencia mútliple en Java

Al contrario que en otros lenguajes, en Java no existe la herencia múltiple. En la siguiente figura se presenta un diseño (no permitido en Java) en el que la clase C hereda tanto de A como de B. Si, como ocurre en el ejemplo, las dos superclases A y B contienen el método `m1()` y dicho método está implementado de forma distinta en cada una de ellas, existiría un conﬂicto respecto a cuál de las dos implementaciones de `m1()` debería heredar C. 

<p align="center">
  <img src="interfacesImagen01.png">
</p>

Este conﬂicto, por otro lado, no se daría si `m1()` se hubiese deﬁnido abstracto tanto en A como en B, ya que en este caso el método no estaría implementado y por tanto no cabría esperar conﬂicto alguno. Podría pensarse, por tanto, que si A y B fuesen clases abstractas no debería haber inconveniente en permitir la herencia múltiple. Sin embargo, las clases abstractas pueden contener métodos no abstractos, con lo que la exigencia propuesta de que las superclases sean abstractas no garantizaría la ausencia de conﬂictos en un esquema de herencia múltiple.

Para que un diseño como el propuesto fuera fácilmente implementable debería existir algún mecanismo que exigiera tanto a A como a B que todos sus métodos fuesen abstractos. Además, por motivos similares, dicho mecanismo no debería permitir la declaración de atributos de instancia en A o en B, ya que podría darse el caso de que existieran dos atributos con el mismo nombre.

Pues bien, este mecanismo existe en Java y se lleva a la práctica mediante lo que se conoce como __interfaz__. El uso de interfaces, más allá de tratar de resolver únicamente el problema de la herencia múltiple, guarda una estrecha relación con el concepto de polimorﬁsmo, tal y como se verá más adelante.

## Interfaces en Java

La interfaz de una clase viene deﬁnida de forma implícita en función de los miembros públicos que contenga dicha clase. Además de esta deﬁnición implícita, Java dispone de un mecanismo para deﬁnir explícitamente la interfaz (o parte de la interfaz) de una clase, lo que permite separarla completamente de su implementación. Ello se hace mediante la declaración de lo que en Java se denomina una interfaz. 

Sintácticamente, las interfaces son como las clases pero sin variables de instancia y con métodos declarados sin cuerpo. La deﬁnición de una interfaz tiene la forma siguiente:

    modificadorDeAcceso interface nombre_interfaz {
        tipo var1;
        tipo var2;
    
        tipo metodo1();
        tipo metodo2();
    }


El `modificadorDeAcceso` de una interfaz debe ser público, bien con la palabra reservada `public` o sin modiﬁcador de acceso (`friendly`). Después se especiﬁca que la siguiente deﬁnición pertenece a una interfaz utilizando la palabra reservada `interface`, seguida del nombre de la interfaz y del bloque de código correspondiente a la deﬁnición de la interfaz. 

Las variables declaradas en la interfaz, si las hay, son por defecto estáticas (`static`) y ﬁnales (`final`), lo que signiﬁca que han de ser inicializadas con un valor constante y su valor no puede cambiarse posteriormente. Los métodos no tienen cuerpo puesto que son básicamente métodos abstractos que han de ser implementados por las clases que implementan la interfaz.

Las interfeces tienen ciertas similitudes con las clases abstractas. De hecho, una interfaz podría verse como una clase abstracta sin atributos de instancia y en la que todos sus métodos son abstractos.

Como ejemplo se podría deﬁnir la interfaz de cierta colección de objetos del siguiente modo:

    public interface Coleccion {
        void anadirElemento(Object o);
        int getNumElementos();
        void mostrar();
    }

Se puede observar que la interfaz no hace suposiciones acerca de los detalles de implementación. Básicamente una interfaz deﬁne qué operaciones se pueden realizar, pero no cómo se realizan.

Una vez deﬁnida una interfaz, cualquier número de clases puede implementarla. Implementar una interfaz implica __implementar cada uno de los métodos__ deﬁnidos en la misma. Para indicar que una clase implementa una interfaz determinada, se utiliza la palabra reservada `implements` con la siguiente sintaxis:

    modificadorDeAcceso class nombreClase implements NombreInterfaz1 {
        ...
    }

Básicamente, todo lo que necesita una clase para implementar una interfaz es sobreescribir el conjunto completo de métodos declarados en dicha interfaz. En caso de que la clase no sobreescriba todos los métodos, dicha clase deberá declararse abstracta, ya que contiene métodos sin implementar.  Los métodos deﬁnidos en una interfaz deben ser declarados con `public` en la clase que los implementa.















