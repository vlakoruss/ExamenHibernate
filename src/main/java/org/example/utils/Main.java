package org.example.utils;

import org.example.models.Pelicula;
import org.example.services.DataService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        DataService dataService = new DataService(sessionFactory);


        dataService.peliculaFindByPuntuacion("5");
        /*dataService.addPelicula("El padrino2");*/
        dataService.opinionFindByUsuario("Muy buena pelicula");
        dataService.addOpinionToPelicula("El Padrino", "Muy buena pelicula", 5);



    }
}