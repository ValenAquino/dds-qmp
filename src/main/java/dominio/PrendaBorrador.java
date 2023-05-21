package dominio;

public class PrendaBorrador {
  TipoDePrenda tipoDePrenda;
  Material material;
  Color colorPrimario;
  Color colorSecundario;

  public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public void setColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public Prenda build() {
    Prenda unaPrenda = new Prenda(tipoDePrenda, material, colorPrimario);

    if (colorSecundario != null) {
      unaPrenda.setColorSecundario(colorSecundario);
    }

    return unaPrenda;
  }
}
