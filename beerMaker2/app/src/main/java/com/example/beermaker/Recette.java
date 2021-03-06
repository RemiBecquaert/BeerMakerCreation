package com.example.beermaker;

import java.io.Serializable;

public class Recette implements Serializable{

    double volumeB;
    double degreB;
    double ebc;

    public Recette(){
        this.degreB = degreB;
        this.ebc = ebc;
        this.volumeB = volumeB;
    }

    public double getVolumeB() {
        return volumeB;
    }

    public void setVolumeB(double volumeB) {
        this.volumeB = volumeB;
    }

    public double getDegreB() {
        return degreB;
    }

    public void setDegreB(double degreB) {
        this.degreB = degreB;
    }

    public double getEbc() {
        return ebc;
    }

    public void setEbc(double ebc) {
        this.ebc = ebc;
    }


    public double quantiteMalt(){
        return arrondir((volumeB*degreB)/20, 2);
    }

    public double quantiteEauBrassage(){
        return arrondir(quantiteMalt()*2.8, 2);
    }

    public double quantiteEauRincage(){ return arrondir((volumeB*1.25)-(quantiteEauBrassage()*0.7), 2);
    }

    public double calculLevure(){ return arrondir (volumeB/2,2);
    }

    public double calculHoublonAmerisant(){ return arrondir(volumeB*3, 2); }

    public double calculHoublonAromatique(){ return arrondir(volumeB*1, 2); }

    public double calculEBC(){
        return arrondir((4.23 *(ebc*0.5))/volumeB, 2);
    }
    public static double arrondir (double chiffre, int nbChiffreApresVirgule){
        double chiffreArrond;
        String nbC = "1";
        for (int i=0; i<nbChiffreApresVirgule; i++){
            nbC+="0";
        }
        Integer arrond = Integer.parseInt(nbC);
        chiffreArrond = (double)Math.round(chiffre * arrond) / arrond;
        return chiffreArrond;
    }

}
