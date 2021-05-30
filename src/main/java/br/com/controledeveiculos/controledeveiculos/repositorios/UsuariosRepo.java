package br.com.controledeveiculos.controledeveiculos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeveiculos.controledeveiculos.entidades.Usuarios;

@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, String> {

    Optional<Usuarios> findByCpf(String cpf);
    Optional<Usuarios> findByEmail(String email);

    

}