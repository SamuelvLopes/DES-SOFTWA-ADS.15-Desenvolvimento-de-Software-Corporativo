/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detran.jpa;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author danielcardoso
 */
public class MultaTeste extends Teste {
    
    @Test
    public void persistirMulta() {
        Multa multa = criarMulta();

        em.persist(multa);
        em.flush();
        
        Assert.assertNotNull(multa.getId());
    }
    
    public static Condutor criarCondutor() {
        Condutor condutor = new Condutor();
        condutor.setId(Long.valueOf(10));
        condutor.setNome("Fulano da Silva");
        condutor.setEmail("fulano@gmail.com");
        condutor.setCpf("534.585.764-45");
        condutor.addTelefone("(81) 3456-2525");
        condutor.addTelefone("(81) 9122-4528");
        condutor.setLocal("Recife");
        condutor.setObservacao("***");
        condutor.setPontuacao("7");
        criarEndereco(condutor);
        criarCNH(condutor);
        
        return condutor;
    }
    
    public static void criarEndereco(Usuario usuario) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Iolanda Rodrigues Sobral");
        endereco.setBairro("Iputinga");
        endereco.setCidade("Recife");
        endereco.setEstado("Pernambuco");
        endereco.setCep("50690-220");
        endereco.setNumero(550);
        usuario.setEndereco(endereco);
    }
    
    public static void criarCNH(Condutor condutor) {
        Cnh cnh = new Cnh();
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2025);
        c.set(Calendar.MONTH, Calendar.FEBRUARY);
        c.set(Calendar.DAY_OF_MONTH, 25);
        
        cnh.setDataValidade(c.getTime());
        cnh.setTipo(CategoriaCnh.B);
        
        try {
            BufferedImage img = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/7778/7778185.png"));
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                ImageIO.write(img, "png", baos);
                baos.flush();
                cnh.setFoto(baos.toByteArray());
            }
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, null, ex);
        }
        
        condutor.setCnh(cnh);
        
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
    
    public Veiculo criarVeiculo() {
        
        Veiculo veiculo = new Veiculo();
        veiculo.setId(Long.valueOf(20));
        veiculo.setTipo_veiculo("Fox");
        veiculo.setFabricante("Volkswagen");
        veiculo.setModelo("4 portas");
        veiculo.setChassi("dkfhsd2gs71ds5s");
        veiculo.setAno_veiculo("2022");
        veiculo.setProprietario("Ciclano da silva");
        veiculo.setCor("Preto");
        Condutor condutor = criarCondutor();
        veiculo.adicionarCondutor(condutor);
        
        return veiculo;
    }
    public Multa criarMulta() {
        
       Multa multa = new Multa();
       
       Veiculo veiculo = criarVeiculo();
       
       multa.setVeiculo(veiculo);
       
       Condutor condutor = criarCondutor();
       multa.setCondutor(condutor);
       
       Autuador autuador = criarAutuador();
       
       multa.setAutuador(autuador);
       
       Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2025);
        c.set(Calendar.MONTH, Calendar.FEBRUARY);
        c.set(Calendar.DAY_OF_MONTH, 25);
       multa.setData_multa( c.getTime());
        multa.setValor(123);
        multa.setDescricao("Estacionamento em local indevido");
        multa.setInfracao("grave");
        multa.setLocal("AV. Recife");
        
        return multa;
    }
    
    
}
