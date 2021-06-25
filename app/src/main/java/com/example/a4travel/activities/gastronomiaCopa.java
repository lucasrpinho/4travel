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

public class gastronomiaCopa extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = gastronomiaCopa.this;
    private DatabaseHelper databaseHelper;
    private TextView mondego, lamole, pergula, doncamillo, conversafora, eclipse, paocia;
    private ImageButton btnMondegoAlmoço, btnMondegoNoite, btnLamoleAlmoço, btnLaMoleNoite, btnPergulaAlmoço, btnPergulaNoite, btnDoncamilloAlmoço, btnCamilloNoite;
    private ImageButton btnConversaforaAlmoço, btnConversaforaNoite, btnEclipseAlmoço, btnEclipseNoite, btnpaociaManha, btnpaociaNoite;
    private Button nextScreen4;

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
        paocia = (TextView) findViewById(R.id.paocia);
        btnConversaforaAlmoço = (ImageButton) findViewById(R.id.btnConversaAlmoço);
        btnConversaforaNoite = (ImageButton) findViewById(R.id.btnConversaNoite);
        btnDoncamilloAlmoço = (ImageButton) findViewById(R.id.btnCamilloAlmoço);
        btnCamilloNoite = (ImageButton) findViewById(R.id.btnCamilloNoite);
        btnEclipseAlmoço = (ImageButton) findViewById(R.id.btnEclipseAlmoço);
        btnEclipseNoite = (ImageButton) findViewById(R.id.btnEclipseNoite);
        btnLamoleAlmoço = (ImageButton) findViewById(R.id.btnLamoleAlmoço);
        btnLaMoleNoite = (ImageButton) findViewById(R.id.btnLamoleNoite);
        btnPergulaNoite = (ImageButton) findViewById(R.id.btnPergulaNoite);
        btnPergulaAlmoço = (ImageButton) findViewById(R.id.btnPergulaAlmoço);
        btnMondegoAlmoço = (ImageButton) findViewById(R.id.btnMondegoAlmoço);
        btnMondegoNoite = (ImageButton) findViewById(R.id.btnMondegoNoite);
        nextScreen4 = (Button) findViewById(R.id.nextScreen4);
        btnpaociaManha = (ImageButton) findViewById(R.id.btnPaoCia);
        btnpaociaNoite = (ImageButton) findViewById(R.id.btnPaoCiaNoturno);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnMondegoAlmoço.setOnClickListener(this);
        btnMondegoNoite.setOnClickListener(this);
        btnPergulaAlmoço.setOnClickListener(this);
        btnPergulaNoite.setOnClickListener(this);
        btnLamoleAlmoço.setOnClickListener(this);
        btnLaMoleNoite.setOnClickListener(this);
        btnEclipseAlmoço.setOnClickListener(this);
        btnEclipseNoite.setOnClickListener(this);
        btnDoncamilloAlmoço.setOnClickListener(this);
        btnCamilloNoite.setOnClickListener(this);
        btnConversaforaAlmoço.setOnClickListener(this);
        btnConversaforaNoite.setOnClickListener(this);
        btnpaociaNoite.setOnClickListener(this);
        btnpaociaManha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String opcao = getIntent().getStringExtra("OPÇÃO");
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnLamoleAlmoço:
                String gastronomia = lamole.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLamoleNoite:
                gastronomia = lamole.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEclipseAlmoço:
                gastronomia = eclipse.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEclipseNoite:
                gastronomia = eclipse.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMondegoAlmoço:
                gastronomia = mondego.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMondegoNoite:
                gastronomia = mondego.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCamilloAlmoço:
                gastronomia = doncamillo.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCamilloNoite:
                gastronomia = doncamillo.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnConversaAlmoço:
                gastronomia = conversafora.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnConversaNoite:
                gastronomia = conversafora.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPergulaAlmoço:
                gastronomia = pergula.getText().toString().trim();
                databaseHelper.addGastronomiaAlmoço(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPergulaNoite:
                gastronomia = conversafora.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPaoCia:
                gastronomia = paocia.getText().toString().trim();
                databaseHelper.addGastronomiaMatinal(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPaoCiaNoturno:
                gastronomia = paocia.getText().toString().trim();
                databaseHelper.addGastronomiaNoturno(email, gastronomia);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextScreen4:
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