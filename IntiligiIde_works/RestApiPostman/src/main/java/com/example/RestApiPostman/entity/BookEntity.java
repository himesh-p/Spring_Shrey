package com.example.RestApiPostman.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    private Long book_id;
    private String title;
    private LocalDate published_year;
    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private AuthorEntity author;
}
