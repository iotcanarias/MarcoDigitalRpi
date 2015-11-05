/*
    MarcoDigitalRpi is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MarcoDigitalRpi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MarcoDigitalRpi. If not, see <http://www.gnu.org/licenses/>.

    Contact: Javier <iotcanarias@gmail.com>
*/
package com.iotcanarias;

import com.iotcanarias.utils.Utils;
import com.pi4j.io.gpio.GpioController;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author raspdroid
 */
public class MarcoDigitalRpi extends Application {
    
    // Ancho y Altura de la pantalla en píxeles
    private static final double ANCHO = 320;
    private static final double ALTO = 240;
    public static double getANCHO() {
        return ANCHO;
    }
    public static double getALTO() {
        return ALTO;
    }

    private static Scene scene;
    public static void setScene(Scene scene) {
        MarcoDigitalRpi.scene = scene;
    }
    private GpioController gpio;
    private final String rutaVideo = "/home/pi/media/videos/mundo_jurasico.mp4";
    private boolean isAlive;
         
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        // Inicia el proceso para fbcp o lo reinicia si ya estaba iniciado.
        Utils.RestartFbcp();
        
        StackPane root = new StackPane();        

        //Animacion1.start(root);
        Animacion2.start(root);
        
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setCursor(Cursor.NONE);
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
        // Controles para los eventos del Ratón o Gestos.
        scene.setOnMouseClicked((MouseEvent event) -> {
            
            if(event.getClickCount()==1 && isAlive==false){
                System.out.println("Clics: " + event.getClickCount());
                primaryStage.hide();
                OMXPlayer omx = new OMXPlayer();
                omx.start(rutaVideo);
                isAlive = true;
            }
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            System.out.println("X: " + event.getX());
            System.out.println("Y: " + event.getY());
        });
        
                
        
//        // Botón que reproduce el vídeo
//        gpio = GpioFactory.getInstance();
//        final GpioPinDigitalInput botonVideo = gpio.provisionDigitalInputPin(RaspiPin.GPIO_26, 
//                PinPullResistance.PULL_DOWN);
//        botonVideo.addListener((GpioPinListenerDigital) (GpioPinDigitalStateChangeEvent gpdsce) -> {
//            System.out.println(" --> GPIO PIN STATE CHANGE: "
//                    + gpdsce.getPin() + " = " + gpdsce.getState());
//            // Inicia el reproductor de vídeo
//            
//        });
    }

    @Override
    public void stop() throws Exception {
        super.stop(); 
//        gpio.shutdown();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}