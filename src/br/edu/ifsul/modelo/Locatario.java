/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author Marcelo
 */
@Entity
@Table(name="locatario")
public class Locatario extends Pessoa implements Serializable {
    
    @NotNull(message = "A renda deve ser informado")
    @Column(name = "renda", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double renda;
    @NotNull(message = "O local de trabalho não pode ser nulo")
    @NotBlank(message = "O local de trabalho não pode ser em branco")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")  
    @Column(name = "localTrabalho", nullable = false, length = 50)
    private String localTrabalho;
    @NotNull(message = "O telefone de trabalho não pode ser nulo")
    @NotBlank(message = "O telefone de trabalho não pode ser em branco")
    @Length(max = 15, message = "O telefone de trabalho não pode ter mais que {max} caracteres")  
    @Column(name = "telefoneTrabalho", nullable = false, length = 15)
    private String telefoneTrabalho;
    
    public Locatario() {
         
    } 
    
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

}


    
  
    
    