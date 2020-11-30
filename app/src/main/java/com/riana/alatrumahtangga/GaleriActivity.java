package com.riana.alatrumahtangga;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import com.riana.alatrumahtangga.model.Perabot;

public class GaleriActivity extends AppCompatActivity {

    List<Perabot> perabots;
    int indeksTampil = 0;
    String jenisPerabot;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txRas,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoPerabot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        Intent intent = getIntent();
        jenisPerabot = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        perabots = DataProvider.getPerabotsByTipe(this,jenisPerabot);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> hewanPertama());
        btnTerakhir.setOnClickListener(view -> hewanTerakhir());
        btnSebelumnya.setOnClickListener(view -> hewanSebelumnya());
        btnBerikutnya.setOnClickListener(view -> hewanBerikutnya());

        txRas = findViewById(R.id.txRas);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPerabot = findViewById(R.id.gambarPerabot);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Jenis "+jenisPerabot);
    }


    private void tampilkanProfil() {
        Perabot k = perabots.get(indeksTampil);
        Log.d("VESPA","Menampilkan vespa "+k.getRas());
        txRas.setText(k.getRas());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoPerabot.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void hewanPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void hewanTerakhir() {
        int posAkhir = perabots.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void hewanBerikutnya() {
        if (indeksTampil == perabots.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void hewanSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}