/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author danielcardoso
 */
public class AutuadorTeste extends Teste {
    
    @Test
    public void persistirAutuador() {
        Autuador autuador = criarAutuador();

        em.persist(autuador);
        em.flush();
        
        Assert.assertNotNull(autuador.getId());
    }
    
    public Autuador criarAutuador() {
        
        Autuador autuador = new Autuador();

        autuador.setNome("Autuador da Silva");
        autuador.setEmail("autuador.da.silva@gmail.com");

        Endereco endereco = new Endereco();
        endereco.setBairro("Varzea");
        endereco.setCep("50770-340");
        endereco.setLogradouro("Avenida Professor Moraes Rego");
        endereco.setEstado("Pernambuco");
        endereco.setNumero(40);
        endereco.setCidade("Recife");

        autuador.setEndereco(endereco);
//      adicionar os telefones
        autuador.setCpf("526.594.890-25");
        
        autuador.setOrgao("Detran");
        autuador.setZona_atuacao("Varzea");
        autuador.setCidade("Recife");
        autuador.setEstado("Pernambuco");
        
        return autuador;
    }
}
