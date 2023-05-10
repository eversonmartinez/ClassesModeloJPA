/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testes.junit;

import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import model.Estado;
import model.Pais;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Administrador
 */
public class TestePersistirEstado {
    
    EntityManager em;
    
    public TestePersistirEstado() {
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
            Estado e = new Estado();
            e.setNome("Rio de Janeiro");
            e.setUf("RJ");
            e.setPais(em.find(Pais.class, 1));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
