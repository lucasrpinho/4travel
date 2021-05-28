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
import com.example.a4travel.model.User;

public class gastronomiaRecreio extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = gastronomiaRecreio.this;
    private TextView riosul, bahamas, nabrasa, kacua, parme, riozen;
    private ImageButton btnriosul, btnbahamas, btnNabrasa, btnKacua, btnParme, btnriozen;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_recreio);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        riosul = (TextView) findViewById(R.id.riosul);
        bahamas = (TextView) findViewById(R.id.bahamas);
        nabrasa = (TextView) findViewById(R.id.nabrasa);
        kacua = (TextView) findViewById(R.id.kacua);
        parme = (TextView) findViewById(R.id.parme);
        riozen = (TextView) findViewById(R.id.riozen);
        btnbahamas = (ImageButton) findViewById(R.id.btnBahamas);
        btnKacua = (ImageButton) findViewById(R.id.btnKacua);
        btnNabrasa = (ImageButton) findViewById(R.id.btnNaBrasa);
        btnriosul = (ImageButton) findViewById(R.id.btnRiosul);
        btnriozen = (ImageButton) findViewById(R.id.btnRiozen);
        btnParme = (ImageButton) findViewById(R.id.btnParme);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    private void initListeners() {
        btnriozen.setOnClickListener(this);
        btnriosul.setOnClickListener(this);
        btnNabrasa.setOnClickListener(this);
        btnbahamas.setOnClickListener(this);
        btnParme.setOnClickListener(this);
        btnKacua.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        switch (view.getId()){
            case R.id.btnBahamas:
                String gastronomia = bahamas.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
            case R.id.btnRiosul:
                gastronomia = riosul.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
            case R.id.btnRiozen:
                gastronomia = riozen.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
            case R.id.btnParme:
                gastronomia = parme.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnNaBrasa:
                gastronomia = nabrasa.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
            case R.id.btnKacua:
                gastronomia = kacua.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
                    passeio.putExtra("OPÇÃO", opcao);
                    startActivity(passeio);
                    break;
                }
                if (opcao.equals("gastronomia")) {
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
        }
    }
}