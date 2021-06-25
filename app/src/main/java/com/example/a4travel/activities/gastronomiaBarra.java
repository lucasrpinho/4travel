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

public class gastronomiaBarra extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaBarra.this;
    private DatabaseHelper databaseHelper;
    private TextView stadium, becco, delirio, domhelio, gabbiano, maccherone, santamarta;
    private ImageButton btnStadiumManha, btnStadiumMTarde, btnStadiumNoite, btnDomhelioManha, btnDomhelioTarde, btnDomhelioNoite, btnDelirioManha, btnDelirioTarde, btnDelirioNoite;
    private ImageButton  btnBeccoManha, btnBeccoTarde, btnBeccoNoite, btnGabbianoManha, btnGabbianoTarde, btnGabbianoNoite, btnMaccheroneManha, btnMaccheroneTarde, btnMaccheroneNoite;
    private ImageButton btnSantaMartaManha, btnSantaMartaTarde, btnSantaMartaNoite;
    private Button nextScreen2;
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
        nextScreen2 = (Button) findViewById(R.id.nextScreen2);
        btnBeccoTarde = (ImageButton) findViewById(R.id.btnBeccoAlmoço);
        btnBeccoNoite = (ImageButton) findViewById(R.id.btnBeccoNoite);
        btnDelirioNoite = (ImageButton) findViewById(R.id.btnDelirioNoite);
        btnDelirioManha = (ImageButton) findViewById(R.id.btnDelirioManha);
        btnDomhelioTarde = (ImageButton) findViewById(R.id.btnDomHelioAlmoço);
        btnDomhelioNoite = (ImageButton) findViewById(R.id.btnDomHelioNoite);
        btnGabbianoTarde = (ImageButton) findViewById(R.id.btnGabbianoAlmoço);
        btnGabbianoNoite = (ImageButton) findViewById(R.id.btnGabbianoNoite);
        btnMaccheroneTarde = (ImageButton) findViewById(R.id.btnMaccheroneAlmoço);
        btnMaccheroneNoite = (ImageButton) findViewById(R.id.btnMaccheroneNoite);
        btnStadiumMTarde = (ImageButton) findViewById(R.id.btnStadiumAlmoço);
        btnStadiumNoite = (ImageButton) findViewById(R.id.btnStadiumNoite);
        btnSantaMartaTarde = (ImageButton) findViewById(R.id.btnSantaMartaTarde);
        btnSantaMartaNoite = (ImageButton) findViewById(R.id.btnSantaMartaNoite);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnStadiumMTarde.setOnClickListener(this);
        btnStadiumNoite.setOnClickListener(this);
        btnMaccheroneTarde.setOnClickListener(this);
        btnMaccheroneNoite.setOnClickListener(this);
        btnGabbianoNoite.setOnClickListener(this);
        btnGabbianoTarde.setOnClickListener(this);
        btnDomhelioTarde.setOnClickListener(this);
        btnDomhelioNoite.setOnClickListener(this);
        btnBeccoNoite.setOnClickListener(this);
        btnBeccoTarde.setOnClickListener(this);
        btnDelirioNoite.setOnClickListener(this);
        btnDelirioTarde.setOnClickListener(this);
        btnSantaMartaNoite.setOnClickListener(this);
        btnSantaMartaTarde.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnStadiumAlmoço:
                String gastronomia = stadium.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id.btnStadiumNoite:
                 gastronomia = stadium.getText().toString().trim();
                 email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnMaccheroneAlmoço:
                gastronomia = maccherone.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnMaccheroneNoite:
                gastronomia = maccherone.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id.btnGabbianoAlmoço:
                gastronomia = gabbiano.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnGabbianoNoite:
                gastronomia = gabbiano.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id.btnDomHelioAlmoço:
                gastronomia = domhelio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnDomHelioNoite:
                gastronomia = domhelio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnDelirioAlmoço:
                gastronomia = delirio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnDelirioNoite:
                gastronomia = delirio.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id.btnBeccoAlmoço:
                gastronomia = becco.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnBeccoNoite:
                gastronomia = becco.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnSantaMartaNoite:
                gastronomia = santamarta.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnSantaMartaManha:
                gastronomia = santamarta.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaMatinal(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id. btnSantaMartaTarde:
                gastronomia = santamarta.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();

            case R.id.nextScreen2:
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