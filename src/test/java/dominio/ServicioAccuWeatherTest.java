package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import accuweather.AccuWeatherApi;
import dominio.clima.Clima;
import dominio.clima.ServicioAccuWeather;
import dominio.clima.Temperatura;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll; 
import org.junit.jupiter.api.Test;

class ServicioAccuWeatherTest {
  private static AccuWeatherApi api;

  private static ServicioAccuWeather servicioAccuWeather;

  @BeforeAll
  static void setUp() {
    api = mock(AccuWeatherApi.class);
    servicioAccuWeather = new ServicioAccuWeather(api, "Villa Vil", Duration.ofMinutes(30));
  }

  @Test
  void getClima_ClimaNoActualizado_ActualizaClimaYDevuelveValorActualizado() {
    // Datos simulados de la API
    Map<String, Object> weatherData = new HashMap<>();
    weatherData.put("PrecipitationProbability", 20);
    weatherData.put("Temperature", new HashMap<String, Object>() {{
      put("Value", 68);
    }});

    // Configuración del comportamiento simulado de la API
    when(api.getWeather("Villa Vil")).thenReturn(List.of(weatherData));

    // Ejecución de la prueba
    Clima clima = servicioAccuWeather.getClima("Villa Vil");

    // Verificación de que se haya llamado a la API
    verify(api, times(1)).getWeather("Villa Vil");

    // Verificación del resultado esperado
    assertEquals(20, clima.getPrecipitacion());
    assertEquals(Temperatura.CALOR, clima.getTemperatura());
  }

  @Test
  void getClima_ClimaActualizadoNoVenceNoLlamaAPILaSegundaVez() {
    // Datos simulados de la API
    Map<String, Object> weatherData = new HashMap<>();
    weatherData.put("PrecipitationProbability", 20);
    weatherData.put("Temperature", new HashMap<String, Object>() {{
      put("Value", 68);
    }});

    // Configuración del comportamiento simulado de la API
    when(api.getWeather("Villa Vil")).thenReturn(List.of(weatherData));

    // Ejecución de la prueba
    Clima clima1 = servicioAccuWeather.getClima("Villa Vil");
    Clima clima2 = servicioAccuWeather.getClima("Villa Vil");

    // Verificación de que no se haya llamado a la API 2 veces
    verify(api, times(1)).getWeather("Villa Vil");

    // Verificación del resultado esperado
    assertEquals(20, clima2.getPrecipitacion());
    assertEquals(Temperatura.CALOR, clima2.getTemperatura());
  }
}
