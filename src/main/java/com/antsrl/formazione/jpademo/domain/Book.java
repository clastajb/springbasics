package com.antsrl.formazione.jpademo.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Table(name = "book")
@Entity
@Getter
@Setter
public class Book {

    @Id
    private Long Id;
    private String title;
}
