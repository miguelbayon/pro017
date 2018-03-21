### Clonando ramas remotas

Primero tenemos que clonar el repositorio git correspondiente y meternos en su carpeta:

    $ git clone git://example.com/myproject
    $ cd myproject

Luego, miramos las ramas que tenemos en local:

    $ git branch
    * master

Si hubiera alguna rama remota, esta no aparece. Para ver qué ramas hay en remoto tenemos que usar:

    $ git branch -a
    * master
      remotes/origin/HEAD
      remotes/origin/master
      remotes/origin/experimental
  
Si queremos obtener en local la rama `experimental` tendremos que ejecutar:

    $ git checkout experimental

Obteniendo por pantalla:

    Rama 'experimental' configurada para hacer seguimiento a la rama remota 'experimental' de 'origin'.
    Cambiado a nueva rama 'experimental'

Ahora, si miramos las ramas que tenems en local, ya aparecerá nuestra rama `experimental` y podremos trabajar con ella sin problemas:

    $ git branch
    * experimental
      master
