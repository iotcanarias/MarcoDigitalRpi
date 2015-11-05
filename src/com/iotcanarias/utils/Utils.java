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
package com.iotcanarias.utils;

import com.iotcanarias.Animacion1;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author raspdroid
 */
public class Utils {    
    private static List<ImageView> listaIV = null;
    private static List<MediaPlayer> players = null;
    
    private static final String rutaImagenes = "/home/pi/media/imagenes";
    private static final String rutaVideos ="/home/pi/media/videos";
    

    // Obtiene una lista de objetos ImageView 
    // a partir de las imagenes contenidas en el directorio ~/media/imagenes
    public static List<ImageView> getImages() {
            // Directorio que representa las imágenes del SlideShow
            final File dirImagenes = new File(rutaImagenes);
            // Lista de extensiones soportadas
            final List<String> EXTENSIONES_IMAGENES = Arrays.asList("jpg","png","gif","bmp");            
            // Filtro para identificar las imágenes basándose en sus extensiones
            final FilenameFilter FILTRO_IMAGENES = (File dir1, String nombre) -> {
                for (final String ext : EXTENSIONES_IMAGENES) {
                    if(nombre.endsWith("." + ext)) {
                        return(true);
                    }
                }
                return(false);
            };
            listaIV = new ArrayList<>();
            if(dirImagenes.isDirectory()) { // comprueba que sea un directorio.
                for(final File f : dirImagenes.listFiles(FILTRO_IMAGENES)) {
                    Image img = new Image(f.toURI().toString());
                    listaIV.add(new ImageView(img));                    
                }
            }     
            Animacion1.setNUM_DE_IMGS(listaIV.size());
            return listaIV;
        }
    
//    // Obtiene un lista de objetos MediaPlayer
//    // a partir de los videos contenidos en el directorio ~/media/videos
//    public static List<MediaPlayer> getPlayers() {
//            // Directorio que representa los vídeos
//            final File dirVideo = new File(rutaVideos);
//            // Lista de extensiones soportadas
//            final List<String> EXTENSIONES_VIDEOS = Arrays.asList("avi","flv","3gp","mp4");
//            // Filtro para identificar los vídeos basándose en sus extensiones
//            final FilenameFilter FILTRO_VIDEOS = (File dir1, String nombre) -> {
//                for (final String ext : EXTENSIONES_VIDEOS) {
//                    if(nombre.endsWith("." + ext)) {
//                        return(true);
//                    }
//                }
//                return(false);
//            };
//            players = new ArrayList<>();
//            if(dirVideo.isDirectory()) { // comprueba que sea un directorio.
//               for(final File f : dirVideo.listFiles(FILTRO_VIDEOS)) {
//                   players.add(newPlayer("file:///" + ("\\" + f).replace("\\", "/").replaceAll(" ", "%20")));
//                   }
//            }           
//            // Añade una marca para la unión al primer player.
//            players.get(0).getMedia().getMarkers().put("Une", Duration.millis(2500));
//            // Añade una marca para la división al último player.
//            if(players.size()>1){
//                players.get(players.size()-1).getMedia().getMarkers().put("Divide", Duration.millis(10000));
//            } else {
//                players.get(0).getMedia().getMarkers().put("Divide", Duration.millis(1000));
//            }
//            return players;
//        }
//
//    private static MediaPlayer newPlayer(String mediaSource) {
//    final Media media = new Media(mediaSource);
//    final MediaPlayer player = new MediaPlayer(media);
//    player.setOnError(() -> {
//        System.out.println("Error creando el MediaPlayer: " + player.getError());
//    });
//    return player;
//  }
//    }

    

    
        public static String getOS() {
         String os = System.getProperty("os.name");
            
        return os;
        }

        
        public static String getArch() {
         String arch = System.getProperty("os.arch");
            
        return arch;
        }

    public static void RestartFbcp() {
        Process p1;
        Process p2;
        ProcessBuilder pb1 = new ProcessBuilder("bash", "-c", "killall fbcp ");
        ProcessBuilder pb2 = new ProcessBuilder("bash", "-c", "fbcp &");
        try {
            p1= pb1.start();
            p1.waitFor();
            p2= pb2.start();
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        




}

