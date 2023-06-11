package dominio.sugerencias;

import com.google.common.collect.Lists;
import dominio.Usuario;
import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Categoria;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GeneradorDeSugerencias implements MotorDeSugerencias {

  public List<Atuendo> generarSugerencias(Usuario usuario, List<Prenda> guardaRopas) {
    List<Prenda> prendasValidas = getPrendasValidas(usuario, guardaRopas);

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

  public abstract List<Prenda> getPrendasValidas(Usuario usuario, List<Prenda> prendas);

}
