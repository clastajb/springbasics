package com.antsrl.formazione.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Table(name = "book")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @Column(name = "any_column_name", nullable = false, unique = true, length = 16)
    private String anything;

    @Temporal(TemporalType.DATE)
    @Column(name = "publishing_date", nullable = false)
    private LocalDate publishing;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @OneToOne(mappedBy = "book")
    private Review review;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany(mappedBy = "bookList")
    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person person){
        personList.add(person);
    }
}
