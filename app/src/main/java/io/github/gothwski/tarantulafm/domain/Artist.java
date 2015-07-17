package io.github.gothwski.tarantulafm.domain;

import com.google.gson.annotations.SerializedName;

import io.github.gothwski.tarantulafm.io.model.JsonKeys;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class Artist {

    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;

    String urlMediumImage;
    String urlLargeImage;
    String playcount;
    String listeners;

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public Artist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }
}
