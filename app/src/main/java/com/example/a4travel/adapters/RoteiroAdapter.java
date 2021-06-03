package com.example.a4travel.adapters;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.model.User;

public class RoteiroAdapter extends AppCompatActivity {

    private TextView txtHotel, txtGastronomia, txtPasseio, nomeRoteiro, txtRegião;
    private DatabaseHelper databaseHelper;
    private User user;
    private AppCompatActivity activity = RoteiroAdapter.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roteiro_adapter);
        initViews();
        initObjects();
        String email = getIntent().getStringExtra("EMAIL");
        nomeRoteiro.setText(email);
        mostrarRoteiro();
    }

    public void mostrarRoteiro(){
        String email = getIntent().getStringExtra("EMAIL");
        String hotel = databaseHelper.getHotel(email);
        txtHotel.setText(hotel);
        String gastronomia = databaseHelper.getGastronomia(email);
        txtGastronomia.setText(gastronomia);
        String passeio = databaseHelper.getPasseio(email);
        txtPasseio.setText(passeio);
        String regiao = databaseHelper.getRegiao(email);
        txtRegião.setText(regiao);
    }

    private void initViews(){
        txtGastronomia = (TextView) findViewById(R.id.txtGastronomia);
        txtHotel = (TextView) findViewById(R.id.txtHotel);
        txtPasseio = (TextView) findViewById(R.id.txtPasseio);
        nomeRoteiro = (TextView) findViewById(R.id.nomeRoteiro);
        txtRegião = (TextView) findViewById(R.id.txtRegião);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(this);
        user = new User();
    }
}