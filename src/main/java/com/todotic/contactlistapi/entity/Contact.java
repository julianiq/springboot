package com.todotic.contactlistapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor //Constructor
@NoArgsConstructor //Genera un constructor vacío para anular el error..
public class Contact {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull //Vuelve un argumento obligatorio.
    private String name;
    @NonNull
    private String email;
    @NonNull
    private LocalDateTime createdAt;
}
