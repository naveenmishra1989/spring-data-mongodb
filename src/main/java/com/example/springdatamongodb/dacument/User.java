package com.example.springdatamongodb.dacument;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {

    @Id
    private Integer id;
    private String name;
    private String teamName;
    private Double salary;
}
