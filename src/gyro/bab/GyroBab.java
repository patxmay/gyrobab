/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gyro.bab;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import java.sql.Connection; // POUR LA CONNEXION JDBC
import org.hibernate.Session; // pour la connexion hibernta

/**
 *
 * @author Rafael
 */
public class GyroBab {
    public static void main(String[] args) {
        // -------------------------------------------------
        // Obtenir une connexion à la base de données
        // -------------------------------------------------
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) 
        {
            System.out.println("Connexion réussie !");
        } 
        else 
        {
            System.err.println("Échec de la connexion à la base de données.");
        }

        // -------------------------------------------------
        // Créez une classe pour tester la connexion avec Hibernate 
        // -------------------------------------------------
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Hibernate est configuré avec succès !");
        session.close();
        
        //OBJETS
        Scanner sc = new Scanner(System.in);
        Administrateur adm = new Administrateur("rafael1893porto@gmail.com","rdpt03","Rafael","Alves");
        /*
        adm.creerCompteGestionnaire("aa@orange.fr", "zeede", "Jean","La Terre",  LocalDate.of(1990, 5, 10), null, "Loueur");
        adm.creerCompteGestionnaire("babnl@gmail.com", "Babnl", "Jean","Azekamiata",  LocalDate.of(2023, 04, 01), LocalDate.of(2023,9,05), "Loueur");
        adm.creerCompteGestionnaire("rodrigoDasPeras@sapo.pt", "zeede", "Rodrigo","Pereira",  LocalDate.of(2023, 04, 01), LocalDate.of(2023,9,05), "Technicien Informatique");
        
        Gestionnaire gest = new Gestionnaire(null,null,null,null,null,null,null);
        gest.creerCompteUsager(null, "aaaa", null, null, LocalDate.of(2013,05,01), null, null);
        gest.creerCompteUsager(null, "dfs", null, null, LocalDate.of(2003,05,01), null, null);
        gest.creerCompteUsager(null, "ez", null, null, LocalDate.of(1993,05,01), null, null);
        */

        boolean menuInitial = true;
        
        while(menuInitial){
            System.out.println("""
                               -----------------------------------------------------
                                        ** 1 : Entrer entant que Admin**            
                                        ** 2 : Entrer entant Que Gestionnaire**     
                               -----------------------------------------------------
                               """);
            int res = sc.nextInt();
            switch(res){
                case 1:
                    //METTRE menuInitial en faux
                    menuInitial = false;
                    //executer la boucle du menuAdmin
                    menuAdministrateur(sc, adm);
                break;
                case 2:
                    System.out.println("**En developpement**");
                break;
                default:
                    System.out.println("**Option Invalide...**");
                    attendre(400);
                break;
            }
        }
    }
        
    
    public static void menuAdministrateur(Scanner sc, Administrateur adm){
        boolean menuAdmin=true; 
        while(menuAdmin){
            System.out.println("------------------------------------------------------------------\n"+
                                 "           ** 1 : Visualiser la liste de comptes Gestionnaires**\n"+
                                 "           ** 2 : Ajouter un compte Gestionnaire**\n"+                                  
                                 "           ** 3 : Modifier un compte Gestionnaire**\n"+
                                 "           ** 4 : Supprimer un compte Gestionnaire** \n"+
                                 "           ** 99: Sortir du programme**\n"+
                                  "-------------------------------------------------------------------");
            int res = sc.nextInt();
                        
            switch(res){
                case 1:
                    System.out.println("-------------------------------------------------------------------\n"+
                                       "               ****LISTE DES GESTIONNAIRES****                     \n"+
                                                     adm.obtenirListeDesGestionnaires()+"\n"+ 
                                       "-------------------------------------------------------------------\n");
                    attendre(2560);
                break;
                case 2://mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille, dateEmbauche,finContrat, typeEmploi
                    creerUnGestionnaire(sc,adm);
                    
                    
                break;
                    
                case 3:
                    ;
                break;
                
                case 4:
                    ;
                break;
                
                case 99:
                    menuAdmin=false;
                break;
                default:
                    optionInvalide();
                break;
            }
        }
    }
    
    
    
    
    
    //MENU POUR CREER DES GESTIONNAIRES
    public static void creerUnGestionnaire(Scanner sc,Administrateur adm){
        //VARIABLES
        String prenom;
        String nomfamille;
        String nomutilisateur = null;
        String mail;
        LocalDate dateDebutFormate = null;
        LocalDate dateFin;
        String metier;
        
        //PRENOM
        sc.nextLine();
        System.out.println("Inserez le prenom du Gestionnaire : ");
        prenom = sc.nextLine();

        //NOM DE FAMILLE            
        System.out.println("Inserez le nom de famille du Gestionnaire : ");
        nomfamille = sc.nextLine();
        
        //METTRE NOM UTILISATEUR STRING nomutilisateur
        boolean entrainDeMettreNomUtilisateur = true;
        while(entrainDeMettreNomUtilisateur){
            System.out.println("Inserez le nom d'utilisateur du Gestionnaire : ");
            
            nomutilisateur = sc.nextLine();
            
            /*if(Utilisateur.utilisateurEstPris(nomutilisateur)){
                System.out.println("Utilisateur deja pris");
            }
            else{
                entrainDeMettreNomUtilisateur=false;
            }*/
        }
        
        //MAIL
        System.out.println("Inserez le mail du Gestionnaire : ");
        mail = sc.nextLine();
                    
        //DATE DEBUT
        boolean entrainDeMettreLaDate = true;
        while(entrainDeMettreLaDate){
            System.out.println("Inserez la date de Embauche separé par des '/' dans le format jj/mm/aaaa : ");
            String stringDateEmbauche = sc.nextLine();

            dateDebutFormate = convertirDate(stringDateEmbauche);
            if(dateDebutFormate != null){
                 entrainDeMettreLaDate = false;
            }
        }
                    
                    
                        
        //DATE DE FIN    
        System.out.println("Inserez la date Fin d'embauche separé par des '/' dans le format jj/mm/aaaa : \n (Si rien ne rien taper");
                    
        String stringDateFin = sc.nextLine();
        if (stringDateFin.equals("") || convertirDate(stringDateFin) == null){
            dateFin = null;
        }
        else{
            dateFin = convertirDate(stringDateFin);
        }
        
        //SON METIER
        System.out.println("Metier du Gestionnaire");
            metier = sc.nextLine();
            
        //LA CONSTRUCTION    
        adm.creerCompteGestionnaire(mail, nomutilisateur, prenom, nomfamille, dateDebutFormate, dateFin, metier);
    }
    
    //CONVERTIR LES DATES STRING EN LOCALDATE
    public static LocalDate convertirDate(String dateNonFormatee){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate date = LocalDate.parse(dateNonFormatee, formatter);
            return date;
        }
        catch(DateTimeParseException e){
            return null;
        }
    }
    
    //AFFICHER OPTION INVALIDE
    public static void optionInvalide(){
        System.out.println("**Option Invalide...**");
        attendre(400);
    }
    
    //ATTENDRE
    public static void attendre(int milisecondes){
        try{
            Thread.sleep(milisecondes);
        }catch(InterruptedException ex){;
        }
    }
}
