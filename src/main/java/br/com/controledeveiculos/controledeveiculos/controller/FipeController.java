package br.com.controledeveiculos.controledeveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeveiculos.controledeveiculos.entidades.Fipe;
import br.com.controledeveiculos.controledeveiculos.services.FipeService;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    @Autowired
    private FipeService fipeService;

    @GetMapping("/marcas")
    public ResponseEntity<List<Fipe>> listMarcas() {
        try {
            List<Fipe> fipe = fipeService.buscaMarcas();
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos")
    public ResponseEntity<Fipe> listModelos(@PathVariable String marca) {
        try {
            Fipe fipe = fipeService.buscaModelos(marca);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos/{modelo}/anos")
    public ResponseEntity<List<Fipe>> listAno(@PathVariable String marca, @PathVariable String modelo) {
        try {
            List<Fipe> fipe = fipeService.buscaAnos(marca, modelo);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/marcas/{marca}/modelos/{modelo}/anos/{ano}")
    public ResponseEntity<Fipe> listAll(@PathVariable String marca, @PathVariable String modelo,
            @PathVariable String ano) {
        try {
            Fipe fipe = fipeService.buscaInfoVeiculos(marca, modelo, ano);
            return ResponseEntity.ok().body(fipe);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}