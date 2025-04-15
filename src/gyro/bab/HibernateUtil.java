/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyro.bab;

import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration; 

/**
 *
 * @author mapluzdell
 */
public class HibernateUtil {

    // Déclaration de la SessionFactory comme une variable statique
    private static SessionFactory sessionFactory; 

    static {
        try {
            // Chargement de la configuration Hibernate et construction de la SessionFactory
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); 
        } 
        catch (Throwable ex) 
        {
            // Gestion des erreurs si la configuration échoue
            System.err.println("La création de la SessionFactory a échoué : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Méthode publique pour obtenir l'instance de SessionFactory
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }

    // Méthode pour fermer la SessionFactory lors de l'arrêt de l'application
    public static void shutdown() 
    {
        if (sessionFactory != null) 
        {
            sessionFactory.close();
        }
    }
}