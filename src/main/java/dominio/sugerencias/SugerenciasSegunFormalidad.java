package dominio.sugerencias;

import dominio.Prenda;
import dominio.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciasSegunFormalidad extends MotorDeSugerencias {
  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas) {
    if (usuario.getEdad() > 55) {
      return prendas.stream().filter(Prenda::esFormal).collect(Collectors.toList());
    } else {
      return prendas;
    }
  }
}
