package dominio.sugerencias;

import dominio.atuendos.Prenda;
import dominio.Usuario;
import java.util.List;

public class SugerenciasBasicas extends GeneradorDeSugerencias {
  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas) {
    return prendas;
  }

}
