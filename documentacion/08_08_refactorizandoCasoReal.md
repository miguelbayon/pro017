### Refactorizando un caso real

Vamos a retomar el objetivo de nuestro ejercicio anterior, que consiste en que: 

* El jugador pueda coger objetos de la sala en la que se encuentre.
* El jugador pueda transportar cualquier número de objetos, pero solo hasta un cierto peso máximo.
* Algunos objetos no puedan cogerse.
* El jugador pueda soltar objetos en la sala actual.

Para alcanzar estos objetivos podemos hacer lo siguiente:

* Añadir un atributo `id` a la clase `Item` que nos permitirá referirnos a un objeto utilizando un nombre sin espacios que ser más corto sea más fácil de usar por el usuario y que, además, facilite que `Parser`, nuestro analizador sintáctico, no tenga problemas para identificar con qué objeto queremos interactuar. Por ejemplo, si hay un libro en la sala actual, los valores de los atributos para este objeto podrían ser:

	```
	id: "libro"
	descripción: "Un viejo y polvoriento libro de hechizos"
	peso: 1200
	```

	Si entramos en una sala, podemos imprimir la descripción del objeto para informar al jugador de qué es lo que hay ahí. Pero para usar los comandos, el id resulta más fácil de utilizar (porque es más corto y porque no tiene espacios). Por ejemplo, el jugador podría escribir `take libro` para coger el libro.

* Podemos garantizar que algunos elementos no puedan cogerse simplemente haciéndolos demasiado pesados (más de lo que un jugador pueda transportar). ¿O deberíamos de disponer de un atributo de tipo `boolean` que se llamara `canBePickedUp``y que nos indique si se puede coger el objeto o no? ¿Cuál crees que es un mejor diseño? Piensa la respuesta a esta pregunta teniendo en cuenta posibles cambios futuros que podamos hacer al programa.

* Añadiremos comandos `take` y `drop` para coger y soltar objetos. Ambos comandos emplean como segunda palabra el id del objeto.

* En algún lugar tenemos que añadir un atributo (que almacene algún tipo de colección) para almacenar los objetos que actualmente transporta el jugador. También tenemos que añadir un atributo con el peso máximo que el jugador puede transportar, para poder verificarlo cada vez que el jugador trate de coger algo.

Esta última tarea es la que analizaremos ahora con más detalle para ilustrar el proceso de refactorización.

La primera pregunta que nos tenemos que plantear al pensar en cómo permitir a los jugadores transportar objetos es: ¿dónde deberíamos añadir los atributos para los objetos actualmente transportados por el jugador y para el peso máximo que este puede llevar? Un exámen rápido de las clases existentes muestra que la clase `Game`  es realmente el único lugar donde encajarían esos campos. No podemos almacenarlos en `Room`, `Item` o `Command` porque hay muchos objetos de dichas clases a lo largo del tiempo de ejecución del programa y muchos de ellos no siempre son accesibles. Tampoco tiene ningún sentido incluirlos en `Parser` o en `CommandWords`, que son clases que nada tienen que ver con ellos.

Una razón adicional que apoya la decisión de hacer estos cambios en la clase `Game` es el hecho de que esa clase ya almacena la sala actual en la que está el jugador, por lo que añadir los objetos que lleva y el peso máximo que puede cargar también parece encajar con esto bastante bien.

Esta solución podría funcionar. Sin embargo, no es una solución bien diseñada. La clase `Game` ya es bastante grande y se podría argumentar, con razón, que ya contiene demasiadas cosas. Añadir más elementos no mejora la situación.

Deberíamos preguntarnos de nuevo a qué clase u objeto tendría que pertenecer esta información. Si pensamos despacio en el tipo de información que estamos añadiendo aquí (objetos transportados y peso máximo) nos damos cuenta que se trata de información sobre un jugador. Lo más lógico, siguiendo las directrices del diseño dirigido por responsabilidad, es crear una clase `Player` para representar al jugador. Entonces podremos añadir estos atributos a la clase `Player` y crear un objeto `Player` al principio del juego para almacenar los datos.

El atributo existente `currentRoom` también almacena información acerca del jugador: nos indica cuál es la ubicación actual del mismo. En consecuencia, ahora deberíamos mover también este campo a la clase `Player`.

Al analizar la solución resulta obvio que este diseño encaja mejor con el principio de diseño dirigido por responsabilidad. ¿Quién debería ser responsable de almacenar la información acerca del jugador? Por supuesto, la clase `Player`.

En la versión original, sólo disponíamos de un elemento de información relativo al jugador: la sala en la que estaba. Podría discutirse si aun así hubiéramos debido tener una clase `Player`. Habría razones tanto a favor como en contra. Se habría tratado de un diseño elegante, así que tal vez hubiéramos debido definir esa clase. Por tener una clase con un único atributo y ningún método que haga nada significativo podría considerarse un desperdicio.

En ocasiones, hay áreas de sombra como esta de la que hablamos en las que podría defenderse una decisión o la contraria. Pero después de añadir estos nuevos atributos, la situación es muy clara. Ahora existe un buen argumento en favor de definir una clase `Player`. Esta clase se encargaría de almacenar los atributos de los que hemos hablado y dispondría de métodos como `dropItem` y `pickUpItem` para solar y coger objetos (métodos que podrían incluir la comprobación del peso y devolver _false_ si no podemos transportar ese elemento).

Lo que hemos hecho al introducir la clase `Player` y mover el campo `currentRoom` de `Game` a `Player` es una refactorización. Hemos reestructurado la firma en que representamos nuestros datos, para conseguir un mejor diseño de cara a llevar a cabo una ampliación de funcionalidad.

Los programadores perezosos o con menos experiencia podrían haber dejado el atributo `currentRoom` en `Game` al ver que el programa funciona bien como está y que no parece que haya una necesidad imperiosa de hacer dicha modificación. Como resultado, terminarían teniendo un diseño de clases muy lioso.

Podemos ver el efecto de realizar esta modificación si tratamos de anticiparnos áun más a los acontecimientos. Supón que ahora quisiéramos ampliar el juego permitiendo la existencia de múltiples jugadores en el mismo mapa. Con nuestro nuevo y elegante diseño, esto sería tan sencillo como crear varios objetos `Player` almacenándo en una colección en `Game` dichos objetos. Cada objeto `Player` almacenaría su propia ubicación actual, los objetos que transporta y el peso máximo que es capaz de llevar. Los diferentes jugadores podrían tener cada uno un peso máximo distinto que pueden llevar, abriendo la puerta al concepto, aún más amplio, de poder tener jugadores con capacidades muy distintas.

Sin embargo, el programador perezoso que hubiera dejado `currentRoom` en `Game` ahora tendría un serio problema. Dado que con ese diseño solo se puede almacenar la ubicación actual de un jugador, almacenar las de todos junto con sus objetos y peso máximo permitido supondria hacer 3 colecciones en `Game` (una de objetos `Room`, otra de colecciones de objetos `Item` y otra donde almacenar enteros) que resultarían en un código muy farragoso. Los malos diseños suelen pasarnos factura posteriormente y terminan, a la postre, dándonos más trabajo.

Llevar a cabo una buena refactorización tiene tanto que ver con la capacidad de pensar de una manera determinada como con nuestras habilidades técnicas. Mientras realizamos cambios y ampliaciones en una aplicación, debemos preguntarnos periódicamente si el diseño original de las clases sigue representando la mejor solución. A medida que cambia la funcionalidad, van variando los argumentos a favor o en contra de ciertos diseños. Lo que era un buen diseño para una aplicación que comenzó siendo muy simple, puede dejar de serlo al añadir ciertas funcionalidades.

Reconocer estos cambios y llevar a cabo la refactorización del código suele terminar ahorrando una gran cantidad de tiempo y esfuerzo. Por regla general, cuanto antes limpiemos nuestro diseño, más trabajo nos ahorraremos.

Debemos estar preparados para _desgajar_ métodos (transformar una secuencia de instrucciones del cuerpo de un método existente en nuevo método independiente) y clases (coger partes de una clase y crear una nueva a partir de ellas como hemos hecho aquí). Tomar en consideración de manera periódica la refactorización hace que nuestro diseño de clases siga siendo limpio y nos acaba ahorrando trabajo al final.

Por supuesto, una de las cosas que hará que la refactorización nos complique la vida a largo plazo es que no probemos la versión refactorizada comparándola con la versión original. Cada vez que nos embarquemos en una tarea de refactorización de una cierta envergadura resulta esencual garantizar que se prueben las cosas adecuadamente, antes y después de la refactorización.

> ![](brain.png) **Actividad 08.08.01**: Estando en la rama `master`, crea una nueva rama llamada `refac` en la que vamos a refactorizar nuestro proyecto introduciendo la clase `Player` comentada en esta sección de forma que, de momento solo almacene la ubicación del jugador. Recuerda que estamos refactorizando y, por tanto, la funcionalidad del programa debe ser exatcamente la misma al acabar que la que tenía al empezar. Cuando veas que todo funciona tal y como funcionaba antes, haz un commit y fusiona la rama con `master` (**commit 17**).
>
> Luego implementa en tu aplicación los siguientes cambios a través de una nueva rama llamada `ramaObjetos` y fusiona dicha rama con `master` cuando termines de implementar todos los cambios que se solicitan a continuación(**commit 18**):
>
> 1. Implementa la posibilidad de que el jugador pueda coger objetos incluyendo la comprobación de que no se pasa del peso máximo que puede soportar. Haz un commit dentro de la rama (**commit r01**).
> 2. Implementa la posibilidad de que haya objetos en el juego que no se puedan coger. Haz un commit dentro de la rama (**commit r02**).
> 2. Implementa un comando _items_ que haga que se impriman por pantalla todos los objetos que lleva ahora mismo el jugador, junto con su peso total. Haz un commit dentro de la rama (**commit r03**).
> 3.  Implementa la posibilidad de que el jugador pueda soltar objetos. Haz un commit dentro de la rama (**commit r04**).
> 4. Implementa que el jugador pueda llevar objetos hasta un peso máximo especificado cuando se construye el jugador. El peso máximo que cada jugador puede llevar es un atributo del jugador. Haz un commit dentro de la rama (**commit r05**)
> 5. Implementa la posibilidad de que exista en una sala un objeto _galleta mágica_ . Añade un comando _eat galleta_. Un jugador que encuentre la galleta, la coja y luego invoque el comando indicado incrementará al doble el peso que es capaz de transportar. Si quieres, puedes modificar este ejercicio ligeramente para que encaje mejor con tu juego, pero siempre con la autorización del profesor. Haz un commit dentro de la rama (**commit r06**).
