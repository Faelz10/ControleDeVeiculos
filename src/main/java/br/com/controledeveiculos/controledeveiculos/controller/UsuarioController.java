package br.com.controledeveiculos.controledeveiculos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controledeveiculos.controledeveiculos.entidades.Usuarios;
import br.com.controledeveiculos.controledeveiculos.error.ResourceNotFoundException;
import br.com.controledeveiculos.controledeveiculos.repositorios.UsuariosRepo;
import br.com.controledeveiculos.controledeveiculos.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuariosService usuariosService;

  @Autowired
  private UsuariosRepo usuariosRepo;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Usuarios> addUsuarios(@Valid @RequestBody Usuarios usuarios) throws Exception {

    try {
      Usuarios retornoUsuarios = usuariosService.postUsuarios(usuarios);

      return new ResponseEntity<>(retornoUsuarios, HttpStatus.CREATED);
    } catch (Exception e) {

      throw new ResourceNotFoundException(e.getMessage());
    }
  }

  @GetMapping("/{cpf}")
  public ResponseEntity<Usuarios> getUsuarioscpf(@Valid @PathVariable String cpf) {
    Usuarios usuario = usuariosRepo.findByCpf(cpf)
        .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado! Cpf: " + cpf));

    return new ResponseEntity<>(usuario, HttpStatus.OK);

  }

}
