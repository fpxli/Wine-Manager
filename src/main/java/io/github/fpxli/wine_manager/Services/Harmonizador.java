package io.github.fpxli.wine_manager.Services;

import java.util.List;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;

public interface Harmonizador<T> {
    List<T> sugerirBebidas(TipoComida comida);

    List<TipoComida> sugerirComidas(T bebida);
}