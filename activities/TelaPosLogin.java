package com.example.a4travel.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;

public class TelaPosLogin extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = TelaPosLogin.this;

    private Button btnCriarRoteiro, btnMostrarRoteiro;

    private DatabaseHelper databaseHelper;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaposlogin);
        getSupportActionBar().hide();
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        btnCriarRoteiro = (Button) findViewById(R.id.btnCriarRoteiro);
        btnMostrarRoteiro = (Button) findViewById(R.id.btnMostrarRoteiro);
    }

    private void initListeners(){
        btnCriarRoteiro.setOnClickListener(this);
        btnMostrarRoteiro.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
    }

    @Override
    public void onClick(View view) {

    }
}
