package com.stan.springbootcourse.corejava.part3.completablefutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PlayListDemo {
    public static String getEmail(String id) {
        return "omejechidozie@gmail.com";
    }

    public static List<PlayList> getPlayLists(String email) {
        List<PlayList> playLists = new ArrayList<>();
        PlayList playlist1 = new PlayList(1, "Boys2Men", "On bended Knee");
        PlayList playlist2 = new PlayList(2, "Tupac", "Hit them up");
        PlayList playlist3 = new PlayList(3, "RKelly", "I believe I can fly");
        PlayList playlist4 = new PlayList(4, "Asake", "Terminator");
        PlayList playlist5 = new PlayList(5, "Olamide", "Boju");
        playLists.add(playlist1);
        playLists.add(playlist2);
        playLists.add(playlist3);
        playLists.add(playlist4);
        playLists.add(playlist5);
        return playLists;
    }

    public static CompletableFuture<String> getEmailAsync(String id){
        return CompletableFuture.supplyAsync(()->getEmail(id));
    }

    public static CompletableFuture<List<PlayList>> getPlayListsAsync(String email) {
        return CompletableFuture.supplyAsync(()->getPlayLists(email));
    }

    public static void show(){
        getEmailAsync("12")
            .thenCompose(PlayListDemo::getPlayListsAsync)
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        PlayListDemo playListDemo = new PlayListDemo();
        System.out.println();
        System.out.println(playListDemo.getPlayLists("omejechidozie@gmail.com"));

        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        show();
        System.out.println();
    }
}
