package io.github.gothwski.tarantulafm.io;

/**
 * Created by ariana gothwski on 8/07/15.
 */
public class ApiConstants {

    public static final String API_KEY = "4a857e31547173301d188dd8b145e503";
    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_METHOD = "method";
    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_FORMAT = "format";

    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.gethypedartists";
    public static final String VALUE_TOP_ARTIST_METHOD = "chart.gettopartists";
    public static final String VALUE_JSON = "json";

    //http://ws.audioscrobbler.com/2.0/?method=chart.gethypedartists&api_key=4a857e31547173301d188dd8b145e503&format=json
    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "?" + PARAM_METHOD + "="
                                                    + VALUE_HYPED_ARTIST_METHOD + "&" + PARAM_API_KEY
                                                    + "=" + API_KEY + "&" + PARAM_FORMAT + "=" + VALUE_JSON;

    //http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=4a857e31547173301d188dd8b145e503&format=json
    public static final String URL_TOP_ARTIST = PATH_VERSION + "?" + PARAM_METHOD + "="
                                                    + VALUE_TOP_ARTIST_METHOD + "&" + PARAM_API_KEY
                                                    + "=" + API_KEY + "&" + PARAM_FORMAT + "=" + VALUE_JSON;
}
