/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyro.bab;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author F.M.
 */
public class Gestionnaire extends Utilisateur {
    private LocalDate dateEmbauche;
    private LocalDate finContrat;
    private String typeEmploi;


    private static ArrayList<Usager> usagers = new ArrayList<>();
    // ArrayList<Usager> usagers = new ArrayList<>();
    private static ArrayList<Gyropode> gyropode = new ArrayList<>();
    
    public LocalDate getLocalDateEmbauche() {
        return dateEmbauche;
    }

    public void setLocalDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public LocalDate getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(LocalDate finContrat) {
        this.finContrat = finContrat;
    }

    public String getTypeEmploi() {
        return typeEmploi;
    }

    public void setTypeEmploi(String typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

    public static ArrayList<Usager> getUsagers() {
        return usagers;
    }

    public static void setUsagers(ArrayList<Usager> usagers) {
        Gestionnaire.usagers = usagers;
    }

    public static ArrayList<Gyropode> getGyropode() {
        return gyropode;
    }

    public static void setGyropode(ArrayList<Gyropode> gyropode) {
        Gestionnaire.gyropode = gyropode;
    }
    
    

    
    
    public void creerCompteUsager(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateNaissance, String nPieceIdentite, TypePieceIdentite typePCIdentite){

        ArrayList listeNomsUtilisateurs = Utilisateur.getListeNomsUtilisateurs();
        if ((listeNomsUtilisateurs.contains(nomUtilisateur))){
            System.out.println("Desolé, mais le nom d'utilisateur "+nomUtilisateur+" est déjà pris.");
        }
        else{
            usagers.add(new Usager(mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille, dateNaissance, nPieceIdentite, typePCIdentite));
        }
    }
    public String obtenirListeUsagers(){
        String listeDeUsagers = "";
        for(int i=0;i<usagers.size();i++){
            listeDeUsagers =+ i+" : "+usagers.get(i)+"\n";
        }
        return listeDeUsagers;
    }
    
    
    
    public Gestionnaire(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateEmbauche, LocalDate finContrat, String typeEmploi) {
        super(mailUtilisateur, nomUtilisateur, prenomUtilisateur,nomDeFamille);
        this.dateEmbauche = dateEmbauche;
        this.finContrat = finContrat;
        this.typeEmploi = typeEmploi;
    }

    @Override
    public String toString() {
        return super.toString()+"Gestionnaire{" + "dateEmbauche=" + dateEmbauche + ", finContrat=" + finContrat + ", typeEmploi=" + typeEmploi + '}';
    }
    
    
    
	// SAISON
    
	// USAGER
    
	public void modifierUsager(Usager usager, String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateNaissance, String nPieceIdentite, TypePieceIdentite typePCIdentite){
    	usager.setMailUtilisateur(mailUtilisateur);
        usager.setNomUtilisateur(nomUtilisateur);
        usager.setPrenomUtilisateur(prenomUtilisateur);
        usager.setNomDeFamille(nomDeFamille);
    	usager.setDateNaissance(dateNaissance);
        usager.setnPieceIdentite(nPieceIdentite);
        usager.setTypePieceIdentite(typePCIdentite);
	}
    
	
        
        
        public void creerModeleGyropode(MarqueGyropode marqueDuGyropode,String typeFreinGyroscopique, String systemeCalePieds, String systemeDePoigneeDemport, 
                String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, 
                double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance){
           gyropode.add(new Monoroue(typeFreinGyroscopique, systemeCalePieds, systemeDePoigneeDemport,nRference,
      nSerieConstructeur,
      couleur,
      dateAchat,
      nUtilisations,
      nKmEffectue,
      nHeureRoule,
      latitude,
      longitude,
      niveauBatterie,
      dureeRouageRestant,
      tempsRechargeEstime,
      bloque,
      enMaintenance,
      marqueDuGyropode));
        }
        
      //monoroue.set  
        
    }
                   
          
      
            
        
        
        
        
        
        
        
        
        
        
        
       
	

    

    
    

