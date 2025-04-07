/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyro.bab;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class Administrateur extends Utilisateur{
    
    private ArrayList<Gestionnaire> gestionnaires = new ArrayList<>();
    
    public Administrateur(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille){
        super(mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille);
    }
    
    public void creerCompteGestionnaire(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateEmbauche, LocalDate finContrat, String typeEmploi){
        gestionnaires.add(new Gestionnaire( mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille, dateEmbauche,finContrat, typeEmploi));
    }
    
    //ADD ON UML
    public ArrayList<Gestionnaire> obtenirListeDesGestionnaires(){
        String listeGestionnaires = "";
        //for(int i=0;i<gestionnaires.size();i++){
        //    listeGestionnaires = listeGestionnaires + i+" : "+gestionnaires.get(i)+"\n";
        //}
        //return listeGestionnaires;
        return gestionnaires;
    }
    public int quantiteGestionnaires(){
        return gestionnaires.size();
    }
    
    
    public void supprimerGestionnaire(int nGestionnaire){
        ;
    }
    
    
    public Gestionnaire obtenirGestionnaireParID(int i){
        Gestionnaire gestionnaire = gestionnaires.get(i);
        return gestionnaire;
    }
    
    
    public Gestionnaire obtenirGestionnaireParNomUtilisateur(String nomUtilisateur){
        for (Gestionnaire gestionnaire : gestionnaires) {
            if (gestionnaire.getNomUtilisateur().equals(nomUtilisateur)) {
                return gestionnaire;
            }
        }
        return null; // Retorna null se o gestionnaire não for encontrado
    }
}
