package dominio;

import static java.util.Objects.requireNonNull;

import excepciones.PrendaException;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  String material;
  Color colorPrimario;
  Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, String material, Color colorPrimario) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "'tipoDePrenda' es obligatorio");
    this.material = requireNonNull(material, "'material' es obligatorio");
    this.colorPrimario = requireNonNull(colorPrimario, "'colorPrimario' es obligatorio");

    if (material.equals("")) {
      throw PrendaException.materialNoPuedeSerVacio();
    }
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }
}