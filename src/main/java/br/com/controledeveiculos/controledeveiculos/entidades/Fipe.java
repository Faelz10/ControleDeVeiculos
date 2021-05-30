package br.com.controledeveiculos.controledeveiculos.entidades;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Fipe {

    private String nome;
    private String codigo;
    private ArrayList<Object> modelos = new ArrayList<Object>();
    private ArrayList<Object> anos = new ArrayList<Object>();

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("AnoModelo")
    private String ano;

    @JsonProperty("Valor")
    private String valor;


}
