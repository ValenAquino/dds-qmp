package dominio.atuendos;

import dominio.propuestas.Propuesta;
import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  List<Prenda> prendas = new ArrayList<>();
  List<Propuesta> propuestas = new ArrayList<Propuesta>();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

}
