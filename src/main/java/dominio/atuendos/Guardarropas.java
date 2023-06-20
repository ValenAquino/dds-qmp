package dominio.atuendos;

import dominio.propuestas.Propuesta;
import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  List<Prenda> prendas = new ArrayList<>();
  List<Propuesta> propuestas = new ArrayList<>();
  List<Propuesta> propuestasAceptadas = new ArrayList<>();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void agregarPropuesta(Propuesta propuesta) {
    propuestas.add(propuesta);
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.aceptar(this);
    propuestas.remove(propuesta);
    propuestasAceptadas.add(propuesta);
  }

  public void deshacerPropuesta(Propuesta propuesta) {
    propuesta.deshacer(this);
    propuestasAceptadas.remove(propuesta);
  }

  public List<Propuesta> getPropuestas() {
    return propuestas;
  }

  public List<Propuesta> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }
}
