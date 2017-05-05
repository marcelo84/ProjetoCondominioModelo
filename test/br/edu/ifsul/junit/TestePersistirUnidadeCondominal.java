package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominal;
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
public class TestePersistirUnidadeCondominal {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUnidadeCondominal() {
        
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
        try{
            UnidadeCondominal uc = em.find(UnidadeCondominal.class, 1);
            Condominio c = new Condominio();
            uc.setNumero("177");
            uc.setDescricao("Preto");
            uc.setArea(47.00);
            uc.setNumeroQuarto(765);
            em.getTransaction().begin();
            em.persist(uc);
            em.getTransaction().commit();
        }catch(Exception e){
            resultado = true;
            e.printStackTrace();
        }
        //aqui verifica se o resultado que ocorreu é igual ao esperado 
        Assert.assertEquals(true, resultado);
            
    }
    
}
