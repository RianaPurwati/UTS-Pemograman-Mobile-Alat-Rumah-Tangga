package com.riana.alatrumahtangga;


import android.content.Context;

import com.riana.alatrumahtangga.model.Perabot;
import com.riana.alatrumahtangga.model.Elektronik;
import com.riana.alatrumahtangga.model.Nelektronik;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Perabot> perabots = new ArrayList<>();

    private static List<Elektronik> initDataElektronik(Context ctx) {
        List<Elektronik> elektroniks = new ArrayList<>();
        elektroniks.add(new Elektronik("blender", "menghaluskanb uah",
                "", R.drawable.elek_blender));
        elektroniks.add(new Elektronik("kipas", "menstabilkan suhu ruangan",
                "", R.drawable.elek_kipas));
        elektroniks.add(new Elektronik("mesinkopi", "unntuk membuat kopi",
                "", R.drawable.elek_kopi));
        elektroniks.add(new Elektronik("magicom", "untuk memasak nasi",
                "", R.drawable.elek_magicom));
        elektroniks.add(new Elektronik("mixer", "untuk mencampur bahan-bahan makanan",
                "", R.drawable.elek_mixer));
        elektroniks.add(new Elektronik("setrika", "untuk melicinkan pakaian",
                "", R.drawable.elek_setrika));
        return elektroniks;
    }

    private static List<Nelektronik> initDataNelektronik(Context ctx) {
        List<Nelektronik> nelektroniks = new ArrayList<>();
        nelektroniks .add(new Nelektronik ("ceret", "sebagai wadah air",
                "", R.drawable.nelek_ceret));
        nelektroniks.add(new Nelektronik("teplon", "untuk menggoreng makanan",
                "", R.drawable.nekel_teplon));
        nelektroniks.add(new Nelektronik("garpu", "sebagai alat makan",
                "", R.drawable.nelek_garpu));
        nelektroniks.add(new Nelektronik("oven", "untuk memanggang makanan",
                "", R.drawable.nelek_oven));
        nelektroniks.add(new Nelektronik("kompor", "untuk memasak",
                "", R.drawable.nelek_kompor));
        nelektroniks.add(new Nelektronik("panci", "untuk memasak sayur",
                "", R.drawable.nelek_panci));
        return nelektroniks;
    }


    private static void initAllPerabots(Context ctx) {
        perabots.addAll(initDataElektronik(ctx));
        perabots.addAll(initDataNelektronik(ctx));
    }

    public static List<Perabot> getAllPerabot(Context ctx) {
        if (perabots.size() == 0) {
            initAllPerabots(ctx);
        }
        return perabots;
    }

    public static List<Perabot> getPerabotsByTipe(Context ctx, String jenis) {
        List<Perabot> perabotsByType = new ArrayList<>();
        if (perabots.size() == 0) {
            initAllPerabots(ctx);
        }
        for (Perabot h : perabots) {
            if (h.getJenis().equals(jenis)) {
                perabotsByType.add(h);
            }
        }
        return perabotsByType;
    }

}
