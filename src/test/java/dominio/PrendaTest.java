package dominio;

import dominio.caracteristicas.Categoria;
import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import dominio.caracteristicas.Trama;

import excepciones.PrendaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {
  TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  Color azul = new Color(240, 248, 255);

  @Test
  public void seInstancianLasPrendasConTodosLosParametrosCorrectos() {
    Prenda remeraAzul = remeraAzul();
    Assertions.assertNotNull(remeraAzul);
  }

  @Test
  public void seInstancianLasPrendasConElBorrador() {
    Prenda remeraAzul = remeraAzul();
    Assertions.assertNotNull(remeraAzul);
  }

  @Test
  public void seInstancianLasPrendasConElBorradorYSeValidanLosAtributos() {
    Prenda remeraAzul = remeraAzul();
    List<Color> colores = new ArrayList<>(Arrays.asList(azul));

    Assertions.assertEquals(remeraAzul.getTipoDePrenda(), remera);
    Assertions.assertEquals(remeraAzul.getMaterial(), Material.ALGODON);
    Assertions.assertEquals(remeraAzul.getColores(), colores);
    Assertions.assertEquals(remeraAzul.getTrama(), Trama.LISA);
  }

  @Test
  public void unaPrendaSinColorSecundarioFallaCuandoPidoSuValor() {
    Prenda remeraAzul = remeraAzul();
    Assertions.assertThrows(PrendaException.class, remeraAzul::getColorSecundario);
  }

  @Test
  public void siNoDefinoLaTramaPorDefectoEsLisa() {
    Prenda remeraAzulSinTrama = remeraAzulSinTrama();

    Assertions.assertEquals(Trama.LISA, remeraAzulSinTrama.getTrama());
  }

  public Prenda remeraAzul() {
    Borrador borrador = remeraAzulSinTramaBorrador();
    borrador.setTrama(Trama.LISA);
    return borrador.build();
  }

  public Prenda remeraAzulSinTrama() {
    Borrador borrador = remeraAzulSinTramaBorrador();
    return borrador.build();
  }

  public Borrador remeraAzulSinTramaBorrador() {
    Borrador borrador = new Borrador();

    borrador.setTipoDePrenda(remera);
    borrador.setMaterial(Material.ALGODON);
    borrador.setColorPrimario(azul);

    return borrador;
  }

}
