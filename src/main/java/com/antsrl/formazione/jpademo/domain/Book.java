package com.antsrl.formazione.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Table(name = "book")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
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
}
