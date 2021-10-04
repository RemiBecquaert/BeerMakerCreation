package com.example.beermaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;

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

    private String nomFichierSerialise = "recette";

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
        checkSerialize();
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

    private void recupSerialize(Context contexte){
        recette = (Recette) Serializer.deserialize(nomFichierSerialise, contexte);
    }

    private void checkSerialize(){
        try{
            recupSerialize(this);
            ((TextView) findViewById(R.id.moyenneEBC)).setText("" + recette.getEbc());
            ((TextView) findViewById(R.id.degreAlcool)).setText("" + recette.getDegreB());
            ((TextView) findViewById(R.id.volumeBiere)).setText("" + recette.getVolumeB());


        }catch (Exception e){

        }
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
                Serializer.serialize(nomFichierSerialise, recette, Activity2.this);

                hideKeyboard(Activity2.this);
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}