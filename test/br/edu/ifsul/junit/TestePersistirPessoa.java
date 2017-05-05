package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.UnidadeCondominal;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirPessoa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPessoa() {
        
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
            Pessoa p = new Pessoa();
            p.setNome("José Abreu");
            p.setCpf("65423427856");
            p.setTelefone("(54)991542310");
            p.setEmail("jose.abreu@gmail.com");
            em.getTransaction().begin();//inicia uma transacao
            em.persist(p);//persiste o objeto e (Estado) no banco de dados
            em.getTransaction().commit();//finaliza e efetiva a transacao no banco de dados
        }catch(Exception e){
            resultado = true;
            e.printStackTrace();
        }
        //aqui verifica se o resultado que ocorreu é igual ao esperado 
        Assert.assertEquals(true, resultado);
            
    }
    
}
