/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author danielcardoso
 */
@Entity
@Table(name = "TB_MULTA")
public class Multa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.PERSIST )
    @JoinColumn(name = "ID_VEICULO_PLACA", referencedColumnName = "ID")
    private Veiculo veiculo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CONDUTOR", referencedColumnName = "ID")
    private Condutor condutor;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_AUTUADOR", referencedColumnName = "ID")
    private Autuador autuador;
    
    @Column(name = "DATA_MULTA")
    private Date data_multa;
    
    @Column(name = "INT_VALOR")
    private int valor;
    
    @Column(name = "TXT_DESCRICAO")
    private String descricao;
    
    @Column(name = "TXT_INFRACAO")
    private String infracao;
    
    @Column(name = "TXT_LOCAL")
    private String local;

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Autuador getAutuador() {
        return autuador;
    }

    public void setAutuador(Autuador autuador) {
        this.autuador = autuador;
    }

    public Date getData_multa() {
        return data_multa;
    }

    public void setData_multa(Date data_multa) {
        this.data_multa = data_multa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInfracao() {
        return infracao;
    }

    public void setInfracao(String infracao) {
        this.infracao = infracao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "exemplo.jpa.Multa[ id=" + id + " ]";
    } 
}
