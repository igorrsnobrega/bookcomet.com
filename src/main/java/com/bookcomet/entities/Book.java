package com.bookcomet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false)
    private String authors;
    @NotNull
    @Column(nullable = false)
    private String publisher;
    @NotNull
    @Column(nullable = false)
    private int yearPublication;
    @NotNull
    @Column(columnDefinition = "text", nullable = false)
    private String summary;
    private Date createdAt;
    private Date updatedAt;


}
