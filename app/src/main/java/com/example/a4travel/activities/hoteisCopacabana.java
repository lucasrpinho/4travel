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

public class hoteisCopacabana extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = hoteisCopacabana.this;
    private ImageButton btnpalace, btnselina, btnatlantico, btnorla;
    private TextView palace, selina, atlantico, orla;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteis_copacabana);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        btnatlantico = (ImageButton) findViewById(R.id.btnAtlanticoCopa);
        btnorla = (ImageButton) findViewById(R.id.btnOrla);
        btnselina = (ImageButton) findViewById(R.id.btnSelina);
        btnpalace = (ImageButton) findViewById(R.id.btnPalace);
        atlantico = (TextView) findViewById(R.id.atlantico);
        selina = (TextView) findViewById(R.id.selina);
        palace = (TextView) findViewById(R.id.palace);
        orla = (TextView) findViewById(R.id.orlahotel);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnpalace.setOnClickListener(this);
        btnselina.setOnClickListener(this);
        btnorla.setOnClickListener(this);
        btnatlantico.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnAtlanticoCopa:
                String opcao = getIntent().getStringExtra("OPÇÃO");
                String hotel = atlantico.getText().toString().trim();
                databaseHelper.addHotel(email, hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaCopa.class);
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                }
                break;

            case R.id.btnOrla:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = orla.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaCopa.class);
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                }
                break;

            case R.id.btnPalace:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = palace.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaCopa.class);
                    email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                }
                break;

            case R.id.btnSelina:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = selina.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);
                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaCopa.class);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    gastronomia.putExtra("EMAIL", email);
                    startActivity(gastronomia);
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                }
                break;
        }
    }
}