package dominio.sugerencias;

import com.google.common.collect.Lists;
import dominio.Usuario;
import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Categoria;
import dominio.clima.Clima;
import dominio.clima.ServicioMeteorologico;
import dominio.clima.Temperatura;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GeneradorDeSugerencias implements MotorDeSugerencias {
  ServicioMeteorologico servicioMeteorologico;

  GeneradorDeSugerencias(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public abstract List<Prenda> getPrendasValidas(Usuario u, List<Prenda> p, Temperatura t);

  public List<Atuendo> generarSugerencias(Usuario usr, List<Prenda> guardaRopas, String ciudad) {
    Clima clima = servicioMeteorologico.getClima(ciudad);
    List<Prenda> prendasValidas = getPrendasValidas(usr, guardaRopas, clima.getTemperatura());

    return generarAtuendos(prendasValidas);
  }

  public List<Atuendo> generarAtuendos(List<Prenda> prendasValidas) {
    List<Prenda> superiores = filtrarCategorias(prendasValidas, Categoria.PARTE_SUPERIOR);
    List<Prenda> inferiores = filtrarCategorias(prendasValidas, Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = filtrarCategorias(prendasValidas, Categoria.CALZADO);

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(superiores, inferiores, calzados);

    return combinaciones.stream()
        .map(c -> new Atuendo(c.get(0), c.get(1), c.get(2))).collect(Collectors.toList());
  }

  public List<Prenda> filtrarCategorias(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream()
        .filter(p -> p.getCategoria().equals(categoria)).collect(Collectors.toList());
  }

}
