package dominio;

import java.util.ArrayList;
import java.util.List;

public class Sugerencia {
  List<Atuendo> atuendos = new ArrayList<>();

  public void agregarAtuendo(Atuendo atuendo) {
    this.atuendos.add(atuendo);
  }
}
