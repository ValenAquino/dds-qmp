package dominio;

import static java.util.Objects.requireNonNull;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  String material;
  Color colorPrimario;
  Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, String material, Color colorPrimario) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "'tipoDePrenda' es obligatorio");
    this.material = requireNonNull(material, "'materia' es obligatorio");
    this.colorPrimario = requireNonNull(colorPrimario, "'colorPrimario' es obligatorio");
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }
}