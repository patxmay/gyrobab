/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyro.bab;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author rlarralde
 */
public abstract class Gyropode {

    
    private String nRference;
    private String nSerieConstructeur;
    private String couleur;
    private LocalDate dateAchat;
    private int nUtilisations;
    private double nKmEffectue;
    private double nHeureRoule;
    private double latitude;
    private double longitude;
    private double niveauBatterie;
    private double dureeRouageRestant;
    private double tempsRechargeEstime;
    private boolean bloque;
    private boolean enMaintenance;
    private static int nUtilisationsTotal;
    private static double nKmTotal;
    private static double nHeuresTotal;
    private MarqueGyropode marqueDuGyropode;

    public String getnRference() {
        return nRference;
    }

    public void setnRference(String nRference) {
        this.nRference = nRference;
    }

    public String getnSerieConstructeur() {
        return nSerieConstructeur;
    }

    public void setnSerieConstructeur(String nSerieConstructeur) {
        this.nSerieConstructeur = nSerieConstructeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getnUtilisations() {
        return nUtilisations;
    }

    public void setnUtilisations(int nUtilisations) {
        this.nUtilisations = nUtilisations;
    }

    public double getnKmEffectue() {
        return nKmEffectue;
    }

    public void setnKmEffectue(double nKmEffectue) {
        this.nKmEffectue = nKmEffectue;
    }

    public double getnHeureRoule() {
        return nHeureRoule;
    }

    public void setnHeureRoule(double nHeureRoule) {
        this.nHeureRoule = nHeureRoule;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getNiveauBatterie() {
        return niveauBatterie;
    }

    public void setNiveauBatterie(double niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    public double getDureeRouageRestant() {
        return dureeRouageRestant;
    }

    public void setDureeRouageRestant(double dureeRouageRestant) {
        this.dureeRouageRestant = dureeRouageRestant;
    }

    public double getTempsRechargeEstime() {
        return tempsRechargeEstime;
    }

    public void setTempsRechargeEstime(double tempsRechargeEstime) {
        this.tempsRechargeEstime = tempsRechargeEstime;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    public boolean isEnMaintenance() {
        return enMaintenance;
    }

    public void setEnMaintenance(boolean enMaintenance) {
        this.enMaintenance = enMaintenance;
    }

    public static int getnUtilisationsTotal() {
        return nUtilisationsTotal;
    }

    public static void setnUtilisationsTotal(int nUtilisationsTotal) {
        Gyropode.nUtilisationsTotal = nUtilisationsTotal;
    }

    public static double getnKmTotal() {
        return nKmTotal;
    }

    public static void setnKmTotal(double nKmTotal) {
        Gyropode.nKmTotal = nKmTotal;
    }

    public static double getnHeuresTotal() {
        return nHeuresTotal;
    }

    public static void setnHeuresTotal(double nHeuresTotal) {
        Gyropode.nHeuresTotal = nHeuresTotal;
    }

    public double geolocaliserLatidude() {
        return Math.random() * 0.048948 + 43.478843;
    }

    public double geolocaliserLongitude() {
        return Math.random() * -0.059698 - 1.463571;
    }
    
    public String geolocaliser(){
        return "latitude :"+this.geolocaliserLatidude()+", longitude : "+this.geolocaliserLongitude();
    }

    public void bloquer() {
        this.bloque=true;
    }

    public void debloquer() {
        this.bloque=false;
    }

    public void mettreEnMaintenance() {
        this.enMaintenance=true;
    }

    public void mettreEnSerivce() {
        this.enMaintenance=false;
    }

    public double RecupereBluetoothNiveauDeChargeBatterie(){
    	this.niveauBatterie=Math.round(Math.random()*100.0);
        return this.niveauBatterie;
	}

    public int recupererRoulageEstime() {
        int tempsRoulageEstime;
        if (this.niveauBatterie >= 80) {
            tempsRoulageEstime = 180; // Temps estimé en minutes pour une charge complète
        } else if (this.niveauBatterie >= 50) {
            tempsRoulageEstime = 120; // Temps estimé en minutes pour une charge complète
        } else if (this.niveauBatterie >= 20) {
            tempsRoulageEstime = 90; // Temps estimé en minutes pour une charge complète
        } else {
            tempsRoulageEstime = 60; // Temps estimé en minutes pour une charge complète
        }
        return tempsRoulageEstime;
    }

    public int recupererTempsRestantEstimePourCharger() {
        int tempsEstime;
        if (this.niveauBatterie >= 80) {
            tempsEstime = 60; // Temps estimé en minutes pour une charge complète
        } else if (this.niveauBatterie >= 50) {
            tempsEstime = 90; // Temps estimé en minutes pour une charge complète
        } else if (this.niveauBatterie >= 20) {
            tempsEstime = 120; // Temps estimé en minutes pour une charge complète
        } else {
            tempsEstime = 180; // Temps estimé en minutes pour une charge complète
        }
        return tempsEstime;
    }
    
    


    public void majInfo() {
        System.out.println("Gyropode geolocalisation : "+this.geolocaliser()+", Niveau Batterie restant : "+this.RecupereBluetoothNiveauDeChargeBatterie()
        +", temps de roulage restant : "+this.recupererRoulageEstime()+", temps de cahrge restant (si mit en charge) : "+this.recupererTempsRestantEstimePourCharger());

    }

    public Gyropode(String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule,
            double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance,
            MarqueGyropode marqueDuGyropode) {
        this.nRference = nRference;
        this.nSerieConstructeur = nSerieConstructeur;
        this.couleur = couleur;
        this.dateAchat = dateAchat;
        this.nUtilisations = nUtilisations;
        this.nKmEffectue = nKmEffectue;
        this.nHeureRoule = nHeureRoule;
        this.latitude = latitude;
        this.longitude = longitude;
        this.niveauBatterie = niveauBatterie;
        this.dureeRouageRestant = dureeRouageRestant;
        this.tempsRechargeEstime = tempsRechargeEstime;
        this.bloque = bloque;
        this.enMaintenance = enMaintenance;
        this.marqueDuGyropode = marqueDuGyropode;
    }

   

    @Override
    public String toString() {
        return "Gyropode{" + "nRference=" + nRference + ", nSerieConstructeur=" + nSerieConstructeur + ", couleur=" + couleur + ", dateAchat=" + dateAchat + ", nUtilisations=" + nUtilisations + ", nKmEffectue=" + nKmEffectue + ", nHeureRoule=" + nHeureRoule + ", latitude=" + latitude + ", longitude=" + longitude + ", niveauBatterie=" + niveauBatterie + ", dureeRouageRestant=" + dureeRouageRestant + ", tempsRechargeEstime=" + tempsRechargeEstime + ", bloque=" + bloque + ", enMaintenance=" + enMaintenance + '}';
    }
    
}
