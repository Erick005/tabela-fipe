package br.com.estudo.tabelafipe.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosVeiculos(List<DadosVeiculos> modelos) {
}
