package dominio.propuestas;

import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;

public class PropuestaQuitarPrenda implements Propuesta {
  Prenda prendaPropuesta;

  public PropuestaQuitarPrenda(Prenda prendaPropuesta) {
    this.prendaPropuesta = prendaPropuesta;
  }

  public void aceptar(Guardarropas guardarropa) {
    guardarropa.quitarPrenda(prendaPropuesta);
  }

  public void deshacer(Guardarropas guardarropa) {
    guardarropa.agregarPrenda(prendaPropuesta);
  }
}
