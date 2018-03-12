
## Acoplamiento implícito

Hemos visto que el uso de atributos públicos es una práctica que tiende a crear una forma innecesariamente fuerte de acoplamiento entre clases. Con este acoplamiento fuerte puede ser necesario realizar cambios en más de una clase en aquellas situaciones en las que hubiéramos podido realizar una modificación sencilla. Por tanto, está claro que debemos evitar los atributos públicos. Sin embargo, existe una forma aun peor de acoplamiento: el _acoplamiento implícito_.

El _acoplamiento implícito_ es una situación en la que una clase depende de la información interna de otra, pero dicha dependencia no resulta obvia. El acoplamiento fuerte en el caso de los atributos públicos no era buena, pero al menos sí era obvio: si cambiamos los atributos públicos en la clase `Room` y no cambiamos la clase `Game` la aplicación ya no compila; en este caso, al menos, el compilador nos indica dónde están los problemas. Sin embargo, en los casos de acoplamiento implícito, al hacer cambios en una clase A, puede que los cambios necesarios por ello en una clase B no sean detectados.

Para ver un ejemplo de cómo nos afecta el acoplamiento implícito, vamos a llevar a cabo una modificación en nuestro juego que deje patente el problema. En concreto, lo que vamos a hacer es añadir palabras de comando adicionales a nuestro juego. 

Supón que queremos añadir el comando _look_ (mirar) al conjunto de comandos legales. El propósito de _look_ es simplemente imprimir de nuevo por pantalla la descripción de la sala en la que está el personaje y sus posibles salidas. Esto podría ser útil si, una vez llegados a una sala, hemos introducido muchos comandos y la descripción que apareció al llega a dicha sala ha quedado fuera de la pantalla y queremos acordarnos de dónde se encuentran las salidas de la sala actual.

- [x] @mentions, #refs, [links](), **formatting**

Podemos introducir una nueva palabra de comando simplemente añadiéndola a la lista de palabras conocidas en la matriz `validCommands` de la clase `CommandWords`:

```java
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look"
    };
```

> Esto muestra, por cierto, un ejemplo de buena cohesión: en lugar de definir las palabras que son comandos en la clase `Parser` (el analizador sintático), que habría sido una posibilidad, el programador que creo el juego ha creado una clase aparte separada (`CommandWords`) para definir dichas palabras. Esto hace que sea muy fácil localizar el lugar en el que están definidas y también resulta muy sencillo añadir una nueva. El programador estaba, al crear el programa, anticipándose a posibles cambios futuros y asumiendo que posteriormente podrían añadirse más comandos, por lo que diseño una estructura para facilitar dicha tarea.

Ya podemos probar la modificación que hemos hecho. Al realizar este cambio y luego ejecutar el juego y escribir el comando `look` no ocurre nada. Esto nos hace ver que vamos por buen camino, ya que antes, cuando el juego se encontraba con una palabra desconocida, imprimía por pantalla la respuesta

```
"I don't know what you mean..."
```

que indica que la aplicación no entiende lo que hemos escrito. Por tanto, el hecho de que no veamos dicha respuesta indica que la palabra ha sido reconocida como un comando pero no sucede nada porque no hemos implementado una acción para ese comando.
