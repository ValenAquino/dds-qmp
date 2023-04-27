package excepciones;

public class PrendaException extends RuntimeException {
  PrendaException(String mensaje) {
    super(mensaje);
  }

  public static PrendaException materialNoPuedeSerVacio() {
    return new PrendaException("El material de la prenda no puede ser un string vacio");
  }
}