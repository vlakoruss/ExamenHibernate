package org.example.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Pelicula")
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Opinion> opiniones = new ArrayList<>();

    public void addOpinion(Opinion o){
       o.setPelicula(this);
         opiniones.add(o);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                ", titulo='" + titulo + '\'' +
                '}';
    }

}
