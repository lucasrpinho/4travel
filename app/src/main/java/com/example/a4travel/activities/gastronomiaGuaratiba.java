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

public class gastronomiaGuaratiba extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaGuaratiba.this;
    private DatabaseHelper databaseHelper;
    private TextView tropicana, bira, tiapenha, aquarios, mirante;
    private ImageButton btnTropicana, btnBira, btnTiapenha, btnAquarios, btnMirante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_guaratiba);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        tropicana = (TextView) findViewById(R.id.tropicana);
        bira = (TextView) findViewById(R.id.bira);
        aquarios = (TextView) findViewById(R.id.aquarios);
        mirante = (TextView) findViewById(R.id.mirante);
        tiapenha = (TextView) findViewById(R.id.tiapenha);
        btnAquarios = (ImageButton) findViewById(R.id.btnAquarios);
        btnBira = (ImageButton) findViewById(R.id.btnBira);
        btnMirante = (ImageButton) findViewById(R.id.btnMirante);
        btnTropicana = (ImageButton) findViewById(R.id.btnTropicana);
        btnTiapenha = (ImageButton) findViewById(R.id.btnTiapenha);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnTiapenha.setOnClickListener(this);
        btnTropicana.setOnClickListener(this);
        btnMirante.setOnClickListener(this);
        btnBira.setOnClickListener(this);
        btnAquarios.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        switch (view.getId()){
            case R.id.btnTiapenha:
                String gastronomia = tiapenha.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosGuaratiba.class);
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
            case R.id.btnTropicana:
                gastronomia = tropicana.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosGuaratiba.class);
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
            case R.id.btnMirante:
                gastronomia = mirante.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosGuaratiba.class);
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
            case R.id.btnBira:
                gastronomia = bira.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosGuaratiba.class);
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

            case R.id.btnAquarios:
                gastronomia = aquarios.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosGuaratiba.class);
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