## Acoplamiento, cohesión y repetición de código

### Acoplamiento y cohesión

Si queremos justificar la afirmación de que unos diseños son mejores que otros, entonces tenemos que definiri algunos términos que nos permitan analizar los aspectos que consideramos importantes en el diseño de clases. Hay dos términos que son fundamentales a la hora de hablar de la calidad de un diseño de clase: el _acoplamiento_ y la _cohesión_.

El término _acoplamiento_ hace referencia al grado de interconexión de las clases. Siempre buscamos diseñar una aplicación con un conjunto de clases en cooperación que se comunican a través de interfaces bien definidas. El gradod e acoplamiento indica lo estrechamente conectadas que están las clases. Lo que buscamos es un grado bajo de acoplamiento (acoplamiento débil).

El grado de acoplamiento determina lo difícil que es realizar cambios en una aplicación. En una estructura de clases estrechamente acoplada, un cambio en una clase puede hacer necesario introducir cambios en otras clases. Esto es precisamente lo que tratamos de evitar: no queremos que el efecto de un pequeño cambio en un punto de la aplicación suponga una propagación en cascada de cambios por todo el resto de la aplicación. Además, localizar todos los lugares donde es necesario hacer cambios y llevar a la práctica esos cambios puede resultar difícil y requerir mucho tiempo.

En un sistema débilmente acoplado, por el contrario, podemos cambiar el interior de una clase (la implementación) sin efectuar ningún cambio en las clases restantes, y la aplicación seguirá funcionando correctamente.

El término _cohesión_ se relaciona con el número y la diversidad de tareas de las que es responsable cada unidad de la aplicación. La cohesión se aplica tanto a clases como a métodos individuales.

Idealmente, cada unidad de código debe ser responsable de una tarea coherente, es decir, de una tarea que pueda ser vista como una unidad lógica. Cada método debería implementar una operación lógica y cada clase debería representar un tipo de entidad. La principal razón que subyace al principio de cohesión es la reutilización: si un método o clase es reponsable de un única cosa bien definida, entonces es mucho más probable que pueda utilizarse de nuevo en un contxto distinto. Una ventaja complementaria de adherirse a este principio es que, cuando haga falta realizar modificaciones en algún aspecto de la aplicación, es probable que encontremos todas las piezas relevantes dentro de una misma unidad.

En un sistema altamente cohesionado, cada unidad de código (ya sea una clase o un método) es responsable de una tarea o entidad bien definidas. Un buen diseño de clases exhibe un alto grado de cohesión.



### Repetición de código

La repetición de código es un indicador de un mal diseño. El problema con la duplicación de código es que cualquier modificación en una parte debe ser realizada también en la otra parte del código repetido si queremos evitar incoherencias. Esto incrementa la cantidad de trabajo que el programador de mantenimiento tiene que realizar e introduce el peligro de que aparezcan nuevos errores. Puede suceder muy fácilmente que un programador de mantenimiento encuentre una copia de código y, habiéndola modificado, suponga que ha terminado su trabajo. No hay nada que indique que existe una segunda copia del código y esas egunda copia podría permanecer, incorrectamente, sin modificaciones.

La clase `Game` de "World of Zuul" contiene un caso de duplicación de código. Tanto el método `printWelcome` como el método `goRoom` contienen quince líneas de código exactamente iguales. El problema aquí tiene su raíz en el hecho de que ambos métodos hacen dos cosas (es decir, tienen una baja cohesión): `printWelcome` imprime el mensaje de bienvenida y la información acerca de la ubicación actual mientras que `goRoom` cambia la ubicación actual y luego imprime la información acerca de la nueva ubicación actual.

Ambos métodos imprimen información sobre la ubicación actual, pero ninguno de ellos puede invocar al otro para evitar la duplicidad de código porque, además, hacen otras cosas. Este es un ejemplo de mal diseño.

Un diseño mejor utilizaría un método separado mas cohesionado, cuya única tarea sea la de imprimir la información acerca de la ubicación actual de forma que tanto el método `printWelcome` como el método `goRoom` pudieran invocar a ese método cada vez que necesiten imprimir la información de la ubicación actual. De esta forma, evitamos escribir el código dos veces y, cuando necesitemos modificarlo, solo tendremos que cambiarlo una vez.
