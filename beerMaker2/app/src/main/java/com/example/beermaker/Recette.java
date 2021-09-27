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
        return (volumeB*degreB)/20;
    }

    public double quantiteEauBrassage(){
        return quantiteMalt()*2.8;
    }

    public double quantiteEauRincage(){
        return (volumeB*1.25)-(quantiteEauBrassage()*0.7);
    }

    public double calculLevure(){
        return volumeB/2;
    }

    public double calculHoublonAmerisant(){ return volumeB*3; }

    public double calculHoublonAromatique(){ return volumeB*1; }
}
