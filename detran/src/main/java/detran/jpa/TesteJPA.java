package detran.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author keiza
 */
public class TesteJPA {
     public static void main(String[] args) {
        
        Condutor c = criarCondutor();
        Veiculo v1 = new Veiculo();
        
        v1.setCondutores(Arrays.asList(c));
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            //EntityManagerFactory realiza a leitura das informações relativas à "persistence-unit".
            emf = Persistence.createEntityManagerFactory("detran_project");
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
            em.persist(c);
            em.persist(v1);
            et.commit();
        } catch (Exception ex) {
            throw ex;
            //if (et != null)
               // et.rollback();
        } finally {
            if (em != null)
                em.close();       
            if (emf != null)
                emf.close();
        }
    }
    
    private static Condutor criarCondutor() {
        Condutor condutor = new Condutor();
        condutor.setNome("Fulano da Silva");
        condutor.setEmail("fulano@gmail.com");
        condutor.setCpf("534.585.764-45");
        condutor.addTelefone("(81) 3456-2525");
        condutor.addTelefone("(81) 9122-4528");
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
}

