package com.modea.modea.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mods")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Mod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreMod;

    @Column(nullable = false)
    private String descripcionMod;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "videojuego_id", nullable = false)
    private Videojuego videojuego;

    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma;

    @ManyToOne
    @JoinColumn(name = "categoriaMod_id", nullable = false)
    private CategoriaMod categoriamod;

    @ManyToOne
    @JoinColumn(name = "descarga_id", nullable = false) 
    private Descarga descarga;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn (name = "feedback_id", nullable = true)
    private Feedback feedback;

}
