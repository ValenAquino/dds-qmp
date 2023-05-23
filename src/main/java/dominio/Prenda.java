package dominio;

import dominio.caracteristicas.Color;
import dominio.caracteristicas.Material;
import dominio.caracteristicas.TipoDePrenda;
import dominio.caracteristicas.Trama;
import excepciones.PrendaException;
import java.util.List;
import java.util.ArrayList;

public class Prenda {
  TipoDePrenda tipoDePrenda;
  Material material;
  Trama trama;
  List<Color> colores;

  public Prenda(TipoDePrenda tipo, Material material, List<Color> colores, Trama trama) {
    this.tipoDePrenda = tipo;
    this.material = material;
    this.colores = colores;
    this.trama = trama;
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

  public List<Color> getColores() {
    return colores;
  }

  public Color getColorPrimario() {
    return colores.get(0);
  }

  public Color getColorSecundario() {
    if(colores.size() < 2) {
      throw new PrendaException("no hay colorSecundario");
    }

    return colores.get(1);
  }
}