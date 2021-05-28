package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.model.User;
import com.example.a4travel.model.roteiro;

public class Regioes extends AppCompatActivity implements View.OnClickListener  {
    private final AppCompatActivity activity = Regioes.this;
    private DatabaseHelper databaseHelper;
    private User user;
    private com.example.a4travel.model.roteiro Roteiro;
    private ImageButton btn_guaratiba, btn_recreio, btn_barradatijuca, btn_copacabana;
    private TextView copacabana, guaratiba, recreiodosbandeirantes, barradatijuca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regioes);
        getSupportActionBar().hide();


        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){
        btn_barradatijuca = (ImageButton) findViewById(R.id.btn_barradatijuca);
        btn_guaratiba = (ImageButton) findViewById(R.id.btn_guaratiba);
        btn_recreio = (ImageButton) findViewById(R.id.btn_recreio);
        btn_copacabana = (ImageButton) findViewById(R.id.btn_copacabana);
        copacabana = (TextView) findViewById(R.id.copacabana);
        recreiodosbandeirantes = (TextView) findViewById(R.id.recreio);
        barradatijuca = (TextView) findViewById(R.id.barradatijuca);
        guaratiba = (TextView) findViewById(R.id.guaratiba);
    }

    private void initListeners() {
        btn_recreio.setOnClickListener(this);
        btn_barradatijuca.setOnClickListener(this);
        btn_guaratiba.setOnClickListener(this);
        btn_copacabana.setOnClickListener(this);
    }

    private void initObjects(){
         databaseHelper = new DatabaseHelper(this);
         Roteiro = new roteiro();
         user = new User();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_barradatijuca:

                Intent barra = new Intent(activity, opcoesRoteiro.class);
                String regiao = barradatijuca.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addRegiao(email, regiao);
                barra.putExtra("REGIÃO", "barra");
                startActivity(barra);
                break;
            case R.id.btn_copacabana:
                Intent copa = new Intent (activity, opcoesRoteiro.class);
                regiao = copacabana.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addRegiao(email, regiao);
                copa.putExtra("REGIÃO", "copa");
                startActivity(copa);
                break;
            case R.id.btn_recreio:
                Intent recreioTela = new Intent(activity, opcoesRoteiro.class);
                regiao = recreiodosbandeirantes.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addRegiao(email, regiao);
                recreioTela.putExtra("REGIÃO", "recreio");
                recreioTela.putExtra("EMAIL", email);
                startActivity(recreioTela);
                break;
            case R.id.btn_guaratiba:
                Intent guaratibaTela= new Intent(activity, opcoesRoteiro.class);
                regiao = guaratiba.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addRegiao(email, regiao);
                guaratibaTela.putExtra("REGIÃO", "guaratiba");
                startActivity(guaratibaTela);
                break;
        }
    }
}