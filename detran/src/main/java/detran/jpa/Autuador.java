/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author danielcardoso
 */
@Entity
@Table(name = "TB_AUTUADOR")
@DiscriminatorValue(value= "a")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "id")
public class Autuador extends Usuario implements Serializable{
    
    /**@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_condutor;   **/ 
   
    @Column(name = "TXT_ORGAO")
    private String orgao;
    @Column(name = "TXT_ZONA_ATUACAO")
    private String zona_atuacao;
    @Column(name = "TXT_CIDADE")
    private String cidade;
    @Column(name = "TXT_ESTADO")
    private String estado;
    @Column(name = "TXT_ADMISSAO")
    private String admissao;

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getZona_atuacao() {
        return zona_atuacao;
    }

    public void setZona_atuacao(String zona_atuacao) {
        this.zona_atuacao = zona_atuacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdmissao() {
        return admissao;
    }

    public void setAdmissao(String admissao) {
        this.admissao = admissao;
    }

    @Override
    public String toString() {
        return "Autuador{" + "orgao=" + orgao + ", zona_atuacao=" + zona_atuacao + ", cidade=" + cidade + ", estado=" + estado + ", admissao=" + admissao + '}';
    }
    
}
