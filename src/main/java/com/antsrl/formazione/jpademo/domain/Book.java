package com.antsrl.formazione.jpademo.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


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

    @Temporal(TemporalType.DATE)
    @Column(name = "publishing_date", nullable = false)
    private LocalDate publishing;
}
