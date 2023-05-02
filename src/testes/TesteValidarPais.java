/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testes;

import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import model.Pais;

/**
 *
 * @author Administrador
 */
public class TesteValidarPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        p.setNome("Uruguai");
        p.setIso("URU");
        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(p);
        if (erros.size() > 0){
            for (ConstraintViolation<Pais> erro : erros){
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
           em.persist(p);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
