package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidade;
import java.util.Calendar;
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
public class TestePersistirMensalidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMensalidade() {
        
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
            Mensalidade m = new Mensalidade();
            Aluguel a = em.find(Aluguel.class, 9);
            //informar os dados da mensalidade
            m.setValor(980.00);
            m.setVencimento(Calendar.getInstance());
            m.setValorPagamento(1000.00);
            m.setDataPagamento(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        }catch(Exception e){
            resultado = true;
            e.printStackTrace();
        }
        //aqui verifica se o resultado que ocorreu é igual ao esperado 
        Assert.assertEquals(true, resultado);
            
    }
    
}
