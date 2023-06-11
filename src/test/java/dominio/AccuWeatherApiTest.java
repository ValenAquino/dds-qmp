package dominio;

import org.junit.jupiter.api.Test;

public class AccuWeatherApiTest {
  @Test
  public void conocerClima() {
    Usuario usuario = new Usuario(20, null, null);
    usuario.conocerClima();
  }
}
