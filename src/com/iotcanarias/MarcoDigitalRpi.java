/*
This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    Contact: Javier <iotcanarias@gmail.com>
*/
package com.iotcanarias;

import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author raspdroid
 */
public class MarcoDigitalRpi extends Application {

    private static Scene scene;

    public static void setScene(Scene scene) {
        MarcoDigitalRpi.scene = scene;
    }
         
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        StackPane root = new StackPane();        
        
        //Animacion1.start(root);
        Animacion2.start(root);
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
        // Controla los eventos del Ratón o Gestos.
        scene.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Clics: " + event.getClickCount());
            if(event.getClickCount()==2){
                // Muestra y Reproduce un vídeo
                
            }else if(event.getClickCount()==1){
                // Muestra efecto Ripple
                
            }
        });
        scene.setOnTouchPressed((TouchEvent event) -> {
            System.out.println("Toques: " + event.getTouchCount());
            if(event.getTouchCount()==1){
                // Muestra efecto Ripple
                
            }
        });
        scene.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getEventType());
            }
        });
        scene.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getEventType());
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}