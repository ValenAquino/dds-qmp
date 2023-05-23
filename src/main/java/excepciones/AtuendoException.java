package excepciones;

import dominio.caracteristicas.Categoria;

public class AtuendoException extends RuntimeException{
  public AtuendoException(String mensaje) {
    super(mensaje);
  }

  public static AtuendoException categoria(Categoria categoriaRecibida, Categoria categoriaEsperada) {
    String msg = "Se recibio la categoria " + categoriaRecibida + " en vez de " + categoriaEsperada;
    return new AtuendoException(msg);
  }
}
