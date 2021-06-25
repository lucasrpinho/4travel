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

public class passeiosRecreio extends AppCompatActivity implements View.OnClickListener {
        private final AppCompatActivity activity = passeiosRecreio.this;
        private TextView praiasecreto, shoppingamericas, reserva, chicomendes, pedrapontal;
        private ImageButton btnPontalManha, btnPontalTarde, btnPontalNoite, btnreservaManha, btnreservaTarde, btnreservaNoite, btnamericasManha, btnamericasTarde, btnamericasNoite, btnsecretoManha, btnsecretoTarde, btnsecretoNoite, btnchicomendesManha, btnchicomendesTarde, btnchicomendesNoite;
        private DatabaseHelper databaseHelper;
        private Button proxTela;
        private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeios_recreio);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();

    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    private void initViews() {
        praiasecreto = (TextView) findViewById(R.id.praiasecreto);
        shoppingamericas = (TextView) findViewById(R.id.shoppingamericas);
        reserva = (TextView) findViewById(R.id.reserva);
        chicomendes = (TextView) findViewById(R.id.chicomendes);
        pedrapontal = (TextView) findViewById(R.id.pedrapontal);

        btnamericasManha = (ImageButton) findViewById(R.id.btnAmericasManha);
        btnamericasTarde = (ImageButton) findViewById(R.id.btnAmericasTarde);
        btnamericasNoite = (ImageButton) findViewById(R.id.btnAmericasNoite);
        btnchicomendesManha = (ImageButton) findViewById(R.id.btnChicoMendesManha);
        btnchicomendesTarde = (ImageButton) findViewById(R.id.btnChicoMendesTarde);
        btnchicomendesNoite = (ImageButton) findViewById(R.id.btnChicoMendesNoite);
        btnPontalManha = (ImageButton) findViewById(R.id.btnPontalManha);
        btnPontalTarde = (ImageButton) findViewById(R.id.btnPontalTarde);
        btnPontalNoite = (ImageButton) findViewById(R.id.btnPontalNoite);
        btnsecretoManha = (ImageButton) findViewById(R.id.btnSecretoManha);
        btnsecretoTarde = (ImageButton) findViewById(R.id.btnSecretoVespertino);
        btnsecretoNoite = (ImageButton) findViewById(R.id.btnSecretoNoite);
        btnreservaManha = (ImageButton) findViewById(R.id.btnReservaManha);
        btnreservaTarde = (ImageButton) findViewById(R.id.btnReservaTarde);
        btnreservaNoite = (ImageButton) findViewById(R.id.btnReservaNoite);
        proxTela = (Button) findViewById(R.id.proxTela);
    }

    private void initListeners(){
        btnreservaManha.setOnClickListener(this);
        btnreservaTarde.setOnClickListener(this);
        btnreservaNoite.setOnClickListener(this);
        btnchicomendesManha.setOnClickListener(this);
        btnchicomendesTarde.setOnClickListener(this);
        btnchicomendesNoite.setOnClickListener(this);
        btnamericasManha.setOnClickListener(this);
        btnamericasTarde.setOnClickListener(this);
        btnamericasNoite.setOnClickListener(this);
        btnsecretoManha.setOnClickListener(this);
        btnsecretoTarde.setOnClickListener(this);
        btnsecretoNoite.setOnClickListener(this);
        btnPontalManha.setOnClickListener(this);
        btnPontalTarde.setOnClickListener(this);
        btnPontalNoite.setOnClickListener(this);
        proxTela.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnAmericasManha:
                String passeio = shoppingamericas.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAmericasTarde:
                passeio = shoppingamericas.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAmericasNoite:
                passeio = shoppingamericas.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReservaManha:
                passeio = reserva.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReservaTarde:
                passeio = reserva.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnReservaNoite:
                passeio = reserva.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnChicoMendesManha:
                passeio = chicomendes.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnChicoMendesTarde:
                passeio = chicomendes.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnChicoMendesNoite:
                passeio = chicomendes.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSecretoManha:
                passeio = praiasecreto.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSecretoVespertino:
                passeio = praiasecreto.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSecretoNoite:
                passeio = praiasecreto.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPontalManha:
                passeio = pedrapontal.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPontalTarde:
                passeio = pedrapontal.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPontalNoite:
                passeio = pedrapontal.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.proxTela:
                Intent roteiro = new Intent (this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
        }
    }
}