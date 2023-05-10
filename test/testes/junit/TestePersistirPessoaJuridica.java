/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testes.junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import model.PessoaJuridica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Administrador
 */
public class TestePersistirPessoaJuridica {
    
    EntityManager em;
    
    public TestePersistirPessoaJuridica() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try{
            PessoaJuridica pf = new PessoaJuridica();
            pf.setCnpj("68.023.466/0001-46");
            pf.setEmail("companhia-son@gmail.com");
            pf.setNome("Companhia Son");
            pf.setIe("1234678911111");
            pf.setTelefone("(22)9879-4591");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
