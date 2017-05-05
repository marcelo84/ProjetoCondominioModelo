package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "unidadeCondominal")
// anotação que deve ser usada para quem fornece herança
@Inheritance(strategy = InheritanceType.JOINED)
public class UnidadeCondominal implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_unidadecondominal", sequenceName = "seq_unidadecondominal_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_unidadecondominal", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O numero não pode ser nulo")
    @Length(max = 20, message = "O numero não pode ter mais de {max} caracteres")
    @NotBlank(message = "O numero não pode ser em branco")
    @Column(name = "numero", length = 20, nullable = false)
    private String numero;
    @NotNull(message = "A descricao não pode ser nulo")
    @NotBlank(message = "A descricao não pode ser em branco")
    @Length(max = 50, message = "A descricao não pode ter mais que {max} caracteres")  
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @NotNull(message = "A area deve ser informado")
    @Column(name = "area", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double area;
    @NotNull(message = "O numero do quarto deve ser informada")
    @Column(name = "numeroQuarto", nullable = false)
    private Integer numeroQuarto;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    @NotNull(message = "A condominio deve ser informada")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidadecondominal_condominio_id")  
    private Condominio condominio;
    

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
    
    public UnidadeCondominal(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominal other = (UnidadeCondominal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}



  
   
    
    

    