/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author root
 */
public class Cnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;  
    @OneToOne(mappedBy = "Cnh", optional = false, fetch = FetchType.LAZY)
    private Condutor condutor;
    @Column(name = "TXT_CATEGORIA_CNH", nullable = false, length = 20)
    private CategoriaCnh tipo;
    @Column(name = "DT_VALIDADE")
    private Date dataValidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public CategoriaCnh getTipo() {
        return tipo;
    }

    public void setTipo(CategoriaCnh tipo) {
        this.tipo = tipo;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cnh other = (Cnh) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.condutor, other.condutor)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return Objects.equals(this.dataValidade, other.dataValidade);
    }
    
    
    
}
