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

public class gastronomiaBarra extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaBarra.this;
    private DatabaseHelper databaseHelper;
    private TextView stadium, becco, delirio, domhelio, gabbiano, maccherone;
    private ImageButton btnStadium, btnDomhelio, btnDelirio, btnBecco, btnGabbiano, btnMaccherone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomia_barra);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        stadium = (TextView) findViewById(R.id.stadium);
        becco = (TextView) findViewById(R.id.becco);
        delirio = (TextView) findViewById(R.id.delirio);
        domhelio = (TextView) findViewById(R.id.domhelio);
        gabbiano = (TextView) findViewById(R.id.gabbiano);
        maccherone = (TextView) findViewById(R.id.maccherone);
        btnBecco = (ImageButton) findViewById(R.id.btnBecco);
        btnDelirio = (ImageButton) findViewById(R.id.btnDelirio);
        btnDomhelio = (ImageButton) findViewById(R.id.btnDomhelio);
        btnGabbiano = (ImageButton) findViewById(R.id.btnGabbiano);
        btnMaccherone = (ImageButton) findViewById(R.id.btnMaccherone);
        btnStadium = (ImageButton) findViewById(R.id.btnStadium);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnStadium.setOnClickListener(this);
        btnMaccherone.setOnClickListener(this);
        btnGabbiano.setOnClickListener(this);
        btnDomhelio.setOnClickListener(this);
        btnDelirio.setOnClickListener(this);
        btnBecco.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        switch (view.getId()){
            case R.id.btnStadium:
                String gastronomia = stadium.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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
            case R.id. btnMaccherone:
                gastronomia = maccherone.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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
            case R.id.btnGabbiano:
                gastronomia = gabbiano.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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
            case R.id.btnDomhelio:
                gastronomia = domhelio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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

            case R.id. btnDelirio:
                gastronomia = delirio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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
            case R.id.btnBecco:
                gastronomia = becco.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomia(email, gastronomia);

                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosBarra.class);
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