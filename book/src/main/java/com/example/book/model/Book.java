package com.example.book.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "JAN_CD", length = 13, nullable = false)
    private String janCd;

    @Column(name = "ISBN_CD", length = 13)
    private String isbnCd;

    @Column(name = "BOOK_NM", length = 500)
    private String bookNm;

    @Column(name = "BOOK_KANA", length = 500)
    private String bookKana;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "CREATE_DATETIME")
    private LocalDateTime createDatetime;

    @Column(name = "UPDATE_DATETIME")
    private LocalDateTime updateDatetime;
}
