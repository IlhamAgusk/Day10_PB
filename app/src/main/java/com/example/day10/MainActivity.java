// MainActivity.java
package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_1, rg2;
    TextView jmlPorsi;
    Button btn1;

    private final int HARGA_NASIGORENG = 10000;
    private final int HARGA_MIEGORENG = 8000;
    private final int HARGA_MIEREBUS = 8000;
    private final int HARGA_NASIUDUK = 15000;

    private final int HARGA_TEHES = 5000;
    private final int HARGA_ESJERUK = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_1 = findViewById(R.id.rg_1);
        rg2 = findViewById(R.id.rg2);
        jmlPorsi = findViewById(R.id.ed1);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan();
            }
        });
    }

    private void pesan() {
        RadioButton selectedMakananRadioButton = findViewById(rg_1.getCheckedRadioButtonId());
        RadioButton selectedMinumanRadioButton = findViewById(rg2.getCheckedRadioButtonId());

        if (selectedMakananRadioButton == null || selectedMinumanRadioButton == null) {
            Toast.makeText(this, "Mohon Pilih Menu!", Toast.LENGTH_SHORT).show();
            return;
        }

        String makanan = selectedMakananRadioButton.getText().toString();
        String minuman = selectedMinumanRadioButton.getText().toString();
        String jumlahPorsi = jmlPorsi.getText().toString();

        if (jumlahPorsi.isEmpty()) {
            Toast.makeText(this, "Mohon Tentukan Jumlah", Toast.LENGTH_SHORT).show();
            return;
        }

        int jumlah = Integer.parseInt(jumlahPorsi);

        int hargaMakanan = getHargaMakanan(makanan);
        int hargaMinuman = getHargaMinuman(minuman);

        int totalHarga = (hargaMakanan + hargaMinuman) * jumlah;

        // Mengirim data ke activity hasil
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("MenuMakanan", makanan);
        intent.putExtra("MenuMinuman", minuman);
        intent.putExtra("jumlah", jumlahPorsi);
        intent.putExtra("totalHarga", totalHarga);
        startActivity(intent);
    }

    private int getHargaMakanan(String makanan) {
        switch (makanan) {
            case "Nasi Goreng":
                return HARGA_NASIGORENG;
            case "Mie Goreng":
                return HARGA_MIEGORENG;
            case "Mie Rebus":
                return HARGA_MIEREBUS;
            case "Nasi Uduk":
                return HARGA_NASIUDUK;
            default:
                return 0;
        }
    }

    private int getHargaMinuman(String minuman) {
        switch (minuman) {
            case "Teh Es":
                return HARGA_TEHES;
            case "Es Jeruk":
                return HARGA_ESJERUK;
            default:
                return 0;
        }
    }
}