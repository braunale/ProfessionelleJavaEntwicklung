package de.hs.albsig.braunal;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

/**
* Class that retrieves the weather data from the api.
*
* @author Alexander Braun
*
*/
public final class WeatherRetriever {
/**
* Logger to display and save important informations.
*/
private static Logger log = Logger.getLogger(WeatherRetriever.class);

/**
*
* @param town = Name of the town for which the
* weather is requested
* @return inputStream that contains the weather data
* @throws Exception if the url could not be accessed
*/
    public InputStream retrieve(final String town) throws Exception {
        log.info("Retrieving Weather Data for town " + town);
        String url = "https://query.yahooapis.com/v1/public/yql?q=select"
         + "%20*%20from%20weather.forecast%20where%20woeid%20in%20"
         + "(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"
         + town + "%22)%20AND%20u%3D'c'&format=xml&env=store%3A%2F%2"
         + "Fdatatables.org%2Falltableswithkeys";
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
