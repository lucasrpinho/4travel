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
import com.example.a4travel.model.roteiro;

public class hoteisRecreio extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnRamada, btnCDesign, btnAtlantico, btnKsbeach;
    private TextView ramada, cdesign, ksbeach, atlanticosul;
    private final AppCompatActivity activity = hoteisRecreio.this;
    private DatabaseHelper databaseHelper;
    private roteiro Roteiro;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteis_recreio);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        btnAtlantico = (ImageButton) findViewById(R.id.btnAtlantico);
        btnCDesign = (ImageButton) findViewById(R.id.btnCDesign);
        btnKsbeach = (ImageButton) findViewById(R.id.btnKsbeach);
        btnRamada = (ImageButton) findViewById(R.id.btnRamada);
        atlanticosul = (TextView) findViewById(R.id.atlanticosul);
        ramada = (TextView) findViewById(R.id.ramada);
        cdesign = (TextView) findViewById(R.id.cdesign);
        ksbeach = (TextView) findViewById(R.id.ksbeach);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
    }

    private void initListeners() {
        btnRamada.setOnClickListener(this);
        btnKsbeach.setOnClickListener(this);
        btnCDesign.setOnClickListener(this);
        btnAtlantico.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRamada:
                String opcao = getIntent().getStringExtra("OPÇÃO");

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaRecreio.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    roteiro.putExtra("EMAIL", email);
                    user.setHotel(ramada.getText().toString());
                    databaseHelper.addHotel(user);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnAtlantico:
                opcao = getIntent().getStringExtra("OPÇÃO");
                user.setHotel(atlanticosul.getText().toString().trim());

                databaseHelper.addRoteiro(user);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaRecreio.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnCDesign:
                opcao = getIntent().getStringExtra("OPÇÃO");
                user.setHotel(cdesign.getText().toString().trim());

                databaseHelper.addRoteiro(user);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaRecreio.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("EMAIL", email);
                    gastronomia.putExtra("OPÇÃO", "completo");
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

            case R.id.btnKsbeach:
                opcao = getIntent().getStringExtra("OPÇÃO");
                user.setHotel(ksbeach.getText().toString().trim());

                databaseHelper.addRoteiro(user);
                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaRecreio.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    gastronomia.putExtra("OPÇÃO", "completo");
                    gastronomia.putExtra("EMAIL", email);
                    startActivity(gastronomia);
                    break;
                }
                if (opcao.equals("hotel")){
                    Intent roteiro = new Intent(this, RoteiroAdapter.class);
                    String email = getIntent().getStringExtra("EMAIL");
                    roteiro.putExtra("EMAIL", email);
                    startActivity(roteiro);
                    break;
                }

        }
    }
}