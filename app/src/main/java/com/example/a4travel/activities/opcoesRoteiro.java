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
               String email = getIntent().getStringExtra("EMAIL");

                if (regiao.equals("copacabana")){
                    if (precisoPasseio.isChecked()) {
                        Intent passeio1 = new Intent(this, passeiosCopa.class);
                        passeio1.putExtra("EMAIL", email);
                        passeio1.putExtra("OPÇÃO", "passeio");
                        startActivity(passeio1);
                        break;
                    }
                    if (precisoGastronomia.isChecked()){
                        Intent gastronomia1 = new Intent (this, gastronomiaCopa.class);
                        gastronomia1.putExtra("EMAIL", email);
                        gastronomia1.putExtra("OPÇÃO", "gastronomia");
                        startActivity(gastronomia1);
                        break;
                    }
                    if (precisoHotel.isChecked()){
                        Intent hotel1 = new Intent(this, hoteisCopacabana.class);
                        hotel1.putExtra("EMAIL", email);
                        hotel1.putExtra("OPÇÃO", "hotel");
                        startActivity(hotel1);
                        break;
                    }

                    if (roteiroCompleto.isChecked()){
                        Intent completo1 = new Intent(this, hoteisCopacabana.class);
                        completo1.putExtra("EMAIL", email);
                        completo1.putExtra("OPÇÃO", "completo");
                        startActivity(completo1);
                        break;
                    }
                }

               if (regiao.equals("recreio")){
                 if (precisoPasseio.isChecked()) {
                     Intent passeio = new Intent(this, passeiosRecreio.class);
                     passeio.putExtra("EMAIL", email);
                     passeio.putExtra("OPÇÃO", "passeio");
                    startActivity(passeio);
                     break;
                }
                 if (precisoGastronomia.isChecked()){
                     Intent gastronomia = new Intent (this, gastronomiaRecreio.class);
                     gastronomia.putExtra("EMAIL", email);
                     gastronomia.putExtra("OPÇÃO", "gastronomia");
                     startActivity(gastronomia);
                     break;
                 }
                 if (precisoHotel.isChecked()){
                     Intent hotel = new Intent(this, hoteisRecreio.class);
                     hotel.putExtra("EMAIL", email);
                     hotel.putExtra("OPÇÃO", "hotel");
                     startActivity(hotel);
                     break;
                 }

                 if (roteiroCompleto.isChecked()){
                     Intent completo = new Intent(this, hoteisRecreio.class);
                     completo.putExtra("EMAIL", email);
                     completo.putExtra("OPÇÃO", "completo");
                     startActivity(completo);
                     break;
                 }
             }
            if (regiao.equals("barra")){
                if (precisoPasseio.isChecked()) {
                    Intent passeio = new Intent(this, passeiosBarra.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", "passeio");
                    startActivity(passeio);
                    break;
                }
                if (precisoGastronomia.isChecked()){
                    Intent gastronomia = new Intent (this, gastronomiaBarra.class);
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "gastronomia");
                    startActivity(gastronomia);
                    break;
                }
                if (precisoHotel.isChecked()){
                    Intent hotel = new Intent(this, hoteisBarra.class);
                    hotel.putExtra("EMAIL", email);
                    hotel.putExtra("OPÇÃO", "hotel");
                    startActivity(hotel);
                    break;
                }

                if (roteiroCompleto.isChecked()){
                    Intent completo = new Intent(this, hoteisBarra.class);
                    completo.putExtra("EMAIL", email);
                    completo.putExtra("OPÇÃO", "completo");
                    startActivity(completo);
                    break;
                }
            }
        }
    }
}