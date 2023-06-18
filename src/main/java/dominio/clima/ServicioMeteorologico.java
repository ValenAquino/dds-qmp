package dominio.clima;

public interface ServicioMeteorologico {
  Clima getClima(String direccion);
}
