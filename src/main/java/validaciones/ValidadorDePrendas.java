package validaciones;

import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import dominio.caracteristicas.Trama;
import excepciones.PrendaException;
import java.util.List;

public class ValidadorDePrendas {

  public static void validarPrenda(TipoDePrenda tipo, Material mat, List<Color> cols, Trama tr) {
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
