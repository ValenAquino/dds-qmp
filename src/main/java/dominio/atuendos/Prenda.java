package dominio.atuendos;

import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.atuendos.caracteristicas.Trama;
import dominio.clima.Temperatura;
import excepciones.PrendaException;
import java.util.List;

public class Prenda {
  final TipoDePrenda tipoDePrenda;
  final Material material;
  final Trama trama;
  final List<Color> colores;
  final Formalidad formalidad;
  final Temperatura temperatura;

  public Prenda(TipoDePrenda tipo, Material mat, List<Color> col, Trama trama,
                Formalidad form, Temperatura temp) {
    this.tipoDePrenda = tipo;
    this.material = mat;
    this.colores = col;
    this.trama = trama;
    this.formalidad = form;
    this.temperatura = temp;
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

  public Color getColorSecundario() {
    if (colores.size() < 2) {
      throw new PrendaException("no hay colorSecundario");
    }

    return colores.get(1);
  }

  public Categoria getCategoria() {
    return tipoDePrenda.getCategoria();
  }

  public boolean esApta(Temperatura t) {
    return t == this.temperatura;
  }

}