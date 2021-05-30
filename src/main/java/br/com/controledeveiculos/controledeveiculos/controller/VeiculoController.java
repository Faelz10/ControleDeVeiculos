package br.com.controledeveiculos.controledeveiculos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeveiculos.controledeveiculos.entidades.Veiculos;
import br.com.controledeveiculos.controledeveiculos.error.ResourceNotFoundException;
import br.com.controledeveiculos.controledeveiculos.repositorios.VeiculosRepo;
import br.com.controledeveiculos.controledeveiculos.services.VeiculosService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

  @Autowired
  private VeiculosRepo veiculosRepo;

  @Autowired
  private VeiculosService veiculosService;

  @GetMapping
  public ResponseEntity<List<Veiculos>> listCarros() {

   try {
      List<Veiculos> retornoVeiculos = veiculosRepo.findAll();

      return new ResponseEntity<>(retornoVeiculos, HttpStatus.OK);
    } catch (Exception e) {
      throw new ResourceNotFoundException("Nenhum veiculo encontrado");
    }
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Veiculos> addVeiculos(@Valid @RequestBody Veiculos veiculos) {

    try {
      Veiculos retornoVeiculos = veiculosService.postVeiculos(veiculos);

      return new ResponseEntity<>(retornoVeiculos, HttpStatus.CREATED);
    } catch (Exception e) {
      throw new ResourceNotFoundException(e.getMessage());
    }

  }
}
