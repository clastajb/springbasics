package com.antsrl.formazione.jpademo;

import com.antsrl.formazione.jpademo.domain.Book;
import com.antsrl.formazione.jpademo.domain.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple_jpa_demo");
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            try {

                entityManager.getTransaction().begin();

                doPersistenceStuff(entityManager);

                entityManager.getTransaction().commit();

            } catch (Exception e) {

                entityManager.getTransaction().rollback();

                e.printStackTrace();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void doPersistenceStuff(EntityManager entityManager) {

        entityManager.persist(Book.builder()
                .title("nice book")
                .anything("a value 10")
                .publishing(LocalDate.of(1984, 9, 23))
                .category(Category.COMEDY)
                .build());

        entityManager.persist(Book.builder()
                .title("good book")
                .anything("a value 20")
                .publishing(LocalDate.of(2020, 10, 31))
                .category(Category.FANTASY)
                .build());

        entityManager.persist(Book.builder()
                .title("wonderful book")
                .anything("a value 30")
                .publishing(LocalDate.of(2021, 3, 16))
                .category(Category.ROMANCE)
                .build());

        entityManager.persist(Book.builder()
                .title("nice book")
                .anything("a value 18")
                .publishing(LocalDate.of(1989, 9, 23))
                .category(Category.ESSAY)
                .build());


        // updating a book
        Book book = Objects.requireNonNull(entityManager.find(Book.class, 1L));
        book.setPublishing(LocalDate.now());
        entityManager.persist(book);

        // getting another book and removing it
        book = Objects.requireNonNull(entityManager.find(Book.class, 3L));
        entityManager.remove(book);

    }
}
