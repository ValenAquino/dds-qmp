package dominio.sugerencias;

import dominio.Prenda;
import dominio.Usuario;
import java.util.List;

public class SugerenciasBasicas extends MotorDeSugerencias {
  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas) {
    return prendas;
  }

}
