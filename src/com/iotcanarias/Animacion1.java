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
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author raspdroid
 */
public class Animacion1 {

    // Ancho y Altura de la imagen en píxeles
    private static final double ANCHO_IMG = 320;
    private static final double ALTO_IMG = 240;
    
    private static final int NUM_DE_IMGS = 4; 
    private static final int FREC_SLIDE = 4; // (en segundos)
    
    public static void start(StackPane root) {
        
        Pane clipPane = new Pane();
        // Para centrar el SlideShow
        clipPane.setMaxSize(ANCHO_IMG, ALTO_IMG);
        clipPane.setClip(new Rectangle(ANCHO_IMG, ALTO_IMG));
        
        HBox hbox = new HBox();
        
        
        EventHandler<ActionEvent> slideAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1.5), hbox);
            trans.setByX(-ANCHO_IMG);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        EventHandler<ActionEvent> resetAction = (ActionEvent t) -> {
            TranslateTransition trans = new TranslateTransition(Duration.seconds(1), hbox);
            trans.setByX((NUM_DE_IMGS - 1) * ANCHO_IMG);
            trans.setInterpolator(Interpolator.EASE_BOTH);
            trans.play();
        };

        List<KeyFrame> keyFrames = new ArrayList<>();
        for (int i = 1; i <= NUM_DE_IMGS; i++) {
            if (i == NUM_DE_IMGS) {
                keyFrames.add(new KeyFrame(Duration.seconds(i * FREC_SLIDE), resetAction));
            } else {
                keyFrames.add(new KeyFrame(Duration.seconds(i * FREC_SLIDE), slideAction));
            }
        }
        Timeline timeLine = new Timeline(keyFrames.toArray(new KeyFrame[NUM_DE_IMGS]));

        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.playFromStart();
        
        
        hbox.getChildren().addAll(Utils.getImages());
        clipPane.getChildren().add(hbox);
        root.getChildren().add(clipPane); 
                
        Scene scene = new Scene(root, ANCHO_IMG, ALTO_IMG);
        MarcoDigitalRpi.setScene(scene);
    }   
}
