package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "recurso")
public class Recurso implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_recurso", 
            sequenceName = "seq_recurso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message="A descricao nao pode ser nulo")
    @NotBlank(message="A descricao nao pode ser em branco")
    @Length(max=50, message="A descricao nao pode ter mais de {max} caracteres")
    @Column(name="descricao", length= 50, nullable=false)
    private String descricao;
    @ManyToMany
    @JoinTable(name="recursar", joinColumns= @JoinColumn(name="recurso", referencedColumnName="id", 
          nullable=false),inverseJoinColumns= @JoinColumn(name="condominio", referencedColumnName="id", nullable=false))
    private List<Condominio> recursar= new ArrayList<>();

    public Recurso() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
     public List<Condominio> getRecursar() {
        return recursar;
    }

    public void setRecursar(List<Condominio> recursar) {
        this.recursar = recursar;
    }

 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}


  
  