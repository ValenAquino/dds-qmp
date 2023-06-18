package dominio.sugerencias;

import dominio.Usuario;
import dominio.atuendos.Prenda;
import dominio.clima.ServicioMeteorologico;
import dominio.clima.Temperatura;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciasFormales extends GeneradorDeSugerencias {

  public SugerenciasFormales(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas, Temperatura temp) {
    if (usuario.getEdad() > 55) {
      return prendas.stream().filter(p -> p.esFormal() && p.esApta(temp)).collect(Collectors.toList());
    } else {
      return prendas;
    }
  }

}
