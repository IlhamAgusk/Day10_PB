package com.example.day10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String makanan = extras.getString("MenuMakanan");
            String minuman = extras.getString("MenuMinuman");
            String jumlahPorsi = extras.getString("jumlah");
            int totalHarga = extras.getInt("totalHarga");

            // Menampilkan data pada TextView
            tv1.setText("Menu : " + makanan);
            tv2.setText("Minuman : " + minuman);
            tv3.setText("Jumlah Porsi : " + jumlahPorsi);
            tv4.setText("Total : "+"Rp." + totalHarga );
        }
    }
}