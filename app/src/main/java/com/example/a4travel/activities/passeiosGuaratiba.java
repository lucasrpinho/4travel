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

public class passeiosGuaratiba extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosGuaratiba.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnBrisa, btnMagdalena, btnArca;
    private TextView brisa, magdalena, arca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeios_guaratiba);
        getSupportActionBar().hide();

        initViews();
        initObjects();
        initListeners();
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(this);
    }

    private void initViews() {
        brisa = (TextView) findViewById(R.id.brisa);
        magdalena = (TextView) findViewById(R.id.magdalena);
        arca = (TextView) findViewById(R.id.arcanoah);

        btnArca = (ImageButton) findViewById(R.id.btnArca);
        btnBrisa = (ImageButton) findViewById(R.id.btnBrisa);
        btnMagdalena = (ImageButton) findViewById(R.id.btnMagdalena);
    }

    private void initListeners(){
        btnMagdalena.setOnClickListener(this);
        btnBrisa.setOnClickListener(this);
        btnArca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnMagdalena:
                String passeio = magdalena.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro = new Intent(this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
            case R.id.btnBrisa:
                passeio = brisa.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro2 = new Intent(this, RoteiroAdapter.class);
                roteiro2.putExtra("EMAIL", email);
                startActivity(roteiro2);
                break;
            case R.id.btnArca:
                passeio = arca.getText().toString().trim();
                databaseHelper.addPasseio(email, passeio);
                Intent roteiro3 = new Intent(this, RoteiroAdapter.class);
                roteiro3.putExtra("EMAIL", email);
                startActivity(roteiro3);
                break;
        }
    }
}