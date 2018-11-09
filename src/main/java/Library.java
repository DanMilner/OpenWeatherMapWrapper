import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
    private OkHttpClient client;
    private String apiKey = "53d4ced445dc683d104322a4c8fdb9fc";

    public Library() {
        client = new OkHttpClient();
    }

    private void printResponse(Request request) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean getWeatherByCityName(String city, String countryCode) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("q", city + "," + countryCode);
        urlBuilder.addQueryParameter("APPID", apiKey);
        String url = urlBuilder.build().toString();
        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        printResponse(request);
        return true;
    }

    public boolean getWeatherByCoordinates(String lat, String lon) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("lat", lat);
        urlBuilder.addQueryParameter("lon", lon);
        urlBuilder.addQueryParameter("APPID", apiKey);
        String url = urlBuilder.build().toString();
        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        printResponse(request);
        return true;
    }

    public boolean getWeatherByZip(String zip, String countryCode) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("zip", zip + "," + countryCode);
        urlBuilder.addQueryParameter("APPID", apiKey);
        String url = urlBuilder.build().toString();
        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        printResponse(request);
        return true;
    }
}
