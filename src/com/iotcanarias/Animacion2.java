/*
 * This file is part of MarcoDigitalRpi.

    MarcoDigitalRpi is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MarcoDigitalRpi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.

    Contact: Javier <iotcanarias@gmail.com>
 */
package com.iotcanarias;

import com.iotcanarias.utils.Utils;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author raspdroid
 */
public class Animacion2 {
    
     // Ancho y Altura de la imagen en píxeles
    private static final double ANCHO_IMG = 320;
    private static final double ALTO_IMG = 240;
    
    private static final int DUR_ENTRADA = 2000;
    private static final int DUR_SALIDA = 2000;
    private static final int FREC_SLIDE = 4; // (en segundos)
    
     public static void start(StackPane root) {
        SequentialTransition slideshow = new SequentialTransition();

         Utils.getImages().stream().forEach((slide) -> {
          SequentialTransition sequentialTransition = new SequentialTransition();
          
          FadeTransition fadeIn = getFadeTransition(slide, 0.0, 1.0, DUR_ENTRADA);
          PauseTransition stayOn = new PauseTransition(Duration.seconds(FREC_SLIDE));
          FadeTransition fadeOut = getFadeTransition(slide, 1.0, 0.0, DUR_SALIDA);
          
          sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);
          slide.setOpacity(0);
          root.getChildren().add(slide);
          slideshow.getChildren().add(sequentialTransition);
        });
      slideshow.setCycleCount(Timeline.INDEFINITE);
      slideshow.playFromStart();
      
      Scene scene = new Scene(root, ANCHO_IMG, ALTO_IMG);
      MarcoDigitalRpi.setScene(scene);
    }


    public static FadeTransition getFadeTransition(ImageView imageView, double fromValue, double toValue, int durationInMilliseconds) {
    
      FadeTransition ft = new FadeTransition(Duration.millis(durationInMilliseconds), imageView);
      ft.setFromValue(fromValue);
      ft.setToValue(toValue);

      return ft;
      
    }
}