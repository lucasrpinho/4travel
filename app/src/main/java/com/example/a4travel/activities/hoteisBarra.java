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

public class hoteisBarra extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = hoteisBarra.this;
    private ImageButton btnWindsor, btnLaghetto, btnLsh, btnRadisson;
    private TextView windsor, laghetto, lsh, radisson;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteis_barra);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initViews(){
        btnLaghetto = (ImageButton) findViewById(R.id.btnLaghetto);
        btnLsh = (ImageButton) findViewById(R.id.btnLsh);
        btnWindsor = (ImageButton) findViewById(R.id.btnWindsor);
        btnRadisson = (ImageButton) findViewById(R.id.btnRadisson);
        lsh = (TextView) findViewById(R.id.lsh);
        laghetto = (TextView) findViewById(R.id.laghetto);
        radisson = (TextView) findViewById(R.id.radisson);
        windsor = (TextView) findViewById(R.id.windsor);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(this);
    }

    private void initListeners() {
        btnRadisson.setOnClickListener(this);
        btnWindsor.setOnClickListener(this);
        btnLsh.setOnClickListener(this);
        btnLaghetto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnWindsor:
                String opcao = getIntent().getStringExtra("OPÇÃO");
                String hotel = windsor.getText().toString().trim();
                databaseHelper.addHotel(email, hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaBarra.class);
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

            case R.id.btnLaghetto:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = laghetto.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaBarra.class);
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

            case R.id.btnLsh:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = lsh.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);

                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaBarra.class);
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

            case R.id.btnRadisson:
                opcao = getIntent().getStringExtra("OPÇÃO");
                hotel = radisson.getText().toString().trim();
                databaseHelper.addHotel(email ,hotel);
                if (opcao.equals("completo")){
                    Intent gastronomia = new Intent(this, gastronomiaBarra.class);
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