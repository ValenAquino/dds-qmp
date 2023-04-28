package validaciones;

import dominio.Categoria;
import dominio.Prenda;
import excepciones.AtuendoException;

public class ValidadorDeAtuendos {
  public static void validarPrendas(Prenda parteSup, Prenda parteInf, Prenda calzado, Prenda accesorio) {
    validarPrenda(parteSup, Categoria.PARTE_SUPERIOR);
    validarPrenda(parteInf, Categoria.PARTE_INFERIOR);
    validarPrenda(calzado, Categoria.CALZADO);
    validarPrenda(accesorio, Categoria.ACCESORIO);
  }

  public static void validarPrenda(Prenda unaPrenda, Categoria categoriaEsperada) {
    Categoria categoriaRecibida = unaPrenda.getTipoDePrenda().getCategoria();

    if (categoriaRecibida != categoriaEsperada) {
      throw AtuendoException.categoria(categoriaRecibida, categoriaEsperada);
    }
  }

}
