package io.github.gothwski.tarantulafm.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.github.gothwski.tarantulafm.domain.Artist;
import io.github.gothwski.tarantulafm.io.model.HypedArtistsResponse;
import io.github.gothwski.tarantulafm.io.model.JsonKeys;

/**
 * Created by ariana gothwski on 11/07/15.
 */
public class MyHypedArtistDeserializer implements JsonDeserializer<HypedArtistsResponse> {
    @Override
    public HypedArtistsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        HypedArtistsResponse response = gson.fromJson(json, HypedArtistsResponse.class);

        //Obtener el objeto artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTIST_RESULTS);
        //Otner el array de artist
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTIST_ARRAY);

        //Converir el jsonArray de artist a objetos de la clase Artist
        response.setArtist(obtainArtistFromJsonArray(artistArray));

        return response;
    }

    private ArrayList<Artist> obtainArtistFromJsonArray(JsonArray array) {
        ArrayList<Artist> artist = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();
            //Ontener el nombre
            String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();
            //Obtener las imagenes
            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGE);
            String[] images = obtainArtistImagesFromJsonArray(imagesArray);

            //Artista con toda la info seteada
            currentArtist.setName(name);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artist.add(currentArtist);
        }

        return artist;
    }

    private String[] obtainArtistImagesFromJsonArray(JsonArray imagesArray) {
        String[] images = new String[2];

        for (int i = 0; i < imagesArray.size(); i++) {
            JsonObject imageData = imagesArray.get(i).getAsJsonObject();

            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();

            url = url.replaceAll("\\/", "/");

            if (url.isEmpty())
                url = null;

            else if (size.matches(JsonKeys.IMAGE_MEDIUM)) {
                images[0] = url;

            } else if (size.matches(JsonKeys.IMAGE_LARGE)) {
                images[1] = url;
            }
        }

        return images;
    }
}
