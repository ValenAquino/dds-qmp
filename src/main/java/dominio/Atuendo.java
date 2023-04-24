package dominio;

public class Atuendo {
  Prenda parteSuperior;
  Prenda parteInferior;
  Prenda calzado;
  Prenda accesorios;

  Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorios) {
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
    this.accesorios = accesorios;
  }

}