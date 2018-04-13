## Refactorización para la independencia respecto del idioma (I)

Una característica del juego que todavía no hemos comentado es que la interfaz del usuario está estrechamente ligada a comandos escritos en inglés. Esta suposición, la de que el juego es en inglés, está integrada tanto en la clase `CommandWords`, en la que se almacenan los comandos válidos, como en la clase `Game`, en la que el método `processcommand` compara explícitamente cada palabra que es un comando con un conjunto de palabras en inglés. 

Si ahora queremos cambiar la interfaz de usuario para permitir a los usuarios utilizar un idioma diferente, entonces tendremos que localizar todos los lugares del código fuente en los que se utilizan palabras de comando y modificar esas secciones de código. Este es un ejemplo mas de acoplamiento implícito.

Si queremos que el programa sea independiente del idioma, entonces deberíamos tener, idealmente, un único punto en el código fuente en el que se almacene el texto real de las palabras que son comandos y hacer que, en todo el resto de lugares donde necesitamos conocer esas palabras se haga referencia a los ellas de una manera que sea independiente del idioma usado. Una característica de Java que hace que esto sea posible son los _tipos enumerados_ o _enums_. 

### Tipos enumerados e instrucción switch

A continuación se muestra la definición de un tipo enumerado en Java denominado `CommandWord` (ojo, no confundir con la clase `CommandWords` existente hasta ahora) que habría que incorporar a nuestra aplicación:

```java
public enum CommandWord
{
    // Un objeto para cada comando, mas otro para los comandos no reconocidos
    GO, QUIT, HELP, LOOK, EAT, BACK, TAKE, DROP, ITEMS, UNKNOWN
}
```

En su forma más simple, una definición de tipo enumerado consta de un envoltorio exterior que utiliza la palabra `enum` en lugar de `class` y de un cuerpo que es, simplemente, una lista de nombres de variables que se escriben siempre en mayúsculas. En nuestros programas nunca vamos a crear objetos de tipo enumerado porque, cada nombre contenido en la definición del tipo es ya un objeto de ese tipo _enum_, que se crea al iniciar la aplicación y que ya está listo para ser utilizado por nosotros cuando queramos. 

Para hacer referencia a los objetos existentes del tipo _enum_ lo haremos escribiendo `CommandWord.GO`, `CommandWord.QUIT`, etc. Aunque la sintaxis para utilizar estos objetos _enum_ es similar a la que se usa para usar constantes tenemos que ser conscientes que no tiene nada que ver una cosa con la otra.

¿Cómo podemos utilizar el tipo `CommandWord` como ayuda para intentar desacoplar la lógica del juego de _zuul_ con respecto a cualquier idioma concreto? Una de las primeras mejoras que podemos hacer es en el método `processCommand` de `Game`:

```java
if(command.isUnknown()) {
    System.out.println("I don't know what you mean...");
    return false;
}

String commandWord = command.getCommandWord();
if (commandWord.equals("help")) {
    printHelp();
}
else if (commandWord.equals("go")) {
    goRoom(command);
}
else if (commandWord.equals("quit")) {
    wantToQuit = quit(command);
}
```

Si hacemos que la variable local `commandWord` existente en el método `processCommand`  sea del tipo `CommandWord` en lugar de ser de tipo `String` (como era hasta ahora), entonces podemos reescribir esto como:

```java
if (commandWord == CommandWord.UNKNOWN) {
    System.out.println("I don't know what you mean...");
    return false;
}

CommandWord commandWord = command.getCommandWord();
if (commandWord == CommandWord.HELP) {
    printHelp();
}
else if (commandWord == Command.GO) {
    goRoom(command);
}
...
```

De hecho, ahora que hemos cambiado el tipo de la variable a `CommandWord` también podríamos aprovechar para mejorar nuestro código y utilizar una _instrucción switch_ en lugar de esa serie de instrucciones _if_. Esto expresa las intenciones de este segmento de código con algo más de claridad:

```java
switch (commandWord) {
     case UNKNOWN:
         System.out.println("I don't know what you mean...");
         break;
     case HELP:
         printHelp();
         break;
...
}
```

La instrucción _switch_ selecciona una secuencia de instrucciones para su ejecución a partir de una serie de múltiples opciones diferentes. Para ello toma la variable encerrada entre los paréntesis que siguen a la palabra clave `switch` (en nuesto caso, `commandWord`) y la compara con cada uno de los enumerados detrás de las palabras clave `case`. Cuando  se encuentra una correspondencia se ejecuta el código situado detrás de ella. La instrucción `break` hace que la ejecución de la instrucción `switch` se interrumpa en dicho punto y que pase al punto en que finaliza la instrucción `switch`.

Esta instrucción `switch` funciona tanto con variables enteras, de tipo `String`, de tipo _enum_, flotantes, booleanos, etc.

Una de las cosas que tendremos que hacer a continuación será que los comandos escritos por el usuario se asignen a los valores correspondientes de `CommandWord`. Para ello, primero debemos eliminar en la clase `CommandWords` el atributo que nos almacena los posibles comandos (actualmente un array tradicional de objetos `String`) y sustituirlo por un `HashMap` que nos mapee las correspondencias entre los `String` que mete el usuario y los objetos `CommandWord` correspondientes. El constructor, quedaría entonces de la siguiente forma:

```java
public CommandWords()
{
    validCommands = new HashMap<>();
    validCommands.put("go", CommandWord.GO);
    validCommands.put("help", CommandWord.HELP);
    validCommands.put("quit", CommandWord.QUIT);
}
```

Con este cambio nos vemos obligados a modificar la implementación (¡sólo la implementación!) de los métodos `isCommand` y `getCommandList` de la clase `CommandWords`, ya que ahora no compila debido a que estos métodos estaban codificados para trabajar sobre el antiguo array.

También nos será útil añadir un método a esa misma clase con la siguiente cabecera:

```java
/**
 * Return the CommandWord associated with a word.
 * @param commandWord The word to look up (as a string, like "go" o "look").
 * @return The CommandWord corresponding to the String commandWord (like GO or LOOK), or UNKNOWN
 *         if it is not a valid command word.
 */
public CommandWord getCommandWord(String commandWord)
```

A continuación, en la clase `Command` tendremos que hacer las modificaciones adecuadas para que el atributo `commandWord` sea ahora de tipo `CommandWord` (en vez de como era hasta ahora un `String`). Date cuenta que ya no vamos a utilizar el valor `null` en el atributo `commandWord` para indicar que un comando no es valido sino que nos valemos de uno de los objetos de la clase _enum_ para ello (`UNKNOWN`). La estructura de la clase `Command` (donde no se incluye la implementación de los métodos) debe ser la siguiente:

```java
public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param commandWord The CommandWord. UNKNOWN if the command word
     *                  was not recognised.
     * @param secondWord The second word of the command. May be null.
     */
    public Command(CommandWord commandWord, String secondWord)
    {
		...
    }

    /**
     * Return the command word (the first word) of this command.
     * @return The command word.
     */
    public CommandWord getCommandWord()
    {
       ....
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        ...
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        ...
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        ...
    }
}
```

El siguiente paso es modificar la clase `Parser` para que compile teniendo en cuenta los cambios realizados hasta ahora. Date cuenta que ahora el objeto `Command` que devuelve el método `getCommand` no debe tener un `null` como primer atributo sino  `UNKNOWN`. Por tanto, las instrucciones `return` de `getCommand` que ahora mismo están dentro de un _if/else_ deben ser modificadas convenientemente.



> ![](brain.png) **Actividad 08.09.01**: Estando en la rama `master`, crea una nueva rama llamada `usoenum` en la que vamos a implementar el uso de _enums_ en nuestro juego. 
>
>1. Estando en la nueva rama, realiza los cambios que se han comentado en esta sección. Testea que todo funciona correctamente y luego fusiona dicha rama con la rama `master` (**commit 21**).
