package dominio.sugerencias;

import dominio.Usuario;
import dominio.atuendos.Prenda;
import java.util.List;

public class SugerenciasBasicas extends GeneradorDeSugerencias {
  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas) {
    return prendas;
  }

}
