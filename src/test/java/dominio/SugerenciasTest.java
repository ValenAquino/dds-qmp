package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import accuweather.AccuWeatherApi;
import dominio.atuendos.Atuendo;
import dominio.atuendos.Guardarropas;
import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.clima.ServicioAccuWeather;
import dominio.sugerencias.MotorDeSugerencias;
import dominio.sugerencias.MotorDeSugerenciasLocator;
import dominio.sugerencias.SugerenciasBasicas;
import dominio.sugerencias.SugerenciasFormales;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SugerenciasTest {
  private static final String ciudad = "Buenos Aires";
  private static Guardarropas guardaRopasInformal;
  private static Guardarropas guardaRopasFormal;
  private static ServicioAccuWeather servicioMeteorologico;

  @BeforeAll
  static void setUp() {
    guardaRopasInformal = TallerDePrendas.generarGuardarropasFormalidad(Formalidad.INFORMAL);
    guardaRopasFormal = TallerDePrendas.generarGuardarropasFormalidad(Formalidad.FORMAL);

    servicioMeteorologico = new ServicioAccuWeather(
        new AccuWeatherApi(), ciudad, Duration.ofSeconds(0)
    );
  }

  @Test
  public void testGenerarSugerenciasSugerenciasBasicas() {
    SugerenciasBasicas sugerenciasBasicas = new SugerenciasBasicas(servicioMeteorologico);
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasBasicas);

    Usuario usuario = new Usuario(30, localizador);
    usuario.agregarGuardarropas(guardaRopasInformal);

    List<Atuendo> sugerencias = usuario.generarSugerencias(
        ciudad, usuario.getGuardarropas().get(0).getPrendas()
    );

    Atuendo atuendo = sugerencias.get(0);

    assertEquals(1, sugerencias.size());
    assertEquals(Categoria.PARTE_SUPERIOR, atuendo.getParteSuperior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.PARTE_INFERIOR, atuendo.getParteInferior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.CALZADO, atuendo.getCalzado().getTipoDePrenda().getCategoria());
  }

  @Test
  public void testGenerarSugerenciasSugerenciasFormales() {
    SugerenciasFormales sugerenciasFormales = new SugerenciasFormales(servicioMeteorologico);
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasFormales);

    Usuario usuario = new Usuario(60, localizador);
    usuario.agregarGuardarropas(guardaRopasFormal);

    List<Atuendo> sugerencias = usuario.generarSugerencias(
        ciudad, usuario.getGuardarropas().get(0).getPrendas()
    );

    Atuendo atuendo = sugerencias.get(0);

    assertEquals(1, sugerencias.size());
    assertEquals(Categoria.PARTE_SUPERIOR, atuendo.getParteSuperior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.PARTE_INFERIOR, atuendo.getParteInferior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.CALZADO, atuendo.getCalzado().getTipoDePrenda().getCategoria());
  }

  @Test
  public void sugerenciasFormalesSinRopaFormalDevuelveListaVacia() {
    SugerenciasFormales sugerenciasFormales = new SugerenciasFormales(servicioMeteorologico);
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasFormales);

    Usuario usuario = new Usuario(60, localizador);
    usuario.agregarGuardarropas(guardaRopasInformal);

    List<Atuendo> sugerencias = usuario.generarSugerencias(
        ciudad, usuario.getGuardarropas().get(0).getPrendas()
    );

    assertEquals(0, sugerencias.size());
  }

  @Test
  public void testCambiarMotorDeSugerencias() {
    MotorDeSugerencias motorBasico = new SugerenciasBasicas(servicioMeteorologico);
    MotorDeSugerencias motorFormal = new SugerenciasFormales(servicioMeteorologico);

    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(motorBasico);

    MotorDeSugerencias motorActual = localizador.getMotorDeSugerencias();
    assertEquals(motorBasico, motorActual);

    localizador.setMotorDeSugerencias(motorFormal);

    motorActual = localizador.getMotorDeSugerencias();
    assertEquals(motorFormal, motorActual);
  }
}
