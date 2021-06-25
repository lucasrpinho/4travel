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
import com.example.a4travel.model.User;

public class gastronomiaRecreio extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = gastronomiaRecreio.this;
    private TextView riosul, bahamas, nabrasa, kacua, parme, riozen, reidorecreio;
    private ImageButton btnriosulAlmoço, btnriosulNoturno, btnbahamasAlmoço, btnReiManha, btnReiAlmoço, btnReiNoite;
    private ImageButton btnbahamasNoturno,  btnNabrasaAlmoço, btnNabrasaNoturno;
    private ImageButton  btnKacuaAlmoço, btnKacuaNoturno,  btnParmeAlmoço, btnParmeNoturno, btnriozenAlmoço, btnriozenNoturno;
    private DatabaseHelper databaseHelper;
    private Button nextScreen;
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
        reidorecreio = (TextView) findViewById(R.id.reidorecreio);
        nextScreen = (Button) findViewById(R.id.nextScreen);
        btnbahamasAlmoço = (ImageButton) findViewById(R.id.btnBahamasAlmoço);
        btnReiAlmoço = (ImageButton) findViewById(R.id.btnReiAlmoço);
        btnReiManha = (ImageButton) findViewById(R.id.btnReiManha);
        btnReiNoite = (ImageButton) findViewById(R.id.btnReiNoturno);
        btnbahamasNoturno = (ImageButton) findViewById(R.id.btnBahamasNoturno);
        btnKacuaAlmoço = (ImageButton) findViewById(R.id.btnKacuaAlmoço);
        btnKacuaNoturno = (ImageButton) findViewById(R.id.btnKacuaNoturno);
        btnNabrasaAlmoço = (ImageButton) findViewById(R.id.btnNabrasaAlmoço);
        btnNabrasaNoturno = (ImageButton) findViewById(R.id.btnNabrasaNoturno);
        btnriosulAlmoço = (ImageButton) findViewById(R.id.btnRioSulAlmoço);
        btnriosulNoturno = (ImageButton) findViewById(R.id.btnRioSulNoturno);
        btnriozenAlmoço = (ImageButton) findViewById(R.id.btnRiozenVespertino);
        btnriozenNoturno = (ImageButton) findViewById(R.id.btnRioZenNoturno);
        btnParmeAlmoço = (ImageButton) findViewById(R.id.btnParmeAlmoço);
        btnParmeNoturno = (ImageButton) findViewById(R.id.btnParmeNoturno);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    private void initListeners() {
        btnriozenAlmoço.setOnClickListener(this);
        btnriozenNoturno.setOnClickListener(this);
        btnriosulAlmoço.setOnClickListener(this);
        btnriosulNoturno.setOnClickListener(this);
        btnNabrasaAlmoço.setOnClickListener(this);
        btnNabrasaNoturno.setOnClickListener(this);
        btnbahamasAlmoço.setOnClickListener(this);
        btnbahamasNoturno.setOnClickListener(this);
        btnParmeAlmoço.setOnClickListener(this);
        btnParmeNoturno.setOnClickListener(this);
        btnKacuaAlmoço.setOnClickListener(this);
        btnKacuaNoturno.setOnClickListener(this);
        nextScreen.setOnClickListener(this);
        btnReiNoite.setOnClickListener(this);
        btnReiManha.setOnClickListener(this);
        btnReiAlmoço.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnBahamasAlmoço:
                String gastronomia = bahamas.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBahamasNoturno:
                gastronomia = bahamas.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReiManha:
                gastronomia = reidorecreio.getText().toString().trim();
                databaseHelper.addGastronomiaMatinal(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReiAlmoço:
                gastronomia = reidorecreio.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReiNoturno:
                gastronomia = reidorecreio.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRioSulAlmoço:
                gastronomia = riosul.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRioSulNoturno:
                gastronomia = riosul.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRiozenVespertino:
                gastronomia = riozen.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRioZenNoturno:
                gastronomia = riozen.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnParmeAlmoço:
                gastronomia = parme.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnParmeNoturno:
                gastronomia = parme.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNabrasaAlmoço:
                gastronomia = nabrasa.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNabrasaNoturno:
                gastronomia = nabrasa.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnKacuaAlmoço:
                gastronomia = kacua.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnKacuaNoturno:
                gastronomia = kacua.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextScreen:
                email = getIntent().getStringExtra("EMAIL");
                if (opcao.equals("completo")){
                    Intent passeio = new Intent(this, passeiosRecreio.class);
                    passeio.putExtra("EMAIL", email);
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