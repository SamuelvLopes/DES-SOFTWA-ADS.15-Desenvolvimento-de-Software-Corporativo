package detran.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author keiza
 */
public class TesteJPA {
     public static void main(String[] args) {
        
        Condutor c = new Condutor();
        Condutor c2 = new Condutor();
        Veiculo v1 = new Veiculo();
        v1.setPlaca("12344");
        
        v1.setCondutor(Arrays.asList(c,c2));
         
        preencherUsuario(c);
        preencherUsuario(c2);
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
            em.persist(c2);
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

    private static void preencherUsuario(Condutor c) {
        c.setNome("Fulano da Silva");
        c.setEmail("fulano@gmail.com");
        c.setCnh("41257489561");
        

    }
    
    
    
}

