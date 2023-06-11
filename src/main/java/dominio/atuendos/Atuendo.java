package dominio.atuendos;

import dominio.atuendos.caracteristicas.Categoria;
import validaciones.ValidadorDeAtuendos;

public class Atuendo {
  final Prenda parteSuperior;
  final Prenda parteInferior;
  final Prenda calzado;
  Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    ValidadorDeAtuendos.validarPrendas(parteSuperior, parteInferior, calzado);
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }

  public void setAccesorios(Prenda accesorio) {
    ValidadorDeAtuendos.validarPrenda(accesorio, Categoria.ACCESORIO);
    this.accesorio = accesorio;
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public Prenda getAccesorio() {
    return accesorio;
  }

}