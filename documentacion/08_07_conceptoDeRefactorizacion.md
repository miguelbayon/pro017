### Concepto de refactorización

Al diseñar aplicaciones debemos tratar de planificar por adelantado, anticipando los posibles cambios que puedan realizarse en el futuro y creando clases y método altamente cohesionados y débilmente acoplados para facilitar las futuras modificaciones. Aunque este debe ser siempre nuestro objetivo no siempre podremos anticipar todas las futuras ampliaciones a acometer en nuestro programa y tampoco es factible prepararse para todos los posibles cambios a un programa que podamos imaginar. 

Y por este motivo, aparece el concepto de _refactorización_. La refactorización es la actividad consistente en reestructurar las clases y métodos existentes sin cambiar la funcionalidad que tenemos para estar en un punto de partida más adecuado para llevar a cabo una ampliación.

A menudo, a lo largo del tiempo de vida de una aplicación, el programador suele ir añadiendo gradualmente funcionalidades. Un efecto de esto es que la longitud de los métodos y de las clases va creciendo poco a poco. Resulta tentador para el programador que modifica el programa añadir código adicional a las clases y métodos existentes, tal y como hemos hecho hasta ahora. Sin embargo, si seguimos haciendo esto durante un cierto tiempo, el grado de cohesión de clases y métodos se reducirá. Cuando se añade más y más código a un método o a una clase, es probable que llegue un momento en el que ese método o esa clase representen más d euna tarea o entidad claramente definida.

La refactorización consiste en repensar y rediseñar las estructuras de las clases y métodos. El efecto más común es que las clases se dividan en dos o que los métodos se dividan en dos o más métodos. La refactorización puede incluir también la unión de varias clases o métodos en uno, aunque esto suele ser bastante menos común que la división.

Antes de proporcionar un ejemplo de refactorización, tenemos que reflexionar sobre el hecho de que, al refactorizar un programa, estamos proponiendo normalmente realizar cambios potencialmente grande a algo que ya funciona correctamente. Y ya se sabe que cuando se modifica algo que funciona, hay una cierta probabilidad de que se introduzcan errores (de ahí el dicho informático de "si funciona, ¡no lo toques!). Por tanto, es muy importante actuar con mucha cautela y, antes de refactorizar, asegurarnos de que exista un conjunto de pruebas para el estado actual del programa. 

Si esas pruebas no existen, entonces antes de refactorizar debemos decidir cómo se puede probar la funcionalidad actual del programa y debemos dejar constancia por escrito de dichas pruebas (por ejemplo, anotándolas por escrito) para que luego, al terminar de refactorizar podamos repetir esas mismas pruebas y comprobar que los cambios han dejado el programa con la misma funcionalidad. Estas pruebas pueden ser automáticas o manuales, pero en cualquier caso han de estar documentadas.

Una vez decidido el conjunto de pruebas, podemos empezar a refactorizar. Al refactorizar vamos a mejorar la estructura interna del código sin realizar ningún cambio en la funcionalidad de la aplicación. En otras palabras, el programa debería de comportarse, al ejecutarse, de la misma forma exacta que antes. Una vez completada la refactorización habrá que repetir las pruebas documentadas previamente para verificar que no hemos introducido errores sin darnos cuenta.

Posteriormente a la refactorización se suele llevar a cabo una ampliación del programa (de hecho, por eso refactorizamos primero, para que nos resulte más sencillo llevar a cabo dicha ampliación). Una vez que hayamos modificado la funcionalidad de nuestro programa deberemos, evidentemente, de realizar nuevas pruebas con la nueva versión.

Si estas dos etapas descritas en los dos párrafos anteriores las llevamos a cabo a la vez (refactorizar y añadir nuevas características) corremos el riesgo de que sea muy difícil localizar el origen de los errores en caso de que aparezcan.

Para ilustrar el concepto de refactorización vamos a continuar añadiendo funcionalidad a nuestro juego. Ahora mismo el juego ya cuenta con la posibilidad de que en cada sala haya un número ilimitado de objetos. Una ampliación lógica consiste en que el jugador pueda coger esos objetos y transportarlos. En concreto, nuestro objetivo va a ser que:

* El jugador pueda coger objetos de la sala en la que se encuentre.
* El jugador pueda transportar cualquier número de objetos, pero solo hasta un cierto peso máximo.
* Algunos objetos no puedan cogerse.
* El jugador pueda soltar objetos en la sala actual.

> ![](brain.png) **Actividad 08.07.01**: Implementa en tu aplicación directamente los 4 cambios indicandos sin hacer ningún tipo de refactorización. Debes incluir tres nuevos comandos al juego denominados `take`, `drop` e `items` para coger objetos, soltar objetos y para que nos muestre la información sobre todos los objetos que el jugador lleva consigo respectivamente. 
> 
> **Muy importante**: 
> * No está permitido añadir nuevas clases.
> * Antes de empezar con los cambios debes crear una rama con el nombre `cogersoltar` y, todos los cambios, debes hacerlos en dicha rama. En ningún caso debes fusionar esta rama con la rama `master`. Una vez que compruebes que el programa se comporta como deseamos, haz un commit (**commit 16**) y sube a Github la nueva rama.

> ![](brain.png) **Actividad 08.07.02**: ¿Qué es lo que más te ha costado implementar del ejercicio anterior? ¿Qué decisiones has tomado al ir programando que no te convecen del todo de cara a un buen diseño?
