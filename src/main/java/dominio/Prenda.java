package dominio;

import dominio.caracteristicas.Categoria;
import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import dominio.caracteristicas.Trama;
import excepciones.PrendaException;
import java.util.List;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Trama trama;
  List<Color> colores;
  boolean esFormal = false;

  public Prenda(TipoDePrenda tipo, Material mat, List<Color> col, Trama trama, boolean esFormal) {
    this.tipoDePrenda = tipo;
    this.material = mat;
    this.colores = col;
    this.trama = trama;
    this.esFormal = esFormal;
  }

  public boolean esFormal() {
    return esFormal;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }

  public Material getMaterial() {
    return material;
  }

  public Trama getTrama() {
    return trama;
  }

  public Color getColorPrimario() {
    return colores.get(0);
  }

  public Color getColorSecundario() {
    if (colores.size() < 2) {
      throw new PrendaException("no hay colorSecundario");
    } else {
      return colores.get(1);
    }
  }

  public Categoria getCategoria() {
    return tipoDePrenda.getCategoria();
  }
}