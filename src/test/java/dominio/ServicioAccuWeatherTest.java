package dominio;

import accuweather.AccuWeatherApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioAccuWeatherTest {
  @Test
  public void test01() {
    AccuWeatherApi api = Mockito.mock(AccuWeatherApi.class);
    System.out.println("Test 01");
  }
}
