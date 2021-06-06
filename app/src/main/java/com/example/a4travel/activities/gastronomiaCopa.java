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

public class gastronomiaCopa extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaCopa.this;
    private DatabaseHelper databaseHelper;
    private TextView mondego, lamole, pergula, doncamillo, conversafora, eclipse;
    private ImageButton btnMondego, btnLamole, btnPergula, btnDoncamillo, btnConversafora, btnEclipse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_copa);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        mondego = (TextView) findViewById(R.id.mondego);
        lamole = (TextView) findViewById(R.id.lamole);
        conversafora = (TextView) findViewById(R.id.conversafora);
        pergula = (TextView) findViewById(R.id.pergula);
        doncamillo = (TextView) findViewById(R.id.doncamillo);
        eclipse = (TextView) findViewById(R.id.eclipse);
        btnConversafora = (ImageButton) findViewById(R.id.btnConversa);
        btnDoncamillo = (ImageButton) findViewById(R.id.btnDoncamillo);
        btnEclipse = (ImageButton) findViewById(R.id.btnEclipse);
        btnLamole = (ImageButton) findViewById(R.id.btnLamole);
        btnPergula = (ImageButton) findViewById(R.id.btnPergula);
        btnMondego = (ImageButton) findViewById(R.id.btnMondego);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnMondego.setOnClickListener(this);
        btnPergula.setOnClickListener(this);
        btnLamole.setOnClickListener(this);
        btnEclipse.setOnClickListener(this);
        btnDoncamillo.setOnClickListener(this);
        btnConversafora.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        switch (view.getId()){
            case R.id.btnLamole:
                String gastronomia = lamole.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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
            case R.id.btnEclipse:
                gastronomia = eclipse.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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
            case R.id.btnMondego:
                gastronomia = mondego.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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
            case R.id.btnDoncamillo:
                gastronomia = doncamillo.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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

            case R.id.btnConversa:
                gastronomia = conversafora.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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
            case R.id.btnPergula:
                gastronomia = pergula.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosCopa.class);
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