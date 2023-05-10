/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "pessoa_juridca")
public class PessoaJuridica extends Pessoa implements Serializable{
    @NotNull(message = "A ie não pode ser nulo")
    @NotBlank(message = "A ie não pode ser em branco")
    @Length(max = 14, message = "A ie não pode ter mais de {max} caracteres")
    @Column(name = "IE", length=14, nullable=false)
    private String ie;
    @NotNull(message = "O cnpj não pode ser nulo")
    @NotBlank(message = "O cnpj não pode ser em branco")
    @Length(max = 18, message = "O cnpj não pode ter mais de {max} caracteres")
    @CNPJ(message = "O CNPJ deve ser válido")
    @Column(name = "CNPJ", length=18, nullable=false)
    private String cnpj;
   
    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
