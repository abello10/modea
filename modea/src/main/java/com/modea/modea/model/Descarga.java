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
@Table(name = "descarga")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Descarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreDescarga;

    @Column(nullable = false)
    private String tipoArchivo;

    @Column(nullable = false)
    private Integer tamanoArchivo;
}
