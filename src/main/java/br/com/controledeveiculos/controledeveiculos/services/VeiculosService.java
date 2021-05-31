package br.com.controledeveiculos.controledeveiculos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controledeveiculos.controledeveiculos.entidades.Fipe;
import br.com.controledeveiculos.controledeveiculos.entidades.Usuarios;
import br.com.controledeveiculos.controledeveiculos.entidades.Veiculos;
import br.com.controledeveiculos.controledeveiculos.repositorios.UsuariosRepo;
import br.com.controledeveiculos.controledeveiculos.repositorios.VeiculosRepo;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepo veiculosRepo;
    @Autowired
    private UsuariosRepo usuariosRepo;
    @Autowired
    private FipeService fipeService;
    private Fipe fipe;

    public Veiculos postVeiculos(Veiculos veiculos) throws Exception {
        Optional<Usuarios> usuariosExistent = usuariosRepo.findByCpf(veiculos.getUsuarios().getCpf());

        try {
            fipe = fipeService.buscaInfoVeiculos(veiculos.getMarca(), veiculos.getModelo(), veiculos.getAno());
        } catch (Exception e) {
            throw new Exception("Dados informados não conferem com dados da FIPE");
        }

        if (usuariosExistent.isPresent()) {

            Veiculos veiculoNovo = new Veiculos();
            veiculoNovo.setUsuarios(usuariosExistent.get());
            veiculoNovo.setMarca(fipe.getMarca());
            veiculoNovo.setAno(fipe.getAno());
            veiculoNovo.setModelo(fipe.getModelo());
            veiculoNovo.setValor(fipe.getValor());
            

            veiculosRepo.save(veiculoNovo);

            usuariosExistent.get().getVeiculo().add(veiculoNovo);

            return veiculoNovo;

        } else {
            throw new Exception("USUARIO NÃO CADASTRADO.");
        }
    }
}
