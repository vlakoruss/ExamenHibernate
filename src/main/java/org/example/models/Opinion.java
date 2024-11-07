package org.example.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Opinion")
/**
 * Represents an opinion given by a user about a movie.
 * This class is mapped to the "Opinion" table in the database.
 * It includes details such as description, user, score, and the associated movie.
 */
public class Opinion implements Serializable {

    /**
     * The unique identifier for the opinion.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The description of the opinion.
     */
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    /**
     * The user who gave the opinion.
     */
    @Column(name = "usuario", nullable = false, length = 150)
    private String usuario;

    /**
     * The score given by the user.
     */
    @Column(name = "puntuacion", nullable = false, length = 150)
    private Integer puntuacion;

    /**
     * The movie associated with the opinion.
     */
    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    /**
     * Associates a movie with this opinion.
     *
     * @param pelicula the movie to associate
     */
    public void addPelicula(Pelicula pelicula){
        this.pelicula = pelicula;
    }

    /**
     * Returns a string representation of the opinion.
     *
     * @return a string representation of the opinion
     */
    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntuacion='" + puntuacion + '\'' +
                '}';
    }
}