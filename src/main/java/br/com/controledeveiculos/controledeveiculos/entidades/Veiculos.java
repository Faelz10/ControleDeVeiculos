package br.com.controledeveiculos.controledeveiculos.entidades;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "veiculos")
public class Veiculos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "ano não pode ser nulo")
    @NotEmpty(message = "ano não pode ser vazio")
    @Column(name = "ano", nullable = false)
    private String ano;

    @NotNull(message = "marca não pode ser nulo")
    @NotEmpty(message = "marca não pode ser vazio")
    @Column(name = "marca", nullable = false)
    private String marca;

    @NotNull(message = "modelo não pode ser nulo")
    @NotEmpty(message = "modelo não pode ser vazio")
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "valor", nullable = false)
    private String valor;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario_cpf")
    private Usuarios usuarios;

    @Transient
    private String rodizio;

    @Transient
    private boolean rodizioAtivo;

    public String getRodizio() {
        char ultimoDigito = this.ano.charAt(this.ano.length() - 1);
        if (ultimoDigito == '0' || ultimoDigito == '1') {
            this.rodizio = "Segunda-Feira";
        } else if (ultimoDigito == '2' || ultimoDigito == '3') {
            this.rodizio = "Terça-Feira";
        } else if (ultimoDigito == '4' || ultimoDigito == '5') {
            this.rodizio = "Quarta-Feira";
        } else if (ultimoDigito == '6' || ultimoDigito == '7') {
            this.rodizio = "Quinta-Feira";
        } else if (ultimoDigito == '8' || ultimoDigito == '9') {
            this.rodizio = "Sexta-Feira";
        }

        return this.rodizio;
    }

    public Boolean getRodizioAtivo() {
        char ultimoDigito = this.ano.charAt(this.ano.length() - 1);
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case Calendar.MONDAY:
                if (ultimoDigito == '0' || ultimoDigito == '1') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.TUESDAY:
                if (ultimoDigito == '2' || ultimoDigito == '3') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.WEDNESDAY:
                if (ultimoDigito == '4' || ultimoDigito == '5') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.THURSDAY:
                if (ultimoDigito == '6' || ultimoDigito == '7') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.FRIDAY:
                if (ultimoDigito == '8' || ultimoDigito == '9') {
                    this.rodizioAtivo = true;
                }
                break;
            default:
                this.rodizioAtivo = false;
        }
    
        return this.rodizioAtivo;

    }

}
