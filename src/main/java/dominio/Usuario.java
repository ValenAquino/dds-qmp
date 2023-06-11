package dominio;

import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import dominio.sugerencias.MotorDeSugerenciasLocator;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
  final Integer edad;
  final List<Prenda> guardaRopas;
  MotorDeSugerenciasLocator motor;

  public Usuario(Integer edad, List<Prenda> guardaRopas, MotorDeSugerenciasLocator motor) {
    this.edad = edad;
    this.guardaRopas = guardaRopas != null ? guardaRopas : new ArrayList<>();
    this.motor = motor;
  }

  public List<Atuendo> generarSugerencias() {
    return motor.getMotorDeSugerencias().generarSugerencias(this, guardaRopas);
  }

  public void agregarPrenda(Prenda prenda) {
    guardaRopas.add(prenda);
  }

  public Integer getEdad() {
    return edad;
  }
}
