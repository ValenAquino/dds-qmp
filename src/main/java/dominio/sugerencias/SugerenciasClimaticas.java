package dominio.sugerencias;

import dominio.Usuario;
import dominio.atuendos.Prenda;
import dominio.clima.ServicioMeteorologico;
import dominio.clima.Temperatura;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SugerenciasClimaticas extends GeneradorDeSugerencias {
  public SugerenciasClimaticas(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

  @Override
  public List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas, Temperatura temp) {
    Stream<Prenda> prendasFiltradas = prendas.stream().filter(p -> p.esApta(temp));
    return prendasFiltradas.collect(Collectors.toList());
  }
}
