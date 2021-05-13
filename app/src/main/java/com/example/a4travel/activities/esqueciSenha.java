package com.example.a4travel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4travel.R;
import com.example.a4travel.SQL.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class esqueciSenha extends AppCompatActivity {

    TextInputEditText email_Senha;
    Button btnResetar;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        email_Senha = (TextInputEditText) findViewById(R.id.email_Senha);
        btnResetar = (Button) findViewById(R.id.btnResetar);
        databaseHelper = new DatabaseHelper(this);

        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailReset = email_Senha.getText().toString();
                Boolean checarEmail = databaseHelper.checkUser(emailReset);
                if (checarEmail == true) {
                    Intent intent = new Intent(getApplicationContext(), ResetarSenha.class);
                    intent.putExtra("email", emailReset);
                    startActivity(intent);
                } else {
                    Toast.makeText(esqueciSenha.this, "E-mail não existe", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}