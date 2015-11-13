### Tipos de datos primitivos

* Números enteros:
  * `byte`: números enteros que ocupan 8 bits (por ejemplo, 24 o -2)
  * `short`: números enteros que ocupan 16 bits (por ejemplo, 137 o -119)
  * `int`: números enteros que ocupan 32 bits (por ejemplo, 5409 o -2003)
  * `long`: números enteros que ocupan 64 bits (por ejemplo, 423266353L o 55L)
* Numeros decimales:
  * `float`: números decimales de precision simple (por ejemplo, 43.889F)
  * `double`: números decimales de doble precisión (por ejemplo, 45.63 o 2.4e5)
* Otros tipos:
  * `boolean`: almacena un valor booleano true o false (por ejemplo, true o false)
  * `char`: almacena un caracter en 16 bits (por ejemplo, 'm' o '?')

#### Notas

Un número sin punto decimal es interpretado como un entero. Java puede convertir enteros automáticamente a un tipo de dato entero más pequeño siempre que quepa en él. Sin embargo, Java no puede convertir automáticamente un entero a un `long`. Por eso puedes poner una L detrás de un número literal para indicar que quieres que sea directamente un `long` en vez de un entero.

Un número escrito con un punto decimal se entiende que es `double`. Puedes especificar que quieres que sea `float` poniendo una `F` después.
