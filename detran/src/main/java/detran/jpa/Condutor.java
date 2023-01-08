/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author keiza
 */
@Entity
@Table(name = "TB_CONDUTOR")
@DiscriminatorValue(value= "C")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "id")
public class Condutor extends Usuario implements Serializable  {
   
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_CNH", referencedColumnName = "ID")
    private Cnh cnh;
    @Column(name = "TXT_OBSERVACAO")
    private String observacao;
    @Column(name = "TXT_PONTUACAO")
    private String pontuacao;
    @Column(name = "TXT_LOCAL")
    private String local;
    @OneToMany(mappedBy = "condutor", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Multa> multas;

    public Cnh getCnh() {
        return cnh;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
        this.cnh.setCondutor(this);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    } 

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }
    
    public void adicionar(Multa multa) {
        if (this.multas == null) {
            this.multas = new ArrayList<>();
        }

        this.multas.add(multa);
        multa.setCondutor(this);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Condutor)) {
            return false;
        }
        Condutor other = (Condutor) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "exemplo.jpa.Condutor[ id=" + id + " ]";
    }   
}
