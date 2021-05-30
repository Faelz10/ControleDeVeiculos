package br.com.controledeveiculos.controledeveiculos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controledeveiculos.controledeveiculos.entidades.Usuarios;
import br.com.controledeveiculos.controledeveiculos.repositorios.UsuariosRepo;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepo usuariosRepo;

	public Usuarios postUsuarios(Usuarios usuarios) throws Exception {
		Optional<Usuarios> usuariosExistent = usuariosRepo.findByCpf(usuarios.getCpf());
		Optional<Usuarios> usuariosEmailExistent = usuariosRepo.findByEmail(usuarios.getEmail());

		if ((usuariosExistent.isPresent())) {
			throw new Exception("CPF já cadastrado");
		} else if (usuariosEmailExistent.isPresent()){			
			throw new Exception("EMAIL já cadastrado.");
		} else{
			return usuariosRepo.save(usuarios);

		}
	}
}