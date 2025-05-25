package farhans.weatherconsolapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseWeatherApp {
    protected String apiKey = "237f8273539d702c7c53319fd144ef73";

    protected String getWeatherData(String city, String country) {
        try {
            // Replace spaces with + for URL encoding
            city = city.replace(" ", "+");
            country = country.replace(" ", "+");
            String location = city + "," + country;

            String requestUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&units=metric";

            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
