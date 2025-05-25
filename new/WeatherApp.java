
package farhans.weatherconsolapp;

import org.json.JSONObject;

public class WeatherApp extends BaseWeatherApp {

    public String getWeatherAsString(String city, String country) {
        String jsonResponse = getWeatherData(city, country);

        try {
            JSONObject obj = new JSONObject(jsonResponse);
            String cityName = obj.getString("name");
            double temperature = obj.getJSONObject("main").getDouble("temp");
            String weatherCondition = obj.getJSONArray("weather").getJSONObject(0).getString("description");

            return "Weather in " + cityName + ", " + country + ":\n" +
                   "Temperature: " + temperature + "°C\n" +
                   "Condition: " + weatherCondition;

        } catch (Exception e) {
            return "Invalid city/country or API error.";
        }
    }

    // For console use
    public void displayWeather(String city, String country) {
        System.out.println(getWeatherAsString(city, country));
    }
}
