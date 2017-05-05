/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "aluguel")
// anotação que deve ser usada para quem fornece herança
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluguel implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double valor;
    @NotNull(message = "O inicioContrato deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inicioContrato", nullable = false)
    private Calendar inicioContrato;
    @NotNull(message = "O fimContrato deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fimContrato", nullable = false)
    private Calendar fimContrato;
    @NotNull(message = "O dia de vencimento deve ser informada")
    @Column(name = "diaVencimento", nullable = false)
    private Integer diaVencimento;
    @NotNull(message = "O locatario não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_locatario_id")
    private Locatario locatario;
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY) 
    
    private List<Mensalidade> mensalidades = new ArrayList<>();

    public Aluguel() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Mensalidade> getMensalidade() {
        return mensalidades;
    }

    public void setMensalidade(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    
}
