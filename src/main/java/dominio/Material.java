package dominio;

public class Material {
  Trama trama = Trama.LISA;

  public Material() {
  }

  public Material(Trama trama) {
    this.trama = trama;
  }

  public Trama getTrama() {
    return trama;
  }
}
