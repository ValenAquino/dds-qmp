package dominio.sugerencias;

import dominio.Usuario;
import dominio.atuendos.Prenda;
import dominio.clima.ServicioMeteorologico;
import dominio.clima.Temperatura;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciasBasicas extends GeneradorDeSugerencias {

  public SugerenciasBasicas(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas, Temperatura temp) {
    return prendas;
  }

}
