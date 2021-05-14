package com.example.a4travel.activities;

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

    }
}