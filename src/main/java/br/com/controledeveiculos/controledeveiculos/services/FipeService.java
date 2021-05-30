package br.com.controledeveiculos.controledeveiculos.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.controledeveiculos.controledeveiculos.entidades.Fipe;

@FeignClient(url = "https://parallelum.com.br/fipe/api/v1/carros/", name ="fipe")
public interface FipeService {
    @GetMapping("marcas")
    public List<Fipe> buscaMarcas();

    @GetMapping("marcas/{marca}/modelos")
    public Fipe buscaModelos(@PathVariable("marca") String marca);

    @GetMapping("marcas/{marca}/modelos/{modelo}/anos")
    public List<Fipe> buscaAnos(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo);

    @GetMapping("marcas/{marca}/modelos/{modelo}/anos/{ano}")
    public Fipe buscaInfoVeiculos(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo,
            @PathVariable("ano") String ano);
}
