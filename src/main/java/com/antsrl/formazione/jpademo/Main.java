package com.antsrl.formazione.jpademo;

import com.antsrl.formazione.jpademo.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple_jpa_demo");
            EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            try{

                entityManager.getTransaction().begin();

                doPersistenceStuff(entityManager);

                entityManager.getTransaction().commit();

            } catch(Exception e){

                entityManager.getTransaction().rollback();

                e.printStackTrace();
            }

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    private static void doPersistenceStuff(EntityManager entityManager) {

        entityManager.persist(Book.builder()
                .Id(67L)
                .title("nice book")
                .anything("a value 1")
                .build());

        entityManager.persist(Book.builder()
                .Id(69L)
                .title("good book")
                .anything("a value 2")
                .build());

        entityManager.persist(Book.builder()
                .Id(890L)
                .title("wonderful book")
                .anything("a value 3")
                .build());

    }
}
