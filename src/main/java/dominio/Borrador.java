package dominio;

import static java.util.Objects.requireNonNull;

import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import dominio.caracteristicas.Trama;
import java.util.ArrayList;
import java.util.List;
import validaciones.ValidadorDePrendas;

public class Borrador {
  TipoDePrenda tipoDePrenda;
  Material material;
  Trama trama = Trama.LISA;
  List<Color> colores = new ArrayList<>();

  public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = ValidadorDePrendas.validarAtributo("tipoDePrenda", tipoDePrenda);
  }

  public void setMaterial(Material material) {
    this.material = ValidadorDePrendas.validarAtributo("material", material);
  }

  public void setColorPrimario(Color color) {
    Color colorValido = ValidadorDePrendas.validarAtributo("colorPrimario", color);
    int indice = 0;
    this.setColorEnPosicion(colorValido, indice);
  }

  public void setColorSecundario(Color color) {
    Color colorValido = ValidadorDePrendas.validarAtributo("colorSecundario", color);
    int indice = 1;
    this.setColorEnPosicion(colorValido, indice);
  }

  public void setColorEnPosicion(Color color, int indice) {
    if (this.colores.size() < indice + 1) {
      this.colores.add(indice, color);
    } else {
      this.colores.set(indice, color);
    }
  }

  public void setTrama(Trama trama) {
    this.trama = ValidadorDePrendas.validarAtributo("trama", trama);
  }

  public Prenda build() {
    ValidadorDePrendas.validarPrenda(tipoDePrenda, material, colores, trama);
    return new Prenda(tipoDePrenda, material, colores, trama);
  }

}
