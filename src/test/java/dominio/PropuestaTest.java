package dominio;

import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.propuestas.Propuesta;
import dominio.propuestas.PropuestaAgregarPrenda;
import dominio.propuestas.PropuestaQuitarPrenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropuestaTest {
  private Guardarropas guardarropas;
  private Prenda prenda1;
  private Prenda prenda2;
  private Propuesta propuestaAgregar;
  private Propuesta propuestaQuitar;

  @BeforeEach
  public void setup() {
    guardarropas = new Guardarropas();
    prenda1 = TallerDePrendas.anteojosNaranja(Formalidad.FORMAL);
    prenda2 = TallerDePrendas.remeraAzul(Formalidad.FORMAL);
    propuestaAgregar = new PropuestaAgregarPrenda(prenda1);
    propuestaQuitar = new PropuestaQuitarPrenda(prenda2);
  }

  @Test
  public void realizarPropuestaAgregarPrenda() {
    guardarropas.agregarPropuesta(propuestaAgregar);
    guardarropas.agregarPropuesta(propuestaQuitar);
    Assertions.assertTrue(guardarropas.getPropuestas().contains(propuestaAgregar));
    Assertions.assertTrue(guardarropas.getPropuestas().contains(propuestaQuitar));
  }

  @Test
  public void aceptarPropuesta() {
    guardarropas.agregarPropuesta(propuestaAgregar);
    guardarropas.aceptarPropuesta(propuestaAgregar);
    Assertions.assertFalse(guardarropas.getPropuestas().contains(propuestaAgregar));
    Assertions.assertTrue(guardarropas.getPropuestasAceptadas().contains(propuestaAgregar));
    Assertions.assertTrue(guardarropas.getPrendas().contains(prenda1));
  }

  @Test
  public void deshacerPropuesta() {
    guardarropas.agregarPropuesta(propuestaAgregar);
    guardarropas.aceptarPropuesta(propuestaAgregar);
    guardarropas.deshacerPropuesta(propuestaAgregar);
    Assertions.assertFalse(guardarropas.getPropuestas().contains(propuestaAgregar));
    Assertions.assertFalse(guardarropas.getPropuestasAceptadas().contains(propuestaAgregar));
    Assertions.assertFalse(guardarropas.getPrendas().contains(prenda1));
  }

  @Test
  public void aceptarPropuestaQuitarPrenda() {
    guardarropas.agregarPrenda(prenda2);
    guardarropas.agregarPropuesta(propuestaQuitar);
    guardarropas.aceptarPropuesta(propuestaQuitar);
    Assertions.assertFalse(guardarropas.getPropuestas().contains(propuestaQuitar));
    Assertions.assertTrue(guardarropas.getPropuestasAceptadas().contains(propuestaQuitar));
    Assertions.assertFalse(guardarropas.getPrendas().contains(prenda2));
  }

  @Test
  public void deshacerPropuestaQuitarPrenda() {
    guardarropas.agregarPrenda(prenda2);
    guardarropas.agregarPropuesta(propuestaQuitar);
    guardarropas.aceptarPropuesta(propuestaQuitar);
    guardarropas.deshacerPropuesta(propuestaQuitar);
    Assertions.assertFalse(guardarropas.getPropuestas().contains(propuestaQuitar));
    Assertions.assertFalse(guardarropas.getPropuestasAceptadas().contains(propuestaQuitar));
    Assertions.assertTrue(guardarropas.getPrendas().contains(prenda2));
  }
}
