package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.example.a4travel.adapters.RoteiroAdapter;

public class passeiosBarra extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity activity = passeiosBarra.this;
    private DatabaseHelper databaseHelper;
    private ImageButton btnBarraManha, btnBarraTarde, btnBarraNoite, btnMarapendiManha, btnMarapendiTarde, btnPierManha, btnPierTarde, btnPierNoite, btnQuebramarManha, btnQuebramarTarde, btnQuebramarNoite;
    private TextView quebramar, pier, reservamarapendi, praiadabarra;
    private Button nextScreen3;

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


        btnPierManha = (ImageButton) findViewById(R.id.btnPierManha);
        btnPierTarde = (ImageButton) findViewById(R.id.btnPierTarde);
        btnPierNoite = (ImageButton) findViewById(R.id.btnPierNoite);
        btnMarapendiManha = (ImageButton) findViewById(R.id.btnMarapendiManha);
        btnMarapendiTarde = (ImageButton) findViewById(R.id.btnMarapendiTarde);
        btnBarraManha = (ImageButton) findViewById(R.id.btnBarraManha);
        btnBarraTarde = (ImageButton) findViewById(R.id.btnBarraTarde);
        btnBarraNoite = (ImageButton) findViewById(R.id.btnBarraNoite);
        btnQuebramarManha = (ImageButton) findViewById(R.id.btnQuebramarManha);
        btnQuebramarTarde = (ImageButton) findViewById(R.id.btnQuebramarTarde);
        btnQuebramarNoite = (ImageButton) findViewById(R.id.btnQuebraMarNoite);
        nextScreen3 = (Button) findViewById(R.id.nextScreen3);
    }

    private void initListeners(){
        btnQuebramarManha.setOnClickListener(this);
        btnQuebramarTarde.setOnClickListener(this);
        btnQuebramarNoite.setOnClickListener(this);
        btnPierNoite.setOnClickListener(this);
        btnPierTarde.setOnClickListener(this);
        btnPierManha.setOnClickListener(this);
        btnMarapendiManha.setOnClickListener(this);
        btnMarapendiTarde.setOnClickListener(this);
        btnBarraNoite.setOnClickListener(this);
        btnBarraTarde.setOnClickListener(this);
        btnBarraManha.setOnClickListener(this);
        nextScreen3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String email = getIntent().getStringExtra("EMAIL");
        switch (view.getId()){
            case R.id.btnQuebramarManha:
                String passeio = quebramar.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuebramarTarde:
                passeio = quebramar.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnQuebraMarNoite:
                passeio = quebramar.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBarraManha:
                passeio = praiadabarra.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBarraNoite:
                passeio = praiadabarra.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBarraTarde:
                passeio = praiadabarra.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMarapendiManha:
                passeio = reservamarapendi.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMarapendiTarde:
                passeio = pier.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPierManha:
                passeio = pier.getText().toString().trim();
                databaseHelper.addPasseioMatinal(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPierTarde:
                passeio = pier.getText().toString().trim();
                databaseHelper.addPasseioVespertino(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPierNoite:
                passeio = pier.getText().toString().trim();
                databaseHelper.addPasseioNoturno(email, passeio);
                Toast.makeText(this, "Opção adicionada ao roteiro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextScreen3:
                Intent roteiro = new Intent (this, RoteiroAdapter.class);
                roteiro.putExtra("EMAIL", email);
                startActivity(roteiro);
                break;
        }
    }
}