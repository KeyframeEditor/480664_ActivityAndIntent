package com.example.mbuhkokiso;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextMenu;
    Button btnMakanan;
    Button btnMinuman;
    TextView TextJumlah;
    public static final String MainActivityKey_Menu = "MENU";
    public static final String MainActivityKey_Jenis = "JENIS";
    public static final String MainActivityKey_Jenis_Makanan = "MAKANAN";
    public static final String MainActivityKey_Jenis_Minuman = "MINUMAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMenu = findViewById(R.id.editTextMenu);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnMinuman = findViewById(R.id.btnMinuman);
        TextJumlah = findViewById(R.id.TextJumlah);

        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextMenu.getText().toString();
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(MainActivityKey_Menu, text);
                intent.putExtra(MainActivityKey_Jenis, MainActivityKey_Jenis_Makanan);
                startActivityForResult(intent,1);
            }
        });

        btnMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextMenu.getText().toString();
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra(MainActivityKey_Menu, text);
                intent.putExtra(MainActivityKey_Jenis, MainActivityKey_Jenis_Minuman);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                String textJumlah = data.getStringExtra(SecondActivity.jumlahKey);
                TextJumlah.setText(textJumlah);
            }
        }
    }
}