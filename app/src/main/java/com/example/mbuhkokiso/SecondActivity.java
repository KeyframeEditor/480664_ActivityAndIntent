package com.example.mbuhkokiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textMenu;
    TextView textJenis;
    EditText editTextJumlah;
    Button btnOK;
    public static final String jumlahKey = "JUMLAH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textMenu = findViewById(R.id.textMenu);
        textJenis= findViewById(R.id.textJenis);
        editTextJumlah = findViewById(R.id.editTextJumlah);
        btnOK = findViewById(R.id.btnOK);

        Intent intent = getIntent();
        String teks = intent.getStringExtra(MainActivity.MainActivityKey_Menu);
        String jenis = intent.getStringExtra(MainActivity.MainActivityKey_Jenis);
        textMenu.setText(teks);
        textJenis.setText(jenis);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textJumlah = editTextJumlah.getText().toString();
                Intent secondIntent = new Intent();
                secondIntent.putExtra(jumlahKey,textJumlah);
                setResult(RESULT_OK,secondIntent);
                finish();
            }
        });
    }
}
