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
