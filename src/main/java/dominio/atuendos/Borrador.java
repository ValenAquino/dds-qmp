package dominio.atuendos;

import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.atuendos.caracteristicas.Trama;
import dominio.clima.Temperatura;
import java.util.ArrayList;
import java.util.List;
import validaciones.ValidadorDePrendas;

public class Borrador {
  final List<Color> colores = new ArrayList<>();
  TipoDePrenda tipoDePrenda;
  Material material;
  Trama trama = Trama.LISA;
  Formalidad formalidad;
  Temperatura temperatura;

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

  public void setFormalidad(Formalidad formalidad) {
    this.formalidad = ValidadorDePrendas.validarAtributo("formalidad", formalidad);
  }

  public void setTemperatura(Temperatura temperatura) {
    this.temperatura = ValidadorDePrendas.validarAtributo("temperatura", temperatura);
  }

  public Prenda build() {
    ValidadorDePrendas.validarPrenda(
        tipoDePrenda, material, colores, trama, formalidad, temperatura
    );
    return new Prenda(tipoDePrenda, material, colores, trama, formalidad, temperatura);
  }

}
