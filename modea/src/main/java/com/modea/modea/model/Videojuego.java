package com.modea.modea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "videojuego")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nombreVideojuego;

    @Column(nullable = false)
    private String portada;

    @Column(nullable = false)
    private String descripcionVideojuego;

    @Column(nullable = false)
    private String genero;

}
