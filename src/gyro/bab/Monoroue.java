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
public class Monoroue extends Gyropode{
    private String typeFreinGyroscopique;
    private String systemeCalePieds;
    private String systemeDePoigneeDemport;

    public String getTypeFreinGyroscopique() {
        return typeFreinGyroscopique;
    }

    public void setTypeFreinGyroscopique(String typeFreinGyroscopique) {
        this.typeFreinGyroscopique = typeFreinGyroscopique;
    }

    public String getSystemeCalePieds() {
        return systemeCalePieds;
    }

    public void setSystemeCalePieds(String systemeCalePieds) {
        this.systemeCalePieds = systemeCalePieds;
    }

    public String getSystemeDePoigneeDemport() {
        return systemeDePoigneeDemport;
    }

    public void setSystemeDePoigneeDemport(String systemeDePoigneeDemport) {
        this.systemeDePoigneeDemport = systemeDePoigneeDemport;
    }

    public Monoroue(String typeFreinGyroscopique, String systemeCalePieds, String systemeDePoigneeDemport, String nRference, String nSerieConstructeur, String couleur,
            LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie,
            double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance, MarqueGyropode marqueDuGyropode) {
        super(nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance, marqueDuGyropode);
        this.typeFreinGyroscopique = typeFreinGyroscopique;
        this.systemeCalePieds = systemeCalePieds;
        this.systemeDePoigneeDemport = systemeDePoigneeDemport;
    }

    

    @Override
    public String toString() {
        return super.toString()+"Monoroue{" + "typeFreinGyroscopique=" + typeFreinGyroscopique + ", systemeCalePieds=" + systemeCalePieds + ", systemeDePoigneeDemport=" + systemeDePoigneeDemport + '}';
    }

    void remove(Gestionnaire aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
