package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.adapters.RoteiroAdapter;

public class passeiosCopa extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosCopa.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnMuseudoForteManha, btnMuseudoForteTarde, btnCalcadaoManha, btnCalcadaoTarde, btnCalcadaoNoite, btnChacrinhaManha, btnChacrinhaTarde, btnCarlosManha, btnCarlosTarde, btnCarlosNoite;
    private Button nextScreen5;
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
        nextScreen5 = (Button) findViewById(R.id.nextScreen5);

        btnCalcadaoManha = (ImageButton) findViewById(R.id.btnCalçadaoManha);
        btnCalcadaoTarde = (ImageButton) findViewById(R.id.btnCalçadaoTarde);
        btnCalcadaoNoite = (ImageButton) findViewById(R.id.btnCalçadaoNoite);
        btnCarlosManha = (ImageButton) findViewById(R.id.btnCarlosManha);
        btnCarlosTarde = (ImageButton) findViewById(R.id.btnCarlosTarde);
        btnCarlosNoite = (ImageButton) findViewById(R.id.btnCarlosNoite);
        btnChacrinhaManha = (ImageButton) findViewById(R.id.btnChacrinhaManha);
        btnChacrinhaTarde = (ImageButton) findViewById(R.id.btnChacrinhaTarde);
        btnMuseudoForteManha = (ImageButton) findViewById(R.id.btnMuseuForteManha);
        btnMuseudoForteTarde = (ImageButton) findViewById(R.id.btnMuseuForteTarde);
    }

    private void initListeners(){
        btnMuseudoForteManha.setOnClickListener(this);
        btnMuseudoForteTarde.setOnClickListener(this);
        btnChacrinhaManha.setOnClickListener(this);
        btnChacrinhaTarde.setOnClickListener(this);
        btnCarlosManha.setOnClickListener(this);
        btnCarlosTarde.setOnClickListener(this);
        btnCarlosNoite.setOnClickListener(this);
        btnCalcadaoManha.setOnClickListener(this);
        btnCalcadaoTarde.setOnClickListener(this);
        btnCalcadaoNoite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnChacrinhaManha:
                String passeio = chacrinha.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnChacrinhaTarde:
                passeio = chacrinha.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCarlosManha:
                passeio = carlos.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCarlosTarde:
                passeio = carlos.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCarlosNoite:
                passeio = carlos.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCalçadaoManha:
                passeio = calcadao.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCalçadaoTarde:
                passeio = calcadao.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnCalçadaoNoite:
                passeio = calcadao.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnMuseuForteManha:
                passeio = museudoforte.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.btnMuseuForteTarde:
                passeio = museudoforte.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
            case R.id.nextScreen5:
                Intent roteiro = new Intent(this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
        }
    }
}