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

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;

/**
 *
 * @author raspdroid
 */
public class Utils {    
    private static List<ImageView> listaIV;
    private static List<MediaView> listaMV;
    
    private static final String rutaImagenes = "/home/pi/media/imagenes";
    private static final String rutaVideos ="/home/pi/media/videos";
    

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
            return listaIV;
        }
        
    
    
    public List<MediaView> getVideos() {
            // Directorio que representa los vídeos
            final File dirVideo = new File(rutaVideos);
            // Lista de extensiones soportadas
            final List<String> EXTENSIONES_VIDEOS = Arrays.asList("avi","flv","3gp","mp4");
            // Filtro para identificar los vídeos basándose en sus extensiones
            final FilenameFilter FILTRO_VIDEOS = (File dir1, String nombre) -> {
                for (final String ext : EXTENSIONES_VIDEOS) {
                    if(nombre.endsWith("." + ext)) {
                        return(true);
                    }
                }
                return(false);
            };
            listaMV = new ArrayList<>();
            if(dirVideo.isDirectory()) { // comprueba que sea un directorio.
               for(final File f : dirVideo.listFiles(FILTRO_VIDEOS)) {
                   //Image img = new Image(f.toURI().toString());
                   //listaMV.add(new ImageView(img));                    
               }
            }            
            return listaMV;
        }
    }

    

