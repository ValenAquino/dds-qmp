package accuweather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccuWeatherApi {
  public List<Map<String, Object>> getWeather(String ciudad) {
    return List.of(
        new HashMap<>() {
          {
            put("DateTime", "2019-05-03T01:00:00-03:00");
            put("EpochDateTime", 1556856000);
            put("WeatherIcon", 33);
            put("IconPhrase", "Clear");
            put("IsDaylight", false);
            put("PrecipitationProbability", 0);
            put("MobileLink", "https://m.accuweather.com/en/ar/villa-vil/7984/");
            put("Link", "https://www.accuweather.com/en/ar/villa-vil/7984");
            put(
                "Temperature",
                new HashMap<String, Object>() {
                  {
                    put("Value", 57);
                    put("Unit", "F");
                    put("UnitType", 18);
                  }
                });
          }
        });
  }
}