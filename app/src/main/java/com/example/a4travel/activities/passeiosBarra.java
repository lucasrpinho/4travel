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

public class passeiosBarra extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosBarra.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnPraiadabarra, btnReservamarapendi, btnPier, btnQuebramar;
    private TextView quebramar, pier, reservamarapendi, praiadabarra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeios_barra);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initViews() {
        praiadabarra = (TextView) findViewById(R.id.praiadabarra);
        pier = (TextView) findViewById(R.id.pier);
        reservamarapendi = (TextView) findViewById(R.id.reservamarapendi);
        quebramar = (TextView) findViewById(R.id.quebramar);


        btnPier = (ImageButton) findViewById(R.id.btnPier);
        btnReservamarapendi = (ImageButton) findViewById(R.id.btnReservaMarapendi);
        btnPraiadabarra = (ImageButton) findViewById(R.id.btnPraiadaBarra);
        btnQuebramar = (ImageButton) findViewById(R.id.btnQuebramar);
    }

    private void initListeners(){
        btnQuebramar.setOnClickListener(this);
        btnPraiadabarra.setOnClickListener(this);
        btnReservamarapendi.setOnClickListener(this);
        btnPier.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnQuebramar:
                String passeio = quebramar.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro = new Intent(this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
            case R.id.btnPraiadaBarra:
                passeio = praiadabarra.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro2 = new Intent(this, RoteiroAdapter.class);
                roteiro2.putExtra("EMAIL", email);
                startActivity(roteiro2);
                break;
            case R.id.btnReservaMarapendi:
                passeio = reservamarapendi.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro3 = new Intent(this, RoteiroAdapter.class);
                roteiro3.putExtra("EMAIL", email);
                startActivity(roteiro3);
                break;
            case R.id.btnPier:
                passeio = pier.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro4 = new Intent(this, RoteiroAdapter.class);
                roteiro4.putExtra("EMAIL", email);
                startActivity(roteiro4);
                break;
        }
    }
}