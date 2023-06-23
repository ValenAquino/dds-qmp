package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;
import dominio.clima.Clima;
import dominio.clima.ServicioMeteorologico;
import dominio.clima.Temperatura;
import dominio.sugerencias.SugerenciasClimaticas;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SugerenciasClimaticasTest {
  @Mock
  private ServicioMeteorologico servicioMeteorologicoMock = Mockito.mock(ServicioMeteorologico.class);

  @Mock
  private Clima climaMock = Mockito.mock(Clima.class);

  @Mock
  private Guardarropas guardarropasMock = Mockito.mock(Guardarropas.class);

  @Mock
  private Usuario usuarioMock = Mockito.mock(Usuario.class);

  private SugerenciasClimaticas sugerenciasClimaticas;

  @BeforeEach
  public void setUp() {
    sugerenciasClimaticas = new SugerenciasClimaticas(servicioMeteorologicoMock);
  }

  @Test
  public void getPrendasValidas_FiltrarPrendasCorrectamente() {
    // Datos de prueba
    Temperatura temperatura = Temperatura.TEMPLADO;

    List<Prenda> prendas = new ArrayList<>();

    Prenda prenda1 = Mockito.mock(Prenda.class);
    when(prenda1.esApta(temperatura)).thenReturn(true);

    Prenda prenda2 = Mockito.mock(Prenda.class);
    when(prenda2.esApta(temperatura)).thenReturn(false);

    Prenda prenda3 = Mockito.mock(Prenda.class);
    when(prenda3.esApta(temperatura)).thenReturn(true);

    prendas.add(prenda1);
    prendas.add(prenda2);
    prendas.add(prenda3);

    // Configuración de mocks
    when(servicioMeteorologicoMock.getClima("")).thenReturn(climaMock);
    when(climaMock.getTemperatura()).thenReturn(temperatura);
    when(guardarropasMock.getPrendas()).thenReturn(prendas);

    // Llamada al método que se va a probar
    List<Prenda> prendasValidas = sugerenciasClimaticas.getPrendasValidas(usuarioMock, prendas, temperatura);

    // Verificación de resultados
    assertEquals(2, prendasValidas.size()); // Solo debe haber una prenda válida
    assertEquals(prenda1, prendasValidas.get(0)); // La prenda válida debe ser la prenda1
    assertEquals(prenda3, prendasValidas.get(1)); // La prenda válida debe ser la prenda1
  }

}

