package com.example.a4travel.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.activities.Regioes;
import com.example.a4travel.model.User;

public class RoteiroAdapter extends AppCompatActivity implements View.OnClickListener {

    private TextView txtHotel, txtGastronomia, txtGastronomia2, TxtGastronomia3, txtPasseio, txtPasseio2, txtPasseio3, nomeRoteiro, txtRegião;
    private Button btnRefazer, btnLimpar;
    private DatabaseHelper databaseHelper;
    private User user;
    private AppCompatActivity activity = RoteiroAdapter.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roteiro_adapter);
        initViews();
        initObjects();
        initListeners();
        String email = getIntent().getStringExtra("EMAIL");
        nomeRoteiro.setText(email);
        mostrarRoteiro();
    }

    public void mostrarRoteiro(){
        String email = getIntent().getStringExtra("EMAIL");
        String hotel = databaseHelper.getHotel(email);
        txtHotel.setText(hotel);
        String gastronomia = databaseHelper.getGastronomia_matinal(email);
        txtGastronomia.setText(gastronomia);
        String gastronomia2 = databaseHelper.getGastronomia_almoço(email);
        txtGastronomia2.setText(gastronomia2);
        String gastronomia3 = databaseHelper.getGastronomia_noturna(email);
        TxtGastronomia3.setText(gastronomia3);
        String passeio = databaseHelper.getPasseioMatinal(email);
        txtPasseio.setText(passeio);
        String passeio2 = databaseHelper.getPasseioVespertino(email);
        txtPasseio2.setText(passeio2);
        String passeio3 = databaseHelper.getPasseioNoturno(email);
        txtPasseio3.setText(passeio3);
        String regiao = databaseHelper.getRegiao(email);
        txtRegião.setText(regiao);
    }

    private void initViews(){
        txtHotel = (TextView) findViewById(R.id.txtHotel);
        txtGastronomia = (TextView) findViewById(R.id.txtGastronomia);
        txtGastronomia2 = (TextView) findViewById(R.id.txtGastronomia2);
        TxtGastronomia3 = (TextView) findViewById(R.id.txtGastronomia3);
        txtPasseio = (TextView) findViewById(R.id.txtPasseio);
        txtPasseio2 = (TextView) findViewById(R.id.txtPasseio2);
        txtPasseio3 = (TextView) findViewById(R.id.txtPasseio3);
        nomeRoteiro = (TextView) findViewById(R.id.nomeRoteiro);
        txtRegião = (TextView) findViewById(R.id.txtRegião);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnRefazer = (Button) findViewById(R.id.btnRefazer);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(this);
        user = new User();
    }

    private void initListeners(){
        btnRefazer.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnLimpar:
                txtHotel.setText("");
                txtRegião.setText("");
                txtPasseio.setText("");
                txtPasseio2.setText("");
                txtPasseio3.setText("");
                txtGastronomia.setText("");
                txtGastronomia2.setText("");
                TxtGastronomia3.setText("");
                databaseHelper.limparRoteiro(email);
            break;
            case R.id.btnRefazer:
                Intent regioes = new Intent(this, Regioes.class);
                databaseHelper.limparRoteiro(email);
                regioes.putExtra("EMAIL", email);
                startActivity(regioes);
            break;
        }
    }
}