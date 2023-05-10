/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testes.junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import jpa.EntityManagerUtil;
import model.PessoaFisica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Administrador
 */
public class TestePersistirPessoaFisica {
    
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("629.659.150-01");
            pf.setEmail("everson_email@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Everson Miranda");
            pf.setNomeUsuario("everson");
            pf.setRg("8927384742");
            pf.setSenha("everson");
            pf.setTelefone("(22)9999-5491");
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
