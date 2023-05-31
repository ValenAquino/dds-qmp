package dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  Integer edad;
  List<Prenda> guardaRopas;

  public Usuario(Integer edad, List<Prenda> guardaRopas) {
    this.edad = edad;
    this.guardaRopas = new ArrayList<>();
  }

  public List<Atuendo> generarSugerencias(MotorDeSugerencias motor) {
    return motor.generarSugerencias(this, guardaRopas);
  }

  public void agregarPrenda(Prenda prenda) {
    guardaRopas.add(prenda);
  }

  public Integer getEdad() {
    return edad;
  }
}
