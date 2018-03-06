## Introducción al diseño de clases

Vamos a analizar algunos de los factores que influyen sobre el diseño de una clase. ¿Qué hace que un diseño de una clase sea bueno o malo? Escribir ckases adecuadamente puede requerir más esfuerzo a corto plazo que escribirlas incorrectamente, pero a largo plazo ese esfuerzo adicional se verá recompensado. 

Para ayudarnos a escribir clases de manera adecuada podemos aplicar algunos principios. En particular, presentaremos el punto de vista de que el diseño de clases debe estar dirigo por el concepto de responsabilidad y que las clases deben encapsular los datos correspondientes.

Se puede perfectamente implementar una aplicación y hacer que lleve a cabo su tarea con una serie de clases mal diseñadas. El ejecutar una aplicación terminada no suele indicar nada acerca de si está bien estructurada internamente o no.

Los problemas suelen aflorar cuando un programador de mantenimiento quiere hacer más tarde algunas modificaciones en una aplicación existente. Por ejemplo, si un programador trata de corregir un error o quiere añadir una nueva funcionalidad a un programa existente, una tarea que podría resultar muy fácil e inmediata con una serie de clases bien diseñadas puede resultar enormemente complicada y requerir una gran cantidad de trabajo si las clases están mal diseñadas.

En aplicaciones de gran tamaño, estos efectos aparecen en una etapa temprana, durante la implementación original. Si la implementación comienza con una mala estructura, entonces finalizarla puede llegar a resultar tremendamente complejo, y el programa completo puede no terminarse, o contener errores, o bien requerir mucho más tiempo para su desarrollo de lo que sería necesario. En el mundo real, las empresas suelen mantener, ampliar y comercializar una aplicación a lo largo de muchos años. No es infrecuente que una implementación de un paquete de software que podemos adquirir hoy en día haya sido iniciada hace más de diez años. En esta situación, una empresa de software no puede permitirse disponer un código mal estructurado.

Muchos de los efectos de un mal diseño de clases se hacen especialmente obvios al tratar de adaptar o ampliar una aplicación, que es justamente lo que vamos a hacer nosotros. A partir de ahora vamos  a utilizar un ejemplo denominado "World of zuul", que es una implementación simple y muy rudimentaria de un juego de aventuras basado en texto. En su estado original, el juego no es realmente muy ambicioso, entre otras cosas porque está incompleto. Sin embargo, al final de nuestro trabajo con la aplicación estaremos en disposición de implementar un juego divertido e interesante.

"World of zuul" está modelado según el juego original que desarrolló a principios de la decada de 1970 Will Crowther y que, posteriormente, fue ampliado por Don Woods. El juego original se conoce también en ocasiones con el nombre de _Colossal Cave Adventure_. Era un juego tremendamente imaginativo y sofisticado para su época, requiriendo que el jugador encontrar el camino a través de un complejo sistema de cuevas, localizando tesoros ocultos y utilizando palabras secretas y otros misterios, todo ello con el objetivo de conseguir el máximo número de puntos.

Mientras trabajamos en la ampliación de la aplicación original aproovecharemos para explicar algunos aspectos del diseño de clases que presenta. Veremos que el código con el que empezamos contiene ejemplos de un mal diseño y podremos comprobar cómo afecta esto a nuestras tareas de mejora y cómo ir corrigiendo dicho diseño.

### Actividad

1. Haz un fork del proyecto `zuul-bad` de mi página de GitHub en tu cuenta. Luego clóna tu respositorio en tu equipo local y ábrelo con BlueJ.

2. Este proyecto es un [framework](https://es.wikipedia.org/wiki/Framework) básico para un juego de aventuras. En esta versión solo disponemos de una serie de habitaciones y de la posibilidad de que el jugador se desplace andando entre ellas. Para iniciar la aplicación crea un objeto de la clase `Game` e invoca su método `play`. Explora el funcionamiento de la aplicación de manera que seas capaz de responder a las siguientes preguntas:

    - ¿Qué comandos acepta el juego en este momento?

    - ¿Qué hace cada comando?

    - ¿Cuántas habitaciones hay en el juego?

7. Este proyecto contiene en su nombre la palabra `bad` porque en la implementación de las clases se han cometido varios errores de diseño. No obstante, intenta descubrir para que sirve cada clase mirando en el código fuente de cada una de ellas. Probablemente no comprenderás todas las líneas del código fuente pero aún así deberías ser capaz de entender el propósito de las clases ya que, a menudo, leyendo los comentarios y las cabeceras de los métodos basta para hacerse una idea. De hecho, en este proyecto, aunque las clases están mal diseñadas, la documentación de las mismas es correcta, lo que pone de manifiesto que un buen o mal diseño no depende de como se vea el código de una clase.

6. Dibuja en formato digital un mapa con las habitaciones existentes en este momento en el juego.
