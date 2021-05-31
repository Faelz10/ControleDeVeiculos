package br.com.controledeveiculos.controledeveiculos.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @NotNull(message = "cpf não pode ser nulo")
    @NotEmpty(message = "cpf não pode ser vazio")
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @NotNull(message = "nascimento não pode ser nulo")
    @Column(name = "nascimento", nullable = false)
    private Date nascimento;

    @NotNull(message = "email não pode ser nulo")
    @NotEmpty(message = "email não pode ser vazio")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "nome não pode ser nulo")
    @NotEmpty(message = "nome não pode ser vazio")
    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE })
    @JsonManagedReference
    private List<Veiculos> veiculo = new ArrayList<Veiculos>();

}
