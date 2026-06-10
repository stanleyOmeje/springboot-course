package com.stan.springbootcourse.corejava.part3.completablefutures;

import lombok.Data;

@Data
public class PlayList {
    private long playlistId;
    private String playlistName;
    private String playlistTitle;

    public PlayList(long playlistId, String playlistName, String playlistTitle) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.playlistTitle = playlistTitle;
    }
}
