package dominio.sugerencias;

import dominio.Usuario;
import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import java.util.List;

public interface MotorDeSugerencias {
  public List<Atuendo> generarSugerencias(Usuario usuario, List<Prenda> guardaRopas, String ciudad);
}
