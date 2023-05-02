package com.antsrl.formazione.jpademo;

import com.antsrl.formazione.jpademo.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Collectors;

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

        // one-to-one review and EXISTING book
        book = Objects.requireNonNull(entityManager.find(Book.class, 4L));
        Review review = new Review();
        review.setBook(book);
        entityManager.persist(review);

        // one-to-one review and NEW book
        book = Book.builder()
                .title("nice book")
                .anything("a value 28")
                .publishing(LocalDate.of(1996, 4, 18))
                .category(Category.SCIENCE)
                .build();
        review = new Review();
        review.setBook(book);
        // must persist the Book BEFORE the Review
        entityManager.persist(book);
        entityManager.persist(review);

        // one-to-one bi-direction
        book = Objects.requireNonNull(entityManager.find(Book.class, 2L));
        review = new Review();

        book.setReview(review);
        review.setBook(book);

        // still need to persist both entities
        entityManager.persist(book);
        entityManager.persist(review);

        // many-to-one
        Publisher publisher = new Publisher();
        book.setPublisher(publisher);
        entityManager.persist(publisher);

        // reset Entity Manager cache. let see how SQL fetches are handled with empty cache
        entityManager.flush();
        entityManager.clear();

        // one-to-many
        System.out.println("publisher is about to be fetched");

        publisher = entityManager.find(Publisher.class, 1L);

        System.out.println("publisher was fetched. books not used yet");

        String bookTitles = publisher.getBookList().stream()
                        .map(Book::getTitle)
                        .collect(Collectors.joining(", "));

        System.out.format("books %s where just fetched\n", bookTitles);


        // many-to-many

        Book book1 = entityManager.find(Book.class, 1L);
        Book book2 = entityManager.find(Book.class, 2L);
        Book book4 = entityManager.find(Book.class, 4L);

        Person p1 = new Person();
        p1.setName("mickey mouse");;
        p1.addBook(book4);

        Person p2 = new Person();
        p2.setName("donald duck");
        p2.addBook(book1);
        p2.addBook(book4);

        Person p3 = new Person();
        p3.setName("donald duck");
        p3.addBook(book1);
        p3.addBook(book2);
        p3.addBook(book4);

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
    }
}
