package dominio.clima;

public class Clima {
  Integer precipitacion;
  Integer temperaturaCelcius;
  Temperatura temperatura;

  public Clima(Integer precipitacion, Integer temperaturaCelcius) {
    this.precipitacion = precipitacion;
    this.temperatura = obtenerEstado(temperaturaCelcius);
  }

  public Temperatura obtenerEstado(Integer temperaturaCelcius) {
    if (temperaturaCelcius < 10) {
      return Temperatura.FRIO;
    } else if (temperaturaCelcius > 25) {
      return Temperatura.CALOR;
    } else {
      return Temperatura.TEMPLADO;
    }
  }

  public Integer getPrecipitacion() {
    return precipitacion;
  }

  public Temperatura getTemperatura() {
    return temperatura;
  }
}
