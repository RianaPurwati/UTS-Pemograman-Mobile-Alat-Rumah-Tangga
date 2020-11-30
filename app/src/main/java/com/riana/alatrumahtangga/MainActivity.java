package com.riana.alatrumahtangga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnElektronik,btnNelektronik;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnElektronik = findViewById(R.id.btn_buka_alat_elektronik);
        btnNelektronik = findViewById(R.id.btn_buka_alat_nelektronik);
        btnElektronik.setOnClickListener(view -> bukaGaleri("Elektronik"));
        btnNelektronik.setOnClickListener(view -> bukaGaleri("Nelektronik"));
    }

    private void bukaGaleri(String jenisMatic) {
        Log.d("MAIN","Buka activity vespa");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisMatic);
        startActivity(intent);
    }

}