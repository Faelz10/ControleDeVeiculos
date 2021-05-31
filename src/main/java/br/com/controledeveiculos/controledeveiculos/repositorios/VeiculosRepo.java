package br.com.controledeveiculos.controledeveiculos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controledeveiculos.controledeveiculos.entidades.Veiculos;

@Repository
public interface VeiculosRepo extends JpaRepository<Veiculos, Long> {

}