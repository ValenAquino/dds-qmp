package dominio;

import excepciones.AtuendoException;
import excepciones.PrendaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AtuendoTest {
  static TipoDePrenda remera;
  static TipoDePrenda pantalon;
  static TipoDePrenda zapatillas;
  static TipoDePrenda anteojos;

  static Color naranjaClarito;
  static Color azul;

  static Prenda remeraAzul;
  static Prenda pantalonAzul;
  static Prenda anteojosNaranja;
  static Prenda zapatillasNaranja;

  @BeforeAll
  static void setUp() {
    remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
    pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR);
    zapatillas = new TipoDePrenda(Categoria.CALZADO);
    anteojos = new TipoDePrenda(Categoria.ACCESORIO);

    naranjaClarito = new Color(255, 188, 66);
    azul = new Color(240, 248, 255);

    remeraAzul = new Prenda(remera, "algodon", azul);
    pantalonAzul = new Prenda(pantalon, "algodon", azul);
    anteojosNaranja = new Prenda(anteojos, "plastico", naranjaClarito);
    zapatillasNaranja = new Prenda(zapatillas, "cuero", naranjaClarito);
  }

  @Test
  public void seInstancianLasPrendasConTodosLosParametrosCorrectos() {
    Atuendo unAtuendo = new Atuendo(remeraAzul, pantalonAzul, zapatillasNaranja, anteojosNaranja);
    Assertions.assertNotNull(unAtuendo);
  }

  @Test
  public void laCategoriaSeCondiceConSuTipo() {
    Assertions.assertThrows(AtuendoException.class, () -> {
      Atuendo unAtuendo = new Atuendo(anteojosNaranja, pantalonAzul, zapatillasNaranja, remeraAzul);
    });
  }
}
