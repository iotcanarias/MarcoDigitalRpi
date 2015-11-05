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
    along with MarcoDigitalRpi.  If not, see <http://www.gnu.org/licenses/>.

    Contact: Javier <iotcanarias@gmail.com>
 */
package com.iotcanarias;

import com.iotcanarias.utils.Utils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raspdroid
 */
public class OMXPlayer {

    private Process process;
    private ProcessBuilder pb;

    public Process getProcess() {
        return process;
    }
    
    public void start(String rutaVideo) {

        if("Linux".equals(Utils.getOS()) && !"arm".equals(Utils.getArch())){
            pb = new ProcessBuilder("bash", "-c", "/usr/bin/mplayer -noidle -fs  " + rutaVideo);
        } else if("Linux".equals(Utils.getOS()) && "arm".equals(Utils.getArch())){
            pb = new ProcessBuilder("bash", "-c", "omxplayer -r  " + rutaVideo);
        }
            try {
                    process = pb.start();
                    System.out.println("Proceso para el vídeo iniciado.");
                try {
                    System.out.println("Esperando por el proceso");
                    process.waitFor();
                    if(!process.isAlive()) {
                        process.destroy();
                        System.out.println("Proceso destruido.");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(OMXPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(MarcoDigitalRpi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
