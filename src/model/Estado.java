/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name="estado")
public class Estado implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seqestado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;
    @Length(max = 2, message = "A UF não pode ter mais de {max} caracteres")
    @NotBlank(message = "A UF deve ser informado")
    @NotNull(message = "A UF não pode ser nula")
    private String uf;
    @NotNull(message = "O País deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name="fk_pais")
    private Pais pais;

    public Estado() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }

}
