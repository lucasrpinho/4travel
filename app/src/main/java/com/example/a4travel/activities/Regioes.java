package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;

public class Regioes extends AppCompatActivity implements View.OnClickListener  {
    private final AppCompatActivity activity = Regioes.this;
    private ImageButton btn_guaratiba, btn_recreio, btn_barradatijuca, btn_copacabana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regioes);
        getSupportActionBar().hide();


        initViews();
        initListeners();
    }

    private void initViews(){
        btn_barradatijuca = (ImageButton) findViewById(R.id.btn_barradatijuca);
        btn_guaratiba = (ImageButton) findViewById(R.id.btn_guaratiba);
        btn_recreio = (ImageButton) findViewById(R.id.btn_recreio);
        btn_copacabana = (ImageButton) findViewById(R.id.btn_copacabana);
    }

    private void initListeners() {
        btn_recreio.setOnClickListener(this);
        btn_barradatijuca.setOnClickListener(this);
        btn_guaratiba.setOnClickListener(this);
        btn_copacabana.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_barradatijuca:
                Intent barra = new Intent(activity, opcoesRoteiro.class);
                startActivity(barra);
                break;
            case R.id.btn_copacabana:
                Intent copa = new Intent (activity, opcoesRoteiro.class);
                startActivity(copa);
                break;
            case R.id.btn_recreio:
                Intent recreio = new Intent(activity, opcoesRoteiro.class);
                startActivity(recreio);
                break;
            case R.id.btn_guaratiba:
                Intent guaratiba = new Intent(activity, opcoesRoteiro.class);
                startActivity(guaratiba);
                break;
        }
    }
}