package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.sugerencias.MotorDeSugerencias;
import dominio.sugerencias.MotorDeSugerenciasLocator;
import dominio.sugerencias.SugerenciasBasicas;
import dominio.sugerencias.SugerenciasFormales;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SugerenciasTest {
  private static List<Prenda> guardaRopasInformal;
  private static List<Prenda> guardaRopasFormal;

  @BeforeAll
  static void setUp() {
    guardaRopasInformal = new ArrayList<>();
    guardaRopasInformal.add(TallerDePrendas.remeraAzul(Formalidad.INFORMAL));
    guardaRopasInformal.add(TallerDePrendas.pantalonAzul(Formalidad.INFORMAL));
    guardaRopasInformal.add(TallerDePrendas.anteojosNaranja(Formalidad.INFORMAL));
    guardaRopasInformal.add(TallerDePrendas.zapatillasNaranja(Formalidad.INFORMAL));

    guardaRopasFormal = new ArrayList<>();
    guardaRopasFormal.add(TallerDePrendas.remeraAzul(Formalidad.FORMAL));
    guardaRopasFormal.add(TallerDePrendas.pantalonAzul(Formalidad.FORMAL));
    guardaRopasFormal.add(TallerDePrendas.anteojosNaranja(Formalidad.FORMAL));
    guardaRopasFormal.add(TallerDePrendas.zapatillasNaranja(Formalidad.FORMAL));
  }

  @Test
  public void testGenerarSugerenciasSugerenciasBasicas() {
    SugerenciasBasicas sugerenciasBasicas = new SugerenciasBasicas();
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasBasicas);
    Usuario usuario = new Usuario(30, guardaRopasInformal, localizador);

    List<Atuendo> sugerencias = usuario.generarSugerencias();
    Atuendo atuendo = sugerencias.get(0);

    assertEquals(1, sugerencias.size());
    assertEquals(Categoria.PARTE_SUPERIOR, atuendo.getParteSuperior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.PARTE_INFERIOR, atuendo.getParteInferior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.CALZADO, atuendo.getCalzado().getTipoDePrenda().getCategoria());
  }

  @Test
  public void testGenerarSugerenciasSugerenciasFormales() {
    SugerenciasFormales sugerenciasFormales = new SugerenciasFormales();
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasFormales);
    Usuario usuario = new Usuario(60, guardaRopasFormal, localizador);

    List<Atuendo> sugerencias = usuario.generarSugerencias();
    Atuendo atuendo = sugerencias.get(0);

    assertEquals(1, sugerencias.size());
    assertEquals(Categoria.PARTE_SUPERIOR, atuendo.getParteSuperior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.PARTE_INFERIOR, atuendo.getParteInferior().getTipoDePrenda().getCategoria());
    assertEquals(Categoria.CALZADO, atuendo.getCalzado().getTipoDePrenda().getCategoria());
  }

  @Test
  public void sugerenciasFormalesSinRopaFormalDevuelveListaVacia() {
    SugerenciasFormales sugerenciasFormales = new SugerenciasFormales();
    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(sugerenciasFormales);
    Usuario usuario = new Usuario(60, guardaRopasInformal, localizador);

    List<Atuendo> sugerencias = usuario.generarSugerencias();

    assertEquals(0, sugerencias.size());
  }

  @Test
  public void testCambiarMotorDeSugerencias() {
    MotorDeSugerencias motorBasico = new SugerenciasBasicas();
    MotorDeSugerencias motorFormal = new SugerenciasFormales();

    MotorDeSugerenciasLocator localizador = new MotorDeSugerenciasLocator(motorBasico);

    MotorDeSugerencias motorActual = localizador.getMotorDeSugerencias();
    assertEquals(motorBasico, motorActual);

    localizador.setMotorDeSugerencias(motorFormal);

    motorActual = localizador.getMotorDeSugerencias();
    assertEquals(motorFormal, motorActual);
  }
}
