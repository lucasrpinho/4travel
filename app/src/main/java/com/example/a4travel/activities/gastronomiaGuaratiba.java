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

public class gastronomiaGuaratiba extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaGuaratiba.this;
    private DatabaseHelper databaseHelper;
    private TextView tropicana, bira, tiapenha, aquarios, mirante, alegria;
    private ImageButton btnTropicanaAlmoço, btnTropicanaNoite, btnBiraAlmoço, btnBiraNoite, btnTiapenhaAlmoço, btnTiaNoite, btnAquariosAlmoço, btnAquariosNoite, btnMiranteAlmoço, btnMiranteNoite;
    private ImageButton btnAlegriaManha, btnAlegriaTarde, btnAlegriaNoite;
    private Button nextScreen6;

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
        alegria = (TextView) findViewById(R.id.alegria);
        btnAquariosAlmoço = (ImageButton) findViewById(R.id.btnAquariosAlmoço);
        btnAquariosNoite = (ImageButton) findViewById(R.id.btnAquariosNoite);
        btnBiraAlmoço = (ImageButton) findViewById(R.id.btnBiraAlmoço);
        btnBiraNoite = (ImageButton) findViewById(R.id.btnBiraNoite);
        btnMiranteAlmoço = (ImageButton) findViewById(R.id.btnMiranteAlmoço);
        btnMiranteNoite = (ImageButton) findViewById(R.id.btnMiranteNoite);
        btnTropicanaAlmoço = (ImageButton) findViewById(R.id.btnTropicanaAlmoço);
        btnTropicanaNoite = (ImageButton) findViewById(R.id.btnTropicanaNoite);
        btnTiapenhaAlmoço = (ImageButton) findViewById(R.id.btnTiaAlmoço);
        btnTiaNoite = (ImageButton) findViewById(R.id.btnTiaNoite);
        btnAlegriaManha = (ImageButton) findViewById(R.id.btnAlegriaManha);
        btnAlegriaTarde = (ImageButton) findViewById(R.id.btnAlegriaTarde);
        btnAlegriaNoite = (ImageButton) findViewById(R.id.btnAlegriaNoite);
        nextScreen6 = (Button) findViewById(R.id.nextScreen6);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnTiapenhaAlmoço.setOnClickListener(this);
        btnTiaNoite.setOnClickListener(this);
        btnTropicanaAlmoço.setOnClickListener(this);
        btnTropicanaNoite.setOnClickListener(this);
        btnMiranteAlmoço.setOnClickListener(this);
        btnMiranteNoite.setOnClickListener(this);
        btnBiraAlmoço.setOnClickListener(this);
        btnBiraNoite.setOnClickListener(this);
        btnAquariosAlmoço.setOnClickListener(this);
        btnAquariosNoite.setOnClickListener(this);
        btnAlegriaNoite.setOnClickListener(this);
        btnAlegriaTarde.setOnClickListener(this);
        btnAlegriaManha.setOnClickListener(this);
        nextScreen6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnTiaAlmoço:
                String gastronomia = tiapenha.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTiaNoite:
                gastronomia = tiapenha.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTropicanaAlmoço:
                gastronomia = tropicana.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTropicanaNoite:
                gastronomia = tropicana.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMiranteAlmoço:
                gastronomia = mirante.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMiranteNoite:
                gastronomia = mirante.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBiraAlmoço:
                gastronomia = bira.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBiraNoite:
                gastronomia = bira.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAquariosAlmoço:
                gastronomia = aquarios.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAquariosNoite:
                gastronomia = aquarios.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAlegriaManha:
                gastronomia = alegria.getText().toString().trim();
                databaseHelper.addGastronomiaMatinal(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAlegriaTarde:
                gastronomia = alegria.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAlegriaNoite:
                gastronomia = alegria.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextScreen6:
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