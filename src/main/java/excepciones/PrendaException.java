package excepciones;

public class PrendaException extends RuntimeException {
  public PrendaException(String mensaje) {
    super(mensaje);
  }

  public static PrendaException atributoNulo(String atributo) {
    String msg = "El atributo " + atributo + "es obligatorio";
    return new PrendaException(msg);
  }
}