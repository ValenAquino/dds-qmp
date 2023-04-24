package dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrendaTest {
  TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
  TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR);
  TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO);
  TipoDePrenda anteojos = new TipoDePrenda(Categoria.ACCESORIO);

  Color azul = new Color(240,248,255);
  Color naranjaClarito = new Color(255,188,66);

//  @BeforeEach
//  public void inicializarDependenciasDeLaPrenda() {
//    this.inicializarTiposDePrenda();
//    this.inicializarColores();
//  }

//  public void inicializarTiposDePrenda() {
//    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
//    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR);
//    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO);
//    TipoDePrenda anteojos = new TipoDePrenda(Categoria.ACCESORIO);
//  }

//  public void inicializarColores() {
//    Color azul = new Color(240,248,255);
//    Color naranjaClarito = new Color(255,188,66);
//  }

  @Test
  public void seInstancianLasPrendasConTodosLosParametrosCorrectos() {
    Prenda remeraAzul = new Prenda(remera, "algodon", azul);

    Assertions.assertNotNull(remeraAzul);
  }
}
