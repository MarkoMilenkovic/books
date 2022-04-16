package com.lemilica.books.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomSequences {
    @Id
    private String id;
    private int seq;

}