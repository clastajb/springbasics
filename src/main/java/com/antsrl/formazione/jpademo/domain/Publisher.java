package com.antsrl.formazione.jpademo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;

    private String businessName;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        this.bookList.add(book);
    }

}
