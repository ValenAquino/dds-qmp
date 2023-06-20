package dominio;

import dominio.atuendos.Atuendo;
import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;
import dominio.sugerencias.MotorDeSugerenciasLocator;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
  final Integer edad;
  MotorDeSugerenciasLocator motor;
  List<Guardarropas> guardarropas = new ArrayList<>();

  public Usuario(Integer edad, MotorDeSugerenciasLocator motor) {
    this.edad = edad;
    this.motor = motor;
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    this.guardarropas.add(guardarropas);
  }

  public List<Atuendo> generarSugerencias(String ciudad, List<Prenda> prendas) {
    return motor.getMotorDeSugerencias().generarSugerencias(this, prendas, ciudad);
  }

  public Integer getEdad() {
    return edad;
  }

  public List<Guardarropas> getGuardarropas() {
    return guardarropas;
  }
}
