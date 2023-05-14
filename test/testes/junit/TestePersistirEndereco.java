/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testes.junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import model.Endereco;
import model.PessoaFisica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Administrador
 */
public class TestePersistirEndereco {
    
    EntityManager em;
    
    public TestePersistirEndereco() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Endereco e = new Endereco();
            e.setBairro("Lagomar");
            e.setCep("27966-500");
            e.setComplemento("Travessa 3");
            e.setEndereco("Avenida Theodomiro Bittencourt");
            e.setNickname("Casa");
            e.setNumero("06");
            e.setReferencia("Entre a W24 e a W26");
            
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
