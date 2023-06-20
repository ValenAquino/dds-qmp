package dominio.propuestas;

import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;

public class PropuestaAgregarPrenda implements Propuesta {
  Prenda prendaPropuesta;

  public PropuestaAgregarPrenda(Prenda prendaPropuesta) {
    this.prendaPropuesta = prendaPropuesta;
  }

  public void aceptar(Guardarropas guardarropa) {
    guardarropa.agregarPrenda(prendaPropuesta);
  }

  public void deshacer(Guardarropas guardarropa) {
    guardarropa.quitarPrenda(prendaPropuesta);
  }
}
