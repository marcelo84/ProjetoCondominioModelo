package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
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
public class TestePersistirAluguel {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAluguel() {
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
            Locatario l = em.find(Locatario.class, 2);
            Mensalidade m = new Mensalidade();
            Aluguel a = new Aluguel();
            a.setValor(980.00);
            a.setInicioContrato(Calendar.getInstance());
            a.setFimContrato(Calendar.getInstance());
            a.setDiaVencimento(10);
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e){
            resultado = true;
            e.printStackTrace();
        }
        //aqui verifica se o resultado que ocorreu é igual ao esperado 
        Assert.assertEquals(false, resultado);
            
    }
    
}
