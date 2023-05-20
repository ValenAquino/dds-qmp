package dominio;

import validaciones.ValidadorDeAtuendos;

public class Atuendo {
  Prenda parteSuperior;
  Prenda parteInferior;
  Prenda calzado;
  Prenda accesorio;

  Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    ValidadorDeAtuendos.validarPrendas(parteSuperior, parteInferior, calzado);
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }

  public void setAccesorios(Prenda accesorio) {
    ValidadorDeAtuendos.validarPrenda(accesorio, Categoria.ACCESORIO);
    this.accesorio = accesorio;
  }

}