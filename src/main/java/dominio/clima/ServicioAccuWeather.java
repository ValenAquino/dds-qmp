package dominio.clima;

import accuweather.AccuWeatherApi;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ServicioAccuWeather implements ServicioMeteorologico {
  AccuWeatherApi api;
  String ciudad;
  Clima clima;
  LocalDateTime ultimaReferencia;
  Duration tiempoDeValidez;
  LocalDateTime proximaActualizacion;

  public ServicioAccuWeather(AccuWeatherApi api, String ciudad, Duration tiempoDeValidez) {
    this.api = api;
    this.ciudad = ciudad;
    this.tiempoDeValidez = tiempoDeValidez;
  }

  public void setClima(Clima clima) {
    this.clima = clima;
  }

  @Override
  public Clima getClima(String ciudad) {
    if (this.clima == null || LocalDateTime.now().isAfter(this.proximaActualizacion)) {
      this.actualizarClima();
      this.proximaActualizacion = LocalDateTime.now().plus(tiempoDeValidez);
    }

    return this.clima;
  }

  @SuppressWarnings("unchecked")
  public void actualizarClima() {
    List<Map<String, Object>> weatherList = api.getWeather(ciudad);
    Map<String, Object> weather = weatherList.get(0);
    Map<String, Object> temperatura = (Map<String, Object>) weather.get("Temperature");

    this.clima = new Clima(
        (Integer) weather.get("PrecipitationProbability"),
        (Integer) temperatura.get("Value")
    );
  }

}
