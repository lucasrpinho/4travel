package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.adapters.RoteiroAdapter;

public class passeiosGuaratiba extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosGuaratiba.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnBrisaManha, btnBrisaTarde, btnBrisaNoite, btnMagdalenaManha, btnMagdalenaTarde, btnMagdalenaNoite, btnArcaManha, btnArcaTarde;
    private TextView brisa, magdalena, arca;
    private Button nextScreen7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeios_guaratiba);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initViews() {
        brisa = (TextView) findViewById(R.id.brisa);
        magdalena = (TextView) findViewById(R.id.magdalena);
        arca = (TextView) findViewById(R.id.arcanoah);

        btnArcaManha = (ImageButton) findViewById(R.id.btnArcaManha);
        btnArcaTarde = (ImageButton) findViewById(R.id.btnArcaTarde);
        btnBrisaManha = (ImageButton) findViewById(R.id.btnBrisaManha);
        btnBrisaTarde = (ImageButton) findViewById(R.id.btnBrisaTarde);
        btnBrisaNoite = (ImageButton) findViewById(R.id.btnBrisaNoite);
        btnMagdalenaManha = (ImageButton) findViewById(R.id.btnCapelaManha);
        btnMagdalenaTarde = (ImageButton) findViewById(R.id.btnCapelaTarde);
        btnMagdalenaNoite = (ImageButton) findViewById(R.id.btnCapelaNoite);
    }

    private void initListeners(){
        btnMagdalenaManha.setOnClickListener(this);
        btnMagdalenaTarde.setOnClickListener(this);
        btnMagdalenaNoite.setOnClickListener(this);
        btnBrisaManha.setOnClickListener(this);
        btnBrisaTarde.setOnClickListener(this);
        btnBrisaNoite.setOnClickListener(this);
        btnArcaManha.setOnClickListener(this);
        btnArcaTarde.setOnClickListener(this);
        nextScreen7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnCapelaManha:
                String passeio = magdalena.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
            case R.id.btnCapelaTarde:
                passeio = magdalena.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
            case R.id.btnCapelaNoite:
                passeio = magdalena.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
            case R.id.btnBrisaManha:
                passeio = brisa.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
            case R.id.btnBrisaTarde:
                passeio = brisa.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
            case R.id.btnBrisaNoite:
                passeio = brisa.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
            case R.id.btnArcaManha:
                passeio = arca.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
            case R.id.btnArcaTarde:
                passeio = arca.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
            case R.id.nextScreen7:
                Intent roteiro = new Intent (this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
        }
    }
}