package dominio;

import dominio.atuendos.Borrador;
import dominio.atuendos.Guardarropas;
import dominio.atuendos.Prenda;
import dominio.atuendos.caracteristicas.Categoria;
import dominio.atuendos.caracteristicas.Color;
import dominio.atuendos.caracteristicas.Formalidad;
import dominio.atuendos.caracteristicas.Material;
import dominio.atuendos.caracteristicas.TipoDePrenda;
import dominio.clima.Temperatura;

public class TallerDePrendas {

  public static Prenda anteojosNaranja(Formalidad form) {
    Color naranjaClarito = new Color(255, 188, 66);
    TipoDePrenda anteojos = new TipoDePrenda(Categoria.ACCESORIO);
    return getPrenda(anteojos, naranjaClarito, form);
  }

  public static Prenda zapatillasNaranja(Formalidad form) {
    Color naranjaClarito = new Color(255, 188, 66);
    TipoDePrenda zapatillas = new TipoDePrenda(Categoria.CALZADO);
    return getPrenda(zapatillas, naranjaClarito, form);
  }

  public static Prenda pantalonAzul(Formalidad form) {
    Color azul = new Color(240, 248, 255);
    TipoDePrenda pantalon = new TipoDePrenda(Categoria.PARTE_INFERIOR);
    return getPrenda(pantalon, azul, form);
  }

  public static Prenda remeraAzul(Formalidad form) {
    Color azul = new Color(240, 248, 255);
    TipoDePrenda remera = new TipoDePrenda(Categoria.PARTE_SUPERIOR);
    return getPrenda(remera, azul, form);
  }

  public static Prenda getPrenda(TipoDePrenda tipo, Color col, Formalidad form) {
    Borrador borrador = new Borrador();
    borrador.setTipoDePrenda(tipo);
    borrador.setMaterial(Material.ALGODON);
    borrador.setColorPrimario(col);
    borrador.setFormalidad(form);
    borrador.setTemperatura(Temperatura.CALOR);
    return borrador.build();
  }

  public static Guardarropas generarGuardarropasFormalidad(Formalidad formalidad) {
    Guardarropas guardarropas = new Guardarropas();
    guardarropas.agregarPrenda(TallerDePrendas.anteojosNaranja(formalidad));
    guardarropas.agregarPrenda(TallerDePrendas.zapatillasNaranja(formalidad));
    guardarropas.agregarPrenda(TallerDePrendas.pantalonAzul(formalidad));
    guardarropas.agregarPrenda(TallerDePrendas.remeraAzul(formalidad));
    return guardarropas;
  }

}
