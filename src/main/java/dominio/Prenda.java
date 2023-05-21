package dominio;

import static java.util.Objects.requireNonNull;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorPrimario) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "'tipoDePrenda' es obligatorio");
    this.material = requireNonNull(material, "'material' es obligatorio");
    this.colorPrimario = requireNonNull(colorPrimario, "'colorPrimario' es obligatorio");
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }
}