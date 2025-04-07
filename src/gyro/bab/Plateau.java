/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyro.bab;

import java.time.LocalDate;

/**
 *
 * @author rlarralde
 */
public class Plateau extends Gyropode{

    private String systemeAutoEquilibrage;
    private boolean sacDeTransport;
    private String systemeDetorsion;
    private String typePatin;

    public String getSystemeAutoEquilibrage() {
        return systemeAutoEquilibrage;
    }

    public void setSystemeAutoEquilibrage(String systemeAutoEquilibrage) {
        this.systemeAutoEquilibrage = systemeAutoEquilibrage;
    }

    public boolean isSacDeTransport() {
        return sacDeTransport;
    }

    public void setSacDeTransport(boolean sacDeTransport) {
        this.sacDeTransport = sacDeTransport;
    }

    public String getSystemeDetorsion() {
        return systemeDetorsion;
    }

    public void setSystemeDetorsion(String systemeDetorsion) {
        this.systemeDetorsion = systemeDetorsion;
    }

    public String getTypePatin() {
        return typePatin;
    }

    public void setTypePatin(String typePatin) {
        this.typePatin = typePatin;
    }

    public Plateau(String systemeAutoEquilibrage, boolean sacDeTransport, String systemeDetorsion, String typePatin, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance, MarqueGyropode marqueDuGyropode) {
        super(nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance, marqueDuGyropode);
        this.systemeAutoEquilibrage = systemeAutoEquilibrage;
        this.sacDeTransport = sacDeTransport;
        this.systemeDetorsion = systemeDetorsion;
        this.typePatin = typePatin;
    }
    
    

    @Override
    public String toString() {
        return super.toString()+"Plateau{" + "systemeAutoEquilibrage=" + systemeAutoEquilibrage + ", sacDeTransport=" + sacDeTransport + ", systemeDetorsion=" + systemeDetorsion + ", typePatin=" + typePatin + '}';
    }

    void remove(Gestionnaire aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
