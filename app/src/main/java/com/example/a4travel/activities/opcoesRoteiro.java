package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;

public class opcoesRoteiro extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = opcoesRoteiro.this;
    private RadioButton roteiroCompleto, precisoHotel, precisoPasseio, precisoGastronomia;
    private Button btnContinuar;
    private Regioes regioes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roteiro);
        getSupportActionBar().hide();

        initViews();
        initListeners();

    }

    private void initViews(){
        roteiroCompleto = (RadioButton) findViewById(R.id.roteiroCompleto);
        precisoGastronomia = (RadioButton) findViewById(R.id.precisoGastronomia);
        precisoHotel = (RadioButton) findViewById(R.id.precisoHotel);
        precisoPasseio = (RadioButton) findViewById(R.id.precisoPasseio);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
    }

    private void initListeners(){
        btnContinuar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnContinuar:
               String regiao = getIntent().getStringExtra("REGIÃO");
               if (regiao.equals("recreio")){
                 if (precisoPasseio.isChecked()) {
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    startActivity(passeio);
                }
                 if (precisoGastronomia.isChecked()){
                     Intent gastronomia = new Intent (this, gastronomiaRecreio.class);
                     startActivity(gastronomia);
                 }
                 if (precisoHotel.isChecked() || roteiroCompleto.isChecked()){
                     Intent hotel = new Intent(this, hoteisRecreio.class);
                     startActivity(hotel);
                 }

            break;
            }
        }
    }
}