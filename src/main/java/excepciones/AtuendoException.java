package excepciones;

import dominio.caracteristicas.Categoria;

public class AtuendoException extends RuntimeException {
  public AtuendoException(String mensaje) {
    super(mensaje);
  }

  public static AtuendoException categoria(Categoria recibida, Categoria esperada) {
    String msg = "Se recibio la categoria " + recibida + " en vez de " + esperada;
    return new AtuendoException(msg);
  }
}
