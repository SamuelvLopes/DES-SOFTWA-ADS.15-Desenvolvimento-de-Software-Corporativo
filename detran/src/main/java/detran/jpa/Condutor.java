/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author keiza
 */
@Entity
@Table(name = "TB_CONDUTOR")
@DiscriminatorValue(value= "c")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "id")
public class Condutor extends Usuario implements Serializable  {
    
   /**@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_condutor;   **/ 
   
    @Column(name = "TXT_CNH")
    private String cnh;
    @Column(name = "TXT_VALIDADE")
    private Date validade;
    @Column(name = "TXT_OBSERVCAO")
    private String observacao;
    @Column(name = "TXT_PONTUACAO")
    private String pontuacao;
    @Column(name = "TXT_LOCAL")
    private String local;



    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
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

   @Override
    public Long getId() {
        return id;
    }

   @Override
    public void setId(Long id) {
        this.id = id;
    }

   @Override
    public String getNome() {
        return nome;
    }

   
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

   @Override
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

   @Override
    public Collection<String> getTelefones() {
        return telefones;
    }

   @Override
    public void setTelefones(Collection<String> telefones) {
        this.telefones = telefones;
    }

    /**
     *
     * @return
     */
    @Override
    public String getCpf() {
        return cpf;
    }

   @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
