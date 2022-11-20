/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CNH")
@SecondaryTable(name = "TB_FOTO_USUARIO",
        pkJoinColumns = {
            @PrimaryKeyJoinColumn(name = "id")}
)
@Access(AccessType.FIELD)
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
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "IMG_FOTO", table = "TB_FOTO_USUARIO", nullable = true)
    private byte[] foto;

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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.condutor);
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + Objects.hashCode(this.dataValidade);
        hash = 79 * hash + Arrays.hashCode(this.foto);
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
        if (!Objects.equals(this.dataValidade, other.dataValidade)) {
            return false;
        }
        return Arrays.equals(this.foto, other.foto);
    }
       
}
