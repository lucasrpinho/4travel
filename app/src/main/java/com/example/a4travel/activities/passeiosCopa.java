package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.adapters.RoteiroAdapter;

public class passeiosCopa extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosCopa.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnMuseudoForte, btnCalcadao, btnChacrinha, btnCarlos;
    private TextView museudoforte, calcadao, chacrinha, carlos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeios_copa);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initViews() {
        calcadao = (TextView) findViewById(R.id.calcadao);
        carlos = (TextView) findViewById(R.id.carlos);
        chacrinha = (TextView) findViewById(R.id.chacrinha);
        museudoforte = (TextView) findViewById(R.id.museuforte);


        btnCalcadao = (ImageButton) findViewById(R.id.btnCalcadao);
        btnCarlos = (ImageButton) findViewById(R.id.btnCarlos);
        btnChacrinha = (ImageButton) findViewById(R.id.btnChacrinha);
        btnMuseudoForte = (ImageButton) findViewById(R.id.btnMuseudoForte);
    }

    private void initListeners(){
        btnMuseudoForte.setOnClickListener(this);
        btnChacrinha.setOnClickListener(this);
        btnCarlos.setOnClickListener(this);
        btnCalcadao.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnChacrinha:
                String passeio = chacrinha.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro = new Intent(this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
            case R.id.btnCarlos:
                passeio = carlos.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro2 = new Intent(this, RoteiroAdapter.class);
                roteiro2.putExtra("EMAIL", email);
                startActivity(roteiro2);
                break;
            case R.id.btnCalcadao:
                passeio = calcadao.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro3 = new Intent(this, RoteiroAdapter.class);
                roteiro3.putExtra("EMAIL", email);
                startActivity(roteiro3);
                break;
            case R.id.btnMuseudoForte:
                passeio = museudoforte.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro4 = new Intent(this, RoteiroAdapter.class);
                roteiro4.putExtra("EMAIL", email);
                startActivity(roteiro4);
                break;
        }
    }
}