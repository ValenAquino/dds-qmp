package dominio.atuendos.caracteristicas;

public class TipoDePrenda {
  final Categoria categoria;

  public TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}
