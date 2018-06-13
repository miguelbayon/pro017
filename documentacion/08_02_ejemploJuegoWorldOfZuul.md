## El ejemplo del juego "World of zuul"


El juego "World of Zuul" tal y como está ahora mismo no es muy interesante. En realidad, en su estado actual es bastante aburrido, pero proporciona una buena base para que podamos diseñar e implementar nuestro propio juego, que cabe esperar sea más interesante.

Comenzaremos por analizar las clases existentes en esta primera versión y trataremos de averiguar qué es lo que hacen. El proyecto cuenta con cinco clases: `Parser`, `CommandWords`, `Command`, `Room` y `Game`. 

Una investigación del código fuente muestra que, afortunadamente, estas clases están muy bien documentadas, lo que nos permite hacernos una idea inicial de lo que hacen simplemente leyendo el comentario incluido al principio de cada clase. Esto también sirve para ilustrar que un mal diseño implica algo más profundo que simplemente el aspecto de una clase o lo buena que sea su documentación. Nuestra comprensión del código se verá ayudada echando un vistazo al código fuente para ver qué métodos tiene cada clase y qué es lo que algunos de los métodos parecen hacer. 

He aquí un resumen del propósito de cada clase:

- _CommandWords_: La clase `CommandWords` define todos los comandos válidos del juego. Lo hace manteniendo una matriz de objetos `String` que representan las palabras utilizadas como comandos.

- _Parser_: Es el analizador sintáctico, que lee las lineas que se teclean en la terminal y trata de interpretarlas como comandos. Crea objetos de la clase `Command` que representan el comando que se ha introducido.

- _Command_: Un objeto `Command` representa un comando introducido por el usuario. Dispone de métodos que hacen que sea fácil comprobar si es un comando válido y que permiten extraer la primera y la segunda palabra del mismo en forma de cadenas de caracteres independientes.

- _Room_: Un objeto `Room` representa una de las ubicaciones o salas del juego. Las salas pueden tener salidas que conducen a otras salas.

- _Game_: La clase `Game` es la clase principal del juego. Configura el juego y entra en un bucle para leer y ejecutar comandos. También contiene el código que implementa cada conando del usuario.
