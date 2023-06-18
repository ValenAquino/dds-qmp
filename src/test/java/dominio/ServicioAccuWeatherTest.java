package dominio;

import accuweather.AccuWeatherApi;
import dominio.clima.Clima;
import dominio.clima.ServicioAccuWeather;
import dominio.clima.Temperatura;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServicioAccuWeatherTest {
  @Test
  public void elServicioMeDiceElClimaDeUnaCiudad() {
    AccuWeatherApi api = new AccuWeatherApi();
    String ciudad = "Buenos Aires";
    Duration tiempoDeValidez = Duration.ofSeconds(0);
    ServicioAccuWeather servicioAccuWeather = new ServicioAccuWeather(api, ciudad, tiempoDeValidez);

    Clima clima = servicioAccuWeather.getClima("Buenos Aires, Argentina");

    Assertions.assertEquals(Temperatura.CALOR, clima.getTemperatura());
    Assertions.assertEquals(0, clima.getPrecipitacion());
  }
}
