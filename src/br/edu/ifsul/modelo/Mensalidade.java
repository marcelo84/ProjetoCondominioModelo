/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "mensalidade")
public class Mensalidade implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_mensalidade", sequenceName = "seq_mensalidade_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double valor;
    @NotNull(message = "O vencimento deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    @NotNull(message = "O valor do pagamento deve ser informado")
    @Column(name = "valorPagamento", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double valorPagamento;
    @NotNull(message = "A dataPagamento deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataPagamento", nullable = false)
    private Calendar dataPagamento;
    @NotNull(message = "O aluguel não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "aluguel", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_mensalidade_aluguel_id")
    private Aluguel aluguel;
    

    public Mensalidade() {
        
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

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Mensalidade other = (Mensalidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

