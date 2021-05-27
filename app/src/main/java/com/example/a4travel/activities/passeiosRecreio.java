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
import com.example.a4travel.model.User;

public class passeiosRecreio extends AppCompatActivity implements View.OnClickListener {
        private final AppCompatActivity activity = passeiosRecreio.this;
        private TextView praiasecreto, shoppingamericas, reserva, chicomendes, pedrapontal;
        private ImageButton btnpedrapontal, btnreserva, btnamericas, btnsecreto, btnchicomendes;
        private DatabaseHelper databaseHelper;
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

        btnamericas = (ImageButton) findViewById(R.id.btnAmericas);
        btnchicomendes = (ImageButton) findViewById(R.id.btnChicoMendes);
        btnpedrapontal = (ImageButton) findViewById(R.id.btnPedraPontal);
        btnsecreto = (ImageButton) findViewById(R.id.btnPraiaSecreto);
        btnreserva = (ImageButton) findViewById(R.id.btnReserva);
    }

    private void initListeners(){
        btnreserva.setOnClickListener(this);
        btnchicomendes.setOnClickListener(this);
        btnamericas.setOnClickListener(this);
        btnsecreto.setOnClickListener(this);
        btnpedrapontal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnAmericas:
                user.setPasseio(shoppingamericas.getText().toString().trim());
                databaseHelper.addPasseio(user);
                Intent roteiro = new Intent(this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
            case R.id.btnReserva:
                user.setPasseio(reserva.getText().toString().trim());
                databaseHelper.addPasseio(user);
                Intent roteiro2 = new Intent(this, RoteiroAdapter.class);
                roteiro2.putExtra("EMAIL", email);
                startActivity(roteiro2);
                break;
            case R.id.btnChicoMendes:
                user.setPasseio(chicomendes.getText().toString().trim());
                databaseHelper.addPasseio(user);
                Intent roteiro3 = new Intent(this, RoteiroAdapter.class);
                roteiro3.putExtra("EMAIL", email);
                startActivity(roteiro3);
                break;
            case R.id.btnPraiaSecreto:
                user.setPasseio(praiasecreto.getText().toString().trim());
                databaseHelper.addPasseio(user);
                Intent roteiro4 = new Intent(this, RoteiroAdapter.class);
                roteiro4.putExtra("EMAIL", email);
                startActivity(roteiro4);
                break;
            case R.id.btnPedraPontal:
                user.setPasseio(pedrapontal.getText().toString().trim());
                databaseHelper.addPasseio(user);
                Intent roteiro5 = new Intent(this, RoteiroAdapter.class);
                roteiro5.putExtra("EMAIL", email);
                startActivity(roteiro5);
                break;
        }
    }
}