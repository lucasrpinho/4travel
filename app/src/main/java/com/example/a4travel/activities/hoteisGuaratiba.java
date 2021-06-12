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

public class hoteisGuaratiba extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnParquehotel, btnLerelais, btnHodelua;
    private TextView hodelua, parquehotel, lerelais;
    private final AppCompatActivity activity = hoteisGuaratiba.this;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteis_guaratiba);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        btnHodelua = (ImageButton) findViewById(R.id.btnHodelua);
        btnLerelais = (ImageButton) findViewById(R.id.btnLerelais);
        btnParquehotel = (ImageButton) findViewById(R.id.btnParquehotel);
        hodelua = (TextView) findViewById(R.id.hodelua);
        parquehotel = (TextView) findViewById(R.id.parquehotel);
        lerelais = (TextView) findViewById(R.id.lerelais);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnParquehotel.setOnClickListener(this);
        btnLerelais.setOnClickListener(this);
        btnHodelua.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnParquehotel:
                String opcao = getIntent().getStringExtra("OPÇÃO");
                String hotel = parquehotel.getText().toString().trim();
                String email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addHotel(email, hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaGuaratiba.class);
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnLerelais:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = lerelais.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaGuaratiba.class);
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnHodelua:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = hodelua.getText().toString().trim();
                email = getIntent().getStringExtra("EMAIL");
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaGuaratiba.class);
                    email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    email = getIntent().getStringExtra("EMAIL");
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }
        }
    }
}