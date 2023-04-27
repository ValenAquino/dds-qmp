package dominio;

import excepciones.PrendaException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {
  TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  Color azul = new Color(240,248,255);

  @Test
  public void seInstancianLasPrendasConTodosLosParametrosCorrectos() {
    Prenda remeraAzul = new Prenda(remera, "algodon", azul);
    Assertions.assertNotNull(remeraAzul);
  }

  @Test
  public void lasPrendasSinMaterialFallan() {
    Assertions.assertThrows(PrendaException.class, () -> {
      Prenda remeraAzul = new Prenda(remera, "", azul);
    });
  }
}
