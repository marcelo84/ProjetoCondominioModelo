package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcelo
 */
public class TestePersistirRecurso {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirRecurso() {
        
    }
    
    @Before
    public void setUp() {
         emf = Persistence.createEntityManagerFactory("DAW-2017-1-5m1-condominio");
         em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean resultado = false;
        try {
            Recurso r = new Recurso();
            Condominio c = new Condominio();
            r.setDescricao("Preto");
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e){
            resultado = true;
            e.printStackTrace();
        }
        // aqui verifico se o resultado que ocorreu é igual ao esperado
        Assert.assertEquals(true, resultado);
    }

}
