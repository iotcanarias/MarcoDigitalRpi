///*
// * This file is part of MarcoDigitalRpi.
//
//    MarcoDigitalRpi is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    MarcoDigitalRpi is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with MarcoDigitalRpi.  If not, see <http://www.gnu.org/licenses/>.
//
//    Contact: Javier <iotcanarias@gmail.com>
// */
//package com.iotcanarias;
//
//import com.iotcanarias.utils.Utils;
//import java.util.List;
//import javafx.animation.ParallelTransition;
//import javafx.animation.ParallelTransitionBuilder;
//import javafx.animation.TranslateTransitionBuilder;
//import javafx.application.Platform;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.geometry.Rectangle2D;
//import javafx.scene.Node;
//import javafx.scene.layout.StackPane;
//import javafx.scene.media.MediaMarkerEvent;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import javafx.util.Duration;
//
///**
// *
// * @author raspdroid
// */
//public class VideoPlayer {
//    private static double ANCHO;
//    private static double ALTO;
//    private List<MediaPlayer> players;
//    private MediaPlayer player;
//    private final StackPane root;
//    private boolean playing;
//
//    VideoPlayer(StackPane root) {
//        this.root = root;
//    }
//    
//public void start(){
//
//    players = Utils.getPlayers();
//    player = players.get(0);
//    
//    final MediaView mvLeft = new MediaView(player);
//    mvLeft.setViewport(new Rectangle2D(0, 0, ANCHO / 2, ALTO));
//    StackPane.setAlignment(mvLeft, Pos.CENTER_LEFT);
//    
//    final MediaView mvRight = new MediaView(player);
//      mvRight.setViewport(new Rectangle2D(ANCHO / 2, 0, ANCHO / 2, ALTO));
//    StackPane.setAlignment(mvRight, Pos.CENTER_RIGHT);
//    player.play();
//    
////    for (int i = 0; i < players.size();i++){
////        player = players.get(i);
////        final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
////        player.setOnEndOfMedia(new Runnable() {
////            @Override
////            public void run() {
////                player.stop();
////                mvLeft.setMediaPlayer(nextPlayer);
////                mvRight.setMediaPlayer(nextPlayer);
////                nextPlayer.play();
////            }
////        });
////    }
//    
//    
//    root.getChildren().addAll(mvLeft, mvRight);
//
//
//    
//    player.setOnMarker(new EventHandler<MediaMarkerEvent>() {
//        @Override
//        public void handle(MediaMarkerEvent event) {
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    if(event.getMarker().equals("Une")){
//                        animUnion(mvLeft, mvRight).play();
//                    } else {
//                        animDivide(mvLeft, mvRight).play();
//                    }
//                }
//            });
//        }
//    });
//}
//
// private ParallelTransition animUnion(Node mvLeft, Node mvRight) {
//    return ParallelTransitionBuilder.create().children(
//              TranslateTransitionBuilder.create().
//              duration(Duration.millis(1000)).
//              node(mvLeft).
//              byX(200).build(),
//              TranslateTransitionBuilder.create().
//              duration(Duration.millis(1000)).
//              node(mvRight).
//              byX(-200).build()).
//            build();
//  }
// 
//  private ParallelTransition animDivide(Node mvLeft, Node mvRight) {
//    return ParallelTransitionBuilder.create().children(
//              TranslateTransitionBuilder.create().
//              duration(Duration.millis(1000)).
//              node(mvLeft).
//              byX(-200).build(),
//              TranslateTransitionBuilder.create().
//              duration(Duration.millis(1000)).
//              node(mvRight).
//              byX(200).build()).
//            build();
//  }
//}
