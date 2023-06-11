package validaciones;

import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.atuendos.caracteristicas.Trama;
import excepciones.PrendaException;
import java.util.List;

public class ValidadorDePrendas {

  public static void validarPrenda(
      TipoDePrenda tipo, Material mat, List<Color> cols, Trama tr, Formalidad fr
  ) {
    validarAtributo("tipoDePrenda", tipo);
    validarAtributo("material", mat);
    validarColor("colores", cols);
    validarAtributo("trama", tr);
    validarAtributo("formalidad", fr);
  }

  // <T> es para indicar que T es un tipo genérico,
  // si alguien manda un String, T será String, si manda un Integer, T será Integer, etc.
  public static <T> T validarAtributo(String atributo, T valor) {
    if (valor == null) {
      throw PrendaException.atributoNulo(atributo);
    }
    return valor;
  }

  public static void validarColor(String atributo, List<Color> colores) {
    if (colores.isEmpty()) {
      throw PrendaException.atributoNulo(atributo);
    }
  }
}
