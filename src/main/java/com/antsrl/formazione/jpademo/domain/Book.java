package com.antsrl.formazione.jpademo.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Table(name = "book")
@Entity
@Getter
@Setter
@Builder
public class Book {

    @Id
    private Long Id;

    private String title;

    @Column(name = "any_column_name", nullable = false, unique = true, length = 16)
    private String anything;
}
