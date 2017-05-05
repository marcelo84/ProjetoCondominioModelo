package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marcelo
 */
public class TestePersistirCondominio {

    
    EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirCondominio() {
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
    public void teste() {
        boolean exception = false;
        try {
            Condominio c = new Condominio();
            c.setNome("São Judas Tadeu");
            c.setEndereco("Rua Anchieta");
            c.setNumero("236");
            c.setCep("6768798658");
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(true, exception);
    }

}