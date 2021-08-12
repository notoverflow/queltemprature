package com.example.queltemprature;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView suprimer;
    private EditText edit;
    private int i;
    private int nbr;
    private int valeur;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private RelativeLayout Relative;
    private TextView vraie, faux;
    private Button oui;




//    ⠀       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⠿⠟⠛⠻⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣆⣀⣀⠀⣿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠻⣿⣿⣿⠅⠛⠋⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢼⣿⣿⣿⣃⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣟⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣛⣛⣫⡄⠀⢸⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⡆⠸⣿⣿⣿⡷⠂⠨⣿⣿⣿⣿⣶⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣾⣿⣿⣿⣿⡇⢀⣿⡿⠋⠁⢀⡶⠪⣉⢸⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⡏⢸⣿⣷⣿⣿⣷⣦⡙⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣇⢸⣿⣿⣿⣿⣿⣷⣦⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀
//            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣵⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    private Button non;
    private Button verifier;
    private TextView rejouer;
    private long departd;
    private TextView record;

//
//
//    essai dadresse ip pour la meteo, mais ça marche pas
//    private static InetAddress ip;
//
//    public static void main(String args[]) throws Exception
//    {
//         ip = InetAddress.getLocalHost();
//
//        System.out.print("Mon adresse IP est: ");
//        System.out.println(ip.getHostAddress());
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();


//         adresse = ip.getHostAddress();
        //
        edit = findViewById(R.id.edit);

        suprimer = findViewById(R.id.suprimer);
        Relative = findViewById(R.id.Relative);
        vraie = findViewById(R.id.vraie);
        faux = findViewById(R.id.faux);
        oui = findViewById(R.id.oui);
        non = findViewById(R.id.non);
        record = findViewById(R.id.record);
        verifier = findViewById(R.id.verifier);
        rejouer = findViewById(R.id.rejouer);
//
//
//        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        double longitude = location.getLongitude();
//        double latitude = location.getLatitude();

        suprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat3();
            }
        });

        verifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt;
                txt = edit.getText().toString();

                nbr = -1;
                i++;

                if (txt.length() > 0) {
                    nbr = (int) Float.parseFloat(txt);
                } else faux.setText(R.string.rentreunnombre);

                if (nbr > 50) {

                    faux.setText(R.string.entreunnbrcorecte);

                }

//        nbr recherché plus grand


                if (nbr < valeur && nbr >= 0) faux.setText(R.string.nbrplusgrand);

//        nbr recherché plus petit

                if (nbr > valeur && nbr <= 50) faux.setText(R.string.nbrpluspetit);

//        nbr trouvé

                if (nbr == valeur) {
                    edit.setText("");
                    etat2();

                }

                edit.setText("");

            }
        });

        etat1();
    }

    private void etat1() {

        Relative.setVisibility(View.INVISIBLE);

        init();

    }

    private void temperature(int code) {

//        https://api.meteo-concept.com/api/ephemeride/0?token=111f1a052d3a50dbecf81f4b802982cfd5023d875f5c284c5a47bbbe6fa86aee


    }

    private void etat2() {
        faux.setVisibility(View.INVISIBLE);
        vraie.setVisibility(View.VISIBLE);
        record.setVisibility(View.VISIBLE);
        suprimer.setVisibility(View.INVISIBLE);
        Relative.setVisibility(View.VISIBLE);
        cacheClavier();
        edit.setVisibility(View.INVISIBLE);
        cacheClavier();
        rejouer.setVisibility(View.VISIBLE);
        rejouer.setText(R.string.rejouer);
        verifier.setVisibility(View.INVISIBLE);

        long find = System.currentTimeMillis();

        float temps1 = (float) ((float) (find - departd) / 1000.);
        int tempsmin = (int) ((float) (find - departd) / 60000);
        float tempss = (temps1 - tempsmin * 60000 / 1000);


        if (temps1 > 60) {
            vraie.setText(getString(R.string.nbrtrouveplusuneminutes, i, tempsmin, tempss));
        } else {
            vraie.setText(getString(R.string.nbrtrouvee, i, temps1));
        }


        int nbrDeCoup;
        nbrDeCoup = sharedPreferences.getInt("coup", Integer.MAX_VALUE);
        if (i < nbrDeCoup) {
            record.setText(getString(R.string.reccordcoups));

            editor.apply();
        }

        float tempsRecord;
        tempsRecord = sharedPreferences.getFloat("s", Float.MAX_VALUE);

        float temps;
        find = System.currentTimeMillis();
        temps = (float) ((float) (find - departd) / 1000.);

        if (temps < tempsRecord) {
            record.setText(getString(R.string.reccordtemps));

            editor.apply();
        }

        if (temps < tempsRecord && i < nbrDeCoup) {

            record.setText(getString(R.string.reccordCoupEtTemps));

            editor.apply();
        }
        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etat1();
                Relative.setVisibility(View.INVISIBLE);
                suprimer.setVisibility(View.VISIBLE);
                vraie.setVisibility(View.INVISIBLE);
                record.setVisibility(View.INVISIBLE);
                faux.setVisibility(View.VISIBLE);
                faux.setText("");
                edit.setVisibility(View.VISIBLE);
                verifier.setVisibility(View.VISIBLE);

            }
        });

    }

    //    class pour suprimer les records
    private void etat3() {

        cacheClavier();
        faux.setVisibility(View.INVISIBLE);
        Relative.setVisibility(View.VISIBLE);
        rejouer.setVisibility(View.VISIBLE);
        vraie.setVisibility(View.INVISIBLE);
        edit.setVisibility(View.INVISIBLE);
        suprimer.setVisibility(View.INVISIBLE);
        verifier.setVisibility(View.INVISIBLE);

        rejouer.setText(R.string.suprreccord);

        oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejouer.setText(R.string.rejouer);
                Relative.setVisibility(View.INVISIBLE);
                rejouer.setVisibility(View.INVISIBLE);


                editor.putInt("coup", Integer.MAX_VALUE);
                editor.putFloat("s", Integer.MAX_VALUE);
                editor.apply();

                Log.i("info", " record initialisé");

                faux.setVisibility(View.VISIBLE);
                faux.setText("");
                vraie.setVisibility(View.VISIBLE);
                vraie.setText("");
                edit.setVisibility(View.VISIBLE);
                suprimer.setVisibility(View.VISIBLE);
                verifier.setVisibility(View.VISIBLE);
                init();

            }


        });

        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejouer.setText(R.string.rejouer);
                rejouer.setVisibility(View.INVISIBLE);
                Relative.setVisibility(View.INVISIBLE);


                faux.setVisibility(View.VISIBLE);
                faux.setText("");
                vraie.setVisibility(View.VISIBLE);
                vraie.setText("");
                edit.setVisibility(View.VISIBLE);
                suprimer.setVisibility(View.VISIBLE);
                verifier.setVisibility(View.VISIBLE);

                init();

            }
        });
    }

    /**
     * méthode pour cacher le clavier
     */
    private void cacheClavier() {

        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view == null)
            view = new View(this);

        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    private void init() {

        Random r = new Random();

        valeur = r.nextInt(51);
        i = 0;

        departd = System.currentTimeMillis();

        Log.i("Info", "Le nombre r=" + valeur);
    }

}
