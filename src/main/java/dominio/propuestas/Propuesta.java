package dominio.propuestas;

import dominio.atuendos.Guardarropas;

public interface Propuesta {
  void aceptar(Guardarropas guardarropa);
  void deshacer(Guardarropas guardarropa);
}
