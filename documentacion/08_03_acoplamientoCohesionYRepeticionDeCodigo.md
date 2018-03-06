## Acoplamiento, cohesión y repetición de código

### Acoplamiento y cohesión

Si queremos justificar la afirmación de que unos diseños son mejores que otros, entonces tenemos que definiri algunos términos que nos permitan analizar los aspectos que consideramos importantes en el diseño de clases. Hay dos términos que son fundamentales a la hora de hablar de la calidad de un diseño de clase: el _acoplamiento_ y la _cohesión_.



### Repetición de código

La repetición de código es un indicador de un mal diseño. El problema con la duplicación de código es que cualquier modificación en una parte debe ser realizada también en la otra parte del código repetido si queremos evitar incoherencias. Esto incrementa la cantidad de trabajo que el programador de mantenimiento tiene que realizar e introduce el peligro de que aparezcan nuevos errores. Puede suceder muy fácilmente que un programador de mantenimiento encuentre una copia de código y, habiéndola modificado, suponga que ha terminado su trabajo. No hay nada que indique que existe una segunda copia del código y esas egunda copia podría permanecer, incorrectamente, sin modificaciones.

La clase `Game` de "World of Zuul" contiene un caso de duplicación de código. Tanto el método `printWelcome` como el método `goRoom` contienen quince líneas de código exactamente iguales. El problema aquí tiene su raíz en el hecho de que ambos métodos hacen dos cosas (es decir, tienen una baja cohesión): `printWelcome` imprime el mensaje de bienvenida y la información acerca de la ubicación actual mientras que `goRoom` cambia la ubicación actual y luego imprime la información acerca de la nueva ubicación actual.

Ambos métodos imprimen información sobre la ubicación actual, pero ninguno de ellos puede invocar al otro para evitar la duplicidad de código porque, además, hacen otras cosas. Este es un ejemplo de mal diseño.

Un diseño mejor utilizaría un método separado mas cohesionado, cuya única tarea sea la de imprimir la información acerca de la ubicación actual de forma que tanto el método `printWelcome` como el método `goRoom` pudieran invocar a ese método cada vez que necesiten imprimir la información de la ubicación actual. De esta forma, evitamos escribir el código dos veces y, cuando necesitemos modificarlo, solo tendremos que cambiarlo una vez.
