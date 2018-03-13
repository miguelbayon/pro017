### Planificación por adelantado

El diseño que tenemos en estos momentos del juego constituye una mejora importante con respecto a la versión original. Sin embargo, es posible mejorarlo aún más.

Una característica de un buen programador es su capacidad para anticiparse a los acontecimientos. Para ello es necesario pensar qué coas pueden cambiar en el futuro en nuestra aplicación y qué cosas podemos suponer, con una cierta garantía, que no sufrirán modificaciones durante todo el tiempo de vida de nuestro programa,

Usa suposición que hemos tenido en cuenta en la mayoría de nuestras clases hasta ahora es que este juego se ejecutará siempre mediante una interfaz basada en texto, en la que los comandos y las salidas de los mismos se imprimirán siempre por la terminal. Sin embargo, parece razonable que en una futura ampliación del programa sería interesante añadir una interfaz gráfica con botones, imágenes, etc. En este caso, los mensajes que genera la aplicación ya no serían impresos en la terminal, sino en dicha interfaz.

Una buena práctica de diseño consiste en tratar de encapsular toda la información acerca de la interfaz de usuario en una única clase o en un conjunto de clases pequeño bien definido. En el estado actual del juego, por ejemplo, el método `showAll` de la clase `CommandWords` no sigue esta regla de diseño. Sería mucho mejor definir que la clase `CommandWords` es la responsable de _generar_ (pero no de _imprimir por pantalla_) el texto con la lista de palabras que son comandos y dejar que sea la clase `Game`, al recibir dicha información, la que decida por donde se muestra esa información (si por la terminal o por una interfaz gráfica).

Podemos hacer esto modificando el método `showAll` de modo que devuelva una cadena de caracteres que contenga todas las palabras que son comandos en lugar de imprimirlas por pantalla directamente. Ello implica también renombrar el método y denominarlo `getCommandList` para que este en consonancia con la nueva labor de dicho método. La cadena devuelta por este método será entonces impresa por pantalla por el método `printHelp` de la clase `Game`.

Hay que tener en cuenta que este cambio que se propone no nos supone, en este momento, ninguna ventaja con respecto al estado actual del juego, pero es interesante de cara a implementar nuevas funcionalidades más adelante.

> ![](brain.png) **Actividad 08.06.01**: Implementa el cambio sugerido en esta sección. Asegúrate que una vez realizadas todas las modificaciones necesarias, el programa sigue funcionando como lo hacía antes. Luego, realiza un commit (**commit 13**).

> ![](brain.png) **Actividad 08.06.02**: Investiga en Internet en qué consiste el patrón _modelo-vista-controlador (MVC o model-view-controller)_. ¿En qué consiste dicho patrón? ¿Tiene alguna relación con lo explicado en esta sección?


### Cohesión

La idea de cohesión se refiere a que cada unidad de código debería ser siempre responsable de una y de solo una tarea. El principio de cohesión puede aplicarse tanto a clases como a métodos y el objetivo es que tanto unos como los otros presenten un alto grado de cohesión.

A continuación vamos a analizar este principio de diseño utilizando algunos ejemplos.

#### Cohesión de métodos

Cuando hablamos de la cohesión de métodos queremos expresar que, idealmente, cada método debe ser responsable de una, y solo una, tarea bien definida.

Podemos ver un ejemplo de método con una alta cohesión en el método `printWelcome` de la clase `Game`. Este método privado se utiliza para mostrar el mensaje de bienvenida y es invocado en el momento de comenzar el juego dentro del método `play`.

Desde un punto de vista de funcionamiento podríamos haber introducido directamente las instrucciones del método `printWelcome` directamente en el método `play` y habriamos conseguido el mismo resultado sin necesidad de definir un método adicional ni de realizar una llamada a dicho método. Lo mismo puede decirse también del método `processCommand` también de la clase `Game` que se invoca también dentro del método `play`: este código bien podría haberse escrito directamente en `play` y todo funcionaría correctamente.

Sin embargo es mucho más fácil entender lo que hace un segmento de código y es también más fácil realizar modificaciones en el mismo si se utilizan métodos cortos y con alta cohesión. Con la estructura de métodos que el autor original eligió, todos los métodos son relativamente cortos y fáciles de entender y, además, los nombres de los métodos indican su propósito de forma bastante clara (cosa que es difícil de conseguir cuando un método se dedica a hacer múltiples cosas). Estas características hacen que el programador que modifica ahora el código para añadir nueva funcionalidad o corregir errores esté en una situación más ventajosa.

#### Cohesión de clases

La regla de la cohesión de clases afirma que cada clase debería representar una única entidad bien definida dentro del dominio del problema.

Como ejemplo de cohesión de clases, vamos a analizar cómo llevar a cabo otra ampliación en nuestro juego. Nuestro objetivo va a ser estudiar como conseguir que existan objetos en el juego (_items_). Cada sala va a poder tener un objeto y cada objeto va a tener una descripción (por ejemplo, "_un cofre lleno de monedas de oro"_) y un peso (por ejemplo, _600_ gramos).

> ![](brain.png) **Actividad 08.06.03**: Sin hacer ninguna modificación a tu código, piensa cómo podrías llevar a cabo dicha funcionalidad y qué cambios y añadidos necesitarías implementar en tu programa. Una vez que lo tengas claro, continua leyendo.

Un enfoque simplista para solucionar el problema sería añadir dos atributos a la clase `Room`: un atributo `itemDescription` que almacenaría la descripción del objeto existente en la sala y un atributo `itemWeight` que almacenaría el peso de dicho objeto. Esto podría funcionar sin problemas y seríamos capaces de imprimir sin muchos problemas la descripción y el peso del objeto correspondiente cada vez que entráramos en una sala.

Sin embargo, este enfoque no presenta un buen grado de cohesión: la clase `Room` ahora describe tanto una sala como un objeto. Esto, ademas de provocar una baja cohesión, implica que cada objeto está ligado a una sala, lo que tal vez choque con cambios venideros en el programa.

Un diseño mejor consistiría en crear una clase separada para representar los objetos del juego llamada `Item`. Esta clase tendría atributos para almacenar la descripción y el peso de cada objeto y lo que los objetos de la clase `Room` contendrían sería simplemente un atributo que sería una referencia a un objeto de la clase `Item`.

> ![](brain.png) **Actividad 08.06.04**: Modifica tú código para que ahora cada sala pueda tener un objeto (no es obligatorio que lo tenga). Cada objeto tiene una descripción y un peso. Al crear las salas y definir sus salidas en la clase `Game` tendremos también que crear y asociar los objetos para cada sala. Cuando un jugador entra en una sala debe visualizarse por pantalla toda la información acerca del objeto presente en la misma si es que hay uno. Piensa antes de realizar las modificaciones qué clase debe ser la encargada de generar el texto con la información del objeto y qué clase debe ser la encargada de imprimir por pantalla dicho texto. Una vez que hayas realizado los cambios y compruebes que el programa funciona tal y como se pide, haz un commit (**commit 14**).

Una de las ventajas reales de optar por separar las salas y los objetos en clases diferentes puede ponerse de manifiesto si ahora queremos permitir que cada sala no solo tenga un único objeto sino un número ilimitado de ellos. 

En el diseño que utiliza una clase `Item` separada, resulta sencillo crear múltiples objetos de la clase `Item` y almacenarlos en una colección dentro de la sala. 

Con el primer enfoque, el de usar dos atributos adicionales en la clase `Room` este cambio habría sido casi imposible de implementar.

> ![](brain.png) **Actividad 08.06.05**: Modifica el proyecto de modo que una sala pueda albergar cualquier número de elementos. Asegúrate de conseguir que las salas dispongan de un método denominado `addItem` que permita colocar un elemento en la sala. Comprueba también que se muestran todos los elementos cuando un jugador entra en una sala o cuando ejecuta el comando _look_ dentro de ella.

#### Cohesión para la legibilidad

Son varias las maneras en que una alta cohesión beneficia a un programa. Las dos más importantes son que mejora la _legibilidad_ y facilita la _reutilización de código_.

El método `play` de la clase `Game` representa un buen ejemplo de como al tener los métodos de dicha clase una alta cohesión la lectura del código de ese método se simplifica. Piensa que si las instrucciones de los métodos `printWelcome` y `processCommand` estuvieran escritas directamente en `play` nos llevaría más tiempo y esfuerzo entender el cometido de dicho método.

Otro ejemplo de mejora de la legibilidad es la existencia de una alta cohesión a nivel de clases. Por ejemplo, como existe por si sola la clase `Item`, si un programador quisiera ahora añadir funcionalidades a los objetos sabría fácilmente a dónde dirigirse para hacer dichas modificaciones.

#### Cohesión para la reutilización

La segunda mayor ventaja de la cohesión alta es que ofrece un mayor potencial para reutilizar código.

La existencia de la clase `Item` como clase separada también constituye aquí una buen ejemplo de esto: podemos crear múltiples objetos en una sala usando el mismo código para cada uno de ellos. Si no hubiéramos creado esa clase y hubiéramos usado dos atributos en la clase `Room` como se propuso originalmente, estaríamos obligados a repetir código, creando por ejemplo otros dos atributos para un segundo objeto en la sala.

Otro ejemplo de reutilización lo podemos ver en los métodos `getExit` y `pgetLongDescription` de la clase `Room`. Imagina que hubiéramos implementado en la clase `Room` un método denominado `leaveRoom` con la siguiente cabecera:

```java
public Room leaveRoom(String direction)
```

Podríamos hacer que este método devolviera la sala existente en la dirección especificada (para que pudiera ser asignada al atributo `currentRoom` de `Game` cuando invocamos el comando _go_) y a la vez imprimir por pantalla la descripción de esta nueva sala en la que acabamos de entrar.

Esto parece un diseño perfectamente factible y podríamos hacer que funcionara. Sin embargo, en nuestra versión actual lo que hecho hecho es tener esas dos tareas separadas en dos métodos:

```java
public Room getExit(String direction)
public String getLongDescription()
```

El primero de ellos es responsable de devolver la siguiente sala existente en la dirección especificada mientras que el segundo genera la descripción de la sala y la devuelve.

La ventaja de esta división de tareas en dos métodos en vez de en uno solo es que estos métodos pueden reutilizarse. Por ejemplo, el método `getLongDescription` se invoca no solo en el método `goRoom` de la clase `Game` sino también en el método `printWelcome`  y en el método que implementa el comando _look_. Esto solo es posible porque el método `getLongDescription` presenta una cohesión alta (si observas esta reutilización sería imposible en el caso del supuesto método `leaveRoom` porque su cohesión es baja, es decir, hace muchas tareas).

> ![](brain.png) **Actividad 08.06.06**: Implementa un comando denominado _back_. Este comando se invoca solo y el resultado es que hace que el personaje vuelva a la sala de donde venía. El jugador no debe cambiar de localización si este comando se invoca al inicio o si se invoca dos o más veces seguidas sin haber ejecutado el comando _go_ entre ellas. Una vez que testees que el programa se comporta como deseamos, haz un commit (**commit 15**).

> ![](brain.png) **Actividad 08.06.07**: Modifica el comando _back_ para que al utilizarlo repetidamente podamos retroceder varias salas, volviendo al principio del juego si usamos el comando las veces necesarias. Para ello es obligatorio que utilices un objeto de la clase `Stack` (investiga en Internet cómo usar dicho objeto). Una vez que compruebes que el programa se comporta como deseamos, haz un commit (**commit 15**).
