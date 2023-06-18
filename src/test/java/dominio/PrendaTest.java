package dominio;

import dominio.atuendos.Borrador;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.atuendos.caracteristicas.Trama;
import dominio.clima.Temperatura;
import excepciones.PrendaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrendaTest {
  final TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  final Color azul = new Color(240, 248, 255);
  final Color verde = new Color(0, 255, 0);

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

    Assertions.assertEquals(remeraAzul.getTipoDePrenda(), remera);
    Assertions.assertEquals(remeraAzul.getMaterial(), Material.ALGODON);
    Assertions.assertEquals(remeraAzul.getColorPrimario(), azul);
    Assertions.assertEquals(remeraAzul.getTrama(), Trama.LISA);
  }

  @Test
  public void noPuedoCrearPrendaSinColor() {
    Assertions.assertThrows(PrendaException.class, () -> {
      Borrador borrador = new Borrador();
      borrador.setTipoDePrenda(remera);
      borrador.setMaterial(Material.ALGODON);
      Prenda unaPrenda = borrador.build();
    });
  }

  @Test
  public void unaPrendaSinColorSecundarioFallaCuandoPidoSuValor() {
    Prenda remeraAzul = remeraAzul();
    Assertions.assertThrows(PrendaException.class, remeraAzul::getColorSecundario);
  }

  @Test
  public void puedoCrearPrendasConColorSecundario() {
    Prenda remeraAzulConVerde = remeraAzulConVerde();
    Assertions.assertEquals(verde, remeraAzulConVerde.getColorSecundario());
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

  public Prenda remeraAzulConVerde() {
    Borrador borrador = remeraAzulSinTramaBorrador();
    borrador.setColorSecundario(verde);
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
    borrador.setFormalidad(Formalidad.FORMAL);
    borrador.setTemperatura(Temperatura.TEMPLADO);

    return borrador;
  }

}
