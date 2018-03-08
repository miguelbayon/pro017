
## Acoplamiento

En estos momentos nuestro juego funciona correctamente: podemos ejecutarlo y hace correctamente todo lo que se pretende que haga. Sin embargo, en algunos aspectos está muy mal diseñado. Hay que tener en cuenta, no obstante, que una alternativa bien diseñada funcionaría exactamente igual, por lo que no podríamos observar ninguna diferencia simplemente ejecutando el programa.

Sin embargo, en cuanto tratamos de hacer modificaciones en el proyecto, experimentaremos diferencias significativas en la cantidad de trabajo requerido para modificar un código mal diseñado si lo comparamos con los cambios realizados en una aplicación con un buen diseño. 

Por ejemplo, cuando hemos añadido la nueva dirección de salida a nuestro juego nos hemos dado cuenta de que hay muchos lugares donde se enumeran todas las salidas. Esto es un síntoma de un diseño de clases muy pobre. Al declarar las variables de salida en la clase `Room`, necesitamos añadir un atributo en esa clase por cada salida; en el método `setExits` hay una instrucción `if` por cada salida; en el método `goRoom` de la clase `Game` hay una instrucción `if` por cada salida; en el método `printLocationInfo` hay una instrucción `if` por cada salida; y así sucesivamente. 

Aquel que tomó la decisión de diseñar así el código provocó que ahora tengamos más trabajo del deseado: al añadir nuevas salidas tenemos que localizar todos esos lugares e incorporar un nuevo caso.

Uno de los principales problemas en el estado actual es que los atributos de la clase `Room` son públicos, ya que están declarados como `public`. El programador que escribió esta clase no ha seguido una de la directrices básicas de la programación orientada a objetos: el **principio de encapsulación**, es decir, no hacer nunca públicos los atributos. La clase `Game`puede acceder directamente a consultar el valor y escribir en esos atributos y, si te fijas en el código, eso es justamente lo que hace en muchos puntos. Al hacer públicos sus atributos, la clase `Room` ha expuesto en su interfaz no solo el hecho de que dispone de salidas, sino también en que forma está almacenada dicha información acerca de las salidas (como atributos individuales). 

El principio de encapsulación sugiere que solo debe hacerse visible para el exterior de una clase la información acerca de _lo que hace una clase_, no la información acerca de _cómo lo hace_. Esto tiene una gran ventaja: si ninguna otra clase sabe cómo está almacenada nuestra información, entonces podemos cambiar fácilmente el modo en que está almacenada sin por ello hacer que otras clases dejen de funcionar.

Podemos obligar a esta separación entre _lo que se hace_ y _cómo se hace_ defininiendo los atributos como privados y untilizando un método getter para acceder a ellos. 
