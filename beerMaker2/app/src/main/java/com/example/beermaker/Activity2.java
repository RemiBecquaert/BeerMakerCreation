package com.example.beermaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private Recette recette;
    private EditText moyenneEBC;
    private EditText degreAlcool;
    private EditText volumeBiere;
    private TextView quantiteHoublonAm;
    private TextView quantiteHoublonAr;
    private TextView quantiteMalt;
    private TextView volEauBrass;
    private TextView volEauRinc;
    private TextView quantiteLevure;
    private LinearLayout resultats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        initBlanc();
        ecouteBtnClose();
        ecouteBtnCalculer();
    }

    private void initBlanc(){
        resultats = findViewById(R.id.resultats);
        resultats.setVisibility(View.GONE);

        moyenneEBC = findViewById(R.id.moyenneEBC);
        degreAlcool = findViewById(R.id.degreAlcool);
        volumeBiere = findViewById(R.id.volumeBiere);

        quantiteHoublonAm = findViewById(R.id.quantiteHoublonAm);
        quantiteHoublonAr = findViewById(R.id.quantiteHoublonAr);
        quantiteMalt = findViewById(R.id.quantiteMalt);
        quantiteLevure = findViewById(R.id.quantiteLevure);
        volEauBrass = findViewById(R.id.volEauBrass);
        volEauRinc = findViewById(R.id.volEauRinc);
        recette = new Recette();
    }
    private void calculBiere(){
        resultats.setVisibility(View.VISIBLE);

        recette.setVolumeB(Double.parseDouble(volumeBiere.getText().toString()));
        recette.setDegreB(Double.parseDouble(degreAlcool.getText().toString()));
        recette.setEbc(Double.parseDouble(moyenneEBC.getText().toString()));

        quantiteHoublonAm.setText("Quantité de houblon amérisant : " + recette.calculHoublonAmerisant() + "g");
        quantiteHoublonAr.setText("Quantité de houble aromatique : " + recette.calculHoublonAromatique() + "g");
        quantiteMalt.setText("Quantité de malt : " + recette.quantiteMalt() + "kg");
        volEauRinc.setText("Volume d'eau de rinçage : " + recette.quantiteEauRincage() + " L");
        volEauBrass.setText("Volume d'eau de brassage : " + recette.quantiteEauBrassage() + " L");
        quantiteLevure.setText("Quantité de levure : " + recette.calculLevure() + " g");
    }
    private void ecouteBtnClose(){
        findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    private void ecouteBtnCalculer(){
        findViewById(R.id.buttonCalculer).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                calculBiere();
            }
        });
    }

}