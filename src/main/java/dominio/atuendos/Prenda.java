package dominio.atuendos;

import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.atuendos.caracteristicas.Trama;
import excepciones.PrendaException;
import java.util.List;

public class Prenda {
  final TipoDePrenda tipoDePrenda;
  final Material material;
  final Trama trama;
  final List<Color> colores;
  final Formalidad formalidad;

  public Prenda(TipoDePrenda tipo, Material mat, List<Color> col, Trama trama, Formalidad form) {
    this.tipoDePrenda = tipo;
    this.material = mat;
    this.colores = col;
    this.trama = trama;
    this.formalidad = form;
  }

  public boolean esFormal() {
    return formalidad == Formalidad.FORMAL;
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

  public void getColorSecundario() {
    if (colores.size() < 2) {
      throw new PrendaException("no hay colorSecundario");
    }

  }

  public Categoria getCategoria() {
    return tipoDePrenda.getCategoria();
  }
}