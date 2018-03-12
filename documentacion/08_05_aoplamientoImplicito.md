## Acoplamiento implícito

Hemos visto que el uso de atributos públicos es una práctica que tiende a crear una forma innecesariamente fuerte de acoplamiento entre clases. Con este acoplamiento fuerte puede ser necesario realizar cambios en más de una clase en aquellas situaciones en las que hubiéramos podido realizar una modificación sencilla. Por tanto, está claro que debemos evitar los atributos públicos. Sin embargo, existe una forma aun peor de acoplamiento: el _acoplamiento implícito_.

El _acoplamiento implícito_ es una situación en la que una clase depende de la información interna de otra, pero dicha dependencia no resulta obvia. El acoplamiento fuerte en el caso de los atributos públicos no era buena, pero al menos sí era obvio: si cambiamos los atributos públicos en la clase `Room` y no cambiamos la clase `Game` la aplicación ya no compila; en este caso, al menos, el compilador nos indica dónde están los problemas. Sin embargo, en los casos de acoplamiento implícito, al hacer cambios en una clase A, puede que los cambios necesarios por ello en una clase B no sean detectados.

Para ver un ejemplo de cómo nos afecta el acoplamiento implícito, vamos a llevar a cabo una modificación en nuestro juego que deje patente el problema. En concreto, lo que vamos a hacer es añadir palabras de comando adicionales a nuestro juego. Durante la explicación se te va a ir indicando dónde se deben realizar cambios: no los lleves a cabo hasta que se te indique explícitamente en una actividad.

Supón que queremos añadir el comando _look_ (mirar) al conjunto de comandos legales. El propósito de _look_ es simplemente imprimir de nuevo por pantalla la descripción de la sala en la que está el personaje y sus posibles salidas. Esto podría ser útil si, una vez llegados a una sala, hemos introducido muchos comandos y la descripción que apareció al llega a dicha sala ha quedado fuera de la pantalla y queremos acordarnos de dónde se encuentran las salidas de la sala actual.

> ![](brain.png) **Actividad 08.05.01**: Revisa el código de la aplicación y piensa dónde deberíamos hacer cambios para poder añadir el comando `look`. Cuando lo tengas claro, sigue leyendo.

Podemos introducir una nueva palabra de comando simplemente añadiéndola a la lista de palabras conocidas en la matriz `validCommands` de la clase `CommandWords`:

```java
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look"
    };
```

Esto muestra, por cierto, un ejemplo de buena cohesión: en lugar de definir las palabras que son comandos en la clase `Parser` (el analizador sintático), que habría sido una posibilidad, el programador que creo el juego ha creado una clase aparte separada (`CommandWords`) para definir dichas palabras. Esto hace que sea muy fácil localizar el lugar en el que están definidas y también resulta muy sencillo añadir una nueva. El programador estaba, al crear el programa, anticipándose a posibles cambios futuros y asumiendo que posteriormente podrían añadirse más comandos, por lo que diseño una estructura para facilitar dicha tarea.

Si para probar la modificación anterior ejecutamos juego y escribimos el comando `look` el resultado es que no ocurre nada. Esto nos hace ver que vamos por buen camino, ya que antes, cuando el juego se encontraba con una palabra desconocida, imprimía por pantalla la respuesta

```
"I don't know what you mean..."
```

que indica que la aplicación no entiende lo que hemos escrito. Por tanto, el hecho de que no veamos dicha respuesta indica que la palabra ha sido reconocida como un comando pero no sucede nada porque no hemos implementado una acción para ese comando.

> ![](brain.png) **Actividad 08.05.02**: Revisa el código de la aplicación y piensa dónde deberíamos escribir el código que se debe ejecutar cuando el usuario invoca el comando `look`. Cuando lo tengas claro, sigue leyendo. 

Para implementar la acción que debe llevar a cabo el comando `look` debemos hacer dos cosas:

1. Implementar un método en la clase `Game` llamado `look` con las acciones que realiza ese comando.

	```java
	private void look() 
	{
		System.out.println(currentRoom.getLongDescription());
	}
	```

2. Añadir un caso para el comando _look_ en el método `processCommand` para invocar el método del punto 1 cuando se reconozca el comando _look_:

	```java
	if (commandWord.equals("help")) {
		printHelp();
	}
	else if (commandWord.equals("go")) {
		goRoom(command);
	}
	else if (commandWord.equals("look")) {
		look();
	}
	else if (commandWord.equals("quit")) {
		wantToQuit = quit(command);
	}
	```

> ![](brain.png) **Actividad 08.05.03**: Implementa en BlueJ los cambios descritos hasta aquí en tu programa, testea que funciona todo y haz un commit (**commit 10**).

> ![](brain.png) **Actividad 08.05.04**: Realiza en BlueJ los cambios necesarios en tu código para que también se pueda invocar al comando _eat_ (comer) que, al ejecutarse, se limite a imprimir el mensaje "_You have eaten now and you are not hungry any more_" (acabas de comer y ya no tienes hambre). Mantén tan simple como se indica este comando porque más adelante lo mejoraremos. Al acabar haz un commit (**commit 11**).

> ![](brain.png) **Actividad 08.05.05**: Casi seguro que, en estos momentos, tu programa contiene un bug. ¿Eres capaz de saber en qué momento aparece? Cuando lo descubras, sigue leyendo.

El acoplamiento entre las clases `Game`. `Parser` y `CommandWords` parece hasta ahora ser bastante bueno; fue fácil realizar la adición de los nuevos comandos y hemos conseguido que todo funcione rápidamente.

El problema del acoplamiento implícito, no obstante, es justamente ese: no se ve a simple vista dónde puede haber un cambio necesario que no hayamos llevado a cabo. Si ahora pruebas a ejecutar el comando `help`, la salida por pantalla será:

```
Your command words are:
 go quit help
```

Analizando la salida observamos un pequeño problema: el texto de ayuda está incompleto  porque el comando _look_ no aparece. Tenemos un bug.

Dicho bug parece fácil de corregir: podemos limitarnos a editar la cadena de texto en el método `printHelp` de la clase `Game` que muestra los comandos disponibles. Esto se puede hacer rápidamente y no parece ser mayor problema. El verdadero problema es darse cuenta de que hay que añadir manualmente en este método cada comando que añadamos al programa (de hecho, ¿habías sido capaz de encontrar el bug en la actividad 08.05.05?).

Ten en cuenta que el programa, sin este cambio en `printHelp` se compila correctamente y todo parece ir bien. El programador que está ampliando el programa podría creer que su tarea ya ha finalizado y lanzar comercialmente un programa que ahora contendrá un error.

Este es un ejemplo de acoplamiento implícito. Cuando los comandos cambian, el texto de ayuda debe modificarse (acoplamiento) pero no hay nada en el código fuente del programa que indique claramente esta dependencia (y es por ello que es implícita).

Un programa bien diseñado evitaría esta forma de acoplamiento siguiendo la regla del diseño dirigido por responsabilidad. Dado que la clase `CommandWords` es la responsable de las palabras que son comandos, también debería ser la responsable de imprimir esas palabras cuando se solicite ayuda. Por tanto, la solución adecuada es implementar el siguiente método a la clase `CommandWords`:

```java
/**
 * Imprime por pantalla todos los comandos válidos
 */
public void showAll()
{
	for (String command : validCommands) {
		System.out.println(command + " ");
	}
	System.out.println();
}
```

La idea aquí es que el método `printHelp` de la clase `Game`, en lugar de imprimir un texto fijo con las palabras que son comandos, invoque un método de la clase `CommandWords` que será el que realice dicha tarea. Hacer esto garantiza que siempre se van a imprimir las palabras que son comandos correctas y que, al añadir un nuevo comando, este comando también aparezca directamente en el texto de ayuda sin más modificaciones.

El único problema que queda por resolver para poder llevar a cabo esto es que el objeto de la clase `Game` no tiene forma de invocar métodos del objeto de la clase `CommandWords` porque no tiene ninguna referencia a este objeto. Podemos ver esto en el diagrama de clases que presenta BlueJ donde no aparece ninguna flecha que vaya de `Game` a `CommandWords`. También podemos verlo en el código fuente de `Game` si nos fijamos en sus atributos

```java
private Parser parser;
private Room currentRoom;
```

y vemos que, en efecto, los únicos objetos que maneja `Game` son de tipo `Parser` y de tipo `Room`. Esto indica que la clase `Game` ni siquiera conoce la existencia de la clase `CommandWords`, solo de las dos clases antes citadas. Si nos fijamos aún más, vemos que el objeto `CommandWords` está incluido como atributo en el objeto de la clase `Parser` pero el objeto `Game` no puede acceder a él.

Podríamos pensar como solución añadir un método a la clase `Parser` (el analizador sintáctico) que devuelva el objeto de la clase `CommanWords` para que el objeto de la clase `Game` pudiera invocar el método `showAll`. Sin  embargo, esta solución aumentará el grado de acoplamiento de la aplicación: ña clase `Game` dependería ahora también de la clase `CommandWords` mientras que, en estos momentos, no lo hace. Asimismo, podríamos visualizar este efecto en el diagrama de clases de BlueJ: la clase `Game` tendría una flecha hacia `CommandWords`.

Las flechad del diagrama son, de hecho, una buena indicación aproximada de lo estrechamente acoplado que está un programa: cuantas más flechas, mayor acoplamiento. Como aproximación a un buen diseño de clases, podemos tratar de crear diagramas que tengan pocas flechas.

Por tanto, el hecho de que `Game` no disponga de una referencia a `CommandWords` es algo bueno. No debemos cambiarlo. Desde el punto de vista de `Game`, el hecho de que la clase `CommandWords` exista es simplemente un asunto propio de la clase `Parser` del cuál no debe ni preocuparse. El objetivo de `Parser` es analizar textos de entrada y devolver comandos y de cómo haga esta tarea (usando la clase `CommandWords` o de cualquier otra forma) es una cosa de la que la clase `Game` no tiene porque preocuparse.

Por tanto, un mejor diseño sería dejar que `Game` hable solo con `Parser`, que, a su vez, puede hablar con `CommandWords`. Podemos implementar esto añadiendo el siguiente código al método `printHelp` de `Game`:

```java
System.out.println("Your command words are:");
parser.showCommands();
```

Y ahora lo único que nos quedaría por escribir sería el método `showCommands` en la clase `Parser`, que delegará esta tarea al objeto de la clase `CommandWords`:

```java
/**
 * Imprime una lista de las palabras de comando validas
 */
public void showCommands()
{
	commands.showAll();
}
```

> ![](brain.png) **Actividad 08.05.06**: Implementa en BlueJ todos los cambios que se han descrito hasta ahora desde la actividad 08.05.04. Testea que todo funciona correctamente y haz un commit (**commit 12**).

> ![](brain.png) **Actividad 08.05.07**: Si ahora quisiéramos añadir un nuevo comando al juego, ¿seguiríamos necesitando modificar la clase `Game`? ¿En qué puntos?

