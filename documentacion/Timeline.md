## Timeline en JavaFx

A continuación se exponde un ejemplo de bucle de juego usando la clase `Timeline`:

```

// Game loop usando Timeline con 0.017 como valor de repeticion que nos da 60 FPS
Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.017), event -> {
    // Cosas por hacer en el bucle...
  }));                
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();        
```

Para que funcione, hay que importar las siguientes clases:

```
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
```
