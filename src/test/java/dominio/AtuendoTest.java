package dominio;

import dominio.caracteristicas.Categoria;
import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import excepciones.AtuendoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AtuendoTest {
  static Prenda remeraAzul;
  static Prenda pantalonAzul;
  static Prenda anteojosNaranja;
  static Prenda zapatillasNaranja;

  static Color naranjaClarito = new Color(255, 188, 66);
  static Color azul = new Color(240, 248, 255);

  @BeforeAll
  static void setUp() {
    remeraAzul = remeraAzul();
    pantalonAzul = pantalonAzul();
    anteojosNaranja = anteojosNaranja();
    zapatillasNaranja = zapatillasNaranja();
  }

  public static Prenda anteojosNaranja() {
    TipoDePrenda anteojos = new TipoDePrenda(Categoria.ACCESORIO);
    return getPrenda(anteojos, Material.ALGODON, naranjaClarito);
  }

  public static Prenda zapatillasNaranja() {
    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO);
    return getPrenda(zapatillas, Material.ALGODON, naranjaClarito);
  }

  public static Prenda pantalonAzul() {
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR);
    return getPrenda(pantalon, Material.ALGODON, azul);
  }

  public static Prenda remeraAzul() {
    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
    return getPrenda(remera, Material.ALGODON, azul);
  }

  public static Prenda getPrenda(TipoDePrenda tipo, Material mat, Color col) {
    Borrador borrador = new Borrador();
    borrador.setTipoDePrenda(tipo);
    borrador.setMaterial(mat);
    borrador.setColorPrimario(col);
    return borrador.build();
  }

  @Test
  public void seInstancianLosAtuendosConTodosLosParametrosCorrectos() {
    Atuendo unAtuendo = new Atuendo(remeraAzul, pantalonAzul, zapatillasNaranja);
    unAtuendo.setAccesorios(anteojosNaranja);
    Assertions.assertNotNull(unAtuendo);
  }

  @Test
  public void laCategoriaSeCondiceConSuTipo() {
    Assertions.assertThrows(AtuendoException.class, () -> {
      new Atuendo(anteojosNaranja, zapatillasNaranja, remeraAzul);
    });
  }
}
