/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name= "TB_VEICULO")
public class Veiculo implements Serializable {
    
    @Id 
    private String placa;
    
    @Column(name = "TXT_TIPO_VEICULO")
    private String tipo_veiculo;
    @Column(name = "TXT_FABRICANTE")
    private String fabricante;
    @Column(name = "TXT_MODELO")
    private String modelo;
    @Column(name = "TXT_CHASSI")
    private String chassi;
    @Column(name = "TXT_ANO_VEICULO")
    private String ano_veiculo;
    @Column(name = "TXT_PROPRIETARIO") 
    private String proprietario;
    @Column(name = "TXT_COR") 
    private String cor;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="TB_VEICULO_CONDUTOR", joinColumns = {
        @JoinColumn (name = "ID_VEICULO_PLACA")},
            inverseJoinColumns = {
                @JoinColumn (name = "ID_VEICULO_CONDUTOR ")})
            
    private List<Condutor> condutor;

    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(String tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAno_veiculo() {
        return ano_veiculo;
    }

    public void setAno_veiculo(String ano_veiculo) {
        this.ano_veiculo = ano_veiculo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Condutor> getCondutor() {
        return condutor;
    }

    public void setCondutor(List<Condutor> condutor) {
        this.condutor =  condutor;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", tipo_veiculo=" + tipo_veiculo + ", fabricante=" + fabricante + ", modelo=" + modelo + ", chassi=" + chassi + ", ano_veiculo=" + ano_veiculo + ", proprietario=" + proprietario + ", cor=" + cor + ", condutor=" + condutor + '}';
    }
    
}
