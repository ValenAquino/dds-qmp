package dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {
  TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  Color azul = new Color(240, 248, 255);

  @Test
  public void seInstancianLasPrendasConTodosLosParametrosCorrectos() {
    Material algodon = new Material(Trama.LISA);
    Prenda remeraAzul = new Prenda(remera, algodon, azul);
    Assertions.assertNotNull(remeraAzul);
  }

  @Test
  public void unMaterialSinTramaPorDefectoEsLisa() {
    Material algodon = new Material();
    Assertions.assertEquals(Trama.LISA, algodon.getTrama());
  }

}
