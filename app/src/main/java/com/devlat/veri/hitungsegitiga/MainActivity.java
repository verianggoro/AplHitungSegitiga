package com.devlat.veri.hitungsegitiga;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    Button BtnKell, BtnLuas, BtnReset;
    EditText InAlas, InTinggi, InSisi;
    TextView OutHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnKell = (Button)findViewById(R.id.BtnKell);
        BtnLuas = (Button)findViewById(R.id.BtnLuas);
        BtnReset = (Button)findViewById(R.id.BtnReset);
        InAlas = (EditText)findViewById(R.id.InputAlas);
        InSisi = (EditText)findViewById(R.id.InputSisi);
        InTinggi = (EditText)findViewById(R.id.InputTinggi);
        OutHasil = (TextView)findViewById(R.id.TvHasil);

        BtnKell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InAlas.length() == 0 && InTinggi.length() == 0 && InSisi.length() == 0){ //Jika Ketiga Kolom kosong
                    Toast.makeText(getApplication(), "Kolom Alas dan Tinggi Harus Kosong", Toast.LENGTH_LONG).show();
                }else if (InAlas.length() == 0 && InSisi.length() == 0){ //Jika Kolom Tinggi terisi
                    Toast.makeText(getApplication(), "Kolom Tinggi Harus Kosong dan Kolom Sisi Harus Terisi", Toast.LENGTH_LONG).show();
                }else if (InTinggi.length() == 0 && InSisi.length() == 0){ //Jika Kolom Alas terisi
                    Toast.makeText(getApplication(), "Kolom Alas Harus Kosong dan Kolom Sisi harus terisi", Toast.LENGTH_LONG).show();
                }else if (InAlas.length() == 0 && InTinggi.length() == 0){ //Jika Kolom sisi terisi
                    int kel = Integer.parseInt(InSisi.getText().toString());
                    int hasil = kel + kel + kel;
                    OutHasil.setText(String.valueOf(hasil));
                }else if (InAlas.length() == 0){ //Jika kolom Tinggi dan sisi terisi
                    Toast.makeText(getApplication(), "Kolom Tinggi Harus Kosong", Toast.LENGTH_LONG).show();
                }else if (InTinggi.length() == 0){ //Jika kolom Alas dan sisi Terisi
                    Toast.makeText(getApplication(), "Kolom Alas Harus Kosong", Toast.LENGTH_LONG).show();
                }else if (InSisi.length() == 0){ //Jika kolom alas dan tinggi terisi
                    Toast.makeText(getApplication(), "Kolom Sisi Harus Terisi", Toast.LENGTH_LONG).show();
                }else{ //Ketiga Kolom Terisi
                    Toast.makeText(getApplication(), "Hanya Kolom Sisi Yang Harus Diisi", Toast.LENGTH_LONG).show();
                }
            }
        });
        BtnLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InAlas.length() == 0 && InTinggi.length() == 0 && InSisi.length() == 0){ //Jika Ketiga kolom terisi
                    Toast.makeText(getApplication(), "Kolom Sisi Harus kosong", Toast.LENGTH_LONG).show();
                }else if (InAlas.length() == 0 && InSisi.length() == 0){ //Jika kolom tinggi terisi
                    Toast.makeText(getApplication(), "Kolom Sisi Harus Kosong Dan Kolom Alas Harus Terisi", Toast.LENGTH_LONG).show();
                }else if (InTinggi.length() == 0 && InSisi.length() == 0){ //Jika Kolom alas terisi
                    Toast.makeText(getApplication(), "Kolom Sisi Harus Kosong dan Kolom Tinggi Harus Terisi", Toast.LENGTH_LONG).show();
                }else if (InTinggi.length() == 0 && InAlas.length() == 0){ //Jika Kolom sisi terisi
                    Toast.makeText(getApplication(), "Kolom Sisi Harus Kosong", Toast.LENGTH_LONG).show();
                }else if (InSisi.length() == 0){//Jika Kolom alas dan tinggi terisi
                    double alas = Double.valueOf(InAlas.getText().toString());
                    double tinggi = Double.valueOf(InTinggi.getText().toString());
                    double hasil = (alas * tinggi) / 2;
                    String hasilFinal = Double.toString(hasil);
                    OutHasil.setText(hasilFinal);
                }else if (InAlas.length() == 0){ //Jika kolom Tinggi dan sisi terisi
                    Toast.makeText(getApplication(), "Kolom sisi Harus Kosong", Toast.LENGTH_LONG).show();
                }else if (InTinggi.length() == 0){ //Jika Kolom alas dan sis terisi
                    Toast.makeText(getApplication(), "Kolom sisi harus Kosong", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplication(), "Kolom Alas dan Tinggi Harus Terisi", Toast.LENGTH_LONG).show();
                }
            }
        });
        BtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InAlas.getText().clear();
                InTinggi.getText().clear();
                InSisi.getText().clear();
                OutHasil.setText("0");
            }
        });
    }
}
