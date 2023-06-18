package dominio;

import dominio.atuendos.Atuendo;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Formalidad;
import excepciones.AtuendoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AtuendoTest {
  static Prenda remeraAzul;
  static Prenda pantalonAzul;
  static Prenda anteojosNaranja;
  static Prenda zapatillasNaranja;

  @BeforeAll
  static void setUp() {
    remeraAzul = TallerDePrendas.remeraAzul(Formalidad.INFORMAL);
    pantalonAzul = TallerDePrendas.pantalonAzul(Formalidad.INFORMAL);
    anteojosNaranja = TallerDePrendas.anteojosNaranja(Formalidad.INFORMAL);
    zapatillasNaranja = TallerDePrendas.zapatillasNaranja(Formalidad.INFORMAL);
  }

  @Test
  public void seInstancianLosAtuendosConTodosLosParametrosCorrectos() {
    Atuendo unAtuendo = new Atuendo(remeraAzul, pantalonAzul, zapatillasNaranja);
    unAtuendo.setAccesorios(anteojosNaranja);
    Assertions.assertNotNull(unAtuendo);
  }

  @Test
  public void laCategoriaSeCondiceConSuTipo() {
    Assertions.assertThrows(
        AtuendoException.class, () -> new Atuendo(anteojosNaranja, zapatillasNaranja, remeraAzul)
    );
  }
}
