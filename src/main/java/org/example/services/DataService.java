package org.example.services;

import org.example.models.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DataService {

    public SessionFactory sessionFactory;

    public DataService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Añadir nuevas peliculas

    public void addPelicula(Pelicula pelicula) {
        sessionFactory.inTransaction((session)->{
            session.persist(pelicula);
        });
    }

    //Obtener oponion de un usuario específico

    public void opinionFindByUsuario(String usuario) {
        sessionFactory.inTransaction((session)->{
            Pelicula pelicula = session.get(Pelicula.class, usuario);
            pelicula.addOpinion(null);
        });
    }

    //Añadir opiniones a una pelicula ya existente anteriormente

    public List<Pelicula> addOpinionToPelicula(String opinion, String pelicula, int i) {
        Session session = sessionFactory.openSession();
        Query<Pelicula> query = session.createQuery("from Pelicula as p inner join p.opiniones as o where o.usuario = :usuario");
        query.setParameter("", "");
        query.list().forEach(System.out::println);
        return query.list();
    }


    //Listado de peliculas con baja puntuación igual o inferior a 3

        public List<Pelicula>peliculaFindByPuntuacion(String puntuacion) {
        Session session = sessionFactory.openSession();
        Query<Pelicula> query = session.createQuery("from Pelicula as p inner join p.opiniones as o where o.puntuacion <= :puntuacion");
        query.setParameter("Puntuacion" , puntuacion);
        query.list().forEach(System.out::println);
        return query.list();
    }


}
